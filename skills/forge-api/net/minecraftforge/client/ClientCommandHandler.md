# ClientCommandHandler

> `net.minecraftforge.client.ClientCommandHandler` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/ClientCommandHandler.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（5 个）

```java
public static void init()
```
源码 :42 —（无 javadoc）

```java
public static CommandDispatcher<SharedSuggestionProvider> mergeServerCommands(CommandDispatcher<SharedSuggestionProvider> serverCommands, CommandBuildContext buildContext)
```
源码 :62 —（无 javadoc）

```java
public static CommandDispatcher<CommandSourceStack> getDispatcher()
```
源码 :103 — @return The command dispatcher for client side commands

```java
public static ClientCommandSourceStack getSource()
```
源码 :111 — @return A ClientCommandSourceStack for the player in the current client

```java
public static boolean runCommand(String command)
```
源码 :153 — Always try to execute the cached parsing of a typed command as a clientside command. Requires that the execute field of the commands to be set to send to server so that they aren't treated as client command's that do nothing. net.minecraft.commands.Commands#performCommand(ParseResults, for reference…

