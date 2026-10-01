# LivingHurtEvent

> `net.minecraftforge.event.entity.living.LivingHurtEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/LivingHurtEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：LivingHurtEvent is fired when an Entity is set to be hurt. This event is fired whenever an Entity is hurt in `LivingEntity#actuallyHurt(DamageSource, float)` and `Player#actuallyHurt(DamageSource, float)`. This event is fired via the ForgeHooks#onLivingHurt(LivingEntity,. #source contains the DamageSource that caused this Entity to be hurt. #amount contains the amount of damage dealt to the Entity…

## 公开成员（2 个）

```java
public LivingHurtEvent(LivingEntity entity, DamageSource source, float amount)
```
源码 :38 —（无 javadoc）

```java
public DamageSource getSource() { return source; } public float getAmount() { return amount; } public void setAmount(float amount) { this.amount = amount; } }
```
源码 :45 —（无 javadoc）

