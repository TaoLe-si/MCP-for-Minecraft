# IFluidHandler

> `net.minecraftforge.fluids.capability.IFluidHandler` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fluids/capability/IFluidHandler.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**（源码 javadoc）：Implement this interface as a capability which should handle fluids, generally storing them in one or more internal IFluidTank objects. A reference implementation is provided TileFluidHandler.

## 公开成员（7 个）

```java
int getTanks()
```
源码 :38 — Returns the number of fluid storage units ("tanks") available @return The number of tanks available

```java
FluidStack getFluidInTank(int tank)
```
源码 :57 —（无 javadoc）

```java
int getTankCapacity(int tank)
```
源码 :65 — Retrieves the maximum fluid amount for a given tank. @param tank Tank to query. @return The maximum fluid amount held by the tank.

```java
boolean isFluidValid(int tank, @NotNull FluidStack stack)
```
源码 :76 — This function is a way to determine which fluids can exist inside a given handler. General purpose tanks will basically always return TRUE for this. @param tank Tank to query for validity @param stack Stack to test with for validity @return TRUE if the tank can hold the FluidStack, not considering c…

```java
int fill(FluidStack resource, FluidAction action)
```
源码 :85 — Fills fluid into internal tanks, distribution is left entirely to the IFluidHandler. @param resource FluidStack representing the Fluid and maximum amount of fluid to be filled. @param action If SIMULATE, fill will only be simulated. @return Amount of resource that was (or would have been, if simulat…

```java
FluidStack drain(FluidStack resource, FluidAction action)
```
源码 :96 —（无 javadoc）

```java
FluidStack drain(int maxDrain, FluidAction action)
```
源码 :109 —（无 javadoc）

