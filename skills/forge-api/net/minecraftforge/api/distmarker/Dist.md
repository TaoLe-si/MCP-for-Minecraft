# Dist

> `net.minecraftforge.api.distmarker.Dist` · enum · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/api/distmarker/Dist.java` · `forgespi-3.0.0`（forgespi-3.0.0-sources.jar）

**本项目用法**：`Dist.CLIENT` 用在 DistExecutor 里

**职责**（源码 javadoc）：A distribution of the minecraft game. There are two common distributions, and though much code is common between them, there are some specific pieces that are only present in one or the other. #CLIENT is the client distribution, it contains the game client, and has code to render a viewport into a game world. #DEDICATED_SERVER is the dedicated server distribution, it contains a server, which can s…

## 公开成员（3 个）

```java
enum 常量 CLIENT, /** * The dedicated server distribution. This is the server only distribution available for * download. It simulates the world, and can be communicated with via a network. * It contains no visual elements of the game whatsoever. */ DEDICATED_SERVER
```
源码 :39 — The client distribution. This is the game client players can purchase and play. It contains the graphics and other rendering to present a viewport into the game world.

```java
public boolean isDedicatedServer()
```
源码 :50 — @return If this marks a dedicated server.

```java
public boolean isClient()
```
源码 :58 — @return if this marks a client.

