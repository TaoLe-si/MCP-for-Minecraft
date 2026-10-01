# BlockEvent

> `net.minecraftforge.event.level.BlockEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/level/BlockEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（14 个）

```java
public BlockEvent(LevelAccessor level, BlockPos pos, BlockState state)
```
源码 :45 —（无 javadoc）

```java
public LevelAccessor getLevel()
```
源码 :52 —（无 javadoc）

```java
public BlockPos getPos()
```
源码 :57 —（无 javadoc）

```java
public BlockState getState()
```
源码 :62 —（无 javadoc）

```java
public static class BreakEvent extends BlockEvent
```
源码 :72 —（无 javadoc）

```java
public static class EntityPlaceEvent extends BlockEvent
```
源码 :127 —（无 javadoc）

```java
public static class EntityMultiPlaceEvent extends EntityPlaceEvent
```
源码 :163 —（无 javadoc）

```java
public static class NeighborNotifyEvent extends BlockEvent
```
源码 :194 —（无 javadoc）

```java
public static class CreateFluidSourceEvent extends Event
```
源码 :233 —（无 javadoc）

```java
public static class FluidPlaceBlockEvent extends BlockEvent
```
源码 :271 —（无 javadoc）

```java
public static class CropGrowEvent extends BlockEvent
```
源码 :319 — Fired when a crop block grows. See subevents.

```java
public static class FarmlandTrampleEvent extends BlockEvent
```
源码 :376 —（无 javadoc）

```java
public static class PortalSpawnEvent extends BlockEvent
```
源码 :405 —（无 javadoc）

```java
public static class BlockToolModificationEvent extends BlockEvent
```
源码 :432 —（无 javadoc）

