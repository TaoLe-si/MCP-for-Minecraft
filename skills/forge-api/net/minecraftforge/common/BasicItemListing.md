# BasicItemListing

> `net.minecraftforge.common.BasicItemListing` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/BasicItemListing.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：A default, exposed implementation of ITrade. All of the other implementations of ITrade (in VillagerTrades) are not public. This class contains everything needed to make a MerchantOffer, the actual "trade" object shown in trading guis.

## 公开成员（11 个）

```java
protected final ItemStack price
```
源码 :22 —（无 javadoc）

```java
protected final ItemStack price2
```
源码 :23 —（无 javadoc）

```java
protected final ItemStack forSale
```
源码 :24 —（无 javadoc）

```java
protected final int maxTrades
```
源码 :25 —（无 javadoc）

```java
protected final int xp
```
源码 :26 —（无 javadoc）

```java
protected final float priceMult
```
源码 :27 —（无 javadoc）

```java
public BasicItemListing(ItemStack price, ItemStack price2, ItemStack forSale, int maxTrades, int xp, float priceMult)
```
源码 :29 —（无 javadoc）

```java
public BasicItemListing(ItemStack price, ItemStack forSale, int maxTrades, int xp, float priceMult)
```
源码 :39 —（无 javadoc）

```java
public BasicItemListing(int emeralds, ItemStack forSale, int maxTrades, int xp, float mult)
```
源码 :44 —（无 javadoc）

```java
public BasicItemListing(int emeralds, ItemStack forSale, int maxTrades, int xp)
```
源码 :49 —（无 javadoc）

```java
public MerchantOffer getOffer(Entity p_219693_, RandomSource p_219694_)
```
源码 :56 —（无 javadoc）

