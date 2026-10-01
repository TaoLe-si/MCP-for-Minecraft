# Event

> `net.minecraftforge.eventbus.api.Event` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/eventbus/api/Event.java` · `eventbus-6.2.33`（eventbus-6.2.33-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Base Event class that all other events are derived from

## 公开成员（11 个）

```java
public @interface HasResult{} public enum Result
```
源码 :25 —（无 javadoc）

```java
public Event() { } /** * Determine if this function is cancelable at all. * @return If access to setCanceled should be allowed * * Note: * Events with the Cancelable annotation will have this method automatically added to return true. */ public boolean isCancelable()
```
源码 :41 —（无 javadoc）

```java
public boolean isCanceled()
```
源码 :58 — Determine if this event is canceled and should stop executing. @return The current canceled state

```java
public void setCanceled(boolean cancel)
```
源码 :75 — Sets the cancel state of this event. Note, not all events are cancelable, and any attempt to invoke this method on an event that is not cancelable (as determined by #isCancelable will result in an UnsupportedOperationException. The functionality of setting the canceled state is defined on a per-even…

```java
public void cancel()
```
源码 :92 — Equivalent to calling #setCanceled(boolean) with `true`.

```java
public boolean hasResult()
```
源码 :102 — Determines if this event expects a significant result value. Note: Events with the HasResult annotation will have this method automatically added to return true.

```java
public Result getResult()
```
源码 :109 — Returns the value set as the result of this event

```java
public void setResult(Result value)
```
源码 :121 — Sets the result value for this event, not all events can have a result set, and any attempt to set a result for a event that isn't expecting it will result in a IllegalArgumentException. The functionality of setting the result is defined on a per-event basis. @param value The new result

```java
public ListenerList getListenerList()
```
源码 :135 — Returns a ListenerList object that contains all listeners that are registered to this event. Note: for better efficiency, this gets overridden automatically using a Transformer, there is no need to override it yourself. @see EventSubclassTransformer @return Listener List

```java
public EventPriority getPhase()
```
源码 :140 —（无 javadoc）

```java
public void setPhase(@NotNull EventPriority value)
```
源码 :144 —（无 javadoc）

