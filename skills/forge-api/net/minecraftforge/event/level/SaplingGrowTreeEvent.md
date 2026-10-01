# SaplingGrowTreeEvent

> `net.minecraftforge.event.level.SaplingGrowTreeEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/level/SaplingGrowTreeEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（6 个）

```java
public SaplingGrowTreeEvent(LevelAccessor level, RandomSource randomSource, BlockPos pos, @Nullable Holder<ConfiguredFeature<?, ?>> feature)
```
源码 :40 —（无 javadoc）

```java
public RandomSource getRandomSource()
```
源码 :51 — the random source which initiated the sapling growth

```java
public BlockPos getPos()
```
源码 :59 — the coordinates of the sapling attempting to grow

```java
public Holder<ConfiguredFeature<?, ?>> getFeature()
```
源码 :68 —（无 javadoc）

```java
public void setFeature(@Nullable Holder<ConfiguredFeature<?, ?>> feature)
```
源码 :76 — @param feature a Holder referencing a tree feature to be placed instead of the current feature.

```java
public void setFeature(ResourceKey<ConfiguredFeature<?, ?>> featureKey)
```
源码 :84 — @param featureKey a ResourceKey referencing a tree feature to be placed instead of the current feature.

