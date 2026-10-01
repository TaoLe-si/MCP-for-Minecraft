# IGlobalLootModifier

> `net.minecraftforge.common.loot.IGlobalLootModifier` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/loot/IGlobalLootModifier.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Implementation that defines what a global loot modifier must implement in order to be functional. LootModifier Supplies base functionality; most modders should only need to extend that. Requires a Codec to be registered: ForgeRegistries#GLOBAL_LOOT_MODIFIER_SERIALIZERS, and returned in #codec() Individual instances of modifiers must be registered via json, see forge:loot_modifiers/global_loot_modi…

## 公开成员（2 个）

```java
static <U> JsonElement getJson(Dynamic<?> dynamic)
```
源码 :64 —（无 javadoc）

```java
ObjectArrayList<ItemStack> apply(ObjectArrayList<ItemStack> generatedLoot, LootContext context)
```
源码 :79 —（无 javadoc）

