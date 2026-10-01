# RegisterRecipeBookCategoriesEvent

> `net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RegisterRecipeBookCategoriesEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Allows users to register custom categories for the vanilla recipe book, making it usable in modded GUIs. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the FMLJavaModLoadingContext#getModEventBus() mod-specific event bus, only on the LogicalSide#CLIENT logical client.

## 公开成员（4 个）

```java
public RegisterRecipeBookCategoriesEvent( Map<RecipeBookCategories, ImmutableList<RecipeBookCategories>> aggregateCategories, Map<RecipeBookType, ImmutableList<RecipeBookCategories>> typeCategories, Map<RecipeType<?>, Function<Recipe<?>, RecipeBookCategories>> recipeCategoryLookups)
```
源码 :39 —（无 javadoc）

```java
public void registerAggregateCategory(RecipeBookCategories category, List<RecipeBookCategories> others)
```
源码 :52 — Registers the list of categories that compose an aggregate category.

```java
public void registerBookCategories(RecipeBookType type, List<RecipeBookCategories> categories)
```
源码 :60 — Registers the list of categories that compose a recipe book.

```java
public void registerRecipeCategoryFinder(RecipeType<?> type, Function<Recipe<?>, RecipeBookCategories> lookup)
```
源码 :68 — Registers a category lookup for a certain recipe type.

