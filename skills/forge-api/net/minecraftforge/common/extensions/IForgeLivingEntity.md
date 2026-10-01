# IForgeLivingEntity

> `net.minecraftforge.common.extensions.IForgeLivingEntity` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeLivingEntity.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（6 个）

```java
default LivingEntity self()
```
源码 :16 —（无 javadoc）

```java
default boolean canSwimInFluidType(FluidType type)
```
源码 :22 —（无 javadoc）

```java
default void jumpInFluid(FluidType type)
```
源码 :33 — Performs what to do when an entity attempts to go up or "jump" in a fluid. @param type the type of the fluid

```java
default void sinkInFluid(FluidType type)
```
源码 :43 — Performs what to do when an entity attempts to go down or "sink" in a fluid. @param type the type of the fluid

```java
default boolean canDrownInFluidType(FluidType type)
```
源码 :54 — Returns whether the entity can drown in the fluid. @param type the type of the fluid @return `true` if the entity can drown in the fluid, `false` otherwise

```java
default boolean moveInFluid(FluidState state, Vec3 movementVector, double gravity)
```
源码 :70 — Performs how an entity moves when within the fluid. If using custom movement logic, the method should return `true`. Otherwise, the movement logic will default to water. @param state the state of the fluid @param movementVector the velocity of how the entity wants to move @param gravity the gravity…

