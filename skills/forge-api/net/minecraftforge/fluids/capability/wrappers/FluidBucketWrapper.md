# FluidBucketWrapper

> `net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fluids/capability/wrappers/FluidBucketWrapper.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**（源码 javadoc）：Wrapper for vanilla and forge buckets. Swaps between empty bucket and filled bucket of the correct type.

## 公开成员（14 个）

```java
protected ItemStack container
```
源码 :39 —（无 javadoc）

```java
public FluidBucketWrapper(@NotNull ItemStack container)
```
源码 :41 —（无 javadoc）

```java
public ItemStack getContainer()
```
源码 :48 —（无 javadoc）

```java
public boolean canFillFluidType(FluidStack fluid)
```
源码 :53 —（无 javadoc）

```java
public FluidStack getFluid()
```
源码 :63 —（无 javadoc）

```java
protected void setFluid(@NotNull FluidStack fluidStack)
```
源码 :80 —（无 javadoc）

```java
public int getTanks()
```
源码 :89 —（无 javadoc）

```java
public FluidStack getFluidInTank(int tank)
```
源码 :96 —（无 javadoc）

```java
public int getTankCapacity(int tank)
```
源码 :102 —（无 javadoc）

```java
public boolean isFluidValid(int tank, @NotNull FluidStack stack)
```
源码 :108 —（无 javadoc）

```java
public int fill(FluidStack resource, FluidAction action)
```
源码 :114 —（无 javadoc）

```java
public FluidStack drain(FluidStack resource, FluidAction action)
```
源码 :131 —（无 javadoc）

```java
public FluidStack drain(int maxDrain, FluidAction action)
```
源码 :153 —（无 javadoc）

```java
public <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction facing)
```
源码 :175 —（无 javadoc）

