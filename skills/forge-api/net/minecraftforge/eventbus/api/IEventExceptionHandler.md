# IEventExceptionHandler

> `net.minecraftforge.eventbus.api.IEventExceptionHandler` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/eventbus/api/IEventExceptionHandler.java` · `eventbus-6.2.33`（eventbus-6.2.33-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（1 个）

```java
void handleException(IEventBus bus, Event event, IEventListener[] listeners, int index, Throwable throwable)
```
源码 :18 — Fired when a EventListener throws an exception for the specified event on the event bus. After this function returns, the original Throwable will be propagated upwards. @param bus The bus the event is being fired on @param event The event that is being fired @param listeners All listeners that are l…

