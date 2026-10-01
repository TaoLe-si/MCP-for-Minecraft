# VanillaGameEvent

> `net.minecraftforge.event.VanillaGameEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/VanillaGameEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：VanillaGameEvent is fired on the server whenever one of Vanilla's GameEvent fire. This allows for listening to Vanilla's events in a more structured and global way that is not tied to needing a block entity listener. This event is fired on the MinecraftForge#EVENT_BUS. Cancel this event to prevent Vanilla from posting the GameEvent to all nearby net.minecraft.world.level.gameevent.GameEventListene…

## 公开成员（6 个）

```java
public VanillaGameEvent(Level level, GameEvent vanillaEvent, Vec3 position, GameEvent.Context context)
```
源码 :34 —（无 javadoc）

```java
public Level getLevel()
```
源码 :45 — @return The level the Vanilla GameEvent occurred.

```java
public Entity getCause()
```
源码 :54 —（无 javadoc）

```java
public GameEvent getVanillaEvent()
```
源码 :62 — @return The Vanilla event.

```java
public Vec3 getEventPosition()
```
源码 :70 — @return The position the event took place at.

```java
public GameEvent.Context getContext()
```
源码 :78 — @return the context of the vanilla event

