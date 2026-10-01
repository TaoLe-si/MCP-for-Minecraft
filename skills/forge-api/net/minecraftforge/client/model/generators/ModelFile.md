# ModelFile

> `net.minecraftforge.client.model.generators.ModelFile` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/generators/ModelFile.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（8 个）

```java
protected ResourceLocation location
```
源码 :15 —（无 javadoc）

```java
protected ModelFile(ResourceLocation location)
```
源码 :17 —（无 javadoc）

```java
protected abstract boolean exists()
```
源码 :21 —（无 javadoc）

```java
public ResourceLocation getLocation()
```
源码 :23 —（无 javadoc）

```java
public void assertExistence()
```
源码 :32 — Assert that this model exists. @throws IllegalStateException if this model does not exist

```java
public ResourceLocation getUncheckedLocation()
```
源码 :36 —（无 javadoc）

```java
public static class UncheckedModelFile extends ModelFile
```
源码 :40 —（无 javadoc）

```java
public static class ExistingModelFile extends ModelFile
```
源码 :55 —（无 javadoc）

