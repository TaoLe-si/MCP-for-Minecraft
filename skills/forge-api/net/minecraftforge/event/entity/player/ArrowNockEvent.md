# ArrowNockEvent

> `net.minecraftforge.event.entity.player.ArrowNockEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/ArrowNockEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：ArrowNockEvent is fired when a player begins using a bow. This event is fired whenever a player begins using a bow in BowItem#use(Level,. This event is fired on the MinecraftForge#EVENT_BUS.

## 公开成员（3 个）

```java
public ArrowNockEvent(Player player, @NotNull ItemStack item, InteractionHand hand, Level level, boolean hasAmmo)
```
源码 :32 —（无 javadoc）

```java
public ItemStack getBow() { return this.bow; } public Level getLevel() { return this.level; } public InteractionHand getHand() { return this.hand; } public boolean hasAmmo() { return this.hasAmmo; } public InteractionResultHolder<ItemStack> getAction()
```
源码 :42 —（无 javadoc）

```java
public void setAction(InteractionResultHolder<ItemStack> action)
```
源码 :51 —（无 javadoc）

