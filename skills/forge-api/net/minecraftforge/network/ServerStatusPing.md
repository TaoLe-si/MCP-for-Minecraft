# ServerStatusPing

> `net.minecraftforge.network.ServerStatusPing` · record · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/ServerStatusPing.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**（源码 javadoc）：Represents additional data sent by FML when a server is pinged. Previous versions used the following format: `{ "fmlNetworkVersion" : FMLNETVERSION, "channels": [ { "res": "fml:handshake", "version": "1.2.3.4", "required": true ` ], "mods": [ { "modid": "modid", "modmarker": "" } ] } } Due to size of the ping packet (32767 UTF-16 code points of JSON data) this could exceed this limit and cause iss…

## 公开成员（16 个）

```java
public static final Codec<ServerStatusPing> CODEC = RecordCodecBuilder.create(in -> in.group( Cod…
```
源码 :84 —（无 javadoc）

```java
public ServerStatusPing()
```
源码 :102 —（无 javadoc）

```java
public boolean equals(Object o)
```
源码 :117 —（无 javadoc）

```java
public int hashCode()
```
源码 :125 —（无 javadoc）

```java
private List<Map.Entry<ResourceLocation, ChannelData>> getChannelsForMod(String modId)
```
源码 :130 —（无 javadoc）

```java
private List<Map.Entry<ResourceLocation, ChannelData>> getNonModChannels()
```
源码 :137 —（无 javadoc）

```java
public ByteBuf toBuf()
```
源码 :144 —（无 javadoc）

```java
private static ServerStatusPing deserializeOptimized(int fmlNetworkVersion, ByteBuf bbuf)
```
源码 :223 —（无 javadoc）

```java
private static String encodeOptimized(ByteBuf buf)
```
源码 :272 — Encode given ByteBuf to a String. This is optimized for UTF-16 Code-Point count. Supports at most 2^30 bytes in length

```java
private static ByteBuf decodeOptimized(String s)
```
源码 :307 — Decode binary data encoded by #encodeOptimized

```java
public Map<ResourceLocation, ChannelData> getRemoteChannels()
```
源码 :343 —（无 javadoc）

```java
public Map<String,String> getRemoteModData()
```
源码 :348 —（无 javadoc）

```java
public int getFMLNetworkVersion()
```
源码 :353 —（无 javadoc）

```java
public boolean isTruncated()
```
源码 :358 —（无 javadoc）

```java
public record ModInfo(String modId, String modmarker)
```
源码 :363 —（无 javadoc）

```java
public record ChannelData(ResourceLocation res, String version, boolean required)
```
源码 :370 —（无 javadoc）

