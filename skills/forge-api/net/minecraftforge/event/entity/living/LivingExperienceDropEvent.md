# LivingExperienceDropEvent

> `net.minecraftforge.event.entity.living.LivingExperienceDropEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/LivingExperienceDropEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Event for when an entity drops experience on its death, can be used to change the amount of experience points dropped or completely prevent dropping of experience by canceling the event.

## 公开成员（5 个）

```java
public LivingExperienceDropEvent(LivingEntity entity, @Nullable Player attackingPlayer, int originalExperience)
```
源码 :26 —（无 javadoc）

```java
public int getDroppedExperience()
```
源码 :34 —（无 javadoc）

```java
public void setDroppedExperience(int droppedExperience)
```
源码 :39 —（无 javadoc）

```java
public Player getAttackingPlayer()
```
源码 :48 —（无 javadoc）

```java
public int getOriginalExperience()
```
源码 :53 —（无 javadoc）

