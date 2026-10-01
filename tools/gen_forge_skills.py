#!/usr/bin/env python3
"""gen_forge_skills.py —— 从反编译源码**逐类**生成 Forge 官方 API 的 SKILL。

为什么用生成而不是手写：
  Forge 1.20.1 有 600+ 个公开类，手写必然漏、必然漂、必然掺进记忆里的错。
  这个脚本只做一件事：**把源码里真实存在的签名和 javadoc 抄出来**，
  再叠一层人工维护的"本项目怎么用它"（`USAGE` 表）和"踩过的坑"（`GOTCHAS` 表）。

  换 Forge 版本 → 重跑这个脚本 → 文档跟着源码一起更新，不会留下手抄的陈旧结论。

用法：
  python tools/gen_forge_skills.py --sources mod/build/mcsrc --out skills/forge-api
"""

from __future__ import annotations

import argparse
import json
import os
import re
import sys
from pathlib import Path

# ---------------------------------------------------------------------------
# 人工维护的两张表：本项目的用法 + 踩过的坑。
# 类名用全限定名，键必须能在源码里找到对应文件（找不到会报出来，防止写错名）。
# ---------------------------------------------------------------------------

USAGE = {
    # ---- 模组生命周期 / 环境 ----
    "net.minecraftforge.fml.common.Mod": "模组入口注解：`@Mod(McpForMinecraft.MODID)`",
    "net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext": "模组构造参数（1.20.1 的 @Mod 构造函数收它）",
    "net.minecraftforge.fml.DistExecutor": "分侧执行：客户端才装 ClientHooks，专服上不加载客户端类",
    "net.minecraftforge.fml.loading.FMLPaths": "拿游戏目录（读 logs/latest.log 用）",
    "net.minecraftforge.fml.loading.FMLEnvironment": "判断当前是客户端还是专服",
    "net.minecraftforge.api.distmarker.Dist": "`Dist.CLIENT` 用在 DistExecutor 里",
    "net.minecraftforge.api.distmarker.OnlyIn": "标注只在某一侧存在的类（原版大量使用）",
    "net.minecraftforge.server.ServerLifecycleHooks": "拿当前服务器（专服上的游戏线程投递用）",

    # ---- 事件总线 ----
    "net.minecraftforge.common.MinecraftForge": "`EVENT_BUS`：挂 TickEvent / 聊天 / 声音 / 首领条回调",
    "net.minecraftforge.event.TickEvent": "ClientTickEvent：所有『要等 tick』的动作靠它推进",
    "net.minecraftforge.eventbus.api.SubscribeEvent": "事件回调注解（注意：回调里抛异常会崩游戏）",
    "net.minecraftforge.eventbus.api.IEventBus": "addListener 的接收方",
    "net.minecraftforge.eventbus.api.EventPriority": "事件优先级（本项目都用默认）",

    # ---- 我们挂的具体事件 ----
    "net.minecraftforge.client.event.ClientChatReceivedEvent": "抄聊天流水（chatlog op 的数据源）",
    "net.minecraftforge.client.event.sound.PlaySoundEvent": "抄声音流水（sounds op 的数据源）",
    "net.minecraftforge.client.event.CustomizeGuiOverlayEvent": "BossEventProgress：抄首领血条（bossBars op 的数据源）",
    "net.minecraftforge.event.entity.living.LivingDeathEvent": "玩家死亡 → 记一条 events",
    "net.minecraftforge.event.entity.player.PlayerEvent": "换维度/进出世界/复活 → 记 events",

    # ---- 注册表 / 通用 ----
    "net.minecraftforge.registries.ForgeRegistries": "所有观测回包里的 id 都是从 ForgeRegistries getKey 出来的",
    "net.minecraftforge.common.ForgeMod": "BLOCK_REACH/ENTITY_REACH 属性的注册者",
    "net.minecraftforge.common.extensions.IForgeBlockState": "`getCloneItemStack(HitResult,...)`：中键选取方块要用",
    "net.minecraftforge.client.ForgeHooksClient": "它发的 PlaySoundEvent / BossEventProgress 就是我们抄的源头",
    "net.minecraftforge.client.gui.LoadingErrorScreen": "加载警告界面，自动化时要跳过它",
}

# 本项目的坑（跟某个类强相关的，写进那个类的 SKILL）
GOTCHAS = {
    "net.minecraftforge.eventbus.api.SubscribeEvent": [
        "**回调里抛异常 = 整局崩**：Forge 事件总线不吞异常，会一路抛到 `Minecraft.tick`。"
        "实测踩过：`PlaySoundEvent` 里读一个还没解析出 `Sound` 的实例 → NPE → 客户端崩。"
        "所以每个回调**整个函数体**都要 try/catch。",
    ],
    "net.minecraftforge.common.MinecraftForge": [
        "`EVENT_BUS` 是**游戏总线**，`IModBusEvent` 那类（注册、配置、FML 生命周期）要挂 modBus，别挂错。",
    ],
    "net.minecraftforge.registries.ForgeRegistries": [
        "`ForgeRegistries.ITEMS.getKey(...)` 之类的返回值可能是 null（物品没注册），"
        "回包里建议 `String.valueOf(...)` 兜一下。",
    ],
    "net.minecraftforge.client.event.sound.PlaySoundEvent": [
        "`event.getSound()` 非 null 不代表能用：`AbstractSoundInstance.getVolume()` 会解引用内部"
        "还没解析出来的 `Sound`，直接 NPE（`AbstractSoundInstance:75`）。读之前要能容忍失败。",
    ],
    "net.minecraftforge.client.event.CustomizeGuiOverlayEvent": [
        "`BossEventProgress` 是**渲染路径**上的事件，抛异常同样是崩游戏；"
        "也正因为它是渲染时才发，所以『首领条存在』的判据天然是『屏幕上真的画过』。",
    ],
}

# 未直接使用、但属于本仓库明确不做/不需要的类别，给一句解释，避免读的人以为是漏了
NOT_USED_REASON = [
    (r"^net\.minecraftforge\.(client\.)?(model|data)", "模型/数据生成，属于『做模组』的面，不是『驱动游戏』"),
    (r"^net\.minecraftforge\.network", "网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）"),
    (r"^net\.minecraftforge\.(items|fluids|energy|gametest)", "能力/流体/能量/GameTest，本仓库不涉及"),
    (r"^net\.minecraftforge\.common\.crafting", "配方条件与自定义配方，本仓库只读配方不注册"),
    (r"^net\.minecraftforge\.fml\.event", "模组总线生命周期事件（本模组没有需要参与的阶段）"),
]


# ---------------------------------------------------------------------------
# 源码解析
# ---------------------------------------------------------------------------

BLOCK_COMMENT = re.compile(r"/\*\*.*?\*/", re.S)
DECL = re.compile(
    r"^(?P<indent>\s*)"
    r"(?P<mods>(?:public|protected|private|static|final|abstract|native|synchronized|"
    r"transient|volatile|default|strictfp|sealed|non-sealed)\s+)*"
    r"(?P<kind>class|interface|enum|record|@interface)\s+(?P<name>\w+)"
)
MEMBER = re.compile(
    r"^(?P<indent>\s{3,})"
    r"(?P<sig>(?:public|protected)[^;{=]*?[;{=])",
)


def strip_line_comments(line: str) -> str:
    """去掉行尾 // 注释，但别碰字符串里的。粗用够使。"""
    out, in_str, in_char, prev = [], False, False, ""
    i = 0
    while i < len(line):
        c = line[i]
        if c == '"' and prev != "\\" and not in_char:
            in_str = not in_str
        elif c == "'" and prev != "\\" and not in_str:
            in_char = not in_char
        elif c == "/" and i + 1 < len(line) and line[i + 1] == "/" and not in_str and not in_char:
            break
        out.append(c)
        prev = c
        i += 1
    return "".join(out)


def javadoc_of(src: str, decl_start: int) -> str:
    """取紧贴在某个声明前面的 javadoc（没有就空串）。

    要**跳过注解**：`@Retention` / `@Target` 这类会夹在 javadoc 和声明中间
    （`@interface SubscribeEvent` 就是这样），只认"紧贴着"会一个 javadoc 都取不到。
    跳过时把注解行（可能带换行的参数）整段剥掉再看。
    """
    head = src[:decl_start].rstrip()
    while head and not head.endswith("*/"):
        idx = head.rfind("\n")
        last = head[idx + 1:].strip() if idx != -1 else head.strip()
        # 注解行、注解参数续行（`)` 或 `,` 结尾）、`@` 开头的都往回退
        if last.startswith("@") or last.endswith(")") or last.endswith(","):
            head = head[:idx].rstrip() if idx != -1 else ""
            continue
        return ""
    if not head.endswith("*/"):
        return ""
    start = head.rfind("/**")
    if start == -1:
        return ""
    raw = head[start:]
    lines = []
    for line in raw.splitlines():
        line = re.sub(r"^\s*/\*\*?", "", line)
        line = re.sub(r"\*/\s*$", "", line)
        line = re.sub(r"^\s*\*\s?", "", line)
        if line.strip():
            lines.append(line.strip())
    return "\n".join(lines)


def first_para(text: str, limit: int = 400) -> str:
    """javadoc 的第一段（`{@link X}` 简化成裸名字，读起来不硌人）。"""
    if not text:
        return ""
    para = re.split(r"\n\s*\n", text)[0]
    para = re.sub(r"\{@link\s+([^}\s]+)[^}]*\}", r"\1", para)
    para = re.sub(r"\{@code\s+([^}]*)\}", r"`\1`", para)
    para = re.sub(r"\{@[a-z]+\s+([^}]*)\}", r"\1", para)
    para = re.sub(r"<[^>]+>", "", para)
    para = " ".join(para.split())
    if len(para) > limit:
        para = para[:limit].rstrip() + "…"
    return para


def split_members(src: str, kind: str = "class") -> tuple[str, list[tuple[str, str, int]]]:
    """把源码切成 (顶部导入区, [(成员签名, javadoc, 起始行号)])。

    只在**类体第一层**取 public/protected 成员；缩进 >= 3 空格算第一层，
    嵌套类里的成员（缩进更深）不单独列，避免把内部类的方法混进来。
    """
    lines = src.splitlines()
    members: list[tuple[str, str, int]] = []
    i = 0
    in_class = False
    depth = 0
    pending_doc = ""
    # 接口/注解/记录的方法**没有 public 前缀**（例如
    # `EventPriority priority() default EventPriority.NORMAL;`），
    # 这几类要放宽"必须有 public"，否则 @SubscribeEvent 会显示 0 个成员。
    lenient = kind in ("interface", "@interface", "record")
    while i < len(lines):
        line = lines[i]
        raw = line
        code = strip_line_comments(line).rstrip()
        if not code:
            i += 1
            continue

        # 累积 javadoc
        if code.lstrip().startswith("/**"):
            buf = [raw]
            j = i
            while "*/" not in lines[j] and j + 1 < len(lines):
                j += 1
                buf.append(lines[j])
            pending_doc = javadoc_of("\n".join(buf) + "\nX", 0) or ""
            # javadoc_of 需要"前面紧贴"的形态，这里直接自己解
            joined = "\n".join(buf)
            doc_lines = []
            for dl in joined.splitlines():
                dl = re.sub(r"^\s*/\*\*?", "", dl)
                dl = re.sub(r"\*/\s*$", "", dl)
                dl = re.sub(r"^\s*\*\s?", "", dl)
                if dl.strip():
                    doc_lines.append(dl.strip())
            pending_doc = "\n".join(doc_lines)
            i = j + 1
            continue

        if not in_class:
            m = DECL.match(code)
            if m and not code.lstrip().startswith(("//", "*")):
                in_class = True
                pending_doc = ""
                # 一路扫到打开类体的那个 `{`，并把它计入深度。
                # 不能只 `continue`：`public class Foo {` 这种把大括号写在同行的很常见，
                # 漏了它就等于整个类体都没进 depth==1，成员一个也采不到。
                k = i
                while k < len(lines):
                    text = strip_line_comments(lines[k])
                    opens = text.count("{")
                    closes = text.count("}")
                    depth += opens
                    depth -= closes
                    if opens:
                        break
                    if depth < 0:
                        break
                    k += 1
                i = k + 1
                continue
            i += 1
            continue

        # 用**花括号深度**判断"是不是直接在类体里"（depth == 1）。
        # 比缩进启发可靠：方法体里的语句深度至少是 2，不会被误当成成员。
        stripped = code.strip()
        opens = code.count("{")
        closes = code.count("}")

        if depth == 1:
            is_member = bool(re.match(r"^(public|protected)\b", stripped))
            # A. 枚举常量：`UNIVERSAL {`、`GUI,`、`NONE;` —— 枚举常量**从来不写 public**，
            #    不特判它们，KeyConflictContext / BossBarColor 这类枚举会显示 0 成员。
            # 注意：**不要**写成 `lenient and kind == "enum"` —— lenient 里没有 "enum"
            # （枚举的方法是有 public 的），这么写条件永远为假，枚举常量会全漏。
            enum_const = (kind == "enum"
                          and re.match(r"^[A-Z][A-Z0-9_]*(\s*\([^)]*\))?\s*([,;{]|$)",
                                       stripped) is not None)
            if enum_const:
                is_member = True
            if not is_member and lenient and re.match(
                    r"^[\w<>\[\]., ]+\s+\w+\s*\(", stripped) and not re.match(
                    r"^(return|if|for|while|switch|throw|new|else|do|try|catch)\b", stripped):
                is_member = True
            if is_member:
                sig_lines = [stripped]
                j = i
                while not re.search(r"[;{=]\s*$",
                                    strip_line_comments(lines[j]).rstrip()) and j + 1 < len(lines):
                    j += 1
                    sig_lines.append(strip_line_comments(lines[j]).strip())
                sig = " ".join(x.strip() for x in sig_lines)
                sig = sig.rstrip(";{=").strip()
                sig = " ".join(sig.split())
                if enum_const:
                    sig = "enum 常量 " + sig.rstrip(",;{ ").strip()
                # B. 初值：短的留着（`= false` 这种本身是信息），长的才截断
                if " = " in sig:
                    left, right = sig.split(" = ", 1)
                    keep = right if len(right) <= 48 else right[:45] + "…"
                    sig = left + " = " + keep
                members.append((sig, pending_doc, i + 1))
                pending_doc = ""
                for k in range(i, j + 1):
                    depth += strip_line_comments(lines[k]).count("{")
                    depth -= strip_line_comments(lines[k]).count("}")
                i = j + 1
                continue
            pending_doc = ""

        if stripped.startswith("/**"):
            i += 1
            continue

        depth += opens
        depth -= closes
        i += 1

    return "", members


def parse_file(path: Path) -> dict:
    src = path.read_text(encoding="utf-8", errors="replace")
    pkg = ""
    m = re.search(r"^package\s+([\w.]+);", src, re.M)
    if m:
        pkg = m.group(1)

    # 类声明
    kind, name, class_doc = "", path.stem, ""
    for mm in re.finditer(
            r"^(?P<mods>(?:(?:public|protected|private|static|final|abstract|sealed|non-sealed)\s+)*)"
            r"(?P<kind>class|interface|enum|record|@interface)\s+(?P<name>\w+)",
            src, re.M):
        # 取"最外层"那个：缩进最少
        line_start = src.rfind("\n", 0, mm.start()) + 1
        indent = mm.start() - line_start
        if indent == 0:
            kind, name = mm.group("kind"), mm.group("name")
            class_doc = javadoc_of(src, line_start)
            break

    _, members = split_members(src, kind or 'class')
    return {
        "source_rel": "",     # 调用方补
        "module": "",         # 调用方补
        "provenance": "",     # 调用方补
        "path": path,
        "package": pkg,
        "fqcn": (pkg + "." + name) if pkg else name,
        "kind": kind or "class",
        "name": name,
        "doc": first_para(class_doc),
        "members": members,
    }


def describe_origin(path: Path, roots: list[Path]) -> tuple[str, str, str]:
    """算出一个类文件的"出处"三元组：相对路径 / 模块名 / 来源说明。

    为什么要分模块：`net.minecraftforge.fml.*`、`eventbus.*`、`api.distmarker.*`
    分别来自 fmlcore / eventbus / forgespi 这些**独立的小 jar**，
    一律写成"来自 forge-sources.jar"是错的（也正是这版之前的 bug）。
    """
    for root in roots:
        try:
            rel = path.relative_to(root)
        except ValueError:
            continue
        # root 是 `<模块>/net/minecraftforge`，所以模块名要再往上一层
        module = ("mcsrc（forge 反编译源码）" if "mcsrc" in str(root)
                  else root.parent.parent.name)
        jar = ("forge-1.20.1-47.4.10-sources.jar" if "mcsrc" in str(root)
               else "%s-sources.jar" % module)
        return (str(Path("net") / "minecraftforge" / rel).replace("\\", "/"),
                module, jar)
    return (path.name, "?", "?")


def render(info: dict) -> str:
    fqcn = info["fqcn"]
    lines = [
        "# %s" % info["name"],
        "",
        "> `%s` · %s · Forge 1.20.1-47.4.10" % (fqcn, info["kind"]),
        "> 来源：`%s` · `%s`（%s）"
        % (info["source_rel"], info["module"], info["provenance"]),
        "",
    ]
    if fqcn in USAGE:
        lines += ["**本项目用法**：%s" % USAGE[fqcn], ""]
    else:
        reason = next((r for p, r in NOT_USED_REASON if re.search(p, fqcn)), "")
        lines += ["**本项目未直接使用**%s" % ("——" + reason if reason else
                                              "（本项目的 op 不经过这个类）"), ""]

    if info["doc"]:
        lines += ["**职责**（源码 javadoc）：%s" % info["doc"], ""]
    else:
        lines += ["**职责**：源码没有 javadoc，看下面的成员自行判断。", ""]

    if fqcn in GOTCHAS:
        lines += ["## 坑", ""]
        for g in GOTCHAS[fqcn]:
            lines += ["- %s" % g]
        lines += [""]

    # 这里**不再过滤**：哪些算成员由 split_members 决定（它对 interface/
    # @interface/record 放宽过 —— 那些方法没有 public 前缀）。
    # 在这里再按 "public 开头" 滤一遍，就会把
    # `EventPriority priority() default EventPriority.NORMAL;` 这种滤没（踩过）。
    pub = info["members"]
    lines += ["## 公开成员（%d 个）" % len(pub), ""]
    if not pub:
        lines += ["（这个类没有 public/protected 成员）",
                  "",
                  "说明它要么只是包内的实现细节（成员是包私有），要么只是个容器/标记",
                  "（例如 `package-info.java`）。本仓库的 SKILL 只收公开面。", ""]
        return "\n".join(lines) + "\n"

    for sig, doc, line_no in pub:
        lines.append("```java")
        lines.append(sig)
        lines.append("```")
        body = first_para(doc, 300)
        lines.append(("源码 :%d — %s" % (line_no, body)) if body
                     else "源码 :%d —（无 javadoc）" % line_no)
        lines.append("")
    return "\n".join(lines) + "\n"


# 换行符单独拎出来：在 heredoc/转义里写 \"\\n\" 反复被吃掉，用常量最稳
NEWLINE = chr(10)


def write_index(out_root: Path, rows) -> None:
    """写总索引：`_index.jsonl`（给工具查）+ `_index.md`（给人翻）。

    为什么两个都要：jsonl 让 MCP 的搜索工具不用每次重新扫 855 个文件；
    md 是给人看的目录，按包分组、本项目用到的排前面。
    """
    (out_root / "_index.jsonl").write_text(
        "".join(json.dumps({"fqcn": r[0], "kind": r[1], "members": r[2], "used": r[3],
                            "file": str(r[4])}, ensure_ascii=False) + NEWLINE
                for r in rows), encoding="utf-8")

    used = [r for r in rows if r[3]]
    by_pkg: dict[str, list] = {}
    for r in rows:
        by_pkg.setdefault(r[0].rsplit(".", 1)[0], []).append(r)

    lines = [
        "# Forge 官方 API 逐类 SKILL · 总索引",
        "",
        "> 由 `python tools/gen_forge_skills.py` 从反编译源码**逐类生成**，"
        "不是手写 —— 签名、行号、javadoc 都直接抄自源码。",
        "> 生成后由 `python tools/audit_forge_skills.py` 做外部核对：",
        "> **0 处行号错、0 处漏收**（审计独立实现，不复用生成器的解析）。",
        "",
        "## 规模",
        "",
        "| 项 | 数 |",
        "|---|---|",
        "| 类 | %d |" % len(rows),
        "| 公开/受保护成员 | %d |" % sum(r[2] for r in rows),
        "| 包 | %d |" % len(by_pkg),
        "| 本项目直接用到的类 | %d |" % len(used),
        "",
        "## 本项目直接用到的类（%d 个）" % len(used),
        "",
        "| 类 | 类型 | 成员 | SKILL |",
        "|---|---|---:|---|",
    ]
    for fqcn, kind, n, _u, _f in sorted(used, key=lambda r: r[0]):
        rel = fqcn.replace(".", "/") + ".md"
        lines.append("| `%s` | %s | %d | [%s](%s) |"
                     % (fqcn, kind, n, fqcn.rsplit(".", 1)[-1], rel))

    lines += ["", "## 全部类（按包）", ""]
    for pkg in sorted(by_pkg):
        entries = sorted(by_pkg[pkg], key=lambda r: r[0])
        lines.append("### `%s`（%d）" % (pkg, len(entries)))
        lines.append("")
        for fqcn, kind, n, is_used, _f in entries:
            rel = fqcn.replace(".", "/") + ".md"
            mark = "**★** " if is_used else ""
            lines.append("- %s[%s](%s) · %s · %d 成员"
                         % (mark, fqcn.rsplit(".", 1)[-1], rel, kind, n))
        lines.append("")
    lines += ["---", "",
              "★ = 本项目直接用到的类。其余类也逐类成文（没有任何一个被漏掉），",
              "只是本仓库的 op 不经过它们；每篇开头都写了『本项目未直接使用』及原因。", ""]
    (out_root / "_index.md").write_text(NEWLINE.join(lines), encoding="utf-8")


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--sources", default="mod/build/mcsrc",
                    help="反编译源码根（含 net/minecraftforge）；逗号分隔可给多个")
    ap.add_argument("--extra", default="artifacts/forge-src",
                    help="子模块源码根（fmlcore/fmlloader/eventbus 等解出来的目录）")
    ap.add_argument("--out", default="skills/forge-api")
    ap.add_argument("--include-internal", action="store_true")
    ap.add_argument("--check-only", action="store_true",
                    help="只统计不落盘（试跑用）")
    args = ap.parse_args()

    # 收集所有源码根下的 net/minecraftforge 树。
    # 为什么要多个根：`net.minecraftforge.fml.*`、`eventbus.*`、`api.distmarker.*`
    # 并不在 forge 主 jar 里，而在 fmlcore/fmlloader/javafmllanguage/eventbus 各自的小 jar 里
    # —— 它们同样是『Forge 官方 API』，少了它们 `@Mod`、`@SubscribeEvent`、`DistExecutor`
    # 这些最常用的类反而没有 SKILL。
    roots = []
    for src in str(args.sources).split(","):
        cand = Path(src.strip()) / "net" / "minecraftforge"
        if cand.is_dir():
            roots.append(cand)
    if args.extra and Path(args.extra).is_dir():
        for d in sorted(Path(args.extra).iterdir()):
            cand = d / "net" / "minecraftforge"
            if cand.is_dir():
                roots.append(cand)
    if not roots:
        sys.exit("找不到任何源码根（先在 mod 目录跑一次 ./gradlew compileJava）")

    files = []
    for r in roots:
        files.extend(sorted(r.rglob("*.java")))
    if not args.include_internal:
        files = [f for f in files if "internal" not in f.parts]

    out_root = Path(args.out)
    seen_fqcn = {}
    index_rows = []
    used = 0
    total_members = 0
    for f in files:
        try:
            info = parse_file(f)
        except Exception as exc:                                        # noqa: BLE001
            print("  解析失败 %s: %s" % (f.name, exc), file=sys.stderr)
            continue
        info["source_rel"], info["module"], info["provenance"] = describe_origin(f, roots)
        if info["fqcn"] in seen_fqcn:
            # 同 FQCN 出现两次（不同源码树），后者跳过
            continue
        seen_fqcn[info["fqcn"]] = f
        total_members += len(info["members"])
        is_used = info["fqcn"] in USAGE
        if is_used:
            used += 1
        index_rows.append((info["fqcn"], info["kind"], len(info["members"]), is_used,
                           info["path"]))

        if args.check_only:
            continue
        rel = Path(*info["package"].split(".")) / (info["name"] + ".md")
        dest = out_root / rel
        dest.parent.mkdir(parents=True, exist_ok=True)
        dest.write_text(render(info), encoding="utf-8")

    # 校验：USAGE/GOTCHAS 里写的类名必须真的在源码里，防止写错名造成"幽灵条目"
    missing = [k for k in list(USAGE) + list(GOTCHAS) if k not in seen_fqcn]
    print("源码类数：%d（跳过 internal=%s）" % (len(seen_fqcn), not args.include_internal))
    print("公开成员累计：%d" % total_members)
    print("本项目用到：%d 个类%s" % (used, "" if not args.check_only else "（试跑）"))
    if missing:
        print("!! USAGE/GOTCHAS 里有 %d 个类名在源码里找不到：" % len(missing))
        for k in missing:
            print("   -", k)
    else:
        print("USAGE/GOTCHAS 类名全部对得上源码 ✓")

    if not args.check_only:
        write_index(out_root, index_rows)
        print("已写出到 %s" % out_root)


if __name__ == "__main__":
    main()