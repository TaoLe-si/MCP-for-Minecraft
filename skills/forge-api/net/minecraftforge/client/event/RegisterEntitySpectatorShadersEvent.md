# RegisterEntitySpectatorShadersEvent

> `net.minecraftforge.client.event.RegisterEntitySpectatorShadersEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RegisterEntitySpectatorShadersEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Allows users to register custom shaders to be used when the player spectates a certain kind of entity. Vanilla examples of this are the green effect for creepers and the invert effect for endermen. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the FMLJavaModLoadingContext#getModEventBus() mod-specific event bus, only on the LogicalSide#CLIEN…

## 公开成员（2 个）

```java
public RegisterEntitySpectatorShadersEvent(Map<EntityType<?>, ResourceLocation> shaders)
```
源码 :33 —（无 javadoc）

```java
public void register(EntityType<?> entityType, ResourceLocation shader)
```
源码 :41 — Registers a spectator shader for a given entity type.

