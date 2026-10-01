# LivingDamageEvent

> `net.minecraftforge.event.entity.living.LivingDamageEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/LivingDamageEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：LivingDamageEvent is fired just before damage is applied to entity. At this point armor, potion and absorption modifiers have already been applied to damage - this is FINAL value. Also note that appropriate resources (like armor durability and absorption extra hearths) have already been consumed. This event is fired whenever an Entity is damaged in `LivingEntity#actuallyHurt(DamageSource, float)`…

## 公开成员（2 个）

```java
public LivingDamageEvent(LivingEntity entity, DamageSource source, float amount)
```
源码 :37 —（无 javadoc）

```java
public DamageSource getSource() { return source; } public float getAmount() { return amount; } public void setAmount(float amount) { this.amount = amount; } }
```
源码 :44 —（无 javadoc）

