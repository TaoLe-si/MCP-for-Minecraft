# FluidActionResult

> `net.minecraftforge.fluids.FluidActionResult` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fluids/FluidActionResult.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**（源码 javadoc）：Holds the result of a fluid action from FluidUtil. Failed actions will always have #isSuccess() == false and an empty ItemStack result. See #FAILURE. Successful actions will always have #isSuccess() == true. Successful actions may have an empty ItemStack result in some cases, for example the action succeeded and the resulting item was consumed.

## 公开成员（6 个）

```java
public static final FluidActionResult FAILURE = new FluidActionResult(false, ItemStack.EMPTY)
```
源码 :22 —（无 javadoc）

```java
public final boolean success
```
源码 :24 —（无 javadoc）

```java
public final ItemStack result
```
源码 :26 —（无 javadoc）

```java
public FluidActionResult(@NotNull ItemStack result)
```
源码 :28 —（无 javadoc）

```java
public boolean isSuccess()
```
源码 :39 —（无 javadoc）

```java
public ItemStack getResult()
```
源码 :45 —（无 javadoc）

