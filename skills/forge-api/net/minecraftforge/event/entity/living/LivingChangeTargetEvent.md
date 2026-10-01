# LivingChangeTargetEvent

> `net.minecraftforge.event.entity.living.LivingChangeTargetEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/LivingChangeTargetEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event allows you to change the target an entity has. This event is fired before LivingSetAttackTargetEvent. This event is fired via the ForgeHooks#onLivingChangeTarget(LivingEntity, #getOriginalTarget() returns the target that should originally be set. The return value cannot be affected by calling #setNewTarget(LivingEntity). #getNewTarget() returns the new target that this entity will have.…

## 公开成员（7 个）

```java
public LivingChangeTargetEvent(LivingEntity entity, LivingEntity originalTarget, ILivingTargetType targetType)
```
源码 :43 —（无 javadoc）

```java
public LivingEntity getNewTarget()
```
源码 :54 — the new target of this entity.

```java
public void setNewTarget(LivingEntity newTarget)
```
源码 :63 — Sets the new target this entity shall have. @param newTarget The new target of this entity.

```java
public ILivingTargetType getTargetType()
```
源码 :71 — the living target type.

```java
public LivingEntity getOriginalTarget()
```
源码 :79 — the original entity MC intended to use as a target before firing this event.

```java
public static interface ILivingTargetType
```
源码 :90 — A living target type indicates what kind of system caused a change of targets. For a list of default target types, take a look at LivingTargetType.

```java
public static enum LivingTargetType implements ILivingTargetType
```
源码 :98 — This enum contains two default living target types.

