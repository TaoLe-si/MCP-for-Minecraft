# AttackEntityEvent

> `net.minecraftforge.event.entity.player.AttackEntityEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/AttackEntityEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：AttackEntityEvent is fired when a player attacks an Entity. This event is fired whenever a player attacks an Entity in Player#attack(Entity). #target contains the Entity that was damaged by the player. This event is Cancelable. If this event is canceled, the player does not attack the Entity. This event does not have a result. HasResult This event is fired on the MinecraftForge#EVENT_BUS.

## 公开成员（2 个）

```java
public AttackEntityEvent(Player player, Entity target)
```
源码 :31 —（无 javadoc）

```java
public Entity getTarget()
```
源码 :37 —（无 javadoc）

