# PistonEvent

> `net.minecraftforge.event.level.PistonEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/level/PistonEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Base piston event, use PistonEvent.Post and PistonEvent.Pre

## 公开成员（8 个）

```java
public PistonEvent(Level world, BlockPos pos, Direction direction, PistonMoveType moveType)
```
源码 :28 — @param pos - The position of the piston @param direction - The move direction of the piston

```java
public Direction getDirection()
```
源码 :38 — @return The direction of the piston block

```java
public BlockPos getFaceOffsetPos()
```
源码 :46 — Helper method that gets the piston position offset by its facing

```java
public PistonMoveType getPistonMoveType()
```
源码 :54 — @return The movement type of the piston (extension, retraction)

```java
public PistonStructureResolver getStructureHelper()
```
源码 :63 —（无 javadoc）

```java
public static class Post extends PistonEvent
```
源码 :75 — Fires after the piston has moved and set surrounding states. This will not fire if PistonEvent.Pre is cancelled.

```java
public static class Pre extends PistonEvent
```
源码 :89 —（无 javadoc）

```java
public static enum PistonMoveType
```
源码 :99 —（无 javadoc）

