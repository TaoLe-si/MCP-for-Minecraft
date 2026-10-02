#!/usr/bin/env node
import assert from 'node:assert/strict';
import { spawn } from 'node:child_process';
import { createInterface } from 'node:readline';
import path from 'node:path';
import { fileURLToPath } from 'node:url';

const TOOLS_DIR = path.dirname(fileURLToPath(import.meta.url));
const PROJECT_DIR = path.resolve(TOOLS_DIR, '..');
const SERVER_PATH = path.join(TOOLS_DIR, 'mcmcp.mjs');
const server = spawn(process.execPath, [SERVER_PATH], {
  cwd: PROJECT_DIR,
  env: process.env,
  stdio: ['pipe', 'pipe', 'pipe'],
  windowsHide: true,
});

let nextId = 1;
let stdoutBuffer = '';
let stderrTail = '';
let clientAttempted = false;
const pending = new Map();

function failPending(error) {
  for (const request of pending.values()) {
    clearTimeout(request.timer);
    request.reject(error);
  }
  pending.clear();
}

server.stdout.setEncoding('utf8');
server.stdout.on('data', (chunk) => {
  stdoutBuffer += chunk;
  while (true) {
    const newline = stdoutBuffer.indexOf('\n');
    if (newline < 0) break;
    const line = stdoutBuffer.slice(0, newline).trim();
    stdoutBuffer = stdoutBuffer.slice(newline + 1);
    if (!line) continue;
    let message;
    try {
      message = JSON.parse(line);
    } catch {
      failPending(new Error(`MCP server wrote non-JSON data to stdout: ${line.slice(0, 300)}`));
      continue;
    }
    if (message.id === undefined) continue;
    const request = pending.get(message.id);
    if (!request) continue;
    pending.delete(message.id);
    clearTimeout(request.timer);
    if (message.error) request.reject(new Error(message.error.message ?? JSON.stringify(message.error)));
    else request.resolve(message.result);
  }
});
server.stderr.setEncoding('utf8');
server.stderr.on('data', (chunk) => {
  stderrTail = `${stderrTail}${chunk}`.slice(-12000);
});
server.once('error', (error) => failPending(error));
server.once('exit', (code, signal) => {
  failPending(new Error(`MCP server exited (${code ?? signal}). ${stderrTail.slice(-4000)}`));
});

function rpc(method, params = {}, timeoutMs = 300000) {
  if (server.exitCode !== null) return Promise.reject(new Error('MCP server is not running.'));
  const id = nextId++;
  return new Promise((resolve, reject) => {
    const timer = setTimeout(() => {
      pending.delete(id);
      reject(new Error(`Timed out waiting for MCP method ${method}.`));
    }, timeoutMs);
    pending.set(id, { resolve, reject, timer });
    server.stdin.write(`${JSON.stringify({ jsonrpc: '2.0', id, method, params })}\n`, (error) => {
      if (!error) return;
      const request = pending.get(id);
      if (!request) return;
      pending.delete(id);
      clearTimeout(request.timer);
      reject(error);
    });
  });
}

function notify(method, params = {}) {
  server.stdin.write(`${JSON.stringify({ jsonrpc: '2.0', method, params })}\n`);
}

async function callTool(name, args = {}, timeoutMs = 300000) {
  const response = await rpc('tools/call', { name, arguments: args }, timeoutMs);
  if (response?.isError) {
    const details = response.content?.map((item) => item.text ?? '').join('\n') ?? 'unknown tool error';
    throw new Error(`${name} failed: ${details}`);
  }
  const text = response?.content?.find((item) => item.type === 'text')?.text;
  if (!text) throw new Error(`${name} returned no text result.`);
  try {
    return JSON.parse(text);
  } catch {
    return text;
  }
}

const sleep = (ms) => new Promise((resolve) => setTimeout(resolve, ms));

async function waitForBuild() {
  const started = await callTool('mc_build', { task: 'jar' });
  assert.equal(started.started, true, 'bridge JAR build did not start');
  let result;
  for (let i = 0; i < 600; i++) {
    await sleep(1000);
    result = await callTool('mc_build_status');
    if (result.status !== 'running') break;
  }
  assert.equal(result?.status, 'succeeded', `bridge JAR build did not succeed: ${JSON.stringify(result)}`);
  return result;
}

async function waitForTestResult(beforeLog) {
  for (let i = 0; i < 90; i++) {
    await sleep(1000);
    const logs = await callTool('mc_client_logs', { tailLines: 1000 });
    const current = logs.latestLog ?? '';
    const delta = current.startsWith(beforeLog) ? current.slice(beforeLog.length) : current;
    if (/\b(?:test|gametest).{0,120}\bfailed\b|\b[1-9]\d* tests? failed\b|\bAll (?:\d+ )?required tests? failed\b|\b[A-Za-z0-9_.:-]+ failed!\s*\(\d+(?:\.\d+)?ms\)/i.test(delta)) {
      throw new Error(`GameTest reported a failure:\n${delta.slice(-5000)}`);
    }
    if (/\btest\b.{0,160}\bpassed\b|\b[1-9]\d* tests? (?:have )?passed\b|\ball tests passed\b|\bAll (?:\d+ )?required tests? passed\b|\b[A-Za-z0-9_.:-]+ passed!\s*\(\d+(?:\.\d+)?ms\)/i.test(delta)) {
      return delta;
    }
  }
  const logs = await callTool('mc_client_logs', { tailLines: 200 });
  throw new Error(`GameTest did not produce a pass line before timeout. Latest log:\n${logs.latestLog ?? '(empty)'}`);
}

let failure = null;
try {
  const initialized = await rpc('initialize', {
    protocolVersion: '2025-11-25',
    capabilities: {},
    clientInfo: { name: 'mcmcp-e2e', version: '1.0.0' },
  });
  assert.ok(initialized?.serverInfo?.name, 'MCP initialize did not return server information');
  notify('notifications/initialized');

  const listed = await rpc('tools/list');
  const toolNames = new Set((listed?.tools ?? []).map((tool) => tool.name));
  for (const name of ['mc_build', 'mc_start_client', 'mc_runtime_info', 'mc_registry_list', 'mc_player_action', 'mc_game_test']) {
    assert.ok(toolNames.has(name), `MCP tool is missing: ${name}`);
  }
  console.log('PASS MCP initialize and required-tool discovery');

  await waitForBuild();
  console.log('PASS Gradle bridge JAR build');

  clientAttempted = true;
  const started = await callTool('mc_start_client', { timeoutSeconds: 90 }, 120000);
  assert.equal(started.ready, true, `client bridge did not become ready: ${JSON.stringify(started)}`);
  assert.equal(started.worldReady, true, `validation world did not become ready: ${JSON.stringify(started)}`);

  const runtime = await callTool('mc_runtime_info');
  assert.equal(runtime.minecraftVersion, '1.21.1', 'unexpected Minecraft version');
  assert.ok(runtime.loadedMods?.some((mod) => mod.id === 'mcmcp'), 'bridge mod was not loaded');
  assert.ok(runtime.localIntegratedServer, 'client is not in a local integrated world');
  console.log(`PASS Minecraft ${runtime.minecraftVersion} client and local validation world`);

  const blocks = await callTool('mc_registry_list', { registry: 'blocks', namespace: 'mcmcp_e2e', limit: 20 });
  const items = await callTool('mc_registry_list', { registry: 'items', namespace: 'mcmcp_e2e', limit: 20 });
  assert.ok(blocks.entries?.includes('mcmcp_e2e:probe_block'), 'sample block is missing from the live registry');
  assert.ok(items.entries?.includes('mcmcp_e2e:probe_block'), 'sample block item is missing from the live registry');
  assert.ok(items.entries?.includes('mcmcp_e2e:probe_wand'), 'sample wand is missing from the live registry');
  const entities = await callTool('mc_registry_list', { registry: 'entities', namespace: 'minecraft', limit: 1 });
  assert.ok(entities.total > 0, 'entity-type registry query returned no built-in entities');
  console.log('PASS live block, item and entity-type registry reads');

  let movement = null;
  let lastState = await callTool('mc_player_state');
  for (const yaw of [0, 90, 180, 270]) {
    await callTool('mc_player_action', { action: 'look', yaw, pitch: 0 });
    const initial = await callTool('mc_player_state');
    await callTool('mc_player_action', { action: 'hold', control: 'forward', ticks: 40 });
    for (let i = 0; i < 12; i++) {
      await sleep(500);
      lastState = await callTool('mc_player_state');
      const horizontalDistance = Math.hypot(lastState.x - initial.x, lastState.z - initial.z);
      if (horizontalDistance > 0.25) {
        movement = { yaw, horizontalDistance, initial, final: lastState };
        break;
      }
    }
    if (movement) break;
    await callTool('mc_player_action', { action: 'release_all' });
  }
  assert.ok(movement, `player did not move through client input APIs; final state: ${JSON.stringify(lastState)}`);
  await callTool('mc_player_action', { action: 'release_all' });
  console.log(`PASS direct in-game player control at yaw ${movement.yaw}; horizontal movement ${movement.horizontalDistance.toFixed(2)} blocks`);

  const status = await callTool('mc_client_status');
  const tests = await callTool('mc_game_test', { selector: 'list' });
  if (status.mode === 'neoforge-runClient') {
    assert.equal(tests.available, true, `development GameTests were not registered: ${JSON.stringify(tests)}`);
    assert.ok(tests.registeredTestIds?.includes('mcmcp:bridgesmoke'),
      `bridge smoke GameTest was not discovered: ${JSON.stringify(tests)}`);
    const baseline = await callTool('mc_client_logs', { tailLines: 1000 });
    const run = await callTool('mc_game_test', { selector: 'mcmcp:bridgesmoke' });
    assert.equal(run.accepted, true, `GameTest run was rejected: ${JSON.stringify(run)}`);
    const resultLog = await waitForTestResult(baseline.latestLog ?? '');
    console.log(`PASS sample NeoForge GameTest\n${resultLog.split(/\r?\n/).filter((line) => /passed/i.test(line)).slice(-2).join('\n')}`);
  } else {
    assert.equal(tests.available, false, 'installed production client unexpectedly reported GameTests');
    console.log('SKIP GameTest execution: installed production profiles do not register NeoForge GameTests.');
  }
} catch (error) {
  failure = error;
} finally {
  if (clientAttempted && server.exitCode === null) {
    try { await callTool('mc_player_action', { action: 'release_all' }, 10000); } catch { /* client may not have reached a world */ }
    try {
      const stopped = await callTool('mc_stop_client', {}, 45000);
      if (!stopped.stopped || stopped.graceful === false) {
        failure ??= new Error(`Client did not stop cleanly: ${JSON.stringify(stopped)}`);
      } else {
        console.log('PASS orderly client shutdown');
      }
    } catch (error) {
      failure ??= new Error(`Could not stop the test client cleanly: ${error.message}`);
    }
  }
  if (server.exitCode === null) {
    server.kill();
    await Promise.race([
      new Promise((resolve) => server.once('exit', resolve)),
      sleep(3000),
    ]);
  }
}

if (failure) {
  console.error(`FAIL ${failure.stack ?? failure.message}`);
  if (stderrTail) console.error(`MCP server stderr:\n${stderrTail}`);
  process.exitCode = 1;
} else {
  console.log('E2E validation completed.');
}
