# ICustomPacket

> `net.minecraftforge.network.ICustomPacket` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/ICustomPacket.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（5 个）

```java
FriendlyByteBuf getInternalData()
```
源码 :21 —（无 javadoc）

```java
ResourceLocation getName()
```
源码 :23 —（无 javadoc）

```java
int getIndex()
```
源码 :25 —（无 javadoc）

```java
default NetworkDirection getDirection()
```
源码 :27 —（无 javadoc）

```java
default T getThis()
```
源码 :32 —（无 javadoc）

