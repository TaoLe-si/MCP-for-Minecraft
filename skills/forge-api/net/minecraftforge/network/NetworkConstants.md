# NetworkConstants

> `net.minecraftforge.network.NetworkConstants` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/NetworkConstants.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**（源码 javadoc）：Constants related to networking

## 公开成员（6 个）

```java
public static final String FMLNETMARKER = "FML"
```
源码 :25 —（无 javadoc）

```java
public static final int FMLNETVERSION = 3
```
源码 :29 — Netversion 3: S2CModList packet may include a list of non-vanilla synced datapack registry ids.

```java
public static final String NETVERSION = FMLNETMARKER + FMLNETVERSION
```
源码 :30 —（无 javadoc）

```java
public static final String NOVERSION = "NONE"
```
源码 :31 —（无 javadoc）

```java
public static final String IGNORESERVERONLY = DisplayTest.IGNORESERVERONLY
```
源码 :49 — Return this value in your DisplayTest function to be ignored.

```java
public static String init()
```
源码 :51 —（无 javadoc）

