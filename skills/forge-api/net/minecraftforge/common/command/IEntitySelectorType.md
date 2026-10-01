# IEntitySelectorType

> `net.minecraftforge.common.command.IEntitySelectorType` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/command/IEntitySelectorType.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Implementations of this interface can be registered using EntitySelectorManager#register

## 公开成员（2 个）

```java
EntitySelector build(EntitySelectorParser parser) throws CommandSyntaxException
```
源码 :26 — Returns an EntitySelector based on the given EntitySelectorParser. Use EntitySelectorParser#getReader to read extra arguments and EntitySelectorParser#addPredicate(Predicate) to add the corresponding filters. If the token being parsed does not match the syntax of this selector, this method should th…

```java
Component getSuggestionTooltip()
```
源码 :31 — Returns an Component containing a short description for this selector type.

