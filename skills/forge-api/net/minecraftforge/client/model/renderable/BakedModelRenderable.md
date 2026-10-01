# BakedModelRenderable

> `net.minecraftforge.client.model.renderable.BakedModelRenderable` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/renderable/BakedModelRenderable.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：IRenderable Renderable wrapper for BakedModel baked models. The context can provide the BlockState, faces to be rendered, a RandomSource and seed, a ModelData instance, and a Vector4f. @see Context

## 公开成员（6 个）

```java
public static BakedModelRenderable of(ResourceLocation model)
```
源码 :41 — Constructs a BakedModelRenderable from the given model location. The model is expected to have been baked ahead of time. @see net.minecraftforge.client.event.ModelEvent.RegisterAdditional

```java
public static BakedModelRenderable of(BakedModel model)
```
源码 :49 — Constructs a BakedModelRenderable from the given baked model.

```java
public void render(PoseStack poseStack, MultiBufferSource bufferSource, ITextureRenderTypeLookup textureRenderTypeLookup, int lightmap, int overlay, float partialTick, Context context)
```
源码 :62 —（无 javadoc）

```java
public IRenderable<Unit> withContext(ModelData modelData)
```
源码 :76 —（无 javadoc）

```java
public IRenderable<ModelData> withModelDataContext()
```
源码 :81 —（无 javadoc）

```java
public record Context(@Nullable BlockState state, Direction[] faces, RandomSource randomSource, long seed, ModelData data, Vector4f tint)
```
源码 :87 —（无 javadoc）

