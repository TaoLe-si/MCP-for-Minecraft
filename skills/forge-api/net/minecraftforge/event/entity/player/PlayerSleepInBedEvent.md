# PlayerSleepInBedEvent

> `net.minecraftforge.event.entity.player.PlayerSleepInBedEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/PlayerSleepInBedEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：PlayerSleepInBedEvent is fired when a player sleeps in a bed. This event is fired whenever a player sleeps in a bed in Player#startSleeping(BlockPos). #result contains whether the player is able to sleep. This event does not have a result. HasResult This event is fired on the MinecraftForge#EVENT_BUS.

## 公开成员（5 个）

```java
public PlayerSleepInBedEvent(Player player, Optional<BlockPos> pos)
```
源码 :32 —（无 javadoc）

```java
public BedSleepingProblem getResultStatus()
```
源码 :38 —（无 javadoc）

```java
public void setResult(BedSleepingProblem result)
```
源码 :43 —（无 javadoc）

```java
public BlockPos getPos()
```
源码 :48 —（无 javadoc）

```java
public Optional<BlockPos> getOptionalPos()
```
源码 :53 —（无 javadoc）

