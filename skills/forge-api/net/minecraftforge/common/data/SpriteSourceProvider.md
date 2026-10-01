# SpriteSourceProvider

> `net.minecraftforge.common.data.SpriteSourceProvider` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/data/SpriteSourceProvider.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Data provider for atlas configuration files. An atlas configuration is bound to a specific texture atlas such as the `minecraft:blocks` atlas and allows adding additional textures to the atlas by adding SpriteSources to the configuration. See SpriteSources for the available sources and the constants in this class for the atlases used in vanilla Minecraft

## 公开成员（15 个）

```java
protected static final ResourceLocation BLOCKS_ATLAS = new ResourceLocation("blocks")
```
源码 :30 —（无 javadoc）

```java
protected static final ResourceLocation BANNER_PATTERNS_ATLAS = new ResourceLocation("banner_patterns")
```
源码 :31 —（无 javadoc）

```java
protected static final ResourceLocation BEDS_ATLAS = new ResourceLocation("beds")
```
源码 :32 —（无 javadoc）

```java
protected static final ResourceLocation CHESTS_ATLAS = new ResourceLocation("chests")
```
源码 :33 —（无 javadoc）

```java
protected static final ResourceLocation SHIELD_PATTERNS_ATLAS = new ResourceLocation("shield_patterns")
```
源码 :34 —（无 javadoc）

```java
protected static final ResourceLocation SHULKER_BOXES_ATLAS = new ResourceLocation("shulker_boxes")
```
源码 :35 —（无 javadoc）

```java
protected static final ResourceLocation SIGNS_ATLAS = new ResourceLocation("signs")
```
源码 :36 —（无 javadoc）

```java
protected static final ResourceLocation MOB_EFFECTS_ATLAS = new ResourceLocation("mob_effects")
```
源码 :37 —（无 javadoc）

```java
protected static final ResourceLocation PAINTINGS_ATLAS = new ResourceLocation("paintings")
```
源码 :38 —（无 javadoc）

```java
protected static final ResourceLocation PARTICLES_ATLAS = new ResourceLocation("particles")
```
源码 :39 —（无 javadoc）

```java
public SpriteSourceProvider(PackOutput output, ExistingFileHelper fileHelper, String modid)
```
源码 :43 —（无 javadoc）

```java
protected final void gather(BiConsumer<ResourceLocation, List<SpriteSource>> consumer)
```
源码 :49 —（无 javadoc）

```java
protected abstract void addSources()
```
源码 :55 —（无 javadoc）

```java
protected final SourceList atlas(ResourceLocation atlas)
```
源码 :63 — Get or create a SourceList for the given atlas @param atlas The texture atlas the sources should be added to, see constants at the top for the format and the vanilla atlases @return an existing `SourceList` for the given atlas or a new one if not present yet

```java
protected static final class SourceList
```
源码 :68 —（无 javadoc）

