# DataPackRegistriesHooks

> `net.minecraftforge.registries.DataPackRegistriesHooks` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/DataPackRegistriesHooks.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（4 个）

```java
public static Map<ResourceKey<? extends Registry<?>>, RegistrySynchronization.NetworkedRegistryData<?>> grabNetworkableRegistries(ImmutableMap.Builder<ResourceKey<? extends Registry<?>>, RegistrySynchronization.NetworkedRegistryData<?>> builder)
```
源码 :37 —（无 javadoc）

```java
public static List<RegistryDataLoader.RegistryData<?>> getDataPackRegistries()
```
源码 :63 — An unmodifiable view of the list of datapack registries. These registries are loaded from per-world datapacks on server startup.

```java
public static Stream<RegistryDataLoader.RegistryData<?>> getDataPackRegistriesWithDimensions()
```
源码 :68 —（无 javadoc）

```java
public static Set<ResourceKey<? extends Registry<?>>> getSyncedCustomRegistries()
```
源码 :77 — An unmodifiable view of the set of synced non-vanilla datapack registry IDs Clients must have each of a server's synced datapack registries to be able to connect to that server; vanilla clients therefore cannot connect if this list is non-empty on the server.

