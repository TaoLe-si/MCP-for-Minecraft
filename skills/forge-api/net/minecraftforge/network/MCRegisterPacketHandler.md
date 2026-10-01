# MCRegisterPacketHandler

> `net.minecraftforge.network.MCRegisterPacketHandler` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/MCRegisterPacketHandler.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（4 个）

```java
public static final MCRegisterPacketHandler INSTANCE = new MCRegisterPacketHandler()
```
源码 :31 —（无 javadoc）

```java
public static class ChannelList
```
源码 :33 —（无 javadoc）

```java
public void addChannels(Set<ResourceLocation> locations, Connection manager)
```
源码 :91 — the unmodifiable set of channel locations sent by the remote side This is useful for interacting with other modloaders via the network to inspect registered network channel IDs.

```java
public void sendRegistry(Connection manager, final NetworkDirection dir)
```
源码 :120 —（无 javadoc）

