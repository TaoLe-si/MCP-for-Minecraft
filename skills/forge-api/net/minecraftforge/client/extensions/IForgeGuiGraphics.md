# IForgeGuiGraphics

> `net.minecraftforge.client.extensions.IForgeGuiGraphics` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/extensions/IForgeGuiGraphics.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Extension interface for GuiGraphics.

## 公开成员（9 个）

```java
private GuiGraphics self()
```
源码 :16 —（无 javadoc）

```java
default int getColorFromFormattingCharacter(char c, boolean isLighter)
```
源码 :31 —（无 javadoc）

```java
default void blitWithBorder(ResourceLocation texture, int x, int y, int u, int v, int width, int height, int textureWidth, int textureHeight, int borderSize)
```
源码 :51 — Draws a textured box of any size (smallest size is borderSize * 2 square) based on a fixed size textured box with continuous borders and filler. @param texture the ResourceLocation object that contains the desired image @param x x-axis offset @param y y-axis offset @param u bound resource location i…

```java
default void blitWithBorder(ResourceLocation texture, int x, int y, int u, int v, int width, int height, int textureWidth, int textureHeight, int topBorder, int bottomBorder, int leftBorder, int rightBorder)
```
源码 :74 — Draws a textured box of any size (smallest size is borderSize * 2 square) based on a fixed size textured box with continuous borders and filler. @param texture the ResourceLocation object that contains the desired image @param x x-axis offset @param y y-axis offset @param u bound resource location i…

```java
default void blitInscribed(ResourceLocation texture, int x, int y, int boundsWidth, int boundsHeight, int rectWidth, int rectHeight)
```
源码 :117 —（无 javadoc）

```java
default void blitInscribed(ResourceLocation texture, int x, int y, int boundsWidth, int boundsHeight, int rectWidth, int rectHeight, boolean centerX, boolean centerY)
```
源码 :122 —（无 javadoc）

```java
default void blitNineSlicedSized(ResourceLocation texture, int x, int y, int width, int height, int sliceSize, int uWidth, int vHeight, int uOffset, int vOffset, int textureWidth, int textureHeight)
```
源码 :143 — Version of GuiGraphics#blitNineSliced(ResourceLocation, that supports specifying the texture's size.

```java
default void blitNineSlicedSized(ResourceLocation texture, int x, int y, int width, int height, int sliceWidth, int sliceHeight, int uWidth, int vHeight, int uOffset, int vOffset, int textureWidth, int textureHeight)
```
源码 :152 — Version of GuiGraphics#blitNineSliced(ResourceLocation, that supports specifying the texture's size.

```java
default void blitNineSlicedSized(ResourceLocation texture, int x, int y, int width, int height, int cornerWidth, int cornerHeight, int edgeWidth, int edgeHeight, int uWidth, int vHeight, int uOffset, int vOffset, int textureWidth, int textureHeight)
```
源码 :161 — Version of GuiGraphics#blitNineSliced(ResourceLocation, that supports specifying the texture's size.

