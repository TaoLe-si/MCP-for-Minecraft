# ViewportEvent

> `net.minecraftforge.client.event.ViewportEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/ViewportEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired for hooking into the entity view rendering in GameRenderer. These can be used for customizing the visual features visible to the player. See the various subclasses for listening to different features. These events are fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client. @see RenderFog @see ComputeFogColor @see ComputeCameraAngles @see Com…

## 公开成员（8 个）

```java
public ViewportEvent(GameRenderer renderer, Camera camera, double partialTick)
```
源码 :40 —（无 javadoc）

```java
public GameRenderer getRenderer()
```
源码 :50 — the game renderer

```java
public Camera getCamera()
```
源码 :58 — the camera information

```java
public double getPartialTick()
```
源码 :66 — the partial tick

```java
public static class RenderFog extends ViewportEvent
```
源码 :81 —（无 javadoc）

```java
public static class ComputeFogColor extends ViewportEvent
```
源码 :201 — Fired for customizing the color of the fog visible to the player. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client.

```java
public static class ComputeCameraAngles extends ViewportEvent
```
源码 :280 — Fired to allow altering the angles of the player's camera. This can be used to alter the player's view for different effects, such as applying roll. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bu…

```java
public static class ComputeFov extends ViewportEvent
```
源码 :361 — Fired for altering the raw field of view (FOV). This is after the FOV settings are applied, and before modifiers such as the Nausea effect. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only o…

