# FurnaceFuelBurnTimeEvent

> `net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/furnace/FurnaceFuelBurnTimeEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：FurnaceFuelBurnTimeEvent is fired when determining the fuel value for an ItemStack. To set the burn time of your own item, use Item#getBurnTime(ItemStack, instead. This event is fired from ForgeEventFactory#getItemBurnTime(ItemStack,. This event is Cancelable to prevent later handlers from changing the value. This event does not have a result. HasResult This event is fired on the MinecraftForge#EV…

## 公开成员（5 个）

```java
public FurnaceFuelBurnTimeEvent(@NotNull ItemStack itemStack, int burnTime, @Nullable RecipeType<?> recipeType)
```
源码 :40 —（无 javadoc）

```java
public ItemStack getItemStack()
```
源码 :51 —（无 javadoc）

```java
public RecipeType<?> getRecipeType()
```
源码 :61 —（无 javadoc）

```java
public void setBurnTime(int burnTime)
```
源码 :70 — Set the burn time for the given ItemStack. Setting it to 0 will prevent the item from being used as fuel, overriding vanilla's decision.

```java
public int getBurnTime()
```
源码 :83 — The resulting value of this event, the burn time for the ItemStack. A value of 0 will prevent the item from being used as fuel, overriding vanilla's decision.

