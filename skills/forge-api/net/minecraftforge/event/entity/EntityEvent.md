# EntityEvent

> `net.minecraftforge.event.entity.EntityEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/EntityEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：EntityEvent is fired when an event involving any Entity occurs. If a method utilizes this net.minecraftforge.eventbus.api.Event as its parameter, the method will receive every child event of this class. #entity contains the entity that caused this event to occur. All children of this event are fired on the MinecraftForge#EVENT_BUS.

## 公开成员（6 个）

```java
public EntityEvent(Entity entity)
```
源码 :30 —（无 javadoc）

```java
public Entity getEntity()
```
源码 :35 —（无 javadoc）

```java
public static class EntityConstructing extends EntityEvent
```
源码 :50 — EntityConstructing is fired when an Entity is being created. This event is fired within the constructor of the Entity. This event is not net.minecraftforge.eventbus.api.Cancelable. This event does not have a result. HasResult This event is fired on the MinecraftForge#EVENT_BUS.

```java
public static class EnteringSection extends EntityEvent
```
源码 :70 — This event is fired on server and client after an Entity has entered a different section. Sections are 16x16x16 block grids of the world. This event does not fire when a new entity is spawned, only when an entity moves from one section to another one. Use EntityJoinLevelEvent to detect new entities…

```java
public static class Size extends EntityEvent
```
源码 :141 —（无 javadoc）

```java
public static class EyeHeight extends EntityEvent
```
源码 :186 —（无 javadoc）

