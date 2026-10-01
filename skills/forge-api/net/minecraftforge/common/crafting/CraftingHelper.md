# CraftingHelper

> `net.minecraftforge.common.crafting.CraftingHelper` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/crafting/CraftingHelper.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——配方条件与自定义配方，本仓库只读配方不注册

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（15 个）

```java
public static IConditionSerializer<?> register(IConditionSerializer<?> serializer)
```
源码 :53 —（无 javadoc）

```java
public static <T extends Ingredient> IIngredientSerializer<T> register(ResourceLocation key, IIngredientSerializer<T> serializer)
```
源码 :61 —（无 javadoc）

```java
public static ResourceLocation getID(IIngredientSerializer<?> serializer)
```
源码 :71 —（无 javadoc）

```java
public static <T extends Ingredient> void write(FriendlyByteBuf buffer, T ingredient)
```
源码 :75 —（无 javadoc）

```java
public static Ingredient getIngredient(ResourceLocation type, FriendlyByteBuf buffer)
```
源码 :90 —（无 javadoc）

```java
public static Ingredient getIngredient(JsonElement json, boolean allowEmpty)
```
源码 :98 —（无 javadoc）

```java
public static ItemStack getItemStack(JsonObject json, boolean readNBT)
```
源码 :151 —（无 javadoc）

```java
public static Item getItem(String itemName, boolean disallowsAirInRecipe)
```
源码 :156 —（无 javadoc）

```java
public static CompoundTag getNBT(JsonElement element)
```
源码 :168 —（无 javadoc）

```java
public static ItemStack getItemStack(JsonObject json, boolean readNBT, boolean disallowsAirInRecipe)
```
源码 :183 —（无 javadoc）

```java
public static boolean processConditions(JsonObject json, String memberName, ICondition.IContext context)
```
源码 :207 —（无 javadoc）

```java
public static boolean processConditions(JsonArray conditions, ICondition.IContext context)
```
源码 :212 —（无 javadoc）

```java
public static ICondition getCondition(JsonObject json)
```
源码 :226 —（无 javadoc）

```java
public static <T extends ICondition> JsonObject serialize(T condition)
```
源码 :235 —（无 javadoc）

```java
public static JsonArray serialize(ICondition... conditions)
```
源码 :244 —（无 javadoc）

