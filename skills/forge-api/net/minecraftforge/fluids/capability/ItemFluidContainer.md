# ItemFluidContainer

> `net.minecraftforge.fluids.capability.ItemFluidContainer` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fluids/capability/ItemFluidContainer.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**（源码 javadoc）：A simple fluid container, to replace the functionality of the old FluidContainerRegistry and IFluidContainerItem. This fluid container may be set so that is can only completely filled or empty. (binary) It may also be set so that it gets consumed when it is drained. (consumable)

## 公开成员（3 个）

```java
protected final int capacity
```
源码 :23 —（无 javadoc）

```java
public ItemFluidContainer(Item.Properties properties, int capacity)
```
源码 :28 — @param capacity The maximum capacity of this fluid container.

```java
public ICapabilityProvider initCapabilities(@NotNull ItemStack stack, @Nullable CompoundTag nbt)
```
源码 :35 —（无 javadoc）

