# ObjModelBuilder

> `net.minecraftforge.client.model.generators.loaders.ObjModelBuilder` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/generators/loaders/ObjModelBuilder.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（9 个）

```java
public static <T extends ModelBuilder<T>> ObjModelBuilder<T> begin(T parent, ExistingFileHelper existingFileHelper)
```
源码 :18 —（无 javadoc）

```java
protected ObjModelBuilder(T parent, ExistingFileHelper existingFileHelper)
```
源码 :30 —（无 javadoc）

```java
public ObjModelBuilder<T> modelLocation(ResourceLocation modelLocation)
```
源码 :35 —（无 javadoc）

```java
public ObjModelBuilder<T> automaticCulling(boolean automaticCulling)
```
源码 :44 —（无 javadoc）

```java
public ObjModelBuilder<T> shadeQuads(boolean shadeQuads)
```
源码 :50 —（无 javadoc）

```java
public ObjModelBuilder<T> flipV(boolean flipV)
```
源码 :56 —（无 javadoc）

```java
public ObjModelBuilder<T> emissiveAmbient(boolean ambientEmissive)
```
源码 :62 —（无 javadoc）

```java
public ObjModelBuilder<T> overrideMaterialLibrary(ResourceLocation mtlOverride)
```
源码 :68 —（无 javadoc）

```java
public JsonObject toJson(JsonObject json)
```
源码 :78 —（无 javadoc）

