# LivingDestroyBlockEvent

> `net.minecraftforge.event.entity.living.LivingDestroyBlockEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/LivingDestroyBlockEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired when the ender dragon or wither attempts to destroy a block and when ever a zombie attempts to break a door. Basically a event version of Block#canEntityDestroy(BlockState, This event is Cancelable. If this event is canceled, the block will not be destroyed. This event does not have a result. HasResult This event is fired on the MinecraftForge#EVENT_BUS.

## 公开成员（3 个）

```java
public LivingDestroyBlockEvent(LivingEntity entity, BlockPos pos, BlockState state)
```
源码 :33 —（无 javadoc）

```java
public BlockState getState()
```
源码 :40 —（无 javadoc）

```java
public BlockPos getPos()
```
源码 :45 —（无 javadoc）

