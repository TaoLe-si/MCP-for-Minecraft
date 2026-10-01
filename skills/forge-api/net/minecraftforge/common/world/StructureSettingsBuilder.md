# StructureSettingsBuilder

> `net.minecraftforge.common.world.StructureSettingsBuilder` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/world/StructureSettingsBuilder.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（12 个）

```java
public static StructureSettingsBuilder copyOf(StructureSettings settings)
```
源码 :35 — @param settings Existing StructureSettings. @return A new builder with a copy of that StructureSettings's values.

```java
public StructureSettings build()
```
源码 :51 — @return A new StructureSettings with the finalized values.

```java
public HolderSet<Biome> getBiomes()
```
源码 :59 —（无 javadoc）

```java
public void setBiomes(HolderSet<Biome> biomes)
```
源码 :64 —（无 javadoc）

```java
public StructureSpawnOverrideBuilder getSpawnOverrides(MobCategory category)
```
源码 :74 —（无 javadoc）

```java
public StructureSpawnOverrideBuilder getOrAddSpawnOverrides(MobCategory category)
```
源码 :83 — Gets or creates a mutable builder for the spawn overrides of a given mob category. If the override needed to be created it will default to piece bounding. @param category Mob category

```java
public void removeSpawnOverrides(MobCategory category)
```
源码 :92 — Removes the spawn overrides for the given mob category. @param category Mob category

```java
public GenerationStep.Decoration getDecorationStep()
```
源码 :100 — Gets the world generation decoration step the structure spawns during.

```java
public void setDecorationStep(GenerationStep.Decoration step)
```
源码 :108 — Sets the world generation decoration step the structure spawns during.

```java
public TerrainAdjustment getTerrainAdaptation()
```
源码 :116 — Gets the way the structure adapts to the terrain during generation.

```java
public void setTerrainAdaptation(TerrainAdjustment terrainAdaptation)
```
源码 :125 — Sets the way the structure adapts to the terrain during generation. @param terrainAdaptation New terrain adjustment

```java
public static class StructureSpawnOverrideBuilder
```
源码 :130 —（无 javadoc）

