# EventBus

> `net.minecraftforge.eventbus.EventBus` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/eventbus/EventBus.java` · `eventbus-6.2.33`（eventbus-6.2.33-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（16 个）

```java
public EventBus(final BusBuilderImpl busBuilder)
```
源码 :65 —（无 javadoc）

```java
public void register(final Object target)
```
源码 :127 —（无 javadoc）

```java
public <T extends Event> void addListener(final Consumer<T> consumer)
```
源码 :189 —（无 javadoc）

```java
public <T extends Event> void addListener(final EventPriority priority, final Consumer<T> consumer)
```
源码 :194 —（无 javadoc）

```java
public <T extends Event> void addListener(final EventPriority priority, final boolean receiveCancelled, final Consumer<T> consumer)
```
源码 :199 —（无 javadoc）

```java
public <T extends Event> void addListener(final EventPriority priority, final boolean receiveCancelled, final Class<T> eventType, final Consumer<T> consumer)
```
源码 :205 —（无 javadoc）

```java
public <T extends GenericEvent<? extends F>, F> void addGenericListener(final Class<F> genericClassFilter, final Consumer<T> consumer)
```
源码 :211 —（无 javadoc）

```java
public <T extends GenericEvent<? extends F>, F> void addGenericListener(final Class<F> genericClassFilter, final EventPriority priority, final Consumer<T> consumer)
```
源码 :216 —（无 javadoc）

```java
public <T extends GenericEvent<? extends F>, F> void addGenericListener(final Class<F> genericClassFilter, final EventPriority priority, final boolean receiveCancelled, final Consumer<T> consumer)
```
源码 :221 —（无 javadoc）

```java
public <T extends GenericEvent<? extends F>, F> void addGenericListener(final Class<F> genericClassFilter, final EventPriority priority, final boolean receiveCancelled, final Class<T> eventType, final Consumer<T> consumer)
```
源码 :226 —（无 javadoc）

```java
public void unregister(Object object)
```
源码 :287 —（无 javadoc）

```java
public boolean post(Event event)
```
源码 :297 —（无 javadoc）

```java
public boolean post(Event event, IEventBusInvokeDispatcher wrapper)
```
源码 :302 —（无 javadoc）

```java
public void handleException(IEventBus bus, Event event, IEventListener[] listeners, int index, Throwable throwable)
```
源码 :322 —（无 javadoc）

```java
public void shutdown()
```
源码 :327 —（无 javadoc）

```java
public void start()
```
源码 :333 —（无 javadoc）

