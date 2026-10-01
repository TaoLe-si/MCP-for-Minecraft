# IEventBus

> `net.minecraftforge.eventbus.api.IEventBus` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/eventbus/api/IEventBus.java` · `eventbus-6.2.33`（eventbus-6.2.33-sources.jar）

**本项目用法**：addListener 的接收方

**职责**（源码 javadoc）：EventBus API. Register for events and post events. Contains factory methods to construct an instance #create() and #create(IEventExceptionHandler)

## 公开成员（12 个）

```java
void register(Object target)
```
源码 :34 — Register an instance object or a Class, and add listeners for all SubscribeEvent annotated methods found there. Depending on what is passed as an argument, different listener creation behaviour is performed. Object Instance Scanned for non-static methods annotated with SubscribeEvent and creates lis…

```java
<T extends Event> void addListener(Consumer<T> consumer)
```
源码 :42 — Add a consumer listener with default EventPriority#NORMAL and not recieving cancelled events. @param consumer Callback to invoke when a matching event is received @param The Event subclass to listen for

```java
<T extends Event> void addListener(EventPriority priority, Consumer<T> consumer)
```
源码 :51 — Add a consumer listener with the specified EventPriority and not receiving cancelled events. @param priority EventPriority for this listener @param consumer Callback to invoke when a matching event is received @param The Event subclass to listen for

```java
<T extends Event> void addListener(EventPriority priority, boolean receiveCancelled, Consumer<T> consumer)
```
源码 :61 — Add a consumer listener with the specified EventPriority and potentially cancelled events. @param priority EventPriority for this listener @param receiveCancelled Indicate if this listener should receive events that have been Cancelable cancelled @param consumer Callback to invoke when a matching ev…

```java
<T extends Event> void addListener(EventPriority priority, boolean receiveCancelled, Class<T> eventType, Consumer<T> consumer)
```
源码 :75 — Add a consumer listener with the specified EventPriority and potentially cancelled events. Use this method when one of the other methods fails to determine the concrete Event subclass that is intended to be subscribed to. @param priority EventPriority for this listener @param receiveCancelled Indica…

```java
void unregister(Object object)
```
源码 :142 — Unregister the supplied listener from this EventBus. Removes all listeners from events. NOTE: Consumers can be stored in a variable if unregistration is required for the Consumer. @param object The object, Class or Consumer to unsubscribe.

```java
boolean post(Event event)
```
源码 :150 — Submit the event for dispatch to appropriate listeners @param event The event to dispatch to listeners @return true if the event was Cancelable cancelled

```java
boolean post(Event event, IEventBusInvokeDispatcher wrapper)
```
源码 :161 — Submit the event for dispatch to listeners. The invoke wrapper allows for wrap handling of the actual dispatch, to allow for monitoring of individual event dispatch @param event The event to dispatch to listeners @param wrapper A wrapper function to handle actual dispatch @return true if the event w…

```java
default <T extends Event> T fire(T event)
```
源码 :169 — Submit the event for dispatch to appropriate listeners and return the (possibly mutated) event @param event The event to dispatch to listeners @return The event object that was dispatched

```java
default <T extends Event> T fire(T event, IEventBusInvokeDispatcher wrapper)
```
源码 :174 —（无 javadoc）

```java
void shutdown()
```
源码 :184 — Shuts down this event bus. No future events will be fired on this event bus, so any call to #post(Event) will be a no op after this method has been invoked

```java
void start()
```
源码 :187 —（无 javadoc）

