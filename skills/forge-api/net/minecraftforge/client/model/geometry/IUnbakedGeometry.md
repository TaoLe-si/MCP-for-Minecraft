# IUnbakedGeometry

> `net.minecraftforge.client.model.geometry.IUnbakedGeometry` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/geometry/IUnbakedGeometry.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：General interface for any model that can be baked, superset of vanilla UnbakedModel. Instances of this class ar usually created via IGeometryLoader. @see IGeometryLoader @see IGeometryBakingContext

## 公开成员（3 个）

```java
BakedModel bake(IGeometryBakingContext context, ModelBaker baker, Function<Material, TextureAtlasSprite> spriteGetter, ModelState modelState, ItemOverrides overrides, ResourceLocation modelLocation)
```
源码 :31 —（无 javadoc）

```java
default void resolveParents(Function<ResourceLocation, UnbakedModel> modelGetter, IGeometryBakingContext context)
```
源码 :38 — Resolve parents of nested BlockModels which are later used in IUnbakedGeometry#bake(IGeometryBakingContext, via BlockModel#resolveParents(Function)

```java
default Set<String> getConfigurableComponentNames()
```
源码 :46 — a set of all the components whose visibility may be configured via IGeometryBakingContext

