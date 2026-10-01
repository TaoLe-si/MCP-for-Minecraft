# IForgePlayer

> `net.minecraftforge.common.extensions.IForgePlayer` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgePlayer.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（9 个）

```java
private Player self()
```
源码 :17 —（无 javadoc）

```java
default double getEntityReach()
```
源码 :27 — The entity reach is increased by 3 for creative players, unless it is currently zero, which disables attacks and entity interactions. This comes from net.minecraft.client.multiplayer.MultiPlayerGameMode#getPickRange() If you want the raw value, get the attribute yourself. @return The entity reach of…

```java
default double getBlockReach()
```
源码 :38 — The reach distance is increased by 0.5 for creative players, unless it is currently zero, which disables interactions. This comes from net.minecraft.client.multiplayer.MultiPlayerGameMode#getPickRange() If you want the raw value, get the attribute yourself. @return The reach distance of this player.

```java
default boolean canReach(Vec3 entityHitVec, double padding)
```
源码 :51 — Checks if the player can reach an entity by targeting the passed vector. On the server, additional padding is added to account for movement/lag. @param entityHitVec The vector being range-checked. @param padding Extra validation distance. @return If the player can attack the entity. @apiNote Do not…

```java
default boolean canReach(Entity entity, double padding)
```
源码 :63 — Checks if the player can reach an entity. On the server, additional padding is added to account for movement/lag. @param entity The entity being range-checked. @param padding Extra validation distance. @return If the player can attack the passed entity. @apiNote Prefer using #canReach(Vec3, if you h…

```java
default boolean canReachRaw(Entity entity, double padding)
```
源码 :79 — Checks if the player can reach an entity. On the server, additional padding is added to account for movement/lag. Unlike #getEntityReach() or #canReach(Entity,double) this does not add the 3.0 creative mode implicit padding. @param entity The entity being range-checked. @param padding Extra validati…

```java
default boolean canReach(BlockPos pos, double padding)
```
源码 :91 — Checks if the player can reach a block. On the server, additional padding is added to account for movement/lag. @param pos The position being range-checked. @param padding Extra validation distance. @return If the player can interact with this location.

```java
default boolean canReachRaw(BlockPos pos, double padding)
```
源码 :107 — Checks if the player can reach a block. On the server, additional padding is added to account for movement/lag. Unlike #getBlockReach() or #canReach(BlockPos,double) this does not add the 0.5 creative mode implicit padding. @param pos The position being range-checked. @param padding Extra validation…

```java
default boolean isCloseEnough(Entity entity, double dist)
```
源码 :119 — Utility check to see if the player is close enough to a target entity. Uses "eye-to-closest-corner" checks. @param entity The entity being checked against @param dist The max distance allowed @return If the eye-to-center distance between this player and the passed entity is less than dist. @implNote…

