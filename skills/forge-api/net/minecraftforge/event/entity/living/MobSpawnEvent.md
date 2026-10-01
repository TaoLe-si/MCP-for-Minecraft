# MobSpawnEvent

> `net.minecraftforge.event.entity.living.MobSpawnEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/MobSpawnEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This class holds all events relating to the entire flow of mob spawns. Currently, the events have the following flow for any given mob spawn: Before the spawn is attempted SpawnPlacementCheck is fired, to determine if the spawn may occur based on mob-specific rules. After the entity is created PositionCheck is fired, to determine if the selected position is legal for the entity. If both checks suc…

## 公开成员（10 个）

```java
protected MobSpawnEvent(Mob mob, ServerLevelAccessor level, double x, double y, double z)
```
源码 :54 —（无 javadoc）

```java
public Mob getEntity()
```
源码 :64 —（无 javadoc）

```java
public ServerLevelAccessor getLevel()
```
源码 :72 — @return The level relating to the mob spawn action

```java
public double getX()
```
源码 :80 — @return The x-coordinate relating to the mob spawn action

```java
public double getY()
```
源码 :88 — @return The y-coordinate relating to the mob spawn action

```java
public double getZ()
```
源码 :96 — @return The z-coordinate relating to the mob spawn action

```java
public static class SpawnPlacementCheck extends Event
```
源码 :121 —（无 javadoc）

```java
public static class PositionCheck extends MobSpawnEvent
```
源码 :226 —（无 javadoc）

```java
public static class FinalizeSpawn extends MobSpawnEvent
```
源码 :274 —（无 javadoc）

```java
public static class AllowDespawn extends MobSpawnEvent
```
源码 :424 —（无 javadoc）

