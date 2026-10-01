# BiomeSpecialEffectsBuilder

> `net.minecraftforge.common.world.BiomeSpecialEffectsBuilder` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/world/BiomeSpecialEffectsBuilder.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Extension of the vanilla builder but also provides read access and a copy-from-existing-data helper. Also, the base builder crashes if certain values aren't specified on build, so this enforces the setting of those.

## 公开成员（15 个）

```java
public static BiomeSpecialEffectsBuilder copyOf(BiomeSpecialEffects baseEffects)
```
源码 :24 —（无 javadoc）

```java
public static BiomeSpecialEffectsBuilder create(int fogColor, int waterColor, int waterFogColor, int skyColor)
```
源码 :38 —（无 javadoc）

```java
protected BiomeSpecialEffectsBuilder(int fogColor, int waterColor, int waterFogColor, int skyColor)
```
源码 :43 —（无 javadoc）

```java
public int getFogColor()
```
源码 :52 —（无 javadoc）

```java
public int waterColor()
```
源码 :57 —（无 javadoc）

```java
public int getWaterFogColor()
```
源码 :62 —（无 javadoc）

```java
public int getSkyColor()
```
源码 :67 —（无 javadoc）

```java
public BiomeSpecialEffects.GrassColorModifier getGrassColorModifier()
```
源码 :72 —（无 javadoc）

```java
public Optional<Integer> getFoliageColorOverride()
```
源码 :77 —（无 javadoc）

```java
public Optional<Integer> getGrassColorOverride()
```
源码 :82 —（无 javadoc）

```java
public Optional<AmbientParticleSettings> getAmbientParticle()
```
源码 :87 —（无 javadoc）

```java
public Optional<Holder<SoundEvent>> getAmbientLoopSound()
```
源码 :92 —（无 javadoc）

```java
public Optional<AmbientMoodSettings> getAmbientMoodSound()
```
源码 :97 —（无 javadoc）

```java
public Optional<AmbientAdditionsSettings> getAmbientAdditionsSound()
```
源码 :102 —（无 javadoc）

```java
public Optional<Music> getBackgroundMusic()
```
源码 :107 —（无 javadoc）

