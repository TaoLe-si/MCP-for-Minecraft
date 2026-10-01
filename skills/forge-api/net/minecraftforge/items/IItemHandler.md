# IItemHandler

> `net.minecraftforge.items.IItemHandler` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/items/IItemHandler.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（6 个）

```java
int getSlots()
```
源码 :23 — Returns the number of slots available @return The number of slots available

```java
ItemStack getStackInSlot(int slot)
```
源码 :45 —（无 javadoc）

```java
ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate)
```
源码 :62 —（无 javadoc）

```java
ItemStack extractItem(int slot, int amount, boolean simulate)
```
源码 :78 —（无 javadoc）

```java
int getSlotLimit(int slot)
```
源码 :86 — Retrieves the maximum stack size allowed to exist in the given slot. @param slot Slot to query. @return The maximum stack size allowed in the slot.

```java
boolean isItemValid(int slot, @NotNull ItemStack stack)
```
源码 :107 — This function re-implements the vanilla function Container#canPlaceItem(int,. It should be used instead of simulated insertions in cases where the contents and state of the inventory are irrelevant, mainly for the purpose of automation and logic (for instance, testing if a minecart can wait to depos…

