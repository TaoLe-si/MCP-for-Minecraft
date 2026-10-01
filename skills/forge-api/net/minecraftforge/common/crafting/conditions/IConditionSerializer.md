# IConditionSerializer

> `net.minecraftforge.common.crafting.conditions.IConditionSerializer` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/crafting/conditions/IConditionSerializer.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——配方条件与自定义配方，本仓库只读配方不注册

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（4 个）

```java
void write(JsonObject json, T value)
```
源码 :14 —（无 javadoc）

```java
T read(JsonObject json)
```
源码 :16 —（无 javadoc）

```java
ResourceLocation getID()
```
源码 :18 —（无 javadoc）

```java
default JsonObject getJson(T value)
```
源码 :20 —（无 javadoc）

