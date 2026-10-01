# BlockGeometryBakingContext

> `net.minecraftforge.client.model.geometry.BlockGeometryBakingContext` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/geometry/BlockGeometryBakingContext.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：A IGeometryBakingContext geometry baking context that is bound to a BlockModel. Users should not be instantiating this themselves.

## 公开成员（24 个）

```java
public final BlockModel owner
```
源码 :36 —（无 javadoc）

```java
public final VisibilityData visibilityData = new VisibilityData()
```
源码 :37 —（无 javadoc）

```java
public BlockGeometryBakingContext(BlockModel owner)
```
源码 :49 —（无 javadoc）

```java
public String getModelName()
```
源码 :55 —（无 javadoc）

```java
public boolean hasCustomGeometry()
```
源码 :60 —（无 javadoc）

```java
public IUnbakedGeometry<?> getCustomGeometry()
```
源码 :66 —（无 javadoc）

```java
public void setCustomGeometry(IUnbakedGeometry<?> geometry)
```
源码 :71 —（无 javadoc）

```java
public boolean isComponentVisible(String part, boolean fallback)
```
源码 :77 —（无 javadoc）

```java
public boolean hasMaterial(String name)
```
源码 :85 —（无 javadoc）

```java
public Material getMaterial(String name)
```
源码 :91 —（无 javadoc）

```java
public boolean isGui3d()
```
源码 :97 —（无 javadoc）

```java
public boolean useBlockLight()
```
源码 :103 —（无 javadoc）

```java
public boolean useAmbientOcclusion()
```
源码 :109 —（无 javadoc）

```java
public ItemTransforms getTransforms()
```
源码 :115 —（无 javadoc）

```java
public Transformation getRootTransform()
```
源码 :121 —（无 javadoc）

```java
public void setRootTransform(Transformation rootTransform)
```
源码 :128 —（无 javadoc）

```java
public ResourceLocation getRenderTypeHint()
```
源码 :135 —（无 javadoc）

```java
public ResourceLocation getRenderTypeFastHint()
```
源码 :144 —（无 javadoc）

```java
public void setRenderTypeHint(ResourceLocation renderTypeHint)
```
源码 :151 —（无 javadoc）

```java
public void setRenderTypeFastHint(ResourceLocation renderTypeFastHint)
```
源码 :156 —（无 javadoc）

```java
public void setGui3d(boolean gui3d)
```
源码 :161 —（无 javadoc）

```java
public void copyFrom(BlockGeometryBakingContext other)
```
源码 :166 —（无 javadoc）

```java
public BakedModel bake(ModelBaker baker, Function<Material, TextureAtlasSprite> bakedTextureGetter, ModelState modelTransform, ItemOverrides overrides, ResourceLocation modelLocation)
```
源码 :176 —（无 javadoc）

```java
public static class VisibilityData
```
源码 :184 —（无 javadoc）

