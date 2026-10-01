# ArrowLooseEvent

> `net.minecraftforge.event.entity.player.ArrowLooseEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/ArrowLooseEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：ArrowLooseEvent is fired when a player stops using a bow. This event is fired whenever a player stops using a bow in BowItem#releaseUsing(ItemStack,. #bow contains the ItemBow ItemStack that was used in this event. #charge contains the value for how much the player had charged before stopping the shot. This event is Cancelable. If this event is canceled, the player does not stop using the bow. For…

## 公开成员（2 个）

```java
public ArrowLooseEvent(Player player, @NotNull ItemStack bow, Level level, int charge, boolean hasAmmo)
```
源码 :41 —（无 javadoc）

```java
public ItemStack getBow() { return this.bow; } public Level getLevel() { return this.level; } public boolean hasAmmo() { return this.hasAmmo; } public int getCharge() { return this.charge; } public void setCharge(int charge) { this.charge = charge; } }
```
源码 :51 —（无 javadoc）

