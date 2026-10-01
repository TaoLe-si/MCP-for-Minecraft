# IFluidTank

> `net.minecraftforge.fluids.IFluidTank` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fluids/IFluidTank.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**（源码 javadoc）：This interface represents a Fluid Tank. IT IS NOT REQUIRED but is provided for convenience. You are free to handle Fluids in any way that you wish - this is simply an easy default way. DO NOT ASSUME that these objects are used internally in all cases.

## 公开成员（7 个）

```java
FluidStack getFluid()
```
源码 :22 —（无 javadoc）

```java
int getFluidAmount()
```
源码 :27 — @return Current amount of fluid in the tank.

```java
int getCapacity()
```
源码 :32 — @return Capacity of this fluid tank.

```java
boolean isFluidValid(FluidStack stack)
```
源码 :38 — @param stack Fluidstack holding the Fluid to be queried. @return If the tank can hold the fluid (EVER, not at the time of query).

```java
int fill(FluidStack resource, FluidAction action)
```
源码 :45 — @param resource FluidStack attempting to fill the tank. @param action If SIMULATE, the fill will only be simulated. @return Amount of fluid that was accepted (or would be, if simulated) by the tank.

```java
FluidStack drain(int maxDrain, FluidAction action)
```
源码 :53 —（无 javadoc）

```java
FluidStack drain(FluidStack resource, FluidAction action)
```
源码 :61 —（无 javadoc）

