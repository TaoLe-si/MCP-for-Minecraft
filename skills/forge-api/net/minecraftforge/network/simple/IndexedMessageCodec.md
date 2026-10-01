# IndexedMessageCodec

> `net.minecraftforge.network.simple.IndexedMessageCodec` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/simple/IndexedMessageCodec.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（4 个）

```java
public IndexedMessageCodec()
```
源码 :35 —（无 javadoc）

```java
public IndexedMessageCodec(final NetworkInstance instance)
```
源码 :38 —（无 javadoc）

```java
public <MSG> MessageHandler<MSG> findMessageType(final MSG msgToReply)
```
源码 :43 —（无 javadoc）

```java
public <MSG> int build(MSG message, FriendlyByteBuf target)
```
源码 :126 —（无 javadoc）

