# SpawnPlacementRegisterEvent

> `net.minecraftforge.event.entity.SpawnPlacementRegisterEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/SpawnPlacementRegisterEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event allows each EntityType to have a SpawnPlacements.SpawnPredicate registered or modified. Spawn Predicates are checked whenever an Entity of the given EntityType spawns in the world naturally. If registering your own entity's spawn placements, you should use SpawnPlacementRegisterEvent#register(EntityType, So that you ensure that your entity has a heightmap type and placement type registe…

## 公开成员（6 个）

```java
public SpawnPlacementRegisterEvent(Map<EntityType<?>, MergedSpawnPredicate<?>> map)
```
源码 :49 —（无 javadoc）

```java
public <T extends Entity> void register(EntityType<T> entityType, SpawnPlacements.SpawnPredicate<T> predicate)
```
源码 :57 — Register an optional spawn placement `predicate` for a given `entityType`

```java
public <T extends Entity> void register(EntityType<T> entityType, SpawnPlacements.SpawnPredicate<T> predicate, Operation operation)
```
源码 :65 — Register a `predicate` for a given `entityType` with a given `operation` for handling

```java
public <T extends Entity> void register(EntityType<T> entityType, @Nullable SpawnPlacements.Type placementType, @Nullable Heightmap.Types heightmap, SpawnPlacements.SpawnPredicate<T> predicate, Operation operation)
```
源码 :76 —（无 javadoc）

```java
public enum Operation
```
源码 :100 —（无 javadoc）

```java
public static class MergedSpawnPredicate<T extends Entity>
```
源码 :116 — Checked first, the last mod to replace the predicate wipes out all other predicates. Listen with a low EventPriority if you need to do this.

