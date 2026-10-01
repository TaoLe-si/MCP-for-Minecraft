# PermissionAPI

> `net.minecraftforge.server.permission.PermissionAPI` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/server/permission/PermissionAPI.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（5 个）

```java
public static Collection<PermissionNode<?>> getRegisteredNodes()
```
源码 :35 —（无 javadoc）

```java
public static ResourceLocation getActivePermissionHandler()
```
源码 :48 —（无 javadoc）

```java
public static <T> T getPermission(ServerPlayer player, PermissionNode<T> node, PermissionDynamicContext<?>... context)
```
源码 :67 — Queries a player's permission for a given node and contexts Warning: PermissionNodes must be registered using the PermissionGatherEvent.Nodes event before querying. @param player player for which you want to check permissions @param node the PermissionNode for which you want to query @param context…

```java
public static <T> T getOfflinePermission(UUID player, PermissionNode<T> node, PermissionDynamicContext<?>... context)
```
源码 :85 — See PermissionAPI#getPermission(ServerPlayer, @param player offline player for which you want to check permissions @param node the PermissionNode for which you want to query @param context optional array of PermissionDynamicContext, single entries will be ignored if they weren't registered to the no…

```java
public static void initializePermissionAPI()
```
源码 :96 — Helper method for internal use only! Initializes the active permission handler based on the users config.

