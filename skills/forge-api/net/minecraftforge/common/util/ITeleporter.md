# ITeleporter

> `net.minecraftforge.common.util.ITeleporter` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/util/ITeleporter.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Interface for handling the placement of entities during dimension change. An implementation of this interface can be used to place the entity in a safe location, or generate a return portal, for instance. See the PortalForcer class, which has been patched to implement this interface, for a vanilla example.

## 公开成员（4 个）

```java
default Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld, float yaw, Function<Boolean, Entity> repositionEntity)
```
源码 :48 — Called to handle placing the entity in the new world. The initial position of the entity will be its position in the origin world, multiplied horizontally by the computed cross-dimensional movement factor. Note that the supplied entity has not yet been spawned in the destination world at the time. @…

```java
default PortalInfo getPortalInfo(Entity entity, ServerLevel destWorld, Function<ServerLevel, PortalInfo> defaultPortalInfo)
```
源码 :67 —（无 javadoc）

```java
default boolean isVanilla()
```
源码 :75 — Is this teleporter the vanilla instance.

```java
default boolean playTeleportSound(ServerPlayer player, ServerLevel sourceWorld, ServerLevel destWorld)
```
源码 :87 — Called when vanilla wants to play the portal sound after teleporting. Return true to play the vanilla sound. @param player the player @param sourceWorld the source world @param destWorld the target world @return true to play the vanilla sound

