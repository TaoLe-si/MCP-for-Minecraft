# RecipeBookManager

> `net.minecraftforge.client.RecipeBookManager` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/RecipeBookManager.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Manager for RecipeBookType and RecipeBookCategories. Provides a recipe category lookup.

## 公开成员（4 个）

```java
public static <T extends Recipe<?>> RecipeBookCategories findCategories(RecipeType<T> type, T recipe)
```
源码 :42 —（无 javadoc）

```java
public static Map<RecipeBookCategories, List<RecipeBookCategories>> getAggregateCategories()
```
源码 :49 —（无 javadoc）

```java
public static List<RecipeBookCategories> getCustomCategoriesOrEmpty(RecipeBookType recipeBookType)
```
源码 :55 —（无 javadoc）

```java
public static void init()
```
源码 :61 —（无 javadoc）

