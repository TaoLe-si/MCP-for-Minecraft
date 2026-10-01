# IRecipeContainer

> `net.minecraftforge.common.crafting.IRecipeContainer` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/crafting/IRecipeContainer.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——配方条件与自定义配方，本仓库只读配方不注册

**职责**（源码 javadoc）：This interface is to be implemented on Container objects. For GUIs with recipe books, this allows their containers to have recipe completion and ghost recipes in their craft matrices.

## 公开成员（2 个）

```java
ResultContainer getCraftResult()
```
源码 :25 — The crafting result slot of your container, where you take out the crafted item. The equivalent for CraftingMenu is `CraftingMenu#resultSlots`. The equivalent for InventoryMenu is `InventoryMenu#resultSlots`.

```java
CraftingContainer getCraftMatrix()
```
源码 :32 — The crafting matrix of your container, where ingredients go for crafting. The equivalent for CraftingMenu is `CraftingMenu#craftSlots`. The equivalent for InventoryMenu is `InventoryMenu#craftSlots`.

