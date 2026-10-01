# IForgeCommandSourceStack

> `net.minecraftforge.common.extensions.IForgeCommandSourceStack` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeCommandSourceStack.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Additional methods for CommandSourceStack so that commands and arguments can access various things without directly referencing using server specific classes

## 公开成员（5 个）

```java
private CommandSourceStack self()
```
源码 :21 —（无 javadoc）

```java
default Scoreboard getScoreboard()
```
源码 :29 — @return the scoreboard

```java
default Advancement getAdvancement(ResourceLocation id)
```
源码 :37 — @return the advancement from the id

```java
default RecipeManager getRecipeManager()
```
源码 :45 — @return the recipe manager

```java
default Level getUnsidedLevel()
```
源码 :53 — @return the level but without being specifically the server side level

