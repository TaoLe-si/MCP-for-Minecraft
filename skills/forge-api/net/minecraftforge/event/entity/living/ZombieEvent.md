# ZombieEvent

> `net.minecraftforge.event.entity.living.ZombieEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/ZombieEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：ZombieEvent is fired whenever a zombie is spawned for aid. If a method utilizes this event as its parameter, the method will receive every child event of this class. All children of this event are fired on the MinecraftForge#EVENT_BUS.

## 公开成员（3 个）

```java
public ZombieEvent(Zombie zombie)
```
源码 :28 —（无 javadoc）

```java
public Zombie getEntity()
```
源码 :35 —（无 javadoc）

```java
public static class SummonAidEvent extends ZombieEvent
```
源码 :64 —（无 javadoc）

