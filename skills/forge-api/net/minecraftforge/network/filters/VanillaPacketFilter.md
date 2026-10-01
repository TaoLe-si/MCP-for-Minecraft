# VanillaPacketFilter

> `net.minecraftforge.network.filters.VanillaPacketFilter` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/filters/VanillaPacketFilter.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**（源码 javadoc）：A filter for vanilla impl packets.

## 公开成员（6 个）

```java
protected final Map<Class<? extends Packet<?>>, BiConsumer<Packet<?>, List<? super Packet<?>>>> handlers
```
源码 :26 —（无 javadoc）

```java
protected VanillaPacketFilter(Map<Class<? extends Packet<?>>, BiConsumer<Packet<?>, List<? super Packet<?>>>> handlers)
```
源码 :28 —（无 javadoc）

```java
protected static <T extends Packet<?>> Map.Entry<Class<? extends Packet<?>>, BiConsumer<Packet<?>, List<? super Packet<?>>>> handler(Class<T> cls, Function<T, ? extends Packet<?>> function)
```
源码 :37 —（无 javadoc）

```java
protected static <T extends Packet<?>> Map.Entry<Class<? extends Packet<?>>, BiConsumer<Packet<?>, List<? super Packet<?>>>> handler(Class<T> cls, BiConsumer<Packet<?>, List<? super Packet<?>>> consumer)
```
源码 :46 —（无 javadoc）

```java
protected abstract boolean isNecessary(Connection manager)
```
源码 :54 — Whether this filter is necessary on the given connection.

```java
protected void encode(ChannelHandlerContext ctx, Packet<?> msg, List<Object> out)
```
源码 :57 —（无 javadoc）

