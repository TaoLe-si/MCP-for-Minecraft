# IForgeBlockAndTintGetter

> `net.minecraftforge.client.extensions.IForgeBlockAndTintGetter` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/extensions/IForgeBlockAndTintGetter.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Extension interface for BlockAndTintGetter.

## 公开成员（2 个）

```java
private BlockAndTintGetter self()
```
源码 :16 —（无 javadoc）

```java
default float getShade(float normalX, float normalY, float normalZ, boolean shade)
```
源码 :25 — Computes the shade for a given normal. Alternate version of the vanilla method taking in a Direction.

