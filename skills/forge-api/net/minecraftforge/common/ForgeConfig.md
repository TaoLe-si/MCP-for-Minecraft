# ForgeConfig

> `net.minecraftforge.common.ForgeConfig` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/ForgeConfig.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（8 个）

```java
public static class Server
```
源码 :19 —（无 javadoc）

```java
public static class Common
```
源码 :95 — General configuration that doesn't need to be synchronized but needs to be available before server startup

```java
public static class Client
```
源码 :108 — Client specific configuration - only loaded clientside from forge-client.toml

```java
public static final Client CLIENT
```
源码 :196 —（无 javadoc）

```java
public static final Common COMMON
```
源码 :205 —（无 javadoc）

```java
public static final Server SERVER
```
源码 :214 —（无 javadoc）

```java
public static void onLoad(final ModConfigEvent.Loading configEvent)
```
源码 :222 —（无 javadoc）

```java
public static void onFileChange(final ModConfigEvent.Reloading configEvent)
```
源码 :227 —（无 javadoc）

