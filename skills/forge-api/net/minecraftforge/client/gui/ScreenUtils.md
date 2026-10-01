# ScreenUtils

> `net.minecraftforge.client.gui.ScreenUtils` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/gui/ScreenUtils.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This class provides several methods and constants used by the Config GUI classes. @author bspkrs @deprecated Use extension methods in net.minecraftforge.client.extensions.IForgeGuiGraphics instead

## 公开成员（17 个）

```java
public static final int DEFAULT_BACKGROUND_COLOR = 0xF0100010
```
源码 :28 —（无 javadoc）

```java
public static final int DEFAULT_BORDER_COLOR_START = 0x505000FF
```
源码 :29 —（无 javadoc）

```java
public static final int DEFAULT_BORDER_COLOR_END = (DEFAULT_BORDER_COLOR_START & 0xFEFEFE) >> 1 …
```
源码 :30 —（无 javadoc）

```java
public static final String UNDO_CHAR = "\u21B6"
```
源码 :31 —（无 javadoc）

```java
public static final String RESET_CHAR = "\u2604"
```
源码 :32 —（无 javadoc）

```java
public static final String VALID = "\u2714"
```
源码 :33 —（无 javadoc）

```java
public static final String INVALID = "\u2715"
```
源码 :34 —（无 javadoc）

```java
public static int[] TEXT_COLOR_CODES = new int[] { 0, 170, 43520, 43690, 11141120, 1…
```
源码 :36 —（无 javadoc）

```java
public static int getColorFromFormattingCharacter(char c, boolean isLighter)
```
源码 :39 —（无 javadoc）

```java
public static void blitWithBorder(GuiGraphics guiGraphics, int x, int y, int u, int v, int width, int height, int textureWidth, int textureHeight, int borderSize, float zLevel)
```
源码 :61 — Draws a textured box of any size (smallest size is borderSize * 2 square) based on a fixed size textured box with continuous borders and filler. It is assumed that the desired texture ResourceLocation object has been bound using Minecraft.getMinecraft().getTextureManager().bindTexture(resourceLocati…

```java
public static void blitWithBorder(GuiGraphics guiGraphics, ResourceLocation res, int x, int y, int u, int v, int width, int height, int textureWidth, int textureHeight, int borderSize, float zLevel)
```
源码 :85 — Draws a textured box of any size (smallest size is borderSize * 2 square) based on a fixed size textured box with continuous borders and filler. The provided ResourceLocation object will be bound using Minecraft.getMinecraft().getTextureManager().bindTexture(resourceLocation). @param guiGraphics the…

```java
public static void blitWithBorder(GuiGraphics guiGraphics, ResourceLocation res, int x, int y, int u, int v, int width, int height, int textureWidth, int textureHeight, int topBorder, int bottomBorder, int leftBorder, int rightBorder, float zLevel)
```
源码 :112 — Draws a textured box of any size (smallest size is borderSize * 2 square) based on a fixed size textured box with continuous borders and filler. The provided ResourceLocation object will be bound using Minecraft.getMinecraft().getTextureManager().bindTexture(resourceLocation). @param guiGraphics the…

```java
public static void blitWithBorder(GuiGraphics guiGraphics, int x, int y, int u, int v, int width, int height, int textureWidth, int textureHeight, int topBorder, int bottomBorder, int leftBorder, int rightBorder, float zLevel)
```
源码 :140 — Draws a textured box of any size (smallest size is borderSize * 2 square) based on a fixed size textured box with continuous borders and filler. It is assumed that the desired texture ResourceLocation object has been bound using Minecraft.getMinecraft().getTextureManager().bindTexture(resourceLocati…

```java
public static void drawTexturedModalRect(GuiGraphics guiGraphics, int x, int y, int u, int v, int width, int height, float zLevel)
```
源码 :192 —（无 javadoc）

```java
public static void drawGradientRect(Matrix4f mat, int zLevel, int left, int top, int right, int bottom, int startColor, int endColor)
```
源码 :212 —（无 javadoc）

```java
public static void blitInscribed(GuiGraphics guiGraphics, ResourceLocation texture, int x, int y, int boundsWidth, int boundsHeight, int rectWidth, int rectHeight)
```
源码 :240 —（无 javadoc）

```java
public static void blitInscribed(GuiGraphics guiGraphics, ResourceLocation texture, int x, int y, int boundsWidth, int boundsHeight, int rectWidth, int rectHeight, boolean centerX, boolean centerY)
```
源码 :245 —（无 javadoc）

