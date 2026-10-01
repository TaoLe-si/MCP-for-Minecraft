# SimpleUnbakedGeometry

> `net.minecraftforge.client.model.geometry.SimpleUnbakedGeometry` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/geometry/SimpleUnbakedGeometry.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：Base class for implementations of IUnbakedGeometry which do not wish to handle model creation themselves, instead supplying BakedQuad baked quads through a builder.

## 公开成员（2 个）

```java
public BakedModel bake(IGeometryBakingContext context, ModelBaker baker, Function<Material, TextureAtlasSprite> spriteGetter, ModelState modelState, ItemOverrides overrides, ResourceLocation modelLocation)
```
源码 :27 —（无 javadoc）

```java
protected abstract void addQuads(IGeometryBakingContext owner, IModelBuilder<?> modelBuilder, ModelBaker baker, Function<Material, TextureAtlasSprite> spriteGetter, ModelState modelTransform, ResourceLocation modelLocation)
```
源码 :43 —（无 javadoc）

