# ItemEvent

> `net.minecraftforge.event.entity.item.ItemEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/item/ItemEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Base class for all ItemEntity events. Contains a reference to the ItemEntity of interest. For most ItemEntity events, there's little to no additional useful data from the firing method that isn't already contained within the ItemEntity instance.

## 公开成员（2 个）

```java
public ItemEvent(ItemEntity itemEntity)
```
源码 :26 — Creates a new event for an ItemEntity. @param itemEntity The ItemEntity for this event

```java
public ItemEntity getEntity()
```
源码 :36 —（无 javadoc）

