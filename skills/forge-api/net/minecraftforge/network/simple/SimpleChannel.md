# SimpleChannel

> `net.minecraftforge.network.simple.SimpleChannel` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/simple/SimpleChannel.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（14 个）

```java
public SimpleChannel(NetworkInstance instance)
```
源码 :31 —（无 javadoc）

```java
public SimpleChannel(NetworkInstance instance, Consumer<NetworkEvent.ChannelRegistrationChangeEvent> registryChangeNotify)
```
源码 :45 —（无 javadoc）

```java
public <MSG> int encodeMessage(MSG message, final FriendlyByteBuf target)
```
源码 :67 —（无 javadoc）

```java
public <MSG> IndexedMessageCodec.MessageHandler<MSG> registerMessage(int index, Class<MSG> messageType, BiConsumer<MSG, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, MSG> decoder, BiConsumer<MSG, Supplier<NetworkEvent.Context>> messageConsumer)
```
源码 :71 —（无 javadoc）

```java
public <MSG> IndexedMessageCodec.MessageHandler<MSG> registerMessage(int index, Class<MSG> messageType, BiConsumer<MSG, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, MSG> decoder, BiConsumer<MSG, Supplier<NetworkEvent.Context>> messageConsumer, final Optional<NetworkDirection> networkDirection)
```
源码 :75 —（无 javadoc）

```java
public <MSG> void sendToServer(MSG message)
```
源码 :85 —（无 javadoc）

```java
public <MSG> void sendTo(MSG message, Connection manager, NetworkDirection direction)
```
源码 :90 —（无 javadoc）

```java
public <MSG> void send(PacketDistributor.PacketTarget target, MSG message)
```
源码 :106 — Send a message to the PacketDistributor.PacketTarget from a PacketDistributor instance. channel.send(PacketDistributor.PLAYER.with(()->player), message) @param target The curried target from a PacketDistributor @param message The message to send @param The type of the message

```java
public <MSG> Packet<?> toVanillaPacket(MSG message, NetworkDirection direction)
```
源码 :110 —（无 javadoc）

```java
public <MSG> void reply(MSG msgToReply, NetworkEvent.Context context)
```
源码 :115 —（无 javadoc）

```java
public boolean isRemotePresent(Connection manager)
```
源码 :123 — Returns true if the channel is present in the given connection.

```java
public <M> MessageBuilder<M> messageBuilder(final Class<M> type, int id)
```
源码 :135 — Build a new MessageBuilder. The type should implement java.util.function.IntSupplier if it is a login packet. @param type Type of message @param id id in the indexed codec @param Type of type @return a MessageBuilder

```java
public <M> MessageBuilder<M> messageBuilder(final Class<M> type, int id, NetworkDirection direction)
```
源码 :149 — Build a new MessageBuilder. The type should implement java.util.function.IntSupplier if it is a login packet. @param type Type of message @param id id in the indexed codec @param direction a impl direction which will be asserted before any processing of this message occurs. Use to enforce strict sid…

```java
public static class MessageBuilder<MSG>
```
源码 :153 —（无 javadoc）

