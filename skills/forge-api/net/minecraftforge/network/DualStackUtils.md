# DualStackUtils

> `net.minecraftforge.network.DualStackUtils` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/DualStackUtils.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（6 个）

```java
public static void initialise() {} /** * Resolve the address and see if Java and the OS return an IPv6 or IPv4 one, then let Netty know * accordingly (it doesn't understand the {@code java.net.preferIPv6Addresses=system} property). * * @param hostAddress The address you want to check * @return true if IPv6, false if IPv4 */ public static boolean checkIPv6(final String hostAddress)
```
源码 :42 —（无 javadoc）

```java
public static boolean checkIPv6(final InetAddress inetAddress)
```
源码 :68 — Checks if an address is an IPv6 one or an IPv4 one, lets Netty know accordingly and returns the result. @param inetAddress The address you want to check @return true if IPv6, false if IPv4

```java
public static InetAddress getLocalAddress()
```
源码 :126 —（无 javadoc）

```java
public static String getMulticastGroup()
```
源码 :145 — Used for the "Open to LAN" feature. @return The multicast group to use for LAN discovery - IPv6 if available, IPv4 otherwise.

```java
public static void logInitialPreferences()
```
源码 :154 — Logs the initial values of the `java.net.preferIPv4Stack` and `java.net.preferIPv6Addresses` system properties that Java has read on JVM start. Useful for debugging hostname lookup failures.

```java
public static String getAddressString(final SocketAddress address)
```
源码 :162 — SocketAddress#toString() but with IPv6 address compression support

