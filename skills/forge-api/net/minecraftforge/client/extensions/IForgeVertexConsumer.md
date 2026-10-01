# IForgeVertexConsumer

> `net.minecraftforge.client.extensions.IForgeVertexConsumer` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/extensions/IForgeVertexConsumer.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Extension interface for VertexConsumer.

## 公开成员（5 个）

```java
private VertexConsumer self()
```
源码 :23 —（无 javadoc）

```java
default VertexConsumer misc(VertexFormatElement element, int... rawData)
```
源码 :33 — Consumes an unknown VertexFormatElement as a raw int data array. If the consumer needs to store the data for later use, it must copy it. There are no guarantees on immutability.

```java
default void putBulkData(PoseStack.Pose pose, BakedQuad bakedQuad, float red, float green, float blue, float alpha, int packedLight, int packedOverlay, boolean readExistingColor)
```
源码 :41 — Variant with no per-vertex shading.

```java
default int applyBakedLighting(int packedLight, ByteBuffer data)
```
源码 :46 —（无 javadoc）

```java
default void applyBakedNormals(Vector3f generated, ByteBuffer data, Matrix3f normalTransform)
```
源码 :58 —（无 javadoc）

