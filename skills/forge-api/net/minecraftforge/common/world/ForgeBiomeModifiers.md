# ForgeBiomeModifiers

> `net.minecraftforge.common.world.ForgeBiomeModifiers` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/world/ForgeBiomeModifiers.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（4 个）

```java
public static record AddFeaturesBiomeModifier(HolderSet<Biome> biomes, HolderSet<PlacedFeature> features, Decoration step) implements BiomeModifier
```
源码 :46 — Stock biome modifier that adds features to biomes. Has the following json format: { "type": "forge:add_features", // required "biomes": "#namespace:your_biome_tag" // accepts a biome id, [list of biome ids], or #namespace:biome_tag "features": "namespace:your_feature", // accepts a placed feature id…

```java
public static record RemoveFeaturesBiomeModifier(HolderSet<Biome> biomes, HolderSet<PlacedFeature> features, Set<Decoration> steps) implements BiomeModifier
```
源码 :80 — Stock biome modifier that removes features from biomes. Has the following json format: { "type": "forge:removefeatures", // required "biomes": "#namespace:your_biome_tag", // accepts a biome id, [list of biome ids], or #namespace:biome_tag "features": "namespace:your_feature", // accepts a placed fe…

```java
public record AddSpawnsBiomeModifier(HolderSet<Biome> biomes, List<SpawnerData> spawners) implements BiomeModifier
```
源码 :150 — Stock biome modifier that adds a mob spawn to a biome. Has the following json format: { "type": "forge:add_spawns", // Required "biomes": "#namespace:biome_tag", // Accepts a biome id, [list of biome ids], or #namespace:biome_tag "spawners": { "type": "namespace:entity_type", // Type of mob to spawn…

```java
public record RemoveSpawnsBiomeModifier(HolderSet<Biome> biomes, HolderSet<EntityType<?>> entityTypes) implements BiomeModifier
```
源码 :197 — Stock biome modifier that removes mob spawns from a biome. Has the following json format: { "type": "forge:add_spawns", // Required "biomes": "#namespace:biome_tag", // Accepts a biome id, [list of biome ids], or #namespace:biome_tag "entity_types": #namespace:entitytype_tag // Accepts an entity typ…

