# SeparateTransformsModel

> `net.minecraftforge.client.model.SeparateTransformsModel` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/SeparateTransformsModel.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：A model composed of multiple sub-models which are picked based on the ItemDisplayContext being used.

## 公开成员（5 个）

```java
public SeparateTransformsModel(BlockModel baseModel, ImmutableMap<ItemDisplayContext, BlockModel> perspectives)
```
源码 :50 —（无 javadoc）

```java
public BakedModel bake(IGeometryBakingContext context, ModelBaker baker, Function<Material, TextureAtlasSprite> spriteGetter, ModelState modelState, ItemOverrides overrides, ResourceLocation modelLocation)
```
源码 :57 —（无 javadoc）

```java
public void resolveParents(Function<ResourceLocation, UnbakedModel> modelGetter, IGeometryBakingContext context)
```
源码 :70 —（无 javadoc）

```java
public static class Baked implements IDynamicBakedModel
```
源码 :76 —（无 javadoc）

```java
public static final class Loader implements IGeometryLoader<SeparateTransformsModel>
```
源码 :164 —（无 javadoc）

