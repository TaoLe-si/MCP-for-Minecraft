# RenderHighlightEvent

> `net.minecraftforge.client.event.RenderHighlightEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RenderHighlightEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired before a selection highlight is rendered. See the two subclasses to listen for blocks or entities. @see Block @see Entity

## 公开成员（9 个）

```java
protected RenderHighlightEvent(LevelRenderer levelRenderer, Camera camera, HitResult target, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource)
```
源码 :39 —（无 javadoc）

```java
public LevelRenderer getLevelRenderer()
```
源码 :52 — the level renderer

```java
public Camera getCamera()
```
源码 :60 — the camera information

```java
public HitResult getTarget()
```
源码 :68 — the hit result which triggered the selection highlight

```java
public float getPartialTick()
```
源码 :76 — the partial tick

```java
public PoseStack getPoseStack()
```
源码 :84 — the pose stack used for rendering

```java
public MultiBufferSource getMultiBufferSource()
```
源码 :92 — the source of rendering buffers

```java
public static class Block extends RenderHighlightEvent
```
源码 :107 —（无 javadoc）

```java
public static class Entity extends RenderHighlightEvent
```
源码 :133 — Fired before an entity's selection highlight is rendered. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client.

