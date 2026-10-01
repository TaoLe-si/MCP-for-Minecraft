# ForgeEventFactory

> `net.minecraftforge.event.ForgeEventFactory` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/ForgeEventFactory.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（106 个）

```java
public static boolean onMultiBlockPlace(@Nullable Entity entity, List<BlockSnapshot> blockSnapshots, Direction direction)
```
源码 :157 —（无 javadoc）

```java
public static boolean onBlockPlace(@Nullable Entity entity, @NotNull BlockSnapshot blockSnapshot, @NotNull Direction direction)
```
源码 :165 —（无 javadoc）

```java
public static NeighborNotifyEvent onNeighborNotify(Level level, BlockPos pos, BlockState state, EnumSet<Direction> notifiedSides, boolean forceRedstoneUpdate)
```
源码 :172 —（无 javadoc）

```java
public static boolean doPlayerHarvestCheck(Player player, BlockState state, boolean success)
```
源码 :179 —（无 javadoc）

```java
public static float getBreakSpeed(Player player, BlockState state, float original, BlockPos pos)
```
源码 :186 —（无 javadoc）

```java
public static void onPlayerDestroyItem(Player player, @NotNull ItemStack stack, @Nullable InteractionHand hand)
```
源码 :192 —（无 javadoc）

```java
public static boolean checkSpawnPlacements(EntityType<?> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random, boolean defaultResult)
```
源码 :202 —（无 javadoc）

```java
public static boolean checkSpawnPosition(Mob mob, ServerLevelAccessor level, MobSpawnType spawnType)
```
源码 :218 — Checks if the current position of the passed mob is valid for spawning, by firing PositionCheck. The default check is to perform the logical and of Mob#checkSpawnRules and Mob#checkSpawnObstruction. @param mob The mob being spawned. @param level The level the mob will be added to, if successful. @pa…

```java
public static boolean checkSpawnPositionSpawner(Mob mob, ServerLevelAccessor level, MobSpawnType spawnType, SpawnData spawnData, BaseSpawner spawner)
```
源码 :234 — Specialized variant of #checkSpawnPosition for spawners, as they have slightly different checks. @see #CheckSpawnPosition @implNote See in-line comments about custom spawn rules.

```java
public static SpawnGroupData onFinalizeSpawn(Mob mob, ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag spawnTag)
```
源码 :278 —（无 javadoc）

```java
public static MobSpawnEvent.FinalizeSpawn onFinalizeSpawnSpawner(Mob mob, ServerLevelAccessor level, DifficultyInstance difficulty, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag spawnTag, BaseSpawner spawner)
```
源码 :298 —（无 javadoc）

```java
public static Result canEntityDespawn(Mob entity, ServerLevelAccessor level)
```
源码 :305 —（无 javadoc）

```java
public static int getItemBurnTime(@NotNull ItemStack itemStack, int burnTime, @Nullable RecipeType<?> recipeType)
```
源码 :312 —（无 javadoc）

```java
public static int getExperienceDrop(LivingEntity entity, Player attackingPlayer, int originalExperience)
```
源码 :319 —（无 javadoc）

```java
public static int getMaxSpawnPackSize(Mob entity)
```
源码 :329 —（无 javadoc）

```java
public static Component getPlayerDisplayName(Player player, Component username)
```
源码 :336 —（无 javadoc）

```java
public static Component getPlayerTabListDisplayName(Player player)
```
源码 :343 —（无 javadoc）

```java
public static BlockState fireFluidPlaceBlockEvent(LevelAccessor level, BlockPos pos, BlockPos liquidPos, BlockState state)
```
源码 :350 —（无 javadoc）

```java
public static ItemTooltipEvent onItemTooltip(ItemStack itemStack, @Nullable Player entityPlayer, List<Component> list, TooltipFlag flags)
```
源码 :357 —（无 javadoc）

```java
public static SummonAidEvent fireZombieSummonAid(Zombie zombie, Level level, int x, int y, int z, LivingEntity attacker, double summonChance)
```
源码 :364 —（无 javadoc）

```java
public static boolean onEntityStruckByLightning(Entity entity, LightningBolt bolt)
```
源码 :371 —（无 javadoc）

```java
public static int onItemUseStart(LivingEntity entity, ItemStack item, int duration)
```
源码 :376 —（无 javadoc）

```java
public static int onItemUseTick(LivingEntity entity, ItemStack item, int duration)
```
源码 :382 —（无 javadoc）

```java
public static boolean onUseItemStop(LivingEntity entity, ItemStack item, int duration)
```
源码 :388 —（无 javadoc）

```java
public static ItemStack onItemUseFinish(LivingEntity entity, ItemStack item, int duration, ItemStack result)
```
源码 :393 —（无 javadoc）

```java
public static void onStartEntityTracking(Entity entity, Player player)
```
源码 :400 —（无 javadoc）

```java
public static void onStopEntityTracking(Entity entity, Player player)
```
源码 :405 —（无 javadoc）

```java
public static void firePlayerLoadingEvent(Player player, File playerDirectory, String uuidString)
```
源码 :410 —（无 javadoc）

```java
public static void firePlayerSavingEvent(Player player, File playerDirectory, String uuidString)
```
源码 :415 —（无 javadoc）

```java
public static void firePlayerLoadingEvent(Player player, PlayerDataStorage playerFileData, String uuidString)
```
源码 :420 —（无 javadoc）

```java
public static BlockState onToolUse(BlockState originalState, UseOnContext context, ToolAction toolAction, boolean simulate)
```
源码 :426 —（无 javadoc）

```java
public static int onApplyBonemeal(@NotNull Player player, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull ItemStack stack)
```
源码 :432 —（无 javadoc）

```java
public static InteractionResultHolder<ItemStack> onBucketUse(@NotNull Player player, @NotNull Level level, @NotNull ItemStack stack, @Nullable HitResult target)
```
源码 :446 —（无 javadoc）

```java
public static PlayLevelSoundEvent.AtEntity onPlaySoundAtEntity(Entity entity, Holder<SoundEvent> name, SoundSource category, float volume, float pitch)
```
源码 :468 —（无 javadoc）

```java
public static PlayLevelSoundEvent.AtPosition onPlaySoundAtPosition(Level level, double x, double y, double z, Holder<SoundEvent> name, SoundSource category, float volume, float pitch)
```
源码 :476 —（无 javadoc）

```java
public static int onItemExpire(ItemEntity entity, @NotNull ItemStack item)
```
源码 :483 —（无 javadoc）

```java
public static int onItemPickup(ItemEntity entityItem, Player player)
```
源码 :491 —（无 javadoc）

```java
public static boolean canMountEntity(Entity entityMounting, Entity entityBeingMounted, boolean isMounting)
```
源码 :498 —（无 javadoc）

```java
public static boolean onAnimalTame(Animal animal, Player tamer)
```
源码 :511 —（无 javadoc）

```java
public static Player.BedSleepingProblem onPlayerSleepInBed(Player player, Optional<BlockPos> pos)
```
源码 :516 —（无 javadoc）

```java
public static void onPlayerWakeup(Player player, boolean wakeImmediately, boolean updateLevel)
```
源码 :523 —（无 javadoc）

```java
public static void onPlayerFall(Player player, float distance, float multiplier)
```
源码 :528 —（无 javadoc）

```java
public static boolean onPlayerSpawnSet(Player player, ResourceKey<Level> levelKey, BlockPos pos, boolean forced)
```
源码 :533 —（无 javadoc）

```java
public static void onPlayerClone(Player player, Player oldPlayer, boolean wasDeath)
```
源码 :538 —（无 javadoc）

```java
public static boolean onExplosionStart(Level level, Explosion explosion)
```
源码 :543 —（无 javadoc）

```java
public static void onExplosionDetonate(Level level, Explosion explosion, List<Entity> list, double diameter)
```
源码 :548 —（无 javadoc）

```java
public static boolean onCreateWorldSpawn(Level level, ServerLevelData settings)
```
源码 :564 —（无 javadoc）

```java
public static float onLivingHeal(LivingEntity entity, float amount)
```
源码 :569 —（无 javadoc）

```java
public static boolean onPotionAttemptBrew(NonNullList<ItemStack> stacks)
```
源码 :575 —（无 javadoc）

```java
public static void onPotionBrewed(NonNullList<ItemStack> brewingItemStacks)
```
源码 :597 —（无 javadoc）

```java
public static void onPlayerBrewedPotion(Player player, ItemStack stack)
```
源码 :602 —（无 javadoc）

```java
public static <T extends ICapabilityProvider> CapabilityDispatcher gatherCapabilities(Class<? extends T> type, T provider)
```
源码 :608 —（无 javadoc）

```java
public static <T extends ICapabilityProvider> CapabilityDispatcher gatherCapabilities(Class<? extends T> type, T provider, @Nullable ICapabilityProvider parent)
```
源码 :615 —（无 javadoc）

```java
public static boolean fireSleepingLocationCheck(LivingEntity player, BlockPos sleepingLocation)
```
源码 :627 —（无 javadoc）

```java
public static boolean fireSleepingTimeCheck(Player player, Optional<BlockPos> sleepingLocation)
```
源码 :644 —（无 javadoc）

```java
public static InteractionResultHolder<ItemStack> onArrowNock(ItemStack item, Level level, Player player, InteractionHand hand, boolean hasAmmo)
```
源码 :656 —（无 javadoc）

```java
public static int onArrowLoose(ItemStack stack, Level level, Player player, int charge, boolean hasAmmo)
```
源码 :664 —（无 javadoc）

```java
public static ProjectileImpactEvent.ImpactResult onProjectileImpactResult(Projectile projectile, HitResult ray)
```
源码 :672 —（无 javadoc）

```java
public static @Nullable ProjectileImpactEvent.ImpactResult onProjectileImpactResultNullable(Projectile projectile, HitResult ray)
```
源码 :697 — This sister method exists due to an oversight in the original introduction of adding ProjectileImpactEvent.ImpactResult to ProjectileImpactEvent. Prior to its addition, the cancelling of this event would call all behavior within the if-clause of the while loop to stop and then break out of the loop…

```java
public static boolean onProjectileImpact(Projectile projectile, HitResult ray)
```
源码 :708 —（无 javadoc）

```java
public static LootTable loadLootTable(ResourceLocation name, LootTable table)
```
源码 :713 —（无 javadoc）

```java
public static boolean canCreateFluidSource(Level level, BlockPos pos, BlockState state, boolean def)
```
源码 :721 —（无 javadoc）

```java
public static Optional<PortalShape> onTrySpawnPortal(LevelAccessor level, BlockPos pos, Optional<PortalShape> size)
```
源码 :730 —（无 javadoc）

```java
public static int onEnchantmentLevelSet(Level level, BlockPos pos, int enchantRow, int power, ItemStack itemStack, int enchantmentLevel)
```
源码 :736 —（无 javadoc）

```java
public static boolean onEntityDestroyBlock(LivingEntity entity, BlockPos pos, BlockState state)
```
源码 :743 —（无 javadoc）

```java
public static boolean getMobGriefingEvent(Level level, @Nullable Entity entity)
```
源码 :748 —（无 javadoc）

```java
public static SaplingGrowTreeEvent blockGrowFeature(LevelAccessor level, RandomSource randomSource, BlockPos pos, @Nullable Holder<ConfiguredFeature<?, ?>> holder)
```
源码 :760 —（无 javadoc）

```java
public static BlockState alterGround(LevelSimulatedReader level, RandomSource random, BlockPos pos, BlockState altered)
```
源码 :767 —（无 javadoc）

```java
public static void fireChunkTicketLevelUpdated(ServerLevel level, long chunkPos, int oldTicketLevel, int newTicketLevel, @Nullable ChunkHolder chunkHolder)
```
源码 :774 —（无 javadoc）

```java
public static void fireChunkWatch(ServerPlayer entity, LevelChunk chunk, ServerLevel level)
```
源码 :780 —（无 javadoc）

```java
public static void fireChunkUnWatch(ServerPlayer entity, ChunkPos chunkpos, ServerLevel level)
```
源码 :785 —（无 javadoc）

```java
public static boolean onPistonMovePre(Level level, BlockPos pos, Direction direction, boolean extending)
```
源码 :790 —（无 javadoc）

```java
public static boolean onPistonMovePost(Level level, BlockPos pos, Direction direction, boolean extending)
```
源码 :795 —（无 javadoc）

```java
public static long onSleepFinished(ServerLevel level, long newTime, long minTime)
```
源码 :800 —（无 javadoc）

```java
public static List<PreparableReloadListener> onResourceReload(ReloadableServerResources serverResources, RegistryAccess registryAccess)
```
源码 :807 —（无 javadoc）

```java
public static void onCommandRegister(CommandDispatcher<CommandSourceStack> dispatcher, Commands.CommandSelection environment, CommandBuildContext context)
```
源码 :814 —（无 javadoc）

```java
public static net.minecraftforge.event.entity.EntityEvent.Size getEntitySizeForge(Entity entity, Pose pose, EntityDimensions size, float eyeHeight)
```
源码 :821 —（无 javadoc）

```java
public static net.minecraftforge.event.entity.EntityEvent.Size getEntitySizeForge(Entity entity, Pose pose, EntityDimensions oldSize, EntityDimensions newSize, float newEyeHeight)
```
源码 :829 —（无 javadoc）

```java
public static boolean canLivingConvert(LivingEntity entity, EntityType<? extends LivingEntity> outcome, Consumer<Integer> timer)
```
源码 :836 —（无 javadoc）

```java
public static void onLivingConvert(LivingEntity entity, LivingEntity outcome)
```
源码 :841 —（无 javadoc）

```java
public static EntityTeleportEvent.TeleportCommand onEntityTeleportCommand(Entity entity, double targetX, double targetY, double targetZ)
```
源码 :846 —（无 javadoc）

```java
public static EntityTeleportEvent.SpreadPlayersCommand onEntityTeleportSpreadPlayersCommand(Entity entity, double targetX, double targetY, double targetZ)
```
源码 :853 —（无 javadoc）

```java
public static EntityTeleportEvent.EnderEntity onEnderTeleport(LivingEntity entity, double targetX, double targetY, double targetZ)
```
源码 :860 —（无 javadoc）

```java
public static EntityTeleportEvent.EnderPearl onEnderPearlLand(ServerPlayer entity, double targetX, double targetY, double targetZ, ThrownEnderpearl pearlEntity, float attackDamage, HitResult hitResult)
```
源码 :868 —（无 javadoc）

```java
public static EntityTeleportEvent.ChorusFruit onChorusFruitTeleport(LivingEntity entity, double targetX, double targetY, double targetZ)
```
源码 :875 —（无 javadoc）

```java
public static boolean onPermissionChanged(GameProfile gameProfile, int newLevel, PlayerList playerList)
```
源码 :882 —（无 javadoc）

```java
public static void firePlayerChangedDimensionEvent(Player player, ResourceKey<Level> fromDim, ResourceKey<Level> toDim)
```
源码 :893 —（无 javadoc）

```java
public static void firePlayerLoggedIn(Player player)
```
源码 :898 —（无 javadoc）

```java
public static void firePlayerLoggedOut(Player player)
```
源码 :903 —（无 javadoc）

```java
public static void firePlayerRespawnEvent(Player player, boolean endConquered)
```
源码 :908 —（无 javadoc）

```java
public static void firePlayerItemPickupEvent(Player player, ItemEntity item, ItemStack clone)
```
源码 :913 —（无 javadoc）

```java
public static void firePlayerCraftingEvent(Player player, ItemStack crafted, Container craftMatrix)
```
源码 :918 —（无 javadoc）

```java
public static void firePlayerSmeltedEvent(Player player, ItemStack smelted)
```
源码 :923 —（无 javadoc）

```java
public static void onRenderTickStart(float timer)
```
源码 :928 —（无 javadoc）

```java
public static void onRenderTickEnd(float timer)
```
源码 :933 —（无 javadoc）

```java
public static void onPlayerPreTick(Player player)
```
源码 :938 —（无 javadoc）

```java
public static void onPlayerPostTick(Player player)
```
源码 :943 —（无 javadoc）

```java
public static void onPreLevelTick(Level level, BooleanSupplier haveTime)
```
源码 :948 —（无 javadoc）

```java
public static void onPostLevelTick(Level level, BooleanSupplier haveTime)
```
源码 :953 —（无 javadoc）

```java
public static void onPreClientTick()
```
源码 :958 —（无 javadoc）

```java
public static void onPostClientTick()
```
源码 :963 —（无 javadoc）

```java
public static void onPreServerTick(BooleanSupplier haveTime, MinecraftServer server)
```
源码 :968 —（无 javadoc）

```java
public static void onPostServerTick(BooleanSupplier haveTime, MinecraftServer server)
```
源码 :973 —（无 javadoc）

```java
public static WeightedRandomList<MobSpawnSettings.SpawnerData> getPotentialSpawns(LevelAccessor level, MobCategory category, BlockPos pos, WeightedRandomList<MobSpawnSettings.SpawnerData> oldList)
```
源码 :978 —（无 javadoc）

```java
public static void onAdvancementEarnedEvent(Player player, Advancement earned)
```
源码 :987 —（无 javadoc）

```java
public static void onAdvancementProgressedEvent(Player player, Advancement progressed, AdvancementProgress advancementProgress, String criterion, ProgressType progressType)
```
源码 :993 —（无 javadoc）

