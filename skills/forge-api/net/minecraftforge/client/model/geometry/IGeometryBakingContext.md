# IGeometryBakingContext

> `net.minecraftforge.client.model.geometry.IGeometryBakingContext` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/geometry/IGeometryBakingContext.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：The context in which a geometry is being baked, providing information such as lighting and ItemTransforms transforms, and allowing the user to create Material materials and query RenderTypeGroup render types. @see StandaloneGeometryBakingContext @see BlockGeometryBakingContext

## 公开成员（11 个）

```java
String getModelName()
```
源码 :29 — the name of the model being baked for logging and caching purposes.

```java
boolean hasMaterial(String name)
```
源码 :37 — Checks if a material is present in the model. @param name The name of the material @return true if the material is present, false otherwise

```java
Material getMaterial(String name)
```
源码 :45 — Resolves the final texture name, taking into account texture aliases and replacements. @param name The name of the material @return The material, or the missing texture if not found

```java
boolean isGui3d()
```
源码 :50 — true if this model should render in 3D in a GUI, false otherwise

```java
boolean useBlockLight()
```
源码 :55 — true if block lighting should be used for this model, false otherwise

```java
boolean useAmbientOcclusion()
```
源码 :60 — true if per-vertex ambient occlusion should be used for this model, false otherwise

```java
ItemTransforms getTransforms()
```
源码 :65 — the transforms for display in item form.

```java
Transformation getRootTransform()
```
源码 :70 — the root transformation to be applied to all variants of this model, regardless of item transforms.

```java
ResourceLocation getRenderTypeHint()
```
源码 :76 —（无 javadoc）

```java
default ResourceLocation getRenderTypeFastHint() { return null; } /** * Queries the visibility of a component of this model. * * @param component The component for which to query visibility * @param fallback The default visibility if an override isn't found * @return The visibility of the component */ boolean isComponentVisible(String component, boolean fallback)
```
源码 :83 —（无 javadoc）

```java
default RenderTypeGroup getRenderType(ResourceLocation name)
```
源码 :97 — a RenderTypeGroup with the given name, or the empty group if not found.

