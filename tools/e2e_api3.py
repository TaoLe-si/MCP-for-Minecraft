#!/usr/bin/env python3
"""e2e_api3.py —— 第三/四批 API 的运行时核实（交易、进度、世界设定、实体）。

重点验的两条"以为自己懂、其实不懂"的东西：

  1. **跟村民交易**：原版点交易按钮是三步（`setSelectionHint` + `tryMoveItems` +
     发 `ServerboundSelectTradePacket`）。少做第二步，付款槽是空的，点结果槽毫无反应 ——
     这种"看着像没反应"最难查。本脚本用一笔**用 NBT 写死的交易**（1 绿宝石 → 3 面包）
     来验：成交后背包里必须真的多出面包。
  2. **进度**：单机读服务端权威进度（客户端那份 progress 是私有字段）。
     先 `/advancement grant` 一个已知进度，再读回来核对。

用法：
  python tools/e2e_api3.py
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

# 一笔写死的交易：1 个绿宝石换 3 个面包。写死是为了确定性 —— 让村民自己生成职业
# 和交易的话，每次跑出来的东西都不一样，判据就没法写。
VILLAGER_NBT = ('{NoAI:1b,Silent:1b,'
                'VillagerData:{type:"minecraft:plains",profession:"minecraft:farmer",level:1},'
                'Offers:{Recipes:[{buy:{id:"minecraft:emerald",Count:1b},'
                'sell:{id:"minecraft:bread",Count:3b},maxUses:12,uses:0,rewardExp:1b,'
                'priceMultiplier:0.0f,xp:1}]}}')


def check(no, label, status, detail=""):
    RESULTS.append({"no": no, "label": label, "status": status})
    mark = {"strong": "已核", "weak": "弱核对", "fail": "失败"}[status]
    print("  [%s] %-8s %s%s" % (mark, no, label, (" —— " + detail) if detail else ""))
    return status != "fail"


def call(op, args=None, timeout=60):
    return send_packet(op, args or {}, timeout=timeout)


def soft(no, label, op, args=None, timeout=60):
    try:
        return call(op, args, timeout)
    except ControlError as exc:
        check(no, label, "fail", str(exc)[:150])
        return None


def count_of(inv, item_sub):
    return sum(x.get("count", 0) for x in (inv.get("slots") or [])
               if item_sub in (x.get("item") or ""))


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--wait", type=float, default=240.0)
    args = ap.parse_args()

    print("== 准备 ==")
    wait_ready(args.wait)
    reset_test_state()
    call("chat", {"text": "/kill @e[type=!player]", "command": True})
    call("chat", {"text": "/time set noon", "command": True})
    call("chat", {"text": "/weather clear", "command": True})
    time.sleep(1.0)
    st = call("state")
    px, py, pz = int(st["pos"]["x"]), int(st["pos"]["y"]), int(st["pos"]["z"])
    print("  起点 (%.1f, %.1f, %.1f)" % (st["pos"]["x"], st["pos"]["y"], st["pos"]["z"]))

    # ================================================================ D. 世界设定
    print("\n== D. 世界设定（发命令 + 回读）==")
    w0 = call("world")
    sw = soft("D1", "setWorld（改成夜里 + 下雨 + 困难）", "setWorld",
              {"time": "midnight", "weather": "rain", "difficulty": "hard"})
    if sw:
        time.sleep(1.5)
        w1 = call("world")
        ok_time = w1.get("dayTime") != w0.get("dayTime")
        ok_rain = w1.get("raining") is True
        check("D1", "setWorld 之后时间/天气都真的变了（回读核对）",
              "strong" if ok_time and ok_rain else "fail",
              "dayTime %s→%s  下雨 %s→%s  难度 %s→%s"
              % (w0.get("dayTime"), w1.get("dayTime"), w0.get("raining"),
                 w1.get("raining"), w0.get("difficulty"), w1.get("difficulty")))
        # 收拾回来，别影响后面的用例
        call("setWorld", {"time": "noon", "weather": "clear", "difficulty": "peaceful"})
        time.sleep(0.8)

    # ================================================================ E. 实体
    print("\n== E. 实体：生成 / 命名 / 清理 ==")
    st = call("state")
    px, py, pz = int(st["pos"]["x"]), int(st["pos"]["y"]), int(st["pos"]["z"])
    sp = soft("E9", "spawn（招一只猪）", "spawn",
              {"entity": "minecraft:pig", "x": px + 0.5, "y": py, "z": pz + 3.5})
    if sp:
        time.sleep(1.0)
        ents = call("entities", {"radius": 16})
        pigs = [e for e in (ents.get("entities") or []) if "pig" in e["type"]]
        check("E9", "spawn 之后 entities 里真的有猪（回读核对）",
              "strong" if pigs else "fail",
              "附近实体 %d 个，猪 %d 只" % (ents.get("count"), len(pigs)))

        if pigs:
            pig_id = pigs[0]["id"]
            nt = soft("E10", "nameTag（给猪改名 MCP-PIG）", "nameTag",
                      {"entityId": pig_id, "name": "MCP-PIG", "visible": True})
            if nt:
                time.sleep(0.3)
                ed = call("entity", {"entityId": pig_id})
                check("E10", "nameTag 之后实体名字变了（回读核对）",
                      "strong" if ed.get("customName") == "MCP-PIG" else "fail",
                      "customName=%s" % ed.get("customName"))

            kl = soft("E11", "kill（清掉这只猪）", "kill", {"entityId": pig_id})
            if kl:
                time.sleep(1.2)
                ents2 = call("entities", {"radius": 16})
                pigs2 = [e for e in (ents2.get("entities") or []) if "pig" in e["type"]]
                check("E11", "kill 之后猪没了（回读核对）",
                      "strong" if not pigs2 else "fail",
                      "剩余猪 %d 只" % len(pigs2))

    # ================================================================ F. 进度
    print("\n== F. 进度（单机读服务端权威进度）==")
    call("chat", {"text": "/advancement revoke @s only minecraft:story/root",
                  "command": True})
    time.sleep(0.5)
    adv0 = soft("F1", "advancements（未完成时）", "advancements",
                {"filter": "story/root"})
    if adv0:
        if not adv0.get("available"):
            check("F1", "advancements 可用性", "fail", adv0.get("note"))
        else:
            got0 = [a for a in (adv0.get("advancements") or [])
                    if a["id"] == "minecraft:story/root"]
            check("F1", "读到了 story/root 且未完成",
                  "strong" if got0 and not got0[0]["done"] else "fail",
                  "found=%d done=%s" % (len(got0), got0[0]["done"] if got0 else None))
            call("chat", {"text": "/advancement grant @s only minecraft:story/root",
                          "command": True})
            time.sleep(0.8)
            adv1 = call("advancements", {"filter": "story/root"})
            got1 = [a for a in (adv1.get("advancements") or [])
                    if a["id"] == "minecraft:story/root"]
            check("F2", "grant 之后读回 completed=True（回读核对）",
                  "strong" if got1 and got1[0]["done"] else "fail",
                  "done=%s percent=%s" % (got1[0]["done"] if got1 else None,
                                          got1[0]["percent"] if got1 else None))

    # ================================================================ G. 交易
    print("\n== G. 交易（原版三步：选中 / 挪付款物 / 告知服务端）==")
    call("chat", {"text": "/give @s minecraft:emerald 8", "command": True})
    time.sleep(0.8)
    call("chat", {"text": '/summon minecraft:villager %d %d %d %s'
                          % (px + 1, py, pz + 2, VILLAGER_NBT), "command": True})
    time.sleep(1.2)
    ents = call("entities", {"radius": 16})
    villagers = [e for e in (ents.get("entities") or []) if "villager" in e["type"]]
    check("G0", "村民已就位", "strong" if villagers else "fail",
          "村民 %d 个" % len(villagers))
    if not villagers:
        print("       服务端回话：%s" % [x["text"] for x in
                                        (call("chatlog", {"lines": 3}).get("chatlog") or [])])
    else:
        opened = soft("G1", "useOnEntity{awaitScreen} 打开交易界面", "useOnEntity",
                      {"entityId": villagers[0]["id"], "awaitScreen": True, "ticks": 60})
        if opened:
            scr = call("screen")
            check("G1", "交易界面真的开出来了", "strong"
                  if scr.get("open") and "Merchant" in (scr.get("class") or "") else "fail",
                  "界面 %s" % scr.get("class"))

            tr = soft("G2", "trades（列这笔写死的交易）", "trades")
            if tr:
                offers = tr.get("trades") or []
                first = offers[0] if offers else {}
                check("G2", "读到 1 绿宝石换 3 面包那笔",
                      "strong" if offers and "emerald" in (first.get("costA") or {}).get(
                          "item", "") and "bread" in (first.get("result") or {}).get(
                          "item", "") else "fail",
                      "共 %d 笔，第 0 笔 %s → %s x%s"
                      % (len(offers), (first.get("costA") or {}).get("item"),
                         (first.get("result") or {}).get("item"),
                         (first.get("result") or {}).get("count")))

                bread_before = count_of(call("inventory"), "bread")
                emerald_before = count_of(call("inventory"), "emerald")
                # 成交要用 Shift+左键（QUICK_MOVE）：PICKUP 点结果槽是把产物挂在**光标**上、
                # 不进背包 —— 实测踩过：成交了、宝石扣了、面包一个没进包
                td = soft("G3", "trade（Shift 左键成交一笔）", "trade", {"index": 0})
                if td:
                    time.sleep(1.2)
                    inv = call("inventory")
                    bread_after = count_of(inv, "bread")
                    check("G3", "成交之后背包里真的多了面包（回读核对）",
                          "strong" if bread_after >= bread_before + 3 else "fail",
                          "面包 %d → %d，绿宝石 %d → %d，付款槽剩 %s，成交 %s 次"
                          % (bread_before, bread_after, emerald_before,
                             count_of(inv, "emerald"),
                             td.get("paymentLeftInSlots"), td.get("times")))
            if call("screen").get("open"):
                call("closeScreen")

    # ================================================================ 收尾
    strong = [r for r in RESULTS if r["status"] == "strong"]
    weak = [r for r in RESULTS if r["status"] == "weak"]
    fail = [r for r in RESULTS if r["status"] == "fail"]
    record_measurement({"kind": "e2e_api3", "results": RESULTS,
                        "summary": {"strong": len(strong), "weak": len(weak),
                                    "fail": len(fail)}})

    print("\n==== 汇总：%d 条 —— 回读核对 %d，弱核对 %d，失败 %d ===="
          % (len(RESULTS), len(strong), len(weak), len(fail)))
    if fail:
        print("失败项：" + "、".join(r["label"] for r in fail))

    tool_skill_note(
        "**第三/四批 API 运行时核实**（`python tools/e2e_api3.py`，共 %d 条）："
        "回读核对 %d，弱核对 %d，失败 %d。\n\n"
        "%s\n"
        "- 交易那条是重点：原版点交易按钮要三步（`setSelectionHint` + **`tryMoveItems`** + "
        "发 `ServerboundSelectTradePacket`），少第二步付款槽是空的、点结果槽毫无反应。"
        "这里用一笔 NBT 写死的交易（1 绿宝石 → 3 面包）验，成交后**背包里真的多了 3 个面包**。\n"
        "- 进度那条：单机读服务端权威进度（客户端那份 progress 是私有字段且会被成就界面抢监听器）。\n"
        "- 原始记录：`measurements.jsonl` 的 `kind=e2e_api3`。"
        % (len(RESULTS), len(strong), len(weak), len(fail),
           "失败项：" + "、".join(r["label"] for r in fail) if fail else "无失败项。"))
    print("已回写 skills/minecraft-runtime/SKILL.md")
    return 1 if fail else 0


if __name__ == "__main__":
    sys.exit(main())
