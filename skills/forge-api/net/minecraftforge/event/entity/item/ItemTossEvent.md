# ItemTossEvent

> `net.minecraftforge.event.entity.item.ItemTossEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/item/ItemTossEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Event that is fired whenever a player tosses (Q) an item or drag-n-drops a stack of items outside the inventory GUI screens. Canceling the event will stop the items from entering the world, but will not prevent them being removed from the inventory - and thus removed from the system.

## 公开成员（2 个）

```java
public ItemTossEvent(ItemEntity entityItem, Player player)
```
源码 :30 — Creates a new event for EntityItems tossed by a player. @param entityItem The EntityItem being tossed. @param player The player tossing the item.

```java
public Player getPlayer()
```
源码 :39 — The player tossing the item.

