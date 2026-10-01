# ForgeLoadingOverlay

> `net.minecraftforge.client.loading.ForgeLoadingOverlay` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/loading/ForgeLoadingOverlay.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This is an implementation of the LoadingOverlay that calls back into the early window rendering, as part of the game loading cycle. We completely replace the #render(GuiGraphics, call from the parent with one of our own, that allows us to blend our early loading screen into the main window, in the same manner as the Mojang screen. It also allows us to see and tick appropriately as the later stages…

## 公开成员（3 个）

```java
public ForgeLoadingOverlay(final Minecraft mc, final ReloadInstance reloader, final Consumer<Optional<Throwable>> errorConsumer, DisplayWindow displayWindow)
```
源码 :54 —（无 javadoc）

```java
public static Supplier<LoadingOverlay> newInstance(Supplier<Minecraft> mc, Supplier<ReloadInstance> ri, Consumer<Optional<Throwable>> handler, DisplayWindow window)
```
源码 :64 —（无 javadoc）

```java
public void render(final @NotNull GuiGraphics graphics, final int mouseX, final int mouseY, final float partialTick)
```
源码 :69 —（无 javadoc）

