# FluidTank

> `net.minecraftforge.fluids.capability.templates.FluidTank` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fluids/capability/templates/FluidTank.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**（源码 javadoc）：Flexible implementation of a Fluid Storage object. NOT REQUIRED. @author King Lemming

## 公开成员（24 个）

```java
protected Predicate<FluidStack> validator
```
源码 :25 —（无 javadoc）

```java
protected FluidStack fluid = FluidStack.EMPTY
```
源码 :27 —（无 javadoc）

```java
protected int capacity
```
源码 :28 —（无 javadoc）

```java
public FluidTank(int capacity)
```
源码 :30 —（无 javadoc）

```java
public FluidTank(int capacity, Predicate<FluidStack> validator)
```
源码 :35 —（无 javadoc）

```java
public FluidTank setCapacity(int capacity)
```
源码 :41 —（无 javadoc）

```java
public FluidTank setValidator(Predicate<FluidStack> validator)
```
源码 :47 —（无 javadoc）

```java
public boolean isFluidValid(FluidStack stack)
```
源码 :55 —（无 javadoc）

```java
public int getCapacity()
```
源码 :60 —（无 javadoc）

```java
public FluidStack getFluid()
```
源码 :66 —（无 javadoc）

```java
public int getFluidAmount()
```
源码 :71 —（无 javadoc）

```java
public FluidTank readFromNBT(CompoundTag nbt)
```
源码 :76 —（无 javadoc）

```java
public CompoundTag writeToNBT(CompoundTag nbt)
```
源码 :83 —（无 javadoc）

```java
public int getTanks()
```
源码 :91 —（无 javadoc）

```java
public FluidStack getFluidInTank(int tank)
```
源码 :98 —（无 javadoc）

```java
public int getTankCapacity(int tank)
```
源码 :104 —（无 javadoc）

```java
public boolean isFluidValid(int tank, @NotNull FluidStack stack)
```
源码 :110 —（无 javadoc）

```java
public int fill(FluidStack resource, FluidAction action)
```
源码 :116 —（无 javadoc）

```java
public FluidStack drain(FluidStack resource, FluidAction action)
```
源码 :162 —（无 javadoc）

```java
public FluidStack drain(int maxDrain, FluidAction action)
```
源码 :173 —（无 javadoc）

```java
protected void onContentsChanged()
```
源码 :189 —（无 javadoc）

```java
public void setFluid(FluidStack stack)
```
源码 :194 —（无 javadoc）

```java
public boolean isEmpty()
```
源码 :199 —（无 javadoc）

```java
public int getSpace()
```
源码 :204 —（无 javadoc）

