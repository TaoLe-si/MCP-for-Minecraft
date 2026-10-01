# LivingEquipmentChangeEvent

> `net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/LivingEquipmentChangeEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：LivingEquipmentChangeEvent is fired when the Equipment of a Entity changes. This event is fired whenever changes in Equipment are detected in LivingEntity#tick(). This also includes entities joining the World, as well as being cloned. This event is fired on server-side only. #slot contains the affected EquipmentSlot. #from contains the ItemStack that was equipped previously. #to contains the ItemS…

## 公开成员（2 个）

```java
public LivingEquipmentChangeEvent(LivingEntity entity, EquipmentSlot slot, @NotNull ItemStack from, @NotNull ItemStack to)
```
源码 :37 —（无 javadoc）

```java
public EquipmentSlot getSlot() { return this.slot; } @NotNull public ItemStack getFrom() { return this.from; } @NotNull public ItemStack getTo() { return this.to; } }
```
源码 :45 —（无 javadoc）

