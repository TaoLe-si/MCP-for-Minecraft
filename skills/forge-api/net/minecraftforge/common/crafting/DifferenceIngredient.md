# DifferenceIngredient

> `net.minecraftforge.common.crafting.DifferenceIngredient` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/crafting/DifferenceIngredient.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——配方条件与自定义配方，本仓库只读配方不注册

**职责**（源码 javadoc）：Ingredient that matches everything from the first ingredient that is not included in the second ingredient

## 公开成员（11 个）

```java
protected DifferenceIngredient(Ingredient base, Ingredient subtracted)
```
源码 :29 —（无 javadoc）

```java
public static DifferenceIngredient of(Ingredient base, Ingredient subtracted)
```
源码 :41 — Gets the difference from the two ingredients @param base Ingredient the item must match @param subtracted Ingredient the item must not match @return Ingredient that `base` anything in base that is not in `subtracted`

```java
public boolean test(@Nullable ItemStack stack)
```
源码 :47 —（无 javadoc）

```java
public ItemStack[] getItems()
```
源码 :55 —（无 javadoc）

```java
public boolean isEmpty()
```
源码 :65 —（无 javadoc）

```java
public boolean isSimple()
```
源码 :71 —（无 javadoc）

```java
protected void invalidate()
```
源码 :77 —（无 javadoc）

```java
public IntList getStackingIds()
```
源码 :85 —（无 javadoc）

```java
public JsonElement toJson()
```
源码 :101 —（无 javadoc）

```java
public IIngredientSerializer<DifferenceIngredient> getSerializer()
```
源码 :111 —（无 javadoc）

```java
public static class Serializer implements IIngredientSerializer<DifferenceIngredient>
```
源码 :116 —（无 javadoc）

