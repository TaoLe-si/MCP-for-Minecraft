# PlayStreamingSourceEvent

> `net.minecraftforge.client.event.sound.PlayStreamingSourceEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/sound/PlayStreamingSourceEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired when a streaming sound is being played. A streaming sound is streamed directly from its source (such as a file), and used for sounds of long length which are unsuitable to keep fully loaded in-memory in a buffer (as is done for regular non-streaming sounds), such as background music or music discs. This event is not Cancelable cancellable, and does not HasResult have a result. This event is…

## 公开成员（1 个）

```java
public PlayStreamingSourceEvent(SoundEngine engine, SoundInstance sound, Channel channel)
```
源码 :32 —（无 javadoc）

