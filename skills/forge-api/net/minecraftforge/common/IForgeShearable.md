# IForgeShearable

> `net.minecraftforge.common.IForgeShearable` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/IForgeShearable.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This allows for mods to create there own Shear-like items and have them interact with Blocks/Entities without extra work. Also, if your block/entity supports the Shears, this allows you to support mod-shears as well.

## 公开成员（2 个）

```java
default boolean isShearable(@NotNull ItemStack item, Level level, BlockPos pos)
```
源码 :37 — Checks if the object is currently shearable Example: Sheep return false when they have no wool @param item The ItemStack that is being used, may be empty. @param level The current level. @param pos Block's position in level. @return If this is shearable, and onSheared should be called.

```java
default List<ItemStack> onSheared(@Nullable Player player, @NotNull ItemStack item, Level level, BlockPos pos, int fortune)
```
源码 :61 —（无 javadoc）

