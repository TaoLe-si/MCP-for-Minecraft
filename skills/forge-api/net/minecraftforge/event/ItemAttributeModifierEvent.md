# ItemAttributeModifierEvent

> `net.minecraftforge.event.ItemAttributeModifierEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/ItemAttributeModifierEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is fired when the attributes for an ItemStack are being calculated. Attributes are calculated on the server when equipping and unequipping an item to add and remove attributes respectively, both must be consistent. Attributes are calculated on the client when rendering an item's tooltip to show relevant attributes. Note that this event is fired regardless of if the stack has NBT overrid…

## 公开成员（9 个）

```java
public ItemAttributeModifierEvent(ItemStack stack, EquipmentSlot slotType, Multimap<Attribute, AttributeModifier> modifiers)
```
源码 :39 —（无 javadoc）

```java
public Multimap<Attribute, AttributeModifier> getModifiers()
```
源码 :51 — Returns an unmodifiable view of the attribute multimap. Use other methods from this event to modify the attributes map. Note that adding attributes based on existing attributes may lead to inconsistent results between the tooltip (client) and the actual attributes (server) if the listener order is d…

```java
public Multimap<Attribute, AttributeModifier> getOriginalModifiers()
```
源码 :59 — Returns the attribute map before any changes from other event listeners was made.

```java
public boolean addModifier(Attribute attribute, AttributeModifier modifier)
```
源码 :85 — Adds a new attribute modifier to the given stack. Modifier must have a consistent UUID for consistency between equipping and unequipping items. Modifier name should clearly identify the mod that added the modifier. @param attribute Attribute @param modifier Modifier instance. @return True if the att…

```java
public boolean removeModifier(Attribute attribute, AttributeModifier modifier)
```
源码 :96 — Removes a single modifier for the given attribute @param attribute Attribute @param modifier Modifier instance @return True if an attribute was removed, false if no change

```java
public Collection<AttributeModifier> removeAttribute(Attribute attribute)
```
源码 :106 — Removes all modifiers for the given attribute @param attribute Attribute @return Collection of removed modifiers

```java
public void clearModifiers()
```
源码 :114 — Removes all modifiers for all attributes

```java
public EquipmentSlot getSlotType()
```
源码 :120 — Gets the slot containing this stack

```java
public ItemStack getItemStack()
```
源码 :126 — Gets the item stack instance

