# CompositeRenderable

> `net.minecraftforge.client.model.renderable.CompositeRenderable` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/renderable/CompositeRenderable.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：A renderable object composed of a hierarchy of parts, each made up of a number of meshes. Each mesh renders a set of quads using a different texture. @see Builder

## 公开成员（5 个）

```java
public void render(PoseStack poseStack, MultiBufferSource bufferSource, ITextureRenderTypeLookup textureRenderTypeLookup, int lightmap, int overlay, float partialTick, Transforms context)
```
源码 :35 —（无 javadoc）

```java
public static Builder builder()
```
源码 :41 —（无 javadoc）

```java
public static class Builder
```
源码 :97 —（无 javadoc）

```java
public static class PartBuilder<T>
```
源码 :118 —（无 javadoc）

```java
public static class Transforms
```
源码 :153 — A context value that provides Matrix4f transforms for certain parts of the model.

