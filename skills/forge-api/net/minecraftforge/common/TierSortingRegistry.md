# TierSortingRegistry

> `net.minecraftforge.common.TierSortingRegistry` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/TierSortingRegistry.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（7 个）

```java
public static synchronized Tier registerTier(Tier tier, ResourceLocation name, List<Object> after, List<Object> before)
```
源码 :64 — Registers a tier into the tier sorting registry. @param tier The tier to register @param name The name to use internally for dependency resolution @param after List of tiers to place this tier after (the tiers in the list will be considered lesser tiers) @param before List of tiers to place this tie…

```java
public static List<Tier> getSortedTiers()
```
源码 :80 — Returns the list of tiers in the order defined by the dependencies. This list will remain valid @return An unmodifiable list of tiers ordered lesser to greater

```java
public static Tier byName(ResourceLocation name)
```
源码 :91 —（无 javadoc）

```java
public static ResourceLocation getName(Tier tier)
```
源码 :102 —（无 javadoc）

```java
public static boolean isTierSorted(Tier tier)
```
源码 :112 — Queries if a tier should be evaluated using the sorting system, by calling isCorrectTierForDrops @param tier The tier to query @return True if isCorrectTierForDrops should be called for the tier

```java
public static boolean isCorrectTierForDrops(Tier tier, BlockState state)
```
源码 :123 — Queries if a tier is high enough to be able to get drops for the given blockstate. @param tier The tier to look up @param state The state to test against @return True if the tier is good enough

```java
public static List<Tier> getTiersLowerThan(Tier tier)
```
源码 :141 — Helper to query all tiers that are lower than the given tier @param tier The tier @return All the lower tiers

