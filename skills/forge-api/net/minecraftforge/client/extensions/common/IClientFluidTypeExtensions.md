# IClientFluidTypeExtensions

> `net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/extensions/common/IClientFluidTypeExtensions.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：LogicalSide#CLIENT Client-only extensions to FluidType. @see FluidType#initializeClient(Consumer)

## 公开成员（19 个）

```java
static IClientFluidTypeExtensions of(FluidState state)
```
源码 :40 —（无 javadoc）

```java
static IClientFluidTypeExtensions of(Fluid fluid)
```
源码 :45 —（无 javadoc）

```java
static IClientFluidTypeExtensions of(FluidType type)
```
源码 :50 —（无 javadoc）

```java
default int getTintColor()
```
源码 :65 — Returns the tint applied to the fluid's textures. The result represents a 32-bit integer where each 8-bits represent the alpha, red, green, and blue channel respectively. @return the tint applied to the fluid's textures in ARGB format

```java
default ResourceLocation getStillTexture()
```
源码 :82 — Returns the reference of the texture to apply to a source fluid. This should return a reference to the texture and not the actual texture itself (e.g. `minecraft:block/water_still` will point to `assets/minecraft/textures/block/water_still.png`). Important: This method should only return `null` for…

```java
default ResourceLocation getFlowingTexture()
```
源码 :99 — Returns the reference of the texture to apply to a flowing fluid. This should return a reference to the texture and not the actual texture itself (e.g. `minecraft:block/water_flow` will point to `assets/minecraft/textures/block/water_flow.png`). Important: This method should only return `null` for F…

```java
default ResourceLocation getOverlayTexture()
```
源码 :118 —（无 javadoc）

```java
default ResourceLocation getRenderOverlayTexture(Minecraft mc)
```
源码 :151 —（无 javadoc）

```java
default void renderOverlay(Minecraft mc, PoseStack poseStack)
```
源码 :163 — Renders `#getRenderOverlayTexture` onto the camera when within the fluid. @param mc the client instance @param poseStack the transformations representing the current rendering position

```java
default Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor)
```
源码 :185 —（无 javadoc）

```java
default void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape)
```
源码 :202 — Modifies how the fog is currently being rendered when the camera is within a fluid. @param camera the camera instance @param mode the type of fog being rendered @param renderDistance the render distance of the client @param partialTick the delta time of where the current frame is within a tick @para…

```java
default ResourceLocation getStillTexture(FluidState state, BlockAndTintGetter getter, BlockPos pos)
```
源码 :223 — Returns the reference of the texture to apply to a source fluid. This should return a reference to the texture and not the actual texture itself (e.g. `minecraft:block/water_still` will point to `assets/minecraft/textures/block/water_still.png`). Important: This method should only return `null` for…

```java
default ResourceLocation getFlowingTexture(FluidState state, BlockAndTintGetter getter, BlockPos pos)
```
源码 :243 — Returns the reference of the texture to apply to a flowing fluid. This should return a reference to the texture and not the actual texture itself (e.g. `minecraft:block/water_flow` will point to `assets/minecraft/textures/block/water_flow.png`). Important: This method should only return `null` for F…

```java
default ResourceLocation getOverlayTexture(FluidState state, BlockAndTintGetter getter, BlockPos pos)
```
源码 :264 — Returns the reference of the texture to apply to a fluid directly touching a non-opaque block other than air. If no reference is specified, either `#getStillTexture` or `#getFlowingTexture` will be applied instead. This should return a reference to the texture and not the actual texture itself (e.g.…

```java
default int getTintColor(FluidState state, BlockAndTintGetter getter, BlockPos pos)
```
源码 :280 — Returns the tint applied to the fluid's textures. The result represents a 32-bit integer where each 8-bits represent the alpha, red, green, and blue channel respectively. @param state the state of the fluid @param getter the getter the fluid can be obtained from @param pos the position of the fluid…

```java
default int getTintColor(FluidStack stack)
```
源码 :296 — Returns the tint applied to the fluid's textures. The result represents a 32-bit integer where each 8-bits represent the alpha, red, green, and blue channel respectively. @param stack the stack the fluid is in @return the tint applied to the fluid's textures in ARGB format

```java
default ResourceLocation getStillTexture(FluidStack stack)
```
源码 :314 — Returns the reference of the texture to apply to a source fluid. This should return a reference to the texture and not the actual texture itself (e.g. `minecraft:block/water_still` will point to `assets/minecraft/textures/block/water_still.png`). Important: This method should only return `null` for…

```java
default ResourceLocation getFlowingTexture(FluidStack stack)
```
源码 :332 — Returns the reference of the texture to apply to a flowing fluid. This should return a reference to the texture and not the actual texture itself (e.g. `minecraft:block/water_flow` will point to `assets/minecraft/textures/block/water_flow.png`). Important: This method should only return `null` for F…

```java
default ResourceLocation getOverlayTexture(FluidStack stack)
```
源码 :351 — Returns the reference of the texture to apply to a fluid directly touching a non-opaque block other than air. If no reference is specified, either `#getStillTexture` or `#getFlowingTexture` will be applied instead. This should return a reference to the texture and not the actual texture itself (e.g.…

