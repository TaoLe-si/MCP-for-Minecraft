# ChunkEvent

> `net.minecraftforge.event.level.ChunkEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/level/ChunkEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：ChunkEvent is fired when an event involving a chunk occurs. If a method utilizes this Event as its parameter, the method will receive every child event of this class. #chunk contains the Chunk this event is affecting. All children of this event are fired on the MinecraftForge#EVENT_BUS.

## 公开成员（5 个）

```java
public ChunkEvent(ChunkAccess chunk)
```
源码 :30 —（无 javadoc）

```java
public ChunkEvent(ChunkAccess chunk, LevelAccessor level)
```
源码 :36 —（无 javadoc）

```java
public ChunkAccess getChunk()
```
源码 :42 —（无 javadoc）

```java
public static class Load extends ChunkEvent
```
源码 :60 — ChunkEvent.Load is fired when vanilla Minecraft attempts to load a Chunk into the level. This event is fired during chunk loading in Chunk.onChunkLoad(). Note: This event may be called before the underlying LevelChunk is promoted to ChunkStatus#FULL. You will cause chunk loading deadlocks if you don…

```java
public static class Unload extends ChunkEvent
```
源码 :95 — ChunkEvent.Unload is fired when vanilla Minecraft attempts to unload a Chunk from the level. This event is fired during chunk unloading in Chunk.onChunkUnload(). This event is not Cancelable. This event does not have a result. HasResult This event is fired on the MinecraftForge#EVENT_BUS.

