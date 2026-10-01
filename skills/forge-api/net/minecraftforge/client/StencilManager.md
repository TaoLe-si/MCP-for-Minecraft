# StencilManager

> `net.minecraftforge.client.StencilManager` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/StencilManager.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（2 个）

```java
public static int reserveBit()
```
源码 :22 — Reserve a stencil bit for use in rendering Note: you must check the com.mojang.blaze3d.pipeline.RenderTarget you are working with to determine if stencil bits are enabled on it before use. @return A bit, or -1 if no further stencil bits are available

```java
public static void releaseBit(int bit)
```
源码 :35 — Release the stencil bit for other use @param bit The bit obtained from #reserveBit()

