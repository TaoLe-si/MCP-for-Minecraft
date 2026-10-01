# ServerChatEvent

> `net.minecraftforge.event.ServerChatEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/ServerChatEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is fired whenever a ServerboundChatPacket is received from a client who has submitted their chat message. This event is Cancelable cancellable, and does not HasResult have a result. If the event is cancelled, the message will not be sent to clients. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#SERVER logical server.

## 公开成员（6 个）

```java
public ServerChatEvent(ServerPlayer player, String rawText, Component message)
```
源码 :37 —（无 javadoc）

```java
public ServerPlayer getPlayer()
```
源码 :48 — the player who initiated the chat action

```java
public String getUsername()
```
源码 :56 — the username of the player who initiated the chat action

```java
public String getRawText()
```
源码 :64 — the original raw text of the player chat message

```java
public void setMessage(Component message)
```
源码 :72 — Set the message to be sent to the relevant clients.

```java
public Component getMessage()
```
源码 :80 — the message that will be sent to the relevant clients, if the event is not cancelled

