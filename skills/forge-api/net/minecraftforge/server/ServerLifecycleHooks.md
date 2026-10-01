# ServerLifecycleHooks

> `net.minecraftforge.server.ServerLifecycleHooks` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/server/ServerLifecycleHooks.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目用法**：拿当前服务器（专服上的游戏线程投递用）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（10 个）

```java
public static boolean handleServerAboutToStart(final MinecraftServer server)
```
源码 :91 —（无 javadoc）

```java
public static boolean handleServerStarting(final MinecraftServer server)
```
源码 :101 —（无 javadoc）

```java
public static void handleServerStarted(final MinecraftServer server)
```
源码 :113 —（无 javadoc）

```java
public static void handleServerStopping(final MinecraftServer server)
```
源码 :119 —（无 javadoc）

```java
public static void expectServerStopped()
```
源码 :125 —（无 javadoc）

```java
public static void handleServerStopped(final MinecraftServer server)
```
源码 :130 —（无 javadoc）

```java
public static MinecraftServer getCurrentServer()
```
源码 :146 —（无 javadoc）

```java
public static boolean handleServerLogin(final ClientIntentionPacket packet, final Connection manager)
```
源码 :152 —（无 javadoc）

```java
public static void handleExit(int retVal)
```
源码 :195 —（无 javadoc）

```java
public static RepositorySource buildPackFinder(Map<IModFile, ? extends PathPackResources> modResourcePacks)
```
源码 :201 —（无 javadoc）

