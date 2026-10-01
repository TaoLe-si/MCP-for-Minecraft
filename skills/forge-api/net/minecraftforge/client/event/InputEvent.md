# InputEvent

> `net.minecraftforge.client.event.InputEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/InputEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired when an input is detected from the user's input devices. See the various subclasses to listen for specific devices and inputs. @see InputEvent.MouseButton @see MouseScrollingEvent @see Key @see InteractionKeyMappingTriggered

## 公开成员（5 个）

```java
protected InputEvent()
```
源码 :30 —（无 javadoc）

```java
public static abstract class MouseButton extends InputEvent
```
源码 :44 — Fired when a mouse button is pressed/released. Sub-events get fired Pre and Post this happens. These events are fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client. @see the online GLFW documentation @see Pre @see Post

```java
public static class MouseScrollingEvent extends InputEvent
```
源码 :150 —（无 javadoc）

```java
public static class Key extends InputEvent
```
源码 :227 — Fired when a keyboard key input occurs, such as pressing, releasing, or repeating a key. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client.

```java
public static class InteractionKeyMappingTriggered extends InputEvent
```
源码 :316 —（无 javadoc）

