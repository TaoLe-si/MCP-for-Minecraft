# ItemTooltipEvent

> `net.minecraftforge.event.entity.player.ItemTooltipEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/ItemTooltipEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（5 个）

```java
public ItemTooltipEvent(@NotNull ItemStack itemStack, @Nullable Player player, List<Component> list, TooltipFlag flags)
```
源码 :29 — This event is fired in ItemStack#getTooltipLines(Player,, which in turn is called from its respective GUIContainer. Tooltips are also gathered with a null player during startup by Minecraft#createSearchTrees().

```java
public TooltipFlag getFlags()
```
源码 :40 — Use to determine if the advanced information on item tooltips is being shown, toggled by F3+H.

```java
public ItemStack getItemStack()
```
源码 :49 —（无 javadoc）

```java
public List<Component> getToolTip()
```
源码 :57 — The ItemStack tooltip.

```java
public Player getEntity()
```
源码 :67 —（无 javadoc）

