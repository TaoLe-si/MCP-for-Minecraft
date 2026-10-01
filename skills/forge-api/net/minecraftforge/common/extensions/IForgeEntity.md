# IForgeEntity

> `net.minecraftforge.common.extensions.IForgeEntity` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeEntity.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（39 个）

```java
private Entity self() { return (Entity) this; } default void deserializeNBT(CompoundTag nbt)
```
源码 :42 —（无 javadoc）

```java
default CompoundTag serializeNBT()
```
源码 :49 —（无 javadoc）

```java
boolean canUpdate()
```
源码 :60 —（无 javadoc）

```java
void canUpdate(boolean value)
```
源码 :61 —（无 javadoc）

```java
Collection<ItemEntity> captureDrops()
```
源码 :64 —（无 javadoc）

```java
Collection<ItemEntity> captureDrops(@Nullable Collection<ItemEntity> captureDrops)
```
源码 :65 —（无 javadoc）

```java
CompoundTag getPersistentData()
```
源码 :73 — Returns a NBTTagCompound that can be used to store custom data for this entity. It will be written, and read from disc, so it persists over world saves. @return A NBTTagCompound

```java
default boolean shouldRiderSit()
```
源码 :79 — Used in model rendering to determine if the entity riding this entity should be in the 'sitting' position. @return false to prevent an entity that is mounted to this entity from displaying the 'sitting' animation.

```java
default ItemStack getPickedResult(HitResult target)
```
源码 :90 — Called when a user uses the creative pick block button on this entity. @param target The full target the player is looking at @return A ItemStack to add to the player's inventory, empty ItemStack if nothing should be added.

```java
default boolean canRiderInteract()
```
源码 :109 — If a rider of this entity can interact with this entity. Should return true on the ridden entity if so. @return if the entity can be interacted with from a rider

```java
default boolean canBeRiddenUnderFluidType(FluidType type, Entity rider)
```
源码 :122 — Returns whether the entity can ride in this vehicle under the fluid. @param type the type of the fluid @param rider the entity riding the vehicle @return `true` if the vehicle can be ridden in under this fluid, `false` otherwise

```java
boolean canTrample(BlockState state, BlockPos pos, float fallDistance)
```
源码 :134 — Checks if this Entity can trample a Block. @param pos The block pos @param fallDistance The fall distance @return `true` if this entity can trample, `false` otherwise

```java
default MobCategory getClassification(boolean forSpawnCount)
```
源码 :141 — Returns The classification of this entity @param forSpawnCount If this is being invoked to check spawn count caps. @return If the creature is of the type provided

```java
boolean isAddedToWorld()
```
源码 :154 — Gets whether this entity has been added to a world (for tracking). Specifically between the times when an entity is added to a world and the entity being removed from the world's tracked lists. @return True if this entity is being tracked by a world

```java
void onAddedToWorld()
```
源码 :162 — Called after the entity has been added to the world's ticking list. Can be overriden, but needs to call super to prevent MC-136995.

```java
void onRemovedFromWorld()
```
源码 :170 — Called after the entity has been removed to the world's ticking list. Can be overriden, but needs to call super to prevent MC-136995.

```java
void revive()
```
源码 :177 — Revives an entity that has been removed from a world. Used as replacement for entity.removed = true. Having it as a function allows the entity to react to being revived.

```java
default boolean isMultipartEntity()
```
源码 :186 — This is used to specify that your entity has multiple individual parts, such as the Vanilla Ender Dragon. See EnderDragon for an example implementation. @return true if this is a multipart entity.

```java
default float getStepHeight()
```
源码 :215 — @return Return the height in blocks the Entity can step up without needing to jump This is the sum of vanilla's Entity#maxUpStep() method and the current value of the net.minecraftforge.common.ForgeMod#STEP_HEIGHT_ADDITION attribute (if this Entity is a LivingEntity and has the attribute), clamped a…

```java
double getFluidTypeHeight(FluidType type)
```
源码 :237 — Returns the height of the fluid type in relation to the bounding box of the entity. If the entity is not in the fluid type, then `0` is returned. @param type the type of the fluid @return the height of the fluid compared to the entity

```java
FluidType getMaxHeightFluidType()
```
源码 :246 — Returns the fluid type which is the highest on the bounding box of the entity. @return the fluid type which is the highest on the bounding box of the entity

```java
default boolean isInFluidType(FluidState state)
```
源码 :255 — Returns whether the entity is within the fluid type of the state. @param state the state of the fluid @return `true` if the entity is within the fluid type of the state, `false` otherwise

```java
default boolean isInFluidType(FluidType type)
```
源码 :267 — Returns whether the entity is within the fluid type. @param type the type of the fluid @return `true` if the entity is within the fluid type, `false` otherwise

```java
default boolean isInFluidType(BiPredicate<FluidType, Double> predicate)
```
源码 :280 — Returns whether any fluid type the entity is currently in matches the specified condition. @param predicate a test taking in the fluid type and its height @return `true` if a fluid type meets the condition, `false` otherwise

```java
boolean isInFluidType(BiPredicate<FluidType, Double> predicate, boolean forAllTypes)
```
源码 :295 — Returns whether the fluid type the entity is currently in matches the specified condition. @param predicate a test taking in the fluid type and its height @param forAllTypes `true` if all fluid types should match the condition instead of at least one @return `true` if a fluid type meets the conditio…

```java
boolean isInFluidType()
```
源码 :302 — Returns whether the entity is in a fluid. @return `true` if the entity is in a fluid, `false` otherwise

```java
FluidType getEyeInFluidType()
```
源码 :309 — Returns the fluid that is on the entity's eyes. @return the fluid that is on the entity's eyes

```java
default boolean isEyeInFluidType(FluidType type)
```
源码 :316 — Returns whether the fluid is on the entity's eyes. @return `true` if the fluid is on the entity's eyes, `false` otherwise

```java
default boolean canStartSwimming()
```
源码 :326 — Returns whether the entity can start swimming in the fluid. @return `true` if the entity can start swimming, `false` otherwise

```java
default double getFluidMotionScale(FluidType type)
```
源码 :338 — Returns how much the velocity of the fluid should be scaled by when applied to an entity. @param type the type of the fluid @return a scalar to multiply to the fluid velocity

```java
default boolean isPushedByFluid(FluidType type)
```
源码 :349 — Returns whether the fluid can push an entity. @param type the type of the fluid @return `true` if the entity can be pushed by the fluid, `false` otherwise

```java
default boolean canSwimInFluidType(FluidType type)
```
源码 :360 — Returns whether the entity can swim in the fluid. @param type the type of the fluid @return `true` if the entity can swim in the fluid, `false` otherwise

```java
default boolean canFluidExtinguish(FluidType type)
```
源码 :371 — Returns whether the entity can be extinguished by this fluid. @param type the type of the fluid @return `true` if the entity can be extinguished, `false` otherwise

```java
default float getFluidFallDistanceModifier(FluidType type)
```
源码 :386 — Returns how much the fluid should scale the damage done to a falling entity when hitting the ground per tick. Implementation: If the entity is in many fluids, the smallest modifier is applied. @param type the type of the fluid @return a scalar to multiply to the fall damage

```java
default boolean canHydrateInFluidType(FluidType type)
```
源码 :400 — Returns whether the entity can be hydrated by this fluid. Hydration is an arbitrary word which depends on the entity. @param type the type of the fluid @return `true` if the entity can be hydrated, `false` otherwise

```java
default SoundEvent getSoundFromFluidType(FluidType type, SoundAction action)
```
源码 :415 —（无 javadoc）

```java
default boolean hasCustomOutlineRendering(Player player)
```
源码 :428 — Returns whether this Entity has custom outline rendering behavior which does not use the existing automatic outline rendering based on Entity#isCurrentlyGlowing() and the entity's team color. @param player the local player currently viewing this `Entity` @return `true` to enable outline processing

```java
default float getEyeHeightForge(Pose pose, EntityDimensions size)
```
源码 :434 —（无 javadoc）

```java
default boolean shouldUpdateFluidWhileBoating(FluidState state, Boat boat)
```
源码 :447 — When `false`, the fluid will no longer update its height value while within a boat while it is not within a fluid (Boat#isUnderWater(). @param state the state of the fluid the rider is within @param boat the boat the rider is within that is not inside a fluid @return `true` if the fluid height shoul…

