# EntityJoinLevelEvent

> `net.minecraftforge.event.entity.EntityJoinLevelEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/EntityJoinLevelEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is fired whenever an Entity joins a Level. This event is fired whenever an entity is added to a level in Level#addFreshEntity(Entity) and `PersistentEntitySectionManager#addNewEntity(Entity, boolean)`. Note: This event may be called before the underlying LevelChunk is promoted to ChunkStatus#FULL. You will cause chunk loading deadlocks if you do not delay your world interactions. This e…

## 公开成员（4 个）

```java
public EntityJoinLevelEvent(Entity entity, Level level)
```
源码 :36 —（无 javadoc）

```java
public EntityJoinLevelEvent(Entity entity, Level level, boolean loadedFromDisk)
```
源码 :41 —（无 javadoc）

```java
public Level getLevel()
```
源码 :51 — the level that the entity is set to join

```java
public boolean loadedFromDisk()
```
源码 :60 — @return `true` if the entity was loaded from disk, `false` otherwise. On the LogicalSide#CLIENT logical client, this will always return `false`.

