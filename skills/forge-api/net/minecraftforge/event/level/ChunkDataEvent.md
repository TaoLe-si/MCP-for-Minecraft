# ChunkDataEvent

> `net.minecraftforge.event.level.ChunkDataEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/level/ChunkDataEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：ChunkDataEvent is fired when an event involving chunk data occurs. If a method utilizes this Event as its parameter, the method will receive every child event of this class. #data contains the NBTTagCompound containing the chunk data for this event. All children of this event are fired on the MinecraftForge#EVENT_BUS.

## 公开成员（5 个）

```java
public ChunkDataEvent(ChunkAccess chunk, CompoundTag data)
```
源码 :33 —（无 javadoc）

```java
public ChunkDataEvent(ChunkAccess chunk, LevelAccessor world, CompoundTag data)
```
源码 :39 —（无 javadoc）

```java
public CompoundTag getData()
```
源码 :45 —（无 javadoc）

```java
public static class Load extends ChunkDataEvent
```
源码 :61 — ChunkDataEvent.Load is fired when vanilla Minecraft attempts to load Chunk data. This event is fired during chunk loading in ChunkSerializer#read(ServerLevel, which means it is async, so be careful. This event is not Cancelable. This event does not have a result. HasResult This event is fired on the…

```java
public static class Save extends ChunkDataEvent
```
源码 :88 — ChunkDataEvent.Save is fired when vanilla Minecraft attempts to save Chunk data. This event is fired during chunk saving in `ChunkMap#save(ChunkAccess)`. This event is not Cancelable. This event does not have a result. HasResult This event is fired on the MinecraftForge#EVENT_BUS.

