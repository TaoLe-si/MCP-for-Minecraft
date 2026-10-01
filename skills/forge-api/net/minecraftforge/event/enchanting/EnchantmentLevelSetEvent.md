# EnchantmentLevelSetEvent

> `net.minecraftforge.event.enchanting.EnchantmentLevelSetEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/enchanting/EnchantmentLevelSetEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired when the enchantment level is set for each of the three potential enchantments in the enchanting table. The #level is set to the vanilla value and can be modified by this event handler. The #enchantRow is used to determine which enchantment level is being set, 1, 2, or 3. The #power is a number from 0-15 and indicates how many bookshelves surround the enchanting table. The #itemStack represe…

## 公开成员（9 个）

```java
public EnchantmentLevelSetEvent(Level level, BlockPos pos, int enchantRow, int power, @NotNull ItemStack itemStack, int enchantLevel)
```
源码 :32 —（无 javadoc）

```java
public Level getLevel()
```
源码 :48 — Get the world object @return the world object

```java
public BlockPos getPos()
```
源码 :58 — Get the pos of the enchantment table @return the pos of the enchantment table

```java
public int getEnchantRow()
```
源码 :68 — Get the row for which the enchantment level is being set @return the row for which the enchantment level is being set

```java
public int getPower()
```
源码 :78 — Get the power (# of bookshelves) for the enchanting table @return the power (# of bookshelves) for the enchanting table

```java
public ItemStack getItem()
```
源码 :89 —（无 javadoc）

```java
public int getOriginalLevel()
```
源码 :99 — Get the original level of the enchantment for this row (0-30) @return the original level of the enchantment for this row (0-30)

```java
public int getEnchantLevel()
```
源码 :109 — Get the level of the enchantment for this row (0-30) @return the level of the enchantment for this row (0-30)

```java
public void setEnchantLevel(int level)
```
源码 :119 — Set the new level of the enchantment (0-30) @param level the new level of the enchantment (0-30)

