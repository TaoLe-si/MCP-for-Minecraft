# BakedModelWrapper

> `net.minecraftforge.client.model.BakedModelWrapper` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/BakedModelWrapper.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：Wrapper for BakedModel which delegates all operations to its parent. Useful for creating wrapper baked models which only override certain properties.

## 公开成员（19 个）

```java
protected final T originalModel
```
源码 :36 —（无 javadoc）

```java
public BakedModelWrapper(T originalModel)
```
源码 :38 —（无 javadoc）

```java
public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, RandomSource rand)
```
源码 :44 —（无 javadoc）

```java
public boolean useAmbientOcclusion()
```
源码 :50 —（无 javadoc）

```java
public boolean useAmbientOcclusion(BlockState state)
```
源码 :56 —（无 javadoc）

```java
public boolean useAmbientOcclusion(BlockState state, RenderType renderType)
```
源码 :62 —（无 javadoc）

```java
public boolean isGui3d()
```
源码 :68 —（无 javadoc）

```java
public boolean usesBlockLight()
```
源码 :74 —（无 javadoc）

```java
public boolean isCustomRenderer()
```
源码 :80 —（无 javadoc）

```java
public TextureAtlasSprite getParticleIcon()
```
源码 :86 —（无 javadoc）

```java
public ItemTransforms getTransforms()
```
源码 :92 —（无 javadoc）

```java
public ItemOverrides getOverrides()
```
源码 :98 —（无 javadoc）

```java
public BakedModel applyTransform(ItemDisplayContext cameraTransformType, PoseStack poseStack, boolean applyLeftHandTransform)
```
源码 :104 —（无 javadoc）

```java
public TextureAtlasSprite getParticleIcon(@NotNull ModelData data)
```
源码 :110 —（无 javadoc）

```java
public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @NotNull RandomSource rand, @NotNull ModelData extraData, @Nullable RenderType renderType)
```
源码 :117 —（无 javadoc）

```java
public ModelData getModelData(@NotNull BlockAndTintGetter level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull ModelData modelData)
```
源码 :124 —（无 javadoc）

```java
public ChunkRenderTypeSet getRenderTypes(@NotNull BlockState state, @NotNull RandomSource rand, @NotNull ModelData data)
```
源码 :130 —（无 javadoc）

```java
public List<RenderType> getRenderTypes(ItemStack itemStack, boolean fabulous)
```
源码 :136 —（无 javadoc）

```java
public List<BakedModel> getRenderPasses(ItemStack itemStack, boolean fabulous)
```
源码 :142 —（无 javadoc）

