# IForgeAbstractMinecart

> `net.minecraftforge.common.extensions.IForgeAbstractMinecart` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeAbstractMinecart.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（23 个）

```java
public static float DEFAULT_MAX_SPEED_AIR_LATERAL = 0.4f
```
源码 :15 —（无 javadoc）

```java
public static float DEFAULT_MAX_SPEED_AIR_VERTICAL = -1.0f
```
源码 :16 —（无 javadoc）

```java
public static double DEFAULT_AIR_DRAG = 0.95f
```
源码 :17 —（无 javadoc）

```java
private AbstractMinecart self()
```
源码 :19 —（无 javadoc）

```java
default BlockPos getCurrentRailPosition()
```
源码 :26 — Internal, returns the current spot to look for the attached rail.

```java
double getMaxSpeedWithRail()
```
源码 :36 —（无 javadoc）

```java
void moveMinecartOnRail(BlockPos pos)
```
源码 :42 — Moved to allow overrides. This code handles minecart movement and speed capping when on a rail.

```java
boolean canUseRail()
```
源码 :49 — Returns true if this cart can currently use rails. This function is mainly used to gracefully detach a minecart from a rail. @return True if the minecart can use rails.

```java
void setCanUseRail(boolean use)
```
源码 :56 — Set whether the minecart can use rails. This function is mainly used to gracefully detach a minecart from a rail. @param use Whether the minecart can currently use rails.

```java
default boolean shouldDoRailFunctions()
```
源码 :62 — Return false if this cart should not call onMinecartPass() and should ignore Powered Rails. @return True if this cart should call onMinecartPass().

```java
default boolean isPoweredCart()
```
源码 :70 — Returns true if this cart is self propelled. @return True if powered.

```java
default boolean canBeRidden()
```
源码 :78 — Returns true if this cart can be ridden by an Entity. @return True if this cart can be ridden.

```java
default float getMaxCartSpeedOnRail()
```
源码 :91 — Returns the carts max speed when traveling on rails. Carts going faster than 1.1 cause issues with chunk loading. Carts cant traverse slopes or corners at greater than 0.5 - 0.6. This value is compared with the rails max speed and the carts current speed cap to determine the carts current max speed.…

```java
float getCurrentCartSpeedCapOnRail()
```
源码 :101 — Returns the current speed cap for the cart when traveling on rails. This functions differs from getMaxCartSpeedOnRail() in that it controls current movement and cannot be overridden. The value however can never be higher than getMaxCartSpeedOnRail().

```java
void setCurrentCartSpeedCapOnRail(float value)
```
源码 :102 —（无 javadoc）

```java
float getMaxSpeedAirLateral()
```
源码 :103 —（无 javadoc）

```java
void setMaxSpeedAirLateral(float value)
```
源码 :104 —（无 javadoc）

```java
float getMaxSpeedAirVertical()
```
源码 :105 —（无 javadoc）

```java
void setMaxSpeedAirVertical(float value)
```
源码 :106 —（无 javadoc）

```java
double getDragAir()
```
源码 :107 —（无 javadoc）

```java
void setDragAir(double value)
```
源码 :108 —（无 javadoc）

```java
default double getSlopeAdjustment()
```
源码 :110 —（无 javadoc）

```java
default int getComparatorLevel()
```
源码 :117 — Called from Detector Rails to retrieve a redstone power level for comparators.

