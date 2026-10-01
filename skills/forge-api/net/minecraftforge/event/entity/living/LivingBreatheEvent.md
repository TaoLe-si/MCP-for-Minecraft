# LivingBreatheEvent

> `net.minecraftforge.event.entity.living.LivingBreatheEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/LivingBreatheEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：LivingBreatheEvent is fired whenever a living entity ticks. This event is fired via ForgeHooks#onLivingBreathe(LivingEntity,. This event is not Cancelable. This event does not have a result. HasResult This event is fired on MinecraftForge#EVENT_BUS

## 公开成员（10 个）

```java
public LivingBreatheEvent(LivingEntity entity, boolean canBreathe, int consumeAirAmount, int refillAirAmount)
```
源码 :34 —（无 javadoc）

```java
public LivingBreatheEvent(LivingEntity entity, boolean canBreathe, int consumeAirAmount, int refillAirAmount, boolean canRefillAir)
```
源码 :39 —（无 javadoc）

```java
public boolean canBreathe()
```
源码 :53 — If the entity can breathe and #canRefillAir() returns true, their air value will be increased by #getRefillAirAmount(). If the entity can breathe and #canRefillAir() returns false, their air value will stay the same. If the entity cannot breathe, their air value will be reduced by #getConsumeAirAmou…

```java
public void setCanBreathe(boolean canBreathe)
```
源码 :61 — Sets if the entity can breathe or not. @param canBreathe The new value.

```java
public boolean canRefillAir()
```
源码 :69 — If the entity can breathe, #canRefillAir() will be checked to see if their air value should be refilled. @return True if the entity can refill its air value

```java
public void setCanRefillAir(boolean canRefillAir)
```
源码 :77 — Sets if the entity can refill its air value or not. @param canRefillAir The new value.

```java
public int getConsumeAirAmount()
```
源码 :84 — @return The amount the entity's LivingEntity#getAirSupply() air supply will be reduced by if the entity #canBreathe() cannot breathe.

```java
public void setConsumeAirAmount(int consumeAirAmount)
```
源码 :93 — Sets the new consumed air amount. @param consumeAirAmount The new value. @see #getConsumeAirAmount()

```java
public int getRefillAirAmount()
```
源码 :100 — @return The amount the entity's LivingEntity#getAirSupply() air supply will be increased by if the entity #canBreathe() can breathe.

```java
public void setRefillAirAmount(int refillAirAmount)
```
源码 :110 — Sets the new refilled air amount. @param refillAirAmount The new value. @see #getRefillAirAmount()

