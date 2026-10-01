# IFluidBlock

> `net.minecraftforge.fluids.IFluidBlock` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fluids/IFluidBlock.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**（源码 javadoc）：Implement this interface on Block classes which represent world-placeable Fluids.

## 公开成员（5 个）

```java
Fluid getFluid()
```
源码 :23 — Returns the Fluid associated with this Block.

```java
int place(Level level, BlockPos pos, @NotNull FluidStack fluidStack, IFluidHandler.FluidAction action)
```
源码 :37 — Attempts to place the block at a given position. The placed block's level will correspond to the provided fluid amount. This method should be called by fluid containers such as buckets, but it is recommended to use FluidUtil. @param level the level to place the block in @param pos the position to pl…

```java
FluidStack drain(Level level, BlockPos pos, IFluidHandler.FluidAction action)
```
源码 :49 —（无 javadoc）

```java
boolean canDrain(Level level, BlockPos pos)
```
源码 :55 — Check to see if a block can be drained. This method should be called by devices such as pumps.

```java
float getFilledPercentage(Level level, BlockPos pos)
```
源码 :64 — Returns the amount of a single block is filled. Value between 0 and 1. 1 meaning the entire 1x1x1 cube is full, 0 meaning completely empty. If the return value is negative. It will be treated as filling the block from the top down instead of bottom up.

