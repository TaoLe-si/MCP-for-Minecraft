# ListenerList

> `net.minecraftforge.eventbus.ListenerList` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/eventbus/ListenerList.java` · `eventbus-6.2.33`（eventbus-6.2.33-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（9 个）

```java
public ListenerList()
```
源码 :25 —（无 javadoc）

```java
public ListenerList(@Nullable ListenerList parent)
```
源码 :29 —（无 javadoc）

```java
public static synchronized void clearBusID(int id)
```
源码 :72 —（无 javadoc）

```java
protected ListenerListInst getInstance(int id)
```
源码 :77 —（无 javadoc）

```java
public IEventListener[] getListeners(int id)
```
源码 :81 —（无 javadoc）

```java
public void register(int id, EventPriority priority, IEventListener listener)
```
源码 :85 —（无 javadoc）

```java
public void register(int id, EventBus eventBus, EventPriority priority, IEventListener listener)
```
源码 :89 —（无 javadoc）

```java
public void unregister(int id, IEventListener listener)
```
源码 :95 —（无 javadoc）

```java
public static synchronized void unregisterAll(int id, IEventListener listener)
```
源码 :99 —（无 javadoc）

