# PlayMessages

> `net.minecraftforge.network.PlayMessages` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/PlayMessages.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（2 个）

```java
public static class SpawnEntity
```
源码 :43 — Used to spawn a custom entity without the same restrictions as ClientboundAddEntityPacket To customize how your entity is created clientside (instead of using the default factory provided to the EntityType) see EntityType.Builder#setCustomClientFactory.

```java
public static class OpenContainer
```
源码 :252 —（无 javadoc）

