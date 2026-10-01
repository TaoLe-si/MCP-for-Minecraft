# LivingHealEvent

> `net.minecraftforge.event.entity.living.LivingHealEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/LivingHealEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：LivingHealEvent is fired when an Entity is set to be healed. This event is fired whenever an Entity is healed in LivingEntity#heal(float) This event is fired via the ForgeEventFactory#onLivingHeal(LivingEntity,. #amount contains the amount of healing done to the Entity that was healed. This event is net.minecraftforge.eventbus.api.Cancelable. If this event is canceled, the Entity is not healed. Th…

## 公开成员（3 个）

```java
public LivingHealEvent(LivingEntity entity, float amount)
```
源码 :32 —（无 javadoc）

```java
public float getAmount()
```
源码 :38 —（无 javadoc）

```java
public void setAmount(float amount)
```
源码 :43 —（无 javadoc）

