# SoundEvent

> `net.minecraftforge.client.event.sound.SoundEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/sound/SoundEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Superclass for sound related events. These events are fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client. @see SoundSourceEvent @see PlaySoundEvent @see SoundEngineLoadEvent

## 公开成员（3 个）

```java
protected SoundEvent(SoundEngine engine)
```
源码 :31 —（无 javadoc）

```java
public SoundEngine getEngine()
```
源码 :39 — the sound engine

```java
public static abstract class SoundSourceEvent extends SoundEvent
```
源码 :53 — Superclass for when a sound has started to play on an audio channel. These events are fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client. @see PlaySoundSourceEvent @see PlayStreamingSourceEvent

