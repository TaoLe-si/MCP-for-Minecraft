# IPermissionHandler

> `net.minecraftforge.server.permission.handler.IPermissionHandler` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/server/permission/handler/IPermissionHandler.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This is the Heart of the PermissionAPI, it manages PermissionNodes as well as it handles all permission queries. Note: You do not need to implement a PermissionHandler to query for permissions. @implNote The DefaultPermissionHandler does forward all permission queries to the PermissionNodes default resolver. @apiNote You can implement your own PermissionHandler using the PermissionGatherEvent.Hand…

## 公开成员（3 个）

```java
ResourceLocation getIdentifier()
```
源码 :33 — an identifier for the PermissionHandler

```java
<T> T getPermission(ServerPlayer player, PermissionNode<T> node, PermissionDynamicContext<?>... context)
```
源码 :54 — Mods must use PermissionAPI#getPermission(ServerPlayer, Queries a player's permission for a given node and contexts Warning: PermissionNodes must be registered using the PermissionGatherEvent.Nodes event before querying. @param player player for which you want to check permissions @param node the Pe…

```java
<T> T getOfflinePermission(UUID player, PermissionNode<T> node, PermissionDynamicContext<?>... context)
```
源码 :66 — See IPermissionHandler#getPermission(ServerPlayer, @param player offline player for which you want to check permissions @param node the PermissionNode for which you want to query @param context optional array of PermissionDynamicContext, single entries will be ignored if they weren't registered to t…

