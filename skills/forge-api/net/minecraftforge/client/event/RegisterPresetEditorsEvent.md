# RegisterPresetEditorsEvent

> `net.minecraftforge.client.event.RegisterPresetEditorsEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RegisterPresetEditorsEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Event for registering PresetEditor screen factories for world presets. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the FMLJavaModLoadingContext#getModEventBus() mod-specific event bus, only on the LogicalSide#CLIENT logical client.

## 公开成员（2 个）

```java
public RegisterPresetEditorsEvent(Map<ResourceKey<WorldPreset>, PresetEditor> editors)
```
源码 :39 —（无 javadoc）

```java
public void register(ResourceKey<WorldPreset> key, PresetEditor editor)
```
源码 :47 — Registers a PresetEditor for a given world preset key.

