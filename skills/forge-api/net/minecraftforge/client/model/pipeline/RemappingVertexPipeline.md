# RemappingVertexPipeline

> `net.minecraftforge.client.model.pipeline.RemappingVertexPipeline` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/pipeline/RemappingVertexPipeline.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：Vertex pipeline element that remaps incoming data to another format.

## 公开成员（11 个）

```java
public RemappingVertexPipeline(VertexConsumer parent, VertexFormat targetFormat)
```
源码 :44 —（无 javadoc）

```java
public VertexConsumer vertex(double x, double y, double z)
```
源码 :59 —（无 javadoc）

```java
public VertexConsumer normal(float x, float y, float z)
```
源码 :66 —（无 javadoc）

```java
public VertexConsumer color(int r, int g, int b, int a)
```
源码 :73 —（无 javadoc）

```java
public VertexConsumer uv(float u, float v)
```
源码 :83 —（无 javadoc）

```java
public VertexConsumer overlayCoords(int u, int v)
```
源码 :91 —（无 javadoc）

```java
public VertexConsumer uv2(int u, int v)
```
源码 :99 —（无 javadoc）

```java
public VertexConsumer misc(VertexFormatElement element, int... values)
```
源码 :107 —（无 javadoc）

```java
public void endVertex()
```
源码 :116 —（无 javadoc）

```java
public void defaultColor(int r, int g, int b, int a)
```
源码 :144 —（无 javadoc）

```java
public void unsetDefaultColor()
```
源码 :150 —（无 javadoc）

