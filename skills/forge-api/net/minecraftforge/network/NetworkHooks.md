# NetworkHooks

> `net.minecraftforge.network.NetworkHooks` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/NetworkHooks.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（19 个）

```java
public static void init()
```
源码 :50 —（无 javadoc）

```java
public static String getFMLVersion(final String ip)
```
源码 :55 —（无 javadoc）

```java
public static ConnectionType getConnectionType(final Supplier<Connection> connection)
```
源码 :60 —（无 javadoc）

```java
public static ConnectionType getConnectionType(ChannelHandlerContext context)
```
源码 :65 —（无 javadoc）

```java
public static Packet<ClientGamePacketListener> getEntitySpawningPacket(Entity entity)
```
源码 :76 —（无 javadoc）

```java
public static boolean onCustomPayload(final ICustomPacket<?> packet, final Connection manager)
```
源码 :82 —（无 javadoc）

```java
public static void validatePacketDirection(final NetworkDirection packetDirection, final Optional<NetworkDirection> expectedDirection, final Connection connection)
```
源码 :96 —（无 javadoc）

```java
public static void registerServerLoginChannel(Connection manager, ClientIntentionPacket packet)
```
源码 :102 —（无 javadoc）

```java
public synchronized static void registerClientLoginChannel(Connection manager)
```
源码 :108 —（无 javadoc）

```java
public synchronized static void sendMCRegistryPackets(Connection manager, String direction)
```
源码 :114 —（无 javadoc）

```java
public static boolean isVanillaConnection(Connection manager)
```
源码 :132 —（无 javadoc）

```java
public static void handleClientLoginSuccess(Connection manager)
```
源码 :138 —（无 javadoc）

```java
public static boolean tickNegotiation(ServerLoginPacketListenerImpl netHandlerLoginServer, Connection networkManager, ServerPlayer player)
```
源码 :147 —（无 javadoc）

```java
public static void openScreen(ServerPlayer player, MenuProvider containerSupplier)
```
源码 :161 — Request to open a GUI on the client, from the server Refer to ConfigScreenHandler.ConfigScreenFactory for how to provide a function to consume these GUI requests on the client. @param player The player to open the GUI for @param containerSupplier A supplier of container properties including the regi…

```java
public static void openScreen(ServerPlayer player, MenuProvider containerSupplier, BlockPos pos)
```
源码 :176 — Request to open a GUI on the client, from the server Refer to ConfigScreenHandler.ConfigScreenFactory for how to provide a function to consume these GUI requests on the client. @param player The player to open the GUI for @param containerSupplier A supplier of container properties including the regi…

```java
public static void openScreen(ServerPlayer player, MenuProvider containerSupplier, Consumer<FriendlyByteBuf> extraDataWriter)
```
源码 :192 — Request to open a GUI on the client, from the server Refer to ConfigScreenHandler.ConfigScreenFactory for how to provide a function to consume these GUI requests on the client. The maximum size for #extraDataWriter is 32600 bytes. @param player The player to open the GUI for @param containerSupplier…

```java
public static ConnectionData getConnectionData(Connection mgr)
```
源码 :234 —（无 javadoc）

```java
public static ModMismatchData getModMismatchData(Connection mgr)
```
源码 :240 —（无 javadoc）

```java
public static MCRegisterPacketHandler.ChannelList getChannelList(Connection mgr)
```
源码 :246 —（无 javadoc）

