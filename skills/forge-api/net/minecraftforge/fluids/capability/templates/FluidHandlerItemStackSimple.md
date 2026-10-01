# FluidHandlerItemStackSimple

> `net.minecraftforge.fluids.capability.templates.FluidHandlerItemStackSimple` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fluids/capability/templates/FluidHandlerItemStackSimple.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**（源码 javadoc）：FluidHandlerItemStackSimple is a template capability provider for ItemStacks. Data is stored directly in the vanilla NBT, in the same way as the old ItemFluidContainer. This implementation only allows item containers to be fully filled or emptied, similar to vanilla buckets.

## 公开成员（20 个）

```java
public static final String FLUID_NBT_KEY = "Fluid"
```
源码 :31 —（无 javadoc）

```java
protected ItemStack container
```
源码 :36 —（无 javadoc）

```java
protected int capacity
```
源码 :37 —（无 javadoc）

```java
public FluidHandlerItemStackSimple(@NotNull ItemStack container, int capacity)
```
源码 :43 — @param container The container itemStack, data is stored on it directly as NBT. @param capacity The maximum capacity of this fluid tank.

```java
public ItemStack getContainer()
```
源码 :51 —（无 javadoc）

```java
public FluidStack getFluid()
```
源码 :57 —（无 javadoc）

```java
protected void setFluid(FluidStack fluid)
```
源码 :67 —（无 javadoc）

```java
public int getTanks()
```
源码 :80 —（无 javadoc）

```java
public FluidStack getFluidInTank(int tank)
```
源码 :87 —（无 javadoc）

```java
public int getTankCapacity(int tank)
```
源码 :93 —（无 javadoc）

```java
public boolean isFluidValid(int tank, @NotNull FluidStack stack)
```
源码 :99 —（无 javadoc）

```java
public int fill(@NotNull FluidStack resource, FluidAction action)
```
源码 :105 —（无 javadoc）

```java
public FluidStack drain(FluidStack resource, FluidAction action)
```
源码 :132 —（无 javadoc）

```java
public FluidStack drain(int maxDrain, FluidAction action)
```
源码 :143 —（无 javadoc）

```java
public boolean canFillFluidType(FluidStack fluid)
```
源码 :170 —（无 javadoc）

```java
public boolean canDrainFluidType(FluidStack fluid)
```
源码 :175 —（无 javadoc）

```java
protected void setContainerToEmpty()
```
源码 :185 — Override this method for special handling. Can be used to swap out the container's item for a different one with "container.setItem". Can be used to destroy the container with "container.stackSize--"

```java
public <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction facing)
```
源码 :192 —（无 javadoc）

```java
public static class Consumable extends FluidHandlerItemStackSimple
```
源码 :200 — Destroys the container item when it's emptied.

```java
public static class SwapEmpty extends FluidHandlerItemStackSimple
```
源码 :218 — Swaps the container item for a different one when it's emptied.

