# ToolActions

> `net.minecraftforge.common.ToolActions` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/ToolActions.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（25 个）

```java
public static final ToolAction AXE_DIG = ToolAction.get("axe_dig")
```
源码 :21 — Exposed by axes to allow querying tool behaviours

```java
public static final ToolAction PICKAXE_DIG = ToolAction.get("pickaxe_dig")
```
源码 :26 — Exposed by pickaxes to allow querying tool behaviours

```java
public static final ToolAction SHOVEL_DIG = ToolAction.get("shovel_dig")
```
源码 :31 — Exposed by shovels to allow querying tool behaviours

```java
public static final ToolAction HOE_DIG = ToolAction.get("hoe_dig")
```
源码 :36 — Exposed by hoes to allow querying tool behaviours

```java
public static final ToolAction SWORD_DIG = ToolAction.get("sword_dig")
```
源码 :41 — Exposed by swords to allow querying tool behaviours

```java
public static final ToolAction SHEARS_DIG = ToolAction.get("shears_dig")
```
源码 :46 — Exposed by shears to allow querying tool behaviours

```java
public static final ToolAction AXE_STRIP = ToolAction.get("axe_strip")
```
源码 :51 — Passed onto IForgeBlock#getToolModifiedState when an axe wants to strip a log

```java
public static final ToolAction AXE_SCRAPE = ToolAction.get("axe_scrape")
```
源码 :56 — Passed onto IForgeBlock#getToolModifiedState when an axe wants to scrape oxidization off copper

```java
public static final ToolAction AXE_WAX_OFF = ToolAction.get("axe_wax_off")
```
源码 :61 — Passed onto IForgeBlock#getToolModifiedState when an axe wants to remove wax out of copper

```java
public static final ToolAction SHOVEL_FLATTEN = ToolAction.get("shovel_flatten")
```
源码 :66 — Passed onto IForgeBlock#getToolModifiedState when a shovel wants to turn dirt into path

```java
public static final ToolAction SWORD_SWEEP = ToolAction.get("sword_sweep")
```
源码 :73 — Used during player attack to figure out if a sweep attack should be performed @see IForgeItem#getSweepHitBox

```java
public static final ToolAction SHEARS_HARVEST = ToolAction.get("shears_harvest")
```
源码 :79 — This action is exposed by shears and corresponds to a harvest action that is triggered with a right click on a block that supports such behaviour. Example: Right click with shears on a beehive with honey level 5 to harvest it

```java
public static final ToolAction SHEARS_CARVE = ToolAction.get("shears_carve")
```
源码 :85 — This action is exposed by shears and corresponds to a carve action that is triggered with a right click on a block that supports such behaviour. Example: Right click with shears o a pumpkin to carve it

```java
public static final ToolAction SHEARS_DISARM = ToolAction.get("shears_disarm")
```
源码 :91 — This action is exposed by shears and corresponds to a disarm action that is triggered by breaking a block that supports such behaviour. Example: Breaking a trip wire with shears to disarm it.

```java
public static final ToolAction HOE_TILL = ToolAction.get("till")
```
源码 :96 — Passed onto IForgeBlock#getToolModifiedState when a hoe wants to turn dirt into soil

```java
public static final ToolAction SHIELD_BLOCK = ToolAction.get("shield_block")
```
源码 :101 — A tool action corresponding to the 'block' action of shields.

```java
public static final ToolAction FISHING_ROD_CAST = ToolAction.get("fishing_rod_cast")
```
源码 :106 — This action corresponds to right-clicking the fishing rod.

```java
public static final Set<ToolAction> DEFAULT_AXE_ACTIONS = of(AXE_DIG, AXE_STRIP, AXE_SCRAPE, AXE_WAX_OFF)
```
源码 :109 —（无 javadoc）

```java
public static final Set<ToolAction> DEFAULT_HOE_ACTIONS = of(HOE_DIG, HOE_TILL)
```
源码 :110 —（无 javadoc）

```java
public static final Set<ToolAction> DEFAULT_SHOVEL_ACTIONS = of(SHOVEL_DIG, SHOVEL_FLATTEN)
```
源码 :111 —（无 javadoc）

```java
public static final Set<ToolAction> DEFAULT_PICKAXE_ACTIONS = of(PICKAXE_DIG)
```
源码 :112 —（无 javadoc）

```java
public static final Set<ToolAction> DEFAULT_SWORD_ACTIONS = of(SWORD_DIG, SWORD_SWEEP)
```
源码 :113 —（无 javadoc）

```java
public static final Set<ToolAction> DEFAULT_SHEARS_ACTIONS = of(SHEARS_DIG, SHEARS_HARVEST, SHEARS_CARVE, …
```
源码 :114 —（无 javadoc）

```java
public static final Set<ToolAction> DEFAULT_SHIELD_ACTIONS = of(SHIELD_BLOCK)
```
源码 :115 —（无 javadoc）

```java
public static final Set<ToolAction> DEFAULT_FISHING_ROD_ACTIONS = of(FISHING_ROD_CAST)
```
源码 :116 —（无 javadoc）

