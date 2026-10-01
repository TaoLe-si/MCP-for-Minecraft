# CompositeModelBuilder

> `net.minecraftforge.client.model.generators.loaders.CompositeModelBuilder` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/generators/loaders/CompositeModelBuilder.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（5 个）

```java
public static <T extends ModelBuilder<T>> CompositeModelBuilder<T> begin(T parent, ExistingFileHelper existingFileHelper)
```
源码 :20 —（无 javadoc）

```java
protected CompositeModelBuilder(T parent, ExistingFileHelper existingFileHelper)
```
源码 :28 —（无 javadoc）

```java
public CompositeModelBuilder<T> child(String name, T modelBuilder)
```
源码 :33 —（无 javadoc）

```java
public CompositeModelBuilder<T> itemRenderOrder(String... names)
```
源码 :42 —（无 javadoc）

```java
public JsonObject toJson(JsonObject json)
```
源码 :55 —（无 javadoc）

