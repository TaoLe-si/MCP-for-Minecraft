# LivingDropsEvent

> `net.minecraftforge.event.entity.living.LivingDropsEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/LivingDropsEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：LivingDropsEvent is fired when an Entity's death causes dropped items to appear. This event is fired whenever an Entity dies and drops items in LivingEntity#die(DamageSource). This event is fired via the ForgeHooks#onLivingDrops(LivingEntity, . #source contains the DamageSource that caused the drop to occur. #drops contains the ArrayList of EntityItems that will be dropped. #lootingLevel contains…

## 公开成员（5 个）

```java
public LivingDropsEvent(LivingEntity entity, DamageSource source, Collection<ItemEntity> drops, int lootingLevel, boolean recentlyHit)
```
源码 :44 —（无 javadoc）

```java
public DamageSource getSource()
```
源码 :53 —（无 javadoc）

```java
public Collection<ItemEntity> getDrops()
```
源码 :58 —（无 javadoc）

```java
public int getLootingLevel()
```
源码 :63 —（无 javadoc）

```java
public boolean isRecentlyHit()
```
源码 :68 —（无 javadoc）

