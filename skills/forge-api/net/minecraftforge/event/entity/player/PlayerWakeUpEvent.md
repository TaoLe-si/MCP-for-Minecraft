# PlayerWakeUpEvent

> `net.minecraftforge.event.entity.player.PlayerWakeUpEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/PlayerWakeUpEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is fired when the player is waking up. This is merely for purposes of listening for this to happen. There is nothing that can be manipulated with this event.

## 公开成员（2 个）

```java
public PlayerWakeUpEvent(Player player, boolean wakeImmediately, boolean updateLevel)
```
源码 :21 —（无 javadoc）

```java
public boolean wakeImmediately() { return wakeImmediately; } /** * Indicates if the server should be notified of sleeping changes. * This will only be false if the server is considered 'up to date' already, because, for example, it initiated the call. */ public boolean updateLevel() { return updateLevel; } }
```
源码 :32 — Used for the 'wake up animation'. This is false if the player is considered 'sleepy' and the overlay should slowly fade away.

