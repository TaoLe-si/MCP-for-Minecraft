# IForgeItemStack

> `net.minecraftforge.common.extensions.IForgeItemStack` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeItemStack.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（44 个）

```java
private ItemStack self()
```
源码 :49 —（无 javadoc）

```java
default ItemStack getCraftingRemainingItem()
```
源码 :60 — ItemStack sensitive version of Item#getCraftingRemainingItem(). Returns a full ItemStack instance of the result. @return The resulting ItemStack

```java
default boolean hasCraftingRemainingItem()
```
源码 :70 — ItemStack sensitive version of Item#hasCraftingRemainingItem(). @return True if this item has a crafting remaining item

```java
default int getBurnTime(@Nullable RecipeType<?> recipeType)
```
源码 :80 — @return the fuel burn time for this itemStack in a furnace. Return 0 to make it not act as a fuel. Return -1 to let the default vanilla logic decide.

```java
default InteractionResult onItemUseFirst(UseOnContext context)
```
源码 :85 —（无 javadoc）

```java
default CompoundTag serializeNBT()
```
源码 :104 —（无 javadoc）

```java
default boolean canPerformAction(ToolAction toolAction)
```
源码 :117 — Queries if an item can perform the given action. See ToolActions for a description of each stock action @param toolAction The action being queried @return True if the stack can perform the action

```java
default boolean onBlockStartBreak(BlockPos pos, Player player)
```
源码 :132 — Called before a block is broken. Return true to prevent default block harvesting. Note: In SMP, this is called on both client and server sides! @param pos Block's position in world @param player The Player that is wielding the item @return True to prevent harvesting, false to continue as normal

```java
default boolean shouldCauseBlockBreakReset(ItemStack newStack)
```
源码 :144 — Called when the player is mining a block and the item in his hand changes. Allows to not reset blockbreaking if only NBT or similar changes. @param newStack The new stack @return True to reset block break progress

```java
default boolean canApplyAtEnchantingTable(Enchantment enchantment)
```
源码 :161 — Checks whether an item can be enchanted with a certain enchantment. This applies specifically to enchanting an item in the enchanting table and is called when retrieving the list of possible enchantments for an item. Enchantments may additionally (or exclusively) be doing their own checks in Enchant…

```java
default int getEnchantmentLevel(Enchantment enchantment)
```
源码 :178 — Gets the level of the enchantment currently present on the stack. By default, returns the enchantment level present in NBT. Equivalent to calling net.minecraft.world.item.enchantment.EnchantmentHelper#getItemEnchantmentLevel(Enchantment, Use in place of net.minecraft.world.item.enchantment.Enchantme…

```java
default Map<Enchantment, Integer> getAllEnchantments()
```
源码 :193 — Gets a map of all enchantments present on the stack. By default, returns the enchantments present in NBT, ignoring book enchantments. Use in place of net.minecraft.world.item.enchantment.EnchantmentHelper#getEnchantments(ItemStack) for checking presence of an enchantment in logic implementing the en…

```java
default int getEnchantmentValue()
```
源码 :203 — ItemStack sensitive version of Item#getEnchantmentValue(). @return the enchantment value of this ItemStack

```java
default EquipmentSlot getEquipmentSlot()
```
源码 :218 —（无 javadoc）

```java
default boolean canDisableShield(ItemStack shield, LivingEntity entity, LivingEntity attacker)
```
源码 :231 — Can this Item disable a shield @param shield The shield in question @param entity The LivingEntity holding the shield @param attacker The LivingEntity holding the ItemStack @return True if this ItemStack can disable the shield in question.

```java
default boolean onEntitySwing(LivingEntity entity)
```
源码 :242 — Called when a entity tries to play the 'swing' animation. @param entity The entity swinging the item. @return True to cancel any further processing by EntityLiving

```java
default void onStopUsing(LivingEntity entity, int count)
```
源码 :253 — Called when an entity stops using an item item for any reason. @param entity The entity using the item, typically a player @param count The amount of time in tick the item has been used for continuously

```java
default int getEntityLifespan(Level level)
```
源码 :265 — Retrieves the normal 'lifespan' of this item when it is dropped on the ground as a EntityItem. This is in ticks, standard result is 6000, or 5 mins. @param level The level the entity is in @return The normal lifespan in ticks.

```java
default boolean onEntityItemUpdate(ItemEntity entity)
```
源码 :278 — Called by the default implemetation of EntityItem's onUpdate method, allowing for cleaner control over the update of the item without having to write a subclass. @param entity The entity Item @return Return true to skip any further update code.

```java
default float getXpRepairRatio()
```
源码 :287 — Determines the amount of durability the mending enchantment will repair, on average, per point of experience.

```java
default void onArmorTick(Level level, Player player)
```
源码 :296 —（无 javadoc）

```java
default void onInventoryTick(Level level, Player player, int slotIndex, int selectedIndex)
```
源码 :304 — Called to tick this items in a players inventory, the indexes are the global slot index.

```java
default void onHorseArmorTick(Level level, Mob horse)
```
源码 :317 — Called every tick from `Horse#playGallopSound(SoundEvent)` on the item in the armor slot. @param level the level the horse is in @param horse the horse wearing this armor

```java
default boolean canEquip(EquipmentSlot armorType, Entity entity)
```
源码 :330 — Determines if the specific ItemStack can be placed in the specified armor slot, for the entity. @param armorType Armor slot to be verified. @param entity The entity trying to equip the armor @return True if the given ItemStack can be inserted in the slot

```java
default boolean isBookEnchantable(ItemStack book)
```
源码 :341 — Allow or forbid the specific book/item combination as an anvil enchant @param book The book @return if the enchantment is allowed

```java
default boolean onDroppedByPlayer(Player player)
```
源码 :354 — Called when a player drops the item into the world, returning false from this will prevent the item from being removed from the players inventory and spawning in the world @param player The player that dropped the item

```java
default Component getHighlightTip(Component displayName)
```
源码 :367 — Allow the item one last chance to modify its name used for the tool highlight useful for adding something extra that can't be removed by a user in the displayed name, such as a mode of operation. @param displayName the name that will be displayed unless it is changed in this method.

```java
default CompoundTag getShareTag()
```
源码 :386 —（无 javadoc）

```java
default void readShareTag(@Nullable CompoundTag nbt)
```
源码 :397 — Override this method to decide what to do with the NBT data received from getNBTShareTag(). @param nbt Received NBT, can be null

```java
default boolean doesSneakBypassUse(net.minecraft.world.level.LevelReader level, BlockPos pos, Player player)
```
源码 :410 — Should this item, when held, allow sneak-clicks to pass through to the underlying block? @param level The level @param pos Block position in level @param player The Player that is wielding the item

```java
default boolean areShareTagsEqual(ItemStack other)
```
源码 :420 — Modeled after ItemStack.areItemStackTagsEqual Uses Item.getNBTShareTag for comparison instead of NBT and capabilities. Only used for comparing itemStacks that were transferred from server to client using Item.getNBTShareTag.

```java
default boolean equals(ItemStack other, boolean limitTags)
```
源码 :437 — Determines if the ItemStack is equal to the other item stack, including Item, Count, and NBT. @param other The other stack @param limitTags True to use shareTag False to use full NBT tag @return true if equals

```java
default boolean isRepairable()
```
源码 :451 — Determines if a item is reparable, used by Repair recipes and Grindstone. @return True if reparable

```java
default boolean isPiglinCurrency()
```
源码 :461 — Called by Piglins when checking to see if they will give an item or something in exchange for this item. @return True if this item can be used as "currency" by piglins

```java
default boolean makesPiglinsNeutral(LivingEntity wearer)
```
源码 :474 — Called by Piglins to check if a given item prevents hostility on sight. If this is true the Piglins will be neutral to the entity wearing this item, and will not attack on sight. Note: This does not prevent Piglins from becoming hostile due to other actions, nor does it make Piglins that are already…

```java
default boolean isEnderMask(Player player, EnderMan endermanEntity)
```
源码 :486 — Whether this Item can be used to hide player head for enderman. @param player The player watching the enderman @param endermanEntity The enderman that the player look @return true if this Item can be used.

```java
default boolean canElytraFly(LivingEntity entity)
```
源码 :498 — Used to determine if the player can use Elytra flight. This is called Client and Server side. @param entity The entity trying to fly. @return True if the entity can use Elytra flight.

```java
default boolean elytraFlightTick(LivingEntity entity, int flightTicks)
```
源码 :514 — Used to determine if the player can continue Elytra flight, this is called each tick, and can be used to apply ItemStack damage, consume Energy, or what have you. For example the Vanilla implementation of this, applies damage to the ItemStack every 20 ticks. @param entity The entity currently in Ely…

```java
default boolean canWalkOnPowderedSnow(LivingEntity wearer)
```
源码 :527 — Called by the powdered snow block to check if a living entity wearing this can walk on the snow, granting the same behavior as leather boots. Only affects items worn in the boots slot. @param wearer The entity wearing this ItemStack @return True if the entity can walk on powdered snow

```java
default AABB getSweepHitBox(@NotNull Player player, @NotNull Entity target)
```
源码 :540 —（无 javadoc）

```java
default void onDestroyed(ItemEntity itemEntity, DamageSource damageSource)
```
源码 :551 — Called when an item entity for this stack is destroyed. Note: The ItemStack can be retrieved from the item entity. @param itemEntity The item entity that was destroyed. @param damageSource Damage source that caused the item entity to "die".

```java
default FoodProperties getFoodProperties(@Nullable LivingEntity entity)
```
源码 :567 —（无 javadoc）

```java
default boolean isNotReplaceableByPickAction(Player player, int inventorySlot)
```
源码 :581 — Whether this stack should be excluded (if possible) when selecting the target hotbar slot of a "pick" action. By default, this returns true for enchanted stacks. @see Inventory#getSuitableHotbarSlot() @param player the player performing the picking @param inventorySlot the inventory slot of the item…

```java
default boolean canGrindstoneRepair()
```
源码 :589 — true if the given ItemStack can be put into a grindstone to be repaired and/or stripped of its enchantments

