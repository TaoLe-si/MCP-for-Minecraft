# ModelData

> `net.minecraftforge.client.model.data.ModelData` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/data/ModelData.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：A container for data to be passed to BakedModel instances. All objects stored in here MUST BE IMMUTABLE OR THREAD-SAFE. Properties will be accessed from another thread. @see ModelProperty @see BlockEntity#getModelData() @see BakedModel#getQuads(BlockState, Direction, RandomSource, ModelData, RenderType) @see BakedModel#getModelData(BlockAndTintGetter, BlockPos, BlockState, ModelData)

## 公开成员（7 个）

```java
public static final ModelData EMPTY = ModelData.builder().build()
```
源码 :38 —（无 javadoc）

```java
public Set<ModelProperty<?>> getProperties()
```
源码 :47 —（无 javadoc）

```java
public boolean has(ModelProperty<?> property)
```
源码 :52 —（无 javadoc）

```java
public <T> T get(ModelProperty<T> property)
```
源码 :58 —（无 javadoc）

```java
public Builder derive()
```
源码 :63 —（无 javadoc）

```java
public static Builder builder()
```
源码 :68 —（无 javadoc）

```java
public static final class Builder
```
源码 :73 —（无 javadoc）

