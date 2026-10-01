# AttachCapabilitiesEvent

> `net.minecraftforge.event.AttachCapabilitiesEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/AttachCapabilitiesEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired whenever an object with Capabilities support {currently TileEntity/Item/Entity) is created. Allowing for the attachment of arbitrary capability providers. Please note that as this is fired for ALL object creations efficient code is recommended. And if possible use one of the sub-classes to filter your intended objects.

## 公开成员（6 个）

```java
public AttachCapabilitiesEvent(Class<T> type, T obj)
```
源码 :32 —（无 javadoc）

```java
public T getObject()
```
源码 :41 — Retrieves the object that is being created, Not much state is set.

```java
public void addCapability(ResourceLocation key, ICapabilityProvider cap)
```
源码 :54 — Adds a capability to be attached to this object. Keys MUST be unique, it is suggested that you set the domain to your mod ID. If the capability is an instance of INBTSerializable, this key will be used when serializing this capability. @param key The name of owner of this capability provider. @param…

```java
public Map<ResourceLocation, ICapabilityProvider> getCapabilities()
```
源码 :64 — A unmodifiable view of the capabilities that will be attached to this object.

```java
public void addListener(Runnable listener)
```
源码 :74 — Adds a callback that is fired when the attached object is invalidated. Such as a Entity/TileEntity being removed from world. All attached providers should invalidate all of their held capability instances.

```java
public List<Runnable> getListeners()
```
源码 :79 —（无 javadoc）

