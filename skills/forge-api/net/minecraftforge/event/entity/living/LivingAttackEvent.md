# LivingAttackEvent

> `net.minecraftforge.event.entity.living.LivingAttackEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/LivingAttackEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：LivingAttackEvent is fired when a living Entity is attacked. This event is fired whenever an Entity is attacked in LivingEntity#hurt(DamageSource, and Player#hurt(DamageSource,. This event is fired via the ForgeHooks#onLivingAttack(LivingEntity,. #source contains the DamageSource of the attack. #amount contains the amount of damage dealt to the entity. This event is net.minecraftforge.eventbus.api…

## 公开成员（2 个）

```java
public LivingAttackEvent(LivingEntity entity, DamageSource source, float amount)
```
源码 :38 —（无 javadoc）

```java
public DamageSource getSource() { return source; } public float getAmount() { return amount; } }
```
源码 :45 —（无 javadoc）

