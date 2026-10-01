# IRenderable

> `net.minecraftforge.client.model.renderable.IRenderable` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/renderable/IRenderable.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：A standard interface for things that can be rendered to a MultiBufferSource. @param The type of context object used by the rendering logic

## 公开成员（2 个）

```java
void render(PoseStack poseStack, MultiBufferSource bufferSource, ITextureRenderTypeLookup textureRenderTypeLookup, int lightmap, int overlay, float partialTick, T context)
```
源码 :31 — Draws the renderable by adding the geometry to the provided MultiBufferSource @param poseStack The pose stack @param bufferSource The buffer source where the vertex data should be output @param textureRenderTypeLookup A function that provides a RenderType for the given texture @param lightmap The li…

```java
default IRenderable<Unit> withContext(T context)
```
源码 :40 — Wraps the current renderable along with a context. Useful for keeping a list of various renderables paired with their contexts. @param context The context used for rendering @return A renderable that accepts Unit#INSTANCE as context, but uses the provided `context` instead

