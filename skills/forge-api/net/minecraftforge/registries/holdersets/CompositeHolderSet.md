# CompositeHolderSet

> `net.minecraftforge.registries.holdersets.CompositeHolderSet` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/holdersets/CompositeHolderSet.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Composite holdersets have component holdersets and possibly owner holdersets (which have this holderset as a component). When their component holderset(s) invalidate, they clear any cached data and then invalidate their owner holdersets.

## 公开成员（17 个）

```java
public CompositeHolderSet(List<HolderSet<T>> components)
```
源码 :43 —（无 javadoc）

```java
protected abstract Set<Holder<T>> createSet()
```
源码 :55 — immutable Set of Holders given this composite holderset's component holdersets

```java
public List<HolderSet<T>> getComponents()
```
源码 :57 —（无 javadoc）

```java
public Set<Holder<T>> getSet()
```
源码 :62 —（无 javadoc）

```java
public List<Holder<T>> getList()
```
源码 :77 —（无 javadoc）

```java
public void addInvalidationListener(Runnable runnable)
```
源码 :93 —（无 javadoc）

```java
public Stream<Holder<T>> stream()
```
源码 :109 —（无 javadoc）

```java
public int size()
```
源码 :115 —（无 javadoc）

```java
public Either<TagKey<T>, List<Holder<T>>> unwrap()
```
源码 :121 —（无 javadoc）

```java
public Optional<Holder<T>> getRandomElement(RandomSource rand)
```
源码 :127 —（无 javadoc）

```java
public Holder<T> get(int i)
```
源码 :137 —（无 javadoc）

```java
public boolean contains(Holder<T> holder)
```
源码 :143 —（无 javadoc）

```java
public boolean canSerializeIn(HolderOwner<T> holderOwner)
```
源码 :149 —（无 javadoc）

```java
public Optional<TagKey<T>> unwrapKey()
```
源码 :162 —（无 javadoc）

```java
public Iterator<Holder<T>> iterator()
```
源码 :168 —（无 javadoc）

```java
public List<HolderSet<T>> homogenize()
```
源码 :186 — Maps the sub-holdersets of this composite such that, if the list contains more than one element, and is non-homogenous, each element of the list will serialize as an object. Prevents crashes from trying to serialize non-homogenous lists to NBT. Lists are considered non-homogenous if it contains more…

```java
public boolean isHomogenous()
```
源码 :215 — @return True if all of our sub-holdersets have the same SerializationType (string, list, or object). False if we have more than one holderset AND if either we have more than one serialization type among them, or any holderset is SerializationType.UNKNOWN.

