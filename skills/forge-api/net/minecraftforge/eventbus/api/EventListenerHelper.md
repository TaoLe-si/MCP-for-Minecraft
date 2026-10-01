# EventListenerHelper

> `net.minecraftforge.eventbus.api.EventListenerHelper` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/eventbus/api/EventListenerHelper.java` · `eventbus-6.2.33`（eventbus-6.2.33-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（2 个）

```java
public static ListenerList getListenerList(Class<?> eventClass)
```
源码 :32 — Returns a ListenerList object that contains all listeners that are registered to this event class. This supports abstract classes that cannot be instantiated. Note: this is much slower than the instance method Event#getListenerList(). For performance when emitting events, always call that method ins…

```java
public static boolean isCancelable(Class<?> eventClass)
```
源码 :68 —（无 javadoc）

