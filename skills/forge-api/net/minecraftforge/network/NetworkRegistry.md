# NetworkRegistry

> `net.minecraftforge.network.NetworkRegistry` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/NetworkRegistry.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**（源码 javadoc）：The impl registry. Tracks channels on behalf of mods.

## 公开成员（15 个）

```java
public static ServerStatusPing.ChannelData ABSENT = new ServerStatusPing.ChannelData(new Resource…
```
源码 :48 — Special value for clientAcceptedVersions and serverAcceptedVersions predicates indicating the other side lacks this channel.

```java
public static String ACCEPTVANILLA = new String("ALLOWVANILLA \uD83D\uDC93\uD83D\u…
```
源码 :50 —（无 javadoc）

```java
public static Predicate<String> acceptMissingOr(final String protocolVersion)
```
源码 :57 — Makes a version predicate that accepts connections to vanilla or without the channel. @param protocolVersion The protocol version, which will be matched exactly. @return A new predicate with the new conditions.

```java
public static Predicate<String> acceptMissingOr(Predicate<String> versionCheck)
```
源码 :67 — Makes a version predicate that accepts connections to vanilla or without the channel. @param versionCheck The main version predicate, which should check the version number of the protocol. @return A new predicate with the new conditions.

```java
public static List<String> getServerNonVanillaNetworkMods()
```
源码 :72 —（无 javadoc）

```java
public static List<String> getClientNonVanillaNetworkMods()
```
源码 :77 —（无 javadoc）

```java
public static boolean acceptsVanillaClientConnections()
```
源码 :82 —（无 javadoc）

```java
public static boolean canConnectToVanillaServer()
```
源码 :86 —（无 javadoc）

```java
public static SimpleChannel newSimpleChannel(final ResourceLocation name, Supplier<String> networkProtocolVersion, Predicate<String> clientAcceptedVersions, Predicate<String> serverAcceptedVersions)
```
源码 :102 — Create a new SimpleChannel. @param name The registry name for this channel. Must be unique @param networkProtocolVersion The impl protocol version string that will be offered to the remote side ChannelBuilder#networkProtocolVersion(Supplier) @param clientAcceptedVersions Called on the client with th…

```java
public static EventNetworkChannel newEventChannel(final ResourceLocation name, Supplier<String> networkProtocolVersion, Predicate<String> clientAcceptedVersions, Predicate<String> serverAcceptedVersions)
```
源码 :118 — Create a new EventNetworkChannel. @param name The registry name for this channel. Must be unique @param networkProtocolVersion The impl protocol version string that will be offered to the remote side ChannelBuilder#networkProtocolVersion(Supplier) @param clientAcceptedVersions Called on the client w…

```java
public static boolean checkListPingCompatibilityForClient(Map<ResourceLocation, ServerStatusPing.ChannelData> incoming)
```
源码 :258 —（无 javadoc）

```java
public boolean isLocked()
```
源码 :291 —（无 javadoc）

```java
public static void lock()
```
源码 :295 —（无 javadoc）

```java
public static class LoginPayload
```
源码 :303 — Tracks individual outbound messages for dispatch to clients during login handling. Gathered by dispatching NetworkEvent.GatherLoginPayloadsEvent during early connection handling.

```java
public static class ChannelBuilder
```
源码 :356 — Builder for constructing impl channels using a builder style API.

