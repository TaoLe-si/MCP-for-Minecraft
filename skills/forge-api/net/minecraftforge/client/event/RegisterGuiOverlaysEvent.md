# RegisterGuiOverlaysEvent

> `net.minecraftforge.client.event.RegisterGuiOverlaysEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RegisterGuiOverlaysEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Allows users to register custom IGuiOverlay. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the FMLJavaModLoadingContext#getModEventBus() mod-specific event bus, only on the LogicalSide#CLIENT logical client.

## 公开成员（5 个）

```java
public RegisterGuiOverlaysEvent(Map<ResourceLocation, IGuiOverlay> overlays, List<ResourceLocation> orderedOverlays)
```
源码 :39 —（无 javadoc）

```java
public void registerBelowAll(@NotNull String id, @NotNull IGuiOverlay overlay)
```
源码 :51 — Registers an overlay that renders below all others. @param id A unique resource id for this overlay @param overlay The overlay

```java
public void registerBelow(@NotNull ResourceLocation other, @NotNull String id, @NotNull IGuiOverlay overlay)
```
源码 :64 — Registers an overlay that renders below another. @param other The id of the overlay to render below. This must be an overlay you have already registered or a VanillaGuiOverlay. Do not use other mods' overlays. @param id A unique resource id for this overlay @param overlay The overlay

```java
public void registerAbove(@NotNull ResourceLocation other, @NotNull String id, @NotNull IGuiOverlay overlay)
```
源码 :77 — Registers an overlay that renders above another. @param other The id of the overlay to render above. This must be an overlay you have already registered or a VanillaGuiOverlay. Do not use other mods' overlays. @param id A unique resource id for this overlay @param overlay The overlay

```java
public void registerAboveAll(@NotNull String id, @NotNull IGuiOverlay overlay)
```
源码 :88 — Registers an overlay that renders above all others. @param id A unique resource id for this overlay @param overlay The overlay

