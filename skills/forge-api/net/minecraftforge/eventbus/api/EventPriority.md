# EventPriority

> `net.minecraftforge.eventbus.api.EventPriority` · enum · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/eventbus/api/EventPriority.java` · `eventbus-6.2.33`（eventbus-6.2.33-sources.jar）

**本项目用法**：事件优先级（本项目都用默认）

**职责**（源码 javadoc）：Different priorities for Event listeners. #NORMAL is the default level for a listener registered without a priority. @see SubscribeEvent#priority()

## 公开成员（2 个）

```java
enum 常量 HIGHEST, HIGH, NORMAL, LOW, LOWEST, /** * When in this state, {@link Event#setCanceled(boolean)} will throw an exception if called with any value. */ MONITOR
```
源码 :22 — Priority of event listeners, listeners will be sorted with respect to this priority level. Note: Due to using a ArrayList in the ListenerList, these need to stay in a contiguous index starting at 0. {Default ordinal}

```java
public void invoke(Event event)
```
源码 :33 —（无 javadoc）

