# RenderPlayerEvent

> `net.minecraftforge.client.event.RenderPlayerEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RenderPlayerEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired when a player is being rendered. See the two subclasses for listening for before and after rendering. @see RenderPlayerEvent.Pre @see RenderPlayerEvent.Post @see PlayerRenderer

## 公开成员（8 个）

```java
protected RenderPlayerEvent(Player player, PlayerRenderer renderer, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight)
```
源码 :36 —（无 javadoc）

```java
public PlayerRenderer getRenderer()
```
源码 :49 — the player entity renderer

```java
public float getPartialTick()
```
源码 :57 — the partial tick

```java
public PoseStack getPoseStack()
```
源码 :65 — the pose stack used for rendering

```java
public MultiBufferSource getMultiBufferSource()
```
源码 :73 — the source of rendering buffers

```java
public int getPackedLight()
```
源码 :83 — the amount of packed (sky and block) light for rendering @see LightTexture

```java
public static class Pre extends RenderPlayerEvent
```
源码 :100 —（无 javadoc）

```java
public static class Post extends RenderPlayerEvent
```
源码 :117 — Fired after the player is rendered, if the corresponding RenderPlayerEvent.Pre is not cancelled. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client.

