# IClientBlockExtensions

> `net.minecraftforge.client.extensions.common.IClientBlockExtensions` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/extensions/common/IClientBlockExtensions.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：LogicalSide#CLIENT Client-only extensions to Block. @see Block#initializeClient(Consumer)

## 公开成员（6 个）

```java
static IClientBlockExtensions of(BlockState state)
```
源码 :37 —（无 javadoc）

```java
static IClientBlockExtensions of(Block block)
```
源码 :42 —（无 javadoc）

```java
default boolean addHitEffects(BlockState state, Level level, HitResult target, ParticleEngine manager)
```
源码 :59 — Spawn a digging particle effect in the level, this is a wrapper around EffectRenderer.addBlockHitEffects to allow the block more control over the particles. Useful when you have entirely different texture sheets for different sides/locations in the level. @param state The current state @param level…

```java
default boolean addDestroyEffects(BlockState state, Level Level, BlockPos pos, ParticleEngine manager)
```
源码 :75 — Spawn particles for when the block is destroyed. Due to the nature of how this is invoked, the x/y/z locations are not always guaranteed to host your block. So be sure to do proper sanity checks before assuming that the location is this block. @param Level The current Level @param pos Position to sp…

```java
default Vector3d getFogColor(BlockState state, LevelReader level, BlockPos pos, Entity entity, Vector3d originalColor, float partialTick)
```
源码 :93 — NOT CURRENTLY IMPLEMENTED Use this to change the fog color used when the entity is "inside" a material. Vec3d is used here as "r/g/b" 0 - 1 values. @param level The level. @param pos The position at the entity viewport. @param state The state at the entity viewport. @param entity the entity @param o…

```java
default boolean areBreakingParticlesTinted(BlockState state, ClientLevel level, BlockPos pos)
```
源码 :127 — Returns true if the breaking particles created from the BlockState passed should be tinted with biome colors. @param state The state of this block @param level The level the particles are spawning in @param pos The position of the block @return `true` if the particles should be tinted.

