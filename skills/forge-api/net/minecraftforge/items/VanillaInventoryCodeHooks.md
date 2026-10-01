# VanillaInventoryCodeHooks

> `net.minecraftforge.items.VanillaInventoryCodeHooks` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/items/VanillaInventoryCodeHooks.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（4 个）

```java
public static Boolean extractHook(Level level, Hopper dest)
```
源码 :35 —（无 javadoc）

```java
public static boolean dropperInsertHook(Level level, BlockPos pos, DispenserBlockEntity dropper, int slot, @NotNull ItemStack stack)
```
源码 :74 — Copied from BlockDropper#dispense and added capability support

```java
public static boolean insertHook(HopperBlockEntity hopper)
```
源码 :104 — Copied from TileEntityHopper#transferItemsOut and added capability support

```java
public static Optional<Pair<IItemHandler, Object>> getItemHandler(Level worldIn, double x, double y, double z, final Direction side)
```
源码 :233 —（无 javadoc）

