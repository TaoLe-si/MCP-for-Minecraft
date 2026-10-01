# IForgeBakedModel

> `net.minecraftforge.client.extensions.IForgeBakedModel` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/extensions/IForgeBakedModel.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Extension interface for IForgeBakedModel.

## 公开成员（9 个）

```java
private BakedModel self()
```
源码 :35 —（无 javadoc）

```java
default List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @NotNull RandomSource rand, @NotNull ModelData data, @Nullable RenderType renderType)
```
源码 :44 —（无 javadoc）

```java
default boolean useAmbientOcclusion(BlockState state)
```
源码 :49 —（无 javadoc）

```java
default boolean useAmbientOcclusion(BlockState state, RenderType renderType)
```
源码 :54 —（无 javadoc）

```java
default BakedModel applyTransform(ItemDisplayContext transformType, PoseStack poseStack, boolean applyLeftHandTransform)
```
源码 :63 — Applies a transform for the given ItemTransforms.TransformType and `applyLeftHandTransform`, and returns the model to be rendered.

```java
default TextureAtlasSprite getParticleIcon(@NotNull ModelData data)
```
源码 :74 —（无 javadoc）

```java
default ChunkRenderTypeSet getRenderTypes(@NotNull BlockState state, @NotNull RandomSource rand, @NotNull ModelData data)
```
源码 :85 — Gets the set of RenderType to use when drawing this block in the level. Supported types are those returned by RenderType#chunkBufferLayers(). By default, defers query to ItemBlockRenderTypes.

```java
default List<RenderType> getRenderTypes(ItemStack itemStack, boolean fabulous)
```
源码 :100 — Gets an ordered list of RenderType to use when drawing this item. All render types using the com.mojang.blaze3d.vertex.DefaultVertexFormat#NEW_ENTITY format are supported. This method will only be called on the models returned by #getRenderPasses(ItemStack,. By default, defers query to ItemBlockRend…

```java
default List<BakedModel> getRenderPasses(ItemStack itemStack, boolean fabulous)
```
源码 :113 — Gets an ordered list of baked models used to render this model as an item. Each of those models' render types will be queried via #getRenderTypes(ItemStack,. By default, returns the model itself. @see #getRenderTypes(ItemStack, boolean)

