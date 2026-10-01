# PlayerInteractEvent

> `net.minecraftforge.event.entity.player.PlayerInteractEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/PlayerInteractEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：PlayerInteractEvent is fired when a player interacts in some way. All subclasses are fired on MinecraftForge#EVENT_BUS. See the individual documentation on each subevent for more details.

## 公开成员（15 个）

```java
public static class EntityInteractSpecific extends PlayerInteractEvent
```
源码 :68 —（无 javadoc）

```java
public static class EntityInteract extends PlayerInteractEvent
```
源码 :111 —（无 javadoc）

```java
public static class RightClickBlock extends PlayerInteractEvent
```
源码 :141 —（无 javadoc）

```java
public static class RightClickItem extends PlayerInteractEvent
```
源码 :217 —（无 javadoc）

```java
public static class RightClickEmpty extends PlayerInteractEvent
```
源码 :230 — This event is fired on the client side when the player right clicks empty space with an empty hand. The server is not aware of when the client right clicks empty space with an empty hand, you will need to tell the server yourself. This event cannot be canceled.

```java
public static class LeftClickBlock extends PlayerInteractEvent
```
源码 :254 —（无 javadoc）

```java
public static class LeftClickEmpty extends PlayerInteractEvent
```
源码 :353 — This event is fired on the client side when the player left clicks empty space with any ItemStack. The server is not aware of when the client left clicks empty space, you will need to tell the server yourself. This event cannot be canceled.

```java
public InteractionHand getHand()
```
源码 :365 —（无 javadoc）

```java
public ItemStack getItemStack()
```
源码 :374 —（无 javadoc）

```java
public BlockPos getPos()
```
源码 :387 —（无 javadoc）

```java
public Direction getFace()
```
源码 :396 —（无 javadoc）

```java
public Level getLevel()
```
源码 :404 — @return Convenience method to get the level of this interaction.

```java
public LogicalSide getSide()
```
源码 :412 — @return The effective, i.e. logical, side of this interaction. This will be LogicalSide#CLIENT on the client thread, and LogicalSide#SERVER on the server thread.

```java
public InteractionResult getCancellationResult()
```
源码 :422 — @return The InteractionResult that will be returned to vanilla if the event is cancelled, instead of calling the relevant method of the event. By default, this is InteractionResult#PASS, meaning cancelled events will cause the client to keep trying more interactions until something works.

```java
public void setCancellationResult(InteractionResult result)
```
源码 :432 — Set the InteractionResult that will be returned to vanilla if the event is cancelled, instead of calling the relevant method of the event. Note that this only has an effect on RightClickBlock, RightClickItem, EntityInteract, and EntityInteractSpecific.

