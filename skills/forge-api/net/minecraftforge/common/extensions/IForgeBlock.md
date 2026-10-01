# IForgeBlock

> `net.minecraftforge.common.extensions.IForgeBlock` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeBlock.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（53 个）

```java
private Block self()
```
源码 :63 —（无 javadoc）

```java
default float getFriction(BlockState state, LevelReader level, BlockPos pos, @Nullable Entity entity)
```
源码 :83 — Gets the slipperiness at the given location at the given state. Normally between 0 and 1. Note that entities may reduce slipperiness by a certain factor of their own; for LivingEntity, this is `.91`. ItemEntity uses `.98`, and FishingHook uses `.92`. @param state state of the block @param level the…

```java
default int getLightEmission(BlockState state, BlockGetter level, BlockPos pos)
```
源码 :113 — Get a light value for this block, taking into account the given state and coordinates, normal ranges are between 0 and 15 @param state The state of this block @param level The level this block is in @param pos The position of this block in the level, will be BlockPos#ZERO when the chunk being loaded…

```java
default boolean isLadder(BlockState state, LevelReader level, BlockPos pos, LivingEntity entity)
```
源码 :127 — Checks if a player or entity can use this block to 'climb' like a ladder. @param state The current state @param level The current level @param pos Block position in level @param entity The entity trying to use the ladder, CAN be null. @return True if the block should act like a ladder

```java
default boolean makesOpenTrapdoorAboveClimbable(BlockState state, LevelReader level, BlockPos pos, BlockState trapdoorState)
```
源码 :141 — Checks if this block makes an open trapdoor above it climbable. @param state The current state @param level The current level @param pos Block position in level @param trapdoorState The current state of the open trapdoor above @return True if the block should act like a ladder

```java
default boolean isBurning(BlockState state, BlockGetter level, BlockPos pos)
```
源码 :154 — Determines if this block should set fire and deal fire damage to entities coming into contact with it. @param level The current level @param pos Block position in level @return True if the block should deal damage

```java
default public boolean canHarvestBlock(BlockState state, BlockGetter level, BlockPos pos, Player player)
```
源码 :167 — Determines if the player can harvest this block, obtaining it's drops when the block is destroyed. @param level The current level @param pos The block's current position @param player The player damaging the block @return True to spawn the drops

```java
default boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid)
```
源码 :192 — Called when a player removes a block. This is responsible for actually destroying the block, and the block is intact at time of call. This is called regardless of whether the player can harvest the block or not. Return true if the block is actually destroyed. Note: When used in multiplayer, this is…

```java
default boolean isBed(BlockState state, BlockGetter level, BlockPos pos, @Nullable Entity player)
```
源码 :209 — Determines if this block is classified as a Bed, Allowing players to sleep in it, though the block has to specifically perform the sleeping functionality in it's activated event. @param state The current state @param level The current level @param pos Block position in level @param player The player…

```java
default Optional<Vec3> getRespawnPosition(BlockState state, EntityType<?> type, LevelReader levelReader, BlockPos pos, float orientation, @Nullable LivingEntity entity)
```
源码 :226 — Returns the position that the entity is moved to upon respawning at this block. @param state The current state @param type The entity type used when checking if a dismount blockstate is dangerous. Currently always PLAYER. @param levelReader The current level @param pos Block position in level @param…

```java
default boolean isValidSpawn(BlockState state, BlockGetter level, BlockPos pos, SpawnPlacements.Type type, EntityType<?> entityType)
```
源码 :245 — Determines if a specified mob type can spawn on this block, returning false will prevent any mob from spawning on the block. @param state The current state @param level The current level @param pos Block position in level @param type The Mob Category Type @return True to allow a mob of the specified…

```java
default void setBedOccupied(BlockState state, Level level, BlockPos pos, LivingEntity sleeper, boolean occupied)
```
源码 :258 — Called when a user either starts or stops sleeping in the bed. @param level The current level @param pos Block position in level @param sleeper The sleeper or camera entity, null in some cases. @param occupied True if we are occupying the bed, or false if they are stopping use of the bed

```java
default Direction getBedDirection(BlockState state, LevelReader level, BlockPos pos)
```
源码 :272 — Returns the direction of the block. Same values that are returned by BlockDirectional. Called every frame tick for every living entity. Be VERY fast. @param state The current state @param level The current level @param pos Block position in level @return Bed direction

```java
default float getExplosionResistance(BlockState state, BlockGetter level, BlockPos pos, Explosion explosion)
```
源码 :285 — Location sensitive version of getExplosionResistance @param level The current level @param pos Block position in level @param explosion The explosion @return The amount of the explosion absorbed.

```java
default ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player)
```
源码 :297 — Called when A user uses the creative pick block button on this block @param target The full target the player is looking at @return A ItemStack to add to the player's inventory, empty itemstack if nothing should be added.

```java
default boolean addLandingEffects(BlockState state1, ServerLevel level, BlockPos pos, BlockState state2, LivingEntity entity, int numberOfParticles)
```
源码 :314 — Allows a block to override the standard EntityLivingBase.updateFallState particles, this is a server side method that spawns particles with WorldServer.spawnParticle. @param level The current server level @param pos The position of the block. @param state2 The state at the specific level/pos @param…

```java
default boolean addRunningEffects(BlockState state, Level level, BlockPos pos, Entity entity)
```
源码 :331 — Allows a block to override the standard vanilla running particles. This is called from Entity.spawnSprintParticle and is called both, Client and server side, it's up to the implementor to client check / server check. By default vanilla spawns particles only on the client and the server methods no-op…

```java
boolean canSustainPlant(BlockState state, BlockGetter level, BlockPos pos, Direction facing, IPlantable plantable)
```
源码 :354 — Determines if this block can support the passed in plant, allowing it to be planted and grow. Some examples: Reeds check if its a reed, or if its sand/dirt/grass and adjacent to water Cacti checks if its a cacti, or if its sand Nether types check for soul sand Crops check for tilled soil Caves check…

```java
default boolean onTreeGrow(BlockState state, LevelReader level, BiConsumer<BlockPos, BlockState> placeFunction, RandomSource randomSource, BlockPos pos, TreeConfiguration config)
```
源码 :375 — Called when a tree grows on top of this block and tries to set it to dirt by the trunk placer. An override that returns true is responsible for using the place function to set blocks in the world properly during generation. A modded grass block might override this method to ensure it turns into the…

```java
default boolean isFertile(BlockState state, BlockGetter level, BlockPos pos)
```
源码 :389 — Checks if this soil is fertile, typically this means that growth rates of plants on this soil will be slightly sped up. Only vanilla case is tilledField when it is within range of water. @param level The current level @param pos Block position in level @return True if the soil should be considered f…

```java
default boolean isConduitFrame(BlockState state, LevelReader level, BlockPos pos, BlockPos conduit)
```
源码 :405 — Determines if this block can be used as the frame of a conduit. @param level The current level @param pos Block position in level @param conduit Conduit position in level @return True, to support the conduit, and make it active with this block.

```java
default boolean isPortalFrame(BlockState state, BlockGetter level, BlockPos pos)
```
源码 :421 — Determines if this block can be used as part of a frame of a nether portal. @param state The current state @param level The current level @param pos Block position in level @return True, to support being part of a nether portal frame, false otherwise.

```java
default int getExpDrop(BlockState state, LevelReader level, RandomSource randomSource, BlockPos pos, int fortuneLevel, int silkTouchLevel)
```
源码 :437 — Gathers how much experience this block drops when broken. @param state The current state @param level The level @param randomSource Random source to use for experience randomness @param pos Block position @param fortuneLevel fortune enchantment level of tool being used @param silkTouchLevel silk tou…

```java
default BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation direction)
```
源码 :442 —（无 javadoc）

```java
default float getEnchantPowerBonus(BlockState state, LevelReader level, BlockPos pos)
```
源码 :453 — Determines the amount of enchanting power this block can provide to an enchanting table. @param level The level @param pos Block position in level @return The amount of enchanting power this block produces.

```java
default void onNeighborChange(BlockState state, LevelReader level, BlockPos pos, BlockPos neighbor){} /** * Called to determine whether to allow the block to handle its own indirect power rather than using the default rules. * @param level The level * @param pos Block position in level * @param side The INPUT side of the block to be powered - ie the opposite of this block's output side * @return Whether Block#isProvidingWeakPower should be called when determining indirect power */ default boolean shouldCheckWeakPower(BlockState state, SignalGetter level, BlockPos pos, Direction side)
```
源码 :464 — Called when a tile entity on a side of this block changes is created or is destroyed. @param level The level @param pos Block position in level @param neighbor Block position of neighbor

```java
default boolean getWeakChanges(BlockState state, LevelReader level, BlockPos pos)
```
源码 :487 — If this block should be notified of weak changes. Weak changes are changes 1 block away through a solid block. Similar to comparators. @param level The current level @param pos Block position in level @return true To be notified of changes

```java
default SoundType getSoundType(BlockState state, LevelReader level, BlockPos pos, @Nullable Entity entity)
```
源码 :500 — Sensitive version of getSoundType @param state The state @param level The level @param pos The position. Note that the level may not necessarily have `state` here! @param entity The entity that is breaking/stepping on/placing/hitting/falling on this block, or null if no entity is in this context @re…

```java
default float[] getBeaconColorMultiplier(BlockState state, LevelReader level, BlockPos pos, BlockPos beaconPos)
```
源码 :513 —（无 javadoc）

```java
default BlockState getStateAtViewpoint(BlockState state, BlockGetter level, BlockPos pos, Vec3 viewpoint)
```
源码 :531 — Used to determine the state 'viewed' by an entity (see Camera#getBlockAtCamera()). Can be used by fluid blocks to determine if the viewpoint is within the fluid or not. @param state the state @param level the level @param pos the position @param viewpoint the viewpoint @return the block state that s…

```java
default BlockPathTypes getBlockPathType(BlockState state, BlockGetter level, BlockPos pos, @Nullable Mob mob)
```
源码 :547 —（无 javadoc）

```java
default BlockPathTypes getAdjacentBlockPathType(BlockState state, BlockGetter level, BlockPos pos, @Nullable Mob mob, BlockPathTypes originalType)
```
源码 :566 —（无 javadoc）

```java
default boolean isSlimeBlock(BlockState state)
```
源码 :577 — @param state The state @return true if the block is sticky block which used for pull or push adjacent blocks (use by piston)

```java
default boolean isStickyBlock(BlockState state)
```
源码 :586 — @param state The state @return true if the block is sticky block which used for pull or push adjacent blocks (use by piston)

```java
default boolean canStickTo(BlockState state, BlockState other)
```
源码 :597 — Determines if this block can stick to another block when pushed by a piston. @param state My state @param other Other block @return True to link blocks

```java
default int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction)
```
源码 :614 — Chance that fire will spread and consume this block. 300 being a 100% chance, 0, being a 0% chance. @param state The current state @param level The current level @param pos Block position in level @param direction The direction that the fire is coming from @return A number ranging from 0 to 300 rela…

```java
default boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction)
```
源码 :629 — Called when fire is updating, checks if a block face can catch fire. @param state The current state @param level The current level @param pos Block position in level @param direction The direction that the fire is coming from @return True if the face can be on fire, false otherwise.

```java
default void onCaughtFire(BlockState state, Level level, BlockPos pos, @Nullable Direction direction, @Nullable LivingEntity igniter) {} /** * Called when fire is updating on a neighbor block. * The higher the number returned, the faster fire will spread around this block. * * @param state The current state * @param level The current level * @param pos Block position in level * @param direction The direction that the fire is coming from * @return A number that is used to determine the speed of fire growth around the block */ default int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction)
```
源码 :643 — If the block is flammable, this is called when it gets lit on fire. @param state The current state @param level The current level @param pos Block position in level @param direction The direction that the fire is coming from @param igniter The entity that lit the fire

```java
default boolean isFireSource(BlockState state, LevelReader level, BlockPos pos, Direction direction)
```
源码 :671 — Currently only called by fire when it is on top of this block. Returning true will prevent the fire from naturally dying during updating. Also prevents firing from dying from rain. @param state The current state @param level The current level @param pos Block position in level @param direction The d…

```java
default boolean canEntityDestroy(BlockState state, BlockGetter level, BlockPos pos, Entity entity)
```
源码 :684 — Determines if this block is can be destroyed by the specified entities normal behavior. @param state The current state @param level The current level @param pos Block position in level @return True to allow the ender dragon to destroy this block

```java
default boolean canDropFromExplosion(BlockState state, BlockGetter level, BlockPos pos, Explosion explosion)
```
源码 :702 — Determines if this block should drop loot when exploded.

```java
default void onBlockExploded(BlockState state, Level level, BlockPos pos, Explosion explosion)
```
源码 :716 — Called when the block is destroyed by an explosion. Useful for allowing the block to take into account tile entities, state, etc. when exploded, before it is removed. @param level The current level @param pos Block position in level @param explosion The explosion instance affecting the block

```java
default boolean collisionExtendsVertically(BlockState state, BlockGetter level, BlockPos pos, Entity collidingEntity)
```
源码 :726 — Determines if this block's collision box should be treated as though it can extend above its block space. Use this to replicate fence and wall behavior.

```java
default boolean shouldDisplayFluidOverlay(BlockState state, BlockAndTintGetter level, BlockPos pos, FluidState fluidState)
```
源码 :740 — Called to determine whether this block should use the fluid overlay texture or flowing texture when it is placed under the fluid. @param state The current state @param level The level @param pos Block position in level @param fluidState The state of the fluid @return Whether the fluid overlay textur…

```java
default BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate)
```
源码 :758 —（无 javadoc）

```java
default boolean isScaffolding(BlockState state, LevelReader level, BlockPos pos, LivingEntity entity)
```
源码 :806 — Checks if a player or entity handles movement on this block like scaffolding. @param state The current state @param level The current level @param pos The block position in level @param entity The entity on the scaffolding @return True if the block should act like scaffolding

```java
default boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, @Nullable Direction direction)
```
源码 :840 — Whether redstone dust should visually connect to this block on a given side The default implementation is identical to `RedStoneWireBlock#shouldConnectTo(BlockState, Direction)` RedStoneWireBlock updates its visual connection when BlockState#updateShape(Direction, is called, this callback is used du…

```java
default boolean hidesNeighborFace(BlockGetter level, BlockPos pos, BlockState state, BlockState neighborState, Direction dir)
```
源码 :881 — Whether this block hides the neighbors face pointed towards by the given direction. This method should only be used for blocks you don't control, for your own blocks override Block#skipRendering(BlockState, on the respective block instead WARNING: This method is likely to be called from a worker thr…

```java
default boolean supportsExternalFaceHiding(BlockState state)
```
源码 :891 — Whether this block allows a neighboring block to hide the face of this block it touches. If this returns true, IForgeBlockState#hidesNeighborFace(BlockGetter, will be called on the neighboring block.

```java
default void onBlockStateChange(LevelReader level, BlockPos pos, BlockState oldState, BlockState newState) { } /** * Returns whether the block can be hydrated by a fluid. * * <p>Hydration is an arbitrary word which depends on the block. * <ul> * <li>A farmland has moisture</li> * <li>A sponge can soak up the liquid</li> * <li>A coral can live</li> * </ul> * * @param state the state of the block being hydrated * @param getter the getter which can get the block * @param pos the position of the block being hydrated * @param fluid the state of the fluid * @param fluidPos the position of the fluid * @return {@code true} if the block can be hydrated, {@code false} otherwise */ default boolean canBeHydrated(BlockState state, BlockGetter getter, BlockPos pos, FluidState fluid, BlockPos fluidPos)
```
源码 :911 — Called after the BlockState at the given BlockPos was changed and neighbors were updated. This method is called on the server and client side. Modifying the level is disallowed in this method. Useful for calculating additional data based on the new state and the neighbor's reactions to the state cha…

```java
default MapColor getMapColor(BlockState state, BlockGetter level, BlockPos pos, MapColor defaultColor)
```
源码 :943 — Returns the MapColor shown on the map. @param state The state of this block @param level The level this block is in @param pos The blocks position in the level @param defaultColor The `MapColor` configured for the given `BlockState` in the BlockBehaviour.Properties

```java
default BlockState getAppearance(BlockState state, BlockAndTintGetter level, BlockPos pos, Direction side, @Nullable BlockState queryState, @Nullable BlockPos queryPos)
```
源码 :971 — Returns the BlockState that this block reports to look like on the given side, for querying by other mods. Note: Overriding this does not change how this block renders. That must still be handled in the block's model. Common implementors would be covers and facades, or any other mimic blocks that pr…

```java
default PushReaction getPistonPushReaction(BlockState state)
```
源码 :991 —（无 javadoc）

