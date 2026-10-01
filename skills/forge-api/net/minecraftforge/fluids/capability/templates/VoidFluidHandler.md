# VoidFluidHandler

> `net.minecraftforge.fluids.capability.templates.VoidFluidHandler` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fluids/capability/templates/VoidFluidHandler.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**（源码 javadoc）：VoidFluidHandler is a template fluid handler that can be filled indefinitely without ever getting full. It does not store fluid that gets filled into it, but "destroys" it upon receiving it.

## 公开成员（4 个）

```java
public static final VoidFluidHandler INSTANCE = new VoidFluidHandler()
```
源码 :21 —（无 javadoc）

```java
public VoidFluidHandler() {} @Override public int getTanks() { return 1; } @NotNull @Override public FluidStack getFluidInTank(int tank) { return FluidStack.EMPTY; } @Override public int getTankCapacity(int tank) { return Integer.MAX_VALUE; } @Override public boolean isFluidValid(int tank, @NotNull FluidStack stack) { return true; } @Override public int fill(FluidStack resource, FluidAction action)
```
源码 :23 —（无 javadoc）

```java
public FluidStack drain(FluidStack resource, FluidAction action)
```
源码 :46 —（无 javadoc）

```java
public FluidStack drain(int maxDrain, FluidAction action)
```
源码 :53 —（无 javadoc）

