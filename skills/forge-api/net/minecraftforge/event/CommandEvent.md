# CommandEvent

> `net.minecraftforge.event.CommandEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/CommandEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：CommandEvent is fired after a command is parsed, but before it is executed. This event is fired during the invocation of Commands#performCommand(ParseResults,. This event is Cancelable cancellable, and does not HasResult have a result. If the event is cancelled, the command will not be executed. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#SERVE…

## 公开成员（5 个）

```java
public CommandEvent(ParseResults<CommandSourceStack> parse)
```
源码 :34 —（无 javadoc）

```java
public ParseResults<CommandSourceStack> getParseResults()
```
源码 :42 — the parsed command results

```java
public void setParseResults(ParseResults<CommandSourceStack> parse)
```
源码 :47 —（无 javadoc）

```java
public Throwable getException()
```
源码 :56 —（无 javadoc）

```java
public void setException(@Nullable Throwable exception)
```
源码 :61 —（无 javadoc）

