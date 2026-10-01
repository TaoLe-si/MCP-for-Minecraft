# RegisterClientReloadListenersEvent

> `net.minecraftforge.client.event.RegisterClientReloadListenersEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RegisterClientReloadListenersEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired to allow mods to register their reload listeners on the client-side resource manager. This event is fired once during the construction of the Minecraft instance. For registering reload listeners on the server-side resource manager, see AddReloadListenerEvent. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the FMLJavaModLoadingContext#ge…

## 公开成员（2 个）

```java
public RegisterClientReloadListenersEvent(ReloadableResourceManager resourceManager)
```
源码 :35 —（无 javadoc）

```java
public void registerReloadListener(PreparableReloadListener reloadListener)
```
源码 :45 — Registers the given reload listener to the client-side resource manager. @param reloadListener the reload listener

