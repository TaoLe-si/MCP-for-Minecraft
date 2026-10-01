# MCP for Minecraft

让 AI 代理**真的去玩** Minecraft 的一套东西：一个 Forge 模组在游戏里开一条本地控制
通道（动态服务），一个 MCP 服务把"往前走 / 挖方块 / 点按钮 / 读日志"这些动作
变成代理能调的工具。

- **分支**：`1.20.1-forge`
- **基线**：MinecraftForge **1.20.1-47.4.10**（1.20.1 的官方 recommended，即当前稳定版）
- **工具链**：ModDevGradle LegacyForge（自带 `runClient` / `runServer`，不用另装启动器）

## 它长什么样

```
MCP 工具 (tools/mcmcp.py，61 个)
   │  mc_move / mc_break / mc_click_button / mc_log ...
   ▼  换行分隔 JSON 包（docs/protocol.md）
   ▼  TCP 127.0.0.1:25585
模组动态服务（mod/）
   │  ControlServer → Dispatcher → 投递到游戏线程
   ▼
原版输入链路 / MultiPlayerGameMode / 界面事件派发
   ▼
玩家真的走、方块真的掉、按钮真的按下
```

**一条 `mc_move` 就是"发送端发一个往前走的包"**：

```json
{"id": 1, "op": "move", "args": {"forward": 1, "ticks": 40}}
```

游戏侧收到后走的是**原版按键那条路**（`KeyMapping` → `KeyboardInput` →
`LocalPlayer.aiStep`），所以服务端照收移动包、照算碰撞、别的模组也看得见 ——
不是"改坐标"那种假动作。

## 不碰真机的鼠标和键盘

**代理驱动游戏时，真机的鼠标、键盘、光标一概不动。** 这不是"注意一下"，是设计上的必然 ——
所有输入都在**游戏进程内部**改原版自己的状态，没有一处走操作系统的输入注入：

| 想做的事 | 走的接口 | 没走的东西 |
|---|---|---|
| 走路/跳跃/潜行 | `KeyMapping.setDown` → 原版 `KeyboardInput` | OS 键盘事件 |
| 开背包/丢弃/切视角 | `KeyMapping.click` → 原版 `consumeClick` | 同上 |
| 转视角 | `Entity.setYRot/setXRot` | **鼠标位置**、`MouseHandler` |
| 挖/放/攻击/使用 | `MultiPlayerGameMode` 的对应方法 | OS 鼠标按键 |
| 点界面按钮 | `Screen.mouseClicked(控件中心坐标)` | OS 光标 |
| 切快捷栏 | `Inventory.swapPaint` + 发包 | 滚轮模拟 |

对比一下**没有**采用（那些才会影响真机）：`SendInput`/`mouse_event` 注入、AutoHotkey、
pyautogui、抢窗口前台再模拟按键、虚拟 HID。**一个都没用。** 所以你可以在代理跑的同时
正常用电脑。

两个**边界**要说清楚（都是"游戏内"层面的，不是真机层面）：

1. **同一个游戏窗口里，模拟按键和真人按键争的是同一个 `KeyMapping`。**
   人正握着 W 而代理也在按 W 时，代理收工松手会让人感觉"被松手"。
   要完全隔离就开两个客户端：代理跑 `runClientAuto`（独立世界、独立窗口），人用自己的。
2. **`clientAuto` 会替人点掉几个挡路界面**（加载警告 / 无障碍引导 / 暂停菜单），
   并把 `pauseOnLostFocus` 设 false。这些**只在 `-Dmcpforminecraft.autoworld=` 武装时生效**，
   普通 `runClient` 不做。

## 三条实现纪律

决定了"像不像真的"，也是本仓库跟"直接改内存"那类做法的分界：

1. **按键走路走原版输入链路。**
2. **改方块走 `MultiPlayerGameMode`**（`startDestroyBlock` / `useItemOn`）。
   直接改本地方块 = 服务端一同步就拉回去，看着还像方块凭空消失。
3. **点按钮走界面事件派发**（`screen.mouseClicked(控件中心)`）。不反射、不假装移动鼠标。

## 操作面

61 个 MCP 工具，五类（完整表在 [docs/protocol.md](docs/protocol.md)）：

| 类别 | 工具 |
|---|---|
| 观测（基础） | `mc_state` `mc_probe` `mc_block` `mc_blocks` `mc_entities` `mc_inventory` `mc_screen` `mc_ray` |
| 观测（纵深） | `mc_vitals` `mc_world` `mc_light` `mc_biome` `mc_block_entity` `mc_entity_info` `mc_scoreboard` `mc_server` `mc_recipes` `mc_recipe_book` `mc_advancements` |
| 日志 | `mc_log` `mc_chatlog` `mc_events` |
| 感官 | `mc_stats` `mc_sounds` `mc_bossbars` |
| 输入 | `mc_move` `mc_key` `mc_press` `mc_jump` `mc_look` `mc_look_at` |
| 世界改动 | `mc_break` `mc_place` `mc_interact` `mc_attack` `mc_use` `mc_select_slot` `mc_scroll` `mc_use_on_entity` `mc_place_recipe` `mc_creative_give` `mc_spawn` `mc_kill` `mc_name_tag` `mc_set_world` |
| 交易 | `mc_trades` `mc_trade` |
| 长尾动作 | `mc_act`（digStatus/drop/pickItem/startUsing/releaseUsing/stopBreak/sleep/wakeUp/respawn/fly/ride/dismount/openInventory/clientLevel/recipeOptions/containerButton） |
| 界面 | `mc_click_button` `mc_type_text` `mc_click_slot` `mc_close_screen` |
| 通信/截图 | `mc_chat` `mc_shot` `mc_diff` |
| 工程 | `mc_build` `mc_run` `mc_exec` `mc_ping` |
| SKILL | `skill_read` `skill_note` |

几个不那么显然的点：

- **`mc_press` 和 `mc_key` 不是一回事**。`setDown` 不增加 `clickCount`，而
  "开背包 / 丢弃 / 切视角 / 快捷栏 1-9"走的是 `consumeClick()` —— 所以"敲一下"
  必须同时补一次 `KeyMapping.click(...)`。要开背包就得用 `mc_press`。
- **`mc_break` 是"挖穿才回包"**，不是"发个指令就回 ok"。
- **`mc_screen` 会吐控件树**（文字/位置/是否变灰），`mc_click_button` 按文字找按钮，
  找不到会把所有按钮列出来。
- **`mc_log` 读的是 `latest.log`**，不自己存一份 —— log4j 已经把原版和所有模组的
  东西写进去了，自己再存只会更差更假。

## 快速开始

```bash
# 1. 起一个 dev 客户端（自动建/载入超平坦世界，无人值守）
cd mod && ./gradlew runClientAuto

# 2. 验收"往前走"这条主线
python tools/e2e.py

# 3. 全操作面自检（观测/日志/建造/界面/输入，逐类核对）
python tools/e2e_api.py
```

MCP 服务由 ZCode 拉起（`~/.zcode/cli/config.json` 里配一条 stdio server 指向
`tools/mcmcp.py` 即可）。

## 两种 SKILL

这是本仓库的"开发格式"：**MCP 服务先立起来，然后静态归纳 API，再让运行时去修正它。**

```
mc_move / mc_break / ...  ──►  游戏内动态服务
        │                            │
        │  ◄── before/after 两帧观测 ─┘
        ▼
skills/minecraft-runtime/measurements.jsonl    ← 原始证据，只增不改
        ▼
skills/minecraft-api/SKILL.md        ← 静态归纳：读源码得出的机制与坑（带行号证据）
skills/minecraft-runtime/SKILL.md    ← 运行时修正：实测说了算，跟静态冲突以它为准
```

- **[skills/minecraft-api/SKILL.md](skills/minecraft-api/SKILL.md)** —— 静态。每条结论
  都能指到反编译源码的某一行（比如"`ToggleKeyMapping` 在切换模式下 `setDown` 是取反语义"
  出自 `ToggleKeyMapping.java:17-23`）。**没读到证据的一律标【待测】**。
- **[skills/minecraft-runtime/SKILL.md](skills/minecraft-runtime/SKILL.md)** —— 动态。
  只写实测出来的东西，每条都能追到 `measurements.jsonl` 里的一次真实调用。
  两边冲突时**以实测为准**，并且回头改静态那份。

这么分是因为：源码能告诉你"这么写有效"，但**只有实测能告诉你"实际走了多少格/秒"**。
静态那份不编数，动态那份不空谈。

## 实测记录（当前）

| 项 | 实测 | 证据 |
|---|---|---|
| `move` forward=1 / 40 tick | 位移 **8.375 格**，Δx=0，Δy=0，**4.187 格/秒**，画面变化 19.91% | `e2e.py` |
| 走路速度曲线（10/20/40/80/120 tick） | 拟合出 **`位移 ≈ 4.317 × (ticks − 1.2) / 20`** | `walk_speed_curve` |

那条拟合值得看一眼：**稳态 4.317 格/秒**正好等于从 `MOVEMENT_SPEED = 0.1` 推出来的
原版值（静态 SKILL 当时拒绝直接引用它是对的 —— 实测把它钉死了）；而 **`1.2 tick`
的偏移量就是起步加速的摊薄**，意思是"别拿 10 tick 去测速度"（10 tick 只有 3.80 格/秒，
比稳态低 12%）。

## 目录

```
docs/protocol.md          动态服务协议（完整 op 表）
mod/                      Forge 1.20.1 模组
  src/main/java/.../control/    ControlServer / Dispatcher / GameThread / Journal
  src/main/java/.../client/     ClientOps / InputOverride / Blocks / GuiOps / AutoWorld
skills/                   两份 SKILL（静态 + 运行时）
tools/mcmcp.py            MCP 服务（纯标准库，无第三方依赖）
tools/e2e.py              端到端验收：往前走
tools/e2e_api.py          全操作面自检
artifacts/                运行日志与临时产物（gitignore）
```
