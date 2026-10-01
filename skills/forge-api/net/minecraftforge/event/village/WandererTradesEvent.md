# WandererTradesEvent

> `net.minecraftforge.event.village.WandererTradesEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/village/WandererTradesEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：WandererTradesEvent is fired during the ServerAboutToStartEvent. It is used to gather the trade lists for the wandering merchant. It is fired on the MinecraftForge#EVENT_BUS. The wandering merchant picks a few trades from `generic` and a single trade from `rare`. To add trades to the merchant, simply add new trades to the list. BasicItemListing provides a default implementation.

## 公开成员（5 个）

```java
protected List<ItemListing> generic
```
源码 :25 —（无 javadoc）

```java
protected List<ItemListing> rare
```
源码 :26 —（无 javadoc）

```java
public WandererTradesEvent(List<ItemListing> generic, List<ItemListing> rare)
```
源码 :28 —（无 javadoc）

```java
public List<ItemListing> getGenericTrades()
```
源码 :34 —（无 javadoc）

```java
public List<ItemListing> getRareTrades()
```
源码 :39 —（无 javadoc）

