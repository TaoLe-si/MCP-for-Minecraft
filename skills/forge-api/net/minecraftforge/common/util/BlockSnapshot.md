# BlockSnapshot

> `net.minecraftforge.common.util.BlockSnapshot` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/util/BlockSnapshot.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Represents a captured snapshot of a block which will not change automatically. Unlike Block, which only one object can exist per coordinate, BlockSnapshot can exist multiple times for any given Block.

## 公开成员（14 个）

```java
public static BlockSnapshot create(ResourceKey<Level> dim, LevelAccessor world, BlockPos pos)
```
源码 :59 —（无 javadoc）

```java
public static BlockSnapshot create(ResourceKey<Level> dim, LevelAccessor world, BlockPos pos, int flag)
```
源码 :64 —（无 javadoc）

```java
public BlockState getCurrentBlock()
```
源码 :75 —（无 javadoc）

```java
public LevelAccessor getLevel()
```
源码 :82 —（无 javadoc）

```java
public BlockState getReplacedBlock()
```
源码 :93 —（无 javadoc）

```java
public BlockEntity getBlockEntity()
```
源码 :99 —（无 javadoc）

```java
public boolean restore()
```
源码 :104 —（无 javadoc）

```java
public boolean restore(boolean force)
```
源码 :109 —（无 javadoc）

```java
public boolean restore(boolean force, boolean notifyNeighbors)
```
源码 :114 —（无 javadoc）

```java
public boolean restoreToLocation(LevelAccessor world, BlockPos pos, boolean force, boolean notifyNeighbors)
```
源码 :119 —（无 javadoc）

```java
public boolean equals(Object obj)
```
源码 :155 —（无 javadoc）

```java
public int hashCode()
```
源码 :171 —（无 javadoc）

```java
public String toString()
```
源码 :183 —（无 javadoc）

```java
public BlockPos getPos() { return pos; } public int getFlag() { return flags; } @Nullable public CompoundTag getTag() { return nbt; } }
```
源码 :199 —（无 javadoc）

