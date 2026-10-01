# SleepingTimeCheckEvent

> `net.minecraftforge.event.entity.player.SleepingTimeCheckEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/SleepingTimeCheckEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is fired when the game checks if players can sleep at this time. Failing this check will cause sleeping players to wake up and prevent awake players from sleeping. This event has a result. HasResult setResult(ALLOW) informs game that player can sleep at this time. setResult(DEFAULT) causes game to check !Level#isDay() instead.

## 公开成员（2 个）

```java
public SleepingTimeCheckEvent(Player player, Optional<BlockPos> sleepingLocation)
```
源码 :29 —（无 javadoc）

```java
public Optional<BlockPos> getSleepingLocation()
```
源码 :39 — Note that the sleeping location may be an approximated one. @return The player's sleeping location.

