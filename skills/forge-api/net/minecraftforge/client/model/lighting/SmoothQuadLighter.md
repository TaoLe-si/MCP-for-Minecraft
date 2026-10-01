# SmoothQuadLighter

> `net.minecraftforge.client.model.lighting.SmoothQuadLighter` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/lighting/SmoothQuadLighter.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：Implementation of QuadLighter that lights BakedQuad using ambient occlusion and light interpolation.

## 公开成员（5 个）

```java
public SmoothQuadLighter(BlockColors colors)
```
源码 :36 —（无 javadoc）

```java
protected void computeLightingAt(BlockAndTintGetter level, BlockPos origin, BlockState state)
```
源码 :42 —（无 javadoc）

```java
protected float calculateBrightness(float[] position)
```
源码 :119 —（无 javadoc）

```java
protected int calculateLightmap(float[] position, byte[] normal)
```
源码 :145 —（无 javadoc）

```java
protected float calcLightmap(float[][][][] light, float x, float y, float z)
```
源码 :161 —（无 javadoc）

