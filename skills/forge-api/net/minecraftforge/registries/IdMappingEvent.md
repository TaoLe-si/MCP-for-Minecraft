# IdMappingEvent

> `net.minecraftforge.registries.IdMappingEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/IdMappingEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Called whenever the ID mapping might have changed. If you register for this event, you will be called back whenever the client or server loads an ID set. This includes both when the ID maps are loaded from disk, as well as when the ID maps revert to the initial state. Note: you cannot change the IDs that have been allocated, but you might want to use this event to update caches or other in-mod art…

## 公开成员（6 个）

```java
public static class ModRemapping
```
源码 :33 —（无 javadoc）

```java
public record IdRemapping(int currId, int newId) {} private final Map<ResourceLocation, ImmutableList<ModRemapping>> remaps
```
源码 :49 —（无 javadoc）

```java
public IdMappingEvent(Map<ResourceLocation, Map<ResourceLocation, IdRemapping>> remaps, boolean isFrozen)
```
源码 :56 —（无 javadoc）

```java
public ImmutableSet<ResourceLocation> getRegistries()
```
源码 :70 —（无 javadoc）

```java
public ImmutableList<ModRemapping> getRemaps(ResourceLocation registry)
```
源码 :75 —（无 javadoc）

```java
public boolean isFrozen()
```
源码 :80 —（无 javadoc）

