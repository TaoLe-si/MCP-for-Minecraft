# BrewingRecipeRegistry

> `net.minecraftforge.common.brewing.BrewingRecipeRegistry` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/brewing/BrewingRecipeRegistry.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（9 个）

```java
public static boolean addRecipe(Ingredient input, Ingredient ingredient, ItemStack output)
```
源码 :38 — Adds a recipe to the registry. Due to the nature of the brewing stand inputs that stack (a.k.a max stack size > 1) are not allowed. @param input The Ingredient that goes in same slots as the water bottles would. @param ingredient The Ingredient that goes in the same slot as nether wart would. @param…

```java
public static boolean addRecipe(IBrewingRecipe recipe)
```
源码 :47 — Adds a recipe to the registry. Due to the nature of the brewing stand inputs that stack (a.k.a max stack size > 1) are not allowed.

```java
public static ItemStack getOutput(ItemStack input, ItemStack ingredient)
```
源码 :56 — Returns the output ItemStack obtained by brewing the passed input and ingredient.

```java
public static boolean hasOutput(ItemStack input, ItemStack ingredient)
```
源码 :75 — Returns true if the passed input and ingredient have an output

```java
public static boolean canBrew(NonNullList<ItemStack> inputs, ItemStack ingredient, int[] inputIndexes)
```
源码 :85 — Used by the brewing stand to determine if its contents can be brewed. Extra parameters exist to allow modders to create bigger brewing stands without much hassle

```java
public static void brewPotions(NonNullList<ItemStack> inputs, ItemStack ingredient, int[] inputIndexes)
```
源码 :104 — Used by the brewing stand to brew its inventory Extra parameters exist to allow modders to create bigger brewing stands without much hassle

```java
public static boolean isValidIngredient(ItemStack stack)
```
源码 :120 — Returns true if the passed ItemStack is a valid ingredient for any of the recipes in the registry.

```java
public static boolean isValidInput(ItemStack stack)
```
源码 :138 — Returns true if the passed ItemStack is a valid input for any of the recipes in the registry.

```java
public static List<IBrewingRecipe> getRecipes()
```
源码 :153 — Returns an unmodifiable list containing all the recipes in the registry

