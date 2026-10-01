# FillBucketEvent

> `net.minecraftforge.event.entity.player.FillBucketEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/FillBucketEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is fired when a player attempts to use a Empty bucket, it can be canceled to completely prevent any further processing. If you set the result to 'ALLOW', it means that you have processed the event and wants the basic functionality of adding the new ItemStack to your inventory and reducing the stack size to process. setResult(ALLOW) is the same as the old setHandled();

## 公开成员（2 个）

```java
public FillBucketEvent(Player player, @NotNull ItemStack current, Level level, @Nullable HitResult target)
```
源码 :38 —（无 javadoc）

```java
public ItemStack getEmptyBucket() { return this.current; } public Level getLevel(){ return this.level; } @Nullable public HitResult getTarget() { return this.target; } @NotNull public ItemStack getFilledBucket() { return this.result; } public void setFilledBucket(@NotNull ItemStack bucket) { this.result = bucket; } }
```
源码 :47 —（无 javadoc）

