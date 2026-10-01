# RegisterClientCommandsEvent

> `net.minecraftforge.client.event.RegisterClientCommandsEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RegisterClientCommandsEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired to allow mods to register client commands. Some command arguments behave differently for the client commands dispatcher: ResourceLocationArgument#getAdvancement(com.mojang.brigadier.context.CommandContext, only returns advancements that are shown on the advancements screen. ObjectiveArgument#getObjective(com.mojang.brigadier.context.CommandContext, only returns objectives that are displayed…

## 公开成员（3 个）

```java
public RegisterClientCommandsEvent(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext context)
```
源码 :43 —（无 javadoc）

```java
public CommandDispatcher<CommandSourceStack> getDispatcher()
```
源码 :52 — the command dispatcher for registering commands to be executed on the client

```java
public CommandBuildContext getBuildContext()
```
源码 :60 — the context to build the commands for

