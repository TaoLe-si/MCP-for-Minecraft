# PlayerDestroyItemEvent

> `net.minecraftforge.event.entity.player.PlayerDestroyItemEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/PlayerDestroyItemEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：PlayerDestroyItemEvent is fired when a player destroys an item. This event is fired whenever a player destroys an item in MultiPlayerGameMode#destroyBlock(BlockPos), MultiPlayerGameMode#useItem(Player,, MultiPlayerGameMode#useItemOn(LocalPlayer, , Player#attack(Entity), `Player#hurtCurrentlyUsedShield(float)`, Player#interactOn(Entity,, ForgeHooks#getCraftingRemainingItem(ItemStack), ServerPlayerG…

## 公开成员（2 个）

```java
public PlayerDestroyItemEvent(Player player, @NotNull ItemStack original, @Nullable InteractionHand hand)
```
源码 :56 —（无 javadoc）

```java
public ItemStack getOriginal() { return this.original; } @Nullable public InteractionHand getHand() { return this.hand; } }
```
源码 :64 —（无 javadoc）

