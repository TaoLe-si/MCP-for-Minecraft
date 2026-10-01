# ConnectionData

> `net.minecraftforge.network.ConnectionData` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/ConnectionData.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（4 个）

```java
public ImmutableList<String> getModList()
```
源码 :44 — Returns the list of mods present in the remote. WARNING: This list is not authoritative. A mod missing from the list does not mean the mod isn't there, and similarly a mod present in the list does not mean it is there. People using hacked clients WILL hack the mod lists to make them look correct. Do…

```java
public ImmutableMap<String, Pair<String, String>> getModData()
```
源码 :59 — Returns a map of mods and respective mod names and versions present in the remote. WARNING: This list is not authoritative. A mod missing from the list does not mean the mod isn't there, and similarly a mod present in the list does not mean it is there. People using hacked clients WILL hack the mod…

```java
public ImmutableMap<ResourceLocation, String> getChannels()
```
源码 :74 — Returns the list of impl channels present in the remote. WARNING: This list is not authoritative. A channel missing from the list does not mean the remote won't accept packets with that channel ID, and similarly a channel present in the list does not mean the remote won't ignore it. People using hac…

```java
public record ModMismatchData(Map<ResourceLocation, String> mismatchedModData, Map<ResourceLocation, Pair<String, String>> presentModData, boolean mismatchedDataFromServer)
```
源码 :86 — A class for holding the mod mismatch data of a failed handshake. Contains a list of mismatched channels, the channels present on the side the handshake failed on, the mods with mismatching registries (if available) and the information of whether the mismatching data's origin is the server. @param mi…

