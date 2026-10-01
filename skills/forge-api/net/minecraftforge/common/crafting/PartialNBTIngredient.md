# PartialNBTIngredient

> `net.minecraftforge.common.crafting.PartialNBTIngredient` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/crafting/PartialNBTIngredient.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——配方条件与自定义配方，本仓库只读配方不注册

**职责**（源码 javadoc）：Ingredient that matches the given items, performing a partial NBT match. Use StrictNBTIngredient if you want exact match on NBT

## 公开成员（8 个）

```java
protected PartialNBTIngredient(Set<Item> items, CompoundTag nbt)
```
源码 :37 —（无 javadoc）

```java
public static PartialNBTIngredient of(CompoundTag nbt, ItemLike... items)
```
源码 :56 — Creates a new ingredient matching any item from the list, containing the given NBT

```java
public static PartialNBTIngredient of(ItemLike item, CompoundTag nbt)
```
源码 :62 — Creates a new ingredient matching the given item, containing the given NBT

```java
public boolean test(@Nullable ItemStack input)
```
源码 :68 —（无 javadoc）

```java
public boolean isSimple()
```
源码 :76 —（无 javadoc）

```java
public IIngredientSerializer<? extends Ingredient> getSerializer()
```
源码 :82 —（无 javadoc）

```java
public JsonElement toJson()
```
源码 :88 —（无 javadoc）

```java
public static class Serializer implements IIngredientSerializer<PartialNBTIngredient>
```
源码 :107 —（无 javadoc）

