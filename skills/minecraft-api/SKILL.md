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

## 10. 证据来源

- 反编译产物：`mod/build/moddev/artifacts/forge-1.20.1-47.4.10-sources.jar`
  （ModDevGradle 用 NeoForm 流水线生成，解开在 `mod/build/mcsrc/`，已 gitignore）
- 基线：MinecraftForge **1.20.1-47.4.10**（1.20.1 的官方 recommended，即当前稳定版）
- 本文行号对应上述 jar 解出来的源码；**换 Forge 版本行号会漂，结论要重核**
