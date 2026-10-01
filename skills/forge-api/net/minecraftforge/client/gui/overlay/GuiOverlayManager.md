# GuiOverlayManager

> `net.minecraftforge.client.gui.overlay.GuiOverlayManager` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/gui/overlay/GuiOverlayManager.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Manager for IGuiOverlay HUD overlays. Provides a lookup by ID, as well as all registered IGuiOverlay.

## 公开成员（3 个）

```java
public static ImmutableList<NamedGuiOverlay> getOverlays()
```
源码 :33 — Retrieves an ordered list of all registered overlays.

```java
public static NamedGuiOverlay findOverlay(ResourceLocation id)
```
源码 :43 —（无 javadoc）

```java
public static void init()
```
源码 :49 —（无 javadoc）

