# QuadTransformers

> `net.minecraftforge.client.model.QuadTransformers` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/QuadTransformers.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：A collection of IQuadTransformer implementations. @see IQuadTransformer

## 公开成员（10 个）

```java
public static IQuadTransformer empty()
```
源码 :33 — a BakedQuad transformer that does nothing

```java
public static IQuadTransformer applying(Transformation transform)
```
源码 :41 — a new BakedQuad transformer that applies the specified Transformation

```java
public static IQuadTransformer applyingLightmap(int packedLight)
```
源码 :88 — @return A new BakedQuad transformer that applies the specified packed light value.

```java
public static IQuadTransformer applyingLightmap(int blockLight, int skyLight)
```
源码 :100 — @return A new BakedQuad transformer that applies the specified block and sky light values.

```java
public static IQuadTransformer settingEmissivity(int emissivity)
```
源码 :108 — @return A BakedQuad transformer that sets the lightmap to the given emissivity (0-15)

```java
public static IQuadTransformer settingMaxEmissivity()
```
源码 :117 — @return A BakedQuad transformer that sets the lightmap to its max value

```java
public static IQuadTransformer applyingColor(int color)
```
源码 :126 — @param color The color in ARGB format. @return A BakedQuad transformer that sets the color to the specified value.

```java
public static IQuadTransformer applyingColor(int red, int green, int blue)
```
源码 :143 — This method supplies a default alpha value of 255 (no transparency) @param red The red value (0-255) @param green The green value (0-255) @param blue The blue value (0-255) @return A BakedQuad transformer that sets the color to the specified value.

```java
public static IQuadTransformer applyingColor(int alpha, int red, int green, int blue)
```
源码 :155 — @param alpha The alpha value (0-255) @param red The red value (0-255) @param green The green value (0-255) @param blue The blue value (0-255) @return A BakedQuad transformer that sets the color to the specified value.

```java
public static int toABGR(int argb)
```
源码 :166 — Converts an ARGB color to an ABGR color, as the commonly used color format is not the format colors end up packed into. This function doubles as its own inverse. @param color ARGB color @return ABGR color

