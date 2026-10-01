# MobEffectEvent

> `net.minecraftforge.event.entity.living.MobEffectEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/MobEffectEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is fired when an interaction between a LivingEntity and MobEffectInstance happens. All children of this event are fired on the MinecraftForge#EVENT_BUS.

## 公开成员（7 个）

```java
protected final MobEffectInstance effectInstance
```
源码 :27 —（无 javadoc）

```java
public MobEffectEvent(LivingEntity living, MobEffectInstance effectInstance)
```
源码 :29 —（无 javadoc）

```java
public MobEffectInstance getEffectInstance()
```
源码 :36 —（无 javadoc）

```java
public static class Remove extends MobEffectEvent
```
源码 :47 —（无 javadoc）

```java
public static class Applicable extends MobEffectEvent
```
源码 :92 —（无 javadoc）

```java
public static class Added extends MobEffectEvent
```
源码 :113 — This event is fired when a new MobEffectInstance is added to an entity. This event is also fired if an entity already has the effect but with a different duration or amplifier. This event is not Cancelable. This event does not have a result.

```java
public static class Expired extends MobEffectEvent
```
源码 :159 — This event is fired when a MobEffectInstance expires on an entity. This event is not Cancelable. This event does not have a result.

