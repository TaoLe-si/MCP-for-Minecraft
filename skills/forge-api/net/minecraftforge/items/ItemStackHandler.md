# ItemStackHandler

> `net.minecraftforge.items.ItemStackHandler` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/items/ItemStackHandler.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（18 个）

```java
protected NonNullList<ItemStack> stacks
```
源码 :18 —（无 javadoc）

```java
public ItemStackHandler()
```
源码 :20 —（无 javadoc）

```java
public ItemStackHandler(int size)
```
源码 :25 —（无 javadoc）

```java
public ItemStackHandler(NonNullList<ItemStack> stacks)
```
源码 :30 —（无 javadoc）

```java
public void setSize(int size)
```
源码 :35 —（无 javadoc）

```java
public void setStackInSlot(int slot, @NotNull ItemStack stack)
```
源码 :41 —（无 javadoc）

```java
public int getSlots()
```
源码 :49 —（无 javadoc）

```java
public ItemStack getStackInSlot(int slot)
```
源码 :56 —（无 javadoc）

```java
public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate)
```
源码 :64 —（无 javadoc）

```java
public ItemStack extractItem(int slot, int amount, boolean simulate)
```
源码 :109 —（无 javadoc）

```java
public int getSlotLimit(int slot)
```
源码 :149 —（无 javadoc）

```java
protected int getStackLimit(int slot, @NotNull ItemStack stack)
```
源码 :154 —（无 javadoc）

```java
public boolean isItemValid(int slot, @NotNull ItemStack stack)
```
源码 :160 —（无 javadoc）

```java
public CompoundTag serializeNBT()
```
源码 :166 —（无 javadoc）

```java
public void deserializeNBT(CompoundTag nbt)
```
源码 :186 —（无 javadoc）

```java
protected void validateSlotIndex(int slot)
```
源码 :203 —（无 javadoc）

```java
protected void onLoad()
```
源码 :209 —（无 javadoc）

```java
protected void onContentsChanged(int slot)
```
源码 :214 —（无 javadoc）

