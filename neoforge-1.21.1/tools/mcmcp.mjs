#!/usr/bin/env node
import { createHash, randomBytes } from 'node:crypto';
import { spawn, spawnSync } from 'node:child_process';
import { access, copyFile, cp, mkdir, readdir, readFile, stat, writeFile } from 'node:fs/promises';
import net from 'node:net';
import path from 'node:path';
import { fileURLToPath } from 'node:url';

const SERVER_DIR = path.dirname(fileURLToPath(import.meta.url));
const PROJECT_DIR = path.resolve(SERVER_DIR, '..');
const MOD_DIR = path.join(PROJECT_DIR, 'mod');
const VALIDATION_DIR = path.join(PROJECT_DIR, '.validation');
const VALIDATION_GAME_DIR = path.join(VALIDATION_DIR, 'game-dir');
const VALIDATION_MODS_DIR = path.join(PROJECT_DIR, 'test-mods');
const LOG_LIMIT_CHARS = 256 * 1024;
const MAX_TAIL_LINES = 1000;
const PROTOCOL_VERSION = '2026-07-28';
const SERVER_INFO = { name: 'minecraft-neoforge-mcp', version: '0.1.0' };
const SUPPORTED_PROTOCOLS = new Set([
  '2024-11-05', '2025-03-26', '2025-06-18', '2025-11-25', PROTOCOL_VERSION,
]);

let session = null;
let activeBuild = null;
let lastBuild = null;
let recentProcessOutput = '';
let legacyProtocolVersion = null;

const text = (value) => ({ type: 'text', text: typeof value === 'string' ? value : JSON.stringify(value, null, 2) });
const jsonSchema = (properties = {}, required = []) => ({
  type: 'object', properties, required, additionalProperties: false,
});
const stringSchema = (description, extra = {}) => ({ type: 'string', description, ...extra });
const integerSchema = (description, minimum, maximum, extra = {}) => ({
  type: 'integer', minimum, maximum, description, ...extra,
});

const toolDefinitions = [
  {
    name: 'mc_start_client',
    description: '若已配置 MC_MCP_SOURCE_GAME_DIR 和版本 ID，则从该安装的精确 NeoForge 21.1.235 版本元数据启动客户端，把 mods/config 复制进仓库隔离 gameDir 并自动创建新测试世界；否则启动本仓库 runClient。不会接受工具参数中的任意路径或命令。',
    inputSchema: jsonSchema({
      timeoutSeconds: integerSchema('等待桥接启动的秒数；范围 10–240。', 10, 240, { default: 120 }),
    }),
    annotations: { readOnlyHint: false, destructiveHint: false, idempotentHint: false, openWorldHint: false },
  },
  {
    name: 'mc_stop_client',
    description: '停止由本 MCP 服务启动的开发客户端及其 Gradle 子进程。',
    inputSchema: jsonSchema(),
    annotations: { readOnlyHint: false, destructiveHint: true, idempotentHint: true, openWorldHint: false },
  },
  {
    name: 'mc_client_status',
    description: '读取本地开发客户端进程与 NeoForge 客户端桥接状态。',
    inputSchema: jsonSchema(),
    annotations: { readOnlyHint: true, destructiveHint: false, idempotentHint: true, openWorldHint: false },
  },
  {
    name: 'mc_client_logs',
    description: '读取固定开发目录中的最新 Minecraft 日志、最近进程输出与最新崩溃报告。',
    inputSchema: jsonSchema({ tailLines: integerSchema('每种日志最多返回的末尾行数。', 20, MAX_TAIL_LINES, { default: 200 }) }),
    annotations: { readOnlyHint: true, destructiveHint: false, idempotentHint: true, openWorldHint: false },
  },
  {
    name: 'mc_build',
    description: '在固定项目目录后台启动受限的 Gradle 验证任务。允许 compileJava、jar 或 build；通过 mc_build_status 获取结果，不接受任意 Gradle 参数。',
    inputSchema: jsonSchema({ task: { type: 'string', enum: ['compileJava', 'jar', 'build'], description: '固定 allowlist 中的 Gradle 任务。' } }, ['task']),
    annotations: { readOnlyHint: false, destructiveHint: false, idempotentHint: true, openWorldHint: false },
  },
  {
    name: 'mc_build_status',
    description: '读取受限 Gradle 构建任务的运行状态、结果和输出。',
    inputSchema: jsonSchema(),
    annotations: { readOnlyHint: true, destructiveHint: false, idempotentHint: true, openWorldHint: false },
  },
  {
    name: 'mc_cancel_build',
    description: '停止本 MCP 服务启动的 Gradle build/compileJava 进程树。',
    inputSchema: jsonSchema(),
    annotations: { readOnlyHint: false, destructiveHint: true, idempotentHint: true, openWorldHint: false },
  },
  {
    name: 'mc_runtime_info',
    description: '读取 Minecraft/NeoForge 客户端版本、加载的模组、本地世界和当前玩家信息。',
    inputSchema: jsonSchema(),
    annotations: { readOnlyHint: true, destructiveHint: false, idempotentHint: true, openWorldHint: false },
  },
  {
    name: 'mc_registry_list',
    description: '分页读取已注册的方块、物品或生物实体类型 ID；可按命名空间和 ID 前缀筛选。',
    inputSchema: jsonSchema({
      registry: { type: 'string', enum: ['blocks', 'items', 'entities'] },
      namespace: stringSchema('可选注册命名空间，例如 minecraft 或目标模组 ID。'),
      prefix: stringSchema('可选完整 ID 前缀，例如 example:machine_。'),
      offset: integerSchema('分页偏移。', 0, 2147483647, { default: 0 }),
      limit: integerSchema('单页条数，最多 200。', 1, 200, { default: 100 }),
    }, ['registry']),
    annotations: { readOnlyHint: true, destructiveHint: false, idempotentHint: true, openWorldHint: false },
  },
  {
    name: 'mc_player_state',
    description: '读取实例玩家坐标、视角、生命/饥饿、模式、背包和准星目标。',
    inputSchema: jsonSchema(),
    annotations: { readOnlyHint: true, destructiveHint: false, idempotentHint: true, openWorldHint: false },
  },
  {
    name: 'mc_player_action',
    description: '通过 Minecraft 客户端 API 操作当前实例玩家：有限 tick 的移动/跳跃/潜行/冲刺/攻击/使用，转向、选槽或发送普通聊天。不能发送斜杠命令。',
    inputSchema: jsonSchema({
      action: { type: 'string', enum: ['hold', 'release_all', 'look', 'select_slot', 'chat'] },
      control: { type: 'string', enum: ['forward', 'back', 'left', 'right', 'jump', 'sneak', 'sprint', 'attack', 'use', 'interact', 'inventory', 'drop', 'swap_offhand', 'pick_block'] },
      controls: { type: 'array', items: { type: 'string', enum: ['forward', 'back', 'left', 'right', 'jump', 'sneak', 'sprint', 'attack', 'use', 'interact', 'inventory', 'drop', 'swap_offhand', 'pick_block'] }, minItems: 1, maxItems: 4 },
      ticks: integerSchema('hold 时长，最多 200 个游戏 tick。', 1, 200, { default: 1 }),
      yaw: { type: 'number', description: '绝对水平角度。' },
      pitch: { type: 'number', minimum: -90, maximum: 90, description: '俯仰角。' },
      slot: integerSchema('快捷栏槽位。', 0, 8),
      message: stringSchema('普通聊天内容；不能以 / 开头，最多 256 字符。', { maxLength: 256 }),
    }, ['action']),
    annotations: { readOnlyHint: false, destructiveHint: true, idempotentHint: false, openWorldHint: false },
  },
  {
    name: 'mc_block_inspect',
    description: '读取玩家 128 格范围内已加载方块的注册 ID、状态属性和方块实体标记；不加载区块。',
    inputSchema: jsonSchema({
      x: integerSchema('方块 X 坐标。', -30000000, 30000000),
      y: integerSchema('方块 Y 坐标。', -2048, 2048),
      z: integerSchema('方块 Z 坐标。', -30000000, 30000000),
    }, ['x', 'y', 'z']),
    annotations: { readOnlyHint: true, destructiveHint: false, idempotentHint: true, openWorldHint: false },
  },
  {
    name: 'mc_interact_block',
    description: '让实例玩家用当前主手物品通过 MultiPlayerGameMode.useItemOn 与本地测试世界中的指定方块交互；不注入鼠标事件，不加载未加载区块。',
    inputSchema: jsonSchema({
      x: integerSchema('目标方块 X 坐标。', -30000000, 30000000),
      y: integerSchema('目标方块 Y 坐标。', -2048, 2048),
      z: integerSchema('目标方块 Z 坐标。', -30000000, 30000000),
      face: { type: 'string', enum: ['down', 'up', 'north', 'south', 'west', 'east'], default: 'up' },
    }, ['x', 'y', 'z']),
    annotations: { readOnlyHint: false, destructiveHint: true, idempotentHint: false, openWorldHint: false },
  },
  {
    name: 'mc_inventory_state',
    description: '读取当前游戏菜单的容器 ID、屏幕类型和所有槽位。可通过玩家 action 按键打开背包。',
    inputSchema: jsonSchema(),
    annotations: { readOnlyHint: true, destructiveHint: false, idempotentHint: true, openWorldHint: false },
  },
  {
    name: 'mc_inventory_click',
    description: '在本地单人测试世界通过 Minecraft 容器 API 点击当前活动菜单槽位。可能移动、丢弃或交换物品。',
    inputSchema: jsonSchema({
      slot: integerSchema('活动菜单中的槽位索引；-999 表示点击菜单外部。', -999, 255),
      button: integerSchema('鼠标按键编号，通常为 0 或 1。', 0, 8, { default: 0 }),
      clickType: { type: 'string', enum: ['PICKUP', 'QUICK_MOVE', 'SWAP', 'THROW', 'PICKUP_ALL'], default: 'PICKUP' },
    }, ['slot']),
    annotations: { readOnlyHint: false, destructiveHint: true, idempotentHint: false, openWorldHint: false },
  },
  {
    name: 'mc_player_give_item',
    description: '在本地单人测试世界向实例玩家发放一个已注册物品；仅接受注册表 ID 和 1–64 数量。会修改测试世界背包。',
    inputSchema: jsonSchema({
      itemId: stringSchema('已注册的命名空间物品 ID，例如 minecraft:stone。', { pattern: '^[a-z0-9_.-]+:[a-z0-9_./-]+$' }),
      count: integerSchema('数量。', 1, 64, { default: 1 }),
    }, ['itemId']),
    annotations: { readOnlyHint: false, destructiveHint: true, idempotentHint: false, openWorldHint: false },
  },
  {
    name: 'mc_world_inspect',
    description: '读取当前维度指定半径内的附近实体列表和准星目标。',
    inputSchema: jsonSchema({
      radius: { type: 'number', minimum: 1, maximum: 64, default: 16 },
      limit: integerSchema('最多返回实体数。', 1, 100, { default: 50 }),
    }),
    annotations: { readOnlyHint: true, destructiveHint: false, idempotentHint: true, openWorldHint: false },
  },
  {
    name: 'mc_world_setup',
    description: '在当前本地单人集成测试世界应用一个固定预设（时间、天气或全体玩家模式）。会修改测试世界状态。',
    inputSchema: jsonSchema({ preset: { type: 'string', enum: ['time_day', 'time_night', 'weather_clear', 'weather_rain', 'creative', 'survival'] } }, ['preset']),
    annotations: { readOnlyHint: false, destructiveHint: true, idempotentHint: true, openWorldHint: false },
  },
    {
      name: 'mc_game_test',
      description: '查询注册的 NeoForge GameTest，或在支持 GameTest 的开发客户端本地测试世界运行全部/指定测试。安装版正式客户端通常不会注册测试；运行后用 mc_client_logs 核对 pass/fail。',
    inputSchema: jsonSchema({ selector: stringSchema('list、all 或形如 example:test_case 的 GameTest ID。', { default: 'all', pattern: '^(list|all|[a-z0-9_.-]+:[a-z0-9_./-]+)$' }) }),
    annotations: { readOnlyHint: false, destructiveHint: true, idempotentHint: false, openWorldHint: false },
  },
  {
    name: 'mc_screenshot',
    description: '使用 Minecraft 渲染目标 API 捕获客户端画面；作为 MCP image 返回，并写入隔离 gameDir 的 screenshots 目录。',
    inputSchema: jsonSchema(),
    annotations: { readOnlyHint: false, destructiveHint: false, idempotentHint: false, openWorldHint: false },
  },
];

function appendOutput(chunk) {
  recentProcessOutput += chunk.toString();
  if (recentProcessOutput.length > LOG_LIMIT_CHARS) recentProcessOutput = recentProcessOutput.slice(-LOG_LIMIT_CHARS);
}

function processAlive(child) {
  return Boolean(child && child.exitCode === null && child.signalCode === null);
}

async function platformGradleCommand(task, extraEnv = {}) {
  const wrapperName = process.platform === 'win32' ? 'gradlew.bat' : 'gradlew';
  const wrapperPath = path.join(MOD_DIR, wrapperName);
  const runClientFlags = task === 'runClient' ? ['--no-configuration-cache'] : [];
  const runClientFlagText = task === 'runClient' ? '--no-configuration-cache ' : '';
  const args = ['--no-daemon', ...runClientFlags, '--console=plain', task];
  const env = {
    ...process.env,
    GRADLE_USER_HOME: process.env.MC_MCP_GRADLE_USER_HOME || path.join(VALIDATION_DIR, 'gradle-home'),
    ...extraEnv,
  };

  const javaExecutable = process.env.MC_MCP_JAVA?.trim();
  if (javaExecutable && path.isAbsolute(javaExecutable)) {
    const javaHome = path.dirname(path.dirname(javaExecutable));
    env.JAVA_HOME = javaHome;
    env.Path = `${path.join(javaHome, 'bin')}${path.delimiter}${env.Path ?? ''}`;
  }

  const configuredHome = process.env.MC_MCP_GRADLE_HOME?.trim();
  if (configuredHome) {
    const executable = path.join(configuredHome, 'bin', process.platform === 'win32' ? 'gradle.bat' : 'gradle');
    await access(executable);
    if (process.platform === 'win32') {
      const relativeExecutable = path.relative(MOD_DIR, executable);
      if (!path.isAbsolute(relativeExecutable) && !relativeExecutable.startsWith(`..${path.sep}`)) {
        return { command: process.env.ComSpec || 'cmd.exe', args: ['/d', '/s', '/c', `${relativeExecutable} --no-daemon ${runClientFlagText}--console=plain ${task}`], options: { cwd: MOD_DIR, env } };
      }
      const command = `& '${executable.replace(/'/g, "''")}' --no-daemon ${runClientFlagText}--console=plain ${task}`;
      return { command: 'powershell.exe', args: ['-NoProfile', '-NonInteractive', '-Command', command], options: { cwd: MOD_DIR, env } };
    }
    return { command: executable, args, options: { cwd: MOD_DIR, env } };
  }

  try {
    await access(wrapperPath);
    return process.platform === 'win32'
      ? { command: process.env.ComSpec || 'cmd.exe', args: ['/d', '/s', '/c', `${wrapperName} --no-daemon ${runClientFlagText}--console=plain ${task}`], options: { cwd: MOD_DIR, env } }
      : { command: wrapperPath, args, options: { cwd: MOD_DIR, env } };
  } catch {
    return fallbackGradle(task, env);
  }
}

function fallbackGradle(task, env) {
  const runClientFlags = task === 'runClient' ? ['--no-configuration-cache'] : [];
  const runClientFlagText = task === 'runClient' ? '--no-configuration-cache ' : '';
  const args = ['--no-daemon', ...runClientFlags, '--console=plain', task];
  return process.platform === 'win32'
    ? { command: process.env.ComSpec || 'cmd.exe', args: ['/d', '/s', '/c', `gradle --no-daemon ${runClientFlagText}--console=plain ${task}`], options: { cwd: MOD_DIR, env } }
    : { command: 'gradle', args, options: { cwd: MOD_DIR, env } };
}

function installedProfileFromEnvironment() {
  const sourceGameDir = process.env.MC_MCP_SOURCE_GAME_DIR?.trim();
  const versionId = process.env.MC_MCP_VERSION_ID?.trim();
  if (!sourceGameDir && !versionId) return null;
  if (!sourceGameDir || !versionId || !/^[A-Za-z0-9_.+-]{1,96}$/.test(versionId)) {
    throw new Error('设置已安装客户端时，必须同时提供有效的 MC_MCP_SOURCE_GAME_DIR 与 MC_MCP_VERSION_ID。');
  }
  return {
    sourceGameDir: path.resolve(sourceGameDir),
    versionId,
    gameDir: VALIDATION_GAME_DIR,
  };
}

function safeChildPath(parent, child) {
  const resolved = path.resolve(parent, child);
  const relative = path.relative(path.resolve(parent), resolved);
  if (relative === '..' || relative.startsWith(`..${path.sep}`) || path.isAbsolute(relative)) {
    throw new Error('Resolved path escaped its fixed validation directory.');
  }
  return resolved;
}

async function pathExists(target) {
  try { await access(target); return true; } catch { return false; }
}

async function copyDirectoryContents(source, destination, { jarsOnly = false, overwrite = false } = {}) {
  if (!(await pathExists(source))) return [];
  await mkdir(destination, { recursive: true });
  const copied = [];
  for (const entry of await readdir(source, { withFileTypes: true })) {
    const from = path.join(source, entry.name);
    const to = safeChildPath(destination, entry.name);
    if (entry.isDirectory()) {
      copied.push(...await copyDirectoryContents(from, to, { jarsOnly, overwrite }));
    } else if (entry.isFile() && (!jarsOnly || entry.name.toLowerCase().endsWith('.jar'))) {
      if (overwrite || !(await pathExists(to))) {
        await copyFile(from, to);
        copied.push(path.relative(destination, to));
      }
    }
  }
  return copied;
}

async function copyValidationMods(destination, reservedNames = new Set()) {
  if (!(await pathExists(VALIDATION_MODS_DIR))) return [];
  await mkdir(destination, { recursive: true });
  const copied = [];
  for (const entry of await readdir(VALIDATION_MODS_DIR, { withFileTypes: true })) {
    if (!entry.isFile() || !entry.name.toLowerCase().endsWith('.jar')) continue;
    if (reservedNames.has(entry.name.toLowerCase())) {
      throw new Error(`Validation mod ${entry.name} conflicts with a mod already copied into the isolated client.`);
    }
    const source = safeChildPath(VALIDATION_MODS_DIR, entry.name);
    const target = safeChildPath(destination, entry.name);
    await copyFile(source, target);
    copied.push(entry.name);
  }
  return copied;
}

function launchRuleMatches(rule) {
  const osRule = rule.os ?? {};
  if (osRule.name && osRule.name !== (process.platform === 'win32' ? 'windows' : process.platform)) return false;
  if (osRule.arch) {
    const aliases = { x64: 'amd64', arm64: 'aarch64' };
    const candidates = [process.arch, aliases[process.arch]].filter(Boolean);
    try {
      if (!candidates.some((arch) => new RegExp(osRule.arch).test(arch))) return false;
    } catch {
      return false;
    }
  }
  if (osRule.version) {
    try {
      const release = process.getSystemVersion?.() ?? '';
      if (!new RegExp(osRule.version).test(release)) return false;
    } catch {
      return false;
    }
  }
  const features = {
    has_custom_resolution: true,
    is_demo_user: false,
    has_quick_plays_support: false,
    is_quick_play_singleplayer: false,
    is_quick_play_multiplayer: false,
    is_quick_play_realms: false,
  };
  return Object.entries(rule.features ?? {}).every(([key, expected]) => features[key] === expected);
}

function rulesAllow(rules) {
  if (!Array.isArray(rules) || rules.length === 0) return true;
  let allowed = false;
  for (const rule of rules) {
    if (launchRuleMatches(rule)) allowed = rule.action === 'allow';
  }
  return allowed;
}

async function prepareInstalledProfile(profile) {
  const versionDir = path.join(profile.sourceGameDir, 'versions', profile.versionId);
  const versionJsonPath = path.join(versionDir, `${profile.versionId}.json`);
  const versionJar = path.join(versionDir, `${profile.versionId}.jar`);
  const libraryDir = path.join(profile.sourceGameDir, 'libraries');
  const assetsDir = path.join(profile.sourceGameDir, 'assets');
  const versionJson = JSON.parse(await readFile(versionJsonPath, 'utf8'));
  if (versionJson.id !== profile.versionId || !versionJson.mainClass) {
    throw new Error('The selected installed version JSON is malformed or does not match its folder name.');
  }
  if (Number(versionJson.javaVersion?.majorVersion) !== 21) {
    throw new Error('The installed version JSON does not require Java 21 as expected.');
  }
  const libraryNames = (versionJson.libraries ?? []).map((library) => library.name ?? '');
  const gameArguments = JSON.stringify(versionJson.arguments?.game ?? []);
  if (profile.versionId !== '1.21.1-NeoForge_21.1.235'
      || !gameArguments.includes('21.1.235')
      || !libraryNames.some((name) => name.startsWith('net.neoforged.fancymodloader:loader:4.0.42'))) {
    throw new Error('The installed game profile is not the required Minecraft 1.21.1 / NeoForge 21.1.235 instance.');
  }
  const neoForgeLibraries = path.join(libraryDir, 'net', 'neoforged', 'neoforge', '21.1.235');
  for (const fileName of ['neoforge-21.1.235-client.jar', 'neoforge-21.1.235-universal.jar']) {
    if (!(await pathExists(path.join(neoForgeLibraries, fileName)))) {
      throw new Error(`The installed NeoForge 21.1.235 artifact is missing: ${fileName}`);
    }
  }
  if (!(await pathExists(versionJar))) throw new Error(`Missing exact installed client jar: ${versionJar}`);
  if (!(await pathExists(path.join(assetsDir, 'indexes', `${versionJson.assetIndex?.id}.json`)))) {
    throw new Error('The installed version asset index is missing.');
  }

  const classpathEntries = [];
  const classpathPaths = new Set();
  for (const library of versionJson.libraries ?? []) {
    if (!rulesAllow(library.rules)) continue;
    const artifactPath = library.downloads?.artifact?.path;
    if (!artifactPath) continue;
    const artifact = safeChildPath(libraryDir, artifactPath);
    if (!(await pathExists(artifact))) throw new Error(`Missing Windows runtime library: ${artifactPath}`);
    const normalizedPath = process.platform === 'win32' ? artifact.toLowerCase() : artifact;
    if (classpathPaths.has(normalizedPath)) continue;
    classpathPaths.add(normalizedPath);
    classpathEntries.push(artifact);
  }
  classpathEntries.push(versionJar);

  await mkdir(profile.gameDir, { recursive: true });
  const modsDir = path.join(profile.gameDir, 'mods');
  const copiedMods = await copyDirectoryContents(path.join(profile.sourceGameDir, 'mods'), modsDir, { jarsOnly: true, overwrite: true });
  const copiedConfigs = [];
  for (const directory of ['config', 'defaultconfigs']) {
    copiedConfigs.push(...await copyDirectoryContents(
      path.join(profile.sourceGameDir, directory), path.join(profile.gameDir, directory), { overwrite: false }));
  }

  const markerPath = path.join(profile.gameDir, '.mcmcp-input-copy.json');
  if (!(await pathExists(markerPath))) {
    await writeFile(markerPath, JSON.stringify({
      sourceVersionId: profile.versionId,
      copiedModJars: copiedMods,
      copiedConfigFiles: copiedConfigs,
      savesCopied: false,
    }, null, 2), 'utf8');
  }

  const buildDir = path.join(MOD_DIR, 'build', 'libs');
  const bridgeJar = (await readdir(buildDir)).filter((name) => name.endsWith('.jar')
    && !name.endsWith('-sources.jar') && !name.endsWith('-javadoc.jar'))
    .sort().at(-1);
  if (!bridgeJar) throw new Error('The MCP bridge mod is not built. Run mc_build with task=build, then start the client.');
  await mkdir(modsDir, { recursive: true });
  const bridgeJarPath = path.join(buildDir, bridgeJar);
  const bridgeTarget = safeChildPath(modsDir, bridgeJar);
  await copyFile(bridgeJarPath, bridgeTarget);
  const reservedModNames = new Set([...copiedMods.map((name) => path.basename(name)), bridgeJar]
    .map((name) => name.toLowerCase()));
  const validationMods = await copyValidationMods(modsDir, reservedModNames);

  const worldName = `mcmcp-validation-${Date.now().toString(36)}-${randomBytes(3).toString('hex')}`;
  const nativeSource = path.join(versionDir, 'natives-windows-x86_64');
  if (!(await pathExists(nativeSource))) throw new Error('The exact installed version has no extracted Windows native libraries.');
  const nativeDir = safeChildPath(profile.gameDir, path.join('.mcmcp', 'natives', worldName));
  await cp(nativeSource, nativeDir, { recursive: true, force: false });

  const launcherValues = {
    auth_player_name: 'McpValidation',
    version_name: profile.versionId,
    game_directory: profile.gameDir,
    assets_root: assetsDir,
    assets_index_name: String(versionJson.assetIndex.id),
    auth_uuid: createHash('md5').update('OfflinePlayer:McpValidation').digest('hex').replace(/(.{8})(.{4})(.{4})(.{4})(.{12})/, '$1-$2-$3-$4-$5'),
    auth_access_token: '0',
    clientid: '0',
    auth_xuid: '0',
    user_type: 'legacy',
    version_type: 'release',
    natives_directory: nativeDir,
    launcher_name: 'MinecraftMCP',
    launcher_version: SERVER_INFO.version,
    classpath: classpathEntries.join(path.delimiter),
    library_directory: libraryDir,
    classpath_separator: path.delimiter,
    resolution_width: '1280',
    resolution_height: '720',
    quickPlayPath: '',
    quickPlaySingleplayer: '',
    quickPlayMultiplayer: '',
    quickPlayRealms: '',
  };
  const expandValue = (value) => String(value).replace(/\$\{([^}]+)\}/g, (_, name) => {
    if (!(name in launcherValues)) throw new Error(`Unsupported installed-launcher placeholder: ${name}`);
    return launcherValues[name];
  });
  const collectArguments = (entries) => (entries ?? []).flatMap((entry) => {
    if (typeof entry === 'string') return [expandValue(entry)];
    if (!entry || !rulesAllow(entry.rules)) return [];
    const values = Array.isArray(entry.value) ? entry.value : [entry.value];
    return values.filter((value) => typeof value === 'string').map(expandValue);
  });
  const args = [
    ...collectArguments(versionJson.arguments?.jvm),
    versionJson.mainClass,
    ...collectArguments(versionJson.arguments?.game),
  ];
    const mainClassIndex = args.indexOf(versionJson.mainClass);
    if (mainClassIndex < 0) throw new Error('The installed version launch arguments do not contain the expected main class.');
    return { ...profile, versionDir, versionJson, classpathEntries, args, nativeDir, worldName, bridgeJar, validationMods };
}

async function installedLaunch(gameProfile, extraEnv) {
  const configuredJava = process.env.MC_MCP_JAVA?.trim();
  const javaHome = process.env.JAVA_HOME;
  const javaPath = configuredJava || (javaHome
    ? path.join(javaHome, 'bin', process.platform === 'win32' ? 'java.exe' : 'java')
    : 'java');
  if (path.isAbsolute(javaPath) && !(await pathExists(javaPath))) {
    throw new Error(`Configured Java executable was not found: ${javaPath}`);
  }
  const javaVersion = spawnSync(javaPath, ['-version'], { encoding: 'utf8', windowsHide: true });
  const javaVersionOutput = `${javaVersion.stdout ?? ''}\n${javaVersion.stderr ?? ''}`;
  const javaMajor = javaVersionOutput.match(/version\s+"?(\d+)/i)?.[1];
  if (javaVersion.error || javaVersion.status !== 0 || javaMajor !== '21') {
    throw new Error(`The exact installed game requires Java 21; the configured Java probe failed. Output: ${javaVersionOutput.trim().slice(-600)}`);
  }
  const env = {
    ...process.env,
    ...extraEnv,
    MC_MCP_AUTOWORLD: 'true',
    MC_MCP_WORLD_NAME: gameProfile.worldName,
  };
  return {
    command: javaPath,
    args: gameProfile.args,
    options: { cwd: gameProfile.gameDir, env },
    gameDir: gameProfile.gameDir,
    mode: 'installed-isolated',
    versionId: gameProfile.versionId,
    worldName: gameProfile.worldName,
  };
}

async function reserveLoopbackPort() {
  const server = net.createServer();
  await new Promise((resolve, reject) => {
    server.once('error', reject);
    server.listen(0, '127.0.0.1', resolve);
  });
  const port = server.address().port;
  await new Promise((resolve) => server.close(resolve));
  return port;
}

async function launchProcess(task, extraEnv = {}) {
  const launch = await platformGradleCommand(task, extraEnv);
  return launchCommand(launch, 'Gradle');
}

async function launchCommand(launch, processName) {
  let child;
  try {
    child = spawn(launch.command, launch.args, {
      ...launch.options,
      stdio: ['ignore', 'pipe', 'pipe'],
      windowsHide: true,
      detached: process.platform !== 'win32',
    });
  } catch (error) {
    throw new Error(`Could not start ${processName}: ${error.message}`);
  }
  child.stdout.on('data', appendOutput);
  child.stderr.on('data', appendOutput);
  child.once('error', (error) => appendOutput(`\n[launcher] ${error.message}\n`));
  return child;
}

function sleep(ms) {
  return new Promise((resolve) => setTimeout(resolve, ms));
}

async function probeBridge(currentSession, timeoutMs = 1500) {
  const abort = new AbortController();
  const timeout = setTimeout(() => abort.abort(), timeoutMs);
  try {
    const response = await fetch(`http://127.0.0.1:${currentSession.port}/health`, {
      headers: { Authorization: `Bearer ${currentSession.token}` },
      signal: abort.signal,
    });
    currentSession.lastProbeStatus = response.status;
    currentSession.lastProbeError = null;
    if (!response.ok) return null;
    return await response.json();
  } catch (error) {
    currentSession.lastProbeStatus = null;
    currentSession.lastProbeError = error.cause?.code ?? error.name ?? 'unknown';
    return null;
  } finally {
    clearTimeout(timeout);
  }
}

async function requestBridge(operation, args = {}, timeoutMs = 15000) {
  if (!session) throw new Error('开发客户端尚未由本 MCP 服务启动。先调用 mc_start_client。');
  const abort = new AbortController();
  const timeout = setTimeout(() => abort.abort(), timeoutMs);
  try {
    const response = await fetch(`http://127.0.0.1:${session.port}/rpc`, {
      method: 'POST',
      headers: {
        Authorization: `Bearer ${session.token}`,
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ op: operation, args }),
      signal: abort.signal,
    });
    const payload = await response.json();
    if (!response.ok || payload.error) throw new Error(payload.message || `Game bridge returned HTTP ${response.status}.`);
    return payload;
  } catch (error) {
    if (error.name === 'AbortError') throw new Error('游戏内桥接请求超时。检查客户端是否仍在运行，并查看 mc_client_logs。');
    if (error.cause?.code === 'ECONNREFUSED') throw new Error('客户端桥接尚未就绪。打开测试世界后重试。');
    throw error;
  } finally {
    clearTimeout(timeout);
  }
}

async function startClient(args) {
  if (processAlive(session?.child)) {
    const bridge = await probeBridge(session);
    return {
      started: true,
      alreadyRunning: true,
      ready: Boolean(bridge?.ready),
      worldReady: Boolean(bridge?.inWorld && bridge?.localIntegratedServer),
      pid: session.child.pid,
      mode: session.mode,
      versionId: session.versionId,
      worldName: session.worldName,
      bridge,
    };
  }
  if (activeBuild) throw new Error('当前有 Gradle build 在运行；等待它完成后再启动 runClient。');

  const port = await reserveLoopbackPort();
  const token = randomBytes(32).toString('hex');
  const defaultWorldName = `mcmcp-validation-${Date.now().toString(36)}-${randomBytes(3).toString('hex')}`;
  recentProcessOutput = '';
  const bridgeEnv = {
    MC_MCP_HOST: '127.0.0.1',
    MC_MCP_PORT: String(port),
    MC_MCP_TOKEN: token,
    MC_MCP_AUTOWORLD: 'true',
    MC_MCP_WORLD_NAME: defaultWorldName,
  };
  const configuredProfile = installedProfileFromEnvironment();
  let launch;
  let child;
  if (configuredProfile) {
    const gameProfile = await prepareInstalledProfile(configuredProfile);
    launch = await installedLaunch(gameProfile, bridgeEnv);
    child = await launchCommand(launch, 'Minecraft Java 21 client');
  } else {
    launch = {
      gameDir: path.join(MOD_DIR, 'run', 'client'),
      mode: 'neoforge-runClient',
      versionId: null,
      worldName: defaultWorldName,
    };
    child = await launchProcess('runClient', bridgeEnv);
  }
  session = {
    child,
    port,
    token,
    startedAt: new Date().toISOString(),
    gameDir: launch.gameDir,
    mode: launch.mode,
    versionId: launch.versionId,
    worldName: launch.worldName,
  };
  const timeoutMs = Math.min(240, Math.max(10, Number(args.timeoutSeconds ?? 120))) * 1000;
  const deadline = Date.now() + timeoutMs;
  let health = null;
  while (Date.now() < deadline && processAlive(child)) {
    health = await probeBridge(session, 900);
    const bridgeReady = Boolean(health?.ready);
    const worldReady = Boolean(health?.inWorld && health?.localIntegratedServer);
    if (bridgeReady && worldReady) {
      return {
        started: true,
        ready: true,
        worldReady,
        pid: child.pid,
        mode: session.mode,
        versionId: session.versionId,
        worldName: session.worldName,
        gameDir: path.relative(PROJECT_DIR, session.gameDir),
        bridge: health,
      };
    }
    await sleep(400);
  }
  const tail = recentProcessOutput.split(/\r?\n/).filter(Boolean).slice(-30).join('\n');
  if (!processAlive(child)) {
    throw new Error(`Minecraft 客户端已退出，退出码 ${child.exitCode ?? child.signalCode}。最近输出：\n${tail || '(无进程输出)'}`);
  }
  return {
    started: true,
    ready: Boolean(health?.ready),
    worldReady: Boolean(health?.inWorld && health?.localIntegratedServer),
    pid: child.pid,
    mode: session.mode,
    versionId: session.versionId,
    worldName: session.worldName,
    gameDir: path.relative(PROJECT_DIR, session.gameDir),
    timeoutSeconds: Math.round(timeoutMs / 1000),
    message: '客户端仍在运行，但 MCP 桥接或隔离测试世界尚未就绪。',
    bridge: health,
    bridgeProbeStatus: session.lastProbeStatus,
    bridgeProbeError: session.lastProbeError,
    recentOutput: tail,
  };
}

async function stopClient() {
  if (!processAlive(session?.child)) return { stopped: true, wasRunning: false };
  const child = session.child;
  const exitPromise = new Promise((resolve) => {
    if (!processAlive(child)) resolve(true);
    else child.once('exit', () => resolve(true));
  });
  let graceful = false;
  try {
    const response = await requestBridge('shutdown', {}, 5000);
    graceful = response.accepted === true;
  } catch {
    // If the bridge is not ready, fall back to terminating the child process below.
  }
  if (graceful) {
    await Promise.race([exitPromise, sleep(30000)]);
  }
  if (!processAlive(child)) return { stopped: true, pid: child.pid, graceful: true, exitCode: child.exitCode };
  if (process.platform === 'win32') {
    await new Promise((resolve) => {
      const killer = spawn('taskkill.exe', ['/PID', String(child.pid), '/T', '/F'], { stdio: 'ignore', windowsHide: true });
      killer.once('error', resolve);
      killer.once('exit', resolve);
    });
  } else {
    try { process.kill(-child.pid, 'SIGTERM'); } catch { try { child.kill('SIGTERM'); } catch { /* already stopped */ } }
    await Promise.race([new Promise((resolve) => child.once('exit', resolve)), sleep(5000)]);
    if (processAlive(child)) {
      try { process.kill(-child.pid, 'SIGKILL'); } catch { try { child.kill('SIGKILL'); } catch { /* already stopped */ } }
    }
  }
  return { stopped: !processAlive(child), pid: child.pid, graceful, exitCode: child.exitCode, signal: child.signalCode };
}

async function killProcessTree(child) {
  if (!processAlive(child)) return;
  if (process.platform === 'win32') {
    await new Promise((resolve) => {
      const killer = spawn('taskkill.exe', ['/PID', String(child.pid), '/T', '/F'], { stdio: 'ignore', windowsHide: true });
      killer.once('error', resolve);
      killer.once('exit', resolve);
    });
  } else {
    try { process.kill(-child.pid, 'SIGTERM'); } catch { try { child.kill('SIGTERM'); } catch { /* already stopped */ } }
    await Promise.race([new Promise((resolve) => child.once('exit', resolve)), sleep(4000)]);
    if (processAlive(child)) {
      try { process.kill(-child.pid, 'SIGKILL'); } catch { try { child.kill('SIGKILL'); } catch { /* already stopped */ } }
    }
  }
}

async function runBuild(task) {
  if (!['compileJava', 'jar', 'build'].includes(task)) throw new Error('仅允许 compileJava、jar 或 build。');
  if (processAlive(session?.child)) throw new Error('开发客户端正在运行；停止客户端后再运行构建任务。');
  if (activeBuild) throw new Error('已有 Gradle 构建任务正在运行。');
  recentProcessOutput = '';
  const child = await launchProcess(task);
  const job = {
    task,
    pid: child.pid,
    startedAt: new Date().toISOString(),
    status: 'running',
    child,
    timedOut: false,
    timer: null,
  };
  activeBuild = job;
  lastBuild = job;
  job.timer = setTimeout(() => {
    if (job.status !== 'running') return;
    job.timedOut = true;
    void killProcessTree(child);
  }, 30 * 60 * 1000);
  job.timer.unref?.();
  child.once('error', (error) => {
    job.status = 'failed_to_start';
    job.error = error.message;
    job.completedAt = new Date().toISOString();
    clearTimeout(job.timer);
    if (activeBuild === job) activeBuild = null;
  });
  child.once('exit', (code, signal) => {
    job.status = job.timedOut ? 'timed_out' : (job.cancelRequested ? 'cancelled' : (code === 0 ? 'succeeded' : 'failed'));
    job.exitCode = code;
    job.signal = signal;
    job.completedAt = new Date().toISOString();
    clearTimeout(job.timer);
    if (activeBuild === job) activeBuild = null;
  });
  return { started: true, task, pid: child.pid, status: 'running', timeoutMinutes: 30 };
}

function buildStatus() {
  if (!lastBuild) return { status: 'not_started' };
  const { child, timer, ...job } = lastBuild;
  return { ...job, outputTail: recentProcessOutput.split(/\r?\n/).filter(Boolean).slice(-100).join('\n') };
}

async function cancelBuild() {
  if (!activeBuild) return { cancelled: false, status: lastBuild?.status ?? 'not_started' };
  const job = activeBuild;
  job.cancelRequested = true;
  await killProcessTree(job.child);
  job.status = job.timedOut ? 'timed_out' : 'cancelled';
  job.completedAt ??= new Date().toISOString();
  clearTimeout(job.timer);
  activeBuild = null;
  return { cancelled: true, task: job.task, pid: job.pid, status: job.status };
}

async function tailFile(filePath, maxLines) {
  try {
    const content = await readFile(filePath, 'utf8');
    return content.split(/\r?\n/).filter(Boolean).slice(-maxLines).join('\n');
  } catch {
    return null;
  }
}

async function latestCrashReport(maxLines) {
  const crashDir = path.join(currentGameDir(), 'crash-reports');
  try {
    const entries = await readdir(crashDir, { withFileTypes: true });
    const files = await Promise.all(entries.filter((entry) => entry.isFile() && entry.name.endsWith('.txt')).map(async (entry) => {
      const filePath = path.join(crashDir, entry.name);
      return { filePath, mtimeMs: (await stat(filePath)).mtimeMs };
    }));
    files.sort((left, right) => right.mtimeMs - left.mtimeMs);
    if (!files.length) return null;
    return { file: path.basename(files[0].filePath), content: await tailFile(files[0].filePath, maxLines) };
  } catch {
    return null;
  }
}

function currentGameDir() {
  if (session?.gameDir) return session.gameDir;
  return installedProfileFromEnvironment()?.gameDir ?? path.join(MOD_DIR, 'run', 'client');
}

async function clientLogs(args) {
  const tailLines = Math.min(MAX_TAIL_LINES, Math.max(20, Number(args.tailLines ?? 200)));
  const gameDir = currentGameDir();
  return {
    processOutput: recentProcessOutput.split(/\r?\n/).filter(Boolean).slice(-tailLines).join('\n'),
    gameDir: path.relative(PROJECT_DIR, gameDir),
    latestLog: await tailFile(path.join(gameDir, 'logs', 'latest.log'), tailLines),
    latestCrashReport: await latestCrashReport(tailLines),
  };
}

function toolResult(value, image = null) {
  const content = [text(value)];
  if (image) content.push(image);
  return { content, isError: false };
}

async function callTool(name, args) {
  switch (name) {
    case 'mc_start_client': return toolResult(await startClient(args));
    case 'mc_stop_client': return toolResult(await stopClient());
    case 'mc_client_status': {
      const running = processAlive(session?.child);
      return toolResult({
        startedByMcp: Boolean(session),
        running,
        pid: session?.child?.pid ?? null,
        startedAt: session?.startedAt ?? null,
        exitCode: session?.child?.exitCode ?? null,
        signal: session?.child?.signalCode ?? null,
        mode: session?.mode ?? null,
        versionId: session?.versionId ?? null,
        worldName: session?.worldName ?? null,
        gameDir: session?.gameDir ? path.relative(PROJECT_DIR, session.gameDir) : null,
        bridge: session ? await probeBridge(session) : null,
        bridgeProbeStatus: session?.lastProbeStatus ?? null,
        bridgeProbeError: session?.lastProbeError ?? null,
      });
    }
    case 'mc_client_logs': return toolResult(await clientLogs(args));
    case 'mc_build': return toolResult(await runBuild(args.task));
    case 'mc_build_status': return toolResult(buildStatus());
    case 'mc_cancel_build': return toolResult(await cancelBuild());
    case 'mc_runtime_info': return toolResult(await requestBridge('runtime_info'));
    case 'mc_registry_list': return toolResult(await requestBridge('registry_list', args));
    case 'mc_player_state': return toolResult(await requestBridge('player_state'));
    case 'mc_player_action': return toolResult(await requestBridge('player_action', args));
    case 'mc_inventory_state': return toolResult(await requestBridge('inventory_state'));
    case 'mc_inventory_click': return toolResult(await requestBridge('inventory_click', args));
    case 'mc_player_give_item': return toolResult(await requestBridge('give_item', args));
    case 'mc_interact_block': return toolResult(await requestBridge('interact_block', args));
    case 'mc_block_inspect': return toolResult(await requestBridge('block_at', args));
    case 'mc_world_inspect': return toolResult(await requestBridge('world_inspect', args));
    case 'mc_world_setup': return toolResult(await requestBridge('world_setup', args));
    case 'mc_game_test': return toolResult(await requestBridge('game_test', args));
    case 'mc_screenshot': {
      const result = await requestBridge('screenshot', {}, 20000);
      const { imageBase64, mimeType, ...metadata } = result;
      const filename = `mcmcp-${new Date().toISOString().replace(/[:.]/g, '-')}.png`;
      const screenshotPath = safeChildPath(path.join(session.gameDir, 'screenshots'), filename);
      await mkdir(path.dirname(screenshotPath), { recursive: true });
      await writeFile(screenshotPath, Buffer.from(imageBase64, 'base64'));
      return toolResult(
        { ...metadata, savedTo: path.relative(PROJECT_DIR, screenshotPath) },
        { type: 'image', mimeType, data: imageBase64 },
      );
    }
    default: throw new Error(`Unknown tool: ${name}`);
  }
}

function sendMessage(message) {
  process.stdout.write(`${JSON.stringify(message)}\n`);
}

function sendError(id, code, message, data) {
  sendMessage({ jsonrpc: '2.0', id, error: { code, message, ...(data === undefined ? {} : { data }) } });
}

function sendResult(id, result, modern) {
  const modernResult = modern
    ? { ...result, resultType: 'complete', _meta: { 'io.modelcontextprotocol/serverInfo': SERVER_INFO } }
    : result;
  sendMessage({ jsonrpc: '2.0', id, result: modernResult });
}

async function handleMessage(message) {
  if (!message || message.jsonrpc !== '2.0' || typeof message.method !== 'string') {
    if (message?.id !== undefined) sendError(message.id, -32600, 'Invalid JSON-RPC request.');
    return;
  }
  const hasId = Object.hasOwn(message, 'id');
  const id = message.id;
  try {
    switch (message.method) {
      case 'initialize': {
        const requested = message.params?.protocolVersion;
        const protocolVersion = SUPPORTED_PROTOCOLS.has(requested)
          ? requested : '2025-11-25';
        legacyProtocolVersion = protocolVersion;
        if (!hasId) return;
        sendMessage({
          jsonrpc: '2.0', id,
          result: {
            protocolVersion,
            capabilities: { tools: { listChanged: false } },
            serverInfo: SERVER_INFO,
            instructions: '只控制本仓库固定的 Minecraft 1.21.1 NeoForge 客户端；配置已安装档案时，仅启动固定的 1.21.1 NeoForge 21.1.235 档案并使用仓库内隔离 gameDir。玩家动作由游戏内模组直接调用客户端 API；世界修改只用于可丢弃的单人测试世界。',
          },
        });
        return;
      }
      case 'notifications/initialized':
        return;
      case 'server/discover': {
        if (!hasId) return;
        const requested = message.params?._meta?.['io.modelcontextprotocol/protocolVersion'];
        if (requested && requested !== PROTOCOL_VERSION) {
          sendError(id, -32022, 'Unsupported protocol version.', { supported: [PROTOCOL_VERSION, '2025-11-25'], requested });
          return;
        }
        sendResult(id, {
          supportedVersions: [PROTOCOL_VERSION, '2025-11-25'],
          capabilities: { tools: {} },
          instructions: 'Controls this repository\'s fixed Minecraft 1.21.1 NeoForge client or, when configured, the fixed installed NeoForge 21.1.235 profile in an isolated repository gameDir. Player actions call Minecraft client APIs; use disposable local single-player test worlds for mutations.',
          ttlMs: 300000,
          cacheScope: 'public',
        }, true);
        return;
      }
      case 'ping': {
        if (!hasId) return;
        const meta = message.params?._meta;
        const modern = meta?.['io.modelcontextprotocol/protocolVersion'] === PROTOCOL_VERSION;
        if (modern || legacyProtocolVersion) sendResult(id, {}, modern);
        else sendError(id, -32600, 'Send server/discover or initialize before calling ping.');
        return;
      }
      case 'tools/list': {
        if (!hasId) return;
        const version = message.params?._meta?.['io.modelcontextprotocol/protocolVersion'];
        const modern = version === PROTOCOL_VERSION;
        if (!modern && !legacyProtocolVersion) {
          sendError(id, -32600, 'Send server/discover or initialize before calling tools/list.');
          return;
        }
        if (version && version !== PROTOCOL_VERSION && version !== legacyProtocolVersion) {
          sendError(id, -32022, 'Unsupported protocol version.', { supported: [PROTOCOL_VERSION, '2025-11-25'], requested: version });
          return;
        }
        sendResult(id, { tools: toolDefinitions, ttlMs: 300000, cacheScope: 'public' }, modern);
        return;
      }
      case 'tools/call': {
        if (!hasId) return;
        const version = message.params?._meta?.['io.modelcontextprotocol/protocolVersion'];
        const modern = version === PROTOCOL_VERSION;
        if (!modern && !legacyProtocolVersion) {
          sendError(id, -32600, 'Send server/discover or initialize before calling tools/call.');
          return;
        }
        if (version && version !== PROTOCOL_VERSION && version !== legacyProtocolVersion) {
          sendError(id, -32022, 'Unsupported protocol version.', { supported: [PROTOCOL_VERSION, legacyProtocolVersion ?? '2025-11-25'], requested: version });
          return;
        }
        const name = message.params?.name;
        const args = message.params?.arguments ?? {};
        if (!toolDefinitions.some((tool) => tool.name === name)) {
          sendError(id, -32602, `Unknown tool: ${name}`);
          return;
        }
        try {
          sendResult(id, await callTool(name, args), modern);
        } catch (error) {
          sendResult(id, { content: [text(error.message)], isError: true }, modern);
        }
        return;
      }
      default:
        if (hasId) sendError(id, -32601, `Method not found: ${message.method}`);
    }
  } catch (error) {
    if (hasId) sendError(id, -32603, error.message || 'Internal error.');
  }
}

let inputBuffer = '';
process.stdin.setEncoding('utf8');
process.stdin.on('data', (chunk) => {
  inputBuffer += chunk;
  while (true) {
    const newline = inputBuffer.indexOf('\n');
    if (newline < 0) break;
    const line = inputBuffer.slice(0, newline).trim();
    inputBuffer = inputBuffer.slice(newline + 1);
    if (!line) continue;
    let message;
    try {
      message = JSON.parse(line);
    } catch {
      sendError(null, -32700, 'Parse error.');
      continue;
    }
    void handleMessage(message);
  }
});
process.stdin.on('end', () => {
  void stopClient().finally(() => process.exit(0));
});
