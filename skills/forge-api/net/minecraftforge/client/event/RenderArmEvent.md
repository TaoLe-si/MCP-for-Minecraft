# RenderArmEvent

> `net.minecraftforge.client.event.RenderArmEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RenderArmEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired before the player's arm is rendered in first person. This is a more targeted version of RenderHandEvent, and can be used to replace the rendering of the player's arm, such as for rendering armor on the arm or outright replacing the arm with armor. This event is Cancelable cancellable, and does not HasResult have a result. If this event is cancelled, then the arm will not be rendered. This ev…

## 公开成员（6 个）

```java
public RenderArmEvent(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, AbstractClientPlayer player, HumanoidArm arm)
```
源码 :40 —（无 javadoc）

```java
public HumanoidArm getArm()
```
源码 :52 — the arm being rendered

```java
public PoseStack getPoseStack()
```
源码 :60 — the pose stack used for rendering

```java
public MultiBufferSource getMultiBufferSource()
```
源码 :68 — the source of rendering buffers

```java
public int getPackedLight()
```
源码 :78 — the amount of packed (sky and block) light for rendering @see LightTexture

```java
public AbstractClientPlayer getPlayer()
```
源码 :87 — the client player that is having their arm rendered In general, this will be the same as net.minecraft.client.Minecraft#player.

