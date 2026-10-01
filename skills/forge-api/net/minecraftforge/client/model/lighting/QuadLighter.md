# QuadLighter

> `net.minecraftforge.client.model.lighting.QuadLighter` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/lighting/QuadLighter.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：Base class for all quad lighting providers. Contains all the shared elements needed for BakedQuad processing and defers lighting logic to inheritors. @see FlatQuadLighter @see SmoothQuadLighter

## 公开成员（9 个）

```java
protected QuadLighter(BlockColors colors)
```
源码 :51 —（无 javadoc）

```java
protected abstract void computeLightingAt(BlockAndTintGetter level, BlockPos pos, BlockState state)
```
源码 :56 —（无 javadoc）

```java
protected abstract float calculateBrightness(float[] position)
```
源码 :58 —（无 javadoc）

```java
protected abstract int calculateLightmap(float[] position, byte[] normal)
```
源码 :60 —（无 javadoc）

```java
public final void setup(BlockAndTintGetter level, BlockPos pos, BlockState state)
```
源码 :62 —（无 javadoc）

```java
public final void reset()
```
源码 :77 —（无 javadoc）

```java
public final void process(VertexConsumer consumer, PoseStack.Pose pose, BakedQuad quad, int overlay)
```
源码 :82 —（无 javadoc）

```java
public static float calculateShade(float normalX, float normalY, float normalZ, boolean constantAmbientLight)
```
源码 :150 —（无 javadoc）

```java
protected static int getLightColor(BlockAndTintGetter level, BlockPos pos, BlockState state)
```
源码 :162 —（无 javadoc）

