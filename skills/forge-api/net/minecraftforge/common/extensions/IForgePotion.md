# IForgePotion

> `net.minecraftforge.common.extensions.IForgePotion` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgePotion.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（2 个）

```java
private Potion self()
```
源码 :14 —（无 javadoc）

```java
default boolean isFoil(ItemStack stack)
```
源码 :25 — Determines whether the potion bottle item should be enchanted. Not called for tipped arrows or if the item is already enchanted. @param stack The potion bottle @return whether the item should appear enchanted.

