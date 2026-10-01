# IMinecartCollisionHandler

> `net.minecraftforge.common.IMinecartCollisionHandler` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/IMinecartCollisionHandler.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This class defines a replacement for the default minecart collision code. Only one handler can be registered at a time. It it registered with AbstractMinecartEntity.registerCollisionHandler(). If you use this, make it a configuration option. @author CovertJaguar

## 公开成员（4 个）

```java
void onEntityCollision(AbstractMinecart cart, Entity other)
```
源码 :27 — This basically replaces the function of the same name in EntityMinecart. Code in IMinecartHooks.applyEntityCollisionHook is still run. @param cart The cart that called the collision. @param other The object it collided with.

```java
AABB getCollisionBox(AbstractMinecart cart, Entity other)
```
源码 :37 — This function replaced the function of the same name in EntityMinecart. It is used to define whether minecarts collide with specific entities, for example items. @param cart The cart for which the collision box was requested. @param other The entity requesting the collision box. @return The collisio…

```java
AABB getMinecartCollisionBox(AbstractMinecart cart)
```
源码 :45 — This function is used to define the box used for detecting minecart collisions. It is generally bigger that the normal collision box. @param cart The cart for which the collision box was requested. @return The collision box, cannot be null.

```java
AABB getBoundingBox(AbstractMinecart cart)
```
源码 :53 — This function replaces the function of the same name in EntityMinecart. It defines whether minecarts are solid to the player. @param cart The cart for which the bounding box was requested. @return The bounding box or null.

