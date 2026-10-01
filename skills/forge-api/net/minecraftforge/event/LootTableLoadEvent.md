# LootTableLoadEvent

> `net.minecraftforge.event.LootTableLoadEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/LootTableLoadEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired when a LootTable is loaded from JSON. Loot tables loaded from world save datapacks will not fire this event as they are considered user configuration files. This event is fired whenever server resources are loaded or reloaded. This event is Cancelable cancellable, and does not HasResult have a result. If the event is cancelled, the loot table will be made empty. This event is fired on the Mi…

## 公开成员（4 个）

```java
public LootTableLoadEvent(ResourceLocation name, LootTable table)
```
源码 :32 —（无 javadoc）

```java
public ResourceLocation getName()
```
源码 :38 —（无 javadoc）

```java
public LootTable getTable()
```
源码 :43 —（无 javadoc）

```java
public void setTable(LootTable table)
```
源码 :48 —（无 javadoc）

