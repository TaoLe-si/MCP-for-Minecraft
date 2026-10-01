# EntityTravelToDimensionEvent

> `net.minecraftforge.event.entity.EntityTravelToDimensionEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/EntityTravelToDimensionEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：EntityTravelToDimensionEvent is fired before an Entity travels to a dimension. #dimension contains the id of the dimension the entity is traveling to. This event is net.minecraftforge.eventbus.api.Cancelable. If this event is canceled, the Entity does not travel to the dimension. This event does not have a result. HasResult This event is fired on the MinecraftForge#EVENT_BUS.

## 公开成员（2 个）

```java
public EntityTravelToDimensionEvent(Entity entity, ResourceKey<Level> dimension)
```
源码 :31 —（无 javadoc）

```java
public ResourceKey<Level> getDimension()
```
源码 :37 —（无 javadoc）

