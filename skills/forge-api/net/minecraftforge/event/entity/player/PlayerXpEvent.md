# PlayerXpEvent

> `net.minecraftforge.event.entity.player.PlayerXpEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/PlayerXpEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：PlayerXpEvent is fired whenever an event involving player experience occurs. If a method utilizes this net.minecraftforge.eventbus.api.Event as its parameter, the method will receive every child event of this class. All children of this event are fired on the MinecraftForge#EVENT_BUS.

## 公开成员（4 个）

```java
public PlayerXpEvent(Player player)
```
源码 :23 —（无 javadoc）

```java
public static class PickupXp extends PlayerXpEvent
```
源码 :33 —（无 javadoc）

```java
public static class XpChange extends PlayerXpEvent
```
源码 :56 —（无 javadoc）

```java
public static class LevelChange extends PlayerXpEvent
```
源码 :84 —（无 javadoc）

