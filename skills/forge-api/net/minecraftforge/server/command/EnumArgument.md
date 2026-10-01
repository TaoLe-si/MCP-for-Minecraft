# EnumArgument

> `net.minecraftforge.server.command.EnumArgument` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/server/command/EnumArgument.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（5 个）

```java
public static <R extends Enum<R>> EnumArgument<R> enumArgument(Class<R> enumClass)
```
源码 :33 —（无 javadoc）

```java
public T parse(final StringReader reader) throws CommandSyntaxException
```
源码 :41 —（无 javadoc）

```java
public <S> CompletableFuture<Suggestions> listSuggestions(final CommandContext<S> context, final SuggestionsBuilder builder)
```
源码 :51 —（无 javadoc）

```java
public Collection<String> getExamples()
```
源码 :56 —（无 javadoc）

```java
public static class Info<T extends Enum<T>> implements ArgumentTypeInfo<EnumArgument<T>, Info<T>.Template>
```
源码 :60 —（无 javadoc）

