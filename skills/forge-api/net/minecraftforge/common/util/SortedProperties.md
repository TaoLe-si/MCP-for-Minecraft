# SortedProperties

> `net.minecraftforge.common.util.SortedProperties` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/util/SortedProperties.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：An Implementation of Properties that is sorted when iterating. Made because i got tired of seeing config files written in random orders. This is implemented very basically, and thus is not a speedy system. This is not recommended for used in high traffic areas, and is mainly intended for writing to disc.

## 公开成员（4 个）

```java
public Set<Map.Entry<Object, Object>> entrySet()
```
源码 :29 —（无 javadoc）

```java
public Set<Object> keySet()
```
源码 :37 —（无 javadoc）

```java
public synchronized Enumeration<Object> keys()
```
源码 :43 —（无 javadoc）

```java
public static void store(Properties props, Writer stream, String comment) throws IOException
```
源码 :48 —（无 javadoc）

