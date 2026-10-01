# IForgeEnchantment

> `net.minecraftforge.common.extensions.IForgeEnchantment` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeEnchantment.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（3 个）

```java
private Enchantment self()
```
源码 :18 —（无 javadoc）

```java
default float getDamageBonus(int level, MobType mobType, ItemStack enchantedItem)
```
源码 :31 —（无 javadoc）

```java
default boolean allowedInCreativeTab(Item book, Set<EnchantmentCategory> allowedCategories)
```
源码 :43 — Determines whether item variants of this enchantment can be added to a given creative tab with the allowed categories. @param book the item being added to the creative tab @param allowedCategories the enchantment categories allowed in the creative tab @return whether item variants of this enchantmen…

