# LivingDeathEvent

> `net.minecraftforge.event.entity.living.LivingDeathEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/LivingDeathEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目用法**：玩家死亡 → 记一条 events

**职责**（源码 javadoc）：LivingDeathEvent is fired when an Entity dies. This event is fired whenever an Entity dies in LivingEntity#die(DamageSource), Player#die(DamageSource), and ServerPlayer#die(DamageSource). This event is fired via the ForgeHooks#onLivingDeath(LivingEntity,. #source contains the DamageSource that caused the entity to die. This event is Cancelable. If this event is canceled, the Entity does not die. T…

## 公开成员（2 个）

```java
public LivingDeathEvent(LivingEntity entity, DamageSource source)
```
源码 :38 —（无 javadoc）

```java
public DamageSource getSource()
```
源码 :44 —（无 javadoc）

