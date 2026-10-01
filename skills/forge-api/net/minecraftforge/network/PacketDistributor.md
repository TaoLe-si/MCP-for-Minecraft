# PacketDistributor

> `net.minecraftforge.network.PacketDistributor` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/PacketDistributor.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**（源码 javadoc）：Means to distribute packets in various ways @see SimpleChannel#send(PacketTarget, Object) @param

## 公开成员（14 个）

```java
public static final PacketDistributor<ServerPlayer> PLAYER = new PacketDistributor<>(PacketDistributor::pl…
```
源码 :39 — Send to the player specified in the Supplier #with(Supplier) Player

```java
public static final PacketDistributor<ResourceKey<Level>> DIMENSION = new PacketDistributor<>(PacketDistributor::pl…
```
源码 :45 — Send to everyone in the dimension specified in the Supplier #with(Supplier) DimensionType

```java
public static final PacketDistributor<TargetPoint> NEAR = new PacketDistributor<>(PacketDistributor::pl…
```
源码 :51 — Send to everyone near the TargetPoint specified in the Supplier #with(Supplier) TargetPoint

```java
public static final PacketDistributor<Void> ALL = new PacketDistributor<>(PacketDistributor::pl…
```
源码 :57 — Send to everyone #noArg()

```java
public static final PacketDistributor<Void> SERVER = new PacketDistributor<>(PacketDistributor::cl…
```
源码 :63 — Send to the server (CLIENT to SERVER) #noArg()

```java
public static final PacketDistributor<Entity> TRACKING_ENTITY = new PacketDistributor<>(PacketDistributor::tr…
```
源码 :69 — Send to all tracking the Entity in the Supplier #with(Supplier) Entity

```java
public static final PacketDistributor<Entity> TRACKING_ENTITY_AND_SELF = new PacketDistributor<>(PacketDistributor::tr…
```
源码 :75 — Send to all tracking the Entity and Player in the Supplier #with(Supplier) Entity

```java
public static final PacketDistributor<LevelChunk> TRACKING_CHUNK = new PacketDistributor<>(PacketDistributor::tr…
```
源码 :81 — Send to all tracking the Chunk in the Supplier #with(Supplier) Chunk

```java
public static final PacketDistributor<List<Connection>> NMLIST = new PacketDistributor<>(PacketDistributor::ne…
```
源码 :87 — Send to the supplied list of NetworkManager instances in the Supplier #with(Supplier) List of NetworkManager

```java
public static final class TargetPoint
```
源码 :89 —（无 javadoc）

```java
public static class PacketTarget
```
源码 :156 — A Distributor curried with a specific value instance, for actual dispatch @see SimpleChannel#send(PacketTarget, Object)

```java
public PacketDistributor(BiFunction<PacketDistributor<T>, Supplier<T>, Consumer<Packet<?>>> functor, NetworkDirection direction)
```
源码 :177 —（无 javadoc）

```java
public PacketTarget with(Supplier<T> input)
```
源码 :187 — Apply the supplied value to the specific distributor to generate an instance for sending packets to. @param input The input to apply @return A curried instance

```java
public PacketTarget noArg()
```
源码 :198 — Apply a no argument value to a distributor to generate an instance for sending packets to. @see #ALL @see #SERVER @return A curried instance

