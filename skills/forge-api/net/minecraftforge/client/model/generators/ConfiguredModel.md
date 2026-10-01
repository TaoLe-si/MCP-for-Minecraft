# ConfiguredModel

> `net.minecraftforge.client.model.generators.ConfiguredModel` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/generators/ConfiguredModel.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：Represents a model with blockstate configurations, e.g. rotation, uvlock, and random weight. Can be manually constructed, created by static factory such as #allYRotations(ModelFile,, or created by builder via #builder().

## 公开成员（15 个）

```java
public static final int DEFAULT_WEIGHT = 1
```
源码 :38 — The default random weight of configured models, used by convenience overloads.

```java
public final ModelFile model
```
源码 :40 —（无 javadoc）

```java
public final int rotationX
```
源码 :41 —（无 javadoc）

```java
public final int rotationY
```
源码 :42 —（无 javadoc）

```java
public final boolean uvLock
```
源码 :43 —（无 javadoc）

```java
public final int weight
```
源码 :44 —（无 javadoc）

```java
public static ConfiguredModel[] allYRotations(ModelFile model, int x, boolean uvlock)
```
源码 :50 —（无 javadoc）

```java
public static ConfiguredModel[] allYRotations(ModelFile model, int x, boolean uvlock, int weight)
```
源码 :54 —（无 javadoc）

```java
public static ConfiguredModel[] allRotations(ModelFile model, boolean uvlock)
```
源码 :60 —（无 javadoc）

```java
public static ConfiguredModel[] allRotations(ModelFile model, boolean uvlock, int weight)
```
源码 :64 —（无 javadoc）

```java
public ConfiguredModel(ModelFile model, int rotationX, int rotationY, boolean uvLock, int weight)
```
源码 :85 — Construct a new ConfiguredModel. @param model the underlying model @param rotationX x-rotation to apply to the model @param rotationY y-rotation to apply to the model @param uvLock if uvlock should be enabled @param weight the random weight of the model @throws NullPointerException if `model` is `nu…

```java
public ConfiguredModel(ModelFile model, int rotationX, int rotationY, boolean uvLock)
```
源码 :109 — Construct a new ConfiguredModel with the #DEFAULT_WEIGHT. @param model the underlying model @param rotationX x-rotation to apply to the model @param rotationY y-rotation to apply to the model @param uvLock if uvlock should be enabled @throws NullPointerException if `model` is `null` @throws IllegalA…

```java
public ConfiguredModel(ModelFile model)
```
源码 :119 — Construct a new ConfiguredModel with the default rotation (0, 0), uvlock (false), and #DEFAULT_WEIGHT. @throws NullPointerException if `model` is `null`

```java
public static Builder<?> builder()
```
源码 :151 — Create a new unowned Builder. @return the builder @see Builder

```java
public static class Builder<T>
```
源码 :178 — A builder for ConfiguredModels, which can contain a callback for processing the finished result. If no callback is available (e.g. in the case of ConfiguredModel#builder()), some methods will not be available. Multiple models can be configured at once through the use of #nextModel(). @param the type…

