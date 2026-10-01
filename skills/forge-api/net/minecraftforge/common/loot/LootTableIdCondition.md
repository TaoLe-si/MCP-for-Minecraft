# LootTableIdCondition

> `net.minecraftforge.common.loot.LootTableIdCondition` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/loot/LootTableIdCondition.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（7 个）

```java
public static final LootItemConditionType LOOT_TABLE_ID = new LootItemConditionType(new LootTableIdCond…
```
源码 :21 —（无 javadoc）

```java
public static final ResourceLocation UNKNOWN_LOOT_TABLE = new ResourceLocation("forge", "unknown_loot_t…
```
源码 :22 —（无 javadoc）

```java
public LootItemConditionType getType()
```
源码 :32 —（无 javadoc）

```java
public boolean test(LootContext lootContext)
```
源码 :38 —（无 javadoc）

```java
public static Builder builder(final ResourceLocation targetLootTableId)
```
源码 :43 —（无 javadoc）

```java
public static class Builder implements LootItemCondition.Builder
```
源码 :48 —（无 javadoc）

```java
public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<LootTableIdCondition>
```
源码 :65 —（无 javadoc）

