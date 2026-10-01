# TextureStitchEvent

> `net.minecraftforge.client.event.TextureStitchEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/TextureStitchEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired after a texture atlas is stitched together. @see TextureStitchEvent.Post @see TextureAtlas

## 公开成员（3 个）

```java
public TextureStitchEvent(TextureAtlas atlas)
```
源码 :29 —（无 javadoc）

```java
public TextureAtlas getAtlas()
```
源码 :37 — the texture atlas

```java
public static class Post extends TextureStitchEvent
```
源码 :85 — Fired after a texture atlas is stitched together and all textures therein has been loaded. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the FMLJavaModLoadingContext#getModEventBus() mod-specific event bus}, only on the LogicalSide#CLIENT logi…

