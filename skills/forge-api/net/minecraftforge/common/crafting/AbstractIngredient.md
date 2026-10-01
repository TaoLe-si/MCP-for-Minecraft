# AbstractIngredient

> `net.minecraftforge.common.crafting.AbstractIngredient` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/crafting/AbstractIngredient.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——配方条件与自定义配方，本仓库只读配方不注册

**职责**（源码 javadoc）：Extension of Ingredient which makes most methods custom ingredients need to implement abstract, and removes the static constructors Mods are encouraged to extend this class for their custom ingredients

## 公开成员（13 个）

```java
protected AbstractIngredient()
```
源码 :28 — Empty constructor, for the sake of dynamic ingredients

```java
protected AbstractIngredient(Stream<? extends Value> values)
```
源码 :34 — Value constructor, for ingredients that have some vanilla representation

```java
public abstract boolean isSimple()
```
源码 :40 —（无 javadoc）

```java
public abstract IIngredientSerializer<? extends Ingredient> getSerializer()
```
源码 :43 —（无 javadoc）

```java
public abstract JsonElement toJson()
```
源码 :46 —（无 javadoc）

```java
public static Ingredient fromValues(Stream<? extends Ingredient.Value> values)
```
源码 :53 —（无 javadoc）

```java
public static Ingredient of()
```
源码 :60 —（无 javadoc）

```java
public static Ingredient of(ItemLike... items)
```
源码 :67 —（无 javadoc）

```java
public static Ingredient of(ItemStack... stacks)
```
源码 :74 —（无 javadoc）

```java
public static Ingredient of(Stream<ItemStack> stacks)
```
源码 :81 —（无 javadoc）

```java
public static Ingredient of(TagKey<Item> tag)
```
源码 :88 —（无 javadoc）

```java
public static Ingredient fromNetwork(FriendlyByteBuf buffer)
```
源码 :95 —（无 javadoc）

```java
public static Ingredient fromJson(@Nullable JsonElement json)
```
源码 :102 —（无 javadoc）

