# NetworkInstance

> `net.minecraftforge.network.NetworkInstance` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/NetworkInstance.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（6 个）

```java
public ResourceLocation getChannelName()
```
源码 :22 —（无 javadoc）

```java
public <T extends NetworkEvent> void addListener(Consumer<T> eventListener)
```
源码 :47 —（无 javadoc）

```java
public void addGatherListener(Consumer<NetworkEvent.GatherLoginPayloadsEvent> eventListener)
```
源码 :52 —（无 javadoc）

```java
public void registerObject(final Object object)
```
源码 :57 —（无 javadoc）

```java
public void unregisterObject(final Object object)
```
源码 :61 —（无 javadoc）

```java
public boolean isRemotePresent(Connection manager)
```
源码 :96 —（无 javadoc）

