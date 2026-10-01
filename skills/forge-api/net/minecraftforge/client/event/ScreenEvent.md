# ScreenEvent

> `net.minecraftforge.client.event.ScreenEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/ScreenEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired on different events/actions when a Screen is active and visible. See the various subclasses for listening to different events. These events are fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client. @see Init @see Render @see BackgroundRendered @see MouseInput @see KeyInput

## 公开成员（15 个）

```java
protected ScreenEvent(Screen screen)
```
源码 :46 —（无 javadoc）

```java
public Screen getScreen()
```
源码 :54 — the screen that caused this event

```java
public static abstract class Init extends ScreenEvent
```
源码 :70 — Fired when a screen is being initialized. See the two subclasses for listening before and after the initialization. Listeners added through this event may also be marked as renderable or narratable, if they inherit from net.minecraft.client.gui.components.Renderable and net.minecraft.client.gui.narr…

```java
public static abstract class Render extends ScreenEvent
```
源码 :159 — Fired when a screen is being drawn. See the two subclasses for listening before and after drawing. @see Render.Pre @see Render.Post

```java
public static class BackgroundRendered extends ScreenEvent
```
源码 :254 — Fired directly after the background of the screen is drawn. Can be used for drawing above the background but below the tooltips. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the Logic…

```java
public static class RenderInventoryMobEffects extends ScreenEvent
```
源码 :286 —（无 javadoc）

```java
public static abstract class MouseButtonPressed extends MouseInput
```
源码 :396 — Fired when a mouse button is pressed. See the two subclasses for listening before and after the normal handling. @see MouseButtonPressed.Pre @see MouseButtonPressed.Post

```java
public static abstract class MouseButtonReleased extends MouseInput
```
源码 :482 — Fired when a mouse button is released. See the two subclasses for listening before and after the normal handling. @see MouseButtonReleased.Pre @see MouseButtonReleased.Post

```java
public static abstract class MouseDragged extends MouseInput
```
源码 :568 — Fired when the mouse was dragged while a button is being held down. See the two subclasses for listening before and after the normal handling. @see MouseDragged.Pre @see MouseDragged.Post

```java
public static abstract class MouseScrolled extends MouseInput
```
源码 :657 — Fired when the mouse was dragged while a button is being held down. See the two subclasses for listening before and after the normal handling. @see MouseScrolled.Pre @see MouseScrolled.Post

```java
public static abstract class KeyPressed extends KeyInput
```
源码 :790 — Fired when a keyboard key is pressed. See the two subclasses for listening before and after the normal handling. @see KeyPressed.Pre @see KeyPressed.Post

```java
public static abstract class KeyReleased extends KeyInput
```
源码 :846 — Fired when a keyboard key is released. See the two subclasses for listening before and after the normal handling. @see KeyReleased.Pre @see KeyReleased.Post

```java
public static class CharacterTyped extends ScreenEvent
```
源码 :903 — Fired when a keyboard key corresponding to a character is typed. See the two subclasses for listening before and after the normal handling. @see CharacterTyped.Pre @see CharacterTyped.Post @see the online GLFW documentation

```java
public static class Opening extends ScreenEvent
```
源码 :993 —（无 javadoc）

```java
public static class Closing extends ScreenEvent
```
源码 :1045 — Fired before a Screen is closed. All screen layers on the screen are closed before this event is fired. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical cli…

