# EnderManAngerEvent

> `net.minecraftforge.event.entity.living.EnderManAngerEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/EnderManAngerEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is fired on the forge bus before an Enderman detects that a player is looking at them. It will not be fired if the detection is already prevented by IForgeItem#isEnderMask This event is Cancelable. If this event is canceled, the Enderman will not target the player. This event does not have a Result.

## 公开成员（3 个）

```java
public EnderManAngerEvent(EnderMan enderman, Player player)
```
源码 :27 —（无 javadoc）

```java
public Player getPlayer()
```
源码 :36 — The player that is being checked.

```java
public EnderMan getEntity()
```
源码 :42 —（无 javadoc）

