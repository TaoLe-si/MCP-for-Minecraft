# RenderGuiEvent

> `net.minecraftforge.client.event.RenderGuiEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RenderGuiEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired when the HUD is rendered to the screen. See the two subclasses for listening to the two possible phases. @see Pre @see Post

## 公开成员（6 个）

```java
protected RenderGuiEvent(Window window, GuiGraphics guiGraphics, float partialTick)
```
源码 :30 —（无 javadoc）

```java
public Window getWindow()
```
源码 :37 —（无 javadoc）

```java
public GuiGraphics getGuiGraphics()
```
源码 :42 —（无 javadoc）

```java
public float getPartialTick()
```
源码 :47 —（无 javadoc）

```java
public static class Pre extends RenderGuiEvent
```
源码 :65 —（无 javadoc）

```java
public static class Post extends RenderGuiEvent
```
源码 :82 — Fired after the HUD is rendered to the screen, if the corresponding Pre is not cancelled. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client.

