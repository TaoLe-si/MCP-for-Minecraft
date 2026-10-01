# LivingConversionEvent

> `net.minecraftforge.event.entity.living.LivingConversionEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/LivingConversionEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（3 个）

```java
public LivingConversionEvent(LivingEntity entity)
```
源码 :16 —（无 javadoc）

```java
public static class Pre extends LivingConversionEvent
```
源码 :33 —（无 javadoc）

```java
public static class Post extends LivingConversionEvent
```
源码 :74 — LivingConversionEvent.Post is triggered when an entity is replacing itself with another entity. The old living entity is likely to be removed right after this event.

