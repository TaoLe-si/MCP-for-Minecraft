# ClientChatEvent

> `net.minecraftforge.client.event.ClientChatEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/ClientChatEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired when the client is about to send a chat message to the server. This event is Cancelable cancellable, and does not HasResult have a result. If the event is cancelled, the chat message will not be sent to the server. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client.

## 公开成员（4 个）

```java
public ClientChatEvent(String message)
```
源码 :31 —（无 javadoc）

```java
public String getMessage()
```
源码 :41 — the message that will be sent to the server, if the event is not cancelled. This can be changed by mods

```java
public void setMessage(String message)
```
源码 :51 — Sets the new message to be sent to the server, if the event is not cancelled. @param message the new message to be sent

```java
public String getOriginalMessage()
```
源码 :59 — the original message that was to be sent to the server. This cannot be changed by mods

