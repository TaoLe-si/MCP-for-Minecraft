# LivingEntityUseItemEvent

> `net.minecraftforge.event.entity.living.LivingEntityUseItemEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/LivingEntityUseItemEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（7 个）

```java
public ItemStack getItem()
```
源码 :26 —（无 javadoc）

```java
public int getDuration()
```
源码 :31 —（无 javadoc）

```java
public void setDuration(int duration)
```
源码 :36 —（无 javadoc）

```java
public static class Start extends LivingEntityUseItemEvent
```
源码 :53 —（无 javadoc）

```java
public static class Tick extends LivingEntityUseItemEvent
```
源码 :68 —（无 javadoc）

```java
public static class Stop extends LivingEntityUseItemEvent
```
源码 :89 —（无 javadoc）

```java
public static class Finish extends LivingEntityUseItemEvent
```
源码 :109 — Fired after an item has fully finished being used. The item has been notified that it was used, and the item/result stacks reflect after that state. This means that when this is fired for a Potion, the potion effect has already been applied. LivingEntityUseItemEvent#item is a copy of the item BEFORE…

