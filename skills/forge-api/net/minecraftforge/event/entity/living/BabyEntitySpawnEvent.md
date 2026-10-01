# BabyEntitySpawnEvent

> `net.minecraftforge.event.entity.living.BabyEntitySpawnEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/BabyEntitySpawnEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：BabyEntitySpawnEvent is fired just before a baby entity is about to be spawned. Parents will have disengaged their relationship. Cancelable It is possible to change the child completely by using #setChild(AgeableMob) This event is fired from Animal#spawnChildFromBreeding(ServerLevel, and Fox#spawnChildFromBreeding(ServerLevel, #parentA contains the initiating parent entity. #parentB contains the s…

## 公开成员（6 个）

```java
public BabyEntitySpawnEvent(Mob parentA, Mob parentB, @Nullable AgeableMob proposedChild)
```
源码 :46 —（无 javadoc）

```java
public Mob getParentA()
```
源码 :65 —（无 javadoc）

```java
public Mob getParentB()
```
源码 :70 —（无 javadoc）

```java
public Player getCausedByPlayer()
```
源码 :76 —（无 javadoc）

```java
public AgeableMob getChild()
```
源码 :82 —（无 javadoc）

```java
public void setChild(AgeableMob proposedChild)
```
源码 :87 —（无 javadoc）

