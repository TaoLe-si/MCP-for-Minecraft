# RenderLevelStageEvent

> `net.minecraftforge.client.event.RenderLevelStageEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RenderLevelStageEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fires at various times during LevelRenderer.renderLevel. Check #getStage to render during the appropriate time for your use case. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client.

## 公开成员（11 个）

```java
public RenderLevelStageEvent(Stage stage, LevelRenderer levelRenderer, PoseStack poseStack, Matrix4f projectionMatrix, int renderTick, float partialTick, Camera camera, Frustum frustum)
```
源码 :51 —（无 javadoc）

```java
public Stage getStage()
```
源码 :67 — the current {@linkplain Stage stage that is being rendered. Check this before doing rendering to ensure that rendering happens at the appropriate time.}

```java
public LevelRenderer getLevelRenderer()
```
源码 :75 — the level renderer

```java
public PoseStack getPoseStack()
```
源码 :83 — the pose stack used for rendering

```java
public Matrix4f getProjectionMatrix()
```
源码 :91 — the projection matrix

```java
public int getRenderTick()
```
源码 :99 — the current "ticks" value in the {@linkplain LevelRenderer level renderer}

```java
public float getPartialTick()
```
源码 :107 — the current partialTick value used for rendering

```java
public Camera getCamera()
```
源码 :115 — the camera

```java
public Frustum getFrustum()
```
源码 :123 — the frustum

```java
public static class RegisterStageEvent extends Event implements IModBusEvent
```
源码 :137 — Use to create a custom RenderLevelStageEvent.Stage stages. Fired after the LevelRenderer has been created. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the FMLJavaModLoadingContext#getModEventBus() mod-specific event bus, only on the LogicalS…

```java
public static class Stage
```
源码 :157 — A time during level rendering for you to render custom things into the world. @see RegisterStageEvent

