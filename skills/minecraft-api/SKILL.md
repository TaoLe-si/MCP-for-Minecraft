# API SKILL：从外部驱动 Minecraft 1.20.1（Forge）

> **性质：静态归纳。** 本文的每条结论都来自**读源码**（反编译产物，见第 7 节），
> 不是试出来的、也不是"看着像"。凡是没读到证据的一律标【待测】，
> 由 `skills/minecraft-runtime/SKILL.md` 里的实测去确认或推翻。
>
> 完整操作码表在 `docs/protocol.md`，本文讲**为什么这么设计**和**哪里会踩坑**。

## 0. 分层：谁在跟谁说话

```
MCP 工具 (tools/mcmcp.py)        36 个工具
   │  mc_move / mc_break / mc_click_button / mc_log ...
   ▼
换行分隔 JSON 包（docs/protocol.md）
   │  {"id":1,"op":"move","args":{"forward":1,"ticks":40}}
   ▼  TCP 127.0.0.1:25585
模组动态服务
   │  ControlServer（私有方法，只收发）→ Dispatcher（路由）→ 游戏线程
   ▼
原版输入链路 / MultiPlayerGameMode / 界面事件派发
   ▼
玩家真的走、方块真的掉、按钮真的按下
```

**"发送端发一个往前走的包"就是中间那一行 JSON。**

## 1. 三条实现纪律

这三条决定了"像不像真的"，也是本仓库跟"直接改内存"那类做法的分界：

1. **按键走路走原版输入链路**（`KeyMapping` → `KeyboardInput` → `LocalPlayer.aiStep`）。
   服务端照收移动包、照算碰撞、别的模组照看得见。
2. **改方块走 `MultiPlayerGameMode`**（`startDestroyBlock/continueDestroyBlock/useItemOn`）。
   直接改本地方块 = 服务端一同步就拉回去，而且看起来像方块凭空消失。
3. **点按钮走界面事件派发**（`screen.mouseClicked(控件中心)`）。
   不反射、不假装移动鼠标 —— 弹道跟真人鼠标落在按钮中心完全一样。

## 2. 玩家行为：按键那条线

### 2.1 按键 → 位移

`KeyboardInput.tick()` 每 tick 读一遍 `options.keyUp.isDown()`，算成 `forwardImpulse`：

- `KeyboardInput.java:24` `this.up = this.options.keyUp.isDown();`
- `KeyboardInput.java:28` `this.forwardImpulse = calculateImpulse(this.up, this.down);`
- `KeyMapping.java:206` `public void setDown(boolean)` —— 公开可写，**这就是抓手**
- `KeyMapping.java:107` `public boolean isDown()`

### 2.2 三个必须照做的坑

**(a) 按住的键每 tick 都要复述。** `Minecraft#setScreen()` 打开任何界面时会调
`KeyMapping.releaseAll()`（`Minecraft.java:1006`），窗口失焦也会清。只按一次会中途松手。

**(b) `keyShift`/`keySprint` 是开关型。** `ToggleKeyMapping.java:17-23`：

```java
public void setDown(boolean p) {
    if (this.needsToggle.getAsBoolean()) {      // 玩家开了"潜行/疾跑切换"选项
        if (p && isConflictContextAndModifierActive())
            super.setDown(!this.isDown());      // 真值 = 取反！
    } else {
        super.setDown(p);                       // 普通语义
    }
}
```

无脑每 tick `setDown(true)` 会**来回翻转**；`setDown(false)` 在切换模式下**是空操作**。
正确用法：当前状态与目标不符才按一次（`InputOverride.force()`）。

**(c) `setDown` 不增加 `clickCount`。** 只有 `KeyMapping.click(InputConstants.Key)`
会（`KeyMapping.java:45-50`）。而"开背包 / 丢弃 / 切视角 / 快捷栏 1-9 / 交换副手 /
成就 / 社交"这些是走 `consumeClick()` 的（`Minecraft#handleKeybinds`）。
**所以"敲一下"必须两个都做**：`click(...)` 让 consumeClick 型的响应，
`setDown(true/false)` 让 isDown 型的响应。`press` op 就是这么实现的。

### 2.3 按键全表（跟 `Options` 字段一一对应）

```
移动类  forward back left right jump sneak sprint
战斗类  attack use pickItem
背包类  inventory drop swapOffhand hotbarSlot1..9 saveHotbar loadHotbar
通信类  chat command playerList socialInteractions
杂项    togglePerspective smoothCamera fullscreen spectatorOutlines advancements screenshot
```

`Options.java:415-440` 是这些字段的原文。名字掰不弯 —— 写了别的会直接报错并提示。

## 3. 玩家行为：视角与坐标

- `Entity.java:3315/3327` `setYRot/setXRot` —— 直接设朝向，客户端会正常把转身发给服务端
- 同时要设 `yRotO/xRotO`（上一 tick 的朝向），否则渲染插值会抖一下
- 朝向约定：`yaw=0` → +Z，`yaw=90` → −X，`yaw=180` → −Z，`yaw=270` → +X

## 4. 方块与容器

- 挖：`MultiPlayerGameMode.java:134/198` `startDestroyBlock` + `continueDestroyBlock`，
  每 tick 推一次，`level.getBlockState(pos).isAir()` 为真就是挖穿了
- 放/交互：`MultiPlayerGameMode.java:287` `useItemOn(player, hand, BlockHitResult)`
  - **放**在某坐标 = 点它**相邻**方块的面（`clickPos = pos.relative(face.getOpposite())`）
  - **交互**某坐标 = 直接点它就是（`clickPos = pos`）
- 手要挥：`player.swing(InteractionHand.MAIN_HAND)`，否则客户端看着像没动
- 切快捷栏：`Inventory.java:141` `swapPaint` 只改本地 `selected`，
  同步给服务端要自己发 `ServerboundSetCarriedItemPacket`
  （原版 `MultiPlayerGameMode#ensureHasSentCarriedItem` 是私有的，别的动作会顺手发，
  但我们不该为了它去调一次"使用物品"）

## 5. 界面

- 遍历控件：`Screen` 实现 `ContainerEventHandler`，`children()` 递归摊平
  （`AbstractContainerEventHandler.java` 的 default 实现）
- 点按钮：`ContainerEventHandler.mouseClicked(x, y, button)` 是 **default 方法**，
  会派发给命中的子控件 → `AbstractWidget.mouseClicked` → `AbstractButton.onClick`
  → `onPress()`。所以**按控件中心坐标调一次即可**，不用反射
- `AbstractWidget.mouseClicked` 的前提：`active && visible && button==0 && isMouseOver`
  —— 所以"灰按钮"点了没反应是正常的，`clickButton` 遇到灰按钮会直接报错
- 输入框：`EditBox.setValue/setFocused`（`EditBox.java:93/490`）
- 槽位：`MultiPlayerGameMode.handleInventoryMouseClick(containerId, slot, button, ClickType, player)`

⚠️ **单机开着界面时游戏是暂停的**（`isPaused()`），此时按键类 op 不会生效。
`InputOverride.requirePlayable` 会直接报错，而不是假装能动。
要操作界面请用 `screen`/`clickButton`/`clickSlot`，操作完 `closeScreen`。

## 6. 日志

- `log`：读 `<游戏目录>/logs/latest.log`。**不自己存一份** —— log4j 已经把原版和
  所有模组的东西写进去了，自己再存只会更差更假。从文件尾捞 512KiB 再切行。
- `chatlog` / `events`：模组自己抄的流水（`Journal`，环形缓冲 500 条）。
  - 聊天窗口的内容在客户端是渲染期结构，取纯文本要拐好几道弯，所以挂
    `ClientChatReceivedEvent` 自己收
  - "操作流水"原版压根没有：每个 op、每次界面开关、换维度、死亡都记一笔，
    排查"我明明发了包为什么没动"时这是唯一的线索

## 7. 量级预期（**待测**，不是结论）

从源码能推到的**输入值**：

- `Player.java:200` 玩家 `MOVEMENT_SPEED` 基础值 = `0.1F`；`Player.java:1449` `getSpeed()` 返回它

**走路速度：已实测钉死（2026-10-01）。** 稳态 **4.317 格/秒**，正好等于从那个 `0.1`
推出来的原版值；短程会因起步加速明显偏低，拟合式为
`位移 ≈ 4.317 × (ticks − 1.2) / 20`。**细节与原始数据见
`skills/minecraft-runtime/SKILL.md` 第 2 节** —— 这里只留一句"静态预期已被证实"，
具体数字以实测那份为准（本节的职责是给预期，不是给结论）。

仍未测：
- 疾跑（`keys.sprint=true` + forward）多少格/秒；潜行掉到多少
- 跳跃峰值高度；40 tick 内能不能跨 1 格坎
- 挖一个 `minecraft:dirt` / `minecraft:stone` 各要多少 tick
- `place` 在空手时会返回什么（预期 `InteractionResult.PASS`，`consumed=false`）

## 8. 输入隔离（硬要求）

**代理驱动游戏时不许碰真机的鼠标和键盘。** 本仓库在实现上就避开了所有操作系统级注入
（`SendInput`/鼠标钩子/抢焦点/pyautogui 一类），全部改成在游戏进程内改原版状态：

- 转视角 → `Entity#setYRot/setXRot`，**不是**移动鼠标、不碰 `MouseHandler`（它的
  `onPress/onScroll/onMove` 还是私有方法，反射进去既脆又没必要）
- 点按钮 → `Screen#mouseClicked(控件中心)`，不是移动光标
- 按键 → `KeyMapping#setDown` / `KeyMapping#click`

这条既是给用户的保证（代理跑着的时候电脑照常用），也是选型理由：
**语义接口比"模拟输入设备"更好用，还顺带没有副作用。**

## 9. 纪律

1. **不编造**：写进 runtime SKILL 的数必须是某次真实调用的回包算出来的，并附上那次调用。
2. **静态让位于实测**：本文任何一条与 `measurements.jsonl` 冲突，以实测为准，
   并且**回头改本文**，不许两边并存。
3. **量级异常先怀疑环境**：人不动，先看 `mc_ping` 的 `tick` 涨不涨（不涨 = 暂停/卡住），
   再看 `state.screen` 是不是开着界面，最后才怀疑按键逻辑。
4. **超时不等于失败**：`break` 到 400 tick 上限会如实回报，不会谎报成功。

## 10. 原版规则：读源码 + 跑实测双向核实的那些坑

这一节是**第二轮**的产出。每一条都是"先说错 → 被运行时打脸 → 回源码找到真相"，
所以格外值得记 —— 它们都是**看着像 bug、其实是原版行为**或者**我理解错了 API 语义**的类型。

### N1. 中键"选取方块"不是 `handlePickItem` ★

- `MultiPlayerGameMode.handlePickItem(int slot)`（`:518`）的语义是
  **"把背包第 slot 格挪到手上"** —— 服务端 `ServerGamePacketListenerImpl:607` 收到后
  调的是 `inventory.pickSlot(slot)`，跟"准星指着什么"毫无关系。
- 真正的"中键选取"逻辑写在 `Minecraft.pickBlock()` 里，而它是 **private**（`Minecraft:2231`）。
  想用只能照抄它的步骤：
  1. 从准星命中结果取方块：Forge 的
     `IForgeBlockState#getCloneItemStack(HitResult, BlockGetter, BlockPos, Player)`
     （在 `net/minecraftforge/common/extensions/IForgeBlockState.java:223`）；
  2. **创造模式**：`inventory.setPickedItem(stack)` → 再
     `handleCreativeModeItemAdd(手持, 36 + selected)`。那个 **36** 是服务端那边快捷栏的起始槽号；
  3. **生存模式**：`inventory.findSlotMatchingItem(stack)` 找到同一个物品 ——
     在快捷栏里就直接 `inventory.selected = i`，否则 `handlePickItem(i)` 把它换上来。
- 实测：按上面重写后，`pickItem` 一次点中（`方式=creative，回读手持=minecraft:stone`）。
  之前那版传了个 selected 槽进去，什么都没发生。

### N2. 站在地上飞行会被原版取消 ★

`LocalPlayer:784`：

```java
super.aiStep();
if (this.onGround() && this.getAbilities().flying && !this.minecraft.gameMode.isAlwaysFlying()) {
    this.getAbilities().flying = false;
    this.onUpdateAbilities();
}
```

- 实测：`fly{on:true}` 之后**当场读是 True，1.5 秒后变回 False**。
- 所以"开飞行"必须**同时离地**，否则下一 tick 就被抹掉。`fly` op 现在默认顺手给一点向上的
  速度（`lift`，可关），实测 `flying=True 离地=True` 保持住了。
- 顺带：`Player.onUpdateAbilities()` 是个**空方法**（`Player:1732`），真正发包的是
  `LocalPlayer:335`（重写过，发 `ServerboundPlayerAbilitiesPacket`）和 `ServerPlayer:1230`。
  所以客户端侧调 `player.onUpdateAbilities()` 是对的 —— 但要看是哪一边的 `player`。

### N3. 客户端那份计分板在单机下是空的 ★

- 实测硬证据：服务端日志明明回了 `Created new objective [mcp]`、`Set [mcp] for Dev to 42`，
  但读 `ClientLevel.getScoreboard()` 得到 **0 个目标**；同一时刻读
  `MinecraftServer.getScoreboard()`（`ServerScoreboard`）得到 **2 个目标、分数 42**。
- 代码路径上 `ClientPacketListener.handleAddObjective`（`:2072` 一带）写的确实是
  `this.level.getScoreboard()`，且 `ClientPacketListener:404` 就是
  `this.minecraft.setLevel(this.level)` —— 两边是同一个 `ClientLevel` 实例
  （`identityHashCode` 一致）。**但那份里就是没有数据。**
- 结论对使用者只关心一件事：**单机时想读计分板，读服务端那份。**
  `scoreboard` op 现在两份都回，并带 `source` 字段标明哪个有数据。

### N4. 读方块实体要用 `saveWithoutMetadata()`，不是 `getUpdateTag()` ★

- `BlockEntity.getUpdateTag()` 的基类实现（`BlockEntity:163`）是
  `return new CompoundTag();` —— **直接给个空 tag**。只有少数几类自己覆写了
  （`BrushableBlockEntity:199`、`CampfireBlockEntity:142`、`DecoratedPotBlockEntity:43`、
  `ConduitBlockEntity:74`、`JigsawBlockEntity:101`、`SpawnerBlockEntity:61`、
  `StructureBlockEntity:141`）。
- 该用的是 `BlockEntity.saveWithoutMetadata()`（`BlockEntity:75`，`public final`），它会调
  `saveAdditional`。换过来之后告示牌文本读到了（`front_text` 里的 `MCP-SIGN`）。

### N5. 容器内容**不会**同步给没开界面的客户端 ★

- 实测：往箱子里 `/item replace block … container.0 with minecraft:gold_ingot 7`，
  服务端回了 `Replaced a slot at … with [Gold Ingot]`；
  但 `blockentity` 读那口箱子得到 `{Items:[]}` —— **本地这份方块实体里根本没东西**。
- 这不是缺陷，是原版设计：容器物品走"开界面 → 菜单 slots"那条路同步。
- 所以想读箱子/熔炉里有什么：**`mc_open`（interact + awaitScreen）把界面开出来，
  再读 `mc_screen` 的 slots**。实测这样能读到那 7 个金锭。
- 换个角度说：`blockentity` 适合读**方块实体自己的状态**（告示牌的文本、熔炉的火、
  营火上的东西），不适合读容器内容。

### N6. 1.20.1 的船叫 `minecraft:boat`，不叫 `oak_boat`

- `EntityType:177`：`register("boat", …)`。木种走 NBT：`{Type:"oak"}`。
- `oak_boat` 是 1.21.3 之后才拆出来的。凭记忆写会得到服务端的
  `Can't find element 'minecraft:oak_boat' of type 'minecraft:entity_type'`。
- **教训**：这类"名字记不准"的错误，静态读一遍 `EntityType` 就能避免；
  幸好在测试里用 `chatlog` 抓到了服务端的原话。

### N7. 命令的结果只能用 `chatlog` 看

`/setblock`、`/summon`、`/give`、`/scoreboard` 这类命令，无论成功失败，**回包都是
客户端本地立刻构造的**（`sendCommand` 只负责把包发出去），真相在服务端回的
系统聊天里。所以：

- 命令发完立刻读世界状态**可能读到旧值**（要轮询，见 M8）；
- 命令**失败**只有 `chatlog` 会告诉你（`Can't find element …`、`No blocks were filled`）。
- 这一条在排查 N6/N3/N5 时救了命 —— 三次都是靠 `chatlog` 里服务端的原话定位的。

### N8. 状态会跨跑累积，跑批前必须重置 ★

同一个世界连着跑几轮，会积累出**看起来像功能坏了**的现象：

| 累积物 | 表现 | 
|---|---|
| 上一轮睡眠测试把人留在床上 | 这一轮 `fly` / `startUsing` **全都悄悄不生效**（原版对睡眠中的玩家忽略很多动作） |
| 上一轮 `/give` 的物品还在背包里 | 这一轮"丢一个"数字对不上（因为它不在被选中的那一格） |
| 上一轮放的石头留在脚边 | 这一轮"往前走"位移只有一半或零（撞墙） |
| 上一轮开着的界面 | 这一轮所有按键类 op 被 `requirePlayable` 直接拒掉 |

所以有了 `tools/mcmcp.py` 的 `reset_test_state()`：**先醒来 → 回固定起点 → 清背包 →
定模式 → 重新发物品 → 原地清走廊**，一步都不能省。

### N9. `drop` 改的是数量，不是物品名

`LocalPlayer.drop(boolean)`（`:279`）= `getInventory().removeFromSelected(all)` + 发
`ServerboundPlayerActionPacket`。所以从一个 8 个的叠里丢 1 个，**物品名不变、数量变**。
判据要比数量（实测 8 → 7 才对得上）。

### N10. 两次"读早了"

两条都是同一类毛病：**服务端裁决的结果不能当场读**。

| op | 当场读到的 | 隔一拍读到的 |
|---|---|---|
| `pickItem`（创造） | `minecraft:air` | `minecraft:stone` |
| `placeRecipe` / `containerButton` / `creativeGive` | 请求已发 | 下一拍才出现在槽里 |

规律重申（跟第 3 节同一件事）：**客户端自己算的（走路/按键/界面树）回包即生效；
服务端裁决的（开界面/命令/选取/配方）要等下一拍。**

### N11. `light` 的遮挡判据

把石头盖在头顶再读 `light`：`sky` 从 15 掉到 14（地表白天本来就是满天光，
盖一格只能掉一点）。**判据用"变没变小"，不要写死期望值** —— 期望值随高度/维度/时间变化。

---

### N12. 交易要三步，少一步就"点了没反应" ★

原版 `MerchantScreen#postButtonClick()`（`MerchantScreen:55`）：

```java
this.menu.setSelectionHint(this.shopItem);                        // 1. 本地选中第几个
this.menu.tryMoveItems(this.shopItem);                            // 2. 把付款物品挪进付款槽
this.minecraft.getConnection().send(new ServerboundSelectTradePacket(this.shopItem)); // 3. 告知服务端
```

**漏掉第 2 步，付款槽是空的，点结果槽什么也不会发生，而且不报错。**
`handleInventoryMouseClick` 那条路完全看不出问题 —— 这是最难查的一类。

### N13. 成交要用 Shift+左键，`PICKUP` 的产物在光标上 ★

- `ClickType.PICKUP` 点结果槽（`MerchantMenu` 里索引 **2**）是把产物放到
  **光标（carried item）**上，不进背包。实测：日志显示成交、8 个绿宝石清零、
  **面包一个没进包** —— 因为它挂在光标上。
- 用 `ClickType.QUICK_MOVE`（Shift+左键）才直接进背包（服务端
  `MerchantMenu.quickMoveStack` 里针对结果槽走的就是成交那条路）。
- 而且**一次 `QUICK_MOVE` 可能成交不止一次**：付款物品够的话原版会把能换的都换掉。
  实测一次点击把 8 个绿宝石全换成 24 个面包。所以成交次数要按
  `MerchantOffer#getUses()` 的增量算，不能按"点了几次"算。
- `MerchantMenu#tryMoveItems` 挪的是**整叠**（不是只挪一份），所以付款槽可能还剩下东西；
  关界面时原版会还回背包（`MerchantMenu#removed`）。`trade` op 会把这个剩余如实报出来。

### N14. 村民：会游荡，而且没交易就不开界面 ★

- `Villager#mobInteract` 里 `boolean flag = this.getOffers().isEmpty();`
  —— **没有交易就直接 `setUnhappy()` 返回，不开界面**。所以测试要开交易界面，
  必须让村民有交易（NBT 写死 `Offers:{Recipes:[...]}` 最省事；
  `MerchantOffer` 的键是 `buy`/`sell`/`buyB`/`uses`/`maxUses`/`rewardExp`/`xp`/`priceMultiplier`）。
- **村民会游荡**：实测第二次跑的时候那只已经走开 **24 格**，`useOnEntity` 根本够不着。
  要它待着不动就 `{NoAI:1b}`。
- 顺带：`useOnEntity` 也支持 `awaitScreen` —— 交易界面同样是服务端回
  `ClientboundOpenScreenPacket` 才开的。

### N15. 进度：联机读不到权威值

客户端 `ClientAdvancements.progress` 是**私有字段**，而且会被成就界面通过
`setListener()` 抢走监听器，自己维护副本既绕又不可靠。单机下服务端对象就在同一进程里，
直接读 `MinecraftServer#getAdvancements()`（`ServerAdvancementManager`）+
`ServerPlayer#getAdvancements()`（`PlayerAdvancements#getOrStartProgress`）。
联机拿不到服务端对象时**如实报"读不到"，不编**。

## 11. 证据来源

- 反编译产物：`mod/build/moddev/artifacts/forge-1.20.1-47.4.10-sources.jar`
  （ModDevGradle 用 NeoForm 流水线生成，解开在 `mod/build/mcsrc/`，已 gitignore）
- 基线：MinecraftForge **1.20.1-47.4.10**（1.20.1 的官方 recommended，即当前稳定版）
- 本文行号对应上述 jar 解出来的源码；**换 Forge 版本行号会漂，结论要重核**
