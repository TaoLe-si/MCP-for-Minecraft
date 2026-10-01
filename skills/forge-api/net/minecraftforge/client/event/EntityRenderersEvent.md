# EntityRenderersEvent

> `net.minecraftforge.client.event.EntityRenderersEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/EntityRenderersEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired for on different events/actions relating to EntityRenderer entity renderers. See the various subclasses for listening to different events. These events are fired on the FMLJavaModLoadingContext#getModEventBus() mod-specific event bus, only on the LogicalSide#CLIENT logical client. @see EntityRenderersEvent.RegisterLayerDefinitions @see EntityRenderersEvent.RegisterRenderers @see EntityRender…

## 公开成员（5 个）

```java
protected EntityRenderersEvent()
```
源码 :58 —（无 javadoc）

```java
public static class RegisterLayerDefinitions extends EntityRenderersEvent
```
源码 :70 — Fired for registering layer definitions at the appropriate time. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the FMLJavaModLoadingContext#getModEventBus() mod-specific event bus, only on the LogicalSide#CLIENT logical client.

```java
public static class RegisterRenderers extends EntityRenderersEvent
```
源码 :102 — Fired for registering entity and block entity renderers at the appropriate time. For registering entity renderer layers to existing entity renderers (whether vanilla or registered through this event), listen for the AddLayers event instead. This event is not Cancelable cancellable, and does not HasR…

```java
public static class AddLayers extends EntityRenderersEvent
```
源码 :141 — Fired for registering entity renderer layers at the appropriate time, after the entity and player renderers maps have been created. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the FMLJavaModLoadingContext#getModEventBus() mod-specific event…

```java
public static class CreateSkullModels extends EntityRenderersEvent
```
源码 :236 — Fired for registering additional net.minecraft.client.model.SkullModelBase skull models at the appropriate time. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the FMLJavaModLoadingContext#getModEventBus() mod-specific event bus, only on the Lo…

