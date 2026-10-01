# HandshakeMessages

> `net.minecraftforge.network.HandshakeMessages` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/HandshakeMessages.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（7 个）

```java
public static class S2CModList extends LoginIndexedMessage
```
源码 :53 — Server to client "list of mods". Always first handshake message after the data sent by S2CModData.

```java
public static class S2CModData extends LoginIndexedMessage
```
源码 :139 — Prefixes S2CModList by sending additional data about the mods installed on the server to the client The mod data is stored as follows: [modId -> [modName, modVersion]]

```java
public static class C2SModListReply extends LoginIndexedMessage
```
源码 :173 —（无 javadoc）

```java
public static class C2SAcknowledge extends LoginIndexedMessage
```
源码 :244 —（无 javadoc）

```java
public static class S2CRegistry extends LoginIndexedMessage
```
源码 :254 —（无 javadoc）

```java
public static class S2CConfigData extends LoginIndexedMessage
```
源码 :294 —（无 javadoc）

```java
public static class S2CChannelMismatchData extends LoginIndexedMessage
```
源码 :325 — Notifies the client of a channel mismatch on the server, so a net.minecraftforge.client.gui.ModMismatchDisconnectedScreen is used to notify the user of the disconnection. This packet also sends the data of a channel mismatch (currently, the ids and versions of the mismatched channels) to the client…

