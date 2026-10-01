# IForgeDimensionSpecialEffects

> `net.minecraftforge.client.extensions.IForgeDimensionSpecialEffects` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/extensions/IForgeDimensionSpecialEffects.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Extension interface for DimensionSpecialEffects.

## 公开成员（6 个）

```java
private DimensionSpecialEffects self()
```
源码 :21 —（无 javadoc）

```java
default boolean renderClouds(ClientLevel level, int ticks, float partialTick, PoseStack poseStack, double camX, double camY, double camZ, Matrix4f projectionMatrix)
```
源码 :31 — Renders the clouds of this dimension. @return true to prevent vanilla cloud rendering

```java
default boolean renderSky(ClientLevel level, int ticks, float partialTick, PoseStack poseStack, Camera camera, Matrix4f projectionMatrix, boolean isFoggy, Runnable setupFog)
```
源码 :41 — Renders the sky of this dimension. @return true to prevent vanilla sky rendering

```java
default boolean renderSnowAndRain(ClientLevel level, int ticks, float partialTick, LightTexture lightTexture, double camX, double camY, double camZ)
```
源码 :51 — Renders the snow and rain effects of this dimension. @return true to prevent vanilla snow and rain rendering

```java
default boolean tickRain(ClientLevel level, int ticks, Camera camera)
```
源码 :61 — Ticks the rain of this dimension. @return true to prevent vanilla rain ticking

```java
default void adjustLightmapColors(ClientLevel level, float partialTicks, float skyDarken, float blockLightRedFlicker, float skyLight, int pixelX, int pixelY, Vector3f colors) {} }
```
源码 :80 — Allows for manipulating the coloring of the lightmap texture. Will be called for each 16*16 combination of sky/block light values. @param level The current level (client-side). @param partialTicks Progress between ticks. @param skyDarken Current darkness of the sky (can be used to calculate sky ligh…

