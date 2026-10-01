# RenderHandEvent

> `net.minecraftforge.client.event.RenderHandEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RenderHandEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired before a hand is rendered in the first person view. This event is Cancelable cancellable, and does not HasResult have a result. If this event is cancelled, then the hand will not be rendered. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client. @see RenderArmEvent

## 公开成员（10 个）

```java
public RenderHandEvent(InteractionHand hand, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, float partialTick, float interpolatedPitch, float swingProgress, float equipProgress, ItemStack stack)
```
源码 :44 —（无 javadoc）

```java
public InteractionHand getHand()
```
源码 :62 — the hand being rendered

```java
public PoseStack getPoseStack()
```
源码 :70 — the pose stack used for rendering

```java
public MultiBufferSource getMultiBufferSource()
```
源码 :78 — the source of rendering buffers

```java
public int getPackedLight()
```
源码 :88 — the amount of packed (sky and block) light for rendering @see LightTexture

```java
public float getPartialTick()
```
源码 :96 — the partial tick

```java
public float getInterpolatedPitch()
```
源码 :104 — the interpolated pitch of the player entity

```java
public float getSwingProgress()
```
源码 :112 — the swing progress of the hand being rendered

```java
public float getEquipProgress()
```
源码 :120 — the progress of the equip animation, from `0.0` to `1.0`

```java
public ItemStack getItemStack()
```
源码 :128 — the item stack to be rendered

