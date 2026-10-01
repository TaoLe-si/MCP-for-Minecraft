# ForgeRegistries

> `net.minecraftforge.registries.ForgeRegistries` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/ForgeRegistries.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目用法**：所有观测回包里的 id 都是从 ForgeRegistries getKey 出来的

**职责**（源码 javadoc）：A class that exposes static references to all vanilla and Forge registries. Created to have a central place to access the registries directly if modders need. It is still advised that if you are registering things to use RegisterEvent or net.minecraftforge.registries.DeferredRegister, but queries and iterations can use this.

## 坑

- `ForgeRegistries.ITEMS.getKey(...)` 之类的返回值可能是 null（物品没注册），回包里建议 `String.valueOf(...)` 兜一下。

## 公开成员（38 个）

```java
public static final IForgeRegistry<Block> BLOCKS = RegistryManager.ACTIVE.getRegistry(Keys.BLOCKS)
```
源码 :68 —（无 javadoc）

```java
public static final IForgeRegistry<Fluid> FLUIDS = RegistryManager.ACTIVE.getRegistry(Keys.FLUIDS)
```
源码 :69 —（无 javadoc）

```java
public static final IForgeRegistry<Item> ITEMS = RegistryManager.ACTIVE.getRegistry(Keys.ITEMS)
```
源码 :70 —（无 javadoc）

```java
public static final IForgeRegistry<MobEffect> MOB_EFFECTS = RegistryManager.ACTIVE.getRegistry(Keys.MOB_E…
```
源码 :71 —（无 javadoc）

```java
public static final IForgeRegistry<SoundEvent> SOUND_EVENTS = RegistryManager.ACTIVE.getRegistry(Keys.SOUND…
```
源码 :72 —（无 javadoc）

```java
public static final IForgeRegistry<Potion> POTIONS = RegistryManager.ACTIVE.getRegistry(Keys.POTIONS)
```
源码 :73 —（无 javadoc）

```java
public static final IForgeRegistry<Enchantment> ENCHANTMENTS = RegistryManager.ACTIVE.getRegistry(Keys.ENCHA…
```
源码 :74 —（无 javadoc）

```java
public static final IForgeRegistry<EntityType<?>> ENTITY_TYPES = RegistryManager.ACTIVE.getRegistry(Keys.ENTIT…
```
源码 :75 —（无 javadoc）

```java
public static final IForgeRegistry<BlockEntityType<?>> BLOCK_ENTITY_TYPES = RegistryManager.ACTIVE.getRegistry(Keys.BLOCK…
```
源码 :76 —（无 javadoc）

```java
public static final IForgeRegistry<ParticleType<?>> PARTICLE_TYPES = RegistryManager.ACTIVE.getRegistry(Keys.PARTI…
```
源码 :77 —（无 javadoc）

```java
public static final IForgeRegistry<MenuType<?>> MENU_TYPES = RegistryManager.ACTIVE.getRegistry(Keys.MENU_…
```
源码 :78 —（无 javadoc）

```java
public static final IForgeRegistry<PaintingVariant> PAINTING_VARIANTS = RegistryManager.ACTIVE.getRegistry(Keys.PAINT…
```
源码 :79 —（无 javadoc）

```java
public static final IForgeRegistry<RecipeType<?>> RECIPE_TYPES = RegistryManager.ACTIVE.getRegistry(Keys.RECIP…
```
源码 :80 —（无 javadoc）

```java
public static final IForgeRegistry<RecipeSerializer<?>> RECIPE_SERIALIZERS = RegistryManager.ACTIVE.getRegistry(Keys.RECIP…
```
源码 :81 —（无 javadoc）

```java
public static final IForgeRegistry<Attribute> ATTRIBUTES = RegistryManager.ACTIVE.getRegistry(Keys.ATTRI…
```
源码 :82 —（无 javadoc）

```java
public static final IForgeRegistry<StatType<?>> STAT_TYPES = RegistryManager.ACTIVE.getRegistry(Keys.STAT_…
```
源码 :83 —（无 javadoc）

```java
public static final IForgeRegistry<ArgumentTypeInfo<?, ?>> COMMAND_ARGUMENT_TYPES = RegistryManager.ACTIVE.getRegistry(Keys.COMMA…
```
源码 :84 —（无 javadoc）

```java
public static final IForgeRegistry<VillagerProfession> VILLAGER_PROFESSIONS = RegistryManager.ACTIVE.getRegistry(Keys.VILLA…
```
源码 :87 —（无 javadoc）

```java
public static final IForgeRegistry<PoiType> POI_TYPES = RegistryManager.ACTIVE.getRegistry(Keys.POI_T…
```
源码 :88 —（无 javadoc）

```java
public static final IForgeRegistry<MemoryModuleType<?>> MEMORY_MODULE_TYPES = RegistryManager.ACTIVE.getRegistry(Keys.MEMOR…
```
源码 :89 —（无 javadoc）

```java
public static final IForgeRegistry<SensorType<?>> SENSOR_TYPES = RegistryManager.ACTIVE.getRegistry(Keys.SENSO…
```
源码 :90 —（无 javadoc）

```java
public static final IForgeRegistry<Schedule> SCHEDULES = RegistryManager.ACTIVE.getRegistry(Keys.SCHED…
```
源码 :91 —（无 javadoc）

```java
public static final IForgeRegistry<Activity> ACTIVITIES = RegistryManager.ACTIVE.getRegistry(Keys.ACTIV…
```
源码 :92 —（无 javadoc）

```java
public static final IForgeRegistry<WorldCarver<?>> WORLD_CARVERS = RegistryManager.ACTIVE.getRegistry(Keys.WORLD…
```
源码 :95 —（无 javadoc）

```java
public static final IForgeRegistry<Feature<?>> FEATURES = RegistryManager.ACTIVE.getRegistry(Keys.FEATU…
```
源码 :96 —（无 javadoc）

```java
public static final IForgeRegistry<ChunkStatus> CHUNK_STATUS = RegistryManager.ACTIVE.getRegistry(Keys.CHUNK…
```
源码 :97 —（无 javadoc）

```java
public static final IForgeRegistry<BlockStateProviderType<?>> BLOCK_STATE_PROVIDER_TYPES = RegistryManager.ACTIVE.getRegistry(Keys.BLOCK…
```
源码 :98 —（无 javadoc）

```java
public static final IForgeRegistry<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = RegistryManager.ACTIVE.getRegistry(Keys.FOLIA…
```
源码 :99 —（无 javadoc）

```java
public static final IForgeRegistry<TreeDecoratorType<?>> TREE_DECORATOR_TYPES = RegistryManager.ACTIVE.getRegistry(Keys.TREE_…
```
源码 :100 —（无 javadoc）

```java
public static final IForgeRegistry<Biome> BIOMES = RegistryManager.ACTIVE.getRegistry(Keys.BIOMES)
```
源码 :103 —（无 javadoc）

```java
public static final Supplier<IForgeRegistry<EntityDataSerializer<?>>> ENTITY_DATA_SERIALIZERS = DEFERRED_ENTITY_DATA_SERIALIZERS.makeRegistry…
```
源码 :111 — Calling Supplier#get() before NewRegistryEvent is fired will result in a null registry returned. Use Keys#ENTITY_DATA_SERIALIZERS to create a DeferredRegister.

```java
public static final Supplier<IForgeRegistry<Codec<? extends IGlobalLootModifier>>> GLOBAL_LOOT_MODIFIER_SERIALIZERS = DEFERRED_GLOBAL_LOOT_MODIFIER_SERIALIZERS.mak…
```
源码 :117 — Calling Supplier#get() before NewRegistryEvent is fired will result in a null registry returned. Use Keys#GLOBAL_LOOT_MODIFIER_SERIALIZERS to create a DeferredRegister.

```java
public static final Supplier<IForgeRegistry<Codec<? extends BiomeModifier>>> BIOME_MODIFIER_SERIALIZERS = DEFERRED_BIOME_MODIFIER_SERIALIZERS.makeRegis…
```
源码 :123 — Calling Supplier#get() before NewRegistryEvent is fired will result in a null registry returned. Use Keys#BIOME_MODIFIER_SERIALIZERS to create a DeferredRegister.

```java
public static final Supplier<IForgeRegistry<Codec<? extends StructureModifier>>> STRUCTURE_MODIFIER_SERIALIZERS = DEFERRED_STRUCTURE_MODIFIER_SERIALIZERS.makeR…
```
源码 :129 — Calling Supplier#get() before NewRegistryEvent is fired will result in a null registry returned. Use Keys#STRUCTURE_MODIFIER_SERIALIZERS to create a DeferredRegister.

```java
public static final Supplier<IForgeRegistry<FluidType>> FLUID_TYPES = DEFERRED_FLUID_TYPES.makeRegistry(GameData::g…
```
源码 :135 — Calling Supplier#get() before NewRegistryEvent is fired will result in a null registry returned. Use Keys#FLUID_TYPES to create a DeferredRegister.

```java
public static final Supplier<IForgeRegistry<HolderSetType>> HOLDER_SET_TYPES = DEFERRED_HOLDER_SET_TYPES.makeRegistry(GameDa…
```
源码 :141 — Calling Supplier#get() before NewRegistryEvent is fired will result in a null registry returned. Use Keys#HOLDER_SET_TYPES to create a DeferredRegister.

```java
public static final Supplier<IForgeRegistry<ItemDisplayContext>> DISPLAY_CONTEXTS = DEFERRED_DISPLAY_CONTEXTS.makeRegistry(GameDa…
```
源码 :148 — Calling Supplier#get() before NewRegistryEvent is fired will result in a null registry returned. Use Keys#DISPLAY_CONTEXTS to create a DeferredRegister.

```java
public static final class Keys
```
源码 :150 —（无 javadoc）

