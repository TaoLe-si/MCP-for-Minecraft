# ITag

> `net.minecraftforge.registries.tags.ITag` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/tags/ITag.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：A tag is a collection of elements with an identifying TagKey. For Forge, these are bound on world load. Tags will always be empty until they are bound. A tag instance provided for a given TagKey from a given ITagManager will always return the same instance on future invocations. This means that the same tag instance will be rebound across reloads assuming the same registry instance is in use. It i…

## 公开成员（7 个）

```java
TagKey<V> getKey()
```
源码 :25 —（无 javadoc）

```java
Stream<V> stream()
```
源码 :27 —（无 javadoc）

```java
boolean isEmpty()
```
源码 :29 —（无 javadoc）

```java
int size()
```
源码 :31 —（无 javadoc）

```java
boolean contains(V value)
```
源码 :33 —（无 javadoc）

```java
Optional<V> getRandomElement(RandomSource random)
```
源码 :35 —（无 javadoc）

```java
boolean isBound()
```
源码 :41 — @return `true` if this tag was loaded with a value (including empty), otherwise the tag is always empty and this returns `false`

