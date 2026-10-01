# NetworkInitialization

> `net.minecraftforge.network.NetworkInitialization` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/NetworkInitialization.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（3 个）

```java
public static SimpleChannel getHandshakeChannel()
```
源码 :17 —（无 javadoc）

```java
public static SimpleChannel getPlayChannel()
```
源码 :82 —（无 javadoc）

```java
public static List<EventNetworkChannel> buildMCRegistrationChannels()
```
源码 :105 —（无 javadoc）

