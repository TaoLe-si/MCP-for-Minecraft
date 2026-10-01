# SoundEngineLoadEvent

> `net.minecraftforge.client.event.sound.SoundEngineLoadEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/sound/SoundEngineLoadEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired when the SoundEngine is constructed or (re)loaded, such as during game initialization or when the sound output device is changed. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the FMLJavaModLoadingContext#getModEventBus() mod-specific event bus, only on the LogicalSide#CLIENT logical client.

## 公开成员（1 个）

```java
public SoundEngineLoadEvent(SoundEngine manager)
```
源码 :27 —（无 javadoc）

