# PermissionDynamicContextKey

> `net.minecraftforge.server.permission.nodes.PermissionDynamicContextKey` · record · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/server/permission/nodes/PermissionDynamicContextKey.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Represents a key that can be used to build a PermissionDynamicContext. Keys, along with their associated values, can be used to provide additional context for a permission handler in determining whether to grant permission for an actor and a specific node. As an example usage, a dimension context key could be used inside a building permission check to ensure that the actor can build given those co…

## 公开成员（1 个）

```java
public PermissionDynamicContext<T> createContext(T value)
```
源码 :21 —（无 javadoc）

