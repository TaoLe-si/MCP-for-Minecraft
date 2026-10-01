# RenderTooltipEvent

> `net.minecraftforge.client.event.RenderTooltipEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RenderTooltipEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired during tooltip rendering. See the various subclasses for listening to specific events. @see RenderTooltipEvent.GatherComponents @see RenderTooltipEvent.Pre @see RenderTooltipEvent.Color

## 公开成员（16 个）

```java
protected final ItemStack itemStack
```
源码 :38 —（无 javadoc）

```java
protected final GuiGraphics graphics
```
源码 :39 —（无 javadoc）

```java
protected int x
```
源码 :40 —（无 javadoc）

```java
protected int y
```
源码 :41 —（无 javadoc）

```java
protected Font font
```
源码 :42 —（无 javadoc）

```java
protected final List<ClientTooltipComponent> components
```
源码 :43 —（无 javadoc）

```java
protected RenderTooltipEvent(@NotNull ItemStack itemStack, GuiGraphics graphics, int x, int y, @NotNull Font font, @NotNull List<ClientTooltipComponent> components)
```
源码 :46 —（无 javadoc）

```java
public ItemStack getItemStack()
```
源码 :61 —（无 javadoc）

```java
public GuiGraphics getGraphics()
```
源码 :69 — the graphics helper for the gui

```java
public List<ClientTooltipComponent> getComponents()
```
源码 :80 —（无 javadoc）

```java
public int getX()
```
源码 :88 — the X position of the tooltip box By default, this is the mouse X position.

```java
public int getY()
```
源码 :96 — the Y position of the tooltip box By default, this is the mouse Y position.

```java
public Font getFont()
```
源码 :105 —（无 javadoc）

```java
public static class GatherComponents extends Event
```
源码 :122 —（无 javadoc）

```java
public static class Pre extends RenderTooltipEvent
```
源码 :211 —（无 javadoc）

```java
public static class Color extends RenderTooltipEvent
```
源码 :290 — Fired when the colours for the tooltip background are determined. This can be used to modify the background color and the border's gradient colors. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus…

