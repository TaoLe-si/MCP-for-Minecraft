# VanillaConnectionNetworkFilter

> `net.minecraftforge.network.filters.VanillaConnectionNetworkFilter` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/filters/VanillaConnectionNetworkFilter.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**（源码 javadoc）：A filter for impl packets, used to filter/modify parts of vanilla impl messages that will cause errors or warnings on vanilla clients, for example entity attributes that are added by Forge or mods.

## 公开成员（2 个）

```java
public VanillaConnectionNetworkFilter()
```
源码 :58 —（无 javadoc）

```java
protected boolean isNecessary(Connection manager)
```
源码 :70 —（无 javadoc）

