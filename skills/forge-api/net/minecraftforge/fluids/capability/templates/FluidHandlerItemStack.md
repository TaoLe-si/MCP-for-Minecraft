# FluidHandlerItemStack

> `net.minecraftforge.fluids.capability.templates.FluidHandlerItemStack` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fluids/capability/templates/FluidHandlerItemStack.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**（源码 javadoc）：FluidHandlerItemStack is a template capability provider for ItemStacks. Data is stored directly in the vanilla NBT, in the same way as the old ItemFluidContainer. This class allows an ItemStack to contain any partial level of fluid up to its capacity, unlike FluidHandlerItemStackSimple Additional examples are provided to enable consumable fluid containers (see Consumable), fluid containers with di…

## 公开成员（20 个）

```java
public static final String FLUID_NBT_KEY = "Fluid"
```
源码 :34 —（无 javadoc）

```java
protected ItemStack container
```
源码 :39 —（无 javadoc）

```java
protected int capacity
```
源码 :40 —（无 javadoc）

```java
public FluidHandlerItemStack(@NotNull ItemStack container, int capacity)
```
源码 :46 — @param container The container itemStack, data is stored on it directly as NBT. @param capacity The maximum capacity of this fluid tank.

```java
public ItemStack getContainer()
```
源码 :54 —（无 javadoc）

```java
public FluidStack getFluid()
```
源码 :60 —（无 javadoc）

```java
protected void setFluid(FluidStack fluid)
```
源码 :70 —（无 javadoc）

```java
public int getTanks()
```
源码 :83 —（无 javadoc）

```java
public FluidStack getFluidInTank(int tank)
```
源码 :90 —（无 javadoc）

```java
public int getTankCapacity(int tank)
```
源码 :96 —（无 javadoc）

```java
public boolean isFluidValid(int tank, @NotNull FluidStack stack)
```
源码 :102 —（无 javadoc）

```java
public int fill(FluidStack resource, FluidAction doFill)
```
源码 :108 —（无 javadoc）

```java
public FluidStack drain(FluidStack resource, FluidAction action)
```
源码 :149 —（无 javadoc）

```java
public FluidStack drain(int maxDrain, FluidAction action)
```
源码 :160 —（无 javadoc）

```java
public boolean canFillFluidType(FluidStack fluid)
```
源码 :194 —（无 javadoc）

```java
public boolean canDrainFluidType(FluidStack fluid)
```
源码 :199 —（无 javadoc）

```java
protected void setContainerToEmpty()
```
源码 :208 — Override this method for special handling. Can be used to swap out or destroy the container.

```java
public <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction facing)
```
源码 :215 —（无 javadoc）

```java
public static class Consumable extends FluidHandlerItemStack
```
源码 :223 — Destroys the container item when it's emptied.

```java
public static class SwapEmpty extends FluidHandlerItemStack
```
源码 :241 — Swaps the container item for a different one when it's emptied.

