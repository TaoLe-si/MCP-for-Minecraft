# IConditionBuilder

> `net.minecraftforge.common.crafting.conditions.IConditionBuilder` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/crafting/conditions/IConditionBuilder.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——配方条件与自定义配方，本仓库只读配方不注册

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（8 个）

```java
default ICondition and(ICondition... values)
```
源码 :13 —（无 javadoc）

```java
default ICondition FALSE()
```
源码 :18 —（无 javadoc）

```java
default ICondition TRUE()
```
源码 :23 —（无 javadoc）

```java
default ICondition not(ICondition value)
```
源码 :28 —（无 javadoc）

```java
default ICondition or(ICondition... values)
```
源码 :33 —（无 javadoc）

```java
default ICondition itemExists(String namespace, String path)
```
源码 :38 —（无 javadoc）

```java
default ICondition modLoaded(String modid)
```
源码 :43 —（无 javadoc）

```java
default ICondition tagEmpty(TagKey<Item> tag)
```
源码 :48 —（无 javadoc）

