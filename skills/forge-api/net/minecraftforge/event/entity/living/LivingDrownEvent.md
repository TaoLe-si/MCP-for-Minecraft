# LivingDrownEvent

> `net.minecraftforge.event.entity.living.LivingDrownEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/LivingDrownEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：LivingDrownEvent is fired whenever a living entity can't breathe and its air supply is less than or equal to zero. This event is fired via ForgeHooks#onLivingBreathe(LivingEntity,. This event is Cancelable. Effects of cancellation are noted in #setCanceled(boolean). This event does not HasResult have a result. This event is fired on MinecraftForge#EVENT_BUS

## 公开成员（9 个）

```java
public LivingDrownEvent(LivingEntity entity, boolean isDrowning, float damageAmount, int bubbleCount)
```
源码 :43 —（无 javadoc）

```java
public LivingDrownEvent(LivingEntity entity, boolean isDrowning)
```
源码 :53 —（无 javadoc）

```java
public boolean isDrowning()
```
源码 :64 — This method returns true if the entity is "actively" drowning. For most entities, this happens when their air supply reaches -20. When this is true, the entity will take damage, spawn particles, and reset their air supply to 0. @return If the entity is actively drowning.

```java
public void setDrowning(boolean isDrowning)
```
源码 :74 — Sets if the entity is actively drowning. @param isDrowning The new value. @see #isDrowning()

```java
public float getDamageAmount()
```
源码 :87 — Gets the amount of DamageSources#drown() drowning damage the entity would take. Drowning damage is only inflicted if the entity is #isDrowning() actively drowning. For vanilla entities, the default amount of damage is 2 (1 heart). If the damage amount is less than or equal to zero, Entity#hurt will…

```java
public void setDamageAmount(float damageAmount)
```
源码 :97 — Sets the amount of drowning damage that may be inflicted. @param damageAmount The new value. @see #getDamageAmount()

```java
public int getBubbleCount()
```
源码 :108 — Gets the number of ParticleTypes#BUBBLE particles that would be spawned. Bubbles are only spawned if the entity is #isDrowning() actively drowning. For vanilla entities, the default value is 8 particles. @return The number of bubble particles that will spawn when actively drowning.

```java
public void setBubbleCount(int bubbleCount)
```
源码 :118 — Sets the amount of bubbles that may be spawned. @param bubbleCount The new value. @see #getBubbleCount()

```java
public void setCanceled(boolean cancel)
```
源码 :128 —（无 javadoc）

