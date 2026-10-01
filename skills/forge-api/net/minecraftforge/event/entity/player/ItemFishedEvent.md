# ItemFishedEvent

> `net.minecraftforge.event.entity.player.ItemFishedEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/ItemFishedEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is called when a player fishes an item. This event is net.minecraftforge.eventbus.api.Cancelable Canceling the event will cause the player to receive no items at all. The hook will still take the damage specified

## 公开成员（5 个）

```java
public ItemFishedEvent(List<ItemStack> stacks, int rodDamage, FishingHook hook)
```
源码 :31 —（无 javadoc）

```java
public int getRodDamage()
```
源码 :43 — Get the damage the rod will take. @return The damage the rod will take

```java
public void damageRodBy(@Nonnegative int rodDamage)
```
源码 :53 — Specifies the amount of damage that the fishing rod should take. This is not added to the pre-existing damage to be taken. @param rodDamage The damage the rod will take. Must be nonnegative

```java
public NonNullList<ItemStack> getDrops()
```
源码 :64 — Use this to get the items the player will receive. You cannot use this to modify the drops the player will get. If you want to affect the loot, you should use LootTables.

```java
public FishingHook getHookEntity()
```
源码 :72 — Use this to stuff related to the hook itself, like the position of the bobber.

