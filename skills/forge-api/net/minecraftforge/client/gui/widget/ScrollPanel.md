# ScrollPanel

> `net.minecraftforge.client.gui.widget.ScrollPanel` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/gui/widget/ScrollPanel.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Abstract scroll panel class.

## 公开成员（28 个）

```java
protected final int width
```
源码 :31 —（无 javadoc）

```java
protected final int height
```
源码 :32 —（无 javadoc）

```java
protected final int top
```
源码 :33 —（无 javadoc）

```java
protected final int bottom
```
源码 :34 —（无 javadoc）

```java
protected final int right
```
源码 :35 —（无 javadoc）

```java
protected final int left
```
源码 :36 —（无 javadoc）

```java
protected float scrollDistance
```
源码 :38 —（无 javadoc）

```java
protected boolean captureMouse = true
```
源码 :39 —（无 javadoc）

```java
protected final int border
```
源码 :40 —（无 javadoc）

```java
public ScrollPanel(Minecraft client, int width, int height, int top, int left)
```
源码 :57 — @param client the minecraft instance this ScrollPanel should use @param width the width @param height the height @param top the offset from the top (y coord) @param left the offset from the left (x coord)

```java
public ScrollPanel(Minecraft client, int width, int height, int top, int left, int border)
```
源码 :70 — @param client the minecraft instance this ScrollPanel should use @param width the width @param height the height @param top the offset from the top (y coord) @param left the offset from the left (x coord) @param border the size of the border

```java
public ScrollPanel(Minecraft client, int width, int height, int top, int left, int border, int barWidth)
```
源码 :84 — @param client the minecraft instance this ScrollPanel should use @param width the width @param height the height @param top the offset from the top (y coord) @param left the offset from the left (x coord) @param border the size of the border @param barWidth the width of the scroll bar

```java
public ScrollPanel(Minecraft client, int width, int height, int top, int left, int border, int barWidth, int bgColor)
```
源码 :99 — @param client the minecraft instance this ScrollPanel should use @param width the width @param height the height @param top the offset from the top (y coord) @param left the offset from the left (x coord) @param border the size of the border @param barWidth the width of the scroll bar @param bgColor…

```java
public ScrollPanel(Minecraft client, int width, int height, int top, int left, int border, int barWidth, int bgColorFrom, int bgColorTo)
```
源码 :115 — @param client the minecraft instance this ScrollPanel should use @param width the width @param height the height @param top the offset from the top (y coord) @param left the offset from the left (x coord) @param border the size of the border @param barWidth the width of the scroll bar @param bgColor…

```java
public ScrollPanel(Minecraft client, int width, int height, int top, int left, int border, int barWidth, int bgColorFrom, int bgColorTo, int barBgColor, int barColor, int barBorderColor)
```
源码 :136 — Base constructor @param client the minecraft instance this ScrollPanel should use @param width the width @param height the height @param top the offset from the top (y coord) @param left the offset from the left (x coord) @param border the size of the border @param barWidth the width of the scroll b…

```java
protected abstract int getContentHeight()
```
源码 :155 —（无 javadoc）

```java
protected void drawBackground(GuiGraphics guiGraphics, Tesselator tess, float partialTick)
```
源码 :160 — Draws the background of the scroll panel. This runs AFTER Scissors are enabled.

```java
protected abstract void drawPanel(GuiGraphics guiGraphics, int entryRight, int relativeY, Tesselator tess, int mouseX, int mouseY)
```
源码 :186 — Draw anything special on the screen. Scissor (RenderSystem.enableScissor) is enabled for anything that is rendered outside the view box. Do not mess with Scissor unless you support this.

```java
protected boolean clickPanel(double mouseX, double mouseY, int button) { return false; } private int getMaxScroll()
```
源码 :188 —（无 javadoc）

```java
public boolean mouseScrolled(double mouseX, double mouseY, double scroll)
```
源码 :216 —（无 javadoc）

```java
protected int getScrollAmount()
```
源码 :227 —（无 javadoc）

```java
public boolean isMouseOver(double mouseX, double mouseY)
```
源码 :233 —（无 javadoc）

```java
public boolean mouseClicked(double mouseX, double mouseY, int button)
```
源码 :240 —（无 javadoc）

```java
public boolean mouseReleased(double mouseX, double mouseY, int button)
```
源码 :259 —（无 javadoc）

```java
public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY)
```
源码 :281 —（无 javadoc）

```java
public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick)
```
源码 :295 —（无 javadoc）

```java
protected void drawGradientRect(GuiGraphics guiGraphics, int left, int top, int right, int bottom, int color1, int color2)
```
源码 :364 —（无 javadoc）

```java
public List<? extends GuiEventListener> children()
```
源码 :370 —（无 javadoc）

