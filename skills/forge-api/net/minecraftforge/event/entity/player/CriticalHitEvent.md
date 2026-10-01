# CriticalHitEvent

> `net.minecraftforge.event.entity.player.CriticalHitEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/CriticalHitEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is fired whenever a player attacks an Entity in EntityPlayer#attackTargetEntityWithCurrentItem(Entity). This event is not Cancelable. This event has a result. HasResult DEFAULT: means the vanilla logic will determine if this a critical hit. DENY: it will not be a critical hit but the player still will attack ALLOW: this attack is forced to be critical This event is fired on the Minecraf…

## 公开成员（6 个）

```java
public CriticalHitEvent(Player player, Entity target, float damageModifier, boolean vanillaCritical)
```
源码 :35 —（无 javadoc）

```java
public Entity getTarget()
```
源码 :47 — The Entity that was damaged by the player.

```java
public void setDamageModifier(float mod)
```
源码 :56 — This set the damage multiplier for the hit. If you set it to 0, then the particles are still generated but damage is not done.

```java
public float getDamageModifier()
```
源码 :65 — The damage modifier for the hit. This is by default 1.5F for ciritcal hits and 1F for normal hits .

```java
public float getOldDamageModifier()
```
源码 :74 — The orignal damage modifier for the hit wthout any changes. This is 1.5F for ciritcal hits and 1F for normal hits .

```java
public boolean isVanillaCritical()
```
源码 :82 — Returns true if this hit was critical by vanilla

