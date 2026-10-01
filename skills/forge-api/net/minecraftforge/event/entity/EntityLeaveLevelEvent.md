# EntityLeaveLevelEvent

> `net.minecraftforge.event.entity.EntityLeaveLevelEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/EntityLeaveLevelEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is fired whenever an Entity leaves a Level. This event is fired whenever an entity is removed from the level in LevelCallback#onTrackingEnd(Object). This event is not Cancelable cancellable and does not net.minecraftforge.eventbus.api.Event.HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus on both logical sides.

## 公开成员（2 个）

```java
public EntityLeaveLevelEvent(Entity entity, Level level)
```
源码 :27 —（无 javadoc）

```java
public Level getLevel()
```
源码 :36 — the level the entity is set to leave

