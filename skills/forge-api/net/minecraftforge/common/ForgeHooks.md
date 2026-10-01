# ForgeHooks

> `net.minecraftforge.common.ForgeHooks` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/ForgeHooks.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（95 个）

```java
public static boolean canContinueUsing(@NotNull ItemStack from, @NotNull ItemStack to)
```
源码 :222 —（无 javadoc）

```java
public static boolean isCorrectToolForDrops(@NotNull BlockState state, @NotNull Player player)
```
源码 :231 —（无 javadoc）

```java
public static boolean onItemStackedOn(ItemStack carriedItem, ItemStack stackedOnItem, Slot slot, ClickAction action, Player player, SlotAccess carriedSlotAccess)
```
源码 :239 —（无 javadoc）

```java
public static void onDifficultyChange(Difficulty difficulty, Difficulty oldDifficulty)
```
源码 :244 —（无 javadoc）

```java
public static LivingChangeTargetEvent onLivingChangeTarget(LivingEntity entity, LivingEntity originalTarget, ILivingTargetType targetType)
```
源码 :249 —（无 javadoc）

```java
public static Brain<?> onLivingMakeBrain(LivingEntity entity, Brain<?> originalBrain, Dynamic<?> dynamic)
```
源码 :257 —（无 javadoc）

```java
public static boolean onLivingTick(LivingEntity entity)
```
源码 :265 —（无 javadoc）

```java
public static boolean onLivingAttack(LivingEntity entity, DamageSource src, float amount)
```
源码 :270 —（无 javadoc）

```java
public static boolean onPlayerAttack(LivingEntity entity, DamageSource src, float amount)
```
源码 :275 —（无 javadoc）

```java
public static LivingKnockBackEvent onLivingKnockBack(LivingEntity target, float strength, double ratioX, double ratioZ)
```
源码 :280 —（无 javadoc）

```java
public static boolean onLivingUseTotem(LivingEntity entity, DamageSource damageSource, ItemStack totem, InteractionHand hand)
```
源码 :287 —（无 javadoc）

```java
public static float onLivingHurt(LivingEntity entity, DamageSource src, float amount)
```
源码 :292 —（无 javadoc）

```java
public static float onLivingDamage(LivingEntity entity, DamageSource src, float amount)
```
源码 :298 —（无 javadoc）

```java
public static boolean onLivingDeath(LivingEntity entity, DamageSource src)
```
源码 :304 —（无 javadoc）

```java
public static boolean onLivingDrops(LivingEntity entity, DamageSource source, Collection<ItemEntity> drops, int lootingLevel, boolean recentlyHit)
```
源码 :309 —（无 javadoc）

```java
public static float[] onLivingFall(LivingEntity entity, float distance, float damageMultiplier)
```
源码 :315 —（无 javadoc）

```java
public static int getLootingLevel(Entity target, @Nullable Entity killer, @Nullable DamageSource cause)
```
源码 :321 —（无 javadoc）

```java
public static int getLootingLevel(LivingEntity target, @Nullable DamageSource cause, int level)
```
源码 :331 —（无 javadoc）

```java
public static double getEntityVisibilityMultiplier(LivingEntity entity, Entity lookingEntity, double originalMultiplier)
```
源码 :338 —（无 javadoc）

```java
public static Optional<BlockPos> isLivingOnLadder(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull LivingEntity entity)
```
源码 :344 —（无 javadoc）

```java
public static void onLivingJump(LivingEntity entity)
```
源码 :377 —（无 javadoc）

```java
public static ItemEntity onPlayerTossEvent(@NotNull Player player, @NotNull ItemStack item, boolean includeName)
```
源码 :383 —（无 javadoc）

```java
public static boolean onVanillaGameEvent(Level level, GameEvent vanillaEvent, Vec3 pos, GameEvent.Context context)
```
源码 :401 —（无 javadoc）

```java
public static Component onServerChatSubmittedEvent(ServerPlayer player, String plain, Component decorated)
```
源码 :412 —（无 javadoc）

```java
public static ChatDecorator getServerChatSubmittedDecorator()
```
源码 :419 —（无 javadoc）

```java
public static Component newChatWithLinks(String string){ return newChatWithLinks(string, true); } public static Component newChatWithLinks(String string, boolean allowMissingHeader)
```
源码 :435 —（无 javadoc）

```java
public static void dropXpForBlock(BlockState state, ServerLevel level, BlockPos pos, ItemStack stack)
```
源码 :505 —（无 javadoc）

```java
public static int onBlockBreakEvent(Level level, GameType gameType, ServerPlayer entityPlayer, BlockPos pos)
```
源码 :514 —（无 javadoc）

```java
public static InteractionResult onPlaceItemIntoWorld(@NotNull UseOnContext context)
```
源码 :568 —（无 javadoc）

```java
public static boolean onAnvilChange(AnvilMenu container, @NotNull ItemStack left, @NotNull ItemStack right, Container outputSlot, String name, int baseCost, Player player)
```
源码 :658 —（无 javadoc）

```java
public static float onAnvilRepair(Player player, @NotNull ItemStack output, @NotNull ItemStack left, @NotNull ItemStack right)
```
源码 :670 —（无 javadoc）

```java
public static int onGrindstoneChange(@NotNull ItemStack top, @NotNull ItemStack bottom, Container outputSlot, int xp)
```
源码 :677 —（无 javadoc）

```java
public static boolean onGrindstoneTake(Container inputSlots, ContainerLevelAccess access, Function<Level, Integer> xpFunction)
```
源码 :691 —（无 javadoc）

```java
public static void setCraftingPlayer(Player player)
```
源码 :713 —（无 javadoc）

```java
public static Player getCraftingPlayer()
```
源码 :717 —（无 javadoc）

```java
public static ItemStack getCraftingRemainingItem(@NotNull ItemStack stack)
```
源码 :722 —（无 javadoc）

```java
public static boolean onPlayerAttackTarget(Player player, Entity target)
```
源码 :737 —（无 javadoc）

```java
public static boolean onTravelToDimension(Entity entity, ResourceKey<Level> dimension)
```
源码 :744 —（无 javadoc）

```java
public static InteractionResult onInteractEntityAt(Player player, Entity entity, HitResult ray, InteractionHand hand)
```
源码 :751 —（无 javadoc）

```java
public static InteractionResult onInteractEntityAt(Player player, Entity entity, Vec3 vec3d, InteractionHand hand)
```
源码 :757 —（无 javadoc）

```java
public static InteractionResult onInteractEntity(Player player, Entity entity, InteractionHand hand)
```
源码 :764 —（无 javadoc）

```java
public static InteractionResult onItemRightClick(Player player, InteractionHand hand)
```
源码 :771 —（无 javadoc）

```java
public static PlayerInteractEvent.LeftClickBlock onLeftClickBlock(Player player, BlockPos pos, Direction face)
```
源码 :782 —（无 javadoc）

```java
public static PlayerInteractEvent.LeftClickBlock onLeftClickBlock(Player player, BlockPos pos, Direction face, ServerboundPlayerActionPacket.Action action)
```
源码 :787 —（无 javadoc）

```java
public static PlayerInteractEvent.LeftClickBlock onClientMineHold(Player player, BlockPos pos, Direction face)
```
源码 :794 —（无 javadoc）

```java
public static PlayerInteractEvent.RightClickBlock onRightClickBlock(Player player, InteractionHand hand, BlockPos pos, BlockHitResult hitVec)
```
源码 :801 —（无 javadoc）

```java
public static void onEmptyClick(Player player, InteractionHand hand)
```
源码 :808 —（无 javadoc）

```java
public static void onEmptyLeftClick(Player player)
```
源码 :813 —（无 javadoc）

```java
public static GameType onChangeGameType(Player player, GameType currentGameType, GameType newGameType)
```
源码 :822 —（无 javadoc）

```java
public static TriFunction<ResourceLocation, JsonElement, ResourceManager, Optional<LootTable>> getLootTableDeserializer(Gson gson, String directory)
```
源码 :844 —（无 javadoc）

```java
public static LootTable loadLootTable(Gson gson, ResourceLocation name, JsonElement data, boolean custom)
```
源码 :861 —（无 javadoc）

```java
public static String readPoolName(JsonObject json)
```
源码 :910 —（无 javadoc）

```java
public static FluidType getVanillaFluidType(Fluid fluid)
```
源码 :932 — Returns a vanilla fluid type for the given fluid. @param fluid the fluid looking for its type @return the type of the fluid if vanilla @throws RuntimeException if the fluid is not a vanilla one

```java
public static TagKey<Block> getTagFromVanillaTier(Tiers tier)
```
源码 :945 —（无 javadoc）

```java
public static Collection<CreativeModeTab> onCheckCreativeTabs(CreativeModeTab... vanillaTabs)
```
源码 :958 —（无 javadoc）

```java
public interface BiomeCallbackFunction
```
源码 :964 —（无 javadoc）

```java
public static boolean onCropsGrowPre(Level level, BlockPos pos, BlockState state, boolean def)
```
源码 :969 —（无 javadoc）

```java
public static void onCropsGrowPost(Level level, BlockPos pos, BlockState state)
```
源码 :976 —（无 javadoc）

```java
public static CriticalHitEvent getCriticalHit(Player player, Entity target, boolean vanillaCritical, float damageModifier)
```
源码 :982 —（无 javadoc）

```java
public static Multimap<Attribute,AttributeModifier> getAttributeModifiers(ItemStack stack, EquipmentSlot equipmentSlot, Multimap<Attribute,AttributeModifier> attributes)
```
源码 :996 — Hook to fire ItemAttributeModifierEvent. Modders should use ItemStack#getAttributeModifiers(EquipmentSlot) instead.

```java
public static ItemStack getProjectile(LivingEntity entity, ItemStack projectileWeaponItem, ItemStack projectile)
```
源码 :1006 — Hook to fire LivingGetProjectileEvent. Returns the ammo to be used.

```java
public static String getDefaultCreatorModId(@NotNull ItemStack itemStack)
```
源码 :1017 —（无 javadoc）

```java
public static boolean onFarmlandTrample(Level level, BlockPos pos, BlockState state, float fallDistance, Entity entity)
```
源码 :1058 —（无 javadoc）

```java
public static int onNoteChange(Level level, BlockPos pos, BlockState state, int old, int _new)
```
源码 :1069 —（无 javadoc）

```java
public static boolean hasNoElements(Ingredient ingredient)
```
源码 :1076 —（无 javadoc）

```java
public static <T> void deserializeTagAdditions(List<TagEntry> list, JsonObject json, List<TagEntry> allList) {} @Nullable public static EntityDataSerializer<?> getSerializer(int id, CrudeIncrementalIntIdentityHashBiMap<EntityDataSerializer<?>> vanilla)
```
源码 :1090 —（无 javadoc）

```java
public static int getSerializerId(EntityDataSerializer<?> serializer, CrudeIncrementalIntIdentityHashBiMap<EntityDataSerializer<?>> vanilla)
```
源码 :1106 —（无 javadoc）

```java
public static boolean canEntityDestroy(Level level, BlockPos pos, LivingEntity entity)
```
源码 :1119 —（无 javadoc）

```java
public static int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType)
```
源码 :1132 — Gets the burn time of this itemstack.

```java
public static synchronized void updateBurns()
```
源码 :1147 —（无 javadoc）

```java
public static List<ItemStack> modifyLoot(List<ItemStack> list, LootContext context)
```
源码 :1167 —（无 javadoc）

```java
public static ObjectArrayList<ItemStack> modifyLoot(ResourceLocation lootTableId, ObjectArrayList<ItemStack> generatedLoot, LootContext context)
```
源码 :1185 — Handles the modification of loot table drops via the registered Global Loot Modifiers, so that custom effects can be processed. All loot-table generated loot should be passed to this function. @param lootTableId The ID of the loot table currently being queried @param generatedLoot The loot generated…

```java
public static List<String> getModPacks()
```
源码 :1194 —（无 javadoc）

```java
public static List<String> getModPacksWithVanilla()
```
源码 :1202 —（无 javadoc）

```java
public static Map<EntityType<? extends LivingEntity>, AttributeSupplier> getAttributesView()
```
源码 :1216 —（无 javadoc）

```java
public static void modifyAttributes()
```
源码 :1223 —（无 javadoc）

```java
public static void onEntityEnterSection(Entity entity, long packedOldPos, long packedNewPos)
```
源码 :1238 —（无 javadoc）

```java
public static ShieldBlockEvent onShieldBlock(LivingEntity blocker, DamageSource source, float blocked)
```
源码 :1243 —（无 javadoc）

```java
public static LivingSwapItemsEvent.Hands onLivingSwapHandItems(LivingEntity livingEntity)
```
源码 :1250 —（无 javadoc）

```java
public static void writeAdditionalLevelSaveData(WorldData worldData, CompoundTag levelTag)
```
源码 :1257 —（无 javadoc）

```java
public static void readAdditionalLevelSaveData(CompoundTag rootTag, LevelStorageSource.LevelDirectory levelDirectory)
```
源码 :1287 —（无 javadoc）

```java
public static String encodeLifecycle(Lifecycle lifecycle)
```
源码 :1401 —（无 javadoc）

```java
public static Lifecycle parseLifecycle(String lifecycle)
```
源码 :1412 —（无 javadoc）

```java
public static void saveMobEffect(CompoundTag nbt, String key, MobEffect effect)
```
源码 :1423 —（无 javadoc）

```java
public static MobEffect loadMobEffect(CompoundTag nbt, String key, @Nullable MobEffect fallback)
```
源码 :1433 —（无 javadoc）

```java
public static boolean shouldSuppressEnderManAnger(EnderMan enderMan, Player player, ItemStack mask)
```
源码 :1450 —（无 javadoc）

```java
public static StructuresBecomeConfiguredFix.Conversion getStructureConversion(String originalBiome)
```
源码 :1466 —（无 javadoc）

```java
public static boolean checkStructureNamespace(String biome)
```
源码 :1474 — @hidden For internal use only.

```java
public static Map<PackType, Integer> readTypedPackFormats(JsonObject json)
```
源码 :1480 —（无 javadoc）

```java
public static void writeTypedPackFormats(JsonObject json, PackMetadataSection section)
```
源码 :1496 —（无 javadoc）

```java
public static String prefixNamespace(ResourceLocation registryKey)
```
源码 :1534 — This method is used to prefix the path, where elements of the associated registry are stored, with their namespace, if it is not minecraft This rules conflicts with equal paths out. If for example the mod `fancy_cheese` adds a registry named `cheeses`, but the mod `awesome_cheese` also adds a regist…

```java
public static boolean canUseEntitySelectors(SharedSuggestionProvider provider)
```
源码 :1539 —（无 javadoc）

```java
public static <T> HolderLookup.RegistryLookup<T> wrapRegistryLookup(final HolderLookup.RegistryLookup<T> lookup)
```
源码 :1553 —（无 javadoc）

```java
public static void onLivingBreathe(LivingEntity entity, int consumeAirAmount, int refillAirAmount)
```
源码 :1573 — Handles living entities being under water. This fires the LivingBreatheEvent and if the entity's air supply is less than or equal to zero also the LivingDrownEvent. Additionally when the entity is under water it will dismount if IForgeEntity#canBeRiddenUnderFluidType(FluidType, returns false. @param…

```java
public static void onCreativeModeTabBuildContents(CreativeModeTab tab, ResourceKey<CreativeModeTab> tabKey, CreativeModeTab.DisplayItemsGenerator originalGenerator, CreativeModeTab.ItemDisplayParameters params, CreativeModeTab.Output output)
```
源码 :1619 —（无 javadoc）

