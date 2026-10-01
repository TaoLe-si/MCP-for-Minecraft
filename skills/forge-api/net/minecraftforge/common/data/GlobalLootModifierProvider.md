# GlobalLootModifierProvider

> `net.minecraftforge.common.data.GlobalLootModifierProvider` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/data/GlobalLootModifierProvider.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Provider for forge's GlobalLootModifier system. See LootModifier This provider only requires implementing #start() and calling #add from it.

## 公开成员（6 个）

```java
public GlobalLootModifierProvider(PackOutput output, String modid)
```
源码 :43 —（无 javadoc）

```java
protected void replacing()
```
源码 :52 — Sets the "replace" key in global_loot_modifiers to true.

```java
protected abstract void start()
```
源码 :60 — Call #add here, which will pass in the necessary information to write the jsons.

```java
public CompletableFuture<?> run(CachedOutput cache)
```
源码 :63 —（无 javadoc）

```java
public <T extends IGlobalLootModifier> void add(String modifier, T instance)
```
源码 :95 — Passes in the data needed to create the file without any extra objects. @param modifier The name of the modifier, which will be the file name. @param instance The instance to serialize

```java
public String getName()
```
源码 :102 —（无 javadoc）

