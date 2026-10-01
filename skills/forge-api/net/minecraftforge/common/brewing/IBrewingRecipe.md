# IBrewingRecipe

> `net.minecraftforge.common.brewing.IBrewingRecipe` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/brewing/IBrewingRecipe.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（3 个）

```java
boolean isInput(ItemStack input)
```
源码 :17 — Returns true is the passed ItemStack is an input for this recipe. "Input" being the item that goes in one of the three bottom slots of the brewing stand (e.g: water bottle)

```java
boolean isIngredient(ItemStack ingredient)
```
源码 :24 — Returns true if the passed ItemStack is an ingredient for this recipe. "Ingredient" being the item that goes in the top slot of the brewing stand (e.g: nether wart)

```java
ItemStack getOutput(ItemStack input, ItemStack ingredient)
```
源码 :30 — Returns the output when the passed input is brewed with the passed ingredient. Empty if invalid input or ingredient.

