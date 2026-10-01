# ItemExpireEvent

> `net.minecraftforge.event.entity.item.ItemExpireEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/item/ItemExpireEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Event that is fired when an EntityItem's age has reached its maximum lifespan. Canceling this event will prevent the EntityItem from being flagged as dead, thus staying it's removal from the world. If canceled it will add more time to the entities life equal to extraLife.

## 公开成员（3 个）

```java
public ItemExpireEvent(ItemEntity entityItem, int extraLife)
```
源码 :29 — Creates a new event for an expiring EntityItem. @param entityItem The EntityItem being deleted. @param extraLife The amount of time to be added to this entities lifespan if the event is canceled.

```java
public int getExtraLife()
```
源码 :35 —（无 javadoc）

```java
public void setExtraLife(int extraLife)
```
源码 :40 —（无 javadoc）

