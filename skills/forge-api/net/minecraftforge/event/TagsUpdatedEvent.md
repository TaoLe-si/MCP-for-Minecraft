# TagsUpdatedEvent

> `net.minecraftforge.event.TagsUpdatedEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/TagsUpdatedEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired when tags are updated on either server or client. This event can be used to refresh data that depends on tags.

## 公开成员（5 个）

```java
public TagsUpdatedEvent(RegistryAccess registryAccess, boolean fromClientPacket, boolean isIntegratedServerConnection)
```
源码 :20 —（无 javadoc）

```java
public RegistryAccess getRegistryAccess()
```
源码 :30 — @return The dynamic registries that have had their tags rebound.

```java
public UpdateCause getUpdateCause()
```
源码 :38 — @return the cause for this tag update

```java
public boolean shouldUpdateStaticData()
```
源码 :47 — Whether static data (which in single player is shared between server and client thread) should be updated as a result of this event. Effectively this means that in single player only the server-side updates this data.

```java
public enum UpdateCause
```
源码 :55 — Represents the cause for a tag update.

