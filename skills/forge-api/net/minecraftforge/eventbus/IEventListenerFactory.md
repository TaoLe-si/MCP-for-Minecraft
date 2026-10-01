# IEventListenerFactory

> `net.minecraftforge.eventbus.IEventListenerFactory` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/eventbus/IEventListenerFactory.java` · `eventbus-6.2.33`（eventbus-6.2.33-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（2 个）

```java
IEventListener create(Method callback, Object target) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException
```
源码 :13 —（无 javadoc）

```java
default String getUniqueName(Method callback)
```
源码 :15 —（无 javadoc）

