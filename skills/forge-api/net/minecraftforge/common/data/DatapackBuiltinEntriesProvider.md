# DatapackBuiltinEntriesProvider

> `net.minecraftforge.common.data.DatapackBuiltinEntriesProvider` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/data/DatapackBuiltinEntriesProvider.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：An extension of the RegistriesDatapackGenerator which properly handles referencing existing dynamic registry objects within another dynamic registry object.

## 公开成员（2 个）

```java
public DatapackBuiltinEntriesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, Set<String> modIds)
```
源码 :36 — Constructs a new datapack provider which generates all registry objects from the provided mods using the holder. @param output the target directory of the data generator @param registries a future of a lookup for registries and their objects @param modIds a set of mod ids to generate the dynamic reg…

```java
public DatapackBuiltinEntriesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, RegistrySetBuilder datapackEntriesBuilder, Set<String> modIds)
```
源码 :51 — Constructs a new datapack provider which generates all registry objects from the provided mods using the holder. All entries that need to be bootstrapped are provided within the RegistrySetBuilder. @param output the target directory of the data generator @param registries a future of a lookup for re…

