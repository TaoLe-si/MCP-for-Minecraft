# OnDatapackSyncEvent

> `net.minecraftforge.event.OnDatapackSyncEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/OnDatapackSyncEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fires when a player joins the server or when the reload command is ran, before tags and crafting recipes are sent to the client. Send datapack data to clients when this event fires.

## 公开成员（4 个）

```java
public OnDatapackSyncEvent(PlayerList playerList, @Nullable ServerPlayer player)
```
源码 :26 —（无 javadoc）

```java
public PlayerList getPlayerList()
```
源码 :34 — @return The server's player list to get a view of all players.

```java
public ServerPlayer getPlayer()
```
源码 :43 —（无 javadoc）

```java
public List<ServerPlayer> getPlayers()
```
源码 :51 — @return A list of players that should receive data during this event, which is the specified player (if not null) or all players otherwise.

