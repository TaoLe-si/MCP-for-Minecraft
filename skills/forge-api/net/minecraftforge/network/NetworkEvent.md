# NetworkEvent

> `net.minecraftforge.network.NetworkEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/NetworkEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（14 个）

```java
public NetworkEvent(final Supplier<Context> source)
```
源码 :49 —（无 javadoc）

```java
public FriendlyByteBuf getPayload()
```
源码 :55 —（无 javadoc）

```java
public Supplier<Context> getSource()
```
源码 :60 —（无 javadoc）

```java
public int getLoginIndex()
```
源码 :65 —（无 javadoc）

```java
public static class ServerCustomPayloadEvent extends NetworkEvent
```
源码 :70 —（无 javadoc）

```java
public static class ClientCustomPayloadEvent extends NetworkEvent
```
源码 :76 —（无 javadoc）

```java
public static class ServerCustomPayloadLoginEvent extends ServerCustomPayloadEvent
```
源码 :82 —（无 javadoc）

```java
public static class ClientCustomPayloadLoginEvent extends ClientCustomPayloadEvent
```
源码 :89 —（无 javadoc）

```java
public static class GatherLoginPayloadsEvent extends Event
```
源码 :96 —（无 javadoc）

```java
public static class LoginPayloadEvent extends NetworkEvent
```
源码 :119 —（无 javadoc）

```java
public enum RegistrationChangeType
```
源码 :125 —（无 javadoc）

```java
public static class ChannelRegistrationChangeEvent extends NetworkEvent
```
源码 :136 — Fired when the channel registration (see minecraft custom channel documentation) changes. Note the payload is not exposed. This fires to the resource location that owns the channel, when it's registration changes state. It seems plausible that this will fire multiple times for the same state, depend…

```java
public static class Context
```
源码 :151 — Context for NetworkEvent

```java
public static class PacketDispatcher
```
源码 :241 — Dispatcher for sending packets in response to a received packet. Abstracts out the difference between wrapped packets and unwrapped packets.

