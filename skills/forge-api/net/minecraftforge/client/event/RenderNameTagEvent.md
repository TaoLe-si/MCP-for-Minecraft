# RenderNameTagEvent

> `net.minecraftforge.client.event.RenderNameTagEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RenderNameTagEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired before an entity renderer renders the nameplate of an entity. This event is not Cancelable cancellable, and HasResult has a result. Result#ALLOW - the nameplate will be forcibly rendered. Result#DEFAULT - the vanilla logic will be used. Result#DENY - the nameplate will not be rendered. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT lo…

## 公开成员（9 个）

```java
public RenderNameTagEvent(Entity entity, Component content, EntityRenderer<?> entityRenderer, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, float partialTick)
```
源码 :47 —（无 javadoc）

```java
public void setContent(Component contents)
```
源码 :64 — Sets the new text on the nameplate. @param contents the new text

```java
public Component getContent()
```
源码 :72 — the text on the nameplate that will be rendered, if the event is not Result#DENY

```java
public Component getOriginalContent()
```
源码 :80 — the original text on the nameplate

```java
public EntityRenderer<?> getEntityRenderer()
```
源码 :88 — the entity renderer rendering the nameplate

```java
public PoseStack getPoseStack()
```
源码 :96 — the pose stack used for rendering

```java
public MultiBufferSource getMultiBufferSource()
```
源码 :104 — the source of rendering buffers

```java
public int getPackedLight()
```
源码 :114 — the amount of packed (sky and block) light for rendering @see net.minecraft.client.renderer.LightTexture

```java
public float getPartialTick()
```
源码 :122 — the partial tick

