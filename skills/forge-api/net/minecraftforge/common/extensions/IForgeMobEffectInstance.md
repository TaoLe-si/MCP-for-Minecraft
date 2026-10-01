# IForgeMobEffectInstance

> `net.minecraftforge.common.extensions.IForgeMobEffectInstance` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeMobEffectInstance.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（5 个）

```java
List<ItemStack> getCurativeItems()
```
源码 :25 — Returns a list of curative items for the potion effect By default, this list is initialized using MobEffect#getCurativeItems() @return The list (ItemStack) of curative items for the potion effect

```java
default boolean isCurativeItem(ItemStack stack)
```
源码 :32 — Checks the given ItemStack to see if it is in the list of curative items for the potion effect @param stack The ItemStack being checked against the list of curative items for this PotionEffect @return true if the given ItemStack is in the list of curative items for this PotionEffect, false otherwise

```java
void setCurativeItems(List<ItemStack> curativeItems)
```
源码 :40 — Sets the list of curative items for this potion effect, overwriting any already present @param curativeItems The list of ItemStacks being set to the potion effect

```java
default void addCurativeItem(ItemStack stack)
```
源码 :46 — Adds the given stack to the list of curative items for this PotionEffect @param stack The ItemStack being added to the curative item list

```java
default void writeCurativeItems(CompoundTag nbt)
```
源码 :51 —（无 javadoc）

