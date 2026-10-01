# ModelDataManager

> `net.minecraftforge.client.model.data.ModelDataManager` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/data/ModelDataManager.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：A manager for the lifecycle of all the ModelData instances in a Level. Users should not be instantiating or using this themselves unless they know what they're doing.

## 公开成员（5 个）

```java
public ModelDataManager(Level level)
```
源码 :41 —（无 javadoc）

```java
public void requestRefresh(@NotNull BlockEntity blockEntity)
```
源码 :46 —（无 javadoc）

```java
public @Nullable ModelData getAt(BlockPos pos)
```
源码 :75 —（无 javadoc）

```java
public Map<BlockPos, ModelData> getAt(ChunkPos pos)
```
源码 :80 —（无 javadoc）

```java
public static void onChunkUnload(ChunkEvent.Unload event)
```
源码 :88 —（无 javadoc）

