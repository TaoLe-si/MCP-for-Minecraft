# LivingKnockBackEvent

> `net.minecraftforge.event.entity.living.LivingKnockBackEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/LivingKnockBackEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：LivingKnockBackEvent is fired when a living entity is about to be knocked back. This event is fired whenever an Entity is knocked back in LivingEntity#hurt(DamageSource,, `LivingEntity#blockUsingShield(LivingEntity)`, Mob#doHurtTarget(Entity) and Player#attack(Entity) This event is fired via ForgeHooks#onLivingKnockBack(LivingEntity, . #strength contains the strength of the knock back. #ratioX con…

## 公开成员（6 个）

```java
protected float strength
```
源码 :41 —（无 javadoc）

```java
protected double ratioX, ratioZ
```
源码 :42 —（无 javadoc）

```java
protected final float originalStrength
```
源码 :43 —（无 javadoc）

```java
protected final double originalRatioX, originalRatioZ
```
源码 :44 —（无 javadoc）

```java
public LivingKnockBackEvent(LivingEntity target, float strength, double ratioX, double ratioZ)
```
源码 :46 —（无 javadoc）

```java
public float getStrength() {return this.strength;} public double getRatioX() {return this.ratioX;} public double getRatioZ() {return this.ratioZ;} public float getOriginalStrength() {return this.originalStrength;} public double getOriginalRatioX() {return this.originalRatioX;} public double getOriginalRatioZ() {return this.originalRatioZ;} public void setStrength(float strength) {this.strength = strength;} public void setRatioX(double ratio…
```
源码 :54 —（无 javadoc）

