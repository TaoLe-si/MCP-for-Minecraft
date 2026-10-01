# VertexConsumerWrapper

> `net.minecraftforge.client.model.pipeline.VertexConsumerWrapper` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/pipeline/VertexConsumerWrapper.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：Wrapper for VertexConsumer which delegates all operations to its parent. Useful for defining custom pipeline elements that only process certain data.

## 公开成员（12 个）

```java
protected final VertexConsumer parent
```
源码 :18 —（无 javadoc）

```java
public VertexConsumerWrapper(VertexConsumer parent)
```
源码 :20 —（无 javadoc）

```java
public VertexConsumer vertex(double x, double y, double z)
```
源码 :26 —（无 javadoc）

```java
public VertexConsumer color(int r, int g, int b, int a)
```
源码 :33 —（无 javadoc）

```java
public VertexConsumer uv(float u, float v)
```
源码 :40 —（无 javadoc）

```java
public VertexConsumer overlayCoords(int u, int v)
```
源码 :47 —（无 javadoc）

```java
public VertexConsumer uv2(int u, int v)
```
源码 :54 —（无 javadoc）

```java
public VertexConsumer normal(float x, float y, float z)
```
源码 :61 —（无 javadoc）

```java
public VertexConsumer misc(VertexFormatElement element, int... values)
```
源码 :68 —（无 javadoc）

```java
public void endVertex()
```
源码 :75 —（无 javadoc）

```java
public void defaultColor(int r, int g, int b, int a)
```
源码 :81 —（无 javadoc）

```java
public void unsetDefaultColor()
```
源码 :87 —（无 javadoc）

