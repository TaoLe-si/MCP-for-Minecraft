# EventNetworkChannel

> `net.minecraftforge.network.event.EventNetworkChannel` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/event/EventNetworkChannel.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**（源码 javadoc）：An event-bus like object on which NetworkEvents are posted. These events are fired from the network thread, and so should not interact with most game state by default. NetworkEvent.Context#enqueueWork(Runnable) can be used to handle the message on the main server or client thread. @see NetworkRegistry#newEventChannel(ResourceLocation, Supplier, Predicate, Predicate) @see NetworkRegistry.ChannelBui…

## 公开成员（5 个）

```java
public EventNetworkChannel(NetworkInstance instance)
```
源码 :32 —（无 javadoc）

```java
public <T extends NetworkEvent> void addListener(Consumer<T> eventListener)
```
源码 :37 —（无 javadoc）

```java
public void registerObject(Object object)
```
源码 :42 —（无 javadoc）

```java
public void unregisterObject(Object object)
```
源码 :47 —（无 javadoc）

```java
public boolean isRemotePresent(Connection manager)
```
源码 :52 —（无 javadoc）

