# PermissionNode

> `net.minecraftforge.server.permission.nodes.PermissionNode` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/server/permission/nodes/PermissionNode.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Represents the basic unit at the heart of the permission system. A permission indicates the ability for an actor to perform an action, in its most general sense. In the permission system, all permissions are encoded as instances of this class, optionally integrated by a PermissionDynamicContext. A node is uniquely identified by its `nodeName`, which is a dot-separated string providing meaning to t…

## 公开成员（12 个）

```java
public PermissionNode(ResourceLocation nodeName, PermissionType<T> type, PermissionResolver<T> defaultResolver, PermissionDynamicContextKey... dynamics)
```
源码 :61 — Calls PermissionNode#PermissionNode(String, with "namespace.path" as the first parameter

```java
public PermissionNode(String modID, String nodeName, PermissionType<T> type, PermissionResolver<T> defaultResolver, PermissionDynamicContextKey... dynamics)
```
源码 :70 — Calls PermissionNode#PermissionNode(String, with "modid.nodename" as the first parameter

```java
public PermissionNode setInformation(@NotNull Component readableName, @NotNull Component description)
```
源码 :104 — Allows you to set a human-readable name and description for your Permission. Note: Even though not used by Default, PermissionHandlers may display this information in game, or provide it to the user by other means. You may use net.minecraft.network.chat.Component#translatable(String), but you'll nee…

```java
public String getNodeName()
```
源码 :115 —（无 javadoc）

```java
public PermissionType<T> getType()
```
源码 :120 —（无 javadoc）

```java
public PermissionDynamicContextKey<?>[] getDynamics()
```
源码 :125 —（无 javadoc）

```java
public PermissionResolver<T> getDefaultResolver()
```
源码 :130 —（无 javadoc）

```java
public Component getReadableName()
```
源码 :136 —（无 javadoc）

```java
public Component getDescription()
```
源码 :142 —（无 javadoc）

```java
public interface PermissionResolver<T>
```
源码 :153 —（无 javadoc）

```java
public boolean equals(Object o)
```
源码 :166 —（无 javadoc）

```java
public int hashCode()
```
源码 :174 —（无 javadoc）

