# AnyHolderSet

> `net.minecraftforge.registries.holdersets.AnyHolderSet` · record · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/holdersets/AnyHolderSet.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Holderset that represents all elements of a registry. Json format: { "type": "forge:any" }

## 公开成员（12 个）

```java
public static <T> Codec<? extends ICustomHolderSet<T>> codec(ResourceKey<? extends Registry<T>> registryKey, Codec<Holder<T>> holderCodec, boolean forceList)
```
源码 :39 —（无 javadoc）

```java
public HolderSetType type()
```
源码 :47 —（无 javadoc）

```java
public Iterator<Holder<T>> iterator()
```
源码 :53 —（无 javadoc）

```java
public Stream<Holder<T>> stream()
```
源码 :59 —（无 javadoc）

```java
public int size()
```
源码 :65 —（无 javadoc）

```java
public Either<TagKey<T>, List<Holder<T>>> unwrap()
```
源码 :71 —（无 javadoc）

```java
public Optional<Holder<T>> getRandomElement(RandomSource random)
```
源码 :77 —（无 javadoc）

```java
public Holder<T> get(int i)
```
源码 :83 —（无 javadoc）

```java
public boolean contains(Holder<T> holder)
```
源码 :94 —（无 javadoc）

```java
public boolean canSerializeIn(HolderOwner<T> holderOwner)
```
源码 :100 —（无 javadoc）

```java
public Optional<TagKey<T>> unwrapKey()
```
源码 :106 —（无 javadoc）

```java
public String toString()
```
源码 :112 —（无 javadoc）

