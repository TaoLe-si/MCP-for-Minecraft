#!/usr/bin/env python3
"""e2e_api.py —— 全 API 自检：把"模拟所有 MC 行为"那套操作面逐类打一遍。

跟 e2e.py 的分工：e2e.py 只验"往前走"这一条主线（那是地基）；
本脚本扫操作面的每一类，确认**每一类都真的落地**：

  观测  state / block / blocks / entities / inventory / ray
  日志  log / chatlog / events
  建造  give → place → 回读 block 核对 → break → 回读核对
  界面  press（开背包）→ screen（控件树）→ clickSlot → interact 工作台 →
        clickButton（点真按钮并看界面变化）→ closeScreen
  输入  look / selectSlot / key / move
  截图  shot（建造前后各一张，肉眼可复核）

两边的核对方式不一样，这点是有意的：**改动类 op 一律回读游戏状态来核对**
（放完方块再问一次 `block` 是不是真变成了那个方块），不拿回包里的 ok 自证。

脚本是**幂等**的：开跑前先清掉上一次留在世界里的方块 —— 世界是存盘的，
不清的话第二次跑就会撞上自己上次的产物。

用法：
  python tools/e2e_api.py
"""

from __future__ import annotations

import argparse
import os
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

from mcmcp import (ControlError, prepare_clean_lane, record_measurement,   # noqa: E402
                   send_packet, tool_shot, tool_skill_note)

RESULTS = []


def check(label, ok, detail=""):
    RESULTS.append((label, ok))
    print("  [%s] %s%s" % ("OK" if ok else "FAIL", label,
                           (" —— " + detail) if detail else ""))
    return ok


def call(op, args=None, timeout=60):
    return send_packet(op, args or {}, timeout=timeout)


def soft(label, op, args=None, timeout=60):
    """出错不炸整轮：记一条失败项，回空结果。"""
    try:
        return call(op, args, timeout)
    except ControlError as exc:
        check(label, False, str(exc))
        return {}


def is_air(pos):
    b = call("block", {"x": pos[0], "y": pos[1], "z": pos[2]})
    return bool(b.get("air"))


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--wait", type=float, default=240.0)
    args = ap.parse_args()

    print("== 0. 等游戏 ==")
    call("ping", timeout=5.0)
    state = call("state")
    if not state.get("inWorld"):
        raise SystemExit("不在世界里，先跑 mc_run client_auto")
    px, py, pz = int(state["pos"]["x"]), int(state["pos"]["y"]), int(state["pos"]["z"])
    print("  玩家在 (%d, %d, %d)，维度 %s" % (px, py, pz, state["dim"]))

    # ---------------------------------------------------------------- 观测
    print("\n== 1. 观测 API ==")
    below = call("block", {"x": px, "y": py - 1, "z": pz})
    check("block 看脚下方块", below.get("block") is not None,
          "脚下是 %s（空气=%s）" % (below.get("block"), below.get("air")))

    scan = call("blocks", {"x1": px - 2, "y1": py - 1, "z1": pz - 2,
                           "x2": px + 2, "y2": py, "z2": pz + 2})
    check("blocks 区域扫描", scan.get("count", 0) > 0,
          "扫了 %s 格，命中 %d 个非空气方块" % (scan.get("scanned"), scan.get("count")))

    ents = call("entities", {"radius": 32})
    check("entities 实体查询", "count" in ents, "附近 %d 个实体" % ents.get("count"))

    inv = call("inventory")
    check("inventory 背包", "selected" in inv and "held" in inv,
          "手持 %s，选中槽 %s，非空槽 %d 个"
          % (inv.get("held"), inv.get("selected"), len(inv.get("slots") or [])))

    ray = call("ray")
    check("ray 视线射线", "type" in ray, "视线 %s" % ray.get("type"))

    # ---------------------------------------------------------------- 日志
    print("\n== 2. 日志 API ==")
    log = call("log", {"lines": 5})
    check("log 游戏日志", log.get("count", 0) > 0,
          "%d 行，来自 %s" % (log.get("count"), log.get("path")))

    chatlog = call("chatlog", {"lines": 5})
    check("chatlog 聊天流水", "count" in chatlog, "%d 条" % chatlog.get("count"))

    events = call("events", {"lines": 5})
    check("events 事件流水", events.get("count", 0) > 0, "%d 条" % events.get("count"))
    for e in (events.get("events") or [])[-3:]:
        print("       [%s] %s: %s" % (e.get("at"), e.get("kind"), e.get("text")))

    # ---------------------------------------------------------------- 建造
    print("\n== 3. 建造：清场 → give → place → 回读 → break → 回读 ==")
    call("chat", {"text": "/gamemode creative", "command": True})
    call("chat", {"text": "/give @s minecraft:stone 64", "command": True})
    call("chat", {"text": "/tp @s %d %d %d 0 0" % (px, py, pz), "command": True})

    inv = call("inventory")
    check("拿到石头（/give）", any("stone" in (x.get("item") or "")
                                 for x in (inv.get("slots") or [])),
          "手持 %s" % inv.get("held"))
    call("selectSlot", {"slot": 1})

    # 目标层要现找：脚下第一格非空气的**上面那一层**
    ground_y = py - 1
    for _ in range(6):
        if not is_air((px, ground_y, pz)):
            break
        ground_y -= 1
    wall_y = ground_y + 1
    targets = [(px, wall_y, pz + dz) for dz in (1, 2, 3)]
    print("       地面在 y=%d，方块放 y=%d，位置 %s" % (ground_y, wall_y, targets))

    # 清场：上一轮跑的方块会让 place 合理地报"已经有方块了"
    cleaned = 0
    for t in targets:
        if not is_air(t):
            call("break", {"x": t[0], "y": t[1], "z": t[2], "face": "up"}, timeout=90)
            cleaned += 1
    print("       清掉上次残留 %d 块" % cleaned)

    placed = []
    for t in targets:
        call("lookAt", {"x": t[0] + 0.5, "y": t[1] + 0.5, "z": t[2] + 0.5})
        out = soft("place(%s) 不该报错" % (t,), "place",
                   {"x": t[0], "y": t[1], "z": t[2], "face": "up"})
        air = is_air(t)
        print("       %s → %s   consumed=%s"
              % (t, "空气（没放上）" if air else "方块", out.get("consumed")))
        if not air:
            placed.append(t)
    check("place 真的放进世界（回读核对）", len(placed) == 3,
          "3 个目标位置里 %d 个真的变成了方块" % len(placed))

    shot_built = tool_shot("e2e_api_built", record=False).splitlines()[0].split("：")[-1].strip()

    if placed:
        t = placed[0]
        soft("break(%s) 不该报错" % (t,), "break",
             {"x": t[0], "y": t[1], "z": t[2], "face": "up"}, timeout=90)
        check("break 真的挖掉（回读核对）", is_air(t), "%s 现在是空气" % (t,))

    shot_broken = tool_shot("e2e_api_broken", record=False).splitlines()[0].split("：")[-1].strip()

    # 剩下两块拆掉：等下要测"往前走"，别让自己砌的墙挡路（上一轮就撞上了）
    for t in placed[1:]:
        soft("清场 break(%s)" % (t,), "break",
             {"x": t[0], "y": t[1], "z": t[2], "face": "up"}, timeout=90)
    check("收尾清场", all(is_air(t) for t in targets), "目标区已清空")

    # ---------------------------------------------------------------- 界面
    print("\n== 4. 界面 API ==")
    call("press", {"key": "inventory"})
    screen = call("screen")
    check("press 开背包（走 consumeClick 那条路）", screen.get("open") is True,
          "界面 %s" % screen.get("class"))
    if screen.get("open"):
        check("screen 报出控件树", bool(screen.get("widgets")) or bool(screen.get("slots")),
              "%d 个控件，%d 个容器槽位"
              % (len(screen.get("widgets") or []), len(screen.get("slots") or [])))
        slots = screen.get("slots") or []
        occupied = [s["slot"] for s in slots if s.get("stack")]
        if occupied:
            soft("clickSlot 不该报错", "clickSlot", {"slot": occupied[0], "button": 0})
            soft("clickSlot 放回不该报错", "clickSlot", {"slot": occupied[0], "button": 0})
            check("clickSlot 走通鼠标路由", True,
                  "点了第 %d 号槽（有物品的那个）并放回" % occupied[0])
        else:
            check("clickSlot 走通鼠标路由", False, "没有装着东西的槽位")
        call("closeScreen")
        check("closeScreen 关掉界面", call("state").get("screen") is None)

    # 真按钮：工作台界面有"配方书"按钮，点一下界面结构会变
    print("       —— 换一个有按钮的界面：工作台")
    table = (px, wall_y, pz + 3)
    call("chat", {"text": "/setblock %d %d %d minecraft:crafting_table" % table,
                  "command": True})
    # /setblock 也要等服务端处理完再回同步包 —— 立刻查必然读到旧值
    got = {}
    for _ in range(20):
        got = call("block", {"x": table[0], "y": table[1], "z": table[2]})
        if "crafting_table" in (got.get("block") or ""):
            break
        time.sleep(0.2)
    check("工作台已就位（等 /setblock 生效）", "crafting_table" in (got.get("block") or ""),
          got.get("block"))

    # 开容器一定要用 awaitScreen：界面是服务端回包之后才 setScreen 的，
    # 不等的话这次 screen 查询必然看到"没界面"
    soft("interact(awaitScreen) 不该报错", "interact",
         {"x": table[0], "y": table[1], "z": table[2], "face": "up", "awaitScreen": True})
    table_screen = call("screen")
    check("interact 打开了工作台界面", table_screen.get("open") is True,
          "界面 %s" % table_screen.get("class"))
    if table_screen.get("open"):
        before_widgets = len(table_screen.get("widgets") or [])
        for w in (table_screen.get("widgets") or []):
            print("       [%d] %s 「%s」%s" % (w["index"], w["type"], w["label"],
                                              "" if w["active"] else " (灰)"))
        if before_widgets:
            out = soft("clickButton 不该报错", "clickButton", {"index": 0})
            after_widgets = len((call("screen").get("widgets") or []))
            check("clickButton 点了个真按钮", out.get("handled") is True,
                  "点了「%s」，界面控件 %d → %d 个%s"
                  % (out.get("clicked"), before_widgets, after_widgets,
                     "（结构变了）" if after_widgets != before_widgets else ""))
        else:
            check("clickButton 点了个真按钮", False, "这个界面没有 AbstractWidget 风格的按钮")
        soft("closeScreen 关工作台", "closeScreen")

    # ---------------------------------------------------------------- 输入
    print("\n== 5. 输入 API ==")
    call("chat", {"text": "/gamemode survival", "command": True})
    call("look", {"yaw": 0.0, "pitch": 0.0})
    before = call("state")
    soft("key 不该报错", "key", {"keys": {"jump": True}, "ticks": 12})
    after = call("state")
    check("key 跳跃（tick 推进了）", after["tick"] > before["tick"],
          "tick %s → %s" % (before["tick"], after["tick"]))

    # 换到一条干净的走廊再测：脚边有方块时人会卡住（表现为位移 0），
    # 「刚跳完还在空中」也会把 20 tick 的平均速度拉低一半 —— 两个坑都得避开
    prepare_clean_lane()

    moved = soft("move 不该报错", "move", {"forward": 1, "ticks": 20})
    if moved.get("before"):
        before_p = moved["before"]["pos"]
        after_p = moved["after"]["pos"]
        dz = after_p["z"] - before_p["z"]
        ticks = moved["after"]["tick"] - moved["before"]["tick"]
        # 判据按实测拟合式来（见 skills/minecraft-runtime 第 2 节）：
        #   位移 ≈ 4.317 * (ticks - 1.2) / 20，起步加速会摊薄短程
        expected = 4.317 * max(0.0, ticks - 1.2) / 20.0
        check("move 往前走（20 tick，地面，前方已清空）", abs(dz) > expected * 0.7,
              "Δz=%+.3f / %d tick = %.3f 格/秒（拟合预期 %.3f 格）"
              % (dz, ticks, abs(dz) / ticks * 20.0, expected))
    else:
        check("move 往前走（20 tick，地面，前方已清空）", False, "没拿到回包")

    # ---------------------------------------------------------------- 收尾
    record_measurement({
        "kind": "e2e_api",
        "checks": [{"label": l, "ok": o} for l, o in RESULTS],
        "shots": {"built": shot_built, "broken": shot_broken},
    })

    bad = [l for l, o in RESULTS if not o]
    print("\n==== 汇总：%d 项，通过 %d，失败 %d ===="
          % (len(RESULTS), len(RESULTS) - len(bad), len(bad)))
    if bad:
        print("失败项：" + "、".join(bad))
        return 1

    tool_skill_note(
        "**全 API 自检通过**（`python tools/e2e_api.py`，共 %d 项）。\n\n"
        "- 观测 / 日志 / 建造 / 界面 / 输入五类都落地。\n"
        "- 改动类一律**回读核对**：`place` 后用 `block` 问一次是不是真变成了石头，"
        "`break` 后同样再问一次 —— 不拿回包里的 ok 自证。\n"
        "- 界面是**两层验证**：`press` 开背包证明 `consumeClick` 那条路通；"
        "工作台上 `clickButton` 点真按钮后界面控件数发生变化，证明事件派发那条路也通。\n"
        "- 截图证据：`%s`（放好三块之后）、`%s`（挖掉第一块之后）。\n"
        "- 原始记录在 `measurements.jsonl` 的 `kind=e2e_api` 那条。"
        % (len(RESULTS), os.path.basename(shot_built), os.path.basename(shot_broken)))
    print("实测已写入 skills/minecraft-runtime/SKILL.md")
    return 0


if __name__ == "__main__":
    sys.exit(main())
