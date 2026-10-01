# SleepingLocationCheckEvent

> `net.minecraftforge.event.entity.player.SleepingLocationCheckEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/SleepingLocationCheckEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is fired when game checks, if sleeping player should be still considered "in bed". Failing this check will cause player to wake up. This event has a result. HasResult setResult(ALLOW) informs game that player is still "in bed" setResult(DEFAULT) causes game to check Block#isBed(BlockState, instead

## 公开成员（2 个）

```java
public SleepingLocationCheckEvent(LivingEntity player, BlockPos sleepingLocation)
```
源码 :32 —（无 javadoc）

```java
public BlockPos getSleepingLocation()
```
源码 :38 —（无 javadoc）

