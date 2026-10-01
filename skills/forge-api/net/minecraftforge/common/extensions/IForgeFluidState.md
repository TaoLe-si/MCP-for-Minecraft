# IForgeFluidState

> `net.minecraftforge.common.extensions.IForgeFluidState` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeFluidState.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（11 个）

```java
private FluidState self()
```
源码 :26 —（无 javadoc）

```java
default float getExplosionResistance(BlockGetter level, BlockPos pos, Explosion explosion)
```
源码 :39 — Returns the explosion resistance of the fluid. @param level the level the fluid is in @param pos the position of the fluid @param explosion the explosion the fluid is absorbing @return the amount of the explosion the fluid can absorb

```java
default FluidType getFluidType()
```
源码 :49 — Returns the type of this fluid. @return the type of this fluid

```java
default boolean move(LivingEntity entity, Vec3 movementVector, double gravity)
```
源码 :64 — Performs how an entity moves when within the fluid. If using custom movement logic, the method should return `true`. Otherwise, the movement logic will default to water. @param entity the entity moving within the fluid @param movementVector the velocity of how the entity wants to move @param gravity…

```java
default boolean canConvertToSource(Level level, BlockPos pos)
```
源码 :76 — Returns whether the fluid can create a source. @param level the level that can get the fluid @param pos the location of the fluid @return `true` if the fluid can create a source, `false` otherwise

```java
default boolean supportsBoating(Boat boat)
```
源码 :87 — Returns whether the boat can be used on the fluid. @param boat the boat trying to be used on the fluid @return `true` if the boat can be used, `false` otherwise

```java
default boolean shouldUpdateWhileBoating(Boat boat, Entity rider)
```
源码 :100 — When `false`, the fluid will no longer update its height value while within a boat while it is not within a fluid (Boat#isUnderWater(). @param boat the boat the rider is within that is not inside a fluid @param rider the rider of the boat @return `true` if the fluid height should be updated, `false`…

```java
default BlockPathTypes getBlockPathType(BlockGetter level, BlockPos pos, @org.jetbrains.annotations.Nullable Mob mob, boolean canFluidLog)
```
源码 :117 —（无 javadoc）

```java
default BlockPathTypes getAdjacentBlockPathType(BlockGetter level, BlockPos pos, @org.jetbrains.annotations.Nullable Mob mob, BlockPathTypes originalType)
```
源码 :135 —（无 javadoc）

```java
default boolean canHydrate(BlockGetter getter, BlockPos pos, BlockState source, BlockPos sourcePos)
```
源码 :156 — Returns whether the block can be hydrated by a fluid. Hydration is an arbitrary word which depends on the block. A farmland has moisture A sponge can soak up the liquid A coral can live @param getter the getter which can get the fluid @param pos the position of the fluid @param source the state of t…

```java
default boolean canExtinguish(BlockGetter getter, BlockPos pos)
```
源码 :168 — Returns whether the block can be extinguished by this fluid. @param getter the getter which can get the fluid @param pos the position of the fluid @return `true` if the block can be extinguished, `false` otherwise

