# EntityEquipmentInvWrapper

> `net.minecraftforge.items.wrapper.EntityEquipmentInvWrapper` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/items/wrapper/EntityEquipmentInvWrapper.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**（源码 javadoc）：Exposes the armor or hands inventory of an LivingEntity as an IItemHandler using LivingEntity#getItemBySlot(EquipmentSlot) and LivingEntity#setItemSlot(EquipmentSlot,.

## 公开成员（13 个）

```java
protected final LivingEntity entity
```
源码 :29 — The entity.

```java
protected final List<EquipmentSlot> slots
```
源码 :34 — The slots exposed by this wrapper, with EquipmentSlot#getIndex() as the index.

```java
public EntityEquipmentInvWrapper(final LivingEntity entity, final EquipmentSlot.Type slotType)
```
源码 :40 — @param entity The entity. @param slotType The slot type to expose.

```java
public int getSlots()
```
源码 :58 —（无 javadoc）

```java
public ItemStack getStackInSlot(final int slot)
```
源码 :65 —（无 javadoc）

```java
public ItemStack insertItem(final int slot, @NotNull final ItemStack stack, final boolean simulate)
```
源码 :72 —（无 javadoc）

```java
public ItemStack extractItem(final int slot, final int amount, final boolean simulate)
```
源码 :113 —（无 javadoc）

```java
public int getSlotLimit(final int slot)
```
源码 :148 —（无 javadoc）

```java
protected int getStackLimit(final int slot, @NotNull final ItemStack stack)
```
源码 :154 —（无 javadoc）

```java
public void setStackInSlot(final int slot, @NotNull final ItemStack stack)
```
源码 :160 —（无 javadoc）

```java
public boolean isItemValid(int slot, @NotNull ItemStack stack)
```
源码 :169 —（无 javadoc）

```java
protected EquipmentSlot validateSlotIndex(final int slot)
```
源码 :174 —（无 javadoc）

```java
public static LazyOptional<IItemHandlerModifiable>[] create(LivingEntity entity)
```
源码 :182 —（无 javadoc）

