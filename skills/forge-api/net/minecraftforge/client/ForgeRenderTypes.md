# ForgeRenderTypes

> `net.minecraftforge.client.ForgeRenderTypes` · enum · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/ForgeRenderTypes.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（17 个）

```java
public static boolean enableTextTextureLinearFiltering = false
```
源码 :41 —（无 javadoc）

```java
public static RenderType getItemLayeredSolid(ResourceLocation textureLocation)
```
源码 :46 — @return A RenderType fit for multi-layer solid item rendering.

```java
public static RenderType getItemLayeredCutout(ResourceLocation textureLocation)
```
源码 :54 — @return A RenderType fit for multi-layer cutout item item rendering.

```java
public static RenderType getItemLayeredCutoutMipped(ResourceLocation textureLocation)
```
源码 :62 — @return A RenderType fit for multi-layer cutout-mipped item rendering.

```java
public static RenderType getItemLayeredTranslucent(ResourceLocation textureLocation)
```
源码 :70 — @return A RenderType fit for multi-layer translucent item rendering.

```java
public static RenderType getUnsortedTranslucent(ResourceLocation textureLocation)
```
源码 :78 — @return A RenderType fit for translucent item/entity rendering, but with depth sorting disabled.

```java
public static RenderType getUnlitTranslucent(ResourceLocation textureLocation)
```
源码 :87 — @return A RenderType fit for translucent item/entity rendering, but with diffuse lighting disabled so that fullbright quads look correct.

```java
public static RenderType getUnlitTranslucent(ResourceLocation textureLocation, boolean sortingEnabled)
```
源码 :97 — @return A RenderType fit for translucent item/entity rendering, but with diffuse lighting disabled so that fullbright quads look correct. @param sortingEnabled If false, depth sorting will not be performed.

```java
public static RenderType getEntityCutoutMipped(ResourceLocation textureLocation)
```
源码 :105 — @return Same as RenderType#entityCutout(ResourceLocation), but with mipmapping enabled.

```java
public static RenderType getText(ResourceLocation locationIn)
```
源码 :113 — @return Replacement of RenderType#text(ResourceLocation), but with optional linear texture filtering.

```java
public static RenderType getTextIntensity(ResourceLocation locationIn)
```
源码 :121 — @return Replacement of RenderType#textIntensity(ResourceLocation), but with optional linear texture filtering.

```java
public static RenderType getTextPolygonOffset(ResourceLocation locationIn)
```
源码 :129 — @return Replacement of RenderType#textPolygonOffset(ResourceLocation), but with optional linear texture filtering.

```java
public static RenderType getTextIntensityPolygonOffset(ResourceLocation locationIn)
```
源码 :137 — @return Replacement of RenderType#textIntensityPolygonOffset(ResourceLocation), but with optional linear texture filtering.

```java
public static RenderType getTextSeeThrough(ResourceLocation locationIn)
```
源码 :145 — @return Replacement of RenderType#textSeeThrough(ResourceLocation), but with optional linear texture filtering.

```java
public static RenderType getTextIntensitySeeThrough(ResourceLocation locationIn)
```
源码 :153 — @return Replacement of RenderType#textIntensitySeeThrough(ResourceLocation), but with optional linear texture filtering.

```java
public static RenderType getTranslucentParticlesTarget(ResourceLocation locationIn)
```
源码 :161 — @return A variation of RenderType#translucent() that uses OutputStateShard#PARTICLES_TARGET to allow fabulous transparency sorting when using RenderLevelStageEvent

```java
public RenderType get()
```
源码 :178 —（无 javadoc）

