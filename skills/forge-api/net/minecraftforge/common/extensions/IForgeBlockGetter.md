# IForgeBlockGetter

> `net.minecraftforge.common.extensions.IForgeBlockGetter` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeBlockGetter.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（2 个）

```java
private BlockGetter self() { return (BlockGetter) this; } /** * Get the {@link BlockEntity} at the given position if it exists. * <p> * {@link Level#getBlockEntity(BlockPos)} would create a new {@link BlockEntity} if the * {@link net.minecraft.world.level.block.Block} has one, but it has not been placed in the world yet * (This can happen on world load). * @return The BlockEntity at the given position or null if it doesn't exist */ @Nullable default BlockEntity getExistingBlockEntity(BlockPos pos)
```
源码 :19 —（无 javadoc）

```java
default ModelDataManager getModelDataManager()
```
源码 :57 —（无 javadoc）

