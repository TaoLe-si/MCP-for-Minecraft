# EntityMountEvent

> `net.minecraftforge.event.entity.EntityMountEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/EntityMountEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event gets fired whenever a entity mounts/dismounts another entity. entityBeingMounted can be null, be sure to check for that. This event is net.minecraftforge.eventbus.api.Cancelable. If this event is canceled, the entity does not mount/dismount the other entity. This event does not have a result. HasResult This event is fired on the MinecraftForge#EVENT_BUS.

## 公开成员（6 个）

```java
public EntityMountEvent(Entity entityMounting, Entity entityBeingMounted, Level level, boolean isMounting)
```
源码 :37 —（无 javadoc）

```java
public boolean isMounting()
```
源码 :46 —（无 javadoc）

```java
public boolean isDismounting()
```
源码 :51 —（无 javadoc）

```java
public Entity getEntityMounting()
```
源码 :56 —（无 javadoc）

```java
public Entity getEntityBeingMounted()
```
源码 :61 —（无 javadoc）

```java
public Level getLevel()
```
源码 :66 —（无 javadoc）

