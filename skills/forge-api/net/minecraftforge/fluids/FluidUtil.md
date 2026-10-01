# FluidUtil

> `net.minecraftforge.fluids.FluidUtil` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fluids/FluidUtil.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（16 个）

```java
public static boolean interactWithFluidHandler(@NotNull Player player, @NotNull InteractionHand hand, @NotNull Level level, @NotNull BlockPos pos, @Nullable Direction side)
```
源码 :64 — Used to handle the common case of a player holding a fluid item and right-clicking on a fluid handler block. First it tries to fill the item from the block, if that action fails then it tries to drain the item into the block. Automatically updates the item in the player's hand and stashes any extra…

```java
public static boolean interactWithFluidHandler(@NotNull Player player, @NotNull InteractionHand hand, @NotNull IFluidHandler handler)
```
源码 :83 — Used to handle the common case of a player holding a fluid item and right-clicking on a fluid handler. First it tries to fill the item from the handler, if that action fails then it tries to drain the item into the handler. Automatically updates the item in the player's hand and stashes any extra it…

```java
public static FluidActionResult tryFillContainer(@NotNull ItemStack container, IFluidHandler fluidSource, int maxAmount, @Nullable Player player, boolean doFill)
```
源码 :126 —（无 javadoc）

```java
public static FluidActionResult tryEmptyContainer(@NotNull ItemStack container, IFluidHandler fluidDestination, int maxAmount, @Nullable Player player, boolean doDrain)
```
源码 :176 —（无 javadoc）

```java
public static FluidActionResult tryFillContainerAndStow(@NotNull ItemStack container, IFluidHandler fluidSource, IItemHandler inventory, int maxAmount, @Nullable Player player, boolean doFill)
```
源码 :225 —（无 javadoc）

```java
public static FluidActionResult tryEmptyContainerAndStow(@NotNull ItemStack container, IFluidHandler fluidDestination, IItemHandler inventory, int maxAmount, @Nullable Player player, boolean doDrain)
```
源码 :293 —（无 javadoc）

```java
public static FluidStack tryFluidTransfer(IFluidHandler fluidDestination, IFluidHandler fluidSource, int maxAmount, boolean doTransfer)
```
源码 :356 —（无 javadoc）

```java
public static FluidStack tryFluidTransfer(IFluidHandler fluidDestination, IFluidHandler fluidSource, FluidStack resource, boolean doTransfer)
```
源码 :378 —（无 javadoc）

```java
public static LazyOptional<IFluidHandlerItem> getFluidHandler(@NotNull ItemStack itemStack)
```
源码 :431 — Helper method to get an IFluidHandlerItem for an itemStack. The itemStack passed in here WILL be modified, the IFluidHandlerItem acts on it directly. Some IFluidHandlerItem will change the item entirely, always use IFluidHandlerItem#getContainer() after using the fluid handler to get the resulting i…

```java
public static Optional<FluidStack> getFluidContained(@NotNull ItemStack container)
```
源码 :439 — Helper method to get the fluid contained in an itemStack

```java
public static LazyOptional<IFluidHandler> getFluidHandler(Level level, BlockPos blockPos, @Nullable Direction side)
```
源码 :457 — Helper method to get an IFluidHandler for at a block position.

```java
public static FluidActionResult tryPickUpFluid(@NotNull ItemStack emptyContainer, @Nullable Player playerIn, Level level, BlockPos pos, Direction side)
```
源码 :483 —（无 javadoc）

```java
public static FluidActionResult tryPlaceFluid(@Nullable Player player, Level level, InteractionHand hand, BlockPos pos, @NotNull ItemStack container, FluidStack resource)
```
源码 :526 —（无 javadoc）

```java
public static boolean tryPlaceFluid(@Nullable Player player, Level level, InteractionHand hand, BlockPos pos, IFluidHandler fluidSource, FluidStack resource)
```
源码 :552 — Tries to place a fluid resource into the level as a block and drains the fluidSource. Makes a fluid emptying or vaporization sound when successful. Honors the amount of fluid contained by the used container. Checks if water-like fluids should vaporize like in the nether. Modeled after BucketItem#emp…

```java
public static void destroyBlockOnFluidPlacement(Level level, BlockPos pos)
```
源码 :640 — Destroys a block when a fluid is placed in the same position. Modeled after BucketItem#emptyContents(Player, This is a helper method for implementing IFluidBlock#place(Level,. @param level the level that the fluid will be placed in @param pos the location that the fluid will be placed

```java
public static ItemStack getFilledBucket(@NotNull FluidStack fluidStack)
```
源码 :661 —（无 javadoc）

