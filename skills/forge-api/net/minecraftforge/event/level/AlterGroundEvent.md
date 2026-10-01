# AlterGroundEvent

> `net.minecraftforge.event.level.AlterGroundEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/level/AlterGroundEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is fired when net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator#placeBlockAt(TreeDecorator.Context, attempts to alter a ground block when generating a feature. An example of this would be large spruce trees converting grass blocks into podzol. This event is not Cancelable cancellable. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus o…

## 公开成员（7 个）

```java
public AlterGroundEvent(LevelSimulatedReader level, RandomSource random, BlockPos pos, BlockState altered)
```
源码 :35 —（无 javadoc）

```java
public LevelSimulatedReader getLevel()
```
源码 :44 —（无 javadoc）

```java
public RandomSource getRandom()
```
源码 :48 —（无 javadoc）

```java
public BlockPos getPos()
```
源码 :55 — the position of the block that will be altered

```java
public BlockState getOriginalAlteredState()
```
源码 :62 — the original block state that would be placed by the ground decorator

```java
public BlockState getNewAlteredState()
```
源码 :69 — the new block state to be placed by the ground decorator

```java
public void setNewAlteredState(BlockState newAltered)
```
源码 :76 — @param newAltered the new block state to be placed by the ground decorator

