# PermissionDynamicContext

> `net.minecraftforge.server.permission.nodes.PermissionDynamicContext` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/server/permission/nodes/PermissionDynamicContext.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Pair of a PermissionDynamicContextKey and a value of the corresponding type. Use PermissionDynamicContextKey#createContext(Object) )} for constructing. Note: While the DynamicContext behaves similar to BlockStates, it does not oblige to the same limitations. There is no string representation that you have to follow, nor is there a limit on how many unique value a DynamicContext may have @implNote…

## 公开成员（5 个）

```java
public PermissionDynamicContextKey<T> getDynamic()
```
源码 :30 —（无 javadoc）

```java
public T getValue()
```
源码 :35 —（无 javadoc）

```java
public String getSerializedValue()
```
源码 :40 —（无 javadoc）

```java
public boolean equals(Object o)
```
源码 :45 —（无 javadoc）

```java
public int hashCode()
```
源码 :53 —（无 javadoc）

