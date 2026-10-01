# ItemModelBuilder

> `net.minecraftforge.client.model.generators.ItemModelBuilder` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/generators/ItemModelBuilder.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：Builder for item models, adds the ability to build overrides via #override().

## 公开成员（6 个）

```java
protected List<OverrideBuilder> overrides = new ArrayList<>()
```
源码 :26 —（无 javadoc）

```java
public ItemModelBuilder(ResourceLocation outputLocation, ExistingFileHelper existingFileHelper)
```
源码 :28 —（无 javadoc）

```java
public OverrideBuilder override()
```
源码 :32 —（无 javadoc）

```java
public OverrideBuilder override(int index)
```
源码 :45 — Get an existing override builder @param index the index of the existing override builder @return the override builder @throws IndexOutOfBoundsException if {@code} index is out of bounds

```java
public JsonObject toJson()
```
源码 :51 —（无 javadoc）

```java
public class OverrideBuilder
```
源码 :61 —（无 javadoc）

