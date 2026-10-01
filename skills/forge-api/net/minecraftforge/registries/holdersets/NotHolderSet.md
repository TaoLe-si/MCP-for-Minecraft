# NotHolderSet

> `net.minecraftforge.registries.holdersets.NotHolderSet` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/holdersets/NotHolderSet.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（14 个）

```java
public static <T> Codec<? extends ICustomHolderSet<T>> codec(ResourceKey<? extends Registry<T>> registryKey, Codec<Holder<T>> holderCodec, boolean forceList)
```
源码 :47 —（无 javadoc）

```java
public HolderLookup.RegistryLookup<T> registryLookup() { return this.registryLookup; } public HolderSet<T> value() { return this.value; } public NotHolderSet(HolderLookup.RegistryLookup<T> registryLookup, HolderSet<T> value)
```
源码 :61 —（无 javadoc）

```java
public HolderSetType type()
```
源码 :72 —（无 javadoc）

```java
public void addInvalidationListener(Runnable runnable)
```
源码 :78 —（无 javadoc）

```java
public Iterator<Holder<T>> iterator()
```
源码 :84 —（无 javadoc）

```java
public Stream<Holder<T>> stream()
```
源码 :90 —（无 javadoc）

```java
public int size()
```
源码 :96 —（无 javadoc）

```java
public Either<TagKey<T>, List<Holder<T>>> unwrap()
```
源码 :102 —（无 javadoc）

```java
public Optional<Holder<T>> getRandomElement(RandomSource random)
```
源码 :108 —（无 javadoc）

```java
public Holder<T> get(int i)
```
源码 :118 —（无 javadoc）

```java
public boolean contains(Holder<T> holder)
```
源码 :124 —（无 javadoc）

```java
public boolean canSerializeIn(HolderOwner<T> holderOwner)
```
源码 :130 —（无 javadoc）

```java
public Optional<TagKey<T>> unwrapKey()
```
源码 :136 —（无 javadoc）

```java
public String toString()
```
源码 :142 —（无 javadoc）

