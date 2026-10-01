# ChunkWatchEvent

> `net.minecraftforge.event.level.ChunkWatchEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/level/ChunkWatchEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is fired whenever a chunk has a watch-related action. The #getPlayer() player's level may not be the same as the #getLevel() level of the chunk when the player is teleporting to another dimension. This event is not Cancelable cancellable and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus only on the LogicalSide#SERVER logical s…

## 公开成员（6 个）

```java
public ChunkWatchEvent(ServerPlayer player, ChunkPos pos, ServerLevel level)
```
源码 :34 —（无 javadoc）

```java
public ServerPlayer getPlayer()
```
源码 :44 — the server player involved with the watch action

```java
public ChunkPos getPos()
```
源码 :52 — the chunk position this watch event is affecting

```java
public ServerLevel getLevel()
```
源码 :60 — the server level containing the chunk

```java
public static class Watch extends ChunkWatchEvent
```
源码 :79 — This event is fired whenever a ServerPlayer begins watching a chunk. This event is fired when a chunk is added to the watched chunks of a ServerPlayer and the chunk's data is sent to the client (see `net.minecraft.server.level.ChunkMap#playerLoadedChunk(ServerPlayer, MutableObject, LevelChunk)`). Th…

```java
public static class UnWatch extends ChunkWatchEvent
```
源码 :106 — This event is fired whenever a ServerPlayer stops watching a chunk. This event is fired when a chunk is removed from the watched chunks of an ServerPlayer in `net.minecraft.server.level.ChunkMap#updateChunkTracking(ServerPlayer, ChunkPos, Packet[], boolean, boolean)`. This event is not Cancelable ca…

