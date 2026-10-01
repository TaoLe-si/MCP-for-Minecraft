# CustomizeGuiOverlayEvent

> `net.minecraftforge.client.event.CustomizeGuiOverlayEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/CustomizeGuiOverlayEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目用法**：BossEventProgress：抄首领血条（bossBars op 的数据源）

**职责**（源码 javadoc）：Fired when an overlay is about to be rendered to the screen to allow the user to modify it. @see BossEventProgress @see DebugText @see Chat

## 坑

- `BossEventProgress` 是**渲染路径**上的事件，抛异常同样是崩游戏；也正因为它是渲染时才发，所以『首领条存在』的判据天然是『屏幕上真的画过』。

## 公开成员（7 个）

```java
protected CustomizeGuiOverlayEvent(Window window, GuiGraphics guiGraphics, float partialTick)
```
源码 :33 —（无 javadoc）

```java
public Window getWindow()
```
源码 :40 —（无 javadoc）

```java
public GuiGraphics getGuiGraphics()
```
源码 :45 —（无 javadoc）

```java
public float getPartialTick()
```
源码 :50 —（无 javadoc）

```java
public static class BossEventProgress extends CustomizeGuiOverlayEvent
```
源码 :65 —（无 javadoc）

```java
public static class DebugText extends CustomizeGuiOverlayEvent
```
源码 :134 — Fired before textual information is rendered to the debug screen. This can be used to add or remove text information. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIE…

```java
public static class Chat extends CustomizeGuiOverlayEvent
```
源码 :172 — Fired before the chat messages overlay is rendered to the screen. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client.

