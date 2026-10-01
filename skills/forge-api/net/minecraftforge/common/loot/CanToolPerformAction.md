# CanToolPerformAction

> `net.minecraftforge.common.loot.CanToolPerformAction` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/loot/CanToolPerformAction.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This LootItemCondition "forge:can_tool_perform_action" can be used to check if a tool can perform a given ToolAction.

## 公开成员（7 个）

```java
public static final LootItemConditionType LOOT_CONDITION_TYPE = new LootItemConditionType(new CanToolPerformA…
```
源码 :28 —（无 javadoc）

```java
public CanToolPerformAction(ToolAction action)
```
源码 :32 —（无 javadoc）

```java
public LootItemConditionType getType()
```
源码 :37 —（无 javadoc）

```java
public Set<LootContextParam<?>> getReferencedContextParams()
```
源码 :42 —（无 javadoc）

```java
public boolean test(LootContext lootContext)
```
源码 :46 —（无 javadoc）

```java
public static LootItemCondition.Builder canToolPerformAction(ToolAction action)
```
源码 :51 —（无 javadoc）

```java
public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<CanToolPerformAction>
```
源码 :55 —（无 javadoc）

