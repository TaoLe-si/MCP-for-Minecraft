# EntityAttributeCreationEvent

> `net.minecraftforge.event.entity.EntityAttributeCreationEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/EntityAttributeCreationEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：EntityAttributeCreationEvent. Use this event to register attributes for your own EntityTypes. This event is fired after registration and before common setup. Fired on the Mod bus IModBusEvent.

## 公开成员（2 个）

```java
public EntityAttributeCreationEvent(Map<EntityType<? extends LivingEntity>, AttributeSupplier> map)
```
源码 :28 —（无 javadoc）

```java
public void put(EntityType<? extends LivingEntity> entity, AttributeSupplier map)
```
源码 :33 —（无 javadoc）

