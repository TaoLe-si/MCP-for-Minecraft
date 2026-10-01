# RegisterColorHandlersEvent

> `net.minecraftforge.client.event.RegisterColorHandlersEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RegisterColorHandlersEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired for registering block and item color handlers at the appropriate time. See the two subclasses for registering block or item color handlers. These events are fired on the FMLJavaModLoadingContext#getModEventBus() mod-specific event bus, only on the LogicalSide#CLIENT logical client. @see RegisterColorHandlersEvent.Block @see RegisterColorHandlersEvent.Item

## 公开成员（4 个）

```java
protected RegisterColorHandlersEvent()
```
源码 :36 —（无 javadoc）

```java
public static class Block extends RegisterColorHandlersEvent
```
源码 :48 — Fired for registering block color handlers. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the FMLJavaModLoadingContext#getModEventBus() mod-specific event bus, only on the LogicalSide#CLIENT logical client.

```java
public static class Item extends RegisterColorHandlersEvent
```
源码 :91 — Fired for registering item color handlers. The block colors should only be used for referencing or delegating item colors to their respective block colors. Use RegisterColorHandlersEvent.Block for registering your block color handlers. This event is not Cancelable cancellable, and does not HasResult…

```java
public static class ColorResolvers extends RegisterColorHandlersEvent
```
源码 :138 — Allows registration of custom ColorResolver implementations to be used with net.minecraft.world.level.BlockAndTintGetter#getBlockTint(BlockPos,.

