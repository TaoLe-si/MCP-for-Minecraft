# PotionColorCalculationEvent

> `net.minecraftforge.event.entity.living.PotionColorCalculationEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/PotionColorCalculationEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fires after Potion Color Calculation. this event is not Cancelable This event is fired on the MinecraftForge#EVENT_BUS.

## 公开成员（6 个）

```java
public PotionColorCalculationEvent(LivingEntity entity, int color, boolean hideParticle, Collection<MobEffectInstance> effectList)
```
源码 :28 —（无 javadoc）

```java
public int getColor()
```
源码 :37 —（无 javadoc）

```java
public void setColor(int color)
```
源码 :42 —（无 javadoc）

```java
public boolean areParticlesHidden()
```
源码 :47 —（无 javadoc）

```java
public void shouldHideParticles(boolean hideParticle)
```
源码 :52 —（无 javadoc）

```java
public Collection<MobEffectInstance> getEffects()
```
源码 :62 — Note that returned list is unmodifiable. @return effects

