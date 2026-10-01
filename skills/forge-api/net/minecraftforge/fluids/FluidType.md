# FluidType

> `net.minecraftforge.fluids.FluidType` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fluids/FluidType.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**（源码 javadoc）：A definition of common attributes, properties, and methods that is applied to a Fluid. This is used to link a flowing and source fluid together without relying on tags. Most accessors do not correlate to in-game features; they are provided for mods to take advantage of. Accessors are typically implemented in a method call chain. As such, it can provide a general implementation while more specific…

## 公开成员（60 个）

```java
public static final int BUCKET_VOLUME = 1000
```
源码 :65 — The number of fluid units that a bucket represents.

```java
public static final Lazy<Integer> SIZE = Lazy.of(() -> ForgeRegistries.FLUID_TYPES.get…
```
源码 :71 — A lazy value which computes the number of fluid types within the registry.

```java
protected final Map<SoundAction, SoundEvent> sounds
```
源码 :94 — A map of actions performed to sound that should be played.

```java
public FluidType(final Properties properties)
```
源码 :101 — Default constructor. @param properties the general properties of the fluid type

```java
public Component getDescription()
```
源码 :132 — Returns the component representing the name of the fluid type. @return the component representing the name of the fluid type

```java
public String getDescriptionId()
```
源码 :144 — Returns the identifier representing the name of the fluid type. If no identifier was specified, then the identifier will be defaulted to `fluid_type..`. @return the identifier representing the name of the fluid type

```java
public int getLightLevel()
```
源码 :162 — Returns the light level emitted by the fluid. Note: This should be a value between `[0,15]`. If not specified, the light level is `0` as most fluids do not emit light. Implementation: This is used by the bucket model to determine whether the fluid should render full-bright when `applyFluidLuminosity…

```java
public int getDensity()
```
源码 :176 — Returns the density of the fluid. Note: This is an arbitrary number. Negative or zero values indicate that the fluid is lighter than air. If not specified, the density is approximately equivalent to the real-life density of water in `kg/m^3`. @return the density of the fluid

```java
public int getTemperature()
```
源码 :190 — Returns the temperature of the fluid. Note: This is an arbitrary number. Higher temperature values indicate that the fluid is hotter. If not specified, the temperature is approximately equivalent to the real-life room temperature of water in `Kelvin`. @return the temperature of the fluid

```java
public int getViscosity()
```
源码 :205 — Returns the viscosity, or thickness, of the fluid. Note: This is an arbitrary number. The value should never be negative. Higher viscosity values indicate that the fluid flows more slowly. If not specified, the viscosity is approximately equivalent to the real-life viscosity of water in `m/s^2`. @re…

```java
public Rarity getRarity()
```
源码 :217 — Returns the rarity of the fluid. Note: If not specified, the rarity of the fluid is Rarity#COMMON. @return the rarity of the fluid

```java
public SoundEvent getSound(SoundAction action)
```
源码 :230 —（无 javadoc）

```java
public double motionScale(Entity entity)
```
源码 :244 — Returns how much the velocity of the fluid should be scaled by when applied to an entity. @param entity the entity in the fluid @return a scalar to multiply to the fluid velocity

```java
public boolean canPushEntity(Entity entity)
```
源码 :255 — Returns whether the fluid can push an entity. @param entity the entity in the fluid @return `true` if the entity can be pushed by the fluid, `false` otherwise

```java
public boolean canSwim(Entity entity)
```
源码 :266 — Returns whether the entity can swim in the fluid. @param entity the entity in the fluid @return `true` if the entity can swim in the fluid, `false` otherwise

```java
public float getFallDistanceModifier(Entity entity)
```
源码 :281 — Returns how much the fluid should scale the damage done to a falling entity when hitting the ground per tick. Implementation: If the entity is in many fluids, the smallest modifier is applied. @param entity the entity in the fluid @return a scalar to multiply to the fall damage

```java
public boolean canExtinguish(Entity entity)
```
源码 :292 — Returns whether the entity can be extinguished by this fluid. @param entity the entity in the fluid @return `true` if the entity can be extinguished, `false` otherwise

```java
public boolean move(FluidState state, LivingEntity entity, Vec3 movementVector, double gravity)
```
源码 :308 — Performs how an entity moves when within the fluid. If using custom movement logic, the method should return `true`. Otherwise, the movement logic will default to water. @param state the state of the fluid @param entity the entity moving within the fluid @param movementVector the velocity of how the…

```java
public boolean canDrownIn(LivingEntity entity)
```
源码 :319 — Returns whether the entity can drown in the fluid. @param entity the entity in the fluid @return `true` if the entity can drown in the fluid, `false` otherwise

```java
public void setItemMovement(ItemEntity entity)
```
源码 :329 — Performs what to do when an item is in a fluid. @param entity the item in the fluid

```java
public boolean supportsBoating(Boat boat)
```
源码 :341 — Returns whether the boat can be used on the fluid. @param boat the boat trying to be used on the fluid @return `true` if the boat can be used, `false` otherwise

```java
public boolean supportsBoating(FluidState state, Boat boat)
```
源码 :353 — Returns whether the boat can be used on the fluid. @param state the state of the fluid @param boat the boat trying to be used on the fluid @return `true` if the boat can be used, `false` otherwise

```java
public boolean shouldUpdateWhileBoating(FluidState state, Boat boat, Entity rider)
```
源码 :367 — When `false`, the fluid will no longer update its height value while within a boat while it is not within a fluid (Boat#isUnderWater(). @param state the state of the fluid the rider is within @param boat the boat the rider is within that is not inside a fluid @param rider the rider of the boat @retu…

```java
public boolean canRideVehicleUnder(Entity vehicle, Entity rider)
```
源码 :380 — Returns whether the entity can ride in this vehicle under the fluid. @param vehicle the vehicle being ridden in @param rider the entity riding the vehicle @return `true` if the vehicle can be ridden in under this fluid, `false` otherwise

```java
public boolean canHydrate(Entity entity)
```
源码 :395 — Returns whether the entity can be hydrated by this fluid. Hydration is an arbitrary word which depends on the entity. @param entity the entity in the fluid @return `true` if the entity can be hydrated, `false` otherwise

```java
public SoundEvent getSound(Entity entity, SoundAction action)
```
源码 :410 —（无 javadoc）

```java
public boolean canExtinguish(FluidState state, BlockGetter getter, BlockPos pos)
```
源码 :425 — Returns whether the block can be extinguished by this fluid. @param state the state of the fluid @param getter the getter which can get the fluid @param pos the position of the fluid @return `true` if the block can be extinguished, `false` otherwise

```java
public boolean canConvertToSource(FluidState state, LevelReader reader, BlockPos pos)
```
源码 :438 — Returns whether the fluid can create a source. @param state the state of the fluid @param reader the reader that can get the fluid @param pos the location of the fluid @return `true` if the fluid can create a source, `false` otherwise

```java
public BlockPathTypes getBlockPathType(FluidState state, BlockGetter level, BlockPos pos, @Nullable Mob mob, boolean canFluidLog)
```
源码 :456 —（无 javadoc）

```java
public BlockPathTypes getAdjacentBlockPathType(FluidState state, BlockGetter level, BlockPos pos, @Nullable Mob mob, BlockPathTypes originalType)
```
源码 :475 —（无 javadoc）

```java
public SoundEvent getSound(@Nullable Player player, BlockGetter getter, BlockPos pos, SoundAction action)
```
源码 :491 —（无 javadoc）

```java
public boolean canHydrate(FluidState state, BlockGetter getter, BlockPos pos, BlockState source, BlockPos sourcePos)
```
源码 :513 — Returns whether the block can be hydrated by a fluid. Hydration is an arbitrary word which depends on the block. A farmland has moisture A sponge can soak up the liquid A coral can live @param state the state of the fluid @param getter the getter which can get the fluid @param pos the position of th…

```java
public int getLightLevel(FluidState state, BlockAndTintGetter getter, BlockPos pos)
```
源码 :529 — Returns the light level emitted by the fluid. Note: This should be a value between `[0,15]`. If not specified, the light level is `0` as most fluids do not emit light. @param state the state of the fluid @param getter the getter which can get the fluid @param pos the position of the fluid @return th…

```java
public int getDensity(FluidState state, BlockAndTintGetter getter, BlockPos pos)
```
源码 :546 — Returns the density of the fluid. Note: This is an arbitrary number. Negative or zero values indicate that the fluid is lighter than air. If not specified, the density is approximately equivalent to the real-life density of water in `kg/m^3`. @param state the state of the fluid @param getter the get…

```java
public int getTemperature(FluidState state, BlockAndTintGetter getter, BlockPos pos)
```
源码 :563 — Returns the temperature of the fluid. Note: This is an arbitrary number. Higher temperature values indicate that the fluid is hotter. If not specified, the temperature is approximately equivalent to the real-life room temperature of water in `Kelvin`. @param state the state of the fluid @param gette…

```java
public int getViscosity(FluidState state, BlockAndTintGetter getter, BlockPos pos)
```
源码 :581 — Returns the viscosity, or thickness, of the fluid. Note: This is an arbitrary number. The value should never be negative. Higher viscosity values indicate that the fluid flows more slowly. If not specified, the viscosity is approximately equivalent to the real-life viscosity of water in `m/s^2`. @pa…

```java
public boolean canConvertToSource(FluidStack stack)
```
源码 :594 — Returns whether the fluid can create a source. @param stack the stack holding the fluid @return `true` if the fluid can create a source, `false` otherwise

```java
public SoundEvent getSound(FluidStack stack, SoundAction action)
```
源码 :608 —（无 javadoc）

```java
public Component getDescription(FluidStack stack)
```
源码 :619 — Returns the component representing the name of the fluid type. @param stack the stack holding the fluid @return the component representing the name of the fluid type

```java
public String getDescriptionId(FluidStack stack)
```
源码 :632 — Returns the identifier representing the name of the fluid. If no identifier was specified, then the identifier will be defaulted to `fluid_type..`. @param stack the stack holding the fluid @return the identifier representing the name of the fluid

```java
public boolean canHydrate(FluidStack stack)
```
源码 :645 — Returns whether the fluid can hydrate. Hydration is an arbitrary word which depends on the implementation. @param stack the stack holding the fluid @return `true` if the fluid can hydrate, `false` otherwise

```java
public int getLightLevel(FluidStack stack)
```
源码 :659 — Returns the light level emitted by the fluid. Note: This should be a value between `[0,15]`. If not specified, the light level is `0` as most fluids do not emit light. @param stack the stack holding the fluid @return the light level emitted by the fluid

```java
public int getDensity(FluidStack stack)
```
源码 :674 — Returns the density of the fluid. Note: This is an arbitrary number. Negative or zero values indicate that the fluid is lighter than air. If not specified, the density is approximately equivalent to the real-life density of water in `kg/m^3`. @param stack the stack holding the fluid @return the dens…

```java
public int getTemperature(FluidStack stack)
```
源码 :689 — Returns the temperature of the fluid. Note: This is an arbitrary number. Higher temperature values indicate that the fluid is hotter. If not specified, the temperature is approximately equivalent to the real-life room temperature of water in `Kelvin`. @param stack the stack holding the fluid @return…

```java
public int getViscosity(FluidStack stack)
```
源码 :705 — Returns the viscosity, or thickness, of the fluid. Note: This is an arbitrary number. The value should never be negative. Higher viscosity values indicate that the fluid flows more slowly. If not specified, the viscosity is approximately equivalent to the real-life viscosity of water in `m/s^2`. @pa…

```java
public Rarity getRarity(FluidStack stack)
```
源码 :718 — Returns the rarity of the fluid. Note: If not specified, the rarity of the fluid is Rarity#COMMON. @param stack the stack holding the fluid @return the rarity of the fluid

```java
public final boolean isAir()
```
源码 :730 — Returns whether the fluid type represents air. @return `true` if the type represents air, `false` otherwise

```java
public final boolean isVanilla()
```
源码 :740 — Returns whether the fluid type is from vanilla. @return `true` if the type is from vanilla, `false` otherwise

```java
public ItemStack getBucket(FluidStack stack)
```
源码 :751 — Returns the bucket containing the fluid. @param stack the stack holding the fluid @return the bucket containing the fluid

```java
public BlockState getBlockForFluidState(BlockAndTintGetter getter, BlockPos pos, FluidState state)
```
源码 :764 — Returns the associated BlockState for a FluidState. @param getter the getter which can get the level data @param pos the position of where the fluid would be @param state the state of the fluid @return the BlockState of a fluid

```java
public FluidState getStateForPlacement(BlockAndTintGetter getter, BlockPos pos, FluidStack stack)
```
源码 :778 — Returns the FluidState when a FluidStack is trying to place it. @param getter the getter which can get the level data @param pos the position of where the fluid is being placed @param stack the stack holding the fluid @return the FluidState being placed

```java
public final boolean canBePlacedInLevel(BlockAndTintGetter getter, BlockPos pos, FluidState state)
```
源码 :791 — Returns whether the fluid can be placed in the level. @param getter the getter which can get the level data @param pos the position of where the fluid is being placed @param state the state of the fluid being placed @return `true` if the fluid can be placed, `false` otherwise

```java
public final boolean canBePlacedInLevel(BlockAndTintGetter getter, BlockPos pos, FluidStack stack)
```
源码 :804 — Returns whether the fluid can be placed in the level. @param getter the getter which can get the level data @param pos the position of where the fluid is being placed @param stack the stack holding the fluid @return `true` if the fluid can be placed, `false` otherwise

```java
public final boolean isLighterThanAir()
```
源码 :820 — Returns whether a fluid is lighter than air. If the fluid's density is lower than or equal `0`, the fluid is considered lighter than air. Tip: `0` is the "canonical" density of air within Forge. Note: Fluids lighter than air will have their bucket model rotated upside-down; fluid block models will h…

```java
public boolean isVaporizedOnPlacement(Level level, BlockPos pos, FluidStack stack)
```
源码 :838 — Determines if this fluid should be vaporized when placed into a level. Note: Fluids that can turn lava into obsidian should vaporize within the nether to preserve the intentions of vanilla. @param level the level the fluid is being placed in @param pos the position to place the fluid at @param stack…

```java
public void onVaporize(@Nullable Player player, Level level, BlockPos pos, FluidStack stack)
```
源码 :859 — Performs an action when a fluid can be vaporized when placed into a level. Note: The fluid will already have been drained from the stack. @param player the player placing the fluid, may be `null` for blocks like dispensers @param level the level the fluid is vaporized in @param pos the position the…

```java
public String toString()
```
源码 :869 —（无 javadoc）

```java
public Object getRenderPropertiesInternal()
```
源码 :880 —（无 javadoc）

```java
public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer)
```
源码 :899 —（无 javadoc）

```java
public static final class Properties
```
源码 :907 — The properties of the fluid. The simple forms of each property can be specified while more complex logic can be overridden in the FluidType.

