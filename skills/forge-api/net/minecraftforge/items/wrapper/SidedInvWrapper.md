# SidedInvWrapper

> `net.minecraftforge.items.wrapper.SidedInvWrapper` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/items/wrapper/SidedInvWrapper.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（14 个）

```java
protected final WorldlyContainer inv
```
源码 :24 —（无 javadoc）

```java
protected final Direction side
```
源码 :26 —（无 javadoc）

```java
public static LazyOptional<IItemHandlerModifiable>[] create(WorldlyContainer inv, Direction... sides)
```
源码 :36 —（无 javadoc）

```java
public SidedInvWrapper(WorldlyContainer inv, @Nullable Direction side)
```
源码 :45 —（无 javadoc）

```java
public static int getSlot(WorldlyContainer inv, int slot, @Nullable Direction side)
```
源码 :65 —（无 javadoc）

```java
public boolean equals(Object o)
```
源码 :74 —（无 javadoc）

```java
public int hashCode()
```
源码 :87 —（无 javadoc）

```java
public int getSlots()
```
源码 :95 —（无 javadoc）

```java
public ItemStack getStackInSlot(int slot)
```
源码 :102 —（无 javadoc）

```java
public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate)
```
源码 :110 —（无 javadoc）

```java
public void setStackInSlot(int slot, @NotNull ItemStack stack)
```
源码 :198 —（无 javadoc）

```java
public ItemStack extractItem(int slot, int amount, boolean simulate)
```
源码 :213 —（无 javadoc）

```java
public int getSlotLimit(int slot)
```
源码 :254 —（无 javadoc）

```java
public boolean isItemValid(int slot, @NotNull ItemStack stack)
```
源码 :260 —（无 javadoc）

