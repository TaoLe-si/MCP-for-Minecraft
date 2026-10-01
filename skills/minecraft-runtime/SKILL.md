# 运行时 SKILL：实测说了算

> **性质：运行时修正。** 本文只写**实测出来的东西**，每条都要能追到
> `measurements.jsonl` 里的一次真实调用。静态说法（`skills/minecraft-api/SKILL.md`）
> 跟这里对不上，**以这里为准**，并且回头去改静态那份 —— 不许两边并存。

## 0. 这套机制怎么转

```
mc_move / mc_break / ...  ──►  游戏内动态服务
        │                            │
        │  ◄── before/after 两帧观测 ─┘
        ▼
skills/minecraft-runtime/measurements.jsonl     ← 原始证据，只增不改
        │
        ▼  由 e2e.py / e2e_api.py / skill_note 归纳
skills/minecraft-runtime/SKILL.md               ← 本文，给人看的结论
```

- **原始流水**：`measurements.jsonl`，一行一条 JSON，含 op、参数、前后两帧观测、
  算出来的位移。任何时候都能重新核对，不会被"总结"抹掉。
- **结论**：本文。由 `python tools/e2e.py` / `tools/e2e_api.py` 自动追加，
  也可以手工用 `skill_note` 追加。
- 每次追加都带时间戳和"是哪一次调用得出的"。

## 1. 不碰真机鼠标和键盘（设计保证）

**这条是硬要求，也确实做到了：MCP 服务驱动游戏时，真机的鼠标、键盘、光标一概不动。**

机制上就不可能碰到 —— 所有输入都是**在游戏进程内部**改原版自己的状态，
没有任何一处走操作系统的输入注入：

| 想做的事 | 走的接口 | 没走的东西 |
|---|---|---|
| 走路/跳跃/潜行 | `KeyMapping.setDown` → 原版 `KeyboardInput` | 不动 OS 键盘事件 |
| 开背包/丢弃/切视角 | `KeyMapping.click` → 原版 `consumeClick` | 同上 |
| 转视角 | `Entity.setYRot/setXRot` | **不动鼠标位置**，不调 `MouseHandler` |
| 鼠标点击方块的语义 | `MultiPlayerGameMode.destroyBlock/useItemOn/attack/useItem` | 不动 OS 鼠标按键 |
| 点界面按钮 | `Screen.mouseClicked(控件中心坐标)` | 不动 OS 光标 |
| 切快捷栏 | `Inventory.swapPaint` / `selected` + 发包 | 不模拟滚轮 |

对比一下**没有**采用的做法（那些才会影响真机）：`SendInput`/`mouse_event` 注入、
AutoHotkey、pyautogui、把窗口抢到前台再模拟按键、虚拟 HID 设备。**一个都没用。**

**实测确认**（`mc_probe` 的 `mouseGrabbed` 字段，整个跑批期间轮询）：
自动化跑的时候 `mouseGrabbed` 一直是 `false`，`windowActive` 也一直是 `false` ——
光标既没被锁进窗口，窗口也没抢焦点。

> 为什么专门修这个：原版在没有界面时会 `MouseHandler.grabMouse()`，它调的是
> `InputConstants.grabOrReleaseMouse(window, 212995, …)`，而 **212995 就是
> `GLFW_CURSOR_DISABLED`** —— 真机光标会被隐藏并锁进游戏窗口。第一次跑批时确实
> 影响到了用户的本机鼠标。现在自动化（`clientAuto`）每 tick 检查并 `releaseMouse()`，
> 人自己跑的 `runClient` 不碰这个，保持原版手感。

两个必须说清楚的**边界**（都是"游戏内"层面的影响，不是真机层面）：

1. **同一个游戏窗口里，模拟按键和真人按键会争同一个 `KeyMapping`。**
   如果人正握着 W，而代理也在按 W，代理收工时会把 W 松开 —— 人会感觉自己"被松手"了。
   这是"共享一个游戏窗口"的固有限制。**要完全隔离就开两个客户端**：
   代理跑 `runClientAuto`（它自带独立世界与独立窗口），人用自己那份。
2. **`clientAuto` 这个跑法会替人点掉几个挡路的界面**（加载警告、无障碍引导、暂停菜单），
   并且把 `pauseOnLostFocus` 设成 false。这些都是**为了无人值守**才做的，
   只在 `-Dmcpforminecraft.autoworld=` 武装时生效；普通 `runClient` 不做这些。

## 2. 走路速度（已实测，取代静态那份的【待测】）

**实测曲线**（`measurements.jsonl` 的 `kind=walk_speed_curve`：超平坦地面、yaw=0、
每次从静止起步、前方无遮挡）：

| 请求 ticks | 实测 tick | 位移（格） | 折算 |
|---:|---:|---:|---:|
| 10 | 10 | 1.8996 | 3.799 格/秒 |
| 20 | 20 | 4.0576 | 4.058 格/秒 |
| 40 | 40 | 8.3748 | 4.187 格/秒 |
| 80 | 80 | 17.0091 | 4.252 格/秒 |
| 120 | 120 | 25.6435 | 4.274 格/秒 |

**拟合结论**：

```
位移 ≈ 4.317 × (ticks − 1.2) / 20      （格）
```

- **`4.317 格/秒` 就是稳态速度**，跟从 `MOVEMENT_SPEED = 0.1` 推出来的原版值一致。
  静态那份拒绝直接引用这个数是对的 —— **实测把它钉死了**。
- **`1.2 tick` 是起步加速的摊薄量。** 含义很实际：**别用短距离去测速度** ——
  10 tick 只有 3.80 格/秒，比稳态低 12%，全被起步那几 tick 拉低。要测速度至少 80 tick。
- `实测 tick` 与请求 `ticks` **5/5 次完全相等**。静态那份写的"允许差 1~2"是保守说法，
  在这台机器上没观察到偏差。

### 2.1 判据陷阱：位移为 0 时先别看按键

这里踩过两次坑，代价是好几轮误判。**"包送到了、tick 也走了、人就是不动"有固定的
排查顺序**，别一上来就怀疑按键机制：

| 症状 | 真因 | 怎么确认 |
|---|---|---|
| 位移 **0**，但 `probe.forwardImpulse == 1.0`、`motion` 恒为极小值 | **玩家卡在方块里**，碰撞把水平速度清零了 | `mc_probe` 看 `forwardImpulse`（是 1）＋ `motion`（不涨）→ 就是它 |
| 位移只有拟合值的一半左右 | 前方有障碍（通常是自己上一轮放的测试方块）；或**刚跳完还在空中**（空中加速更慢） | 清场后重测；`probe.onGround` |
| 什么 op 都超时，但 `ping` 照答 | **客户端主线程被堵住**（大跨度 `/tp` 触发大量区块生成） | `ping.tick` 不涨 + `mc_probe` 超时 |

那次实测的数字：玩家卡在 `(-6, -60, 11)` 的石头里（上一轮测试自己放的），
`forwardImpulse=1.0`、`motion.x=-0.0006` 恒定不变、位置一动不动。传送到干净地面后
同一发 40 tick 包走了 **8.3748 格** —— 跟第一次成功的实测**一位不差**。
**所以按键机制一直是好的，是环境和状态的问题。**

两侧的 `e2e*.py` 现在都会先调 `prepare_clean_lane()`：**原地**清一条 3×3×N 的走廊，
并把朝向摆正。**故意不传送** —— 大跨度 `/tp`（0 → 300）会让客户端为新区域生成
几十秒区块，实测卡了约 25 秒，日志里连着两条 `Can't keep up!`，
期间所有需要排队到主线程的 op 全部超时。

### 2.2 `mc_probe`：不想猜就用它

`probe` 是专门为这类问题加的诊断 op，一次把内部状态全打出来：
`paused` / `screen` / `overlay` / `windowActive` / `mouseGrabbed` /
`keyUpDown`（按键真的按上了吗）/ `forwardImpulse`（输入层读到了吗）/
`motion`（物理上动了吗）/ `gameTime`（世界在走吗）。
断在哪一环，一眼就能看出来。

## 3. 时序：哪些 op 的"效果"不在回包里

实测踩出来的，静态读源码能看出端倪但不容易重视：

| 现象 | 原因 | 用法 |
|---|---|---|
| `interact` 开容器后立刻查 `screen`，看到"没界面" | 开容器**服务端仲裁**：客户端只发 useItemOn，界面要等服务端回 `ClientboundOpenScreenPacket` 才 `setScreen` | `interact` 带 `awaitScreen=true`（MCP 侧是 `mc_open`），会挂账到界面真的开出来 |
| `/setblock` 后立刻查 `block`，读到旧值 | 同上，命令要一个来回才生效 | 轮询 `block` 直到值变了 |

**规律：凡是由服务端裁决的结果（开界面、命令、别的实体的动作），回包 ≠ 已生效。**
而"客户端自己算的"（走路位移、按键状态、界面控件树）回包即生效。

## 4. 已确认"没坑"的项

静态读出来、运行时也验证过没翻车的：

- **按住键每 tick 复述有效**：120 tick 的 `move` 完整走完，没有中途松手
- **`press` 的"click + setDown 双管齐下"有效**：确实开出了背包界面
  （`CreativeModeInventoryScreen`）
- **`clickButton` 走 `screen.mouseClicked(控件中心)` 有效**：工作台上点第 0 号
  `ImageButton` 返回 `handled=true`
- **`place` 的前置校验有用**：目标已有方块时明确报错，而不是静默失败
  （这条是实测撞出来的：第二次跑撞上上一轮自己放的石头）
- **`break` 生存挖掘有效**：`place` 放石头 → `break` → 回读确认变空气

## 5. 修正记录

<!-- 下面是自动/手工追加区，最新的在最下面。每条都带时间戳。 -->

### [2026-10-01 17:47] 运行时修正

**实测：`move` forward=1 / ticks=40 有效。**

- 起点 `{'x': -6.5, 'y': -60.0, 'z': 0.5}` → 终点 `{'x': -6.5, 'y': -60.0, 'z': 8.8748}`
- 位移 8.375 格（Δx=+0.000, Δy=+0.000, Δz=+8.375），40 tick，**4.187 格/秒**
- 前后截图变化 19.91%（`e2e_before.png` ↔ `e2e_after.png`）
- 原始记录：`measurements.jsonl` 的 `kind=e2e_move`

静态 SKILL 里『走路速度』标成【待测】的那一项，**以本条实测为准**。

### [2026-10-01 22:47] 运行时修正

**实测：`move` forward=1 / ticks=40 有效。**

- 起点 {'x': 0.5, 'y': -60.0, 'z': 0.5} → 终点 {'x': 0.5, 'y': -60.0, 'z': 8.874761235223515}
- 位移 8.375 格（Δx=+0.000, Δy=+0.000, Δz=+8.375），40 tick，**4.187 格/秒**
- 前后截图变化 24.70%
- 原始记录：measurements.jsonl

静态 SKILL 第 4 节把『走路速度』标成【待测】的那一项，**以本条实测为准**。

### [2026-10-01 22:47] 运行时修正

**全 API 自检通过**（`python tools/e2e_api.py`，共 21 项）。

- 观测 / 日志 / 建造 / 界面 / 输入五类都落地。
- 改动类一律**回读核对**：`place` 后用 `block` 问一次是不是真变成了石头，`break` 后同样再问一次 —— 不拿回包里的 ok 自证。
- 界面是**两层验证**：`press` 开背包证明 `consumeClick` 那条路通；工作台上 `clickButton` 点真按钮后界面控件数发生变化，证明事件派发那条路也通。
- 截图证据：`e2e_api_built.png`（放好三块之后）、`e2e_api_broken.png`（挖掉第一块之后）。
- 原始记录在 `measurements.jsonl` 的 `kind=e2e_api` 那条。

### [2026-10-01 22:48] 运行时修正

**全操作面自检通过：21 项全过（`python tools/e2e_api.py`）。**

- 五类都落地：观测 / 日志 / 建造 / 界面 / 输入。
- 建造类是**回读核对**：`place` 三块石头后用 `block` 逐个确认，`break` 后再确认变空气。
- 界面是**两层验证**：`press` 开背包（`consumeClick` 那条路）＋ 工作台上
  `clickButton` 点真按钮返回 `handled=true`。
- **拟合式被独立验证**：20 tick 实测 Δz=**+4.058** 格，拟合预期 4.058 —— 一位不差。
- 截图：`e2e_api_built.png`（放好三块）、`e2e_api_broken.png`（挖掉第一块）。
- 原始记录：`measurements.jsonl` 的 `kind=e2e_api`。

### [2026-10-01 22:47] 运行时修正

**`move` forward=1 / ticks=40 复测通过（干净走廊）。**

- 起点 `(0.5, -60, 0.5)` → 终点 `(0.5, -60, 8.8748)`，位移 **8.375 格**，
  40 tick，**4.187 格/秒**，前后截图变化 **24.70%**。
- 跟 17:47 那次（8.3748 格）**一位不差** —— 可复现。

### [2026-10-01 23:11] 运行时修正

**第二批 API 运行时核实**（`python tools/e2e_api2.py`，共 28 条）：回读核对过 19 条，弱核对 5 条，失败 4 条。

失败项：drop 之后那一叠少了 1 个（回读核对）、startUsing 后 using=True、releaseUsing 回读到 wasUsing=True、pickItem 把石头拿到手上（回读核对）
- 回读核对的含义：不是『没报错就算过』，而是**改完之后再读一次状态**
  （drop 后看背包、fly 后看 abilities、sleep 后看 problem、creativeGive 后看背包里是不是真有 8 个红石）。
- 弱核对的那几条是『客户端只管发请求、结果由服务端裁决』的（placeRecipe/recipebook 等），
  回包只代表请求已发出，所以不敢标硬证据。
- 原始记录：`measurements.jsonl` 的 `kind=e2e_api2`。

### [2026-10-01 23:12] 运行时修正

**第二批 API 运行时核实**（`python tools/e2e_api2.py`，共 29 条）：回读核对过 18 条，弱核对 5 条，失败 6 条。

失败项：fly 之后 abilities.flying 变了（回读核对）、找到面包所在的快捷栏格、drop 之后那一叠少了 1 个（回读核对）、startUsing 后 using=True、releaseUsing 回读到 wasUsing=True、pickItem 之后手上变成石头（回读核对）
- 回读核对的含义：不是『没报错就算过』，而是**改完之后再读一次状态**
  （drop 后看背包、fly 后看 abilities、sleep 后看 problem、creativeGive 后看背包里是不是真有 8 个红石）。
- 弱核对的那几条是『客户端只管发请求、结果由服务端裁决』的（placeRecipe/recipebook 等），
  回包只代表请求已发出，所以不敢标硬证据。
- 原始记录：`measurements.jsonl` 的 `kind=e2e_api2`。

### [2026-10-01 23:13] 运行时修正

**第二批 API 运行时核实**（`python tools/e2e_api2.py`，共 30 条）：回读核对过 23 条，弱核对 5 条，失败 2 条。

失败项：fly 之后 abilities.flying 变了（回读核对）、pickItem 之后手上变成石头（回读核对）
- 回读核对的含义：不是『没报错就算过』，而是**改完之后再读一次状态**
  （drop 后看背包、fly 后看 abilities、sleep 后看 problem、creativeGive 后看背包里是不是真有 8 个红石）。
- 弱核对的那几条是『客户端只管发请求、结果由服务端裁决』的（placeRecipe/recipebook 等），
  回包只代表请求已发出，所以不敢标硬证据。
- 原始记录：`measurements.jsonl` 的 `kind=e2e_api2`。

### [2026-10-01 23:19] 运行时修正

**第二批 API 运行时核实**（`python tools/e2e_api2.py`，共 30 条）：回读核对过 25 条，弱核对 5 条，失败 0 条。

无失败项。
- 回读核对的含义：不是『没报错就算过』，而是**改完之后再读一次状态**
  （drop 后看背包、fly 后看 abilities、sleep 后看 problem、creativeGive 后看背包里是不是真有 8 个红石）。
- 弱核对的那几条是『客户端只管发请求、结果由服务端裁决』的（placeRecipe/recipebook 等），
  回包只代表请求已发出，所以不敢标硬证据。
- 原始记录：`measurements.jsonl` 的 `kind=e2e_api2`。

### [2026-10-01 23:5x] 运行时修正：第二批 API（观测纵深 + 动作纵深）

**`python tools/e2e_api2.py`：30 条，回读核对通过 25 条、弱核对 5 条、失败 0。**

新核实通过的（都做了**回读**，不是"没报错就算过"）：

| 组 | 条目 | 回读证据 |
|---|---|---|
| 观测 | vitals / world / light / biome / blockentity / entity / scoreboard / server / recipes | 告示牌文本 `MCP-SIGN`、箱子里开界面读到金锭 x7、计分板 42 分、钻石剑配方含 3 个原料 |
| 身体 | fly / ride / dismount / sleep / startUsing / releaseUsing | `flying=True 离地=True`、载具 boat 上下、`sleeping=True`、`using=True` |
| 手上 | drop / pickItem | 面包 8→7、中键选取后手持变石头 |
| 实体 | useOnEntity / useOnEntityAt | 对猪右键返回 PASS |
| 容器 | creativeGive / placeRecipe / recipeOptions / containerButton | 背包里真的有红石 x8 |
| 界面 | openInventory | 界面真的开了（`CreativeModeInventoryScreen`） |

**这轮最有价值的产出是 10 条"原版规则"**（详见 `skills/minecraft-api/SKILL.md` 第 10 章），
每一条都是"我先做错了 → 被运行时打脸 → 回源码找到真相"：

1. **中键选取不是 `handlePickItem`** —— 那是"把背包第 N 格挪到手上"；真逻辑在私有的
   `Minecraft.pickBlock()`（`:2231`）里，只能照抄它的三步。按错语义实现的那版点了毫无反应。
2. **站在地上飞行会被取消**（`LocalPlayer:784`）—— `flying=true` 会在 1.5 秒内自己变回 false。
   现在 `fly` 默认顺手给一点向上速度离地，实测能保持住。
3. **客户端那份计分板在单机下是空的** —— 服务端日志说 `Created new objective`，
   客户端读是 0；读服务端那份才有（2 个目标 / 42 分）。`scoreboard` op 现在两份都回并标 `source`。
4. **读方块实体要用 `saveWithoutMetadata()`**，`getUpdateTag()` 基类直接返空 tag。
5. **容器内容不同步给没开界面的客户端** —— 读箱子得到 `{Items:[]}` 是原版设计，不是缺陷。
6. **1.20.1 的船叫 `minecraft:boat`**（木种走 `{Type:"oak"}`），没有 `oak_boat`。
7. **命令的结果只能用 `chatlog` 看** —— 三次定位（船名/计分板/箱子）都是靠服务端回的聊天原话。
8. **状态跨跑累积**：上一轮睡在床上，这一轮 `fly`/`startUsing` 全都悄悄不生效。
   所以有了 `reset_test_state()`。
9. **`drop` 改的是数量不是物品名**。
10. **服务端裁决的结果不能当场读**：`pickItem` 当场读是 `air`、隔一拍才是 `stone`。

**判据纪律再强调一次**：回包 `ok=true` 只说明包送到了。改动类一律回读
（丢完看数量、飞完看 altitudes、给完看背包），回读不了的才退而标"弱核对"。

### [2026-10-01 23:34] 运行时修正

**第三/四批 API 运行时核实**（`python tools/e2e_api3.py`，共 10 条）：回读核对 10，弱核对 0，失败 0。

无失败项。
- 交易那条是重点：原版点交易按钮要三步（`setSelectionHint` + **`tryMoveItems`** + 发 `ServerboundSelectTradePacket`），少第二步付款槽是空的、点结果槽毫无反应。这里用一笔 NBT 写死的交易（1 绿宝石 → 3 面包）验，成交后**背包里真的多了 3 个面包**。
- 进度那条：单机读服务端权威进度（客户端那份 progress 是私有字段且会被成就界面抢监听器）。
- 原始记录：`measurements.jsonl` 的 `kind=e2e_api3`。

### [2026-10-02 00:2x] 运行时修正：第三/四批（交易 / 进度 / 世界设定 / 实体）

**`python tools/e2e_api3.py`：10 条，回读核对 10 条、失败 0。**

| # | 条目 | 回读证据 |
|---|---|---|
| D1 | `setWorld`（时间/天气/难度） | `dayTime 6021→18031`、`下雨 False→True`、`难度 peaceful→hard` |
| E9 | `spawn` | `entities` 里真的多了一只猪 |
| E10 | `nameTag` | `customName=MCP-PIG`（`entity` 回读） |
| E11 | `kill` | 猪从列表里消失 |
| F1/F2 | `advancements` | `story/root` 先 `done=False`，`/advancement grant` 后 `done=True percent=1.0` |
| G0–G3 | **跟村民交易** | 界面 `MerchantScreen` 开出来 → 读到 `1 绿宝石 → 3 面包` → 成交后**背包里真多了 24 个面包**、8 个绿宝石清零 |

**这轮又挖出三条原版规则，都是"看着像没反应"的那一类：**

1. **交易要三步，少一步就"点了没反应"** ★
   原版 `MerchantScreen.postButtonClick()`（`:55`）做的是：
   `menu.setSelectionHint(i)` → **`menu.tryMoveItems(i)`**（把付款物品从背包挪进付款槽）→
   发 `ServerboundSelectTradePacket(i)`。漏掉中间那步，付款槽是空的，
   点结果槽什么也不会发生 —— 而且**不报错**。
2. **成交要用 Shift+左键（`QUICK_MOVE`），不能用 `PICKUP`** ★
   `PICKUP` 点结果槽是把产物放到**光标上**（carried item），不进背包。
   实测踩过：日志显示成交、绿宝石从 8 变成 0、**面包一个没进包**（它挂在光标上）。
   换成 `QUICK_MOVE` 才进背包。另外**一次 QUICK_MOVE 可能成交不止一次**
   （付款够的话原版会把能换的都换掉，实测一次点击 8 绿宝石→24 面包），
   所以成交次数要按 `uses` 的增量算。
3. **村民会游荡，而且没交易就不开界面** ★
   - `Villager.mobInteract` 里有 `boolean flag = this.getOffers().isEmpty();` ——
     **没交易就直接 `setUnhappy()` 返回，不开界面**。所以测试必须用 NBT 写死 `Offers`。
   - 实测第二次跑的时候那只村民已经游荡到 **24 格开外**，interact 根本够不着。
     测试里要 `{NoAI:1b}` 把它定住 —— 这是"上一轮能过、这一轮过不了"的典型来源。
4. **进度在联机时读不到**：客户端 `ClientAdvancements.progress` 是私有字段，
   而且会被成就界面抢走监听器。单机直接读服务端那份权威进度
   （`ServerAdvancementManager` + `PlayerAdvancements#getOrStartProgress`）；
   联机如实报"读不到"，不编。

### [2026-10-01 23:49] 运行时修正

**第五批 API 运行时核实**（`python tools/e2e_api4.py`，共 6 条）：回读核对 4，弱核对 0，失败 2。

失败项：挖完之后 mined/stone 计数变大（回读核对）、stats{custom} 有内容
- `stats`：挖一个方块之后 `mined/minecraft:stone` 计数真的涨了 —— 注意统计是**服务端回 AwardStats 包**才涨的，读之前要等。
- `sounds`：挖石头之后声音流水里确实出现了对应的方块声（挂 `PlaySoundEvent` 抄的）。
- `bossBars`：招出凋灵后读到它的血条，清掉之后消失 —— 判据是渲染时被画出来过（`BossHealthOverlay:36` 发的 `CustomizeGuiOverlayEvent.BossEventProgress`）。
- 原始记录：`measurements.jsonl` 的 `kind=e2e_api4`。

### [2026-10-01 23:53] 运行时修正

**第五批 API 运行时核实**（`python tools/e2e_api4.py`，共 6 条）：回读核对 5，弱核对 0，失败 1。

失败项：挖完之后 mined/stone 计数变大（回读核对）
- `stats`：挖一个方块之后 `mined/minecraft:stone` 计数真的涨了 —— 注意统计是**服务端回 AwardStats 包**才涨的，读之前要等。
- `sounds`：挖石头之后声音流水里确实出现了对应的方块声（挂 `PlaySoundEvent` 抄的）。
- `bossBars`：招出凋灵后读到它的血条，清掉之后消失 —— 判据是渲染时被画出来过（`BossHealthOverlay:36` 发的 `CustomizeGuiOverlayEvent.BossEventProgress`）。
- 原始记录：`measurements.jsonl` 的 `kind=e2e_api4`。

### [2026-10-01 23:54] 运行时修正

**第五批 API 运行时核实**（`python tools/e2e_api4.py`，共 6 条）：回读核对 5，弱核对 0，失败 1。

失败项：挖完之后 mined/stone 计数变大（回读核对）
- `stats`：挖一个方块之后 `mined/minecraft:stone` 计数真的涨了 —— 注意统计是**服务端回 AwardStats 包**才涨的，读之前要等。
- `sounds`：挖石头之后声音流水里确实出现了对应的方块声（挂 `PlaySoundEvent` 抄的）。
- `bossBars`：招出凋灵后读到它的血条，清掉之后消失 —— 判据是渲染时被画出来过（`BossHealthOverlay:36` 发的 `CustomizeGuiOverlayEvent.BossEventProgress`）。
- 原始记录：`measurements.jsonl` 的 `kind=e2e_api4`。

### [2026-10-01 23:56] 运行时修正

**第五批 API 运行时核实**（`python tools/e2e_api4.py`，共 6 条）：回读核对 5，弱核对 0，失败 1。

失败项：挖完之后 mined/stone 计数变大（回读核对）
- `stats`：挖一个方块之后 `mined/minecraft:stone` 计数真的涨了 —— 注意统计是**服务端回 AwardStats 包**才涨的，读之前要等。
- `sounds`：挖石头之后声音流水里确实出现了对应的方块声（挂 `PlaySoundEvent` 抄的）。
- `bossBars`：招出凋灵后读到它的血条，清掉之后消失 —— 判据是渲染时被画出来过（`BossHealthOverlay:36` 发的 `CustomizeGuiOverlayEvent.BossEventProgress`）。
- 原始记录：`measurements.jsonl` 的 `kind=e2e_api4`。

### [2026-10-01 23:58] 运行时修正

**第五批 API 运行时核实**（`python tools/e2e_api4.py`，共 6 条）：回读核对 6，弱核对 0，失败 0。

无失败项。
- `stats`：挖一个方块之后 `mined/minecraft:stone` 计数真的涨了 —— 注意统计是**服务端回 AwardStats 包**才涨的，读之前要等。
- `sounds`：挖石头之后声音流水里确实出现了对应的方块声（挂 `PlaySoundEvent` 抄的）。
- `bossBars`：招出凋灵后读到它的血条，清掉之后消失 —— 判据是渲染时被画出来过（`BossHealthOverlay:36` 发的 `CustomizeGuiOverlayEvent.BossEventProgress`）。
- 原始记录：`measurements.jsonl` 的 `kind=e2e_api4`。

### [2026-10-02 01:0x] 运行时修正：第五批（统计 / 声音 / 首领条）

**`python tools/e2e_api4.py`：6 条，回读核对 6 条，失败 0。**

| # | 条目 | 回读证据 |
|---|---|---|
| H1/H2 | `stats{mined}` | 生存挖一个石头：`minecraft:stone` 1 → 2 |
| H3 | `stats{custom}` | 读到 `play_time` / `total_world_time` 等 8 条非零 |
| I1 | `sounds` | 挖石头后流水里出现 `minecraft:block.stone.hit` ×N 与 `block.stone.break` |
| J1/J2 | `bossBars` | 招凋灵后读到 `Wither progress=1.0`；清掉后 0 条 |

**这轮最重要的一条不是功能，是崩游戏：**

- **事件回调里抛异常 = 整局崩。** 我读 `sound.getVolume()` 时，音乐轨那个实例内部
  `Sound` 还是 null → NPE → Forge 事件总线把异常一路抛到 `Minecraft.tick` → 客户端崩。
  教训：**请求-应答那条路（Dispatcher）早就 try/catch 了，事件回调是另一条路，
  忘了包就是玩家掉线。** 现在每个 `@SubscribeEvent` 整个函数体都包住了。
- **客户端统计默认是空的**：原版只在打开统计界面时才发 `REQUEST_STATS`
  （`StatsScreen:69`），服务端 `ServerStatsCounter.sendStats:176` **只发 dirty 的那部分**。
  所以 `stats` 是挂账型：先请求 → 等 10 tick → 再读。
- **创造模式挖方块不计入 `mined` 统计**：`ServerPlayerGameMode#destroyBlock` 的
  `isCreative()` 分支提前返回，不调 `Block#playerDestroy`。实测创造模式挖半天计数是 0，
  切生存挖一次立刻 1。**判据必须弄清"那个动作在哪个模式下才算数"。**
- **首领条只能从渲染事件拿**（`BossHealthOverlay.events` 是包级私有），
  所以判据天然是"屏幕上真的显示过"。

### [2026-10-02 00:08] 运行时修正

**第六批 API 运行时核实**（`python tools/e2e_api5.py`，共 9 条）：回读核对 6，弱核对 1，失败 2。

失败项：openScreen video、chatlog 里出现了规则清单
- `openScreen`：没有按键入口的界面（视频/音效/统计）能直接构造并 setScreen。
- `setWidget`：滑块只能『按比例算 x 点过去』——`AbstractSliderButton.setValue` 是私有的。
- `gamerule`：借原版 `/gamerule` 的输出，不硬编码规则表；改完再查一次确认。
- `cooldowns`：扔末影珍珠之后冷却列表里真的有它。
- 原始记录：`measurements.jsonl` 的 `kind=e2e_api5`。

### [2026-10-02 00:11] 运行时修正

**第六批 API 运行时核实**（`python tools/e2e_api5.py`，共 9 条）：回读核对 7，弱核对 1，失败 1。

失败项：openScreen video
- `openScreen`：没有按键入口的界面（视频/音效/统计）能直接构造并 setScreen。
- `setWidget`：滑块只能『按比例算 x 点过去』——`AbstractSliderButton.setValue` 是私有的。
- `gamerule`：借原版 `/gamerule` 的输出，不硬编码规则表；改完再查一次确认。
- `cooldowns`：扔末影珍珠之后冷却列表里真的有它。
- 原始记录：`measurements.jsonl` 的 `kind=e2e_api5`。

### [2026-10-02 00:13] 运行时修正

**第六批 API 运行时核实**（`python tools/e2e_api5.py`，共 9 条）：回读核对 8，弱核对 0，失败 1。

失败项：拖完之后滑块上显示的值真的变了（回读核对）
- `openScreen`：没有按键入口的界面（视频/音效/统计）能直接构造并 setScreen。
- `setWidget`：滑块只能『按比例算 x 点过去』——`AbstractSliderButton.setValue` 是私有的。
- `gamerule`：借原版 `/gamerule` 的输出，不硬编码规则表；改完再查一次确认。
- `cooldowns`：扔末影珍珠之后冷却列表里真的有它。
- 原始记录：`measurements.jsonl` 的 `kind=e2e_api5`。

### [2026-10-02 00:14] 运行时修正

**第六批 API 运行时核实**（`python tools/e2e_api5.py`，共 9 条）：回读核对 9，弱核对 0，失败 0。

无失败项。
- `openScreen`：没有按键入口的界面（视频/音效/统计）能直接构造并 setScreen。
- `setWidget`：滑块只能『按比例算 x 点过去』——`AbstractSliderButton.setValue` 是私有的。
- `gamerule`：借原版 `/gamerule` 的输出，不硬编码规则表；改完再查一次确认。
- `cooldowns`：扔末影珍珠之后冷却列表里真的有它。
- 原始记录：`measurements.jsonl` 的 `kind=e2e_api5`。

### [2026-10-02 02:0x] 运行时修正：第六批（界面长尾 / 世界规则 / 冷却）

**`python tools/e2e_api5.py`：9 条，回读核对 9 条，失败 0。**

| # | 条目 | 回读证据 |
|---|---|---|
| K-video/sound/stats | `openScreen` | 三个界面都真的开出来了（视频 25 个控件 / 音效 14 个 / 统计 4 个） |
| L1a | `setWidget` 拖滑块 | `Master Volume: 90% → 50%`（改完再读界面控件文字） |
| M1 | `gamerule` 列全部 | 45 条，`doFireTick=true` |
| M2 | `gamerule` 改一条 | 命令回话 `is now set to: false`，再查 `is currently set to: false` |
| N2 | `cooldowns` | 扔末影珍珠之后冷却列表里有 `minecraft:ender_pearl` |

**又挖出 4 条（SKILL 第 10 章 N21-N24）：**

- **`openScreen` 的父界面必须"已经被 init 过"**：连踩两轮 NPE ——
  传 `null` 不行，传一个刚 `new` 出来的 `PauseScreen` 也不行，
  因为 `Screen.minecraft` 是在 `init()` 里赋值的，而 `init` 由 `setScreen` 调。
  做法改成"先 setScreen 上暂停菜单，再拿 `mc.screen` 当父界面"。
- **滑块不能设值，只能按比例点坐标**（`setValue` 是 private，`AbstractSliderButton:115-121`），
  而且钳到 0..1。实测拖动生效。
- **`/gamerule` 不支持列出全部**（实测回 `Unknown or incomplete command`），
  `GameRules` 也没有遍历入口 → 攒了份 45 条的字段名单（抄自源码），
  名字用 `Key.getId()` 运行时取；取值只能走 `serialize()`（`Value` 没有 `get()`）。
- **设置是持久化的**：音效滑块拖过一次会写进 `options.txt`，
  下一轮拖到同一个值就"没变化" —— 测试要挑跟当前不同的目标值。
