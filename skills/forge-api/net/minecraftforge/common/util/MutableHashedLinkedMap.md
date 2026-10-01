# MutableHashedLinkedMap

> `net.minecraftforge.common.util.MutableHashedLinkedMap` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/util/MutableHashedLinkedMap.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：A mutable linked map with a hashing strategy and a merge function. @param the type of keys @param the type of mapped values

## 公开成员（13 个）

```java
public static final Strategy<? super Object> BASIC = new BasicStrategy()
```
源码 :30 — A strategy that uses Objects#hashCode(Object) and Object#equals(Object).

```java
public static final Strategy<? super Object> IDENTITY = new IdentityStrategy()
```
源码 :35 — A strategy that uses System#identityHashCode(Object) and `a == b` comparisons.

```java
public MutableHashedLinkedMap()
```
源码 :51 — Creates a new instance using the #BASIC strategy.

```java
public MutableHashedLinkedMap(Strategy<? super K> strategy)
```
源码 :61 — Creates a mutable linked map with a default new-value-selecting merge function. @param strategy the hashing strategy

```java
public MutableHashedLinkedMap(Strategy<? super K> strategy, MergeFunction<K, V> merge)
```
源码 :72 — Creates a mutable linked map with a custom merge function. @param strategy the hashing strategy @param merge the function used when merging an existing value and a new value

```java
public V put(K key, V value)
```
源码 :91 —（无 javadoc）

```java
public boolean contains(K key) { return this.entries.containsKey(key); } public boolean isEmpty() { return this.entries.isEmpty(); } @Nullable public V remove(K key)
```
源码 :116 —（无 javadoc）

```java
public V get(K key)
```
源码 :131 —（无 javadoc）

```java
public Iterator<Map.Entry<K, V>> iterator()
```
源码 :138 —（无 javadoc）

```java
public V putFirst(K key, V value)
```
源码 :194 —（无 javadoc）

```java
public V putAfter(K after, K key, V value)
```
源码 :217 —（无 javadoc）

```java
public V putBefore(K before, K key, V value)
```
源码 :266 —（无 javadoc）

```java
public static interface MergeFunction<Key, Value>
```
源码 :323 —（无 javadoc）

