# RenderLivingEvent

> `net.minecraftforge.client.event.RenderLivingEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RenderLivingEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired when a LivingEntity is rendered. See the two subclasses to listen for before and after rendering. Despite this event's use of generic type parameters, this is not a net.minecraftforge.eventbus.api.GenericEvent, and should not be treated as such (such as using generic-specific listeners, which may cause a ClassCastException). @param the living entity that is being rendered @param the model fo…

## 公开成员（9 个）

```java
protected RenderLivingEvent(LivingEntity entity, LivingEntityRenderer<T, M> renderer, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight)
```
源码 :44 —（无 javadoc）

```java
public LivingEntity getEntity()
```
源码 :58 — @return the living entity being rendered

```java
public LivingEntityRenderer<T, M> getRenderer()
```
源码 :66 — @return the renderer for the living entity

```java
public float getPartialTick()
```
源码 :74 — the partial tick

```java
public PoseStack getPoseStack()
```
源码 :82 — the pose stack used for rendering

```java
public MultiBufferSource getMultiBufferSource()
```
源码 :90 — the source of rendering buffers

```java
public int getPackedLight()
```
源码 :100 — the amount of packed (sky and block) light for rendering @see LightTexture

```java
public static class Pre<T extends LivingEntity, M extends EntityModel<T>> extends RenderLivingEvent<T, M>
```
源码 :120 —（无 javadoc）

```java
public static class Post<T extends LivingEntity, M extends EntityModel<T>> extends RenderLivingEvent<T, M>
```
源码 :140 — Fired after an entity is rendered, if the corresponding RenderLivingEvent.Post is not cancelled. This event is not Cancelable cancelable, and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client. @pa…

