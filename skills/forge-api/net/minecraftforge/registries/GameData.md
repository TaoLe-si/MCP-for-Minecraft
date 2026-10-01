# GameData

> `net.minecraftforge.registries.GameData` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/GameData.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：INTERNAL ONLY MODDERS SHOULD HAVE NO REASON TO USE THIS CLASS Use the public IForgeRegistry and ForgeRegistries APIs to get the data

## 公开成员（15 个）

```java
public static void init()
```
源码 :99 —（无 javadoc）

```java
public static <T> MappedRegistry<T> getWrapper(ResourceKey<? extends Registry<T>> key, Lifecycle lifecycle)
```
源码 :190 —（无 javadoc）

```java
public static <T> MappedRegistry<T> getWrapper(ResourceKey<? extends Registry<T>> key, Lifecycle lifecycle, String defKey)
```
源码 :199 —（无 javadoc）

```java
public static Map<Block, Item> getBlockItemMap()
```
源码 :209 —（无 javadoc）

```java
public static IdMapper<BlockState> getBlockStateIDMap()
```
源码 :214 —（无 javadoc）

```java
public static Map<BlockState, PoiType> getBlockStatePointOfInterestTypeMap()
```
源码 :219 —（无 javadoc）

```java
public static void vanillaSnapshot()
```
源码 :223 —（无 javadoc）

```java
public static void unfreezeData()
```
源码 :240 —（无 javadoc）

```java
public static void freezeData()
```
源码 :245 —（无 javadoc）

```java
public static void revertToFrozen()
```
源码 :271 —（无 javadoc）

```java
public static void revertTo(final RegistryManager target, boolean fireEvents)
```
源码 :275 —（无 javadoc）

```java
public static void revert(RegistryManager state, ResourceLocation registry, boolean lock)
```
源码 :300 —（无 javadoc）

```java
public static void postRegisterEvents()
```
源码 :308 —（无 javadoc）

```java
public static Multimap<ResourceLocation, ResourceLocation> injectSnapshot(Map<ResourceLocation, ForgeRegistry.Snapshot> snapshot, boolean injectFrozenData, boolean isLocalWorld)
```
源码 :580 —（无 javadoc）

```java
public static ResourceLocation checkPrefix(String name, boolean warnOverrides)
```
源码 :768 — Check a name for a domain prefix, and if not present infer it from the current active mod container. @param name The name or resource location @param warnOverrides If true, logs a warning if domain differs from that of the currently currently active mod container @return The ResourceLocation with gi…

