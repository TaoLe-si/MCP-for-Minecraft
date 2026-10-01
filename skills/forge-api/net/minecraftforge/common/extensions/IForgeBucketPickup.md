# IForgeBucketPickup

> `net.minecraftforge.common.extensions.IForgeBucketPickup` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeBucketPickup.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（2 个）

```java
private BucketPickup self()
```
源码 :16 —（无 javadoc）

```java
default Optional<SoundEvent> getPickupSound(BlockState state)
```
源码 :30 — State sensitive variant of BucketPickup#getPickupSound(). Override to change the pickup sound based on the BlockState of the object being picked up. @param state State @return Sound event for pickup sound or empty if there isn't a pickup sound.

