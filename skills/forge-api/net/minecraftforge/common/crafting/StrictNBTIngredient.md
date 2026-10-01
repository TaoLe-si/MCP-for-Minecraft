# StrictNBTIngredient

> `net.minecraftforge.common.crafting.StrictNBTIngredient` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/crafting/StrictNBTIngredient.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——配方条件与自定义配方，本仓库只读配方不注册

**职责**（源码 javadoc）：Ingredient that matches the given stack, performing an exact NBT match. Use PartialNBTIngredient if you need partial match.

## 公开成员（7 个）

```java
protected StrictNBTIngredient(ItemStack stack)
```
源码 :23 —（无 javadoc）

```java
public static StrictNBTIngredient of(ItemStack stack)
```
源码 :30 — Creates a new ingredient matching the given stack and tag

```java
public boolean test(@Nullable ItemStack input)
```
源码 :36 —（无 javadoc）

```java
public boolean isSimple()
```
源码 :45 —（无 javadoc）

```java
public IIngredientSerializer<? extends Ingredient> getSerializer()
```
源码 :51 —（无 javadoc）

```java
public JsonElement toJson()
```
源码 :57 —（无 javadoc）

```java
public static class Serializer implements IIngredientSerializer<StrictNBTIngredient>
```
源码 :68 —（无 javadoc）

