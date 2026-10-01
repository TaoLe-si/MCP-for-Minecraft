# PlantType

> `net.minecraftforge.common.PlantType` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/PlantType.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（9 个）

```java
public static final PlantType PLAINS = get("plains")
```
源码 :23 —（无 javadoc）

```java
public static final PlantType DESERT = get("desert")
```
源码 :24 —（无 javadoc）

```java
public static final PlantType BEACH = get("beach")
```
源码 :25 —（无 javadoc）

```java
public static final PlantType CAVE = get("cave")
```
源码 :26 —（无 javadoc）

```java
public static final PlantType WATER = get("water")
```
源码 :27 —（无 javadoc）

```java
public static final PlantType NETHER = get("nether")
```
源码 :28 —（无 javadoc）

```java
public static final PlantType CROP = get("crop")
```
源码 :29 —（无 javadoc）

```java
public static PlantType get(String name)
```
源码 :44 — Getting a custom PlantType, or an existing one if it has the same name as that one. Your plant should implement IPlantable and return this custom type in IPlantable#getPlantType(BlockGetter,. If your new plant grows on blocks like any one of them above, never create a new PlantType. This Type is onl…

```java
public String getName()
```
源码 :61 —（无 javadoc）

