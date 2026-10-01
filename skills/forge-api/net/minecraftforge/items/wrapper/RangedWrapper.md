# RangedWrapper

> `net.minecraftforge.items.wrapper.RangedWrapper` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/items/wrapper/RangedWrapper.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**（源码 javadoc）：A wrapper that composes another IItemHandlerModifiable, exposing only a range of the composed slots. Shifting of slot indices is handled automatically for you.

## 公开成员（8 个）

```java
public RangedWrapper(IItemHandlerModifiable compose, int minSlot, int maxSlotExclusive)
```
源码 :23 —（无 javadoc）

```java
public int getSlots()
```
源码 :32 —（无 javadoc）

```java
public ItemStack getStackInSlot(int slot)
```
源码 :39 —（无 javadoc）

```java
public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate)
```
源码 :51 —（无 javadoc）

```java
public ItemStack extractItem(int slot, int amount, boolean simulate)
```
源码 :63 —（无 javadoc）

```java
public void setStackInSlot(int slot, @NotNull ItemStack stack)
```
源码 :74 —（无 javadoc）

```java
public int getSlotLimit(int slot)
```
源码 :83 —（无 javadoc）

```java
public boolean isItemValid(int slot, @NotNull ItemStack stack)
```
源码 :94 —（无 javadoc）

