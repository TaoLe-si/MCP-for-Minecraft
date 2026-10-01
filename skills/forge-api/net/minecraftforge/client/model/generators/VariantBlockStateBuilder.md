# VariantBlockStateBuilder

> `net.minecraftforge.client.model.generators.VariantBlockStateBuilder` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/generators/VariantBlockStateBuilder.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：Builder for variant-type blockstates, i.e. non-multipart blockstates. Should not be manually instantiated, instead use BlockStateProvider#getVariantBuilder(Block). Variants can either be set via #setModels(PartialBlockstate, or #addModels(PartialBlockstate,, where model(s) can be assigned directly to PartialBlockstate, or builder style via #partialState() and its subsequent methods. This class als…

## 公开成员（9 个）

```java
public Map<PartialBlockstate, ConfiguredModelList> getModels()
```
源码 :65 —（无 javadoc）

```java
public Block getOwner()
```
源码 :69 —（无 javadoc）

```java
public JsonObject toJson()
```
源码 :74 —（无 javadoc）

```java
public VariantBlockStateBuilder addModels(PartialBlockstate state, ConfiguredModel... models)
```
源码 :101 — Assign some models to a given PartialBlockstate. @param state The PartialBlockstate for which to add the models @param models A set of models to add to this state @return this builder @throws NullPointerException if `state` is `null` @throws IllegalArgumentException if `models` is empty @throws Ille…

```java
public VariantBlockStateBuilder setModels(PartialBlockstate state, ConfiguredModel... model)
```
源码 :131 — Assign some models to a given PartialBlockstate, throwing an exception if the state has already been configured. Otherwise, simply calls #addModels(PartialBlockstate,. @param state The PartialBlockstate for which to set the models @param model A set of models to assign to this state @return this bui…

```java
public PartialBlockstate partialState()
```
源码 :141 —（无 javadoc）

```java
public VariantBlockStateBuilder forAllStates(Function<BlockState, ConfiguredModel[]> mapper)
```
源码 :145 —（无 javadoc）

```java
public VariantBlockStateBuilder forAllStatesExcept(Function<BlockState, ConfiguredModel[]> mapper, Property<?>... ignored)
```
源码 :149 —（无 javadoc）

```java
public static class PartialBlockstate implements Predicate<BlockState>
```
源码 :164 —（无 javadoc）

