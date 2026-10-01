# PermissionsChangedEvent

> `net.minecraftforge.event.entity.player.PermissionsChangedEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/PermissionsChangedEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event will fire when the player is opped or deopped. This event is cancelable which will stop the op or deop from happening.

## 公开成员（3 个）

```java
public PermissionsChangedEvent(ServerPlayer player, int newLevel, int oldLevel)
```
源码 :22 —（无 javadoc）

```java
public int getNewLevel()
```
源码 :32 — @return The new permission level.

```java
public int getOldLevel()
```
源码 :39 — @return The old permission level.

