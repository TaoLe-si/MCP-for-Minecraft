# IForgeFluid

> `net.minecraftforge.common.extensions.IForgeFluid` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeFluid.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（11 个）

```java
private Fluid self()
```
源码 :27 —（无 javadoc）

```java
default float getExplosionResistance(FluidState state, BlockGetter level, BlockPos pos, Explosion explosion)
```
源码 :42 —（无 javadoc）

```java
FluidType getFluidType()
```
源码 :55 — Returns the type of this fluid. Important: This MUST be overridden on your fluid, otherwise an error will be thrown. @return the type of this fluid

```java
default boolean move(FluidState state, LivingEntity entity, Vec3 movementVector, double gravity)
```
源码 :68 — Performs how an entity moves when within the fluid. If using custom movement logic, the method should return `true`. Otherwise, the movement logic will default to water. @param state the state of the fluid @param entity the entity moving within the fluid @param movementVector the velocity of how the…

```java
default boolean canConvertToSource(FluidState state, Level level, BlockPos pos)
```
源码 :81 — Returns whether the fluid can create a source. @param state the state of the fluid @param level the level that can get the fluid @param pos the location of the fluid @return `true` if the fluid can create a source, `false` otherwise

```java
default boolean supportsBoating(FluidState state, Boat boat)
```
源码 :93 — Returns whether the boat can be used on the fluid. @param state the state of the fluid @param boat the boat trying to be used on the fluid @return `true` if the boat can be used, `false` otherwise

```java
default boolean shouldUpdateWhileBoating(FluidState state, Boat boat, Entity rider)
```
源码 :107 — When `false`, the fluid will no longer update its height value while within a boat while it is not within a fluid (Boat#isUnderWater(). @param state the state of the fluid the rider is within @param boat the boat the rider is within that is not inside a fluid @param rider the rider of the boat @retu…

```java
default BlockPathTypes getBlockPathType(FluidState state, BlockGetter level, BlockPos pos, @org.jetbrains.annotations.Nullable Mob mob, boolean canFluidLog)
```
源码 :125 —（无 javadoc）

```java
default BlockPathTypes getAdjacentBlockPathType(FluidState state, BlockGetter level, BlockPos pos, @org.jetbrains.annotations.Nullable Mob mob, BlockPathTypes originalType)
```
源码 :144 —（无 javadoc）

```java
default boolean canHydrate(FluidState state, BlockGetter getter, BlockPos pos, BlockState source, BlockPos sourcePos)
```
源码 :166 — Returns whether the block can be hydrated by a fluid. Hydration is an arbitrary word which depends on the block. A farmland has moisture A sponge can soak up the liquid A coral can live @param state the state of the fluid @param getter the getter which can get the fluid @param pos the position of th…

```java
default boolean canExtinguish(FluidState state, BlockGetter getter, BlockPos pos)
```
源码 :179 — Returns whether the block can be extinguished by this fluid. @param state the state of the fluid @param getter the getter which can get the fluid @param pos the position of the fluid @return `true` if the block can be extinguished, `false` otherwise

