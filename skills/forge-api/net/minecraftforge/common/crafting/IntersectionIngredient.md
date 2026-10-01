# IntersectionIngredient

> `net.minecraftforge.common.crafting.IntersectionIngredient` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/crafting/IntersectionIngredient.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——配方条件与自定义配方，本仓库只读配方不注册

**职责**（源码 javadoc）：Ingredient that matches if all child ingredients match

## 公开成员（11 个）

```java
protected IntersectionIngredient(List<Ingredient> children)
```
源码 :35 —（无 javadoc）

```java
public static Ingredient of(Ingredient... ingredients)
```
源码 :48 — Gets an intersection ingredient @param ingredients List of ingredients to match @return Ingredient that only matches if all the passed ingredients match

```java
public boolean test(@Nullable ItemStack stack)
```
源码 :59 —（无 javadoc）

```java
public ItemStack[] getItems()
```
源码 :72 —（无 javadoc）

```java
public boolean isEmpty()
```
源码 :92 —（无 javadoc）

```java
public boolean isSimple()
```
源码 :98 —（无 javadoc）

```java
protected void invalidate()
```
源码 :104 —（无 javadoc）

```java
public IntList getStackingIds()
```
源码 :112 —（无 javadoc）

```java
public JsonElement toJson()
```
源码 :127 —（无 javadoc）

```java
public IIngredientSerializer<IntersectionIngredient> getSerializer()
```
源码 :140 —（无 javadoc）

```java
public static class Serializer implements IIngredientSerializer<IntersectionIngredient>
```
源码 :145 —（无 javadoc）

