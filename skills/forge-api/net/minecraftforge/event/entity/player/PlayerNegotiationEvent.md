# PlayerNegotiationEvent

> `net.minecraftforge.event.entity.player.PlayerNegotiationEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/PlayerNegotiationEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is fired on the server when a connection has started the Forge handshake, Forge will wait for all enqueued work to be completed before proceeding further with the login process. This event can be used to delay the player login until any necessary work such as preloading user data has completed. This event is fired on the MinecraftForge#EVENT_BUS.

## 公开成员（5 个）

```java
public PlayerNegotiationEvent(Connection connection, GameProfile profile, List<Future<Void>> futures)
```
源码 :32 —（无 javadoc）

```java
public void enqueueWork(Runnable runnable)
```
源码 :42 — Enqueue work to be completed asynchronously before the login proceeds.

```java
public void enqueueWork(Future<Void> future)
```
源码 :50 — Enqueue work to be completed asynchronously before the login proceeds.

```java
public Connection getConnection()
```
源码 :55 —（无 javadoc）

```java
public GameProfile getProfile()
```
源码 :60 —（无 javadoc）

