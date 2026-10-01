# EntityStruckByLightningEvent

> `net.minecraftforge.event.entity.EntityStruckByLightningEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/EntityStruckByLightningEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：EntityStruckByLightningEvent is fired when an Entity is about to be struck by lightening. This event is fired whenever an EntityLightningBolt is updated to strike an Entity in LightningBolt#tick() via ForgeEventFactory#onEntityStruckByLightning(Entity,. #lightning contains the instance of EntityLightningBolt attempting to strike an entity. This event is Cancelable. If this event is canceled, the E…

## 公开成员（2 个）

```java
public EntityStruckByLightningEvent(Entity entity, LightningBolt lightning)
```
源码 :33 —（无 javadoc）

```java
public LightningBolt getLightning()
```
源码 :39 —（无 javadoc）

