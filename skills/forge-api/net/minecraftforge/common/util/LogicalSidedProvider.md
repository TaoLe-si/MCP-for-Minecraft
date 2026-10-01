# LogicalSidedProvider

> `net.minecraftforge.common.util.LogicalSidedProvider` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/util/LogicalSidedProvider.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（5 个）

```java
public static final LogicalSidedProvider<BlockableEventLoop<? super TickTask>> WORKQUEUE = new LogicalSidedProvider<>(Supplier::get, Sup…
```
源码 :21 —（无 javadoc）

```java
public static final LogicalSidedProvider<Optional<Level>> CLIENTWORLD = new LogicalSidedProvider<>((c)-> Optional.of(…
```
源码 :22 —（无 javadoc）

```java
public static void setClient(Supplier<Minecraft> client)
```
源码 :28 —（无 javadoc）

```java
public static void setServer(Supplier<MinecraftServer> server)
```
源码 :32 —（无 javadoc）

```java
public T get(final LogicalSide side)
```
源码 :46 —（无 javadoc）

