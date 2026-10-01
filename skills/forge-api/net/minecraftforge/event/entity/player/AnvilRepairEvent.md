# AnvilRepairEvent

> `net.minecraftforge.event.entity.player.AnvilRepairEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/AnvilRepairEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired when the player removes a "repaired" item from the Anvil's Output slot. breakChance specifies as a percentage the chance that the anvil will be "damaged" when used. ItemStacks are the inputs/output from the anvil. They cannot be edited.

## 公开成员（2 个）

```java
public AnvilRepairEvent(Player player, @NotNull ItemStack left, @NotNull ItemStack right, @NotNull ItemStack output)
```
源码 :29 —（无 javadoc）

```java
public ItemStack getOutput() { return output; } /** * Get the first item input into the anvil * @return the first input slot */ @NotNull public ItemStack getLeft() { return left; } /** * Get the second item input into the anvil * @return the second input slot */ @NotNull public ItemStack getRight() { return right; } public float getBreakChance() { return breakChance; } public void setBreakChance(float breakChance) { this.breakChance = breakChance; } }
```
源码 :43 —（无 javadoc）

