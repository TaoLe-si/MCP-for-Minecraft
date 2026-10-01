# ModelEvent

> `net.minecraftforge.client.event.ModelEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/ModelEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Houses events related to models.

## 公开成员（5 个）

```java
protected ModelEvent()
```
源码 :31 —（无 javadoc）

```java
public static class ModifyBakingResult extends ModelEvent implements IModBusEvent
```
源码 :51 — Fired while the ModelManager is reloading models, after the model registry is set up, but before it's passed to the net.minecraft.client.renderer.block.BlockModelShaper for caching. This event is fired from a worker thread and it is therefore not safe to access anything outside the model registry an…

```java
public static class BakingCompleted extends ModelEvent implements IModBusEvent
```
源码 :91 — Fired when the ModelManager is notified of the resource manager reloading. Called after the model registry is set up and cached in the net.minecraft.client.renderer.block.BlockModelShaper. The model registry given by this event is unmodifiable. To modify the model registry, use ModelEvent.ModifyBaki…

```java
public static class RegisterAdditional extends ModelEvent implements IModBusEvent
```
源码 :139 — Fired when the net.minecraft.client.resources.model.ModelBakery is notified of the resource manager reloading. Allows developers to register models to be loaded, along with their dependencies. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the…

```java
public static class RegisterGeometryLoaders extends ModelEvent implements IModBusEvent
```
源码 :166 — Allows users to register their own IGeometryLoader for use in block/item models. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the FMLJavaModLoadingContext#getModEventBus() mod-specific event bus, only on the LogicalSide#CLIENT logical client.

