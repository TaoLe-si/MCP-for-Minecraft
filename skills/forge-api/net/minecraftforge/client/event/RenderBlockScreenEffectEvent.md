# RenderBlockScreenEffectEvent

> `net.minecraftforge.client.event.RenderBlockScreenEffectEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RenderBlockScreenEffectEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired before a block texture will be overlaid on the player's view. This event is Cancelable cancellable, and does not HasResult have a result. If this event is cancelled, then the overlay will not be rendered. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client.

## 公开成员（7 个）

```java
public enum OverlayType
```
源码 :35 — The type of the block overlay to be rendered. @see RenderBlockScreenEffectEvent

```java
public RenderBlockScreenEffectEvent(Player player, PoseStack poseStack, OverlayType type, BlockState block, BlockPos blockPos)
```
源码 :58 —（无 javadoc）

```java
public Player getPlayer()
```
源码 :70 — the player which the overlay will apply to

```java
public PoseStack getPoseStack()
```
源码 :78 — the pose stack used for rendering

```java
public OverlayType getOverlayType()
```
源码 :86 — the type of the overlay

```java
public BlockState getBlockState()
```
源码 :94 — the block which the overlay is gotten from

```java
public BlockPos getBlockPos()
```
源码 :102 — the position of the block which the overlay is gotten from

