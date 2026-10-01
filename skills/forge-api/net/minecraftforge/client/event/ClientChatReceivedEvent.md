# ClientChatReceivedEvent

> `net.minecraftforge.client.event.ClientChatReceivedEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/ClientChatReceivedEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目用法**：抄聊天流水（chatlog op 的数据源）

**职责**（源码 javadoc）：Fired when a chat message is received on the client. This can be used for filtering and detecting messages with specific words or phrases, and suppressing them. This event is Cancelable cancellable, and does not HasResult have a result. If the event is cancelled, the message is not displayed in the chat message window. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only…

## 公开成员（8 个）

```java
public ClientChatReceivedEvent(ChatType.Bound boundChatType, Component message, UUID sender)
```
源码 :39 —（无 javadoc）

```java
public Component getMessage()
```
源码 :49 — the message that will be displayed in the chat message window, if the event is not cancelled

```java
public void setMessage(Component message)
```
源码 :59 — Sets the new message to be displayed in the chat message window, if the event is not cancelled. @param message the new message to be displayed

```java
public ChatType.Bound getBoundChatType()
```
源码 :68 — the bound chat type of the chat message. This contains the chat type, display name of the sender, and nullable target name depending on the chat type.

```java
public UUID getSender()
```
源码 :77 — the message sender. This will be Util#NIL_UUID if the message is a system message.

```java
public boolean isSystem()
```
源码 :85 — `true` if the message was sent by the system, `false` otherwise

```java
public static class Player extends ClientChatReceivedEvent
```
源码 :101 — Fired when a player chat message is received on the client. This event is Cancelable cancellable, and does not HasResult have a result. If the event is cancelled, the message is not displayed in the chat message window. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only o…

```java
public static class System extends ClientChatReceivedEvent
```
源码 :131 — Fired when a system chat message is received on the client. This event is Cancelable cancellable, and does not HasResult have a result. If the event is cancelled, the message is not displayed in the chat message window or in the overlay. This event is fired on the MinecraftForge#EVENT_BUS main Forge…

