# ItemLayerModel

> `net.minecraftforge.client.model.ItemLayerModel` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/ItemLayerModel.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：Forge reimplementation of vanilla's ItemModelGenerator, i.e. builtin/generated models with some tweaks: - Represented as IUnbakedGeometry so it can be baked as usual instead of being special-cased - Not limited to an arbitrary number of layers (5) - Support for per-layer render types

## 公开成员（2 个）

```java
public BakedModel bake(IGeometryBakingContext context, ModelBaker baker, Function<Material, TextureAtlasSprite> spriteGetter, ModelState modelState, ItemOverrides overrides, ResourceLocation modelLocation)
```
源码 :64 —（无 javadoc）

```java
public static final class Loader implements IGeometryLoader<ItemLayerModel>
```
源码 :100 —（无 javadoc）

