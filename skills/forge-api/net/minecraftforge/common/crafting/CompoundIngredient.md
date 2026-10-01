# CompoundIngredient

> `net.minecraftforge.common.crafting.CompoundIngredient` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/crafting/CompoundIngredient.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——配方条件与自定义配方，本仓库只读配方不注册

**职责**（源码 javadoc）：Ingredient that matches if any of the child ingredients match

## 公开成员（12 个）

```java
protected CompoundIngredient(List<Ingredient> children)
```
源码 :38 —（无 javadoc）

```java
public static Ingredient of(Ingredient... children)
```
源码 :45 — Creates a compound ingredient from the given list of ingredients

```java
public ItemStack[] getItems()
```
源码 :71 —（无 javadoc）

```java
public IntList getStackingIds()
```
源码 :86 —（无 javadoc）

```java
public boolean test(@Nullable ItemStack target)
```
源码 :106 —（无 javadoc）

```java
protected void invalidate()
```
源码 :115 —（无 javadoc）

```java
public boolean isSimple()
```
源码 :122 —（无 javadoc）

```java
public IIngredientSerializer<? extends Ingredient> getSerializer()
```
源码 :128 —（无 javadoc）

```java
public Collection<Ingredient> getChildren()
```
源码 :134 —（无 javadoc）

```java
public JsonElement toJson()
```
源码 :140 —（无 javadoc）

```java
public boolean isEmpty()
```
源码 :155 —（无 javadoc）

```java
public static class Serializer implements IIngredientSerializer<CompoundIngredient>
```
源码 :160 —（无 javadoc）

