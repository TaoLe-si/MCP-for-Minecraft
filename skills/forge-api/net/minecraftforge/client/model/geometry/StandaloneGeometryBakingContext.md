# StandaloneGeometryBakingContext

> `net.minecraftforge.client.model.geometry.StandaloneGeometryBakingContext` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/geometry/StandaloneGeometryBakingContext.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：A IGeometryBakingContext geometry baking context that is not bound to block/item model loading.

## 公开成员（19 个）

```java
public static final ResourceLocation LOCATION = new ResourceLocation("forge", "standalone")
```
源码 :28 —（无 javadoc）

```java
public static final StandaloneGeometryBakingContext INSTANCE = create(LOCATION)
```
源码 :30 —（无 javadoc）

```java
public static StandaloneGeometryBakingContext create(ResourceLocation modelName)
```
源码 :32 —（无 javadoc）

```java
public static StandaloneGeometryBakingContext create(Map<String, ResourceLocation> textures)
```
源码 :37 —（无 javadoc）

```java
public static StandaloneGeometryBakingContext create(ResourceLocation modelName, Map<String, ResourceLocation> textures)
```
源码 :42 —（无 javadoc）

```java
public String getModelName()
```
源码 :103 —（无 javadoc）

```java
public boolean hasMaterial(String name)
```
源码 :109 —（无 javadoc）

```java
public Material getMaterial(String name)
```
源码 :115 —（无 javadoc）

```java
public boolean isGui3d()
```
源码 :121 —（无 javadoc）

```java
public boolean useBlockLight()
```
源码 :127 —（无 javadoc）

```java
public boolean useAmbientOcclusion()
```
源码 :133 —（无 javadoc）

```java
public ItemTransforms getTransforms()
```
源码 :139 —（无 javadoc）

```java
public Transformation getRootTransform()
```
源码 :145 —（无 javadoc）

```java
public ResourceLocation getRenderTypeHint()
```
源码 :152 —（无 javadoc）

```java
public ResourceLocation getRenderTypeFastHint()
```
源码 :159 —（无 javadoc）

```java
public boolean isComponentVisible(String component, boolean fallback)
```
源码 :165 —（无 javadoc）

```java
public static Builder builder()
```
源码 :170 —（无 javadoc）

```java
public static Builder builder(IGeometryBakingContext parent)
```
源码 :175 —（无 javadoc）

```java
public static final class Builder
```
源码 :180 —（无 javadoc）

