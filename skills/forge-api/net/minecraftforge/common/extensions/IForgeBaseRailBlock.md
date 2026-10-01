# IForgeBaseRailBlock

> `net.minecraftforge.common.extensions.IForgeBaseRailBlock` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeBaseRailBlock.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（5 个）

```java
boolean isFlexibleRail(BlockState state, BlockGetter level, BlockPos pos)
```
源码 :27 — Return true if the rail can make corners. Used by placement logic. @param level The level. @param pos Block's position in level @return True if the rail can make corners.

```java
default boolean canMakeSlopes(BlockState state, BlockGetter level, BlockPos pos)
```
源码 :36 — Returns true if the rail can make up and down slopes. Used by placement logic. @param level The level. @param pos Block's position in level @return True if the rail can make slopes.

```java
RailShape getRailDirection(BlockState state, BlockGetter level, BlockPos pos, @Nullable AbstractMinecart cart)
```
源码 :53 — Return the rail's direction. Can be used to make the cart think the rail is a different shape, for example when making diamond junctions or switches. The cart parameter will often be null unless it it called from EntityMinecart. @param level The level. @param pos Block's position in level @param sta…

```java
default float getRailMaxSpeed(BlockState state, Level level, BlockPos pos, AbstractMinecart cart)
```
源码 :62 — Returns the max speed of the rail at the specified position. @param level The level. @param cart The cart on the rail, may be null. @param pos Block's position in level @return The max speed of the current rail.

```java
default void onMinecartPass(BlockState state, Level level, BlockPos pos, AbstractMinecart cart){} /** * Returns true if the given {@link RailShape} is valid for this rail block. * This is called when the RailShape for the initial placement of this block is calculated or * when another rail block tries to connect to this block and this block's RailState calculates * the new RailShape for its current neigbors. * @param shape The new RailShape * @return True when the given RailShape is valid */ default boolean isValidRailShape(RailShape shape)
```
源码 :75 — This function is called by any minecart that passes over this rail. It is called once per update tick that the minecart is on the rail. @param level The level. @param cart The cart on the rail. @param pos Block's position in level

