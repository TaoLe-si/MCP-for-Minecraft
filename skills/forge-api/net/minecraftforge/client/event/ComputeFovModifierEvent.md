# ComputeFovModifierEvent

> `net.minecraftforge.client.event.ComputeFovModifierEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/ComputeFovModifierEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired after the field of vision (FOV) modifier for the player is calculated to allow developers to adjust it further. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client. @see ViewportEvent.ComputeFov

## 公开成员（5 个）

```java
public ComputeFovModifierEvent(Player player, float fovModifier)
```
源码 :34 —（无 javadoc）

```java
public Player getPlayer()
```
源码 :44 — the player affected by this event

```java
public float getFovModifier()
```
源码 :52 — the original field of vision (FOV) of the player, before any modifications or interpolation

```java
public float getNewFovModifier()
```
源码 :60 — the current field of vision (FOV) of the player

```java
public void setNewFovModifier(float newFovModifier)
```
源码 :70 — Sets the new field of vision (FOV) of the player. @param newFovModifier the new field of vision (FOV)

