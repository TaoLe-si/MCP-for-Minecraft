# IForgeDispensibleContainerItem

> `net.minecraftforge.common.extensions.IForgeDispensibleContainerItem` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeDispensibleContainerItem.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（2 个）

```java
private DispensibleContainerItem self()
```
源码 :18 —（无 javadoc）

```java
default boolean emptyContents(@Nullable Player player, Level level, BlockPos pos, @Nullable BlockHitResult hitResult, @Nullable ItemStack container)
```
源码 :33 — Empties the contents of the container and returns whether it was successful. @param player Player who empties the container. May be null for blocks like dispensers. @param level Level to place the content in @param pos The position in the level to empty the content @param hitResult Hit result of the…

