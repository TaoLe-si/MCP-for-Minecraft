# AddReloadListenerEvent

> `net.minecraftforge.event.AddReloadListenerEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/AddReloadListenerEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：The main ResourceManager is recreated on each reload, just after ReloadableServerResources's creation. The event is fired on each reload and lets modders add their own ReloadListeners, for server-side resources. The event is fired on the MinecraftForge#EVENT_BUS

## 公开成员（6 个）

```java
public AddReloadListenerEvent(ReloadableServerResources serverResources, RegistryAccess registryAccess)
```
源码 :38 —（无 javadoc）

```java
public void addListener(PreparableReloadListener listener)
```
源码 :47 — @param listener the listener to add to the ResourceManager on reload

```java
public List<PreparableReloadListener> getListeners()
```
源码 :52 —（无 javadoc）

```java
public ReloadableServerResources getServerResources()
```
源码 :60 — @return The ReloableServerResources being reloaded.

```java
public ICondition.IContext getConditionContext()
```
源码 :69 — This context object holds data relevant to the current reload, such as staged tags. @return The condition context for the currently active reload.

```java
public RegistryAccess getRegistryAccess()
```
源码 :79 — Provides access to the loaded registries associated with these server resources. All built-in and dynamic registries are loaded and frozen by this point. @return The RegistryAccess context for the currently active reload.

