# RenderGuiOverlayEvent

> `net.minecraftforge.client.event.RenderGuiOverlayEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RenderGuiOverlayEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired when an overlay is rendered to the screen. See the two subclasses for listening to the two possible phases. An overlay that is not normally active cannot be forced to render. In such cases, this event will not fire. @see Pre @see Post

## 公开成员（7 个）

```java
protected RenderGuiOverlayEvent(Window window, GuiGraphics guiGraphics, float partialTick, NamedGuiOverlay overlay)
```
源码 :34 —（无 javadoc）

```java
public Window getWindow()
```
源码 :42 —（无 javadoc）

```java
public GuiGraphics getGuiGraphics()
```
源码 :47 —（无 javadoc）

```java
public float getPartialTick()
```
源码 :52 —（无 javadoc）

```java
public NamedGuiOverlay getOverlay()
```
源码 :57 —（无 javadoc）

```java
public static class Pre extends RenderGuiOverlayEvent
```
源码 :75 —（无 javadoc）

```java
public static class Post extends RenderGuiOverlayEvent
```
源码 :92 — Fired after an GUI overlay is rendered to the screen, if the corresponding Pre is not cancelled. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client.

