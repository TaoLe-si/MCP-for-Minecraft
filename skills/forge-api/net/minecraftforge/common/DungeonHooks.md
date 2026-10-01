# DungeonHooks

> `net.minecraftforge.common.DungeonHooks` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/DungeonHooks.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（4 个）

```java
public static float addDungeonMob(EntityType<?> type, int rarity)
```
源码 :35 — Adds a mob to the possible list of creatures the spawner will create. If the mob is already in the spawn list, the rarity will be added to the existing one, causing the mob to be more common. @param type Monster type @param rarity The rarity of selecting this mob over others. Must be greater then 0.…

```java
public static int removeDungeonMob(EntityType<?> name)
```
源码 :64 — Will completely remove a Mob from the dungeon spawn list. @param name The name of the mob to remove @return The rarity of the removed mob, prior to being removed.

```java
public static EntityType<?> getRandomDungeonMob(RandomSource rand)
```
源码 :82 — Gets a random mob name from the list. @param rand World generation random number generator @return The mob name

```java
public static class DungeonMob extends WeightedEntry.IntrusiveBase
```
源码 :89 —（无 javadoc）

