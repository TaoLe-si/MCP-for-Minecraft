# VillageSiegeEvent

> `net.minecraftforge.event.village.VillageSiegeEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/village/VillageSiegeEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：VillageSiegeEvent is fired just before a zombie siege finds a successful location in `VillageSiege#tryToSetupSiege(ServerLevel)`, to give mods the chance to stop the siege. This event is Cancelable; canceling stops the siege. This event does not have a result. HasResult This event is fired on the MinecraftForge#EVENT_BUS.

## 公开成员（5 个）

```java
public VillageSiegeEvent(VillageSiege siege, Level level, Player player, Vec3 attemptedSpawnPos)
```
源码 :34 —（无 javadoc）

```java
public VillageSiege getSiege()
```
源码 :42 —（无 javadoc）

```java
public Level getLevel()
```
源码 :47 —（无 javadoc）

```java
public Player getPlayer()
```
源码 :52 —（无 javadoc）

```java
public Vec3 getAttemptedSpawnPos()
```
源码 :57 —（无 javadoc）

