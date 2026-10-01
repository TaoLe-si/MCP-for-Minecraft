# PlayerSetSpawnEvent

> `net.minecraftforge.event.entity.player.PlayerSetSpawnEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/PlayerSetSpawnEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is fired when a player's spawn point is set or reset. The event can be canceled, which will prevent the spawn point from being changed.

## 公开成员（4 个）

```java
public PlayerSetSpawnEvent(Player player, ResourceKey<Level> spawnLevel, @Nullable BlockPos newSpawn, boolean forced)
```
源码 :27 —（无 javadoc）

```java
public boolean isForced()
```
源码 :35 —（无 javadoc）

```java
public BlockPos getNewSpawn()
```
源码 :44 —（无 javadoc）

```java
public ResourceKey<Level> getSpawnLevel()
```
源码 :49 —（无 javadoc）

