# IForgeTransformation

> `net.minecraftforge.common.extensions.IForgeTransformation` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeTransformation.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Extension interface for Transformation.

## 公开成员（8 个）

```java
private Transformation self()
```
源码 :20 —（无 javadoc）

```java
default boolean isIdentity()
```
源码 :30 — whether this transformation is the identity transformation @see Transformation#identity()

```java
default void transformPosition(Vector4f position)
```
源码 :40 — Transforms the position according to this transformation. @param position the position to transform

```java
default void transformNormal(Vector3f normal)
```
源码 :50 — Transforms the normal according to this transformation and normalizes it. @param normal the normal to transform

```java
default Direction rotateTransform(Direction facing)
```
源码 :64 — Rotates the direction according to this transformation and returns the nearest `Direction` to the resulting direction. @param facing the direction to transform @return the `Direction` value nearest to the resulting transformed direction @see Direction#rotate(Matrix4f, Direction)

```java
default Transformation blockCenterToCorner()
```
源码 :75 — Converts and returns a new transformation based on this transformation from assuming a center-block system to an opposing-corner-block system. @return a new transformation using the opposing-corner-block system

```java
default Transformation blockCornerToCenter()
```
源码 :86 — Converts and returns a new transformation based on this transformation from assuming an opposing-corner-block system to a center-block system. @return a new transformation using the center-block system

```java
default Transformation applyOrigin(Vector3f origin)
```
源码 :98 — Returns a new transformation with a changed origin by applying the given parameter (which is relative to the current origin). This can be used for switching between coordinate systems. @param origin the new origin as relative to the current origin @return a new transformation with a changed origin

