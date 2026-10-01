# AndHolderSet

> `net.minecraftforge.registries.holdersets.AndHolderSet` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/holdersets/AndHolderSet.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Holderset that represents an intersection of other holdersets. Json format: { "type": "forge:and", "values": [ // list of sub-holdersets (strings, lists, or objects) ] }

## 公开成员（5 个）

```java
public static <T> Codec<? extends ICustomHolderSet<T>> codec(ResourceKey<? extends Registry<T>> registryKey, Codec<Holder<T>> holderCodec, boolean forceList)
```
源码 :35 —（无 javadoc）

```java
public AndHolderSet(List<HolderSet<T>> values)
```
源码 :44 —（无 javadoc）

```java
public HolderSetType type()
```
源码 :50 —（无 javadoc）

```java
protected Set<Holder<T>> createSet()
```
源码 :56 —（无 javadoc）

```java
public String toString()
```
源码 :76 —（无 javadoc）

