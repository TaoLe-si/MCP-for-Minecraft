# BonemealEvent

> `net.minecraftforge.event.entity.player.BonemealEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/BonemealEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is called when a player attempts to use Bonemeal on a block. It can be canceled to completely prevent any further processing. You can also set the result to ALLOW to mark the event as processed and use up a bonemeal from the stack but do no further processing. setResult(ALLOW) is the same as the old setHandled()

## 公开成员（5 个）

```java
public BonemealEvent(@NotNull Player player, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState block, @NotNull ItemStack stack)
```
源码 :35 —（无 javadoc）

```java
public Level getLevel()
```
源码 :44 —（无 javadoc）

```java
public BlockPos getPos()
```
源码 :49 —（无 javadoc）

```java
public BlockState getBlock()
```
源码 :54 —（无 javadoc）

```java
public ItemStack getStack()
```
源码 :60 —（无 javadoc）

