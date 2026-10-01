# ClientPlayerChangeGameTypeEvent

> `net.minecraftforge.client.event.ClientPlayerChangeGameTypeEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/ClientPlayerChangeGameTypeEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired when the client player is notified of a change of GameType from the server. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client.

## 公开成员（4 个）

```java
public ClientPlayerChangeGameTypeEvent(PlayerInfo info, GameType currentGameType, GameType newGameType)
```
源码 :31 —（无 javadoc）

```java
public PlayerInfo getInfo()
```
源码 :41 — the client player information

```java
public GameType getCurrentGameType()
```
源码 :49 — the current game type of the player

```java
public GameType getNewGameType()
```
源码 :57 — the new game type of the player

