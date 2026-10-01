# BlockWrapper

> `net.minecraftforge.fluids.capability.wrappers.BlockWrapper` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fluids/capability/wrappers/BlockWrapper.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**（源码 javadoc）：Wrapper around any block, only accounts for fluid placement, otherwise the block acts a void. If the block in question inherits from the Forge implementations, consider using FluidBlockWrapper.

## 公开成员（6 个）

```java
protected final BlockState state
```
源码 :27 —（无 javadoc）

```java
protected final Level world
```
源码 :28 —（无 javadoc）

```java
protected final BlockPos blockPos
```
源码 :29 —（无 javadoc）

```java
public BlockWrapper(BlockState state, Level world, BlockPos blockPos)
```
源码 :31 —（无 javadoc）

```java
public int fill(FluidStack resource, FluidAction action)
```
源码 :39 —（无 javadoc）

```java
public static class LiquidContainerBlockWrapper extends VoidFluidHandler
```
源码 :54 —（无 javadoc）

