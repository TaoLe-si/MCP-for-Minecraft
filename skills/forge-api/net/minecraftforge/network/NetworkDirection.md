# NetworkDirection

> `net.minecraftforge.network.NetworkDirection` · enum · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/NetworkDirection.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（6 个）

```java
public static <T extends ICustomPacket<?>> NetworkDirection directionFor(Class<T> customPacket)
```
源码 :57 —（无 javadoc）

```java
public NetworkDirection reply()
```
源码 :62 —（无 javadoc）

```java
public NetworkEvent getEvent(final ICustomPacket<?> buffer, final Supplier<NetworkEvent.Context> manager)
```
源码 :65 —（无 javadoc）

```java
public LogicalSide getOriginationSide()
```
源码 :69 —（无 javadoc）

```java
public LogicalSide getReceptionSide() { return reply().logicalSide; }
```
源码 :74 —（无 javadoc）

```java
public <T extends Packet<?>> ICustomPacket<T> buildPacket(Pair<FriendlyByteBuf,Integer> packetData, ResourceLocation channelName)
```
源码 :77 —（无 javadoc）

