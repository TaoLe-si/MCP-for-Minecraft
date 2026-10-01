# GenericEvent

> `net.minecraftforge.eventbus.api.GenericEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/eventbus/api/GenericEvent.java` · `eventbus-6.2.33`（eventbus-6.2.33-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Implements IGenericEvent to provide filterable events based on generic type data. Subclasses should extend this if they wish to expose a secondary type based filter (the generic type). @param The type to filter this generic event for

## 公开成员（2 个）

```java
public GenericEvent() {} protected GenericEvent(Class<T> type)
```
源码 :18 —（无 javadoc）

```java
public Type getGenericType()
```
源码 :24 —（无 javadoc）

