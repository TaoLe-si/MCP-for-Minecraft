# LockHelper

> `net.minecraftforge.eventbus.LockHelper` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/eventbus/LockHelper.java` · `eventbus-6.2.33`（eventbus-6.2.33-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（7 个）

```java
public LockHelper(Map<K, V> map)
```
源码 :23 —（无 javadoc）

```java
public V get(K key)
```
源码 :27 —（无 javadoc）

```java
public boolean containsKey(K key)
```
源码 :35 —（无 javadoc）

```java
public V computeIfAbsent(K key, Supplier<V> factory)
```
源码 :43 —（无 javadoc）

```java
public <I> V get(K key, Supplier<I> factory, Function<I, V> finalizer)
```
源码 :48 —（无 javadoc）

```java
public <I> V computeIfAbsent(K key, Supplier<I> factory, Function<I, V> finalizer)
```
源码 :52 —（无 javadoc）

```java
public void clearAll()
```
源码 :89 —（无 javadoc）

