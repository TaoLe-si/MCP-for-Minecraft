# RegisterNamedRenderTypesEvent

> `net.minecraftforge.client.event.RegisterNamedRenderTypesEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RegisterNamedRenderTypesEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Allows users to register custom named RenderType. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the FMLJavaModLoadingContext#getModEventBus() mod-specific event bus, only on the LogicalSide#CLIENT logical client.

## 公开成员（3 个）

```java
public RegisterNamedRenderTypesEvent(Map<ResourceLocation, RenderTypeGroup> renderTypes)
```
源码 :36 —（无 javadoc）

```java
public void register(String name, RenderType blockRenderType, RenderType entityRenderType)
```
源码 :48 — Registers a named RenderTypeGroup. @param name The name @param blockRenderType One of the values returned by RenderType#chunkBufferLayers() @param entityRenderType A RenderType using DefaultVertexFormat#NEW_ENTITY

```java
public void register(String name, RenderType blockRenderType, RenderType entityRenderType, RenderType fabulousEntityRenderType)
```
源码 :62 — Registers a named RenderTypeGroup. @param name The name @param blockRenderType One of the values returned by RenderType#chunkBufferLayers() @param entityRenderType A RenderType using DefaultVertexFormat#NEW_ENTITY @param fabulousEntityRenderType A RenderType using DefaultVertexFormat#NEW_ENTITY for…

