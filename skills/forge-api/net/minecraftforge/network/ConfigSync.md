# ConfigSync

> `net.minecraftforge.network.ConfigSync` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/ConfigSync.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（3 个）

```java
public static final ConfigSync INSTANCE = new ConfigSync(ConfigTracker.INSTANCE)
```
源码 :22 —（无 javadoc）

```java
public List<Pair<String, HandshakeMessages.S2CConfigData>> syncConfigs(boolean isLocal)
```
源码 :29 —（无 javadoc）

```java
public void receiveSyncedConfig(final HandshakeMessages.S2CConfigData s2CConfigData, final Supplier<NetworkEvent.Context> contextSupplier)
```
源码 :40 —（无 javadoc）

