# OrHolderSet

> `net.minecraftforge.registries.holdersets.OrHolderSet` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/holdersets/OrHolderSet.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Holderset that represents a union of other holdersets. Json format: { "type": "forge:or", "values": [ // list of sub-holdersets (strings, lists, or objects) ] }

## 公开成员（5 个）

```java
public static <T> Codec<? extends ICustomHolderSet<T>> codec(ResourceKey<? extends Registry<T>> registryKey, Codec<Holder<T>> holderCodec, boolean forceList)
```
源码 :36 —（无 javadoc）

```java
public OrHolderSet(List<HolderSet<T>> values)
```
源码 :45 —（无 javadoc）

```java
public HolderSetType type()
```
源码 :51 —（无 javadoc）

```java
protected Set<Holder<T>> createSet()
```
源码 :57 —（无 javadoc）

```java
public String toString()
```
源码 :63 —（无 javadoc）

