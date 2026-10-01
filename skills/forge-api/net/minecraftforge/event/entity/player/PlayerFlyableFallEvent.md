# PlayerFlyableFallEvent

> `net.minecraftforge.event.entity.player.PlayerFlyableFallEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/PlayerFlyableFallEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Occurs when a player falls, but is able to fly. Doesn't need to be cancelable, this is mainly for notification purposes. @author Mithion

## 公开成员（2 个）

```java
public PlayerFlyableFallEvent(Player player, float distance, float multiplier)
```
源码 :20 —（无 javadoc）

```java
public float getDistance() { return distance;} public void setDistance(float distance) { this.distance = distance; } public float getMultiplier() { re…
```
源码 :27 —（无 javadoc）

