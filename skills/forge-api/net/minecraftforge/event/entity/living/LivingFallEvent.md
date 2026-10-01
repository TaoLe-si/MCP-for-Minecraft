# LivingFallEvent

> `net.minecraftforge.event.entity.living.LivingFallEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/LivingFallEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：LivingFallEvent is fired when an Entity is set to be falling. This event is fired whenever an Entity is set to fall in LivingEntity#causeFallDamage(float,. This event is fired via the ForgeHooks#onLivingFall(LivingEntity,. #distance contains the distance the Entity is to fall. If this event is canceled, this value is set to 0.0F. This event is net.minecraftforge.eventbus.api.Cancelable. If this ev…

## 公开成员（2 个）

```java
public LivingFallEvent(LivingEntity entity, float distance, float damageMultiplier)
```
源码 :35 —（无 javadoc）

```java
public float getDistance() { return distance; } public void setDistance(float distance) { this.distance = distance; } public float getDamageMultiplier(…
```
源码 :42 —（无 javadoc）

