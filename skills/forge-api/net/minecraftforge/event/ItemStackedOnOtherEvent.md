# ItemStackedOnOtherEvent

> `net.minecraftforge.event.ItemStackedOnOtherEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/ItemStackedOnOtherEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event provides the functionality of the pair of functions used for the Bundle, in one event: Item#overrideOtherStackedOnMe(ItemStack, Item#overrideStackedOnOther(ItemStack, This event is fired before either of the above are called, when a carried item is clicked on top of another in a GUI slot. This event (and items stacking on others in general) is fired on both LogicalSide sides, but only o…

## 公开成员（7 个）

```java
public ItemStackedOnOtherEvent(ItemStack carriedItem, ItemStack stackedOnItem, Slot slot, ClickAction action, Player player, SlotAccess carriedSlotAccess)
```
源码 :47 —（无 javadoc）

```java
public ItemStack getCarriedItem()
```
源码 :60 — the stack being carried by the mouse This may be empty!

```java
public ItemStack getStackedOnItem()
```
源码 :68 — the stack currently in the slot being clicked on This may be empty!

```java
public Slot getSlot()
```
源码 :76 — the slot being clicked on

```java
public ClickAction getClickAction()
```
源码 :84 — the click action being used By default ClickAction#PRIMARY corresponds to left-click, and ClickAction#SECONDARY is right-click.

```java
public Player getPlayer()
```
源码 :92 — the player doing the item swap attempt

```java
public SlotAccess getCarriedSlotAccess()
```
源码 :100 — a fake slot allowing the listener to see and change what item is being carried

