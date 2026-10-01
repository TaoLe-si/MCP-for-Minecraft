# LootModifier

> `net.minecraftforge.common.loot.LootModifier` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/loot/LootModifier.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：A base implementation of a Global Loot Modifier for modders to extend. Takes care of ILootCondition matching and comes with the base codec to extend.

## 公开成员（5 个）

```java
protected final LootItemCondition[] conditions
```
源码 :26 —（无 javadoc）

```java
protected static <T extends LootModifier> Products.P1<RecordCodecBuilder.Mu<T>, LootItemCondition[]> codecStart(RecordCodecBuilder.Instance<T> instance)
```
源码 :39 — Simplifies codec creation, especially if no other fields are added: `public static final Codec CODEC = RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, MyLootModifier::new)); ` Otherwise can follow this with #and() to add more fields. Examples: Forge Test Subclasses or BendingTrunkPlac…

```java
protected LootModifier(LootItemCondition[] conditionsIn)
```
源码 :48 — Constructs a LootModifier. @param conditionsIn the ILootConditions that need to be matched before the loot is modified.

```java
public final ObjectArrayList<ItemStack> apply(ObjectArrayList<ItemStack> generatedLoot, LootContext context)
```
源码 :56 —（无 javadoc）

```java
protected abstract ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context)
```
源码 :69 —（无 javadoc）

