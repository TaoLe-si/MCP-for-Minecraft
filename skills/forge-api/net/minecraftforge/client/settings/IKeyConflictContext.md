# IKeyConflictContext

> `net.minecraftforge.client.settings.IKeyConflictContext` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/settings/IKeyConflictContext.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Defines the context that a KeyMapping is used. Key conflicts occur when a KeyMapping has the same IKeyConflictContext and has conflicting modifiers and keyCodes.

## 公开成员（2 个）

```java
boolean isActive()
```
源码 :18 — @return true if conditions are met to activate KeyMappings with this context

```java
boolean conflicts(IKeyConflictContext other)
```
源码 :24 — @return true if the other context can have KeyMapping conflicts with this one. This will be called on both contexts to check for conflicts.

