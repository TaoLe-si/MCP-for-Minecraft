# IForgeMobEffect

> `net.minecraftforge.common.extensions.IForgeMobEffect` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeMobEffect.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（3 个）

```java
private MobEffect self()
```
源码 :18 —（无 javadoc）

```java
default List<ItemStack> getCurativeItems()
```
源码 :28 — Get a fresh list of items that can cure this Potion. All new PotionEffects created from this Potion will call this to initialize the default curative items @see MobEffectInstance#getCurativeItems() @return A list of items that can cure this Potion

```java
default int getSortOrder(MobEffectInstance effectInstance)
```
源码 :40 — Used for determining `PotionEffect` sort order in GUIs. Defaults to the `PotionEffect`'s liquid color. @param effectInstance the `PotionEffect` instance containing the potion @return a value used to sort `PotionEffect`s in GUIs

