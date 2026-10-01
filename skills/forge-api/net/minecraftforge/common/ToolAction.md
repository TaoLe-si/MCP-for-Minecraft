# ToolAction

> `net.minecraftforge.common.ToolAction` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/ToolAction.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（4 个）

```java
public static Collection<ToolAction> getActions()
```
源码 :23 — Returns all registered actions. This collection can be kept around, and will update itself in response to changes to the map. See ConcurrentHashMap#values() for details.

```java
public static ToolAction get(String name)
```
源码 :31 — Gets or creates a new ToolAction for the given name.

```java
public String name()
```
源码 :39 — Returns the name of this tool action

```java
public String toString()
```
源码 :45 —（无 javadoc）

