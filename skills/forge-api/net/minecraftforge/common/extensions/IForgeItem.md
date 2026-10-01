# IForgeItem

> `net.minecraftforge.common.extensions.IForgeItem` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeItem.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（59 个）

```java
private Item self()
```
源码 :52 —（无 javadoc）

```java
default Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack)
```
源码 :61 —（无 javadoc）

```java
default boolean onDroppedByPlayer(ItemStack item, Player player)
```
源码 :74 — Called when a player drops the item into the world, returning false from this will prevent the item from being removed from the players inventory and spawning in the world @param player The player that dropped the item @param item The item stack, before the item is removed.

```java
default Component getHighlightTip(ItemStack item, Component displayName)
```
源码 :88 — Allow the item one last chance to modify its name used for the tool highlight useful for adding something extra that can't be removed by a user in the displayed name, such as a mode of operation. @param item the ItemStack for the item. @param displayName the name that will be displayed unless it is…

```java
default InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context)
```
源码 :98 — This is called when the item is used, before the block is activated. @return Return PASS to allow vanilla handling, any other to skip normal code.

```java
default boolean isPiglinCurrency(ItemStack stack)
```
源码 :108 — Called by Piglins when checking to see if they will give an item or something in exchange for this item. @return True if this item can be used as "currency" by piglins

```java
default boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer)
```
源码 :121 — Called by Piglins to check if a given item prevents hostility on sight. If this is true the Piglins will be neutral to the entity wearing this item, and will not attack on sight. Note: This does not prevent Piglins from becoming hostile due to other actions, nor does it make Piglins that are already…

```java
boolean isRepairable(ItemStack stack)
```
源码 :131 — Called by CraftingManager to determine if an item is reparable. @return True if reparable

```java
default float getXpRepairRatio(ItemStack stack)
```
源码 :137 — Determines the amount of durability the mending enchantment will repair, on average, per point of experience.

```java
default CompoundTag getShareTag(ItemStack stack)
```
源码 :159 —（无 javadoc）

```java
default void readShareTag(ItemStack stack, @Nullable CompoundTag nbt)
```
源码 :171 — Override this method to decide what to do with the NBT data received from getNBTShareTag(). @param stack The stack that received NBT @param nbt Received NBT, can be null

```java
default boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, Player player)
```
源码 :187 — Called before a block is broken. Return true to prevent default block harvesting. Note: In SMP, this is called on both client and server sides! @param itemstack The current ItemStack @param pos Block's position in world @param player The Player that is wielding the item @return True to prevent harve…

```java
default void onStopUsing(ItemStack stack, LivingEntity entity, int count)
```
源码 :210 — Called when an entity stops using an item for any reason, notably when selecting another item without releasing or finishing. This method is called in addition to any other hooks called when an item is finished using; when another hook is also called it will be called before this method. Note that i…

```java
default boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity)
```
源码 :224 — Called when the player Left Clicks (attacks) an entity. Processed before damage is done, if return value is true further processing is canceled and the entity is not attacked. @param stack The Item being used @param player The player that is attacking @param entity The entity being attacked @return…

```java
default ItemStack getCraftingRemainingItem(ItemStack itemStack)
```
源码 :237 —（无 javadoc）

```java
default boolean hasCraftingRemainingItem(ItemStack stack)
```
源码 :253 —（无 javadoc）

```java
default int getEntityLifespan(ItemStack itemStack, Level level)
```
源码 :266 — Retrieves the normal 'lifespan' of this item when it is dropped on the ground as a EntityItem. This is in ticks, standard result is 6000, or 5 mins. @param itemStack The current ItemStack @param level The level the entity is in @return The normal lifespan in ticks.

```java
default boolean hasCustomEntity(ItemStack stack)
```
源码 :281 — Determines if this Item has a special entity for when they are in the world. Is called when a EntityItem is spawned in the world, if true and Item#createCustomEntity returns non null, the EntityItem will be destroyed and the new Entity will be added to the world. @param stack The current item stack…

```java
default Entity createEntity(Level level, Entity location, ItemStack stack)
```
源码 :298 —（无 javadoc）

```java
default boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity)
```
源码 :311 — Called by the default implemetation of EntityItem's onUpdate method, allowing for cleaner control over the update of the item without having to write a subclass. @param entity The entity Item @return Return true to skip any further update code.

```java
default boolean doesSneakBypassUse(ItemStack stack, net.minecraft.world.level.LevelReader level, BlockPos pos, Player player)
```
源码 :325 — Should this item, when held, allow sneak-clicks to pass through to the underlying block? @param level The level @param pos Block position in level @param player The Player that is wielding the item

```java
default void onArmorTick(ItemStack stack, Level level, Player player)
```
源码 :334 —（无 javadoc）

```java
default void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex)
```
源码 :341 — Called to tick this items in a players inventory, the indexes are the global slot index.

```java
default boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity)
```
源码 :365 — Determines if the specific ItemStack can be placed in the specified armor slot, for the entity. @param stack The ItemStack @param armorType Armor slot to be verified. @param entity The entity trying to equip the armor @return True if the given ItemStack can be inserted in the slot

```java
default EquipmentSlot getEquipmentSlot(ItemStack stack)
```
源码 :381 —（无 javadoc）

```java
default boolean isBookEnchantable(ItemStack stack, ItemStack book)
```
源码 :393 — Allow or forbid the specific book/item combination as an anvil enchant @param stack The item @param book The book @return if the enchantment is allowed

```java
default String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type)
```
源码 :412 —（无 javadoc）

```java
default boolean onEntitySwing(ItemStack stack, LivingEntity entity)
```
源码 :423 — Called when a entity tries to play the 'swing' animation. @param entity The entity swinging the item. @return True to cancel any further processing by EntityLiving

```java
default int getDamage(ItemStack stack)
```
源码 :435 — Return the itemDamage represented by this ItemStack. Defaults to the Damage entry in the stack NBT, but can be overridden here for other sources. @param stack The itemstack that is damaged @return the damage value

```java
default int getMaxDamage(ItemStack stack)
```
源码 :448 —（无 javadoc）

```java
default boolean isDamaged(ItemStack stack)
```
源码 :460 — Return if this itemstack is damaged. Note only called if ItemStack#isDamageableItem() is true. @param stack the stack @return if the stack is damaged

```java
default void setDamage(ItemStack stack, int damage)
```
源码 :472 — Set the damage for this itemstack. Note, this method is responsible for zero checking. @param stack the stack @param damage the new damage value

```java
default boolean canPerformAction(ItemStack stack, ToolAction toolAction)
```
源码 :484 — Queries if an item can perform the given action. See ToolActions for a description of each stock action @param stack The stack being used @param toolAction The action being queried @return True if the stack can perform the action

```java
default boolean isCorrectToolForDrops(ItemStack stack, BlockState state)
```
源码 :496 — ItemStack sensitive version of Item#isCorrectToolForDrops(BlockState) @param stack The itemstack used to harvest the block @param state The block trying to harvest @return true if the stack can harvest the block

```java
default int getMaxStackSize(ItemStack stack)
```
源码 :509 —（无 javadoc）

```java
default int getEnchantmentValue(ItemStack stack)
```
源码 :520 — ItemStack sensitive version of Item#getEnchantmentValue(). @param stack The ItemStack @return the enchantment value

```java
default boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment)
```
源码 :538 — Checks whether an item can be enchanted with a certain enchantment. This applies specifically to enchanting an item in the enchanting table and is called when retrieving the list of possible enchantments for an item. Enchantments may additionally (or exclusively) be doing their own checks in Enchant…

```java
default int getEnchantmentLevel(ItemStack stack, Enchantment enchantment)
```
源码 :553 — Gets the level of the enchantment currently present on the stack. By default, returns the enchantment level present in NBT. Most enchantment implementations rely upon this method. For consistency, results of this method should be the same as getting the enchantment from #getAllEnchantments(ItemStack…

```java
default Map<Enchantment, Integer> getAllEnchantments(ItemStack stack)
```
源码 :567 — Gets a map of all enchantments present on the stack. By default, returns the enchantments present in NBT. Used in several places in code including armor enchantment hooks. For consistency, any enchantments in the returned map should include the same level in #getEnchantmentLevel(ItemStack, @param st…

```java
default boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged)
```
源码 :582 — Determine if the player switching between these two item stacks @param oldStack The old stack that was equipped @param newStack The new stack @param slotChanged If the current equipped slot was changed, Vanilla does not play the animation if you switch between two slots that hold the exact same item…

```java
default boolean shouldCauseBlockBreakReset(ItemStack oldStack, ItemStack newStack)
```
源码 :596 — Called when the player is mining a block and the item in his hand changes. Allows to not reset blockbreaking if only NBT or similar changes. @param oldStack The old stack that was used for mining. Item in players main hand @param newStack The new stack @return True to reset block break progress

```java
default boolean canContinueUsing(ItemStack oldStack, ItemStack newStack)
```
源码 :634 — Called while an item is in 'active' use to determine if usage should continue. Allows items to continue being used while sustaining damage, for example. @param oldStack the previous 'active' stack @param newStack the stack currently in the active hand @return true to set the new stack to active and…

```java
default String getCreatorModId(ItemStack itemStack)
```
源码 :658 —（无 javadoc）

```java
default net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt)
```
源码 :678 —（无 javadoc）

```java
default boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker)
```
源码 :693 — Can this Item disable a shield @param stack The ItemStack @param shield The shield in question @param entity The LivingEntity holding the shield @param attacker The LivingEntity holding the ItemStack @return True if this ItemStack can disable the shield in question.

```java
default int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType)
```
源码 :703 — @return the fuel burn time for this itemStack in a furnace. Return 0 to make it not act as a fuel. Return -1 to let the default vanilla logic decide.

```java
default void onHorseArmorTick(ItemStack stack, Level level, Mob horse)
```
源码 :716 — Called every tick from `Horse#playGallopSound(SoundEvent)` on the item in the armor slot. @param stack the armor itemstack @param level the level the horse is in @param horse the horse wearing this armor

```java
default <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken)
```
源码 :730 — Reduce the durability of this item by the amount given. This can be used to e.g. consume power from NBT before durability. @param stack The itemstack to damage @param amount The amount to damage @param entity The entity damaging the item @param onBroken The on-broken callback from vanilla @return Th…

```java
default void onDestroyed(ItemEntity itemEntity, DamageSource damageSource)
```
源码 :740 — Called when an item entity for this stack is destroyed. Note: The ItemStack can be retrieved from the item entity. @param itemEntity The item entity that was destroyed. @param damageSource Damage source that caused the item entity to "die".

```java
default boolean isEnderMask(ItemStack stack, Player player, EnderMan endermanEntity)
```
源码 :753 — Whether this Item can be used to hide player head for enderman. @param stack the ItemStack @param player The player watching the enderman @param endermanEntity The enderman that the player look @return true if this Item can be used to hide player head for enderman

```java
default boolean canElytraFly(ItemStack stack, LivingEntity entity)
```
源码 :766 — Used to determine if the player can use Elytra flight. This is called Client and Server side. @param stack The ItemStack in the Chest slot of the entity. @param entity The entity trying to fly. @return True if the entity can use Elytra flight.

```java
default boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks)
```
源码 :783 — Used to determine if the player can continue Elytra flight, this is called each tick, and can be used to apply ItemStack damage, consume Energy, or what have you. For example the Vanilla implementation of this, applies damage to the ItemStack every 20 ticks. @param stack ItemStack in the Chest slot…

```java
default boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer)
```
源码 :797 — Called by the powdered snow block to check if a living entity wearing this can walk on the snow, granting the same behavior as leather boots. Only affects items worn in the boots slot. @param stack Stack instance @param wearer The entity wearing this ItemStack @return True if the entity can walk on…

```java
default boolean isDamageable(ItemStack stack)
```
源码 :808 — Used to test if this item can be damaged, but with the ItemStack in question. Please note that in some cases no ItemStack is available, so the stack-less method will be used. @param stack ItemStack in the Chest slot of the entity.

```java
default AABB getSweepHitBox(@NotNull ItemStack stack, @NotNull Player player, @NotNull Entity target)
```
源码 :822 —（无 javadoc）

```java
default int getDefaultTooltipHideFlags(@NotNull ItemStack stack)
```
源码 :833 — Get the tooltip parts that should be hidden by default on the given stack if the `HideFlags` tag is not set. @see ItemStack.TooltipPart @param stack the stack @return the default hide flags

```java
default FoodProperties getFoodProperties(ItemStack stack, @Nullable LivingEntity entity)
```
源码 :850 —（无 javadoc）

```java
default boolean isNotReplaceableByPickAction(ItemStack stack, Player player, int inventorySlot)
```
源码 :864 — Whether the given ItemStack should be excluded (if possible) when selecting the target hotbar slot of a "pick" action. By default, this returns true for enchanted stacks. @see Inventory#getSuitableHotbarSlot() @param player the player performing the picking @param inventorySlot the inventory slot of…

```java
default boolean canGrindstoneRepair(ItemStack stack)
```
源码 :872 — true if the given ItemStack can be put into a grindstone to be repaired and/or stripped of its enchantments

