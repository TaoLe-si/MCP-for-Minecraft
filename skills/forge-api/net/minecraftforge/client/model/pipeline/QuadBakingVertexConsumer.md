# QuadBakingVertexConsumer

> `net.minecraftforge.client.model.pipeline.QuadBakingVertexConsumer` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/pipeline/QuadBakingVertexConsumer.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：Vertex consumer that outputs BakedQuad baked quads. This consumer accepts data in com.mojang.blaze3d.vertex.DefaultVertexFormat#BLOCK and is not picky about ordering or missing elements, but will not automatically populate missing data (color will be black, for example).

## 公开成员（17 个）

```java
public QuadBakingVertexConsumer(Consumer<BakedQuad> quadConsumer)
```
源码 :49 —（无 javadoc）

```java
public VertexConsumer vertex(double x, double y, double z)
```
源码 :55 —（无 javadoc）

```java
public VertexConsumer normal(float x, float y, float z)
```
源码 :65 —（无 javadoc）

```java
public VertexConsumer color(int r, int g, int b, int a)
```
源码 :75 —（无 javadoc）

```java
public VertexConsumer uv(float u, float v)
```
源码 :86 —（无 javadoc）

```java
public VertexConsumer overlayCoords(int u, int v)
```
源码 :95 —（无 javadoc）

```java
public VertexConsumer uv2(int u, int v)
```
源码 :106 —（无 javadoc）

```java
public VertexConsumer misc(VertexFormatElement element, int... rawData)
```
源码 :114 —（无 javadoc）

```java
public void endVertex()
```
源码 :126 —（无 javadoc）

```java
public void defaultColor(int r, int g, int b, int a)
```
源码 :137 —（无 javadoc）

```java
public void unsetDefaultColor()
```
源码 :142 —（无 javadoc）

```java
public void setTintIndex(int tintIndex)
```
源码 :146 —（无 javadoc）

```java
public void setDirection(Direction direction)
```
源码 :151 —（无 javadoc）

```java
public void setSprite(TextureAtlasSprite sprite)
```
源码 :156 —（无 javadoc）

```java
public void setShade(boolean shade)
```
源码 :161 —（无 javadoc）

```java
public void setHasAmbientOcclusion(boolean hasAmbientOcclusion)
```
源码 :166 —（无 javadoc）

```java
public static class Buffered extends QuadBakingVertexConsumer
```
源码 :171 —（无 javadoc）

