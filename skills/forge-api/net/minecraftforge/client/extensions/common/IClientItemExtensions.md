# IClientItemExtensions

> `net.minecraftforge.client.extensions.common.IClientItemExtensions` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/extensions/common/IClientItemExtensions.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：LogicalSide#CLIENT Client-only extensions to Item. @see Item#initializeClient(Consumer)

## 公开成员（8 个）

```java
static IClientItemExtensions of(ItemStack stack)
```
源码 :41 —（无 javadoc）

```java
static IClientItemExtensions of(Item item)
```
源码 :46 —（无 javadoc）

```java
default Font getFont(ItemStack stack, FontContext context)
```
源码 :60 —（无 javadoc）

```java
default HumanoidModel.ArmPose getArmPose(LivingEntity entityLiving, InteractionHand hand, ItemStack itemStack)
```
源码 :75 —（无 javadoc）

```java
default boolean applyForgeHandTransform(PoseStack poseStack, LocalPlayer player, HumanoidArm arm, ItemStack itemInHand, float partialTick, float equipProcess, float swingProcess)
```
源码 :92 — Called right before when client applies transformations to item in hand and render it. @param poseStack The pose stack @param player The player holding the item, it's always main client player @param arm The arm holding the item @param itemInHand The held item @param partialTick Partial tick time, u…

```java
default Model getGenericArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original)
```
源码 :127 —（无 javadoc）

```java
default void renderHelmetOverlay(ItemStack stack, Player player, int width, int height, float partialTick)
```
源码 :149 — Called when the client starts rendering the HUD, and is wearing this item in the helmet slot. This is where pumpkins would render their overlay. @param stack The item stack @param player The player entity @param width The viewport width @param height Viewport height @param partialTick Partial tick t…

```java
default BlockEntityWithoutLevelRenderer getCustomRenderer()
```
源码 :161 — Queries this item's renderer. Only used if BakedModel#isCustomRenderer() returns `true` or BlockState#getRenderShape() returns net.minecraft.world.level.block.RenderShape#ENTITYBLOCK_ANIMATED. By default, returns vanilla's block entity renderer.

