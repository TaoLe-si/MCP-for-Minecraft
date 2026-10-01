# TradeWithVillagerEvent

> `net.minecraftforge.event.entity.player.TradeWithVillagerEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/TradeWithVillagerEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired when a player trades with an AbstractVillager. This event is not Cancelable cancellable, and does not Event.HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#SERVER logical server.

## 公开成员（3 个）

```java
public TradeWithVillagerEvent(Player player, MerchantOffer offer, AbstractVillager abstractVillager)
```
源码 :29 —（无 javadoc）

```java
public MerchantOffer getMerchantOffer()
```
源码 :39 — the MerchantOffer selected by the player to trade with

```java
public AbstractVillager getAbstractVillager()
```
源码 :47 — the villager the player traded with

