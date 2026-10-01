# IContainerFactory

> `net.minecraftforge.network.IContainerFactory` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/IContainerFactory.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（2 个）

```java
T create(int windowId, Inventory inv, FriendlyByteBuf data)
```
源码 :15 —（无 javadoc）

```java
default T create(int p_create_1_, Inventory p_create_2_)
```
源码 :18 —（无 javadoc）

