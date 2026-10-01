# LivingMakeBrainEvent

> `net.minecraftforge.event.entity.living.LivingMakeBrainEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/LivingMakeBrainEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：LivingMakeBrainEvent is fired whenever a new net.minecraft.world.entity.ai.Brain instance is created using LivingEntity#makeBrain(Dynamic). To access the internal BrainBuilder, call LivingMakeBrainEvent#getTypedBrainBuilder(LivingEntity) using the downcasted LivingEntity obtained from LivingEvent#getEntity(). The BrainBuilder will initially contain all the state found in the original Brain instanc…

## 公开成员（2 个）

```java
public LivingMakeBrainEvent(LivingEntity entity, BrainBuilder<?> brainBuilder)
```
源码 :38 —（无 javadoc）

```java
public <E extends LivingEntity> BrainBuilder<E> getTypedBrainBuilder(E ignoredEntity)
```
源码 :44 —（无 javadoc）

