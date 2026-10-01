# NamespacedWrapper

> `net.minecraftforge.registries.NamespacedWrapper` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/NamespacedWrapper.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（36 个）

```java
public Holder.Reference<T> registerMapping(int id, ResourceKey<T> key, T value, Lifecycle lifecycle)
```
源码 :72 —（无 javadoc）

```java
public Holder.Reference<T> register(ResourceKey<T> key, T value, Lifecycle lifecycle)
```
源码 :89 —（无 javadoc）

```java
public T get(@Nullable ResourceLocation name)
```
源码 :97 —（无 javadoc）

```java
public Optional<T> getOptional(@Nullable ResourceLocation name)
```
源码 :103 —（无 javadoc）

```java
public T get(@Nullable ResourceKey<T> name)
```
源码 :110 —（无 javadoc）

```java
public ResourceLocation getKey(T value)
```
源码 :117 —（无 javadoc）

```java
public Optional<ResourceKey<T>> getResourceKey(T p_122755_)
```
源码 :123 —（无 javadoc）

```java
public boolean containsKey(ResourceLocation key)
```
源码 :129 —（无 javadoc）

```java
public boolean containsKey(ResourceKey<T> key)
```
源码 :135 —（无 javadoc）

```java
public int getId(@Nullable T value)
```
源码 :141 —（无 javadoc）

```java
public T byId(int id)
```
源码 :148 —（无 javadoc）

```java
public Lifecycle lifecycle(T value)
```
源码 :154 —（无 javadoc）

```java
public Lifecycle registryLifecycle()
```
源码 :160 —（无 javadoc）

```java
public Iterator<T> iterator()
```
源码 :166 —（无 javadoc）

```java
public Set<ResourceLocation> keySet()
```
源码 :172 —（无 javadoc）

```java
public Set<ResourceKey<T>> registryKeySet()
```
源码 :178 —（无 javadoc）

```java
public Set<Map.Entry<ResourceKey<T>, T>> entrySet()
```
源码 :184 —（无 javadoc）

```java
public boolean isEmpty()
```
源码 :190 —（无 javadoc）

```java
public int size()
```
源码 :196 —（无 javadoc）

```java
public void lock()
```
源码 :206 —（无 javadoc）

```java
public Optional<Holder.Reference<T>> getHolder(int id)
```
源码 :212 —（无 javadoc）

```java
public Optional<Holder.Reference<T>> getHolder(ResourceKey<T> key)
```
源码 :218 —（无 javadoc）

```java
public @NotNull Holder<T> wrapAsHolder(@NotNull T value)
```
源码 :224 —（无 javadoc）

```java
public HolderGetter<T> createRegistrationLookup()
```
源码 :241 —（无 javadoc）

```java
public Optional<Holder.Reference<T>> getRandom(RandomSource rand)
```
源码 :296 —（无 javadoc）

```java
public Stream<Holder.Reference<T>> holders()
```
源码 :302 —（无 javadoc）

```java
public Stream<Pair<TagKey<T>, HolderSet.Named<T>>> getTags()
```
源码 :308 —（无 javadoc）

```java
public HolderSet.Named<T> getOrCreateTag(TagKey<T> name)
```
源码 :314 —（无 javadoc）

```java
public Stream<TagKey<T>> getTagNames()
```
源码 :335 —（无 javadoc）

```java
public Registry<T> freeze()
```
源码 :342 —（无 javadoc）

```java
public Holder.Reference<T> createIntrusiveHolder(T value)
```
源码 :360 —（无 javadoc）

```java
public Optional<HolderSet.Named<T>> getTag(TagKey<T> name)
```
源码 :371 —（无 javadoc）

```java
public void bindTags(Map<TagKey<T>, List<Holder<T>>> newTags)
```
源码 :377 —（无 javadoc）

```java
public void resetTags()
```
源码 :421 —（无 javadoc）

```java
public void unfreeze()
```
源码 :428 —（无 javadoc）

```java
public static class Factory<V> implements IForgeRegistry.CreateCallback<V>, IForgeRegistry.AddCallback<V>
```
源码 :492 —（无 javadoc）

