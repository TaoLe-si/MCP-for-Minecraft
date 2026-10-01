# ChunkTicketLevelUpdatedEvent

> `net.minecraftforge.event.level.ChunkTicketLevelUpdatedEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/level/ChunkTicketLevelUpdatedEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is fired whenever a chunk has its ticket level changed via the server's ChunkMap. This event does not fire if the new ticket level is the same as the old level, or if both the new AND old ticket levels represent values past the max chunk distance. Due to how vanilla processes ticket level changes this event may be fired "twice" in one tick for the same chunk. The scenario where this hap…

## 公开成员（6 个）

```java
public ChunkTicketLevelUpdatedEvent(ServerLevel level, long chunkPos, int oldTicketLevel, int newTicketLevel, @Nullable ChunkHolder chunkHolder)
```
源码 :41 —（无 javadoc）

```java
public ServerLevel getLevel()
```
源码 :53 — the server level containing the chunk

```java
public long getChunkPos()
```
源码 :61 — the long representation of the chunk position the ticket level changed for

```java
public int getOldTicketLevel()
```
源码 :69 — the previous ticket level the chunk had

```java
public int getNewTicketLevel()
```
源码 :77 — the new ticket level for the chunk

```java
public ChunkHolder getChunkHolder()
```
源码 :86 —（无 javadoc）

