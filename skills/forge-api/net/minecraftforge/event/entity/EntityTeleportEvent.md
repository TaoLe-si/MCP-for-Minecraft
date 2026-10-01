# EntityTeleportEvent

> `net.minecraftforge.event.entity.EntityTeleportEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/EntityTeleportEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：EntityTeleportEvent is fired when an event involving any teleportation of an Entity occurs. If a method utilizes this Event as its parameter, the method will receive every child event of this class. #getTarget() contains the target destination. #getPrev() contains the entity's current position. All children of this event are fired on the MinecraftForge#EVENT_BUS.

## 公开成员（9 个）

```java
protected double targetX
```
源码 :34 —（无 javadoc）

```java
protected double targetY
```
源码 :35 —（无 javadoc）

```java
protected double targetZ
```
源码 :36 —（无 javadoc）

```java
public EntityTeleportEvent(Entity entity, double targetX, double targetY, double targetZ)
```
源码 :38 —（无 javadoc）

```java
public double getTargetX() { return targetX; } public void setTargetX(double targetX) { this.targetX = targetX; } public double getTargetY() { retur…
```
源码 :45 —（无 javadoc）

```java
public static class SpreadPlayersCommand extends EntityTeleportEvent
```
源码 :97 —（无 javadoc）

```java
public static class EnderEntity extends EntityTeleportEvent
```
源码 :120 —（无 javadoc）

```java
public static class EnderPearl extends EntityTeleportEvent
```
源码 :151 —（无 javadoc）

```java
public static class ChorusFruit extends EntityTeleportEvent
```
源码 :210 —（无 javadoc）

