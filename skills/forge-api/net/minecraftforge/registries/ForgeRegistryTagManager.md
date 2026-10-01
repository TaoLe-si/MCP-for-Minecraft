# ForgeRegistryTagManager

> `net.minecraftforge.registries.ForgeRegistryTagManager` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/ForgeRegistryTagManager.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（9 个）

```java
public ITag<V> getTag(@NotNull TagKey<V> name)
```
源码 :52 —（无 javadoc）

```java
public Optional<IReverseTag<V>> getReverseTag(@NotNull V value)
```
源码 :75 —（无 javadoc）

```java
public boolean isKnownTagName(@NotNull TagKey<V> name)
```
源码 :83 —（无 javadoc）

```java
public Iterator<ITag<V>> iterator()
```
源码 :92 —（无 javadoc）

```java
public Stream<ITag<V>> stream()
```
源码 :99 —（无 javadoc）

```java
public Stream<TagKey<V>> getTagNames()
```
源码 :106 —（无 javadoc）

```java
public TagKey<V> createTagKey(@NotNull ResourceLocation location)
```
源码 :113 —（无 javadoc）

```java
public TagKey<V> createOptionalTagKey(@NotNull ResourceLocation location, @NotNull Set<? extends Supplier<V>> defaults)
```
源码 :121 —（无 javadoc）

```java
public void addOptionalTagDefaults(@NotNull TagKey<V> name, @NotNull Set<? extends Supplier<V>> defaults)
```
源码 :131 —（无 javadoc）

