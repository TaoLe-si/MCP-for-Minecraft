# GrindstoneEvent

> `net.minecraftforge.event.GrindstoneEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/GrindstoneEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（7 个）

```java
protected GrindstoneEvent(ItemStack top, ItemStack bottom, int xp)
```
源码 :20 —（无 javadoc）

```java
public ItemStack getTopItem()
```
源码 :30 — @return The item in the top input grindstone slot.

```java
public ItemStack getBottomItem()
```
源码 :38 — @return The item in the bottom input grindstone slot.

```java
public int getXp()
```
源码 :47 — This is the experience amount determined by the event. It will be `-1` unless #setXp(int) is called. @return The experience amount given to the player.

```java
public void setXp(int xp)
```
源码 :56 — Sets the experience amount. @param xp The experience amount given to the player.

```java
public static class OnPlaceItem extends GrindstoneEvent
```
源码 :82 —（无 javadoc）

```java
public static class OnTakeItem extends GrindstoneEvent
```
源码 :122 —（无 javadoc）

