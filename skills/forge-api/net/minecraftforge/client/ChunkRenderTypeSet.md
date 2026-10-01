# ChunkRenderTypeSet

> `net.minecraftforge.client.ChunkRenderTypeSet` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/ChunkRenderTypeSet.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：An immutable ordered set (not implementing java.util.Set) of chunk RenderType render types. Considerably speeds up lookups and merges of sets of chunk RenderType render types. Users should cache their instances of this class whenever possible, as instantiating it is cheap, but not free.

## 公开成员（14 个）

```java
public static ChunkRenderTypeSet none()
```
源码 :35 —（无 javadoc）

```java
public static ChunkRenderTypeSet all()
```
源码 :40 —（无 javadoc）

```java
public static ChunkRenderTypeSet of(RenderType... renderTypes)
```
源码 :45 —（无 javadoc）

```java
public static ChunkRenderTypeSet of(Collection<RenderType> renderTypes)
```
源码 :50 —（无 javadoc）

```java
public static ChunkRenderTypeSet union(ChunkRenderTypeSet... sets)
```
源码 :69 —（无 javadoc）

```java
public static ChunkRenderTypeSet union(Collection<ChunkRenderTypeSet> sets)
```
源码 :74 —（无 javadoc）

```java
public static ChunkRenderTypeSet union(Iterable<ChunkRenderTypeSet> sets)
```
源码 :81 —（无 javadoc）

```java
public static ChunkRenderTypeSet intersection(ChunkRenderTypeSet... sets)
```
源码 :89 —（无 javadoc）

```java
public static ChunkRenderTypeSet intersection(Collection<ChunkRenderTypeSet> sets)
```
源码 :94 —（无 javadoc）

```java
public static ChunkRenderTypeSet intersection(Iterable<ChunkRenderTypeSet> sets)
```
源码 :101 —（无 javadoc）

```java
public boolean isEmpty()
```
源码 :117 —（无 javadoc）

```java
public boolean contains(RenderType renderType)
```
源码 :122 —（无 javadoc）

```java
public Iterator<RenderType> iterator()
```
源码 :130 —（无 javadoc）

```java
public List<RenderType> asList()
```
源码 :135 —（无 javadoc）

