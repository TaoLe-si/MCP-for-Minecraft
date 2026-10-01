# ExplosionEvent

> `net.minecraftforge.event.level.ExplosionEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/level/ExplosionEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：ExplosionEvent triggers when an explosion happens in the level. ExplosionEvent.Start is fired before the explosion actually occurs. ExplosionEvent.Detonate is fired once the explosion has a list of affected blocks and entities. ExplosionEvent.Start is Cancelable. ExplosionEvent.Detonate can modify the affected blocks and entities. Children do not use HasResult. Children of this event are fired on…

## 公开成员（5 个）

```java
public ExplosionEvent(Level level, Explosion explosion)
```
源码 :33 —（无 javadoc）

```java
public Level getLevel()
```
源码 :39 —（无 javadoc）

```java
public Explosion getExplosion()
```
源码 :44 —（无 javadoc）

```java
public static class Start extends ExplosionEvent
```
源码 :56 —（无 javadoc）

```java
public static class Detonate extends ExplosionEvent
```
源码 :70 — ExplosionEvent.Detonate is fired once the explosion has a list of affected blocks and entities. These lists can be modified to change the outcome. This event is not Cancelable. This event does not use HasResult. This event is fired on the MinecraftForge#EVENT_BUS.

