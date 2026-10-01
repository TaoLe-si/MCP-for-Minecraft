# CompositeModel

> `net.minecraftforge.client.model.CompositeModel` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/CompositeModel.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：A model composed of several named children. These respect component visibility as specified in IGeometryBakingContext and can additionally be provided with an item-specific render ordering, for multi-pass arrangements.

## 公开成员（7 个）

```java
public CompositeModel(ImmutableMap<String, BlockModel> children, ImmutableList<String> itemPasses)
```
源码 :64 —（无 javadoc）

```java
public BakedModel bake(IGeometryBakingContext context, ModelBaker baker, Function<Material, TextureAtlasSprite> spriteGetter, ModelState modelState, ItemOverrides overrides, ResourceLocation modelLocation)
```
源码 :71 —（无 javadoc）

```java
public void resolveParents(Function<ResourceLocation, UnbakedModel> modelGetter, IGeometryBakingContext context)
```
源码 :104 —（无 javadoc）

```java
public Set<String> getConfigurableComponentNames()
```
源码 :110 —（无 javadoc）

```java
public static class Baked implements IDynamicBakedModel
```
源码 :115 —（无 javadoc）

```java
public static class Data
```
源码 :348 — A model data container which stores data for child components.

```java
public static final class Loader implements IGeometryLoader<CompositeModel>
```
源码 :403 — Helper to get the data from a ModelData instance. @param modelData The object to get data from @param name The name of the part to get data for @return The data for the part, or the one passed in if not found

