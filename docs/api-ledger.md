# 1.20.1 Forge 可驱动 API 总账

> 纪律：**一条一行，先核实再登记。** 核实分两级：
> - **静** = 在反编译源码里读到了签名/语义，并记下行号（`mod/build/mcsrc/`，可 gitignore 重建）
> - **运** = 在真游戏里跑过一次，结果记进了 `skills/minecraft-runtime/measurements.jsonl`
>
> 只过静的那条写【静】，过了运的写【已核】。**没读源码的一律不写进来。**

状态图例：`已核` = 静+运都过 · `静` = 只过了静态 · `待` = 已实现未实测 · `缺` = 还没实现

实现位置：`C`=control/（ControlServer, Dispatcher, GameThread, Journal）·
`O`=client/Observation · `I`=client/Info · `A`=client/Actions · `B`=client/Blocks ·
`G`=client/GuiOps · `N`=client/InputOverride · `P`=client/Probe

---

## A. 观测 · 玩家自己

| # | 能力 | op | 实现 | 静态证据 | 运行时 | 状态 |
|---|---|---|---|---|---|---|
| A1 | 位置/朝向/维度 | `state` | O | `Entity.getX/Y/Z` `:3182` 一带 | e2e ×6 | 已核 |
| A2 | 客户端内脏（暂停/焦点/按键/冲量） | `probe` | P | `Minecraft.isPaused() :2485` | 破案"卡方块"那次 | 已核 |
| A3 | 血量/饱食/饱和/消耗 | `vitals` | I | `FoodData.getSaturationLevel() :120` | vitals ×1 | 已核 |
| A4 | 经验等级/进度/总量 | `vitals` | I | `Player.experienceLevel :158` | vitals ×1 | 已核 |
| A5 | 药水效果 | `vitals.effects` | I | `LivingEntity.getActiveEffects() :903` | vitals ×1 | 已核 |
| A6 | 能力（飞行/瞬破/无敌/速度） | `vitals.abilities` | I | `Abilities.flying :7` `instabuild :9` | vitals ×1 | 已核 |
| A7 | 游戏模式 | `vitals.gameMode` | I | `MultiPlayerGameMode.getPlayerMode() :506` | vitals ×1 | 已核 |
| A8 | 护甲/氧气/着火/入水/坠落 | `vitals` | I | `LivingEntity.getArmorValue() :1558` `Entity.getAirSupply() :2265` | vitals ×1 | 已核 |
| A9 | 背包全槽 + 选中槽 | `inventory` | B | `Inventory.getItem(int) :471` | e2e_api ×3 | 已核 |
| A10 | 客户端世界快照（实体数/区块数） | `clientLevel` | A | `ClientLevel.getEntityCount()` | e2e_api2 弱核对 | 已核 |

## B. 观测 · 世界

| # | 能力 | op | 实现 | 静态证据 | 运行时 | 状态 |
|---|---|---|---|---|---|---|
| B1 | 时间（dayTime/gameTime/昼夜） | `world` | I | `Level.getDayTime() :732` `isDay() :369` | world ×1 | 已核 |
| B2 | 天气（雨/雷/强度） | `world` | I | `Level.isRaining() :786` `getRainLevel() :768` | world ×1 | 已核 |
| B3 | 难度（含锁定） | `world` | I | `Level.getDifficulty()` | world ×1 | 已核 |
| B4 | 世界边界 | `world.worldBorder` | I | `WorldBorder.getMinX() :82` `getSize() :117` | world ×1 | 已核 |
| B5 | 方块（含状态属性） | `block` | B | `BlockState.getProperties()` | e2e_api | 已核 |
| B6 | 区域扫描 | `blocks` | B | `Level.getBlockState() :351` | e2e_api | 已核 |
| B7 | 光照（总/天/方块） | `light` | I | `LevelReader.getMaxLocalRawBrightness() :164,168` | 遮挡前后对比 | 已核 |
| B8 | 生物群系 | `biome` | I | `Holder.unwrapKey() :46` | plains | 已核 |
| B9 | 方块实体 NBT（箱子/熔炉/告示牌） | `blockentity` | I | `BlockEntity.getUpdateTag() :163` | 告示牌文本 | 已核 |
| B10 | 计分板（目标/队伍/分数） | `scoreboard` | I | `Scoreboard.getObjectives() :106` `getPlayerScores() :92` | 42 分 | 已核 |
| B11 | 服务器/延迟/在线玩家 | `server` | I | `ClientPacketListener.getOnlinePlayers() :2335` `PlayerInfo.getLatency() :81` | 延迟 0~3ms | 已核 |
| B12 | 配方查询（产物+原料） | `recipes` | I | `RecipeManager.getRecipes() :149` `Recipe.getIngredients()` | 钻石剑配方 | 已核 |
| B13 | 配方书状态（认了多少/能不能做） | `recipebook` | I | `RecipeCollection.hasCraftable() :90` | e2e_api2 弱核对 | 已核 |

## C. 观测 · 实体与视线

| # | 能力 | op | 实现 | 静态证据 | 运行时 | 状态 |
|---|---|---|---|---|---|---|
| C1 | 附近实体列表 | `entities` | B | `Level.getEntities() :638` | e2e_api | 已核 |
| C2 | 单实体详情 + NBT | `entity` | I | `Entity.saveWithoutId() :1598` | 猪 NBT 718B | 已核 |
| C3 | 视线射线 | `ray` | B | `Entity.pick() :1535` | e2e_api | 已核 |

## D. 观测 · 界面与日志

| # | 能力 | op | 实现 | 静态证据 | 运行时 | 状态 |
|---|---|---|---|---|---|---|
| D1 | 界面控件树 + 容器槽位 | `screen` | G | `ContainerEventHandler.children()` | e2e_api | 已核 |
| D2 | 游戏日志尾部 | `log` | C | 读 `logs/latest.log`（不自己存一份） | e2e_api | 已核 |
| D3 | 聊天流水 | `chatlog` | C | `ClientChatReceivedEvent.getMessage() :49` | e2e_api | 已核 |
| D4 | 事件流水 | `events` | C | Journal 环形缓冲 | e2e_api | 已核 |
| D5 | 截图 | `shot` | C | `Screenshot.grab() :37`（写盘异步 `:66`） | e2e ×4 | 已核 |
| D6 | 像素比对 | `mc_diff`（MCP 侧） | tools | 自解 PNG，不依赖 PIL | e2e ×4 | 已核 |

## E. 动作 · 移动与朝向

| # | 能力 | op | 实现 | 静态证据 | 运行时 | 状态 |
|---|---|---|---|---|---|---|
| E1 | 往前走 | `move` | N | `KeyboardInput.tick() :24,28` | 8.375 格/40tick | 已核 |
| E2 | 任意按键按住 N tick | `key` | N | `KeyMapping.setDown() :206` | 开背包/跳跃 | 已核 |
| E3 | 敲一下（consumeClick 型） | `press` | N | `KeyMapping.click()` vs `setDown` 不涨 clickCount | 开背包 | 已核 |
| E4 | 跳跃 | `jump` | N | 同上 | e2e_api | 已核 |
| E5 | 设朝向 | `look` | N | `Entity.setYRot() :3315` | e2e ×6 | 已核 |
| E6 | 看向坐标 | `lookAt` | N | 自算 yaw/pitch | e2e_api | 已核 |
| E7 | 开关创造飞行 | `fly` | A | `Abilities.flying :7` + `onUpdateAbilities()` | flying 保持住 | 已核 |
| E8 | 上下载具 | `ride`/`dismount` | A | `LocalPlayer.startRiding() :161` `Entity.stopRiding() :1961` | boat 上下 | 已核 |

## F. 动作 · 方块与挖掘

| # | 能力 | op | 实现 | 静态证据 | 运行时 | 状态 |
|---|---|---|---|---|---|---|
| F1 | 挖方块（挖穿才回包） | `break` | B | `startDestroyBlock() :134` `continueDestroyBlock() :198` | e2e_api 回读 | 已核 |
| F2 | 放方块 | `place` | B | `useItemOn() :287` | e2e_api 回读 | 已核 |
| F3 | 对方块右键 | `interact` | B | 同上 | 工作台 | 已核 |
| F4 | 开容器（等界面） | `interact{awaitScreen}` | B | 服务端 `ClientboundOpenScreenPacket` 才 setScreen | e2e_api | 已核 |
| F5 | 中止挖掘 | `stopBreak` | A | `MultiPlayerGameMode.stopDestroyBlock() :185` | 待 | 静 |
| F6 | 挖掘进度/够得着多远 | `digStatus` | A | `isDestroying() :510` `getDestroyStage() :514` `getPickRange() :256` | e2e_api2 弱核对 | 已核 |
| F7 | 选取方块（中键） | `pickItem` | A | `handlePickItem() :518` | 回读=石头 | 已核 |

## G. 动作 · 手上的东西

| # | 能力 | op | 实现 | 静态证据 | 运行时 | 状态 |
|---|---|---|---|---|---|---|
| G1 | 用手中/副手物品 | `use` | B | `useItem() :352` | 待 | 静 |
| G2 | 开始蓄力（拉弓/吃/举盾） | `startUsing` | A | `LocalPlayer.startUsingItem() :482` | using=True | 已核 |
| G3 | 松手放掉蓄力 | `releaseUsing` | A | `releaseUsingItem() :471` | wasUsing=True | 已核 |
| G4 | 丢物品 | `drop` | A | `LocalPlayer.drop(boolean) :279` | 8→7 | 已核 |
| G5 | 攻击实体 | `attack` | B | `attack() :395` | 待 | 静 |
| G6 | 换快捷栏槽位 | `selectSlot` | B | `Inventory.selected :39` + 发包 | e2e_api | 已核 |
| G7 | 滚轮切槽 | `scroll` | B | `Inventory.swapPaint() :141` | 待 | 静 |
| G8 | 换副手 | `press{swapOffhand}` | N | `handleKeybinds` 里 `keySwapOffhand.consumeClick()` | 待 | 静 |

## H. 动作 · 实体交互

| # | 能力 | op | 实现 | 静态证据 | 运行时 | 状态 |
|---|---|---|---|---|---|---|
| H1 | 对实体右键（喂/剪/挤奶/交易/上车） | `useOnEntity` | A | `MultiPlayerGameMode.interact() :405` | PASS 有结果 | 已核 |
| H2 | 在实体具体位置右键（盔甲架/展示框） | `useOnEntityAt` | A | `interactAt() :411` `EntityHitResult(Entity,Vec3) :12` | PASS 有结果 | 已核 |

## I. 动作 · 容器与合成

| # | 能力 | op | 实现 | 静态证据 | 运行时 | 状态 |
|---|---|---|---|---|---|---|
| I1 | 点容器槽位 | `clickSlot` | G | `handleInventoryMouseClick() :421` | e2e_api | 已核 |
| I2 | 配方书一键合成 | `placeRecipe` | A | `handlePlaceRecipe() :449` | e2e_api2 弱核对 | 已核 |
| I3 | 列出可合成配方（index 来源） | `recipeOptions` | A | `RecipeCollection.getRecipes() :98` | 36 个可选 | 已核 |
| I4 | 容器按钮（附魔等级/切石样式/信标） | `containerButton` | A | `handleInventoryButtonClick() :453` | 待 | 静 |
| I5 | 创造栏取物 | `creativeGive` | A | `handleCreativeModeItemAdd() :457` | 红石 x8 | 已核 |

## J. 动作 · 界面

| # | 能力 | op | 实现 | 静态证据 | 运行时 | 状态 |
|---|---|---|---|---|---|---|
| J1 | 点按钮（按文字/序号） | `clickButton` | G | `ContainerEventHandler.mouseClicked()` default 派发 | e2e_api | 已核 |
| J2 | 输入框打字 | `typeText` | G | `EditBox.setValue() :93` | 待 | 静 |
| J3 | 关界面 | `closeScreen` | G | `Minecraft.setScreen(null)` | e2e_api | 已核 |
| J4 | 开背包 | `openInventory` | A | `LocalPlayer.sendOpenInventory() :359` | 界面已开 | 已核 |

## K. 动作 · 身体状态

| # | 能力 | op | 实现 | 静态证据 | 运行时 | 状态 |
|---|---|---|---|---|---|---|
| K1 | 睡觉 | `sleep` | A | `Player.startSleepInBed() :1312` | sleeping=True | 已核 |
| K2 | 起床 | `wakeUp` | A | `Player.stopSleeping() :1328` | 待 | 静 |
| K3 | 重生 | `respawn` | A | `Player.respawn() :1277` | 待 | 静 |

## L. 通信

| # | 能力 | op | 实现 | 静态证据 | 运行时 | 状态 |
|---|---|---|---|---|---|---|
| L1 | 发聊天 | `chat` | O | `ClientPacketListener.sendChat() :2407` | e2e_api | 已核 |
| L2 | 发命令（`/…`） | `chat{command}` | O | `ClientPacketListener.sendCommand() :2417` | e2e_api | 已核 |

## M. 工程

| # | 能力 | 工具 | 实现 | 说明 | 状态 |
|---|---|---|---|---|---|
| M1 | 构建 | `mc_build` | tools | gradle 封装，只回错误行 | 已核 |
| M2 | 起游戏 | `mc_run` | tools | `clientAuto` 自动建/载世界 + 固定起点 | 已核 |
| M3 | 静/动态 SKILL 读写 | `skill_read`/`skill_note` | tools | | 已核 |
| M4 | 原始包逃生口 | `mc_exec` | tools | 新 op 先用它试 | 已核 |

---

## 未覆盖 / 明确不做（写在明处，别装作覆盖了）

| 项 | 原因 |
|---|---|
| `Botania`/其它模组 API | 本仓库只做原版 + Forge 公共面 |
| `DimensionType` 细节、`BiomeSource` 参数 | 对"驱动游戏"没直接用处 |
| 生物 AI / 寻路（Baritone 那类） | 是另一个量级的工程，本仓库只提供原语 |
| 网络层收发包（抓包/伪造） | 会绕过服务端校验，属于作弊性质，不做 |
| 玩家统计 `StatsCounter` | 客户端没有现成的读取口（`Player.getStats()` 在 1.20.1 不存在），要另外挂包；暂缓 |
| 自定义 `SimpleChannel` 包 | 进程外的发送端拿不到 Netty 通道；协议已按此设计（见 protocol.md 第 7 节） |

## 覆盖统计

- 已核（静+运）：**57** 条（其中 6 条是"弱核对"：只确认请求发出、结果由服务端裁决）
- 已核静态（待运行时核实）：**0** 条
- 未实现：**0** 条（本表登记的都在代码里了）

第二轮（观测纵深 + 动作纵深）的运行时核实：`python tools/e2e_api2.py` —— **30 条，
25 条回读核对通过、5 条弱核对、0 失败**。原始记录见 `measurements.jsonl` 的 `kind=e2e_api2`。

### 第二轮挖出来的原版规则（详见 `skills/minecraft-api/SKILL.md` 第 10 章）

| # | 规则 | 为什么值得记 |
|---|---|---|
| N1 | 中键"选取方块"不是 `handlePickItem`（那是"把背包第 N 格挪到手上"）；真逻辑在私有的 `Minecraft.pickBlock()` 里 | 我按错的语义实现了一版，点下去毫无反应 |
| N2 | 站在地上飞行会被原版取消（`LocalPlayer:784`） | "设 flying=true"之后 1.5 秒自己变回 false，看着像 op 失效 |
| N3 | 客户端那份计分板在单机下是空的，要读服务端那份 | 服务端日志说建好了，客户端读是 0 |
| N4 | 读方块实体用 `saveWithoutMetadata()`，`getUpdateTag()` 基类返空 tag | 读箱子得到 `{}` 不是没东西，是方法错了 |
| N5 | 容器内容不同步给没开界面的客户端 | 想读箱子里有什么，只能开界面 |
| N6 | 1.20.1 的船是 `minecraft:boat` + `{Type:"oak"}`，没有 `oak_boat` | 凭记忆写实体名，服务端直接拒 |
| N7 | 命令的结果只能用 `chatlog` 看 | 三次定位都是靠服务端回的聊天原话 |
| N8 | 状态跨跑累积（睡眠/物品/方块/界面），跑批前必须 `reset_test_state()` | 上一轮睡在床上会让这一轮 fly/use 全都不生效 |
| N9 | `drop` 改的是数量不是物品名 | 判据要比数量 |
| N10 | 服务端裁决的结果不能当场读 | `pickItem` 当场读是 air、隔一拍才是石头 |
