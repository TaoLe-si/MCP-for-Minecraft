# DefaultPermissionHandler

> `net.minecraftforge.server.permission.handler.DefaultPermissionHandler` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/server/permission/handler/DefaultPermissionHandler.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（6 个）

```java
public static final ResourceLocation IDENTIFIER = new ResourceLocation("forge", "default_handler")
```
源码 :17 —（无 javadoc）

```java
public DefaultPermissionHandler(Collection<PermissionNode<?>> permissions)
```
源码 :22 —（无 javadoc）

```java
public ResourceLocation getIdentifier()
```
源码 :28 —（无 javadoc）

```java
public Set<PermissionNode<?>> getRegisteredNodes()
```
源码 :34 —（无 javadoc）

```java
public <T> T getPermission(ServerPlayer player, PermissionNode<T> node, PermissionDynamicContext<?>... context)
```
源码 :40 —（无 javadoc）

```java
public <T> T getOfflinePermission(UUID player, PermissionNode<T> node, PermissionDynamicContext<?>... context)
```
源码 :46 —（无 javadoc）

