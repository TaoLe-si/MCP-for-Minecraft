# HandshakeHandler

> `net.minecraftforge.network.HandshakeHandler` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/HandshakeHandler.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**（源码 javadoc）：Instance responsible for handling the overall FML impl handshake. An instance is created during ClientIntentionPacket handling, and attached to the Connection#channel() via NetworkConstants#FML_HANDSHAKE_HANDLER. The NetworkConstants#handshakeChannel is a SimpleChannel with standard messages flowing in both directions. The #loginWrapper transforms these messages into ServerboundCustomQueryPacket a…

## 公开成员（5 个）

```java
public interface HandshakeConsumer<MSG extends IntSupplier>
```
源码 :135 —（无 javadoc）

```java
public static <MSG extends IntSupplier> BiConsumer<MSG, Supplier<NetworkEvent.Context>> biConsumerFor(HandshakeConsumer<MSG> consumer)
```
源码 :149 — Transforms a two-argument instance method reference into a BiConsumer based on the #getHandshake(Supplier) function. This should only be used for login message types. @param consumer A two argument instance method reference @param message type @return A BiConsumer for use in message handling

```java
public static <MSG extends IntSupplier> BiConsumer<MSG, Supplier<NetworkEvent.Context>> indexFirst(HandshakeConsumer<MSG> next)
```
源码 :164 — Transforms a two-argument instance method reference into a BiConsumer #biConsumerFor(HandshakeConsumer), first calling the #handleIndexedMessage(IntSupplier, method to handle index tracking. Used for client to server replies. This should only be used for login messages. @param next The method refere…

```java
public boolean tickServer()
```
源码 :341 — FML will send packets, from Server to Client, from the messages queue until the queue is drained. Each message will be indexed, and placed into the "pending acknowledgement" queue. As indexed packets are received at the server, they will be removed from the "pending acknowledgement" queue. Once the…

```java
public static boolean packetNeedsResponse(Connection mgr, int packetPosition)
```
源码 :392 — Helper method to determine if the S2C packet at the given packet position needs a response in form of a packet handled in HandshakeHandler#handleIndexedMessage for the handshake to progress. @param mgr The impl manager for this connection @param packetPosition The packet position of the packet that…

