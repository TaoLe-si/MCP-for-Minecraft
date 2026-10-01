# ForgeModelBlockRenderer

> `net.minecraftforge.client.model.lighting.ForgeModelBlockRenderer` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/lighting/ForgeModelBlockRenderer.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：Wrapper around ModelBlockRenderer to allow rendering blocks via Forge's lighting pipeline.

## 公开成员（4 个）

```java
public ForgeModelBlockRenderer(BlockColors colors)
```
源码 :36 —（无 javadoc）

```java
public void tesselateWithoutAO(BlockAndTintGetter level, BakedModel model, BlockState state, BlockPos pos, PoseStack poseStack, VertexConsumer vertexConsumer, boolean checkSides, RandomSource rand, long seed, int packedOverlay, ModelData modelData, RenderType renderType)
```
源码 :44 —（无 javadoc）

```java
public void tesselateWithAO(BlockAndTintGetter level, BakedModel model, BlockState state, BlockPos pos, PoseStack poseStack, VertexConsumer vertexConsumer, boolean checkSides, RandomSource rand, long seed, int packedOverlay, ModelData modelData, RenderType renderType)
```
源码 :57 —（无 javadoc）

```java
public static boolean render(VertexConsumer vertexConsumer, QuadLighter lighter, BlockAndTintGetter level, BakedModel model, BlockState state, BlockPos pos, PoseStack poseStack, boolean checkSides, RandomSource rand, long seed, int packedOverlay, ModelData modelData, RenderType renderType)
```
源码 :69 —（无 javadoc）

