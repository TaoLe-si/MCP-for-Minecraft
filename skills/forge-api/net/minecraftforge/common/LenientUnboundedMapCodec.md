# LenientUnboundedMapCodec

> `net.minecraftforge.common.LenientUnboundedMapCodec` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/LenientUnboundedMapCodec.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Key and value decoded independently, unknown set of keys

## 公开成员（9 个）

```java
public LenientUnboundedMapCodec(final Codec<K> keyCodec, final Codec<V> elementCodec)
```
源码 :27 —（无 javadoc）

```java
public Codec<K> keyCodec()
```
源码 :33 —（无 javadoc）

```java
public Codec<V> elementCodec()
```
源码 :38 —（无 javadoc）

```java
public <T> DataResult<Map<K, V>> decode(DynamicOps<T> ops, MapLike<T> input)
```
源码 :43 —（无 javadoc）

```java
public <T> DataResult<Pair<Map<K, V>, T>> decode(final DynamicOps<T> ops, final T input)
```
源码 :69 —（无 javadoc）

```java
public <T> DataResult<T> encode(final Map<K, V> input, final DynamicOps<T> ops, final T prefix)
```
源码 :74 —（无 javadoc）

```java
public boolean equals(final Object o)
```
源码 :79 —（无 javadoc）

```java
public int hashCode()
```
源码 :91 —（无 javadoc）

```java
public String toString()
```
源码 :96 —（无 javadoc）

