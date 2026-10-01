# ForgeMod

> `net.minecraftforge.common.ForgeMod` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/ForgeMod.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目用法**：BLOCK_REACH/ENTITY_REACH 属性的注册者

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（40 个）

```java
public static final String VERSION_CHECK_CAT = "version_checking"
```
源码 :134 —（无 javadoc）

```java
public static final RegistryObject<Attribute> SWIM_SPEED = ATTRIBUTES.register("swim_speed", () -> new R…
```
源码 :151 —（无 javadoc）

```java
public static final RegistryObject<Attribute> NAMETAG_DISTANCE = ATTRIBUTES.register("nametag_distance", () ->…
```
源码 :152 —（无 javadoc）

```java
public static final RegistryObject<Attribute> ENTITY_GRAVITY = ATTRIBUTES.register("entity_gravity", () -> n…
```
源码 :153 —（无 javadoc）

```java
public static final RegistryObject<Attribute> BLOCK_REACH = ATTRIBUTES.register("block_reach", () -> new …
```
源码 :160 — Reach Distance represents the distance at which a player may interact with the world. The default is 4.5 blocks. Players in creative mode have an additional 0.5 blocks of block reach. @see IForgePlayer#getBlockReach() @see IForgePlayer#canReach(BlockPos, double)

```java
public static final RegistryObject<Attribute> ENTITY_REACH = ATTRIBUTES.register("entity_reach", () -> new…
```
源码 :169 — Attack Range represents the distance at which a player may attack an entity. The default is 3 blocks. Players in creative mode have an additional 3 blocks of entity reach. The default of 3.0 is technically considered a bug by Mojang - see MC-172289 and MC-92484. However, updating this value would al…

```java
public static final RegistryObject<Attribute> STEP_HEIGHT_ADDITION = ATTRIBUTES.register("step_height_addition", (…
```
源码 :175 — Step Height Addition modifies the amount of blocks an entity may walk up without jumping. @see IForgeEntity#getStepHeight()

```java
public static final RegistryObject<Codec<NoneBiomeModifier>> NONE_BIOME_MODIFIER_TYPE = BIOME_MODIFIER_SERIALIZERS.register("none", (…
```
源码 :180 — Noop biome modifier. Can be used in a biome modifier json with "type": "forge:none".

```java
public static final RegistryObject<Codec<AddFeaturesBiomeModifier>> ADD_FEATURES_BIOME_MODIFIER_TYPE = BIOME_MODIFIER_SERIALIZERS.register("add_feat…
```
源码 :185 — Stock biome modifier for adding features to biomes.

```java
public static final RegistryObject<Codec<RemoveFeaturesBiomeModifier>> REMOVE_FEATURES_BIOME_MODIFIER_TYPE = BIOME_MODIFIER_SERIALIZERS.register("remove_f…
```
源码 :196 — Stock biome modifier for removing features from biomes.

```java
public static final RegistryObject<Codec<AddSpawnsBiomeModifier>> ADD_SPAWNS_BIOME_MODIFIER_TYPE = BIOME_MODIFIER_SERIALIZERS.register("add_spaw…
```
源码 :210 — Stock biome modifier for adding mob spawns to biomes.

```java
public static final RegistryObject<Codec<RemoveSpawnsBiomeModifier>> REMOVE_SPAWNS_BIOME_MODIFIER_TYPE = BIOME_MODIFIER_SERIALIZERS.register("remove_s…
```
源码 :225 — Stock biome modifier for removing mob spawns from biomes.

```java
public static final RegistryObject<Codec<NoneStructureModifier>> NONE_STRUCTURE_MODIFIER_TYPE = STRUCTURE_MODIFIER_SERIALIZERS.register("none…
```
源码 :234 — Noop structure modifier. Can be used in a structure modifier json with "type": "forge:none".

```java
public static final RegistryObject<HolderSetType> ANY_HOLDER_SET = HOLDER_SET_TYPES.register("any", () -> AnyHol…
```
源码 :239 — Stock holder set type that represents any/all values in a registry. Can be used in a holderset object with `{ "type": "forge:any" `}

```java
public static final RegistryObject<HolderSetType> AND_HOLDER_SET = HOLDER_SET_TYPES.register("and", () -> AndHol…
```
源码 :244 — Stock holder set type that represents an intersection of other holdersets. Can be used in a holderset object with `{ "type": "forge:and", "values": [list of holdersets] `}

```java
public static final RegistryObject<HolderSetType> OR_HOLDER_SET = HOLDER_SET_TYPES.register("or", () -> OrHolde…
```
源码 :249 — Stock holder set type that represents a union of other holdersets. Can be used in a holderset object with `{ "type": "forge:or", "values": [list of holdersets] `}

```java
public static final RegistryObject<HolderSetType> NOT_HOLDER_SET = HOLDER_SET_TYPES.register("not", () -> NotHol…
```
源码 :255 — Stock holder set type that represents all values in a registry except those in another given set. Can be used in a holderset object with `{ "type": "forge:not", "value": holderset `}

```java
public static final RegistryObject<FluidType> EMPTY_TYPE = VANILLA_FLUID_TYPES.register("empty", () -> n…
```
源码 :259 —（无 javadoc）

```java
public static final RegistryObject<FluidType> WATER_TYPE = VANILLA_FLUID_TYPES.register("water", () -> n…
```
源码 :279 —（无 javadoc）

```java
public static final RegistryObject<FluidType> LAVA_TYPE = VANILLA_FLUID_TYPES.register("lava", () -> ne…
```
源码 :346 —（无 javadoc）

```java
public static final RegistryObject<SoundEvent> BUCKET_EMPTY_MILK = RegistryObject.create(new ResourceLocation("i…
```
源码 :397 —（无 javadoc）

```java
public static final RegistryObject<SoundEvent> BUCKET_FILL_MILK = RegistryObject.create(new ResourceLocation("i…
```
源码 :398 —（无 javadoc）

```java
public static final RegistryObject<FluidType> MILK_TYPE = RegistryObject.createOptional(new ResourceLoc…
```
源码 :399 —（无 javadoc）

```java
public static final RegistryObject<Fluid> MILK = RegistryObject.create(new ResourceLocation("m…
```
源码 :400 —（无 javadoc）

```java
public static final RegistryObject<Fluid> FLOWING_MILK = RegistryObject.create(new ResourceLocation("f…
```
源码 :401 —（无 javadoc）

```java
public static ForgeMod getInstance()
```
源码 :404 —（无 javadoc）

```java
public static void enableMilkFluid()
```
源码 :412 — Run this method during mod constructor to enable milk and add it to the Minecraft milk bucket

```java
public ForgeMod(FMLJavaModLoadingContext context)
```
源码 :417 —（无 javadoc）

```java
public void preInit(FMLCommonSetupEvent evt)
```
源码 :475 —（无 javadoc）

```java
public void loadComplete(FMLLoadCompleteEvent event)
```
源码 :481 —（无 javadoc）

```java
public void serverStopping(ServerStoppingEvent evt)
```
源码 :485 —（无 javadoc）

```java
public void mappingChanged(IdMappingEvent evt)
```
源码 :490 —（无 javadoc）

```java
public void gatherData(GatherDataEvent event)
```
源码 :495 —（无 javadoc）

```java
public void missingSoundMapping(MissingMappingsEvent event)
```
源码 :522 —（无 javadoc）

```java
public void registerFluids(RegisterEvent event)
```
源码 :545 —（无 javadoc）

```java
public void registerVanillaDisplayContexts(RegisterEvent event)
```
源码 :596 —（无 javadoc）

```java
public void registerRecipeSerializers(RegisterEvent event)
```
源码 :610 —（无 javadoc）

```java
public void registerLootData(RegisterEvent event)
```
源码 :634 —（无 javadoc）

```java
public static final PermissionNode<Boolean> USE_SELECTORS_PERMISSION = new PermissionNode<>("forge", "use_entity_sel…
```
源码 :643 —（无 javadoc）

```java
public void registerPermissionNodes(PermissionGatherEvent.Nodes event)
```
源码 :646 —（无 javadoc）

