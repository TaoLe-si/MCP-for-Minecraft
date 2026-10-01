# CustomLoaderBuilder

> `net.minecraftforge.client.model.generators.CustomLoaderBuilder` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/generators/CustomLoaderBuilder.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（8 个）

```java
protected final ResourceLocation loaderId
```
源码 :18 —（无 javadoc）

```java
protected final T parent
```
源码 :19 —（无 javadoc）

```java
protected final ExistingFileHelper existingFileHelper
```
源码 :20 —（无 javadoc）

```java
protected final Map<String, Boolean> visibility = new LinkedHashMap<>()
```
源码 :21 —（无 javadoc）

```java
protected CustomLoaderBuilder(ResourceLocation loaderId, T parent, ExistingFileHelper existingFileHelper)
```
源码 :23 —（无 javadoc）

```java
public CustomLoaderBuilder<T> visibility(String partName, boolean show)
```
源码 :30 —（无 javadoc）

```java
public T end()
```
源码 :37 —（无 javadoc）

```java
public JsonObject toJson(JsonObject json)
```
源码 :42 —（无 javadoc）

