# EntitySelectorManager

> `net.minecraftforge.common.command.EntitySelectorManager` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/command/EntitySelectorManager.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Allows modders to register custom entity selectors by assigning an IEntitySelectorType to a String token. The token "test", for example, corresponds to @test[...] in a command.

## 公开成员（3 个）

```java
public static void register(String token, IEntitySelectorType type)
```
源码 :30 — Registers a new IEntitySelectorType for the given `token`. @param token Defines the name of the selector

```java
public static EntitySelector parseSelector(EntitySelectorParser parser) throws CommandSyntaxException
```
源码 :58 — This method is called in EntitySelectorParser#parse() If the REGISTRY does not contain a custom selector for the command being parsed, this method returns `null` and the vanilla logic in `EntitySelectorParser#parseSelector()` is used.

```java
public static void fillSelectorSuggestions(SuggestionsBuilder suggestionBuilder)
```
源码 :79 — This method is called in `EntitySelectorParser#fillSelectorSuggestions(SuggestionsBuilder)`

