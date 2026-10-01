# BucketPickupHandlerWrapper

> `net.minecraftforge.fluids.capability.wrappers.BucketPickupHandlerWrapper` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fluids/capability/wrappers/BucketPickupHandlerWrapper.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（11 个）

```java
protected final BucketPickup bucketPickupHandler
```
源码 :28 —（无 javadoc）

```java
protected final Level world
```
源码 :29 —（无 javadoc）

```java
protected final BlockPos blockPos
```
源码 :30 —（无 javadoc）

```java
public BucketPickupHandlerWrapper(BucketPickup bucketPickupHandler, Level world, BlockPos blockPos)
```
源码 :32 —（无 javadoc）

```java
public int getTanks()
```
源码 :40 —（无 javadoc）

```java
public FluidStack getFluidInTank(int tank)
```
源码 :47 —（无 javadoc）

```java
public int getTankCapacity(int tank)
```
源码 :62 —（无 javadoc）

```java
public boolean isFluidValid(int tank, @NotNull FluidStack stack)
```
源码 :68 —（无 javadoc）

```java
public int fill(FluidStack resource, FluidAction action)
```
源码 :74 —（无 javadoc）

```java
public FluidStack drain(FluidStack resource, FluidAction action)
```
源码 :81 —（无 javadoc）

```java
public FluidStack drain(int maxDrain, FluidAction action)
```
源码 :120 —（无 javadoc）

