# LevelEvent

> `net.minecraftforge.event.level.LevelEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/level/LevelEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is fired whenever an event involving a LevelAccessor occurs. All children of this event are fired on the MinecraftForge#EVENT_BUS main Forge event bus.

## 公开成员（7 个）

```java
public LevelEvent(LevelAccessor level)
```
源码 :39 —（无 javadoc）

```java
public LevelAccessor getLevel()
```
源码 :47 — the level this event is affecting

```java
public static class Load extends LevelEvent
```
源码 :62 — This event is fired whenever a level loads. This event is fired whenever a level loads in ClientLevel's constructor and MinecraftServer#createLevels(ChunkProgressListener). This event is not Cancelable cancellable and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_…

```java
public static class Unload extends LevelEvent
```
源码 :80 — This event is fired whenever a level unloads. This event is fired whenever a level unloads in Minecraft#setLevel(ClientLevel), MinecraftServer#stopServer(), Minecraft#clearLevel(Screen), and ForgeInternalHandler#onDimensionUnload(Unload). This event is not Cancelable cancellable and does not HasResu…

```java
public static class Save extends LevelEvent
```
源码 :95 — This event fires whenever a level is saved. This event is fired when a level is saved in ServerLevel#save(ProgressListener,. This event is not Cancelable cancellable and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus only on the LogicalSide…

```java
public static class CreateSpawnPosition extends LevelEvent
```
源码 :113 —（无 javadoc）

```java
public static class PotentialSpawns extends LevelEvent
```
源码 :141 —（无 javadoc）

