# ShieldBlockEvent

> `net.minecraftforge.event.entity.living.ShieldBlockEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/ShieldBlockEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：The ShieldBlockEvent is fired when an entity successfully blocks with a shield. Cancelling this event will have the same impact as if the shield was not eligible to block. The damage blocked cannot be set lower than zero or greater than the original value. Note: The shield item stack "should" be available from LivingEntity#getUseItem() at least for players.

## 公开成员（7 个）

```java
public ShieldBlockEvent(LivingEntity blocker, DamageSource source, float blocked)
```
源码 :28 —（无 javadoc）

```java
public DamageSource getDamageSource()
```
源码 :39 — @return The damage source.

```java
public float getOriginalBlockedDamage()
```
源码 :48 — @return The original amount of damage blocked, which is the same as the original incoming damage value.

```java
public float getBlockedDamage()
```
源码 :56 — @return The current amount of damage blocked, as a result of this event.

```java
public boolean shieldTakesDamage()
```
源码 :65 — Controls if LivingEntity#hurtCurrentlyUsedShield is called. @return If the shield item will take durability damage or not.

```java
public void setBlockedDamage(float blocked)
```
源码 :74 — Set how much damage is blocked by this action. Note that initially the blocked amount is the entire attack.

```java
public void setShieldTakesDamage(boolean damage)
```
源码 :82 — Set if the shield will take durability damage or not.

