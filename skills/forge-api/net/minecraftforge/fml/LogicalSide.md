# LogicalSide

> `net.minecraftforge.fml.LogicalSide` · enum · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/LogicalSide.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：A logical side of the Minecraft game. The Dist#CLIENT client distribution has a copy of the logical client and the logical server, while the Dist#DEDICATED_SERVER dedicated server distribution only holds the logical server. @see Dist

## 公开成员（3 个）

```java
enum 常量 CLIENT, /** * The logical server of the Minecraft game, responsible for connecting to clients and running the simulation logic * on the level. * <p> * The logical server is shipped with both client and dedicated server distributions. The client distribution runs * the logical server for singleplayer mode and LAN play. * * @see Dist#DEDICATED_SERVER */ SERVER
```
源码 :29 — The logical client of the Minecraft game, which interfaces with the player's inputs and renders the player's viewpoint. The logical client is only shipped with the client distribution of the game. @see Dist#CLIENT

```java
public boolean isServer()
```
源码 :44 — if this logical side is the server

```java
public boolean isClient()
```
源码 :52 — if the logical side is the client

