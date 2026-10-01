# MovementInputUpdateEvent

> `net.minecraftforge.client.event.MovementInputUpdateEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/MovementInputUpdateEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired after the player's movement inputs are updated. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client.

## 公开成员（2 个）

```java
public MovementInputUpdateEvent(Player player, Input input)
```
源码 :29 —（无 javadoc）

```java
public Input getInput()
```
源码 :38 — the player's movement inputs

