# RegisterTextureAtlasSpriteLoadersEvent

> `net.minecraftforge.client.event.RegisterTextureAtlasSpriteLoadersEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RegisterTextureAtlasSpriteLoadersEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Allows users to register custom ITextureAtlasSpriteLoader. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the FMLJavaModLoadingContext#getModEventBus() mod-specific event bus, only on the LogicalSide#CLIENT logical client.

## 公开成员（2 个）

```java
public RegisterTextureAtlasSpriteLoadersEvent(Map<ResourceLocation, ITextureAtlasSpriteLoader> loaders)
```
源码 :34 —（无 javadoc）

```java
public void register(String name, ITextureAtlasSpriteLoader loader)
```
源码 :42 — Registers a custom ITextureAtlasSpriteLoader.

