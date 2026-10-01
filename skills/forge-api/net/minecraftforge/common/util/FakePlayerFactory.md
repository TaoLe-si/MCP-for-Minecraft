# FakePlayerFactory

> `net.minecraftforge.common.util.FakePlayerFactory` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/util/FakePlayerFactory.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（3 个）

```java
public static FakePlayer getMinecraft(ServerLevel level)
```
源码 :24 —（无 javadoc）

```java
public static FakePlayer get(ServerLevel level, GameProfile username)
```
源码 :35 — Get a fake player with a given username, Mods should either hold weak references to the return value, or listen for a WorldEvent.Unload and kill all references to prevent worlds staying in memory, or call this function every time and let Forge take care of the cleanup.

```java
public static void unloadLevel(ServerLevel level)
```
源码 :41 —（无 javadoc）

