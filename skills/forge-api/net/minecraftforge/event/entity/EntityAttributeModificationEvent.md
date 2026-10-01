# EntityAttributeModificationEvent

> `net.minecraftforge.event.entity.EntityAttributeModificationEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/EntityAttributeModificationEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：EntityAttributeModificationEvent. Use this event to add attributes to existing entity types. This event is fired after registration and before common setup, and after EntityAttributeCreationEvent Fired on the Mod bus IModBusEvent.

## 公开成员（5 个）

```java
public EntityAttributeModificationEvent(Map<EntityType<? extends LivingEntity>, AttributeSupplier.Builder> mapIn)
```
源码 :35 —（无 javadoc）

```java
public void add(EntityType<? extends LivingEntity> entityType, Attribute attribute, double value)
```
源码 :46 —（无 javadoc）

```java
public void add(EntityType<? extends LivingEntity> entityType, Attribute attribute)
```
源码 :53 —（无 javadoc）

```java
public boolean has(EntityType<? extends LivingEntity> entityType, Attribute attribute)
```
源码 :58 —（无 javadoc）

```java
public List<EntityType<? extends LivingEntity>> getTypes()
```
源码 :64 —（无 javadoc）

