# LivingEvent

> `net.minecraftforge.event.entity.living.LivingEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/LivingEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：LivingEvent is fired whenever an event involving a LivingEntity occurs. If a method utilizes this Event as its parameter, the method will receive every child event of this class. All children of this event are fired on the MinecraftForge#EVENT_BUS.

## 公开成员（5 个）

```java
public LivingEvent(LivingEntity entity)
```
源码 :28 —（无 javadoc）

```java
public LivingEntity getEntity()
```
源码 :35 —（无 javadoc）

```java
public static class LivingTickEvent extends LivingEvent
```
源码 :53 —（无 javadoc）

```java
public static class LivingJumpEvent extends LivingEvent
```
源码 :72 — LivingJumpEvent is fired when an Entity jumps. This event is fired whenever an Entity jumps in `LivingEntity#jumpFromGround()`, `MagmaCube#jumpFromGround()`, and `Horse#jumpFromGround()`. This event is fired via the ForgeHooks#onLivingJump(LivingEntity). This event is not Cancelable. This event does…

```java
public static class LivingVisibilityEvent extends LivingEvent
```
源码 :77 —（无 javadoc）

