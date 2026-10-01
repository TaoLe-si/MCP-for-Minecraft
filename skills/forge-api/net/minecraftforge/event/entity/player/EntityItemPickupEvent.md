# EntityItemPickupEvent

> `net.minecraftforge.event.entity.player.EntityItemPickupEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/EntityItemPickupEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is called when a player collides with a EntityItem on the ground. The event can be canceled, and no further processing will be done. You can set the result of this event to ALLOW which will trigger the processing of achievements, FML's event, play the sound, and kill the entity if all the items are picked up. setResult(ALLOW) is the same as the old setHandled()

## 公开成员（2 个）

```java
public EntityItemPickupEvent(Player player, ItemEntity item)
```
源码 :29 —（无 javadoc）

```java
public ItemEntity getItem()
```
源码 :35 —（无 javadoc）

