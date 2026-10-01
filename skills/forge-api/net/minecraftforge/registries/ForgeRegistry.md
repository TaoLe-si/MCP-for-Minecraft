# ForgeRegistry

> `net.minecraftforge.registries.ForgeRegistry` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/ForgeRegistry.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Internal - use the public IForgeRegistry and ForgeRegistries APIs to get the data

## 公开成员（46 个）

```java
public static final Marker REGISTRIES = MarkerManager.getMarker("REGISTRIES")
```
源码 :67 —（无 javadoc）

```java
public void register(String key, V value)
```
源码 :131 —（无 javadoc）

```java
public void register(ResourceLocation key, V value)
```
源码 :136 —（无 javadoc）

```java
public Iterator<V> iterator()
```
源码 :141 —（无 javadoc）

```java
public ResourceLocation getRegistryName()
```
源码 :166 —（无 javadoc）

```java
public ResourceKey<Registry<V>> getRegistryKey()
```
源码 :171 —（无 javadoc）

```java
public Codec<V> getCodec()
```
源码 :176 —（无 javadoc）

```java
public boolean containsKey(ResourceLocation key)
```
源码 :181 —（无 javadoc）

```java
public boolean containsValue(V value)
```
源码 :191 —（无 javadoc）

```java
public boolean isEmpty()
```
源码 :196 —（无 javadoc）

```java
public V getValue(ResourceLocation key)
```
源码 :205 —（无 javadoc）

```java
public ResourceLocation getKey(V value)
```
源码 :216 —（无 javadoc）

```java
public Optional<ResourceKey<V>> getResourceKey(V value)
```
源码 :222 —（无 javadoc）

```java
public Optional<Holder<V>> getHolder(ResourceKey<V> key)
```
源码 :255 —（无 javadoc）

```java
public Optional<Holder<V>> getHolder(ResourceLocation location)
```
源码 :261 —（无 javadoc）

```java
public Optional<Holder<V>> getHolder(V value)
```
源码 :267 —（无 javadoc）

```java
public ITagManager<V> tags()
```
源码 :273 —（无 javadoc）

```java
public Set<ResourceLocation> getKeys()
```
源码 :279 —（无 javadoc）

```java
public Collection<V> getValues()
```
源码 :290 —（无 javadoc）

```java
public Set<Entry<ResourceKey<V>, V>> getEntries()
```
源码 :296 —（无 javadoc）

```java
public <T> T getSlaveMap(ResourceLocation name, Class<T> type)
```
源码 :302 —（无 javadoc）

```java
public void setSlaveMap(ResourceLocation name, Object obj)
```
源码 :308 —（无 javadoc）

```java
public int getID(V value)
```
源码 :312 —（无 javadoc）

```java
public int getID(ResourceLocation name)
```
源码 :319 —（无 javadoc）

```java
public V getValue(int id)
```
源码 :333 —（无 javadoc）

```java
public ResourceKey<V> getKey(int id)
```
源码 :339 —（无 javadoc）

```java
public ResourceLocation getDefaultKey()
```
源码 :350 —（无 javadoc）

```java
public void register(int id, ResourceLocation key, V value)
```
源码 :359 —（无 javadoc）

```java
public V getRaw(ResourceLocation key)
```
源码 :433 —（无 javadoc）

```java
public void addAlias(ResourceLocation src, ResourceLocation dst)
```
源码 :451 — Adds an alias that maps from the name specified by src to the name specified by dst. Any registry lookups that target the first name will resolve as the second name, if the first name is not present. @param src The source registry name to alias from. @param dst The target registry name to alias to.…

```java
public Optional<Holder.Reference<V>> getDelegate(ResourceKey<V> rkey)
```
源码 :466 —（无 javadoc）

```java
public Holder.Reference<V> getDelegateOrThrow(ResourceKey<V> rkey)
```
源码 :472 —（无 javadoc）

```java
public Optional<Holder.Reference<V>> getDelegate(ResourceLocation key)
```
源码 :478 —（无 javadoc）

```java
public Holder.Reference<V> getDelegateOrThrow(ResourceLocation key)
```
源码 :484 —（无 javadoc）

```java
public Optional<Holder.Reference<V>> getDelegate(V value)
```
源码 :490 —（无 javadoc）

```java
public Holder.Reference<V> getDelegateOrThrow(V value)
```
源码 :496 —（无 javadoc）

```java
public void bake()
```
源码 :560 —（无 javadoc）

```java
public void clear()
```
源码 :629 —（无 javadoc）

```java
public V remove(ResourceLocation key)
```
源码 :649 —（无 javadoc）

```java
public boolean isLocked()
```
源码 :678 —（无 javadoc）

```java
public void freeze()
```
源码 :686 — Used to control the times where people can modify this registry. Users should only ever register things in the Register events!

```java
public void unfreeze()
```
源码 :693 —（无 javadoc）

```java
public void loadIds(Object2IntMap<ResourceLocation> ids, Map<ResourceLocation, String> overrides, Object2IntMap<ResourceLocation> missing, Map<ResourceLocation, IdMappingEvent.IdRemapping> remapped, ForgeRegistry<V> old, ResourceLocation name)
```
源码 :723 —（无 javadoc）

```java
public Snapshot makeSnapshot()
```
源码 :797 —（无 javadoc）

```java
public static class Snapshot
```
源码 :846 —（无 javadoc）

```java
public MissingMappingsEvent getMissingEvent(ResourceLocation name, Object2IntMap<ResourceLocation> map)
```
源码 :947 —（无 javadoc）

