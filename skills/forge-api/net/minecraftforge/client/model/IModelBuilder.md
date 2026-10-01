# IModelBuilder

> `net.minecraftforge.client.model.IModelBuilder` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/IModelBuilder.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：Base interface for any object that collects culled and unculled faces and bakes them into a model. Provides a generic base implementation via #of(boolean, and a quad-collecting alternative via #collecting(List).

## 公开成员（3 个）

```java
T addCulledFace(Direction facing, BakedQuad quad)
```
源码 :56 —（无 javadoc）

```java
T addUnculledFace(BakedQuad quad)
```
源码 :58 —（无 javadoc）

```java
BakedModel build()
```
源码 :60 —（无 javadoc）

