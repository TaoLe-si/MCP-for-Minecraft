# PermissionGatherEvent

> `net.minecraftforge.server.permission.events.PermissionGatherEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/server/permission/events/PermissionGatherEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired to gather information for the permissions API, such as the IPermissionHandler and PermissionNodes. Handler allows to set a new PermissionHandler Nodes allows you to register new PermissionNodes Note: All PermissionNodes that you want to use, must be registered!

## 公开成员（2 个）

```java
public static class Handler extends PermissionGatherEvent
```
源码 :36 — Used to register a new PermissionHandler, a server config value exists to choose which one to use. Note: Create a new instance when registering a PermissionHandler. If you cache it, make sure that your PermissionHandler is actually used after this event.

```java
public static class Nodes extends PermissionGatherEvent
```
源码 :64 — Used to register your PermissionNodes, every node that you want to use, must be registered!

