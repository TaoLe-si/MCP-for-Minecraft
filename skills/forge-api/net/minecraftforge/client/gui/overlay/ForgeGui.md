# ForgeGui

> `net.minecraftforge.client.gui.overlay.ForgeGui` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/gui/overlay/ForgeGui.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Forge wrapper around Gui to be able to render IGuiOverlay.

## 公开成员（26 个）

```java
public static double rayTraceDistance = 20.0D
```
源码 :58 —（无 javadoc）

```java
public int leftHeight = 39
```
源码 :60 —（无 javadoc）

```java
public int rightHeight = 39
```
源码 :61 —（无 javadoc）

```java
public ForgeGui(Minecraft mc)
```
源码 :67 —（无 javadoc）

```java
public Minecraft getMinecraft()
```
源码 :73 —（无 javadoc）

```java
public void setupOverlayRenderState(boolean blend, boolean depthTest)
```
源码 :78 —（无 javadoc）

```java
public void render(GuiGraphics guiGraphics, float partialTick)
```
源码 :104 —（无 javadoc）

```java
public boolean shouldDrawSurvivalElements()
```
源码 :139 —（无 javadoc）

```java
protected void renderSubtitles(GuiGraphics guiGraphics)
```
源码 :144 —（无 javadoc）

```java
protected void renderBossHealth(GuiGraphics guiGraphics)
```
源码 :149 —（无 javadoc）

```java
protected void renderArmor(GuiGraphics guiGraphics, int width, int height)
```
源码 :200 —（无 javadoc）

```java
protected void renderPortalOverlay(GuiGraphics guiGraphics, float alpha)
```
源码 :232 —（无 javadoc）

```java
protected void renderAir(int width, int height, GuiGraphics guiGraphics)
```
源码 :240 —（无 javadoc）

```java
public void renderHealth(int width, int height, GuiGraphics guiGraphics)
```
源码 :265 —（无 javadoc）

```java
public void renderFood(int width, int height, GuiGraphics guiGraphics)
```
源码 :321 —（无 javadoc）

```java
protected void renderSleepFade(int width, int height, GuiGraphics guiGraphics)
```
源码 :366 —（无 javadoc）

```java
protected void renderExperience(int x, GuiGraphics guiGraphics)
```
源码 :385 —（无 javadoc）

```java
public void renderJumpMeter(PlayerRideableJumping playerRideableJumping, GuiGraphics guiGraphics, int x)
```
源码 :399 —（无 javadoc）

```java
protected void renderHUDText(int width, int height, GuiGraphics guiGraphics)
```
源码 :411 —（无 javadoc）

```java
protected void renderFPSGraph(GuiGraphics guiGraphics)
```
源码 :469 —（无 javadoc）

```java
public void clearCache()
```
源码 :478 —（无 javadoc）

```java
protected void renderRecordOverlay(int width, int height, float partialTick, GuiGraphics guiGraphics)
```
源码 :484 —（无 javadoc）

```java
protected void renderTitle(int width, int height, float partialTick, GuiGraphics guiGraphics)
```
源码 :515 —（无 javadoc）

```java
protected void renderChat(int width, int height, GuiGraphics guiGraphics)
```
源码 :558 —（无 javadoc）

```java
protected void renderPlayerList(int width, int height, GuiGraphics guiGraphics)
```
源码 :577 —（无 javadoc）

```java
protected void renderHealthMount(int width, int height, GuiGraphics guiGraphics)
```
源码 :594 —（无 javadoc）

