# ModifiableBiomeInfo

> `net.minecraftforge.common.world.ModifiableBiomeInfo` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/world/ModifiableBiomeInfo.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Holds lazy-evaluable modified biome info. Memoizers are not used because it's important to return null without evaluating the biome info if it's accessed outside of a server context.

## 公开成员（6 个）

```java
public ModifiableBiomeInfo(@NotNull final BiomeInfo originalBiomeInfo)
```
源码 :37 — @param originalBiomeInfo BiomeInfo representing the original state of a biome when the biome was constructed.

```java
public BiomeInfo get()
```
源码 :46 —（无 javadoc）

```java
public BiomeInfo getOriginalBiomeInfo()
```
源码 :57 —（无 javadoc）

```java
public BiomeInfo getModifiedBiomeInfo()
```
源码 :66 —（无 javadoc）

```java
public void applyBiomeModifiers(final Holder<Biome> biome, final List<BiomeModifier> biomeModifiers)
```
源码 :80 —（无 javadoc）

```java
public record BiomeInfo(ClimateSettings climateSettings, BiomeSpecialEffects effects, BiomeGenerationSettings generationSettings, MobSpawnSettings mobSpawnSettings)
```
源码 :104 — Record containing raw biome data. @param climateSettings Weather and temperature settings. @param effects Client-relevant effects for rendering and sound. @param generationSettings Worldgen features and carvers. @param mobSpawnSettings Mob spawn settings.

