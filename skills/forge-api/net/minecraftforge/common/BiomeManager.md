# BiomeManager

> `net.minecraftforge.common.BiomeManager` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/BiomeManager.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（8 个）

```java
public static void addAdditionalOverworldBiomes(ResourceKey<Biome> biome)
```
源码 :71 — Add biomes that you add to the overworld without using BiomeManager#addBiome(BiomeType,

```java
public static boolean addBiome(BiomeType type, BiomeEntry entry)
```
源码 :79 —（无 javadoc）

```java
public static boolean removeBiome(BiomeType type, BiomeEntry entry)
```
源码 :91 —（无 javadoc）

```java
public static List<ResourceKey<Biome>> getAdditionalOverworldBiomes()
```
源码 :101 — @return list of biomes that might be generated in the overworld in addition to the vanilla biomes

```java
public static ImmutableList<BiomeEntry> getBiomes(BiomeType type)
```
源码 :106 —（无 javadoc）

```java
public static boolean isTypeListModded(BiomeType type)
```
源码 :113 —（无 javadoc）

```java
public static enum BiomeType
```
源码 :120 —（无 javadoc）

```java
public static class BiomeEntry
```
源码 :125 —（无 javadoc）

