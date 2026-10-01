# IForgeBoat

> `net.minecraftforge.common.extensions.IForgeBoat` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeBoat.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（4 个）

```java
private Boat self()
```
源码 :15 —（无 javadoc）

```java
default boolean canBoatInFluid(FluidState state)
```
源码 :26 — Returns whether the boat can be used on the fluid. @param state the state of the fluid @return `true` if the boat can be used, `false` otherwise

```java
default boolean canBoatInFluid(FluidType type)
```
源码 :37 — Returns whether the boat can be used on the fluid. @param type the type of the fluid @return `true` if the boat can be used, `false` otherwise

```java
default boolean shouldUpdateFluidWhileRiding(FluidState state, Entity rider)
```
源码 :50 — When `false`, the fluid will no longer update its height value while within a boat while it is not within a fluid (Boat#isUnderWater(). @param state the state of the fluid the rider is within @param rider the rider of the boat @return `true` if the fluid height should be updated, `false` otherwise

