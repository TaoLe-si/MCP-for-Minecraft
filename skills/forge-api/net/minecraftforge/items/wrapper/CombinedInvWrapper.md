# CombinedInvWrapper

> `net.minecraftforge.items.wrapper.CombinedInvWrapper` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/items/wrapper/CombinedInvWrapper.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（14 个）

```java
protected final IItemHandlerModifiable[] itemHandler
```
源码 :16 —（无 javadoc）

```java
protected final int[] baseIndex
```
源码 :17 —（无 javadoc）

```java
protected final int slotCount
```
源码 :18 —（无 javadoc）

```java
public CombinedInvWrapper(IItemHandlerModifiable... itemHandler)
```
源码 :20 —（无 javadoc）

```java
protected int getIndexForSlot(int slot)
```
源码 :34 —（无 javadoc）

```java
protected IItemHandlerModifiable getHandlerFromIndex(int index)
```
源码 :49 —（无 javadoc）

```java
protected int getSlotFromIndex(int slot, int index)
```
源码 :58 —（无 javadoc）

```java
public void setStackInSlot(int slot, @NotNull ItemStack stack)
```
源码 :68 —（无 javadoc）

```java
public int getSlots()
```
源码 :77 —（无 javadoc）

```java
public ItemStack getStackInSlot(int slot)
```
源码 :84 —（无 javadoc）

```java
public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate)
```
源码 :94 —（无 javadoc）

```java
public ItemStack extractItem(int slot, int amount, boolean simulate)
```
源码 :104 —（无 javadoc）

```java
public int getSlotLimit(int slot)
```
源码 :113 —（无 javadoc）

```java
public boolean isItemValid(int slot, @NotNull ItemStack stack)
```
源码 :122 —（无 javadoc）

