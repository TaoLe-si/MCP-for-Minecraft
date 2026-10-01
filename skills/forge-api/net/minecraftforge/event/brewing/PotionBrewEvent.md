# PotionBrewEvent

> `net.minecraftforge.event.brewing.PotionBrewEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/brewing/PotionBrewEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（6 个）

```java
protected PotionBrewEvent(NonNullList<ItemStack> stacks)
```
源码 :19 —（无 javadoc）

```java
public ItemStack getItem(int index)
```
源码 :25 —（无 javadoc）

```java
public void setItem(int index, @NotNull ItemStack stack)
```
源码 :31 —（无 javadoc）

```java
public int getLength()
```
源码 :39 —（无 javadoc）

```java
public static class Pre extends PotionBrewEvent
```
源码 :62 —（无 javadoc）

```java
public static class Post extends PotionBrewEvent
```
源码 :83 — PotionBrewEvent.Post is fired when a potion is brewed in the brewing stand. The event is fired during the `BrewingStandBlockEntity#doBrew(Level, BlockPos, NonNullList)` method invocation. #stacks contains the itemstack array from the TileEntityBrewer holding all items in Brewer. This event is not ne…

