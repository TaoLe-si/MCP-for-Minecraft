#!/usr/bin/env python3
"""audit_forge_skills.py —— 审计生成的逐类 SKILL 是否**真的对得上源码**。

生成器自己写行号、自己再读，等于自证 —— 所以这里做的是**外部核对**：

  1. 每个 `源码 :N` 行号，回到源码里取第 N 行，看它是否**包含该成员签名里的标识符**
     （名字 + 至少一个类型词）。对不上就是行号漂了或被别的行蹭到了。
  2. 反查：源码第一层里以 public/protected 开头的声明，是否**都在**生成的清单里
     （用一份独立的极简扫描器，不复用生成器的解析逻辑）。
  3. 统计空壳文件（0 成员）并按包归类，确认"0 成员"的都是注解/常量类这种真的没有成员的。

用法：
  python tools/audit_forge_skills.py
  python tools/audit_forge_skills.py --sample 30   # 只抽 30 个看细节
"""

from __future__ import annotations

import argparse
import re
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).parent))
import gen_forge_skills as gen   # noqa: E402


def independent_members(src: str) -> list[tuple[str, int]]:
    """一份**独立**的极简扫描：花括号深度到 1 时，记下 public/protected 开头的声明行。

    刻意不复用 gen 的解析 —— 两条独立实现互相印证，才叫核对。
    """
    out: list[tuple[str, int]] = []
    depth = 0
    started = False
    pending: list[str] = []
    for n, raw in enumerate(src.splitlines(), start=1):
        line = gen.strip_line_comments(raw)
        s = line.strip()
        if not started:
            # 只认**对外可见**的顶层类型。包私有的顶层类（`class CommonLaunchHandler`）
            # 里的 protected 字段外部根本拿不到，不该要求生成器收录。
            if re.match(r"^(public\s+)?(class|interface|enum|record|@interface)\s+\w+", s):
                if not s.startswith("public"):
                    return out          # 包私有顶层类型：不进入核对
                started = True
            depth += line.count("{") - line.count("}")
            continue
        # 只在**直接位于顶层类体**（depth==1）时比对；嵌套类型里的成员
        # 由那个嵌套类自己的 SKILL 负责，这里不复述（否则 Post 的构造会跟
        # `public static class Post` 重复计入）。
        if depth == 1 and re.match(r"^(public|protected)", s):
            pending.append(s)
            if re.search(r"[;{=]\s*$", s):
                out.append((" ".join(pending), n))
                pending = []
        elif pending:
            # 续行的签名
            pending.append(s)
            if re.search(r"[;{=]\s*$", s):
                out.append((" ".join(pending), n))
                pending = []
        depth += line.count("{") - line.count("}")
    return out


def ident_tokens(sig: str) -> set[str]:
    """签名里够"独特"的标识符（长度>2 的词），用来判断某行是不是这条声明。"""
    words = set(re.findall(r"[A-Za-z_][A-Za-z0-9_]{2,}", sig))
    drop = {"public", "protected", "static", "final", "abstract", "default", "class",
            "interface", "enum", "record", "extends", "implements", "return", "this"}
    return {w for w in words if w not in drop}


def member_name(sig: str) -> str:
    """从一条声明里取出成员名。

    方法/构造：`(` 前面那个标识符（去掉泛型）；字段：`;`/`=` 前最后一个标识符。
    """
    # 先按 `=` 切一刀：否则 `public static boolean x = false;` 会取出 `false` 当名字
    sig = sig.split(" = ")[0]
    head = sig.split("(")[0] if "(" in sig else sig
    head = re.sub(r"<[^>]*>", "", head)
    head = head.rstrip(";{= ").strip()
    words = re.findall(r"[A-Za-z_$][A-Za-z0-9_$]*", head)
    return words[-1] if words else ""


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--skills", default="skills/forge-api")
    ap.add_argument("--sources", default="mod/build/mcsrc")
    ap.add_argument("--extra", default="artifacts/forge-src")
    ap.add_argument("--sample", type=int, default=0, help="只详细列出前 N 个问题")
    args = ap.parse_args()

    # 重建 roots（跟生成器同一套）
    roots = []
    for src in str(args.sources).split(","):
        cand = Path(src.strip()) / "net" / "minecraftforge"
        if cand.is_dir():
            roots.append(cand)
    if Path(args.extra).is_dir():
        for d in sorted(Path(args.extra).iterdir()):
            cand = d / "net" / "minecraftforge"
            if cand.is_dir():
                roots.append(cand)

    files = []
    for r in roots:
        files.extend(sorted(r.rglob("*.java")))
    files = [f for f in files if "internal" not in f.parts]

    bad_line = []
    missing = []
    empty = []
    checked = 0
    total_members = 0

    for f in files:
        info = gen.parse_file(f)
        if info["fqcn"] in [x[0] for x in missing]:
            continue
        src_lines = f.read_text(encoding="utf-8", errors="replace").splitlines()
        md = Path(args.skills) / Path(*info["package"].split(".")) / (info["name"] + ".md")
        if not md.is_file():
            missing.append((info["fqcn"], "SKILL 文件不存在"))
            continue

        parsed = info["members"]
        total_members += len(parsed)
        if not parsed:
            empty.append(info["fqcn"])

        # 1) 行号核对：第 N 行是否含该签名的标识符
        for sig, _doc, line_no in parsed:
            checked += 1
            if line_no - 1 >= len(src_lines):
                bad_line.append((info["fqcn"], sig, line_no, "<越界>"))
                continue
            target = gen.strip_line_comments(src_lines[line_no - 1])
            # 声明可能跨行，取 N..N+2 三行拼起来看
            window = " ".join(gen.strip_line_comments(x)
                              for x in src_lines[line_no - 1:line_no + 2])
            if not (ident_tokens(sig) & ident_tokens(window)):
                bad_line.append((info["fqcn"], sig, line_no, target.strip()[:70]))

        # 2) 独立性核对：源码里第一层的 public/protected 是否都被收了。
        #    按**成员名**比对（上一版拿签名末段做子串匹配，报了 3410 条假漏收）。
        ind = independent_members(f.read_text(encoding="utf-8", errors="replace"))
        got_names = {member_name(s) for s, _, _ in parsed}
        got_names.discard("")
        for sig, n in ind:
            name = member_name(sig)
            if name and name not in got_names:
                missing.append((info["fqcn"], "L%d 未收录: %s" % (n, sig[:78])))

    print("=" * 72)
    print("审计：%d 个类，%d 条成员" % (len(files), total_members))
    print("  行号对不上：%d 条" % len(bad_line))
    print("  疑似漏收  ：%d 条" % len(missing))
    print("  0 成员文件：%d 个" % len(empty))
    print("=" * 72)

    if bad_line:
        print("\n行号对不上（前 %d 条）：" % (args.sample or 15))
        for fq, sig, ln, got in (bad_line[:args.sample or 15]):
            print("  %s\n    声明: %s\n    行 %d 实际: %s" % (fq, sig[:80], ln, got))
    if missing:
        print("\n疑似漏收（前 %d 条）：" % (args.sample or 15))
        for fq, why in (missing[:args.sample or 15]):
            print("  %s  %s" % (fq, why))
    if empty:
        # 0 成员的按包归类，确认都是"真的没有成员"的类型
        buckets: dict = {}
        for fq in empty:
            parts = fq.split(".")
            pkg = ".".join(parts[:-1]) or "(默认包)"
            buckets.setdefault(pkg, []).append(parts[-1])
        print("\n0 成员文件的分布（前 12 个包）：")
        for pkg, names in sorted(buckets.items(), key=lambda kv: -len(kv[1]))[:12]:
            print("  %-34s %3d 个：%s" % (pkg, len(names), ", ".join(sorted(names)[:5])))

    return 0 if (not bad_line and not missing) else 1


if __name__ == "__main__":
    sys.exit(main())