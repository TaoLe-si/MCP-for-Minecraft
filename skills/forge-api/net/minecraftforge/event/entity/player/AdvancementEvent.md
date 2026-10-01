# AdvancementEvent

> `net.minecraftforge.event.entity.player.AdvancementEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/AdvancementEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Base class used for advancement-related events. Should not be used directly. @see AdvancementEarnEvent @see AdvancementProgressEvent

## 公开成员（4 个）

```java
public AdvancementEvent(Player player, Advancement advancement)
```
源码 :22 —（无 javadoc）

```java
public Advancement getAdvancement()
```
源码 :28 —（无 javadoc）

```java
public static class AdvancementEarnEvent extends AdvancementEvent
```
源码 :46 — Fired when the player earns an advancement. An advancement is earned once its requirements are complete. Note that advancements may be hidden from the player or used in background mechanics, such as recipe advancements for unlocking recipes in the recipe book. This event is not net.minecraftforge.ev…

```java
public static class AdvancementProgressEvent extends AdvancementEvent
```
源码 :77 — Fired when the player's progress on an advancement criterion is granted or revoked. This event is not net.minecraftforge.eventbus.api.Cancelable cancellable, and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the net.minecraftforge…

