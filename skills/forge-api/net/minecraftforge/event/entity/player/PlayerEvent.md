# PlayerEvent

> `net.minecraftforge.event.entity.player.PlayerEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/PlayerEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目用法**：换维度/进出世界/复活 → 记 events

**职责**（源码 javadoc）：PlayerEvent is fired whenever an event involving a Player occurs. If a method utilizes this net.minecraftforge.eventbus.api.Event as its parameter, the method will receive every child event of this class. All children of this event are fired on the MinecraftForge#EVENT_BUS.

## 公开成员（19 个）

```java
public PlayerEvent(Player player)
```
源码 :41 —（无 javadoc）

```java
public Player getEntity()
```
源码 :48 —（无 javadoc）

```java
public static class HarvestCheck extends PlayerEvent
```
源码 :69 — HarvestCheck is fired when a player attempts to harvest a block. This event is fired whenever a player attempts to harvest a block in Player#hasCorrectToolForDrops(BlockState). This event is fired via the ForgeEventFactory#doPlayerHarvestCheck(Player,. #state contains the BlockState that is being ch…

```java
public static class BreakSpeed extends PlayerEvent
```
源码 :106 —（无 javadoc）

```java
public static class NameFormat extends PlayerEvent
```
源码 :146 — NameFormat is fired when a player's display name is retrieved. This event is fired whenever a player's name is retrieved in Player#getDisplayName() or Player#refreshDisplayName(). This event is fired via the ForgeEventFactory#getPlayerDisplayName(Player,. #username contains the username of the playe…

```java
public static class TabListNameFormat extends PlayerEvent
```
源码 :189 — TabListNameFormat is fired when a player's display name for the tablist is retrieved. This event is fired whenever a player's display name for the tablist is retrieved in ServerPlayer#getTabListDisplayName() or ServerPlayer#refreshTabListName(). This event is fired via the ForgeEventFactory#getPlaye…

```java
public static class Clone extends PlayerEvent
```
源码 :215 — Fired when the EntityPlayer is cloned, typically caused by the impl sending a RESPAWN_PLAYER event. Either caused by death, or by traveling from the End to the overworld.

```java
public static class StartTracking extends PlayerEvent
```
源码 :249 — Fired when an Entity is started to be "tracked" by this player (the player receives updates about this entity, e.g. motion).

```java
public static class StopTracking extends PlayerEvent
```
源码 :272 — Fired when an Entity is stopped to be "tracked" by this player (the player no longer receives updates about this entity, e.g. motion).

```java
public static class LoadFromFile extends PlayerEvent
```
源码 :297 — The player is being loaded from the world save. Note that the player won't have been added to the world yet. Intended to allow mods to load an additional file from the players directory containing additional mod related player data.

```java
public static class SaveToFile extends PlayerEvent
```
源码 :349 — The player is being saved to the world store. Note that the player may be in the process of logging out or otherwise departing from the world. Don't assume it's association with the world. This allows mods to load an additional file from the players directory containing additional mod related player…

```java
public static class ItemPickupEvent extends PlayerEvent
```
源码 :389 — The UUID is the standard for player related file storage. It is broken out here for convenience for quick file generation.

```java
public static class ItemCraftedEvent extends PlayerEvent
```
源码 :414 — Clone item stack, containing the item and amount picked up

```java
public static class ItemSmeltedEvent extends PlayerEvent
```
源码 :437 —（无 javadoc）

```java
public static class PlayerLoggedInEvent extends PlayerEvent
```
源码 :453 —（无 javadoc）

```java
public static class PlayerLoggedOutEvent extends PlayerEvent
```
源码 :460 —（无 javadoc）

```java
public static class PlayerRespawnEvent extends PlayerEvent
```
源码 :467 —（无 javadoc）

```java
public static class PlayerChangedDimensionEvent extends PlayerEvent
```
源码 :488 — Did this respawn event come from the player conquering the end? @return if this respawn was because the player conquered the end

```java
public static class PlayerChangeGameModeEvent extends PlayerEvent
```
源码 :514 —（无 javadoc）

