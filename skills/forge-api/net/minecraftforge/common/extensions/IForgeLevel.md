# IForgeLevel

> `net.minecraftforge.common.extensions.IForgeLevel` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeLevel.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（3 个）

```java
public double getMaxEntityRadius()
```
源码 :20 — The maximum radius to scan for entities when trying to check bounding boxes. Vanilla's default is 2.0D But mods that add larger entities may increase this.

```java
public double increaseMaxEntityRadius(double value)
```
源码 :28 — Increases the max entity radius, this is safe to call with any value. The setter will verify the input value is larger then the current setting. @param value New max radius to set. @return The new max radius

```java
public default Collection<PartEntity<?>> getPartEntities()
```
源码 :33 — All part entities in this world. Used when collecting entities in an AABB to fix parts being ignored whose parent entity is in a chunk that does not intersect with the AABB.

