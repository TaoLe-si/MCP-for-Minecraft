# ItemHandlerHelper

> `net.minecraftforge.items.ItemHandlerHelper` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/items/ItemHandlerHelper.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（8 个）

```java
public static ItemStack insertItem(IItemHandler dest, @NotNull ItemStack stack, boolean simulate)
```
源码 :22 —（无 javadoc）

```java
public static boolean canItemStacksStack(@NotNull ItemStack a, @NotNull ItemStack b)
```
源码 :39 —（无 javadoc）

```java
public static boolean canItemStacksStackRelaxed(@NotNull ItemStack a, @NotNull ItemStack b)
```
源码 :51 — A relaxed version of canItemStacksStack that stacks itemstacks with different metadata if they don't have subtypes. This usually only applies when players pick up items.

```java
public static ItemStack copyStackWithSize(@NotNull ItemStack itemStack, int size)
```
源码 :73 —（无 javadoc）

```java
public static ItemStack insertItemStacked(IItemHandler inventory, @NotNull ItemStack stack, boolean simulate)
```
源码 :88 —（无 javadoc）

```java
public static void giveItemToPlayer(Player player, @NotNull ItemStack stack)
```
源码 :137 — giveItemToPlayer without preferred slot

```java
public static void giveItemToPlayer(Player player, @NotNull ItemStack stack, int preferredSlot)
```
源码 :148 — Inserts the given itemstack into the players inventory. If the inventory can't hold it, the item will be dropped in the world at the players position. @param player The player to give the item to @param stack The itemstack to insert

```java
public static int calcRedstoneFromInventory(@Nullable IItemHandler inv)
```
源码 :192 — This method uses the standard vanilla algorithm to calculate a comparator output for how "full" the inventory is. This method is an adaptation of Container#calcRedstoneFromInventory(IInventory). @param inv The inventory handler to test. @return A redstone value in the range [0,15] representing how "…

