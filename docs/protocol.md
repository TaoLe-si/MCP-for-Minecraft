# 动态服务协议（MCP for Minecraft Control Protocol）

> 版本：mcpc/1
> 传输：TCP，默认 `127.0.0.1:25585`（可用 `-Dmcpforminecraft.port=` 覆盖）
> 编码：UTF-8，**换行分隔的 JSON**（NDJSON），一行 = 一个包

这是"发送端 → 游戏内"的那根线。发送端是 `tools/mcmcp.py`（MCP 服务），
接收端是模组里的 `ControlServer`。一条 `move` 包从 MCP 工具调用发出，落到游戏线程上
执行，玩家真的会往前走。

## 1. 封包格式

请求（客户端 → 游戏）:

```json
{"id": 1, "op": "move", "args": {"forward": 1.0, "ticks": 40}}
```

响应（游戏 → 客户端）:

```json
{"id": 1, "ok": true, "result": {...}}
{"id": 1, "ok": false, "error": "还没进世界，动不了"}
```

- `id`：客户端自增，响应原样带回（同一条连接内请求**串行**，不做多路复用）
- `op`：操作码，见第 3 节全表
- `args`：参数对象，可省略
- 未知 `op` / 参数错误 → `ok:false`，连接**不断开**（失败不该让调试线掉线）

## 2. 动作的时间语义

这是本协议最要紧的一条约定，三类 op 的行为不一样：

| 类别 | 行为 | 例子 |
|---|---|---|
| **瞬时** | 当场做完就回包 | `state` / `block` / `place` / `clickButton` / `chat` |
| **占时** | **等动作走完**才回包，`before`/`after` 一并在包里 | `move` / `key` / `jump` / `press` / `break` |
| **挂账** | 立刻回包，动作在后台继续 | 目前没有（预留） |

占时类不用调用方轮询：`ticks=40` 就是等 40 tick 过去、键已松开，响应里直接带
前后两帧观测。代价是**别把 `ticks` 开太大**，回包会一直等（超时按 ticks 放宽，
见 `Dispatcher`）。

## 3. 操作码全表

### 3.1 存活与观测（只读）

| op | args | 说明 |
|---|---|---|
| `ping` | – | 探活。回 `pong, side, inWorld, tick`；只读 volatile 快照，专服上也能答 |
| `state` | – | 玩家/世界快照（第 4 节） |
| `block` | `x, y, z` | 单方块：id、是否空气、硬度、**方块状态属性**（facing/open/powered…）、有无方块实体 |
| `blocks` | `x1,y1,z1,x2,y2,z2, filter?, limit?` | 区域扫描，只回非空气。体积上限 100 万格，`limit` 默认 512 |
| `entities` | `radius?, type?, limit?` | 附近实体：id / 类型 / 名字 / 坐标 / 距离 / 血量 |
| `inventory` | – | 背包所有非空槽 + 选中槽 + 手持 + 副手 |
| `screen` | – | 当前界面的**控件清单**（含文字、位置、大小、是否变灰）+ 容器槽位 |
| `ray` | `reach?` | 视线射线命中的方块或实体（`reach` 默认 4.5） |

### 3.2 日志（只读）

| op | args | 说明 |
|---|---|---|
| `log` | `lines?, filter?` | 游戏日志尾部（原版和所有模组写的那份 `latest.log`）。从文件尾捞 512KiB 再切行，不整读 |
| `chatlog` | `lines?` | 最近聊天/系统消息。模组自己抄的流水，不依赖原版聊天窗 |
| `events` | `lines?` | 事件流水：**执行过的每个动作**、界面开关、换维度、死亡、复活、进出世界 |

### 3.3 按键层（原版输入链路）

| op | args | 说明 |
|---|---|---|
| `key` | `keys{名→开关}, ticks` | 按住/松开若干键 N tick，到点**自动全松**（不会卡键） |
| `press` | `key, ticks?` | 敲一下：按下→松开。同时补一次 `KeyMapping.click`，所以 `consumeClick` 型的功能也叫得动 |
| `move` | `forward, ticks, yaw?` | `key` 的语义封装：往前走。带 `yaw` 就先转向再走 |
| `jump` | `ticks` | 按住跳跃 N tick |

**按键全表**（跟 `Options` 里的字段一一对应，见 `skills/minecraft-api/SKILL.md`）:

```
forward back left right jump sneak sprint
attack use pickItem inventory drop swapOffhand
chat command playerList socialInteractions
togglePerspective smoothCamera fullscreen spectatorOutlines advancements screenshot
saveHotbar loadHotbar hotbarSlot1 … hotbarSlot9
```

`key`/`press` 走的是原版 `KeyMapping`，所以**玩家真的走、真的攻击**：
服务端收得到移动包、算得到碰撞、别的模组也看得见。

### 3.4 朝向

| op | args | 说明 |
|---|---|---|
| `look` | `yaw, pitch?` | 直接设朝向（度） |
| `lookAt` | `x, y, z` | 看向某坐标（自动算 yaw/pitch） |

约定：`yaw=0` → +Z，`yaw=90` → −X，`yaw=180` → −Z，`yaw=270` → +X。

### 3.5 世界改动（走 `MultiPlayerGameMode`，服务端认账）

| op | args | 说明 |
|---|---|---|
| `break` | `x,y,z, face?` | 挖掉方块。生存按硬度挖若干 tick，**挖穿才回包**；到时间上限会如实回报 |
| `place` | `x,y,z, face?` | 在 (x,y,z) 放一个方块：对着相邻方块的面用手里/选中的物品 |
| `interact` | `x,y,z, face?` | 对着该方块右键：开门、按按钮、拉杆、开容器 |
| `attack` | `entityId?` | 攻击。给了 id 就先转过去再打；不给就打准星指着的 |
| `use` | `hand?` | 使用手中（`main`，默认）或副手（`off`）的物品 |
| `selectSlot` | `slot` | 选快捷栏 1..9（也接受 0..8）。顺带把切换告诉服务端 |
| `scroll` | `amount` | 滚轮切快捷栏 | 

**这些 op 都不直接改方块**。直接改本地方块，服务端一同步就给你拉回去，
看起来还像"方块凭空没了"。走 `gameMode` 就是走原版左键/右键那条路，
由服务端仲裁后回同步包 —— 慢一点，但是真的。

### 3.6 界面

| op | args | 说明 |
|---|---|---|
| `clickButton` | `label?` 或 `index?` | 按文字（子串、不分大小写）或序号点按钮。找不到会把**所有按钮列出来** |
| `typeText` | `text, index?, submit?` | 往输入框打字；`submit=true` 顺带回车 |
| `clickSlot` | `slot, button?, clickType?` | 点容器槽位，走 `handleInventoryMouseClick`（服务端仲裁） |
| `closeScreen` | – | 关掉当前界面 |

`clickButton` 的实现是 `screen.mouseClicked(控件中心x, 控件中心y, 0)` ——
跟真人鼠标落在按钮中心是同一条路（`ContainerEventHandler.mouseClicked` 派发给命中的子控件，
再落到 `AbstractButton.onClick → onPress`）。**不反射、不假装移动鼠标。**

### 3.7 通信与截图

| op | args | 说明 |
|---|---|---|
| `chat` | `text, command?` | `command=true` 走 `/命令`，否则走聊天 |
| `shot` | `name?` | 截图存 PNG，回绝对路径与字节数 |

## 4. 观测快照的形状

`state`（也是占时类 op 里 `before`/`after` 的形状）:

```json
{
  "inWorld": true,
  "tick": 1234,
  "dim": "minecraft:overworld",
  "pos":  {"x": 0.5, "y": 65.0, "z": 0.5},
  "rot":  {"yaw": 0.0, "pitch": 0.0},
  "look": {"x": 0.0, "y": 0.0, "z": 1.0},
  "onGround": true,
  "sneaking": false,
  "sprinting": false,
  "health": 20.0,
  "food": 20,
  "held": "minecraft:air",
  "screen": null
}
```

- `pos` 是脚底实体坐标（`Entity#getX/Y/Z`），不是眼睛位置
- `look` 是朝向单位向量；`rot` 跟它互为换算，两个都给是因为"往前走"的判据用向量更好写
- `screen` 非 null 表示开着界面（给类名）；**界面开着时按键不生效**（单机会暂停）

## 5. 时序与线程

- **所有改动游戏状态的 op 都在客户端主线程（游戏线程）上执行**。TCP 线程只做收发，
  通过 `Minecraft#execute` 投递任务。观测类的等结果回传；占时类由 `GameActions`
  在 tick 里推进、到点自己 complete。
- "占时"类**不会卡住游戏**：倒计时发生在游戏线程之外，游戏照常 20 TPS。
- 挂账上限：`break` 400 tick，按键类 `ticks + 200` tick。到点强制收工并**如实回报**，
  不谎报成功。
- 离开世界（退回主菜单/断开）时会自动松键、清空挂账动作。

## 6. 输入隔离：不碰真机

本协议的所有动作**都发生在游戏进程内部**，不走任何操作系统级的输入注入
（不用 `SendInput`、不用鼠标钩子、不抢窗口焦点、不模拟 HID）。转视角是
`Entity#setYRot/setXRot`，点按钮是 `Screen#mouseClicked(控件中心坐标)`，
按键是 `KeyMapping#setDown` —— 真机的鼠标、键盘、光标一概不动。

唯一的"游戏内"边界：同一窗口里模拟按键和真人按键争同一个 `KeyMapping`，
人不巧正握着同一个键时会被代理的"松手"影响。要完全隔离就开两个客户端。

`awaitScreen` / `mc_open` 这类"等效果落地"的开关也列在协议里，因为它们是**服务端仲裁**
的结果，回包不等于已生效 —— 详见 `skills/minecraft-runtime/SKILL.md` 第 3 节。

## 6. 判据与实测

每条会动的 op 的响应都带 `before`/`after`，所以**位移是随包回来的**：

```
位移 = after.pos - before.pos
tick 差 = after.tick - before.tick
```

`mc_move` 已经把它算好写上去了（距离、格/秒）。光看 `ok:true` **不算数** ——
那只能说明包送到了。`tools/e2e.py` 就是拿这三条判据（位移、tick、画面变化）
做端到端验收的。

`tools/mcmcp.py` 把实测写进 `skills/minecraft-runtime/measurements.jsonl`（只增不改），
和静态说法对不上就以实测为准记账。

## 7. 与 Forge 网络包的关系

本协议跑在**进程外**：外部发送端根本拿不到游戏内的 Netty 通道，所以复用不了
Forge 的 `SimpleChannel`。模组内部把请求归一成同一组操作，由 `ControlServer`
投递到游戏线程。

以后若要加"客户端 ↔ 服务端"的模组自有包（多人场景下由服务端仲裁），
在同一套 op 语义上加一条 `SimpleChannel` 投递路径即可，调用方不用改。
