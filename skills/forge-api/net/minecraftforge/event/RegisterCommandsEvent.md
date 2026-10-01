# RegisterCommandsEvent

> `net.minecraftforge.event.RegisterCommandsEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/RegisterCommandsEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Commands are rebuilt whenever ReloadableServerResources is recreated. You can use this event to register your commands whenever the Commands class in constructed. The event is fired on the MinecraftForge#EVENT_BUS

## 公开成员（4 个）

```java
public RegisterCommandsEvent(CommandDispatcher<CommandSourceStack> dispatcher, Commands.CommandSelection environment, CommandBuildContext context)
```
源码 :30 —（无 javadoc）

```java
public CommandDispatcher<CommandSourceStack> getDispatcher()
```
源码 :40 — the command dispatcher for registering commands to be executed on the client

```java
public Commands.CommandSelection getCommandSelection()
```
源码 :48 — the environment the command is being registered for

```java
public CommandBuildContext getBuildContext()
```
源码 :56 — the context to build the commands for

