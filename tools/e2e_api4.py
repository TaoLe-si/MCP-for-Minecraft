#!/usr/bin/env python3
"""e2e_api4.py —— 第五批 API 的运行时核实（统计 / 声音 / 首领条）。

这三条是"感官"类，判据跟前面几批不一样：

  * `stats`   —— 先做一个会产生统计的动作（挖一个方块），再看挖方块统计里有没有它。
                 注意：**统计是服务端裁决的**（`ClientboundAwardStatsPacket`），要等服务端同步。
  * `sounds`  —— 做一个必然发声的动作（挖石头），再看声音流水里有没有对应的声音条目。
  * `bossbars`—— 招一只凋灵（有首领血条），再看首领条列表里有没有它。
                 判据是"渲染时被画出来过"，所以窗口得真的在渲染。

用法：
  python tools/e2e_api4.py
"""

from __future__ import annotations

import argparse
import os
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

from mcmcp import (ControlError, record_measurement, reset_test_state,   # noqa: E402
                   send_packet, tool_skill_note, wait_ready)

RESULTS = []


def check(no, label, status, detail=""):
    RESULTS.append({"no": no, "label": label, "status": status})
    mark = {"strong": "已核", "weak": "弱核对", "fail": "失败"}[status]
    print("  [%s] %-9s %s%s" % (mark, no, label, (" —— " + detail) if detail else ""))
    return status != "fail"


def call(op, args=None, timeout=60):
    return send_packet(op, args or {}, timeout=timeout)


def soft(no, label, op, args=None, timeout=60):
    try:
        return call(op, args, timeout)
    except ControlError as exc:
        check(no, label, "fail", str(exc)[:150])
        return None


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--wait", type=float, default=240.0)
    args = ap.parse_args()

    print("== 准备 ==")
    wait_ready(args.wait)
    reset_test_state(items=("minecraft:diamond_pickaxe 1",))
    st = call("state")
    px, py, pz = int(st["pos"]["x"]), int(st["pos"]["y"]), int(st["pos"]["z"])
    print("  起点 (%.1f, %.1f, %.1f)" % (st["pos"]["x"], st["pos"]["y"], st["pos"]["z"]))

    # ================================================================ 统计
    print("\n== H. 统计（挖一个方块，看统计里有没有它）==")
    # **必须用生存模式挖**：创造模式走 `ServerPlayerGameMode#destroyBlock` 里
    # `isCreative()` 那条提前返回的分支，根本不会调 `Block#playerDestroy`，
    # 也就不会 `awardStat(BLOCK_MINED)` —— 创造模式挖方块不进 mined 统计。
    # （这是实测撞出来的：创造模式挖了半天 stone 计数一直是 0。）
    call("chat", {"text": "/gamemode survival", "command": True})
    call("chat", {"text": "/give @s minecraft:diamond_pickaxe 1", "command": True})
    time.sleep(1.0)
    call("selectSlot", {"slot": 1})   # 清完背包再给，镐子必在第 1 格
    before = soft("H1", "stats{mined}（挖之前）", "stats",
                  {"category": "mined", "filter": "stone"})
    if before:
        n0 = next((x["value"] for x in (before.get("stats") or [])
                   if x["stat"] == "minecraft:stone"), 0)
        check("H1", "stats 能读（挖之前 stone=%d）" % n0, "strong",
              "非零项 %d 条" % before.get("count"))

        # 放一个石头再挖掉（生存挖石头要几 tick，break op 会等挖穿）
        call("chat", {"text": "/setblock %d %d %d minecraft:stone" % (px, py, pz + 2),
                      "command": True})
        time.sleep(0.6)
        call("lookAt", {"x": px + 0.5, "y": py + 0.5, "z": pz + 2.5})
        soft("H2", "break（生存挖掉那个石头）", "break",
             {"x": px, "y": py, "z": pz + 2, "face": "up"}, timeout=120)

        # 统计是服务端同步过来的，得等
        n1 = n0
        for _ in range(20):
            time.sleep(0.3)
            now = call("stats", {"category": "mined", "filter": "stone"})
            n1 = next((x["value"] for x in (now.get("stats") or [])
                       if x["stat"] == "minecraft:stone"), 0)
            if n1 > n0:
                break
        check("H2", "挖完之后 mined/stone 计数变大（回读核对）",
              "strong" if n1 > n0 else "fail",
              "stone %d → %d（统计是服务端回 AwardStats 包才涨的）" % (n0, n1))

    # 自定义统计：游戏时长这类
    cust = soft("H3", "stats{custom}（游戏时长等）", "stats", {"category": "custom", "limit": 8})
    if cust:
        check("H3", "stats{custom} 有内容", "strong" if cust.get("count") else "fail",
              "非零自定义统计 %d 条：%s"
              % (cust.get("count"), [x["stat"] for x in (cust.get("stats") or [])[:4]]))

    # ================================================================ 声音
    print("\n== I. 声音（挖石头必然发声）==")
    call("chat", {"text": "/setblock %d %d %d minecraft:stone" % (px, py, pz + 3),
                  "command": True})
    time.sleep(0.6)
    call("lookAt", {"x": px + 0.5, "y": py + 0.5, "z": pz + 3.5})
    before_sounds = call("sounds", {"limit": 5})
    n_before = before_sounds.get("count", 0)
    soft("I1", "break（挖第二个石头）", "break",
         {"x": px, "y": py, "z": pz + 3, "face": "up"}, timeout=90)
    time.sleep(0.5)
    after_sounds = call("sounds", {"limit": 40})
    block_sounds = [x for x in (after_sounds.get("sounds") or [])
                    if "block.stone" in x["sound"] or "dig" in x["sound"]
                    or "break" in x["sound"]]
    check("I1", "挖石头之后声音流水里出现对应的声音（回读核对）",
          "strong" if block_sounds else "fail",
          "流水 %d 条，含方块声 %d 条：%s"
          % (after_sounds.get("count", 0), len(block_sounds),
             [x["sound"] for x in block_sounds[:4]]))

    # ================================================================ 首领条
    print("\n== J. 首领条（招一只凋灵）==")
    call("chat", {"text": "/kill @e[type=!player]", "command": True})
    time.sleep(0.5)
    call("chat", {"text": "/summon minecraft:wither %d %d %d {NoAI:1b,Invulnerable:1b}"
                          % (px + 3, py + 3, pz), "command": True})
    time.sleep(1.5)
    bars = {}
    for _ in range(20):
        bars = call("bossBars")
        if bars.get("count"):
            break
        time.sleep(0.4)
    check("J1", "凋灵出现后 bossBars 读到它的血条（回读核对）",
          "strong" if bars.get("count") else "fail",
          "首领条 %d 条：%s" % (bars.get("count"),
                               [(x.get("name"), x.get("progress"))
                                for x in (bars.get("bossBars") or [])]))
    call("chat", {"text": "/kill @e[type=!player]", "command": True})
    time.sleep(1.5)
    gone = call("bossBars")
    check("J2", "清掉之后首领条消失（回读核对）",
          "strong" if not gone.get("count") else "fail",
          "剩余 %d 条" % gone.get("count"))

    # ================================================================ 汇总
    strong = [r for r in RESULTS if r["status"] == "strong"]
    weak = [r for r in RESULTS if r["status"] == "weak"]
    fail = [r for r in RESULTS if r["status"] == "fail"]
    record_measurement({"kind": "e2e_api4", "results": RESULTS,
                        "summary": {"strong": len(strong), "weak": len(weak),
                                    "fail": len(fail)}})
    print("\n==== 汇总：%d 条 —— 回读核对 %d，弱核对 %d，失败 %d ===="
          % (len(RESULTS), len(strong), len(weak), len(fail)))
    if fail:
        print("失败项：" + "、".join(r["label"] for r in fail))

    tool_skill_note(
        "**第五批 API 运行时核实**（`python tools/e2e_api4.py`，共 %d 条）："
        "回读核对 %d，弱核对 %d，失败 %d。\n\n"
        "%s\n"
        "- `stats`：挖一个方块之后 `mined/minecraft:stone` 计数真的涨了 —— "
        "注意统计是**服务端回 AwardStats 包**才涨的，读之前要等。\n"
        "- `sounds`：挖石头之后声音流水里确实出现了对应的方块声（挂 `PlaySoundEvent` 抄的）。\n"
        "- `bossBars`：招出凋灵后读到它的血条，清掉之后消失 —— "
        "判据是渲染时被画出来过（`BossHealthOverlay:36` 发的 `CustomizeGuiOverlayEvent.BossEventProgress`）。\n"
        "- 原始记录：`measurements.jsonl` 的 `kind=e2e_api4`。"
        % (len(RESULTS), len(strong), len(weak), len(fail),
           "失败项：" + "、".join(r["label"] for r in fail) if fail else "无失败项。"))
    print("已回写 skills/minecraft-runtime/SKILL.md")
    return 1 if fail else 0


if __name__ == "__main__":
    sys.exit(main())
