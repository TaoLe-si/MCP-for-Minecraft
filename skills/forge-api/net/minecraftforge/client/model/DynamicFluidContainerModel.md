# DynamicFluidContainerModel

> `net.minecraftforge.client.model.DynamicFluidContainerModel` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/DynamicFluidContainerModel.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：A dynamic fluid container model, capable of re-texturing itself at runtime to match the contained fluid. Composed of a base layer, a fluid layer (applied with a mask) and a cover layer (optionally applied with a mask). The entire model may optionally be flipped if the fluid is gaseous, and the fluid layer may glow if light-emitting. Fluid tinting requires registering a separate ItemColor. An imple…

## 公开成员（5 个）

```java
public static RenderTypeGroup getLayerRenderTypes(boolean unlit)
```
源码 :76 —（无 javadoc）

```java
public DynamicFluidContainerModel withFluid(Fluid newFluid)
```
源码 :85 — Returns a new ModelDynBucket representing the given fluid, but with the same other properties (flipGas, tint, coverIsMask).

```java
public BakedModel bake(IGeometryBakingContext context, ModelBaker baker, Function<Material, TextureAtlasSprite> spriteGetter, ModelState modelState, ItemOverrides overrides, ResourceLocation modelLocation)
```
源码 :91 —（无 javadoc）

```java
public static final class Loader implements IGeometryLoader<DynamicFluidContainerModel>
```
源码 :166 —（无 javadoc）

```java
public static class Colors implements ItemColor
```
源码 :234 —（无 javadoc）

