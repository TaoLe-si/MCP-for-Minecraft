# RenderItemInFrameEvent

> `net.minecraftforge.client.event.RenderItemInFrameEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RenderItemInFrameEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired before an item stack is rendered in an item frame. This can be used to prevent normal rendering or add custom rendering. This event is Cancelable cancellable, and does not HasResult have a result. If the event is cancelled, then the item stack will not be rendered This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client. @see Ite…

## 公开成员（7 个）

```java
public RenderItemInFrameEvent(ItemFrame itemFrame, ItemFrameRenderer<?> renderItemFrame, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight)
```
源码 :43 —（无 javadoc）

```java
public ItemStack getItemStack()
```
源码 :57 — the item stack being rendered

```java
public ItemFrame getItemFrameEntity()
```
源码 :65 — the item frame entity

```java
public ItemFrameRenderer<?> getRenderer()
```
源码 :73 — the renderer for the item frame entity

```java
public PoseStack getPoseStack()
```
源码 :81 — the pose stack used for rendering

```java
public MultiBufferSource getMultiBufferSource()
```
源码 :89 — the source of rendering buffers

```java
public int getPackedLight()
```
源码 :99 — the amount of packed (sky and block) light for rendering @see LightTexture

