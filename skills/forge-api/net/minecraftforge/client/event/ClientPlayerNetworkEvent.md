# ClientPlayerNetworkEvent

> `net.minecraftforge.client.event.ClientPlayerNetworkEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/ClientPlayerNetworkEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired for different client connectivity events. See the various subclasses to listen for specific events. These events are fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client. @see LoggingIn @see LoggingOut @see Clone

## 公开成员（7 个）

```java
protected ClientPlayerNetworkEvent(final MultiPlayerGameMode multiPlayerGameMode, final LocalPlayer player, final Connection connection)
```
源码 :36 —（无 javadoc）

```java
public MultiPlayerGameMode getMultiPlayerGameMode()
```
源码 :46 — the multiplayer game mode controller for the player

```java
public LocalPlayer getPlayer()
```
源码 :54 — the player instance

```java
public Connection getConnection()
```
源码 :62 — the network connection for the player

```java
public static class LoggingIn extends ClientPlayerNetworkEvent
```
源码 :75 — Fired when the client player logs in to the server. The player should be initialized. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client.

```java
public static class LoggingOut extends ClientPlayerNetworkEvent
```
源码 :94 —（无 javadoc）

```java
public static class Clone extends ClientPlayerNetworkEvent
```
源码 :148 — Fired when the client player respawns, creating a new player instance to replace the old player instance. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical c…

