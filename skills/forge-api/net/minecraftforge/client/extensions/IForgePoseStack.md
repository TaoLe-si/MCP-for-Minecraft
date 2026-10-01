# IForgePoseStack

> `net.minecraftforge.client.extensions.IForgePoseStack` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/extensions/IForgePoseStack.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Extension interface for com.mojang.blaze3d.vertex.PoseStack.

## 公开成员（2 个）

```java
private PoseStack self()
```
源码 :17 —（无 javadoc）

```java
default void pushTransformation(Transformation transformation)
```
源码 :28 — Pushes and applies the `transformation` to this pose stack. The effects of this method can be reversed by a corresponding PoseStack#popPose() call. @param transformation the transformation to push

