# IQuadTransformer

> `net.minecraftforge.client.model.IQuadTransformer` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/IQuadTransformer.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：Transformer for BakedQuad. @see QuadTransformers

## 公开成员（7 个）

```java
void processInPlace(BakedQuad quad)
```
源码 :31 —（无 javadoc）

```java
default void processInPlace(List<BakedQuad> quads)
```
源码 :33 —（无 javadoc）

```java
default BakedQuad process(BakedQuad quad)
```
源码 :39 —（无 javadoc）

```java
default List<BakedQuad> process(List<BakedQuad> inputs)
```
源码 :46 —（无 javadoc）

```java
default IQuadTransformer andThen(IQuadTransformer other)
```
源码 :51 —（无 javadoc）

```java
private static BakedQuad copy(BakedQuad quad)
```
源码 :59 —（无 javadoc）

```java
private static int findOffset(VertexFormatElement element)
```
源码 :65 —（无 javadoc）

