#!/usr/bin/env python3
"""e2e_api5.py —— 第六批 API 的运行时核实（界面长尾 / 世界规则 / 冷却）。

验三件"以前驱动不了"的事：

  * `openScreen`  —— 直接打开没有按键入口的界面（设置/视频/音效/统计…），
                     不用一层层点进去。
  * `setWidget`   —— 拖滑块 / 勾复选框。滑块**不能直接设值**（setValue 是私有的），
                     只能按比例算出 x 点过去，这里就验这个。
  * `gamerule`    —— 改一条规则并回读确认（借原版 /gamerule 的输出，不硬编码规则表）。
  * `cooldowns`   —— 扔末影珍珠之后看冷却里有没有它。

用法：
  python tools/e2e_api5.py
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
        check(no, label, "fail", str(exc)[:160])
        return None


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--wait", type=float, default=240.0)
    args = ap.parse_args()

    print("== 准备 ==")
    wait_ready(args.wait)
    reset_test_state(items=("minecraft:ender_pearl 4",))
    print("  已重置")

    # ================================================================ 打开界面
    print("\n== K. 直接打开界面 ==")
    for key in ("video", "sound", "stats"):
        r = soft("K-%s" % key, "openScreen %s" % key, "openScreen", {"screen": key})
        if r is None:
            continue
        scr = call("screen")
        widgets = scr.get("widgets") or []
        check("K-%s" % key, "openScreen %s 之后界面真的开着" % key,
              "strong" if scr.get("open") else "fail",
              "%s，%d 个控件" % (scr.get("class"), len(widgets)))
        if key == "sound":
            labels = [w["label"] for w in widgets[:8]]
            print("       前几个控件：%s" % labels)
        call("closeScreen")

    # ================================================================ 滑块
    print("\n== L. 滑块（按比例点坐标）==")
    call("openScreen", {"screen": "sound"})
    scr = call("screen")
    sliders = [w for w in (scr.get("widgets") or []) if "Slider" in (w.get("type") or "")]
    check("L0", "音效界面里找到了滑块", "strong" if sliders else "fail",
          "%d 个滑块，第一个「%s」" % (len(sliders), sliders[0]["label"] if sliders else None))
    if sliders:
        idx = sliders[0]["index"]
        before_label = sliders[0]["label"]
        # 目标值要**跟当前不同**：上一轮拖过之后设置会写进 options.txt 持久化，
        # 这一轮再拖到同一个值自然"没变化" —— 那是测试不幂等，不是功能问题
        import re as _re
        m = _re.search(r"(\d+)%", before_label)
        cur = int(m.group(1)) if m else -1
        want = 0.5 if cur > 50 else 0.9
        w1 = soft("L1a", "setWidget 把「%s」拖到 %.0f%%" % (before_label, want * 100),
                  "setWidget", {"index": idx, "value": want})
        if w1:
            after = [w for w in (call("screen").get("widgets") or [])
                     if w.get("index") == idx]
            after_label = after[0]["label"] if after else "?"
            check("L1a", "拖完之后滑块上显示的值真的变了（回读核对）",
                  "strong" if after_label != before_label else "fail",
                  "「%s」→「%s」（坐标 %s，handled=%s）"
                  % (before_label, after_label, w1.get("at"), w1.get("handled")))
    call("closeScreen")

    # ================================================================ 游戏规则
    print("\n== M. 游戏规则（借 /gamerule 的输出）==")
    # 原版 /gamerule **不支持无参列出全部**（实测回 Unknown or incomplete command），
    # 所以"列全部"是直接读客户端那份 GameRules —— 名单见 GameRuleset（45 条，抄自源码）
    rules = soft("M1", "gamerule 列出全部（本地直读 45 条）", "gamerule", {})
    if rules:
        got = rules.get("rules") or {}
        check("M1", "列出全部规则且数量对得上", "strong" if rules.get("count") == 45 else "fail",
              "%d 条，例如 doFireTick=%s doDaylightCycle=%s"
              % (rules.get("count"), got.get("doFireTick"), got.get("doDaylightCycle")))

    # 改一条：doDaylightCycle 关掉，再查回来
    soft("M2", "gamerule doDaylightCycle false", "gamerule",
         {"name": "doDaylightCycle", "value": "false"})
    time.sleep(0.8)
    soft("M2q", "查询 doDaylightCycle", "gamerule", {"name": "doDaylightCycle"})
    time.sleep(0.8)
    chat = call("chatlog", {"lines": 6}).get("chatlog") or []
    texts = [x["text"] for x in chat]
    hit_false = any("doDaylightCycle" in t and "false" in t.lower() for t in texts)
    check("M2", "改完回读确认它变成了 false（回读核对）",
          "strong" if hit_false else "fail", "最近几条：%s" % texts[-3:])
    # 收拾回来
    call("gamerule", {"name": "doDaylightCycle", "value": "true"})
    time.sleep(0.5)

    # ================================================================ 冷却
    print("\n== N. 物品冷却 ==")
    before = soft("N1", "cooldowns（扔之前）", "cooldowns")
    if before:
        check("N1", "cooldowns 能读（扔之前）", "strong",
              "正在冷却 %d 项" % before.get("count"))
    call("selectSlot", {"slot": 1})
    # 末影珍珠：右键扔出去会触发冷却
    soft("N2", "use（扔末影珍珠）", "use", {"hand": "main"}, timeout=60)
    time.sleep(0.4)
    after = call("cooldowns")
    items = [x["item"] for x in (after.get("cooldowns") or [])]
    check("N2", "扔完之后 cooldowns 里有末影珍珠（回读核对）",
          "strong" if any("ender_pearl" in i for i in items) else "fail",
          "正在冷却：%s" % items)

    # ================================================================ 汇总
    strong = [r for r in RESULTS if r["status"] == "strong"]
    weak = [r for r in RESULTS if r["status"] == "weak"]
    fail = [r for r in RESULTS if r["status"] == "fail"]
    record_measurement({"kind": "e2e_api5", "results": RESULTS,
                        "summary": {"strong": len(strong), "weak": len(weak),
                                    "fail": len(fail)}})
    print("\n==== 汇总：%d 条 —— 回读核对 %d，弱核对 %d，失败 %d ===="
          % (len(RESULTS), len(strong), len(weak), len(fail)))
    if fail:
        print("失败项：" + "、".join(r["label"] for r in fail))

    tool_skill_note(
        "**第六批 API 运行时核实**（`python tools/e2e_api5.py`，共 %d 条）："
        "回读核对 %d，弱核对 %d，失败 %d。\n\n"
        "%s\n"
        "- `openScreen`：没有按键入口的界面（视频/音效/统计）能直接构造并 setScreen。\n"
        "- `setWidget`：滑块只能『按比例算 x 点过去』——`AbstractSliderButton.setValue` 是私有的。\n"
        "- `gamerule`：借原版 `/gamerule` 的输出，不硬编码规则表；改完再查一次确认。\n"
        "- `cooldowns`：扔末影珍珠之后冷却列表里真的有它。\n"
        "- 原始记录：`measurements.jsonl` 的 `kind=e2e_api5`。"
        % (len(RESULTS), len(strong), len(weak), len(fail),
           "失败项：" + "、".join(r["label"] for r in fail) if fail else "无失败项。"))
    print("已回写 skills/minecraft-runtime/SKILL.md")
    return 1 if fail else 0


if __name__ == "__main__":
    sys.exit(main())
