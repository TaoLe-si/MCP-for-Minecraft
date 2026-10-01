# UnbakedGeometryHelper

> `net.minecraftforge.client.model.geometry.UnbakedGeometryHelper` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/geometry/UnbakedGeometryHelper.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：Helper for dealing with unbaked models and geometries.

## 公开成员（11 个）

```java
public static Material resolveDirtyMaterial(@Nullable String tex, IGeometryBakingContext owner)
```
源码 :77 — Resolves a material that may have been defined with a filesystem path instead of a proper ResourceLocation. The target atlas will always be TextureAtlas#LOCATION_BLOCKS.

```java
public static BakedModel bake(BlockModel blockModel, ModelBaker modelBaker, BlockModel owner, Function<Material, TextureAtlasSprite> spriteGetter, ModelState modelState, ResourceLocation modelLocation, boolean guiLight3d)
```
源码 :101 —（无 javadoc）

```java
public static List<BlockElement> createUnbakedItemElements(int layerIndex, SpriteContents spriteContents)
```
源码 :124 — @see #createUnbakedItemElements(int, SpriteContents, ForgeFaceData)

```java
public static List<BlockElement> createUnbakedItemElements(int layerIndex, SpriteContents spriteContents, @Nullable ForgeFaceData faceData)
```
源码 :135 — Creates a list of BlockElement block elements in the shape of the specified sprite contents. These can later be baked using the same, or another texture. The Direction#NORTH and Direction#SOUTH faces take up the whole surface.

```java
public static List<BlockElement> createUnbakedItemMaskElements(int layerIndex, SpriteContents spriteContents)
```
源码 :148 — @see #createUnbakedItemMaskElements(int, SpriteContents, ForgeFaceData)

```java
public static List<BlockElement> createUnbakedItemMaskElements(int layerIndex, SpriteContents spriteContents, @Nullable ForgeFaceData faceData)
```
源码 :159 — Creates a list of BlockElement block elements in the shape of the specified sprite contents. These can later be baked using the same, or another texture. The Direction#NORTH and Direction#SOUTH faces take up only the pixels the texture uses.

```java
public static void bakeElements(IModelBuilder<?> builder, List<BlockElement> elements, Function<Material, TextureAtlasSprite> spriteGetter, ModelState modelState, ResourceLocation modelLocation)
```
源码 :227 — Bakes a list of BlockElement block elements and feeds the baked quads to a IModelBuilder model builder.

```java
public static List<BakedQuad> bakeElements(List<BlockElement> elements, Function<Material, TextureAtlasSprite> spriteGetter, ModelState modelState, ResourceLocation modelLocation)
```
源码 :245 — Bakes a list of BlockElement block elements and returns the list of baked quads.

```java
public static BakedQuad bakeElementFace(BlockElement element, BlockElementFace face, TextureAtlasSprite sprite, Direction direction, ModelState state, ResourceLocation modelLocation)
```
源码 :257 — Turns a single BlockElementFace into a BakedQuad.

```java
public static IQuadTransformer applyRootTransform(ModelState modelState, Transformation rootTransform)
```
源码 :270 — Create an IQuadTransformer to apply a Transformation that undoes the ModelState transform (blockstate transform), applies the given root transform and then re-applies the blockstate transform. @return an `IQuadTransformer` that applies the root transform to a baked quad that already has the transfor…

```java
public static ModelState composeRootTransformIntoModelState(ModelState modelState, Transformation rootTransform)
```
源码 :282 — a ModelState that combines the existing model state and the {@linkplain Transformation root transform}

