# VanillaPacketSplitter

> `net.minecraftforge.network.filters.VanillaPacketSplitter` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/filters/VanillaPacketSplitter.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**（源码 javadoc）：A custom payload channel that allows sending vanilla server-to-client packets, even if they would normally be too large for the vanilla protocol. This is achieved by splitting them into multiple custom payload packets.

## 公开成员（5 个）

```java
public static void register()
```
源码 :46 —（无 javadoc）

```java
public static void appendPackets(ConnectionProtocol protocol, PacketFlow direction, Packet<?> packet, List<? super Packet<?>> out)
```
源码 :57 — Append the given packet to the given list. If the packet needs to be split, multiple packets will be appened. Otherwise only the packet itself.

```java
public enum RemoteCompatibility
```
源码 :163 —（无 javadoc）

```java
public static RemoteCompatibility getRemoteCompatibility(Connection manager)
```
源码 :169 —（无 javadoc）

```java
public static boolean isRemoteCompatible(Connection manager)
```
源码 :182 —（无 javadoc）

