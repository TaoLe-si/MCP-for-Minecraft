# IForgeBlockEntity

> `net.minecraftforge.common.extensions.IForgeBlockEntity` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeBlockEntity.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（10 个）

```java
private BlockEntity self() { return (BlockEntity) this; } @Override default void deserializeNBT(CompoundTag nbt)
```
源码 :30 —（无 javadoc）

```java
default CompoundTag serializeNBT()
```
源码 :39 —（无 javadoc）

```java
default void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt)
```
源码 :53 — Called when you receive a TileEntityData packet for the location this TileEntity is currently in. On the client, the NetworkManager will always be the remote server. On the server, it will be whomever is responsible for sending the packet. @param net The NetworkManager the packet originated from @pa…

```java
default void handleUpdateTag(CompoundTag tag)
```
源码 :68 — Called when the chunk's TE update tag, gotten from BlockEntity#getUpdateTag(), is received on the client. Used to handle this tag in a special way. By default this simply calls BlockEntity#load(CompoundTag). @param tag The CompoundTag sent from BlockEntity#getUpdateTag()

```java
CompoundTag getPersistentData()
```
源码 :79 — Gets a CompoundTag that can be used to store custom data for this block entity. It will be written, and read from disc, so it persists over world saves. @return A compound tag for custom persistent data

```java
default void onChunkUnloaded(){} /** * Called when this is first added to the world (by {@link LevelChunk#addAndRegisterBlockEntity(BlockEntity)}) * or right before the first tick when the chunk is generated or loaded from disk. * Override instead of adding {@code if (firstTick)} stuff in update. */ default void onLoad()
```
源码 :81 —（无 javadoc）

```java
public static final AABB INFINITE_EXTENT_AABB = new net.minecraft.world.phys.AABB(Double.NEGA…
```
源码 :96 — Sometimes default render bounding box: infinite in scope. Used to control rendering on BlockEntityWithoutLevelRenderer.

```java
default AABB getRenderBoundingBox()
```
源码 :105 — Return an AABB that controls the visible scope of a BlockEntityWithoutLevelRenderer associated with this BlockEntity Defaults to the collision bounding box BlockState#getCollisionShape(BlockGetter, associated with the block at this location. @return an appropriately size AABB for the BlockEntity

```java
default void requestModelDataUpdate()
```
源码 :153 — Requests a refresh for the model data of your TE Call this every time your #getModelData() changes

```java
default boolean hasCustomOutlineRendering(Player player)
```
源码 :185 — Returns whether this BlockEntity has custom outline rendering behavior. @param player the local player currently viewing this `BlockEntity` @return `true` to enable outline processing

