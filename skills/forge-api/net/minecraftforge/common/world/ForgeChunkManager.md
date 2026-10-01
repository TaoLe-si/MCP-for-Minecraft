# ForgeChunkManager

> `net.minecraftforge.common.world.ForgeChunkManager` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/world/ForgeChunkManager.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（12 个）

```java
public static void setForcedChunkLoadingCallback(String modId, LoadingValidationCallback callback)
```
源码 :52 — Sets the forced chunk loading validation callback for the given mod. This allows for validating and removing no longer valid tickets on level load. @apiNote This method should be called from a net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent using one of the net.minecraftforge.fml.event.li…

```java
public static boolean hasForcedChunks(ServerLevel level)
```
源码 :63 — Checks if a level has any forced chunks. Mainly used for seeing if a level should continue ticking with no players in it.

```java
public static boolean forceChunk(ServerLevel level, String modId, BlockPos owner, int chunkX, int chunkZ, boolean add, boolean ticking)
```
源码 :76 — Forces a chunk to be loaded for the given mod with the "owner" of the ticket being a given block position. @param add `true` to force the chunk, `false` to unforce the chunk. @param ticking `true` to make the chunk receive full chunk ticks even if there is no player nearby.

```java
public static boolean forceChunk(ServerLevel level, String modId, Entity owner, int chunkX, int chunkZ, boolean add, boolean ticking)
```
源码 :87 — Forces a chunk to be loaded for the given mod with the "owner" of the ticket being the UUID of the given entity. @param add `true` to force the chunk, `false` to unforce the chunk. @param ticking `true` to make the chunk receive full chunk ticks even if there is no player nearby.

```java
public static boolean forceChunk(ServerLevel level, String modId, UUID owner, int chunkX, int chunkZ, boolean add, boolean ticking)
```
源码 :98 — Forces a chunk to be loaded for the given mod with the "owner" of the ticket being a given UUID. @param add `true` to force the chunk, `false` to unforce the chunk. @param ticking `true` to make the chunk receive full chunk ticks even if there is no player nearby.

```java
public static void reinstatePersistentChunks(ServerLevel level, ForcedChunksSavedData saveData)
```
源码 :166 — Reinstates forge's forced chunks when vanilla initially loads a level and reinstates their forced chunks. This method also will validate all of forge's forced chunks using and registered LoadingValidationCallback. @apiNote Internal

```java
public static void writeForgeForcedChunks(CompoundTag nbt, TicketTracker<BlockPos> blockForcedChunks, TicketTracker<UUID> entityForcedChunks)
```
源码 :239 — Writes the forge forced chunks into the NBT compound. Format is List{modid, List{ChunkPos, List{BlockPos}, List{UUID}}} @apiNote Internal

```java
public static void readForgeForcedChunks(CompoundTag nbt, TicketTracker<BlockPos> blockForcedChunks, TicketTracker<UUID> entityForcedChunks)
```
源码 :295 — Reads the forge forced chunks from the NBT compound. Format is List{modid, List{ChunkPos, List{BlockPos}, List{UUID}}} @apiNote Internal

```java
public interface LoadingValidationCallback
```
源码 :347 —（无 javadoc）

```java
public static class TicketHelper
```
源码 :360 — Class to help mods remove no longer valid tickets.

```java
public static class TicketOwner<T extends Comparable<? super T>> implements Comparable<TicketOwner<T>>
```
源码 :465 — Helper class to keep track of a ticket owner by modid and owner object

```java
public static class TicketTracker<T extends Comparable<? super T>>
```
源码 :502 — Helper class to manage tracking and handling loaded tickets.

