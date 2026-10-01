# EmptyFluidHandler

> `net.minecraftforge.fluids.capability.templates.EmptyFluidHandler` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fluids/capability/templates/EmptyFluidHandler.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（4 个）

```java
public static final EmptyFluidHandler INSTANCE = new EmptyFluidHandler()
```
源码 :17 —（无 javadoc）

```java
protected EmptyFluidHandler() {} @Override public int getTanks() { return 1; } @NotNull @Override public FluidStack getFluidInTank(int tank) { return FluidStack.EMPTY; } @Override public int getTankCapacity(int tank) { return 0; } @Override public boolean isFluidValid(int tank, @NotNull FluidStack stack) { return true; } @Override public int fill(FluidStack resource, FluidAction action)
```
源码 :19 —（无 javadoc）

```java
public FluidStack drain(FluidStack resource, FluidAction action)
```
源码 :42 —（无 javadoc）

```java
public FluidStack drain(int maxDrain, FluidAction action)
```
源码 :49 —（无 javadoc）

