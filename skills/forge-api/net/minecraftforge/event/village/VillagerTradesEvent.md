# VillagerTradesEvent

> `net.minecraftforge.event.village.VillagerTradesEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/village/VillagerTradesEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：VillagerTradesEvent is fired during the ServerAboutToStartEvent. It is used to gather the trade lists for each profession. It is fired on the MinecraftForge#EVENT_BUS. It is fired once for each registered villager profession. Villagers pick two trades from their trade map, based on their level. Villager level is increased by successful trades. The map is populated for levels 1-5 (inclusive), so Ma…

## 公开成员（5 个）

```java
protected Int2ObjectMap<List<ItemListing>> trades
```
源码 :32 —（无 javadoc）

```java
protected VillagerProfession type
```
源码 :33 —（无 javadoc）

```java
public VillagerTradesEvent(Int2ObjectMap<List<ItemListing>> trades, VillagerProfession type)
```
源码 :35 —（无 javadoc）

```java
public Int2ObjectMap<List<ItemListing>> getTrades()
```
源码 :41 —（无 javadoc）

```java
public VillagerProfession getType()
```
源码 :46 —（无 javadoc）

