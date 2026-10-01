# PlaySoundSourceEvent

> `net.minecraftforge.client.event.sound.PlaySoundSourceEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/sound/PlaySoundSourceEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired when a non-streaming sound is being played. A non-streaming sound is loaded fully into memory in a buffer before being played, and used for most sounds of short length such as sound effects for clicking buttons. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIE…

## 公开成员（1 个）

```java
public PlaySoundSourceEvent(SoundEngine engine, SoundInstance sound, Channel channel)
```
源码 :32 —（无 javadoc）

