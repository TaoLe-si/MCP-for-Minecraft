# EmptyModel

> `net.minecraftforge.client.model.EmptyModel` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/EmptyModel.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：A completely empty model with no quads or texture dependencies. You can access it as a BakedModel, an IUnbakedGeometry or an IGeometryLoader.

## 公开成员（5 个）

```java
public static final BakedModel BAKED = new Baked()
```
源码 :40 —（无 javadoc）

```java
public static final EmptyModel INSTANCE = new EmptyModel()
```
源码 :41 —（无 javadoc）

```java
public static final IGeometryLoader<EmptyModel> LOADER = (json, ctx) -> INSTANCE
```
源码 :42 —（无 javadoc）

```java
protected void addQuads(IGeometryBakingContext owner, IModelBuilder<?> modelBuilder, ModelBaker baker, Function<Material, TextureAtlasSprite> spriteGetter, ModelState modelTransform, ResourceLocation modelLocation)
```
源码 :49 —（无 javadoc）

```java
public BakedModel bake(IGeometryBakingContext context, ModelBaker baker, Function<Material, TextureAtlasSprite> spriteGetter, ModelState modelState, ItemOverrides overrides, ResourceLocation modelLocation)
```
源码 :55 —（无 javadoc）

