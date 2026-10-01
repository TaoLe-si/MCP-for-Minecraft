# FluidBlockWrapper

> `net.minecraftforge.fluids.capability.wrappers.FluidBlockWrapper` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fluids/capability/wrappers/FluidBlockWrapper.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（11 个）

```java
protected final IFluidBlock fluidBlock
```
源码 :21 —（无 javadoc）

```java
protected final Level world
```
源码 :22 —（无 javadoc）

```java
protected final BlockPos blockPos
```
源码 :23 —（无 javadoc）

```java
public FluidBlockWrapper(IFluidBlock fluidBlock, Level world, BlockPos blockPos)
```
源码 :25 —（无 javadoc）

```java
public int getTanks()
```
源码 :33 —（无 javadoc）

```java
public FluidStack getFluidInTank(int tank)
```
源码 :40 —（无 javadoc）

```java
public int getTankCapacity(int tank)
```
源码 :46 —（无 javadoc）

```java
public boolean isFluidValid(int tank, @NotNull FluidStack stack)
```
源码 :61 —（无 javadoc）

```java
public int fill(FluidStack resource, FluidAction action)
```
源码 :67 —（无 javadoc）

```java
public FluidStack drain(FluidStack resource, FluidAction action)
```
源码 :74 —（无 javadoc）

```java
public FluidStack drain(int maxDrain, FluidAction action)
```
源码 :93 —（无 javadoc）

