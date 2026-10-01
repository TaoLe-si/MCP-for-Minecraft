# IItemHandlerModifiable

> `net.minecraftforge.items.IItemHandlerModifiable` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/items/IItemHandlerModifiable.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（1 个）

```java
void setStackInSlot(int slot, @NotNull ItemStack stack)
```
源码 :24 — Overrides the stack in the given slot. This method is used by the standard Forge helper methods and classes. It is not intended for general use by other mods, and the handler may throw an error if it is called unexpectedly. @param slot Slot to modify @param stack ItemStack to set slot to (may be emp…

