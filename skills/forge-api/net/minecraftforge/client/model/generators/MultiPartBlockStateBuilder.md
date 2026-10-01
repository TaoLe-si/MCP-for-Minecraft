# MultiPartBlockStateBuilder

> `net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/generators/MultiPartBlockStateBuilder.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（4 个）

```java
public MultiPartBlockStateBuilder(Block owner)
```
源码 :30 —（无 javadoc）

```java
public ConfiguredModel.Builder<PartBuilder> part()
```
源码 :42 — Creates a builder for models to assign to a PartBuilder, which when completed via ConfiguredModel.Builder#addModel() will assign the resultant set of models to the part and return it for further processing. @return the model builder @see ConfiguredModel.Builder

```java
public JsonObject toJson()
```
源码 :52 —（无 javadoc）

```java
public class PartBuilder
```
源码 :62 —（无 javadoc）

