# AnvilUpdateEvent

> `net.minecraftforge.event.AnvilUpdateEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/AnvilUpdateEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：AnvilUpdateEvent is fired whenever the input stacks (left or right) or the name in an anvil changed. It is called from AnvilMenu#createResult(). If the event is canceled, vanilla behavior will not run, and the output will be set to ItemStack#EMPTY. If the event is not canceled, but the output is not empty, it will set the output and not run vanilla behavior. if the output is empty, and the event i…

## 公开成员（11 个）

```java
public AnvilUpdateEvent(ItemStack left, ItemStack right, String name, int cost, Player player)
```
源码 :35 —（无 javadoc）

```java
public ItemStack getLeft()
```
源码 :49 — @return The item in the left input (leftmost) anvil slot.

```java
public ItemStack getRight()
```
源码 :57 — @return The item in the right input (center) anvil slot.

```java
public String getName()
```
源码 :68 —（无 javadoc）

```java
public ItemStack getOutput()
```
源码 :80 — This is the output as determined by the event, not by the vanilla behavior between these two items. If you are the first receiver of this event, it is guaranteed to be empty. It will only be non-empty if changed by an event handler. If this event is cancelled, this output stack is discarded. @return…

```java
public void setOutput(ItemStack output)
```
源码 :89 — Sets the output slot to a specific itemstack. @param output The stack to change the output to.

```java
public int getCost()
```
源码 :99 — This is the level cost of this anvil operation. When unchanged, it is guaranteed to be left.getRepairCost() + right.getRepairCost(). @return The level cost of this anvil operation.

```java
public void setCost(int cost)
```
源码 :110 — Changes the level cost of this operation. The level cost does prevent the output from being available. That is, a player without enough experience may not take the output. @param cost The new level cost.

```java
public int getMaterialCost()
```
源码 :119 — The material cost is how many units of the right input stack are consumed. @return The material cost of this anvil operation.

```java
public void setMaterialCost(int materialCost)
```
源码 :132 — Sets how many right inputs are consumed. A material cost of zero consumes the entire stack. A material cost higher than the count of the right stack consumes the entire stack. The material cost does not prevent the output from being available. @param materialCost The new material cost.

```java
public Player getPlayer()
```
源码 :140 — @return The player using this anvil container.

