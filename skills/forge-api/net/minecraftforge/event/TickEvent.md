# TickEvent

> `net.minecraftforge.event.TickEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/TickEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目用法**：ClientTickEvent：所有『要等 tick』的动作靠它推进

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（11 个）

```java
public enum Type
```
源码 :20 —（无 javadoc）

```java
public enum Phase
```
源码 :24 —（无 javadoc）

```java
public final Type type
```
源码 :27 —（无 javadoc）

```java
public final LogicalSide side
```
源码 :28 —（无 javadoc）

```java
public final Phase phase
```
源码 :29 —（无 javadoc）

```java
public TickEvent(Type type, LogicalSide side, Phase phase)
```
源码 :30 —（无 javadoc）

```java
public static class ServerTickEvent extends TickEvent
```
源码 :37 —（无 javadoc）

```java
public static class ClientTickEvent extends TickEvent
```
源码 :67 — the server instance

```java
public static class LevelTickEvent extends TickEvent
```
源码 :74 —（无 javadoc）

```java
public static class PlayerTickEvent extends TickEvent
```
源码 :97 — @return `true` whether the server has enough time to perform any additional tasks (usually IO related) during the current tick, otherwise `false` @see ServerTickEvent#haveTime()

```java
public static class RenderTickEvent extends TickEvent
```
源码 :107 —（无 javadoc）

