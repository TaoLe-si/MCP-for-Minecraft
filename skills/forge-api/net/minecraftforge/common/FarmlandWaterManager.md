# FarmlandWaterManager

> `net.minecraftforge.common.FarmlandWaterManager` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/FarmlandWaterManager.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（3 个）

```java
public static<T extends SimpleTicket<Vec3>> T addCustomTicket(Level level, T ticket, ChunkPos masterChunk, ChunkPos... additionalChunks)
```
源码 :47 —（无 javadoc）

```java
public static AABBTicket addAABBTicket(Level level, AABB aabb)
```
源码 :70 — Convenience method to add a ticket that is backed by an AABB. If you don't want to water the region anymore, call SimpleTicket#invalidate(). Also call this when the region this is unloaded (e.g. your TE is unloaded or the block is removed), and validate once it is loaded The AABB in the ticket is im…

```java
public static boolean hasBlockWaterTicket(LevelReader level, BlockPos pos)
```
源码 :118 — Tests if a block is in a region that is watered by blocks. This does not check vanilla water, see `net.minecraft.level.level.block.FarmBlock#isNearWater(LevelReader, BlockPos)` @return true if there is a ticket with an AABB that includes your block

