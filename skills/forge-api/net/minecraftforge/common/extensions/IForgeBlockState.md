# IForgeBlockState

> `net.minecraftforge.common.extensions.IForgeBlockState` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeBlockState.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目用法**：`getCloneItemStack(HitResult,...)`：中键选取方块要用

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（53 个）

```java
private BlockState self()
```
源码 :50 —（无 javadoc）

```java
default float getFriction(LevelReader level, BlockPos pos, @Nullable Entity entity)
```
源码 :69 — Gets the slipperiness at the given location at the given state. Normally between 0 and 1. Note that entities may reduce slipperiness by a certain factor of their own; for LivingEntity, this is `.91`. ItemEntity uses `.98`, and FishingHook uses `.92`. @param level the level @param pos the position in…

```java
default int getLightEmission(BlockGetter level, BlockPos pos)
```
源码 :77 — Get a light value for this block, taking into account the given state and coordinates, normal ranges are between 0 and 15

```java
default boolean isLadder(LevelReader level, BlockPos pos, LivingEntity entity)
```
源码 :90 — Checks if a player or entity can use this block to 'climb' like a ladder. @param level The current level @param pos Block position in level @param entity The entity trying to use the ladder, CAN be null. @return True if the block should act like a ladder

```java
default boolean canHarvestBlock(BlockGetter level, BlockPos pos, Player player)
```
源码 :103 — Determines if the player can harvest this block, obtaining it's drops when the block is destroyed. @param level The current level @param pos The block's current position @param player The player damaging the block @return True to spawn the drops

```java
default boolean onDestroyedByPlayer(Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid)
```
源码 :127 — Called when a player removes a block. This is responsible for actually destroying the block, and the block is intact at time of call. This is called regardless of whether the player can harvest the block or not. Return true if the block is actually destroyed. Note: When used in multiplayer, this is…

```java
default boolean isBed(BlockGetter level, BlockPos pos, @Nullable LivingEntity sleeper)
```
源码 :142 — Determines if this block is classified as a Bed, Allowing players to sleep in it, though the block has to specifically perform the sleeping functionality in it's activated event. @param level The current level @param pos Block position in level @param sleeper The sleeper or camera entity, null in so…

```java
default boolean isValidSpawn(LevelReader level, BlockPos pos, Type type, EntityType<?> entityType)
```
源码 :156 — Determines if a specified mob type can spawn on this block, returning false will prevent any mob from spawning on the block. @param level The current level @param pos Block position in level @param type The Mob Category Type @return True to allow a mob of the specified category to spawn, false to pr…

```java
default Optional<Vec3> getRespawnPosition(EntityType<?> type, LevelReader level, BlockPos pos, float orientation, @Nullable LivingEntity entity)
```
源码 :172 — Returns the position that the entity is moved to upon respawning at this block. @param type The entity type used when checking if a dismount blockstate is dangerous. Currently always PLAYER. @param level The current level @param pos Block position in level @param orientation The angle the entity had…

```java
default void setBedOccupied(Level level, BlockPos pos, LivingEntity sleeper, boolean occupied)
```
源码 :185 — Called when a user either starts or stops sleeping in the bed. @param level The current level @param pos Block position in level @param sleeper The sleeper or camera entity, null in some cases. @param occupied True if we are occupying the bed, or false if they are stopping use of the bed

```java
default Direction getBedDirection(LevelReader level, BlockPos pos)
```
源码 :198 — Returns the direction of the block. Same values that are returned by BlockDirectional @param level The current level @param pos Block position in level @return Bed direction

```java
default float getExplosionResistance(BlockGetter level, BlockPos pos, Explosion explosion)
```
源码 :211 — Location sensitive version of getExplosionResistance @param level The current level @param pos Block position in level @param explosion The explosion @return The amount of the explosion absorbed.

```java
default ItemStack getCloneItemStack(HitResult target, BlockGetter level, BlockPos pos, Player player)
```
源码 :223 — Called when A user uses the creative pick block button on this block @param target The full target the player is looking at @return A ItemStack to add to the player's inventory, empty itemstack if nothing should be added.

```java
default boolean addLandingEffects(ServerLevel level, BlockPos pos, BlockState state2, LivingEntity entity, int numberOfParticles)
```
源码 :240 — Allows a block to override the standard EntityLivingBase.updateFallState particles, this is a server side method that spawns particles with WorldServer.spawnParticle. @param level The current server level @param pos The position of the block. @param state2 The state at the specific world/pos @param…

```java
default boolean addRunningEffects(Level level, BlockPos pos, Entity entity)
```
源码 :255 — Allows a block to override the standard vanilla running particles. This is called from `Entity#spawnSprintParticle()` and is called both, Client and server side, it's up to the implementor to client check / server check. By default vanilla spawns particles only on the client and the server methods n…

```java
default boolean canSustainPlant(BlockGetter level, BlockPos pos, Direction facing, IPlantable plantable)
```
源码 :276 — Determines if this block can support the passed in plant, allowing it to be planted and grow. Some examples: Reeds check if its a reed, or if its sand/dirt/grass and adjacent to water Cacti checks if its a cacti, or if its sand Nether types check for soul sand Crops check for tilled soil Caves check…

```java
default boolean onTreeGrow(LevelReader level, BiConsumer<BlockPos, BlockState> placeFunction, RandomSource randomSource, BlockPos pos, TreeConfiguration config)
```
源码 :299 — Called when a tree grows on top of this block and tries to set it to dirt by the trunk placer. An override that returns true is responsible for using the place function to set blocks in the world properly during generation. A modded grass block might override this method to ensure it turns into the…

```java
default boolean isFertile(BlockGetter level, BlockPos pos)
```
源码 :313 — Checks if this soil is fertile, typically this means that growth rates of plants on this soil will be slightly sped up. Only vanilla case is tilledField when it is within range of water. @param level The current level @param pos Block position in level @return True if the soil should be considered f…

```java
default boolean isConduitFrame(LevelReader level, BlockPos pos, BlockPos conduit)
```
源码 :326 — Determines if this block can be used as the frame of a conduit. @param level The current level @param pos Block position in level @param conduit Conduit position in level @return True, to support the conduit, and make it active with this block.

```java
default boolean isPortalFrame(BlockGetter level, BlockPos pos)
```
源码 :338 — Determines if this block can be used as part of a frame of a nether portal. @param level The current level @param pos Block position in level @return True, to support being part of a nether portal frame, false otherwise.

```java
default int getExpDrop(LevelReader level, RandomSource randomSource, BlockPos pos, int fortuneLevel, int silkTouchLevel)
```
源码 :353 — Gathers how much experience this block drops when broken. @param level The level @param randomSource Random source to use for experience randomness @param pos Block position @param fortuneLevel fortune enchantment level of tool being used @param silkTouchLevel silk touch enchantment level of tool be…

```java
default BlockState rotate(LevelAccessor level, BlockPos pos, Rotation direction)
```
源码 :358 —（无 javadoc）

```java
default float getEnchantPowerBonus(LevelReader level, BlockPos pos)
```
源码 :369 — Determines the amount of enchanting power this block can provide to an enchanting table. @param level The level @param pos Block position in level @return The amount of enchanting power this block produces.

```java
default void onNeighborChange(LevelReader level, BlockPos pos, BlockPos neighbor)
```
源码 :380 — Called when a tile entity on a side of this block changes is created or is destroyed. @param level The level @param pos Block position in level @param neighbor Block position of neighbor

```java
default boolean shouldCheckWeakPower(SignalGetter level, BlockPos pos, Direction side)
```
源码 :392 — Called to determine whether to allow the block to handle its own indirect power rather than using the default rules. @param level The level @param pos Block position in level @param side The INPUT side of the block to be powered - ie the opposite of this block's output side @return Whether Block#isP…

```java
default boolean getWeakChanges(LevelReader level, BlockPos pos)
```
源码 :406 — If this block should be notified of weak changes. Weak changes are changes 1 block away through a solid block. Similar to comparators. @param level The current level @param pos Block position in level @return true To be notified of changes

```java
default SoundType getSoundType(LevelReader level, BlockPos pos, @Nullable Entity entity)
```
源码 :418 — Sensitive version of getSoundType @param level The level @param pos The position. Note that the level may not necessarily have `state` here! @param entity The entity that is breaking/stepping on/placing/hitting/falling on this block, or null if no entity is in this context @return A SoundType to use

```java
default float[] getBeaconColorMultiplier(LevelReader level, BlockPos pos, BlockPos beacon)
```
源码 :430 —（无 javadoc）

```java
default BlockState getStateAtViewpoint(BlockGetter level, BlockPos pos, Vec3 viewpoint)
```
源码 :445 — Used to determine the state 'viewed' by an entity (see Camera#getBlockAtCamera()). Can be used by fluid blocks to determine if the viewpoint is within the fluid or not. @param level the level @param pos the position @param viewpoint the viewpoint @return the block state that should be 'seen'

```java
default boolean isSlimeBlock()
```
源码 :453 — @return true if the block is sticky block which used for pull or push adjacent blocks (use by piston)

```java
default boolean isStickyBlock()
```
源码 :461 — @return true if the block is sticky block which used for pull or push adjacent blocks (use by piston)

```java
default boolean canStickTo(@NotNull BlockState other)
```
源码 :471 — Determines if this block can stick to another block when pushed by a piston. @param other Other block @return True to link blocks

```java
default int getFlammability(BlockGetter level, BlockPos pos, Direction face)
```
源码 :485 — Chance that fire will spread and consume this block. 300 being a 100% chance, 0, being a 0% chance. @param level The current level @param pos Block position in level @param face The face that the fire is coming from @return A number ranging from 0 to 300 relating used to determine if the block will…

```java
default boolean isFlammable(BlockGetter level, BlockPos pos, Direction face)
```
源码 :498 — Called when fire is updating, checks if a block face can catch fire. @param level The current level @param pos Block position in level @param face The face that the fire is coming from @return True if the face can be on fire, false otherwise.

```java
default void onCaughtFire(Level level, BlockPos pos, @Nullable Direction face, @Nullable LivingEntity igniter)
```
源码 :511 — If the block is flammable, this is called when it gets lit on fire. @param level The current level @param pos Block position in level @param face The face that the fire is coming from @param igniter The entity that lit the fire

```java
default int getFireSpreadSpeed(BlockGetter level, BlockPos pos, Direction face)
```
源码 :525 — Called when fire is updating on a neighbor block. The higher the number returned, the faster fire will spread around this block. @param level The current level @param pos Block position in level @param face The face that the fire is coming from @return A number that is used to determine the speed of…

```java
default boolean isFireSource(LevelReader level, BlockPos pos, Direction side)
```
源码 :540 — Currently only called by fire when it is on top of this block. Returning true will prevent the fire from naturally dying during updating. Also prevents firing from dying from rain. @param level The current level @param pos Block position in level @param side The face that the fire is coming from @re…

```java
default boolean canEntityDestroy(BlockGetter level, BlockPos pos, Entity entity)
```
源码 :552 — Determines if this block is can be destroyed by the specified entities normal behavior. @param level The current level @param pos Block position in level @return True to allow the ender dragon to destroy this block

```java
default boolean isBurning(BlockGetter level, BlockPos pos)
```
源码 :565 — Determines if this block should set fire and deal fire damage to entities coming into contact with it. @param level The current level @param pos Block position in level @return True if the block should deal damage

```java
default BlockPathTypes getBlockPathType(BlockGetter level, BlockPos pos, @Nullable Mob mob)
```
源码 :580 —（无 javadoc）

```java
default BlockPathTypes getAdjacentBlockPathType(BlockGetter level, BlockPos pos, @Nullable Mob mob, BlockPathTypes originalType)
```
源码 :598 —（无 javadoc）

```java
default boolean canDropFromExplosion(BlockGetter level, BlockPos pos, Explosion explosion)
```
源码 :606 — Determines if this block should drop loot when exploded.

```java
default void onBlockExploded(Level level, BlockPos pos, Explosion explosion)
```
源码 :620 — Called when the block is destroyed by an explosion. Useful for allowing the block to take into account tile entities, state, etc. when exploded, before it is removed. @param level The current level @param pos Block position in level @param explosion The explosion instance affecting the block

```java
default boolean collisionExtendsVertically(BlockGetter level, BlockPos pos, Entity collidingEntity)
```
源码 :629 — Determines if this block's collision box should be treated as though it can extend above its block space. This can be used to replicate fence and wall behavior.

```java
default boolean shouldDisplayFluidOverlay(BlockAndTintGetter level, BlockPos pos, FluidState fluidState)
```
源码 :642 — Called to determine whether this block should use the fluid overlay texture or flowing texture when it is placed under the fluid. @param level The level @param pos Block position in level @param fluidState The state of the fluid @return Whether the fluid overlay texture should be used

```java
default BlockState getToolModifiedState(UseOnContext context, ToolAction toolAction, boolean simulate)
```
源码 :659 —（无 javadoc）

```java
default boolean isScaffolding(LivingEntity entity)
```
源码 :671 — Checks if a player or entity handles movement on this block like scaffolding. @param entity The entity on the scaffolding @return True if the block should act like scaffolding

```java
default boolean canRedstoneConnectTo(BlockGetter level, BlockPos pos, @Nullable Direction direction)
```
源码 :686 — Whether redstone dust should visually connect to this block on a side. Modded redstone wire blocks should call this function to determine visual connections. @param level The level @param pos The block position in level @param direction The coming direction of the redstone dust connection (with resp…

```java
default boolean hidesNeighborFace(BlockGetter level, BlockPos pos, BlockState neighborState, Direction dir)
```
源码 :703 — Whether this block hides the neighbors face pointed towards by the given direction. This method should only be used for blocks you don't control, for your own blocks override net.minecraft.world.level.block.Block#skipRendering(BlockState, on the respective block instead @param level The world @param…

```java
default boolean supportsExternalFaceHiding()
```
源码 :713 — Whether this block allows a neighboring block to hide the face of this block it touches. If this returns true, IForgeBlockState#hidesNeighborFace(BlockGetter, will be called on the neighboring block.

```java
default void onBlockStateChange(LevelReader level, BlockPos pos, BlockState oldState)
```
源码 :728 — Called after the BlockState at the given BlockPos was changed and neighbors were updated. This method is called on the server and client side. Modifying the level is disallowed in this method. Useful for calculating additional data based on the new state and the neighbor's reactions to the state cha…

```java
default boolean canBeHydrated(BlockGetter getter, BlockPos pos, FluidState fluid, BlockPos fluidPos)
```
源码 :749 — Returns whether the block can be hydrated by a fluid. Hydration is an arbitrary word which depends on the block. A farmland has moisture A sponge can soak up the liquid A coral can live @param getter the getter which can get the block @param pos the position of the block being hydrated @param fluid…

```java
default BlockState getAppearance(BlockAndTintGetter level, BlockPos pos, Direction side, @Nullable BlockState queryState, @Nullable BlockPos queryPos)
```
源码 :765 — Returns the BlockState that this state reports to look like on the given side for querying by other mods. @param level The level this block is in @param pos The block's position in the level @param side The side of the block that is being queried @param queryState The state of the block that is quer…

