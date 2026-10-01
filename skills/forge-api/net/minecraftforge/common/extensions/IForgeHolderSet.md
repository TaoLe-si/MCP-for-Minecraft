# IForgeHolderSet

> `net.minecraftforge.common.extensions.IForgeHolderSet` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeHolderSet.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（3 个）

```java
default public void addInvalidationListener(Runnable runnable)
```
源码 :24 — Adds a callback to run when this holderset's contents invalidate (i.e. because tags were rebound). The intended usage and use case is with composite holdersets that need to cache sets/list based on other holdersets, which may be mutable (because they are tag-based or themselves composite holdersets)…

```java
default public SerializationType serializationType()
```
源码 :32 — What format this holderset serializes to in json/nbt/etc

```java
public static enum SerializationType
```
源码 :52 — What format a holderset serializes to in json/nbt/etc

