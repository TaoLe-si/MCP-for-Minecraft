# CommandHelper

> `net.minecraftforge.server.command.CommandHelper` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/server/command/CommandHelper.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Internal utility class for various command-related operations. For internal Forge use only. @hidden

## 公开成员（1 个）

```java
public static <S, T> void mergeCommandNode(CommandNode<S> sourceNode, CommandNode<T> resultNode, Map<CommandNode<S>, CommandNode<T>> sourceToResult, S canUse, Command<T> execute, Function<SuggestionProvider<S>, SuggestionProvider<T>> sourceToResultSuggestion)
```
源码 :44 — Deep copies the children of a command node and stores a link between the source and the copy @param sourceNode the original command node @param resultNode the result command node @param sourceToResult a map storing the original command node as the key and the result command node as the value @param…

