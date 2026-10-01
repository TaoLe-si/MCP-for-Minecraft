# LivingPackSizeEvent

> `net.minecraftforge.event.entity.living.LivingPackSizeEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/LivingPackSizeEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（3 个）

```java
public LivingPackSizeEvent(Mob entity)
```
源码 :16 —（无 javadoc）

```java
public int getMaxPackSize()
```
源码 :29 — This event is fired when the spawning system determines the maximum amount of the selected entity that can spawn at the same time. If you set the result to 'ALLOW', it means that you want to return the value of maxPackSize as the maximum pack size for current entity.

```java
public void setMaxPackSize(int maxPackSize)
```
源码 :34 —（无 javadoc）

