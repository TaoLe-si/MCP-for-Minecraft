#!/usr/bin/env python3
"""e2e.py —— 端到端自检：**发一个往前走的包，验证游戏内真的往前走了**。

这是本仓库的验收动作。判据不只看 ok=true（那只说明包送到了），而是：

  1. 位移：`move` 回包里 after.pos - before.pos 的模长要够大，方向要跟朝向对得上；
  2. tick：after.tick - before.tick 要跟请求的 ticks 对得上（允许差 1~2）；
  3. 画面：前后两张截图必须有可观差异（人往前走，屏幕上的东西会挪）。

三条都过才算"往前走"成立，然后把实测写进 skills/minecraft-runtime/SKILL.md。
任何一条不过就非零退出，并且把原始回包打出来 —— 失败要能复盘。

用法：
  python tools/e2e.py            # 游戏要先跑着（mc_run client_auto）
  python tools/e2e.py --ticks 60
"""

from __future__ import annotations

import argparse
import os
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

from mcmcp import (ControlError, fmt_delta, prepare_clean_lane,   # noqa: E402
                   record_measurement, send_packet, tool_diff, tool_shot,
                   tool_skill_note)

TICKS = 40


def wait_alive(seconds):
    deadline = time.time() + seconds
    last = None
    while time.time() < deadline:
        try:
            return send_packet("ping", timeout=5.0)
        except ControlError as exc:
            last = exc
            time.sleep(2.0)
    raise SystemExit("等不到游戏：%s\n（先用 mc_run 把 dev 客户端跑起来）" % last)


def wait_world(seconds):
    deadline = time.time() + seconds
    while time.time() < deadline:
        r = send_packet("ping", timeout=5.0)
        if r.get("inWorld"):
            return r
        time.sleep(2.0)
    raise SystemExit("游戏在跑，但一直没进世界（自动建世界失败了？看 artifacts/game.log）")


def check(label, ok, detail):
    print("  [%s] %s —— %s" % ("OK" if ok else "FAIL", label, detail))
    return ok


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--ticks", type=int, default=TICKS)
    ap.add_argument("--wait", type=float, default=240.0, help="等游戏起来的秒数")
    args = ap.parse_args()

    print("== 1. 等游戏和动态服务 ==")
    ping = wait_alive(args.wait)
    print("  在线：side=%s tick=%s" % (ping.get("side"), ping.get("tick")))
    wait_world(args.wait)
    print("  已进世界")

    print("\n== 2. 清出干净走廊，摆正朝向，拍『之前』 ==")
    # 必须先清场：脚边有方块时人会卡住，表现为"位移 0"，极易误判成按键坏了
    prepare_clean_lane()
    print("  走廊已清空，玩家已站到起点")
    before = send_packet("state")
    shot_a = tool_shot("e2e_before", record=False).splitlines()[0].split("：")[-1].strip()
    print("  起点 %s  朝向 yaw=%.1f" % (before["pos"], before["rot"]["yaw"]))

    print("\n== 3. 发一个往前走的包（forward=1, ticks=%d）==" % args.ticks)
    result = send_packet("move", {"forward": 1, "ticks": args.ticks},
                         timeout=30 + args.ticks // 20)
    after = result["after"]
    delta = fmt_delta(result["before"], after)
    print("  终点 %s" % after["pos"])
    print("  位移 Δ=(%+.3f, %+.3f, %+.3f) 距离=%.3f 格  tick 差=%d  → %.3f 格/秒"
          % (delta["dx"], delta["dy"], delta["dz"], delta["dist"],
             delta["ticks"], delta["blocks_per_second"] or 0.0))

    print("\n== 4. 拍『之后』并比对画面 ==")
    shot_b = tool_shot("e2e_after", record=False).splitlines()[0].split("：")[-1].strip()
    diff = tool_diff(shot_a, shot_b)
    print("  " + diff)
    changed_pct = float(diff.split("（")[1].split("%")[0]) if "（" in diff else 0.0

    print("\n== 5. 判据 ==")
    ok = True
    ok &= check("包送到", result.get("applied", {}).get("forward") is True,
                "applied=%s" % result.get("applied"))
    ok &= check("走了有距离", delta["dist"] > 1.0, "距离 %.3f 格（>1.0 才算真动了）" % delta["dist"])
    ok &= check("tick 对得上", abs(delta["ticks"] - args.ticks) <= 3,
                "请求 %d，实测 %d" % (args.ticks, delta["ticks"]))
    ok &= check("没被地形带偏（y 基本不动）", abs(delta["dy"]) < 0.5,
                "Δy=%+.3f" % delta["dy"])
    ok &= check("方向对（yaw=0 应当往 +Z）", delta["dz"] > 0 and abs(delta["dx"]) < 0.5,
                "Δx=%+.3f Δz=%+.3f" % (delta["dx"], delta["dz"]))
    ok &= check("画面变了", changed_pct > 5.0, "变化像素占比 %.2f%%" % changed_pct)

    entry = {"kind": "e2e_move", "ticks": args.ticks, "before": result["before"],
             "after": after, "delta": delta, "screen_changed_pct": changed_pct}
    path = record_measurement(entry)

    if ok:
        tool_skill_note(
            "**实测：`move` forward=1 / ticks=%d 有效。**\n\n"
            "- 起点 %s → 终点 %s\n"
            "- 位移 %.3f 格（Δx=%+.3f, Δy=%+.3f, Δz=%+.3f），%d tick，**%.3f 格/秒**\n"
            "- 前后截图变化 %.2f%%\n"
            "- 原始记录：%s\n\n"
            "静态 SKILL 第 4 节把『走路速度』标成【待测】的那一项，**以本条实测为准**。"
            % (args.ticks, before["pos"], after["pos"], delta["dist"], delta["dx"],
               delta["dy"], delta["dz"], delta["ticks"],
               delta["blocks_per_second"] or 0.0, changed_pct,
               os.path.basename(path)))
        print("\n全部通过。实测已写入 skills/minecraft-runtime/SKILL.md")
        print("截图：%s / %s" % (shot_a, shot_b))
        return 0

    print("\n有判据不过 —— 原始回包：")
    print(result)
    return 1


if __name__ == "__main__":
    sys.exit(main())
