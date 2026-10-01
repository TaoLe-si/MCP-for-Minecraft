#!/usr/bin/env python3
"""mcmcp —— MCP for Minecraft 的 MCP 服务器（纯标准库，无第三方依赖）。

为什么自己写而不装 `mcp` 包：这个仓库的原则是"能用标准库就别拖依赖"，
而且 MCP 的 stdio 传输就是**换行分隔的 JSON-RPC 2.0**，几十行就能实现。
少一个 pip 依赖 = 少一个"在我机器上能跑"的坑。

分工：
  tools/mcmcp.py  ← 本文件，MCP 服务（外部发送端）
  mod/            ← Forge 1.20.1 模组（游戏内接收端，动态服务）

两头用 docs/protocol.md 里那套换行分隔 JSON 包通信。本文件里
`send_packet()` 就是"发送端发一个包"的那只手。

  mc_move  ──►  {"id":1,"op":"move","args":{"forward":1,"ticks":40}}
                 │
                 ▼  TCP 127.0.0.1:25585
              mod 里的 ControlServer → 投递到游戏线程 → 玩家真的往前走

暴露的工具：
  mc_ping / mc_wait      —— 探活与等待
  mc_state               —— 观测快照
  mc_move / mc_key / mc_look / mc_jump / mc_chat —— 动作（都是"等做完再回包"）
  mc_shot / mc_diff      —— 截图与像素比对（视觉证据，自己解 PNG，不依赖 PIL）
  mc_exec                —— 原始包逃生口
  mc_build / mc_run      —— 构建与启动 dev 客户端/服务端
  skill_read / skill_note —— API SKILL 与运行时 SKILL 的读写

用法（由 ZCode 的 ~/.zcode/cli/config.json 拉起，一般不用手敲）：
  python tools/mcmcp.py
"""

from __future__ import annotations

import datetime
import json
import os
import re
import socket
import struct
import subprocess
import sys
import time
import zlib

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
MOD_DIR = os.path.join(ROOT, "mod")
SKILL_API = os.path.join(ROOT, "skills", "minecraft-api", "SKILL.md")
SKILL_RUNTIME = os.path.join(ROOT, "skills", "minecraft-runtime", "SKILL.md")
MEASUREMENTS = os.path.join(ROOT, "skills", "minecraft-runtime", "measurements.jsonl")
RUN_LOG = os.path.join(ROOT, "artifacts", "game.log")
RUN_PID = os.path.join(ROOT, "artifacts", "game.pid")

HOST = "127.0.0.1"
PORT = int(os.environ.get("MCPMC_PORT", "25585"))

PROTOCOL_VERSION = "2024-11-05"
GRADLEW = os.path.join(MOD_DIR, "gradlew.bat" if os.name == "nt" else "gradlew")


# ---------------------------------------------------------------- 动态服务客户端
class ControlError(RuntimeError):
    pass


def send_packet(op, args=None, timeout=60.0, port=None):
    """发一个包，收一个包。串行、一问一答，见 docs/protocol.md。"""
    req = {"id": 1, "op": op, "args": args or {}}
    try:
        with socket.create_connection((HOST, port or PORT), timeout=5.0) as sock:
            sock.settimeout(timeout)
            sock.sendall((json.dumps(req, ensure_ascii=False) + "\n").encode("utf-8"))
            buf = b""
            while b"\n" not in buf:
                chunk = sock.recv(65536)
                if not chunk:
                    raise ControlError("游戏关掉了连接（可能崩了，看 %s）" % RUN_LOG)
                buf += chunk
    except (ConnectionRefusedError, socket.timeout) as exc:
        raise ControlError(
            "连不上游戏内动态服务 %s:%d（%s）。游戏没起来？先用 mc_run 起一个。"
            % (HOST, port or PORT, type(exc).__name__)) from exc
    resp = json.loads(buf.split(b"\n", 1)[0].decode("utf-8"))
    if not resp.get("ok"):
        raise ControlError(resp.get("error") or "游戏侧返回 ok=false")
    return resp.get("result") or {}


# ---------------------------------------------------------------- 观测渲染
def fmt_pos(p):
    return "(%.2f, %.2f, %.2f)" % (p["x"], p["y"], p["z"])


def fmt_delta(before, after):
    """位移的长度 + 分量。判据就在这：往前走没走，看这个数。"""
    a, b = before["pos"], after["pos"]
    dx, dy, dz = b["x"] - a["x"], b["y"] - a["y"], b["z"] - a["z"]
    dist = (dx * dx + dy * dy + dz * dz) ** 0.5
    ticks = after["tick"] - before["tick"]
    return {
        "dx": round(dx, 4), "dy": round(dy, 4), "dz": round(dz, 4),
        "dist": round(dist, 4), "ticks": ticks,
        "blocks_per_tick": round(dist / ticks, 5) if ticks else None,
        "blocks_per_second": round(dist / ticks * 20.0, 3) if ticks else None,
    }


def fmt_frame(tag, frame):
    if not frame.get("inWorld"):
        return "  %s: 不在世界里" % tag
    p, r = frame["pos"], frame["rot"]
    return "  %s: 位置 %s  朝向 yaw=%.1f pitch=%.1f  着地=%s" % (
        tag, fmt_pos(p), r["yaw"], r["pitch"], frame.get("onGround"))


def record_measurement(entry):
    """把实测写进行证据流水（jsonl，只增不改）。动态修正的原料。"""
    os.makedirs(os.path.dirname(MEASUREMENTS), exist_ok=True)
    entry = dict(entry)
    entry["at"] = datetime.datetime.now().astimezone().isoformat(timespec="seconds")
    with open(MEASUREMENTS, "a", encoding="utf-8") as f:
        f.write(json.dumps(entry, ensure_ascii=False) + "\n")
    return MEASUREMENTS


# ---------------------------------------------------------------- 动作类工具
def _window_hint(result):
    """tick 不涨的时候，窗口焦点和失焦暂停设置是头号嫌疑，直接点出来。"""
    if result.get("side") != "client":
        return ""
    if result.get("windowActive") is False:
        return "（窗口没焦点；失焦暂停=%s）" % result.get("pauseOnLostFocus")
    return ""


def tool_ping(wait=0.0):
    if wait and wait > 0:
        deadline = time.time() + float(wait)
        last = None
        while time.time() < deadline:
            try:
                r = send_packet("ping", timeout=5.0)
                if r.get("inWorld"):
                    return "游戏在线，已进世界。tick=%s（等了 %.1fs）%s" % (
                        r.get("tick"), float(wait), _window_hint(r))
                time.sleep(1.5)
            except ControlError as exc:
                last = exc
                time.sleep(1.5)
        return "等 %.1fs 仍没进世界：%s" % (float(wait), last)
    r = send_packet("ping", timeout=5.0)
    return "游戏在线。tick=%s 在世界里=%s%s" % (
        r.get("tick"), r.get("inWorld"), _window_hint(r))


def tool_state():
    r = send_packet("state")
    if not r.get("inWorld"):
        return "游戏在跑，但还没进世界（当前界面：%s）。" % (r.get("screen") or "无")
    return "\n".join([
        fmt_frame("当前", r),
        "  维度=%s  tick=%s  血量=%.1f  饱食=%s  手持=%s"
        % (r.get("dim"), r.get("tick"), r.get("health", -1), r.get("food"), r.get("held")),
        "  潜行=%s 疾跑=%s 界面=%s"
        % (r.get("sneaking"), r.get("sprinting"), r.get("screen") or "无"),
    ])


def tool_action(op, args, record=True):
    """动作类工具的统一外壳：发包 → 渲染 before/after → 记实测。"""
    r = send_packet(op, args)
    before, after = r.get("before"), r.get("after")
    lines = ["%s %s" % (op, json.dumps(args, ensure_ascii=False))]
    if before and after:
        lines.append(fmt_frame("之前", before))
        lines.append(fmt_frame("之后", after))
        d = fmt_delta(before, after)
        lines.append("  位移 Δ=(%+.3f, %+.3f, %+.3f)  距离=%.3f 格  用了 %d tick  →  %.3f 格/秒"
                     % (d["dx"], d["dy"], d["dz"], d["dist"], d["ticks"],
                        d["blocks_per_second"] or 0.0))
        if record:
            record_measurement({"op": op, "args": args, "before": before,
                                "after": after, "delta": d})
    for k in ("applied", "sent", "path"):
        if k in r:
            lines.append("  %s=%s" % (k, r[k]))
    return "\n".join(lines)


def tool_shot(name="", record=True):
    r = send_packet("shot", {"name": name} if name else {})
    path = r["path"]
    lines = ["截图已存：%s" % path]
    try:
        info = png_info(path)
        lines.append("  尺寸 %dx%d  平均亮度 %.1f  非黑像素 %.1f%%"
                     % (info["width"], info["height"], info["mean_luma"],
                        info["nonblack"] * 100.0))
        lines.append("  指纹 %s" % info["fingerprint"])
        if record:
            record_measurement({"op": "shot", "path": path, "info": info})
    except Exception as exc:                                          # noqa: BLE001
        lines.append("  （PNG 统计失败：%s: %s）" % (type(exc).__name__, exc))
    return "\n".join(lines)


def wait_ready(seconds=60.0):
    """等游戏主线程真的能干活。

    `ping` 走的是 volatile 快照，主线程被堵住时它照样答；`probe` 要排队到主线程，
    所以**用 probe 当"能干活"的判据**。刚做过大跨度传送时主线程会在生成区块上卡
    几十秒，这时候发什么动作都超时 —— 先等，别急着判定"坏了"。
    """
    deadline = time.time() + seconds
    last = None
    while time.time() < deadline:
        try:
            send_packet("probe", timeout=8.0)
            return True
        except ControlError as exc:
            last = exc
            time.sleep(1.0)
    raise RuntimeError("等了 %.0fs 主线程还是不能干活：%s" % (seconds, last))


def prepare_clean_lane(length=16, wait=6.0):
    """原地清出一条走廊，把玩家从"卡在方块里"的状态里救出来，并把朝向摆正。

    为什么非要这一步：玩家**卡在方块里**时，`forwardImpulse` 照样是 1、tick 照样走，
    但碰撞会把水平速度清零，表现为"位移 0 / 只有预期的一半"，极容易被误判成
    "按键机制坏了"。踩过一次：上一轮测试自己放的石头就留在脚边。

    **故意不传送**：大跨度 `/tp` 会触发大量新区块生成，把客户端主线程堵住几十秒，
    命令直接超时（实测从 0 传到 300 卡了 ~25 秒，日志里连着两条 "Can't keep up!"）。
    原地清场只动已加载的区块，快且稳。

    返回被清理区域的中心 (x, y, z)。
    """
    wait_ready()
    st = send_packet("state")
    if not st.get("inWorld"):
        raise RuntimeError("不在世界里，没法清场")
    pos = st["pos"]
    px, py, pz = int(pos["x"]), int(pos["y"]), int(pos["z"])

    # 3 宽 3 高，从玩家脚下往后铺一条走廊；只动已加载的区块
    cmd = "/fill %d %d %d %d %d %d minecraft:air" % (
        px - 1, py, pz - 1, px + 1, py + 2, pz + length)
    send_packet("chat", {"text": cmd, "command": True})

    # 等它生效，顺便确认游戏还活着（客户端线程被堵时 tick 不涨）
    deadline = time.time() + wait
    last_tick = -1
    stuck = 0
    while time.time() < deadline:
        ping = send_packet("ping")
        tick = ping.get("tick") or 0
        if tick == last_tick:
            stuck += 1
        last_tick = tick
        if stuck >= 5:
            raise RuntimeError(
                "游戏客户端主线程疑似被堵住（tick 连续 5 次不涨）—— 常见原因是刚做过"
                "大跨度传送，正在生成新区块。等它缓过来再试，日志见 artifacts/game.log")
        if send_packet("block", {"x": px, "y": py, "z": pz}).get("air"):
            break
        time.sleep(0.2)

    send_packet("look", {"yaw": 0.0, "pitch": 0.0})
    for _ in range(60):
        if send_packet("state").get("onGround"):
            break
        time.sleep(0.1)
    return px, py, pz


def reset_test_state(items=(), spawn=(0, -60, 0), wait=3.0):
    """跑批之前把角色状态收拾干净，保证每一轮从同一个起点开始。

    为什么非做不可 —— 状态会**跨跑累积**，而且累积出来的坑很难认：
      * 上一轮做睡眠测试把人**留在床上**了，这一轮的 `fly`/`startUsing` 全都悄悄不生效；
      * 上一轮 `/give` 的面包还在主背包里，这一轮"丢一个"数来数去数字对不上；
      * 上一轮挖的坑、放的石头留在原地，这一轮"往前走"撞墙；
      * 上一轮开着的界面还开着，这一轮所有按键类动作直接被拒。
    所以：**先醒来 → 回固定起点 → 清背包 → 定模式 → 重新发物品**，一步都不能省。
    """
    # 1) 先醒来：睡着的时候很多动作会被原版默默忽略
    try:
        send_packet("wakeUp", timeout=15)
    except ControlError:
        pass
    # 2) 回固定起点（目标区块在加载时就已生成，不会触发大规模地形生成）
    send_packet("chat", {"text": "/tp @s %d %d %d 0 0" % spawn, "command": True})
    time.sleep(0.6)
    # 3) 清背包、定模式
    send_packet("chat", {"text": "/clear @s", "command": True})
    send_packet("chat", {"text": "/gamemode creative", "command": True})
    time.sleep(0.6)
    # 4) 重新发物品
    for item in items:
        send_packet("chat", {"text": "/give @s %s" % item, "command": True})
    # 5) 走廊清空（原地，不传送）
    prepare_clean_lane()
    deadline = time.time() + wait
    while time.time() < deadline:
        if not send_packet("state").get("sleeping"):
            break
        time.sleep(0.2)
    return send_packet("state")


def tool_build(target=""):
    cmd = [GRADLEW, target or "build", "--console=plain"]
    p = subprocess.run(cmd, cwd=MOD_DIR, capture_output=True, text=True,
                       errors="replace", timeout=1800)
    out = (p.stdout or "") + (p.stderr or "")
    bad = [l for l in out.splitlines()
           if re.search(r"error: |错误: |FAILURE:|BUILD FAILED|Could not resolve|Execution failed", l)]
    body = "\n".join(bad[:60]) if bad else out[-3000:]
    return "rc=%d\n%s" % (p.returncode, body)


def tool_run(action="start_client", wait=180.0, extra=""):
    if action in ("stop", "kill"):
        p = subprocess.run(["taskkill", "/F", "/IM", "java.exe", "/FI", "WINDOWTITLE eq MCPMC*"],
                           capture_output=True, text=True)
        return "已尝试停掉（%s）。dev 客户端窗口关掉即可。" % (p.stdout or p.stderr).strip()
    if action == "status":
        try:
            return tool_ping(0)
        except ControlError as exc:
            return "没在跑：%s" % exc
    task = {"client": "runClient", "client_auto": "runClientAuto",
            "server": "runServer"}.get(action)
    if not task:
        return "action 只能是 client / client_auto / server / stop / status"
    os.makedirs(os.path.dirname(RUN_LOG), exist_ok=True)
    flag = "w" if action == "server" else "a"
    log = open(RUN_LOG, flag, encoding="utf-8", errors="replace")
    cmd = [GRADLEW, task, "--console=plain"] + (extra.split() if extra else [])
    proc = subprocess.Popen(cmd, cwd=MOD_DIR, stdout=log, stderr=subprocess.STDOUT,
                            creationflags=getattr(subprocess, "CREATE_NEW_PROCESS_GROUP", 0))
    with open(RUN_PID, "w", encoding="utf-8") as f:
        f.write(str(proc.pid))
    if wait and wait > 0 and action != "server":
        deadline = time.time() + float(wait)
        while time.time() < deadline:
            try:
                send_packet("ping", timeout=5.0)
                return "已启动 %s（pid=%s），动态服务在线。日志：%s" % (task, proc.pid, RUN_LOG)
            except ControlError:
                time.sleep(3.0)
        return "启动了 %s（pid=%s）但 %.0fs 内没等到动态服务；看日志 %s" % (
            task, proc.pid, float(wait), RUN_LOG)
    return "已启动 %s（pid=%s），日志：%s" % (task, proc.pid, RUN_LOG)


# ---------------------------------------------------------------- SKILL 读写
def tool_skill_read(which="api", tail=120):
    path = {"api": SKILL_API, "runtime": SKILL_RUNTIME}.get(which)
    if not path:
        return "which 只能是 api 或 runtime"
    if not os.path.exists(path):
        return "（还没有 %s，路径 %s）" % (which, path)
    with open(path, encoding="utf-8") as f:
        lines = f.read().splitlines()
    n = int(tail) if tail else 0
    body = "\n".join(lines[-n:]) if n and len(lines) > n else "\n".join(lines)
    return "%s（%d 行，显示后 %d 行）\n%s" % (path, len(lines), min(n or len(lines), len(lines)), body)


def tool_skill_note(text):
    """往运行时 SKILL 追加一节修正（自动带时间戳）。"""
    os.makedirs(os.path.dirname(SKILL_RUNTIME), exist_ok=True)
    stamp = datetime.datetime.now().astimezone().strftime("%Y-%m-%d %H:%M")
    with open(SKILL_RUNTIME, "a", encoding="utf-8") as f:
        f.write("\n### [%s] 运行时修正\n\n%s\n" % (stamp, text.rstrip()))
    return "已写入 %s" % SKILL_RUNTIME


# ---------------------------------------------------------------- PNG（自己解，不依赖 PIL）
def _paeth(a, b, c):
    p = a + b - c
    pa, pb, pc = abs(p - a), abs(p - b), abs(p - c)
    if pa <= pb and pa <= pc:
        return a
    return b if pb <= pc else c


def png_read(path):
    """读 8bit 非隔行 PNG（灰度/RGB/RGBA），回 (宽, 高, 通道数, 像素 bytes)。"""
    with open(path, "rb") as f:
        data = f.read()
    if data[:8] != b"\x89PNG\r\n\x1a\n":
        raise ValueError("不是 PNG")
    pos, idat, w, h, depth, ctype, interlace = 8, b"", 0, 0, 0, 0, 0
    while pos < len(data):
        ln = struct.unpack(">I", data[pos:pos + 4])[0]
        typ = data[pos + 4:pos + 8]
        body = data[pos + 8:pos + 8 + ln]
        if typ == b"IHDR":
            w, h, depth, ctype, _, _, interlace = struct.unpack(">IIBBBBB", body)
        elif typ == b"IDAT":
            idat += body
        elif typ == b"IEND":
            break
        pos += 12 + ln
    if depth != 8 or interlace != 0 or ctype not in (0, 2, 4, 6):
        raise ValueError("只支持 8bit 非隔行 灰度/RGB/RGBA（depth=%d ctype=%d il=%d）"
                         % (depth, ctype, interlace))
    ch = {0: 1, 2: 3, 4: 2, 6: 4}[ctype]
    raw = zlib.decompress(idat)
    stride = w * ch
    out = bytearray(stride * h)
    prev = bytearray(stride)
    p = 0
    for y in range(h):
        ft = raw[p]
        p += 1
        line = bytearray(raw[p:p + stride])
        p += stride
        if ft == 1:
            for i in range(ch, stride):
                line[i] = (line[i] + line[i - ch]) & 0xFF
        elif ft == 2:
            for i in range(stride):
                line[i] = (line[i] + prev[i]) & 0xFF
        elif ft == 3:
            for i in range(stride):
                a = line[i - ch] if i >= ch else 0
                line[i] = (line[i] + ((a + prev[i]) >> 1)) & 0xFF
        elif ft == 4:
            for i in range(stride):
                a = line[i - ch] if i >= ch else 0
                c = prev[i - ch] if i >= ch else 0
                line[i] = (line[i] + _paeth(a, prev[i], c)) & 0xFF
        out[y * stride:(y + 1) * stride] = line
        prev = line
    return w, h, ch, bytes(out)


def png_info(path, grid=8):
    w, h, ch, px = png_read(path)
    total = w * h
    luma_sum, nonblack, cells = 0.0, 0, [0.0] * (grid * grid)
    counts = [0] * (grid * grid)
    for y in range(h):
        row = y * w * ch
        for x in range(w):
            i = row + x * ch
            if ch >= 3:
                r, g, b = px[i], px[i + 1], px[i + 2]
            else:
                r = g = b = px[i]
            if ch in (2, 4) and px[i + ch - 1] < 8:
                r = g = b = 0
            luma = 0.299 * r + 0.587 * g + 0.114 * b
            luma_sum += luma
            if luma > 12:
                nonblack += 1
            c = (y * grid // h) * grid + (x * grid // w)
            cells[c] += luma
            counts[c] += 1
    avg = [cells[i] / counts[i] if counts[i] else 0.0 for i in range(grid * grid)]
    return {
        "path": path, "width": w, "height": h,
        "mean_luma": round(luma_sum / total, 3),
        "nonblack": round(nonblack / total, 5),
        "fingerprint": "%dx%d:%s" % (w, h, ",".join("%.0f" % v for v in avg)),
    }


def tool_diff(a, b, region=""):
    wa, ha, cha, pa = png_read(a)
    wb, hb, chb, pb = png_read(b)
    if (wa, ha) != (wb, hb):
        return "尺寸不同：%dx%d vs %dx%d，没法逐像素比" % (wa, ha, wb, hb)
    x0, y0, x1, y1 = 0, 0, wa, ha
    if region:
        x0, y0, x1, y1 = [int(v) for v in region.split(",")]
    diff, total, worst, worst_xy = 0, 0, 0, None
    for y in range(y0, y1):
        for x in range(x0, x1):
            ia, ib = (y * wa + x) * cha, (y * wa + x) * chb
            d = 0
            for k in range(min(cha, chb)):
                d = max(d, abs(pa[ia + k] - pb[ib + k]))
            total += 1
            if d > 8:
                diff += 1
            if d > worst:
                worst, worst_xy = d, (x, y)
    pct = diff * 100.0 / total if total else 0.0
    return ("比 %s ↔ %s：区域 %d 像素，变化 %d（%.2f%%），最大单通道差 %d 在 %s"
            % (os.path.basename(a), os.path.basename(b), total, diff, pct, worst, worst_xy))


# ------------------------------------------------------------ 观测结果渲染
def render_result(op, result, indent="  "):
    """把回包渲染成人能读的几行。认得的就展开，不认得的退回 JSON。"""
    if op == "block":
        props = result.get("props") or {}
        ptxt = ("  属性 " + " ".join("%s=%s" % kv for kv in props.items())) if props else ""
        return ("%s(%d, %d, %d) %s%s  (%.2f 格外)%s"
                % (indent, result["x"], result["y"], result["z"], result.get("block"),
                   " [空气]" if result.get("air") else "", result.get("distance", 0.0), ptxt))
    if op == "blocks":
        lines = ["%s扫了 %s 格，命中 %d 个非空气方块%s"
                 % (indent, result.get("scanned"), result.get("count"),
                    "（截断了）" if result.get("truncated") else "")]
        for b in (result.get("blocks") or [])[:40]:
            lines.append("%s  (%d, %d, %d) %s" % (indent, b["x"], b["y"], b["z"], b["block"]))
        if result.get("count", 0) > 40:
            lines.append("%s  …还有 %d 个" % (indent, result["count"] - 40))
        return "\n".join(lines)
    if op == "entities":
        lines = ["%s附近 %d 个实体" % (indent, result.get("count"))]
        for e in (result.get("entities") or [])[:30]:
            lines.append("%s  #%s %s 「%s」 (%.1f, %.1f, %.1f) 距 %.2f%s"
                         % (indent, e["id"], e["type"], e["name"], e["x"], e["y"], e["z"],
                            e["distance"], (" 血 %.1f" % e["health"]) if "health" in e else ""))
        return "\n".join(lines)
    if op == "inventory":
        lines = ["%s手持 %s  副手 %s  选中槽 %s"
                 % (indent, result.get("held"), result.get("offhand"), result.get("selected"))]
        for it in (result.get("slots") or []):
            lines.append("%s  [%d] %s x%d" % (indent, it["slot"], it["item"], it["count"]))
        if not result.get("slots"):
            lines.append("%s  （背包是空的）" % indent)
        return "\n".join(lines)
    if op == "screen":
        if not result.get("open"):
            return indent + "当前没有开着的界面"
        lines = ["%s界面「%s」%s" % (indent, result.get("title"), result.get("class"))]
        for w in (result.get("widgets") or []):
            lines.append("%s  [%d] %s 「%s」 %dx%d @(%d,%d)%s"
                         % (indent, w["index"], w["type"], w["label"], w["width"], w["height"],
                            w["x"], w["y"], "" if w["active"] else " (灰)"))
        if "slots" in result:
            used = [x for x in result["slots"] if x.get("stack")]
            lines.append("%s  容器 %d 个槽位，其中 %d 个有东西"
                         % (indent, len(result["slots"]), len(used)))
            for x in used[:20]:
                st = x["stack"]
                lines.append("%s    [%d] %s x%d" % (indent, x["slot"], st["item"], st["count"]))
        return "\n".join(lines)
    if op == "ray":
        if result.get("type") == "miss":
            return indent + "视线没打到任何东西"
        if "block" in result:
            b = result["block"]
            return "%s视线命中方块 (%d, %d, %d) %s，面 %s" % (
                indent, b["x"], b["y"], b["z"], b["block"], result.get("face"))
        return "%s视线命中实体 #%s %s「%s」" % (
            indent, result.get("entityId"), result.get("entityType"), result.get("entityName"))
    if op in ("log", "chatlog", "events"):
        lines = ["%s%s 条 %s" % (indent, result.get("count"), result.get("path", ""))]
        for item in (result.get("lines") or result.get(op) or []):
            if isinstance(item, dict):
                lines.append("%s  [%s] %s: %s" % (indent, item.get("at"), item.get("kind"),
                                                 item.get("text")))
            else:
                lines.append("%s  %s" % (indent, item))
        return "\n".join(lines)
    return indent + json.dumps(result, ensure_ascii=False, indent=2)


def tool_obs(op, args, record=False):
    """观测类工具的统一外壳：发包 → 渲染。"""
    result = send_packet(op, args)
    text = "%s %s\n%s" % (op, json.dumps(args, ensure_ascii=False),
                          render_result(op, result))
    if record:
        record_measurement({"op": op, "args": args, "result": result})
    return text


# ---------------------------------------------------------------- 工具表
TOOLS_SPEC = [
    # ---------------- 存活与观测 ----------------
    ("mc_ping", "探活：游戏内动态服务在不在。wait>0 则轮询等待（秒）。",
     {"type": "object", "properties": {
         "wait": {"type": "number", "description": "轮询等待秒数，默认 0（只试一次）"}}},
     lambda a: tool_ping(a.get("wait", 0))),
    ("mc_state", "玩家/世界快照：位置、朝向、维度、血量、饱食、手持、是否开着界面。",
     {"type": "object", "properties": {}},
     lambda a: tool_state()),
    ("mc_block", "看某个坐标上是什么方块（含属性，如 facing/open/powered）。",
     {"type": "object", "properties": {
         "x": {"type": "integer"}, "y": {"type": "integer"}, "z": {"type": "integer"}},
      "required": ["x", "y", "z"]},
     lambda a: tool_obs("block", {"x": a["x"], "y": a["y"], "z": a["z"]})),
    ("mc_blocks", "扫一个长方体区域里有哪些方块（可 filter 按名字过滤）。",
     {"type": "object", "properties": {
         "x1": {"type": "integer"}, "y1": {"type": "integer"}, "z1": {"type": "integer"},
         "x2": {"type": "integer"}, "y2": {"type": "integer"}, "z2": {"type": "integer"},
         "filter": {"type": "string", "description": "方块名子串，如 minecraft:log"},
         "limit": {"type": "integer", "description": "最多回多少个，默认 512"}},
      "required": ["x1", "y1", "z1", "x2", "y2", "z2"]},
     lambda a: tool_obs("blocks", {k: a[k] for k in
                                   ("x1", "y1", "z1", "x2", "y2", "z2", "filter", "limit")
                                   if k in a})),
    ("mc_entities", "附近有哪些实体（id/类型/名字/坐标/距离/血量）。",
     {"type": "object", "properties": {
         "radius": {"type": "number", "description": "半径，默认 16"},
         "type": {"type": "string", "description": "类型名子串过滤"},
         "limit": {"type": "integer"}}},
     lambda a: tool_obs("entities", {k: a[k] for k in ("radius", "type", "limit") if k in a})),
    ("mc_inventory", "背包与手持：每个槽位的物品和数量、当前选中槽。",
     {"type": "object", "properties": {}},
     lambda a: tool_obs("inventory", {})),
    ("mc_ray", "视线射线打到了什么（方块或实体）。",
     {"type": "object", "properties": {"reach": {"type": "number"}}},
     lambda a: tool_obs("ray", {k: a[k] for k in ("reach",) if k in a})),
    ("mc_screen", "当前界面的控件清单（按钮文字/位置/是否可用）+ 容器槽位。",
     {"type": "object", "properties": {}},
     lambda a: tool_obs("screen", {})),

    # ---------------- 日志 ----------------
    ("mc_log", "游戏日志尾部（原版和所有模组写的那份 latest.log）。",
     {"type": "object", "properties": {
         "lines": {"type": "integer", "description": "回多少行，默认 80"},
         "filter": {"type": "string", "description": "只回含该子串的行"}}},
     lambda a: tool_obs("log", {k: a[k] for k in ("lines", "filter") if k in a})),
    ("mc_chatlog", "最近的聊天/系统消息（我们抄的流水，不依赖原版聊天窗）。",
     {"type": "object", "properties": {"lines": {"type": "integer"}}},
     lambda a: tool_obs("chatlog", {k: a[k] for k in ("lines",) if k in a})),
    ("mc_events", "事件流水：执行过的动作、界面开关、换维度、死亡、进出世界。",
     {"type": "object", "properties": {"lines": {"type": "integer"}}},
     lambda a: tool_obs("events", {k: a[k] for k in ("lines",) if k in a})),

    # ---------------- 按键 ----------------
    ("mc_move", "让玩家往前走（核心动作）。可选先转向。等走完再回包，带前后实测位移。",
     {"type": "object", "properties": {
         "forward": {"type": "number", "description": "前进量，默认 1（原版按键只有开/关）"},
         "ticks": {"type": "integer", "description": "走多少 tick，20 tick ≈ 1 秒，默认 40"},
         "yaw": {"type": "number", "description": "可选，先拧到该朝向再走（度）"},
         "record": {"type": "boolean", "description": "是否记入实测流水，默认 true"}}},
     lambda a: tool_action("move", {k: v for k, v in {
         "forward": a.get("forward", 1), "ticks": int(a.get("ticks", 40)),
         "yaw": a.get("yaw")}.items() if v is not None}, a.get("record", True))),
    ("mc_key", "按住/松开原版按键 N tick，到点自动全松（不卡键）。",
     {"type": "object", "properties": {
         "keys": {"type": "object",
                  "description": "键名→开关。键名全表见 skills/minecraft-api/SKILL.md"},
         "ticks": {"type": "integer", "description": "按多少 tick，默认 20"},
         "record": {"type": "boolean"}}},
     lambda a: tool_action("key", {"keys": a.get("keys") or {},
                                   "ticks": int(a.get("ticks", 20))}, a.get("record", True))),
    ("mc_press", "敲一下某个键（按下→松开）。走 consumeClick 那条路，"
                 "开背包/丢弃/切视角/快捷栏 1-9 必须用它。",
     {"type": "object", "properties": {
         "key": {"type": "string",
                 "description": "键名，如 inventory / drop / togglePerspective"},
         "record": {"type": "boolean"}},
      "required": ["key"]},
     lambda a: tool_action("press", {"key": a["key"], "ticks": 1}, a.get("record", True))),
    ("mc_jump", "按住跳跃 N tick。",
     {"type": "object", "properties": {
         "ticks": {"type": "integer"}, "record": {"type": "boolean"}}},
     lambda a: tool_action("jump", {"ticks": int(a.get("ticks", 10))}, a.get("record", True))),

    # ---------------- 朝向 ----------------
    ("mc_look", "直接设朝向（yaw/pitch，度）。",
     {"type": "object", "properties": {
         "yaw": {"type": "number"}, "pitch": {"type": "number"},
         "record": {"type": "boolean"}},
      "required": ["yaw"]},
     lambda a: tool_action("look", {k: v for k, v in {
         "yaw": a.get("yaw"), "pitch": a.get("pitch")}.items() if v is not None},
         a.get("record", False))),
    ("mc_look_at", "看向某个坐标（自动算 yaw/pitch）。",
     {"type": "object", "properties": {
         "x": {"type": "number"}, "y": {"type": "number"}, "z": {"type": "number"}},
      "required": ["x", "y", "z"]},
     lambda a: tool_action("lookAt", {"x": a["x"], "y": a["y"], "z": a["z"]}, False)),

    # ---------------- 世界改动 ----------------
    ("mc_break", "挖掉 (x,y,z) 上的方块。生存按硬度挖，挖穿才回包。",
     {"type": "object", "properties": {
         "x": {"type": "integer"}, "y": {"type": "integer"}, "z": {"type": "integer"},
         "face": {"type": "string", "description": "从哪面挖，默认 up"},
         "record": {"type": "boolean"}},
      "required": ["x", "y", "z"]},
     lambda a: tool_action("break", {k: a[k] for k in ("x", "y", "z", "face") if k in a},
                           a.get("record", True))),
    ("mc_place", "在 (x,y,z) 放一个方块（对着相邻方块的面用手里/选中的物品）。",
     {"type": "object", "properties": {
         "x": {"type": "integer"}, "y": {"type": "integer"}, "z": {"type": "integer"},
         "face": {"type": "string", "description": "从哪个方向贴上去，默认 up"},
         "record": {"type": "boolean"}},
      "required": ["x", "y", "z"]},
     lambda a: tool_action("place", {k: a[k] for k in ("x", "y", "z", "face") if k in a},
                           a.get("record", True))),
    ("mc_interact", "对着 (x,y,z) 这个方块右键：开门、按按钮、拉杆。瞬时动作，不等界面。",
     {"type": "object", "properties": {
         "x": {"type": "integer"}, "y": {"type": "integer"}, "z": {"type": "integer"},
         "face": {"type": "string"}, "record": {"type": "boolean"}},
      "required": ["x", "y", "z"]},
     lambda a: tool_action("interact", {k: a[k] for k in ("x", "y", "z", "face") if k in a},
                           a.get("record", True))),
    ("mc_open", "对着方块右键**并等界面开出来**（箱子/工作台/熔炉这类）。"
               "界面是服务端仲裁后才开的，所以这个 op 会挂账等到 setScreen 真的发生。",
     {"type": "object", "properties": {
         "x": {"type": "integer"}, "y": {"type": "integer"}, "z": {"type": "integer"},
         "face": {"type": "string"},
         "ticks": {"type": "integer", "description": "最多等多少 tick，默认 40"}},
      "required": ["x", "y", "z"]},
     lambda a: tool_action("interact", dict(
         {k: a[k] for k in ("x", "y", "z", "face", "ticks") if k in a},
         awaitScreen=True), False)),
    ("mc_attack", "攻击。不给 entityId 就打准星指着的那个；给了就先转身再打。",
     {"type": "object", "properties": {
         "entityId": {"type": "integer", "description": "mc_entities 回的那个 id"},
         "record": {"type": "boolean"}}},
     lambda a: tool_action("attack", {k: a[k] for k in ("entityId",) if k in a},
                           a.get("record", True))),
    ("mc_use", "使用手里/副手的东西（吃、射、挥）。",
     {"type": "object", "properties": {
         "hand": {"type": "string", "description": "main（默认）或 off"},
         "record": {"type": "boolean"}}},
     lambda a: tool_action("use", {k: a[k] for k in ("hand",) if k in a}, a.get("record", True))),
    ("mc_select_slot", "选快捷栏槽位（1..9）。",
     {"type": "object", "properties": {"slot": {"type": "integer"}}, "required": ["slot"]},
     lambda a: tool_action("selectSlot", {"slot": a["slot"]}, False)),
    ("mc_scroll", "滚轮切快捷栏（+1 往后一格，-1 往前一格）。",
     {"type": "object", "properties": {"amount": {"type": "number"}}},
     lambda a: tool_action("scroll", {k: a[k] for k in ("amount",) if k in a}, False)),

    # ---------------- 界面 ----------------
    ("mc_click_button", "按文字或序号点当前界面上的按钮。找不到会把所有按钮列出来。",
     {"type": "object", "properties": {
         "label": {"type": "string", "description": "按钮文字子串，不分大小写"},
         "index": {"type": "integer", "description": "mc_screen 回的那个序号"},
         "record": {"type": "boolean"}}},
     lambda a: tool_action("clickButton", {k: a[k] for k in ("label", "index") if k in a},
                           a.get("record", False))),
    ("mc_type_text", "往界面上的输入框打字；submit=true 顺带回车（聊天/种子框等）。",
     {"type": "object", "properties": {
         "text": {"type": "string"}, "index": {"type": "integer"},
         "submit": {"type": "boolean"}}},
     lambda a: tool_obs("typeText", {k: a[k] for k in ("text", "index", "submit") if k in a})),
    ("mc_click_slot", "点容器/背包的槽位（走原版那条路由服务端仲裁）。",
     {"type": "object", "properties": {
         "slot": {"type": "integer", "description": "mc_screen 里 slots 的序号"},
         "button": {"type": "integer", "description": "0 左键 / 1 右键"},
         "clickType": {"type": "string",
                       "description": "PICKUP/QUICK_MOVE/SWAP/THROW/… 默认 PICKUP"},
         "record": {"type": "boolean"}},
      "required": ["slot"]},
     lambda a: tool_action("clickSlot", {k: a[k] for k in ("slot", "button", "clickType") if k in a},
                           a.get("record", False))),
    ("mc_close_screen", "关掉当前界面，回到能操作玩家的状态。",
     {"type": "object", "properties": {}},
     lambda a: tool_obs("closeScreen", {})),

    # ---------------- 通信与截图 ----------------
    ("mc_chat", "发聊天或命令。command=true 时按 /命令 发。",
     {"type": "object", "properties": {
         "text": {"type": "string"}, "command": {"type": "boolean"}},
      "required": ["text"]},
     lambda a: tool_action("chat", {"text": a["text"], "command": bool(a.get("command", False))},
                           False)),
    ("mc_shot", "让游戏截图存 PNG，回路径 + 尺寸/亮度/非黑占比/指纹。",
     {"type": "object", "properties": {
         "name": {"type": "string"}, "record": {"type": "boolean"}}},
     lambda a: tool_shot(a.get("name", ""), a.get("record", True))),
    ("mc_diff", "逐像素比两张截图（含 alpha），回变化像素数与最大差。",
     {"type": "object", "properties": {
         "a": {"type": "string"}, "b": {"type": "string"},
         "region": {"type": "string", "description": "可选 x0,y0,x1,y1"}},
      "required": ["a", "b"]},
     lambda a: tool_diff(a["a"], a["b"], a.get("region", ""))),
    ("mc_exec", "原始包逃生口：直接发 {\"op\":...}，回原始 JSON。新 op 先用它试。",
     {"type": "object", "properties": {
         "op": {"type": "string"}, "args": {"type": "object"}},
      "required": ["op"]},
     lambda a: json.dumps(send_packet(a["op"], a.get("args") or {}), ensure_ascii=False,
                          indent=2)),

    # ---------------- 观测纵深（第二批） ----------------
    ("mc_vitals", "生存纵深：血量/饱食/饱和/护甲/氧气/经验/药水效果/能力/飞行/着火/入水/睡眠/载具。",
     {"type": "object", "properties": {}},
     lambda a: tool_obs("vitals", {})),
    ("mc_world", "世界：时间/昼夜/天气/难度/维度/世界边界。",
     {"type": "object", "properties": {}},
     lambda a: tool_obs("world", {})),
    ("mc_light", "某坐标的光照：总亮度 / 天光 / 方块光。",
     {"type": "object", "properties": {
         "x": {"type": "integer"}, "y": {"type": "integer"}, "z": {"type": "integer"}},
      "required": ["x", "y", "z"]},
     lambda a: tool_obs("light", {"x": a["x"], "y": a["y"], "z": a["z"]})),
    ("mc_biome", "某坐标的生物群系。",
     {"type": "object", "properties": {
         "x": {"type": "integer"}, "y": {"type": "integer"}, "z": {"type": "integer"}},
      "required": ["x", "y", "z"]},
     lambda a: tool_obs("biome", {"x": a["x"], "y": a["y"], "z": a["z"]})),
    ("mc_block_entity", "方块实体里的数据（箱子装了什么、熔炉烧到哪、告示牌写了什么），回 NBT 文本。",
     {"type": "object", "properties": {
         "x": {"type": "integer"}, "y": {"type": "integer"}, "z": {"type": "integer"}},
      "required": ["x", "y", "z"]},
     lambda a: tool_obs("blockentity", {"x": a["x"], "y": a["y"], "z": a["z"]})),
    ("mc_entity_info", "单个实体的全部：类型/名字/坐标/朝向/血量/效果/骑乘关系 + 完整 NBT。",
     {"type": "object", "properties": {
         "entityId": {"type": "integer", "description": "mc_entities 回的 id"}},
      "required": ["entityId"]},
     lambda a: tool_obs("entity", {"entityId": a["entityId"]})),
    ("mc_scoreboard", "计分板：目标、队伍成员、分数。",
     {"type": "object", "properties": {}},
     lambda a: tool_obs("scoreboard", {})),
    ("mc_server", "连接信息：单机还是联机、地址、在线玩家与各自延迟/游戏模式。",
     {"type": "object", "properties": {}},
     lambda a: tool_obs("server", {})),
    ("mc_recipes", "查配方（产物 + 原料 + 配方类型）。filter 可按产物名/配方 id 过滤。",
     {"type": "object", "properties": {
         "filter": {"type": "string", "description": "产物物品名或配方 id 的子串，如 torch"},
         "station": {"type": "string", "description": "配方类型子串，如 crafting / smelting"},
         "limit": {"type": "integer", "description": "最多回多少，默认 40"}}},
     lambda a: tool_obs("recipes", {k: a[k] for k in ("filter", "station", "limit") if k in a})),
    ("mc_recipe_book", "配方书状态：分几组、认了多少、现在哪些做得出来。",
     {"type": "object", "properties": {}},
     lambda a: tool_obs("recipebook", {})),

    # ---------------- 动作纵深（第二批） ----------------
    ("mc_use_on_entity", "对实体右键：喂食、剪毛、挤奶、交易、上船、给盔甲架穿装备。",
     {"type": "object", "properties": {
         "entityId": {"type": "integer"},
         "hand": {"type": "string", "description": "main（默认）/ off"},
         "at": {"type": "boolean", "description": "true = 在实体包围盒中心精确点（盔甲架/展示框）"},
         "x": {"type": "number"}, "y": {"type": "number"}, "z": {"type": "number"},
         "record": {"type": "boolean"}},
      "required": ["entityId"]},
     lambda a: tool_action("useOnEntityAt" if a.get("at") else "useOnEntity",
                           {k: a[k] for k in ("entityId", "hand", "x", "y", "z") if k in a},
                           a.get("record", True))),
    ("mc_place_recipe", "配方书一键合成（就像在配方书里点一下）。需要先开着合成界面。",
     {"type": "object", "properties": {
         "recipeId": {"type": "string", "description": "精确配方 id"},
         "result": {"type": "string", "description": "按产物物品名子串找第一个"},
         "index": {"type": "integer", "description": "mc_act{action:recipeOptions} 回的序号"},
         "all": {"type": "boolean", "description": "尽量多做几份，默认 true"}}},
     lambda a: tool_action("placeRecipe",
                           {k: a[k] for k in ("recipeId", "result", "index", "all") if k in a},
                           True)),
    ("mc_creative_give", "创造模式拿物品到手（放进指定槽位；不消耗）。",
     {"type": "object", "properties": {
         "item": {"type": "string", "description": "如 minecraft:stone 或 stone"},
         "count": {"type": "integer"}, "slot": {"type": "integer"},
         "record": {"type": "boolean"}},
      "required": ["item"]},
     lambda a: tool_action("creativeGive", {k: a[k] for k in ("item", "count", "slot") if k in a},
                           a.get("record", True))),
    ("mc_act", "长尾动作统一入口。action 取值见 skills/minecraft-api/SKILL.md 的『长尾动作』表。",
     {"type": "object", "properties": {
         "action": {"type": "string", "description":
                    "digStatus / drop / pickItem / startUsing / releaseUsing / stopBreak / "
                    "sleep / wakeUp / respawn / fly / ride / dismount / openInventory / "
                    "clientLevel / recipeOptions / containerButton"},
         "args": {"type": "object", "description": "该动作的参数，如 {\"all\":true}"},
         "record": {"type": "boolean"}},
      "required": ["action"]},
     lambda a: tool_action(a["action"], a.get("args") or {}, a.get("record", True))),

    # ---------------- 工程 ----------------
    ("mc_build", "跑 gradle 构建（默认 build），只回错误行。",
     {"type": "object", "properties": {"target": {"type": "string"}}},
     lambda a: tool_build(a.get("target", ""))),
    ("mc_run", "启动 dev 游戏。action=client/client_auto/server/stop/status。",
     {"type": "object", "properties": {
         "action": {"type": "string", "description": "默认 start_client"},
         "wait": {"type": "number", "description": "等动态服务上线的秒数，默认 180"},
         "extra": {"type": "string", "description": "附加 gradle 参数"}}},
     lambda a: tool_run(a.get("action", "start_client"), a.get("wait", 180), a.get("extra", ""))),

    # ---------------- SKILL ----------------
    ("skill_read", "读 SKILL。which=api（静态归纳）或 runtime（运行时修正）。",
     {"type": "object", "properties": {
         "which": {"type": "string"}, "tail": {"type": "integer"}}},
     lambda a: tool_skill_read(a.get("which", "api"), a.get("tail", 120))),
    ("skill_note", "往运行时 SKILL 追加一节修正（自动带时间戳）。",
     {"type": "object", "properties": {"text": {"type": "string"}}, "required": ["text"]},
     lambda a: tool_skill_note(a["text"])),
]



def spec_tools():
    return [{"name": n, "description": d, "inputSchema": s} for n, d, s, _ in TOOLS_SPEC]


def call_tool(name, args):
    for n, _, _, fn in TOOLS_SPEC:
        if n == name:
            try:
                return fn(args or {}), False
            except Exception as exc:                                  # noqa: BLE001
                return "%s: %s" % (type(exc).__name__, exc), True
    return "未知工具 %s" % name, True


# ---------------------------------------------------------------- 传输
def send(obj):
    sys.stdout.write(json.dumps(obj, ensure_ascii=False) + "\n")
    sys.stdout.flush()


def main():
    for line in sys.stdin:
        line = line.strip()
        if not line:
            continue
        try:
            msg = json.loads(line)
        except json.JSONDecodeError:
            continue
        mid = msg.get("id")
        method = msg.get("method", "")
        if method == "initialize":
            send({"jsonrpc": "2.0", "id": mid, "result": {
                "protocolVersion": PROTOCOL_VERSION,
                "capabilities": {"tools": {}},
                "serverInfo": {"name": "mcmcp", "version": "0.1.0"}}})
        elif method in ("notifications/initialized", "initialized"):
            continue
        elif method == "ping":
            send({"jsonrpc": "2.0", "id": mid, "result": {}})
        elif method == "tools/list":
            send({"jsonrpc": "2.0", "id": mid, "result": {"tools": spec_tools()}})
        elif method == "tools/call":
            params = msg.get("params") or {}
            text, is_err = call_tool(params.get("name", ""), params.get("arguments"))
            send({"jsonrpc": "2.0", "id": mid, "result": {
                "content": [{"type": "text", "text": text}], "isError": is_err}})
        elif mid is not None:
            send({"jsonrpc": "2.0", "id": mid,
                  "error": {"code": -32601, "message": "未实现：" + method}})


if __name__ == "__main__":
    main()
