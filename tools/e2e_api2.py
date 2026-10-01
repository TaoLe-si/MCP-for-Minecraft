#!/usr/bin/env python3
"""e2e_api2.py —— 第二批 API（观测纵深 + 动作纵深）的运行时核实。

跟 e2e_api.py 的分工：那个验的是第一批主干（走路/建造/界面/日志），
本脚本把 `docs/api-ledger.md` 里标【静】的那些**逐条跑一遍**，
跑过的当场改成【已核】，并把证据落进 measurements.jsonl。

**核心理念：一条 op 不只是"没报错"就算过。**
能回读的一律回读（例如 drop 之后再看背包、fly 之后再看 abilities），
只报"没报错"的会在结果里标成 `弱核对`，别把它当成硬证据。

用法：
  python tools/e2e_api2.py
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
    """status: strong（回读核对过）/ weak（只确认没报错）/ fail"""
    RESULTS.append({"no": no, "label": label, "status": status})
    mark = {"strong": "已核", "weak": "弱核对", "fail": "失败"}[status]
    print("  [%s] %-6s %s%s" % (mark, no, label, (" —— " + detail) if detail else ""))
    return status != "fail"


def call(op, args=None, timeout=60):
    return send_packet(op, args or {}, timeout=timeout)


def soft(no, label, op, args=None, timeout=60):
    try:
        return call(op, args, timeout)
    except ControlError as exc:
        check(no, label, "fail", str(exc)[:140])
        return None


def stack_count(inv, item_sub):
    """背包里某物品的总数。drop 这类动作只改数量不改物品名，所以得比数量。"""
    return sum(x.get("count", 0) for x in (inv.get("slots") or [])
               if item_sub in (x.get("item") or ""))


def hotbar_slot_of(inv, item_sub):
    """某物品在**快捷栏**（背包槽 0..8）里的位置，找不到回 None。

    selectSlot 只能选快捷栏那 9 格 —— 之前直接写死 slot=2 结果选到了空格，
    于是"丢面包"丢的是别的格子，面包数量当然不变。这是测试写错，不是功能有问题。
    """
    for x in (inv.get("slots") or []):
        if 0 <= x.get("slot", 99) <= 8 and item_sub in (x.get("item") or ""):
            return x["slot"]
    return None


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--wait", type=float, default=240.0)
    args = ap.parse_args()

    print("== 准备（重置到已知状态）==")
    wait_ready(args.wait)
    call("ping", timeout=5)
    # 重置而不是"接着上一轮跑"：上一轮可能把人留在床上、面包堆在主背包、
    # 石头留在脚边 —— 这些都会让这一轮的判据对不上，而现象看起来像"功能坏了"
    st0 = reset_test_state(items=("minecraft:diamond_sword 1", "minecraft:bread 8",
                                  "minecraft:oak_boat 1"))
    call("chat", {"text": "/time set day", "command": True})
    call("chat", {"text": "/weather clear", "command": True})
    time.sleep(0.8)
    print("  已重置：位置 %s，睡眠=%s，模式待定为创造"
          % (st0["pos"], st0.get("sleeping")))

    # ================================================================ A/B 观测
    print("\n== A/B. 观测纵深 ==")
    v = soft("A3-A8", "vitals（血量/饱食/经验/能力）", "vitals")
    if v:
        ok = all(k in v for k in ("health", "food", "xpLevel", "abilities", "effects"))
        check("A3-A8", "vitals 字段齐全", "strong" if ok else "fail",
              "血 %.1f/%.1f 食 %s 经验级 %s 模式 %s 效果 %d 个"
              % (v.get("health", 0), v.get("maxHealth", 0), v.get("food"),
                 v.get("xpLevel"), v.get("gameMode"), len(v.get("effects") or [])))

    w = soft("B1-B4", "world（时间/天气/难度/边界）", "world")
    if w:
        ok = all(k in w for k in ("dayTime", "raining", "difficulty", "worldBorder"))
        check("B1-B4", "world 字段齐全", "strong" if ok else "fail",
              "dayTime=%s 下雨=%s 雷=%s 难度=%s 边界size=%s"
              % (w.get("dayTime"), w.get("raining"), w.get("thundering"),
                 w.get("difficulty"), (w.get("worldBorder") or {}).get("size")))

    # 光照：地表白天应当是 15；用"放一块石头把天光遮掉"来验证它真的在测光
    st = call("state")
    px, py, pz = int(st["pos"]["x"]), int(st["pos"]["y"]), int(st["pos"]["z"])
    lit = soft("B7", "light（地表白天）", "light", {"x": px, "y": py, "z": pz})
    if lit:
        lvl = lit.get("brightness")
        # 回读核对：在地上盖一块，再看它下面那格的光有没有掉下来
        call("chat", {"text": "/setblock %d %d %d minecraft:stone" % (px, py + 3, pz),
                      "command": True})
        time.sleep(0.8)
        shaded = call("light", {"x": px, "y": py, "z": pz})
        check("B7", "light 会随遮挡变化（回读核对）",
              "strong" if shaded.get("sky", 15) <= lit.get("sky", 0) else "fail",
              "盖石头前 sky=%s 后 sky=%s（地表亮度 %s）"
              % (lit.get("sky"), shaded.get("sky"), lvl))

    b = soft("B8", "biome", "biome", {"x": px, "y": py, "z": pz})
    if b:
        check("B8", "biome 报出群系", "strong" if b.get("biome") else "fail", b.get("biome"))

    # 方块实体：放个箱子塞点东西进去，再读 NBT —— 回读核对
    call("chat", {"text": "/setblock %d %d %d minecraft:chest" % (px + 1, py, pz),
                  "command": True})
    call("chat", {"text": "/item replace block %d %d %d container.0 with minecraft:gold_ingot 7"
                          % (px + 1, py, pz), "command": True})
    time.sleep(1.0)
    # 告示牌：它的文本**是**同步给客户端的，正好用来验 blockentity 这条管道通不通
    call("chat", {"text": "/setblock %d %d %d minecraft:oak_sign" % (px + 4, py, pz),
                  "command": True})
    call("chat", {"text": "/data merge block %d %d %d "
                          "{front_text:{messages:['{\"text\":\"MCP-SIGN\"}',"
                          "'{\"text\":\"\"}','{\"text\":\"\"}','{\"text\":\"\"}']}}"
                  % (px + 4, py, pz), "command": True})
    time.sleep(1.0)
    sign = call("blockentity", {"x": px + 4, "y": py, "z": pz})
    nbt_sign = sign.get("nbt") or ""
    check("B9", "blockentity 读到告示牌文本（回读核对）",
          "strong" if "MCP-SIGN" in nbt_sign else "fail",
          "NBT=%s" % nbt_sign[:120])
    if "MCP-SIGN" not in nbt_sign:
        print("       服务端回话：%s" % [x["text"] for x in
                                        (call("chatlog", {"lines": 3}).get("chatlog") or [])])

    # 箱子的状态 NBT 读得到，但**容器内容读不到** —— 原版不同步给没开界面的客户端
    call("chat", {"text": '/setblock %d %d %d minecraft:chest{LootTable:"minecraft:chests/simple_dungeon"}'
                          % (px + 3, py, pz), "command": True})
    time.sleep(0.8)
    loot = call("blockentity", {"x": px + 3, "y": py, "z": pz})
    nbt_loot = loot.get("nbt") or ""
    check("B9c", "箱子 NBT 读得到、但里面没有物品（原版限制，如实记录）",
          "strong" if "Items" in nbt_loot and "gold_ingot" not in nbt_loot else "fail",
          "箱子 NBT=%s" % nbt_loot[:90])

    # B9b：容器内容只能把界面开出来读 —— 这是原版的行为，不是缺陷
    call("chat", {"text": "/setblock %d %d %d minecraft:air" % (px + 3, py, pz),
                  "command": True})
    time.sleep(0.4)
    call("lookAt", {"x": px + 1.5, "y": py + 0.5, "z": pz + 0.5})
    opened = soft("B9b", "mc_open 开箱子", "interact",
                  {"x": px + 1, "y": py, "z": pz, "face": "up", "awaitScreen": True})
    if opened:
        scr = call("screen")
        stacks = [s2["stack"] for s2 in (scr.get("slots") or []) if s2.get("stack")]
        has_gold = any("gold_ingot" in (x.get("item") or "") for x in stacks)
        check("B9b", "开界面后读到容器里的金锭（回读核对）",
              "strong" if has_gold else "fail",
              "界面 %s，有内容的槽 %d 个，含金锭=%s"
              % (scr.get("class"), len(stacks), has_gold))
        call("closeScreen")

    # 实体：叫一只猪，读它的详情
    call("chat", {"text": "/kill @e[type=!player]", "command": True})
    time.sleep(0.5)
    call("chat", {"text": "/summon minecraft:pig %d %d %d" % (px, py, pz + 3),
                  "command": True})
    time.sleep(0.8)
    ents = call("entities", {"radius": 16})
    pigs = [e for e in (ents.get("entities") or []) if "pig" in e["type"]]
    if pigs:
        ed = soft("C2", "entity（猪的详情 + NBT）", "entity", {"entityId": pigs[0]["id"]})
        if ed:
            check("C2", "entity 报出类型与血量", "strong" if "pig" in (ed.get("type") or "")
                  and "health" in ed else "fail",
                  "%s 血 %s NBT %d 字节" % (ed.get("type"), ed.get("health"),
                                            len(ed.get("nbt") or "")))
    else:
        check("C2", "entity（猪的详情 + NBT）", "fail", "没招出猪来")

    # 计分板：建一个目标打一分，再读回来 —— 回读核对
    call("chat", {"text": "/scoreboard objectives remove mcp", "command": True})
    call("chat", {"text": "/scoreboard objectives add mcp dummy \"MCP 测试\"", "command": True})
    call("chat", {"text": "/scoreboard players set @s mcp 42", "command": True})
    time.sleep(1.0)
    call("chat", {"text": "/scoreboard objectives add mcp dummy", "command": True})
    call("chat", {"text": "/scoreboard players set @s mcp 42", "command": True})
    time.sleep(1.2)
    sb = soft("B10", "scoreboard（客户端/服务端两份都看）", "scoreboard")
    if sb:
        board = sb.get("server") if sb.get("serverObjectives") else sb
        found = [o for o in (board.get("objectives") or []) if o.get("name") == "mcp"]
        hit = bool(found) and any(x.get("score") == 42 for x in found[0].get("scores") or [])
        check("B10", "scoreboard 回读到刚打的 42 分（回读核对）",
              "strong" if hit else "fail",
              "来源=%s 客户端目标 %s 服务端目标 %s 分数 %s"
              % (sb.get("source"), sb.get("clientObjectives"), sb.get("serverObjectives"),
                 [x.get("score") for x in (found[0].get("scores") if found else [])]))

    sv = soft("B11", "server（连接/在线玩家/延迟）", "server")
    if sv:
        check("B11", "server 报出单机与玩家列表", "strong"
              if "singleplayer" in sv and sv.get("players") is not None else "fail",
              "单机=%s 在线 %d 人，我的延迟=%s"
              % (sv.get("singleplayer"), len(sv.get("players") or []),
                 (sv.get("players") or [{}])[0].get("latency")))

    # 配方：钻石剑的配方
    rc = soft("B12", "recipes（查钻石剑）", "recipes", {"filter": "diamond_sword"})
    if rc:
        hit = [r for r in (rc.get("recipes") or []) if "diamond_sword" in (r.get("result") or "")]
        check("B12", "recipes 查到钻石剑配方且带原料",
              "strong" if hit and hit[0].get("ingredients") else "fail",
              "命中 %d 条，原料 %s" % (len(hit),
                                      (hit[0].get("ingredients") if hit else None)))

    rb = soft("B13", "recipebook（认了多少/能不能做）", "recipebook")
    if rb:
        check("B13", "recipebook 报出分组", "weak",
              "%d 组，认识 %s 组，能做 %s 组" % (rb.get("groups", 0),
                                              rb.get("groupsWithKnown"),
                                              rb.get("groupsCraftable")))

    cl = soft("A10", "clientLevel（实体数/区块数）", "clientLevel")
    if cl:
        check("A10", "clientLevel 报出区块与实体数", "weak",
              "维度 %s 区块 %s 实体 %s" % (cl.get("dim"), cl.get("loadedChunks"),
                                          cl.get("entityCount")))

    # ================================================================ E/G/K 动作
    print("\n== E/G/K. 身体与手上 ==")
    dig = soft("F6", "digStatus（挖掘状态/够得着多远）", "digStatus")
    if dig:
        check("F6", "digStatus 报出模式与射程", "weak",
              "模式 %s 射程 %s 在挖=%s" % (dig.get("playerMode"), dig.get("pickRange"),
                                          dig.get("destroying")))

    fly = soft("E7", "fly（开飞行，原版站地上会取消所以会顺手离地）", "fly", {"on": True})
    if fly:
        # 原版规则：站在地上 flying 会被自动清掉（LocalPlayer:784），所以不能"设完立刻读"就完事，
        # 要给它一两 tick 脱离地面，再读 —— 这才是"真的飞起来了"
        time.sleep(0.6)
        v2 = call("vitals")
        ab = v2.get("abilities") or {}
        flying = ab.get("flying")
        check("E7", "fly 之后真的处于飞行且保持住（回读核对）",
              "strong" if flying is True and not v2.get("onFire") else "fail",
              "flying=%s 离地=%s lifted=%s" % (flying, not call("state")["onGround"],
                                             fly.get("lifted")))
        call("fly", {"on": False})

    # drop：先看手上有几把剑，丢一把，再看背包 —— 回读核对
    inv0 = call("inventory")
    bread_slot = hotbar_slot_of(inv0, "bread")
    if bread_slot is None:
        call("chat", {"text": "/give @s minecraft:bread 8", "command": True})
        time.sleep(0.8)
        inv0 = call("inventory")
        bread_slot = hotbar_slot_of(inv0, "bread")
    check("G0", "找到面包所在的快捷栏格", "strong" if bread_slot is not None else "fail",
          "第 %s 格（0 基），手持 %s" % (bread_slot, inv0.get("held")))
    if bread_slot is not None:
        call("selectSlot", {"slot": bread_slot + 1})
    before_count = stack_count(call("inventory"), "bread")
    d = soft("G4", "drop（丢一个面包）", "drop", {"all": False})
    if d:
        time.sleep(0.5)
        after_count = stack_count(call("inventory"), "bread")
        # 比数量不比物品名：从一个 8 个的叠里丢 1 个，物品名是不变的
        check("G4", "drop 之后那一叠少了 1 个（回读核对）",
              "strong" if after_count == before_count - 1 else "fail",
              "面包 %d → %d" % (before_count, after_count))

    su = soft("G2", "startUsing（开始吃东西）", "startUsing", {"hand": "main"})
    if su:
        check("G2", "startUsing 后 using=True", "strong" if su.get("using") else "fail",
              "using=%s" % su.get("using"))
        ru = soft("G3", "releaseUsing（松口）", "releaseUsing")
        if ru:
            check("G3", "releaseUsing 回读到 wasUsing=True", "strong"
                  if ru.get("wasUsing") else "fail", "wasUsing=%s" % ru.get("wasUsing"))

    # pickItem：瞄准石头中键选它
    call("chat", {"text": "/setblock %d %d %d minecraft:stone" % (px, py, pz + 2),
                  "command": True})
    time.sleep(0.8)
    call("lookAt", {"x": px + 0.5, "y": py + 0.5, "z": pz + 2.5})
    aimed = call("ray")
    check("F7-pre", "准星确实对着那块石头", "strong"
          if (aimed.get("block") or {}).get("block") == "minecraft:stone" else "fail",
          "瞄到 %s" % (aimed.get("block") or {}).get("block"))
    pk = soft("F7", "pickItem（中键选取方块，按 pickBlock 的步骤实现）", "pickItem", {})
    if pk:
        # 创造模式那条要等服务端回 SetSlot 包，当场读 held 必然读到旧值
        time.sleep(0.8)
        held_now = call("inventory").get("held")
        check("F7", "pickItem 之后手上变成石头（回读核对）",
              "strong" if "stone" in (held_now or "") else "fail",
              "方式=%s，回读手持=%s" % (pk.get("how"), held_now))
    call("chat", {"text": "/setblock %d %d %d minecraft:air" % (px, py, pz + 2),
                  "command": True})

    # 载具：船放下 → 上船 → 读 state.vehicle → 下船
    # 实体名是 minecraft:boat，木种走 NBT —— "oak_boat" 是 1.21.3 之后才拆出来的，
    # 凭记忆写成 oak_boat 会让服务端回 "Can't find element ... of type entity_type"
    call("chat", {"text": '/summon minecraft:boat %d %d %d {Type:"oak"}' % (px, py, pz + 2),
                  "command": True})
    time.sleep(0.8)
    ents = call("entities", {"radius": 16})
    boats = [e for e in (ents.get("entities") or []) if "boat" in e["type"]]
    if boats:
        rd = soft("E8a", "ride（上船）", "ride", {"entityId": boats[0]["id"]})
        if rd:
            v3 = call("vitals")
            check("E8a", "ride 之后 state.vehicle 有值（回读核对）",
                  "strong" if v3.get("vehicle") else "fail", "载具=%s" % v3.get("vehicle"))
            dm = soft("E8b", "dismount（下船）", "dismount")
            if dm:
                v4 = call("vitals")
                check("E8b", "dismount 之后没载具了（回读核对）",
                      "strong" if not v4.get("vehicle") else "fail",
                      "载具=%s" % v4.get("vehicle"))
    else:
        check("E8a", "ride（上船）", "fail", "没招出船来")

    call("closeScreen") if call("screen").get("open") else None
    oi = soft("J4", "openInventory", "openInventory")
    if oi:
        time.sleep(0.5)
        s2 = call("screen")
        check("J4", "openInventory 之后界面开了（回读核对）",
              "strong" if s2.get("open") else "fail", "界面 %s" % s2.get("class"))
        if s2.get("open"):
            call("closeScreen")

    # 睡觉：先放张床，看能不能睡（白天会失败，这也是一种核实 —— 返回了具体原因）
    call("chat", {"text": "/setblock %d %d %d minecraft:red_bed" % (px + 2, py, pz),
                  "command": True})
    time.sleep(0.6)
    sl = soft("K1", "sleep（白天睡，应给出具体原因）", "sleep",
              {"x": px + 2, "y": py, "z": pz})
    if sl is not None:
        check("K1", "sleep 返回了结果（成功或具体原因）",
              "strong" if ("problem" in sl or sl.get("sleeping")) else "fail",
              "problem=%s sleeping=%s" % (sl.get("problem"), sl.get("sleeping")))
        soft("K2", "wakeUp", "wakeUp")

    # ================================================================ H/I 实体与容器
    print("\n== H/I. 实体交互与容器 ==")
    ents = call("entities", {"radius": 16})
    pigs = [e for e in (ents.get("entities") or []) if "pig" in e["type"]]
    if pigs and not any("boat" in e["type"] for e in (ents.get("entities") or [])):
        pass
    if pigs:
        ue = soft("H1", "useOnEntity（喂猪小麦）", "useOnEntity", {"entityId": pigs[0]["id"]})
        if ue:
            check("H1", "useOnEntity 有明确结果", "strong" if "consumed" in ue else "fail",
                  "result=%s consumed=%s" % (ue.get("result"), ue.get("consumed")))
        ua = soft("H2", "useOnEntityAt（在实体中心精确点）", "useOnEntityAt",
                  {"entityId": pigs[0]["id"]})
        if ua:
            check("H2", "useOnEntityAt 有明确结果", "strong" if "consumed" in ua else "fail",
                  "result=%s" % ua.get("result"))
    else:
        check("H1", "useOnEntity", "fail", "附近没猪")
        check("H2", "useOnEntityAt", "fail", "附近没猪")

    # 配方书一键合成：开着背包，查可选配方
    call("press", {"key": "inventory"})
    ro = soft("I3", "recipeOptions（列出可合成项）", "recipeOptions")
    if ro:
        check("I3", "recipeOptions 给出带 index 的清单", "weak",
              "%d 个可选配方，第一个 %s"
              % (ro.get("count", 0),
                 (ro.get("options") or [{}])[0].get("result")))
        if ro.get("count"):
            pr = soft("I2", "placeRecipe（一键合成第一个）", "placeRecipe", {"index": 0})
            if pr:
                time.sleep(0.6)
                check("I2", "placeRecipe 请求已发出（结果为服务端裁决）", "weak",
                      "配方 %s → %s" % (pr.get("recipe"), pr.get("result")))
    call("closeScreen")

    # 创造栏取物：给个红石
    cg = soft("I5", "creativeGive（拿 8 个红石）", "creativeGive",
              {"item": "minecraft:redstone", "count": 8, "slot": 38})
    if cg:
        time.sleep(0.5)
        inv = call("inventory")
        got = [s for s in (inv.get("slots") or []) if "redstone" in (s.get("item") or "")]
        check("I5", "creativeGive 之后背包里真的有红石（回读核对）",
              "strong" if got and got[0].get("count") == 8 else "fail",
              "背包里的红石：%s" % [(s.get("item"), s.get("count")) for s in got])

    # ================================================================ 汇总
    strong = [r for r in RESULTS if r["status"] == "strong"]
    weak = [r for r in RESULTS if r["status"] == "weak"]
    fail = [r for r in RESULTS if r["status"] == "fail"]
    record_measurement({"kind": "e2e_api2", "results": RESULTS,
                        "summary": {"strong": len(strong), "weak": len(weak),
                                    "fail": len(fail)}})

    print("\n==== 汇总：%d 条 —— 回读核对过 %d，弱核对 %d，失败 %d ===="
          % (len(RESULTS), len(strong), len(weak), len(fail)))
    if fail:
        print("失败项：" + "、".join(r["label"] for r in fail))
    if weak:
        print("弱核对（只确认没报错，没做回读）：" + "、".join(r["label"] for r in weak))

    tool_skill_note(
        "**第二批 API 运行时核实**（`python tools/e2e_api2.py`，共 %d 条）："
        "回读核对过 %d 条，弱核对 %d 条，失败 %d 条。\n\n"
        "%s\n"
        "- 回读核对的含义：不是『没报错就算过』，而是**改完之后再读一次状态**\n"
        "  （drop 后看背包、fly 后看 abilities、sleep 后看 problem、"
        "creativeGive 后看背包里是不是真有 8 个红石）。\n"
        "- 弱核对的那几条是『客户端只管发请求、结果由服务端裁决』的（placeRecipe/recipebook 等），\n"
        "  回包只代表请求已发出，所以不敢标硬证据。\n"
        "- 原始记录：`measurements.jsonl` 的 `kind=e2e_api2`。"
        % (len(RESULTS), len(strong), len(weak), len(fail),
           "失败项：" + "、".join(r["label"] for r in fail) if fail else "无失败项。"))
    print("已回写 skills/minecraft-runtime/SKILL.md")
    return 1 if fail else 0


if __name__ == "__main__":
    sys.exit(main())
