# ObjModel

> `net.minecraftforge.client.model.obj.ObjModel` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/obj/ObjModel.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：A model loaded from an OBJ file. Supports positions, texture coordinates, normals and colors. The ObjMaterialLibrary has support for numerous features, including support for ResourceLocation textures (non-standard).

## 公开成员（14 个）

```java
public final boolean automaticCulling
```
源码 :76 —（无 javadoc）

```java
public final boolean shadeQuads
```
源码 :77 —（无 javadoc）

```java
public final boolean flipV
```
源码 :78 —（无 javadoc）

```java
public final boolean emissiveAmbient
```
源码 :79 —（无 javadoc）

```java
public final String mtlOverride
```
源码 :81 —（无 javadoc）

```java
public final ResourceLocation modelLocation
```
源码 :83 —（无 javadoc）

```java
public static ObjModel parse(ObjTokenizer tokenizer, ModelSettings settings) throws IOException
```
源码 :95 —（无 javadoc）

```java
protected void addQuads(IGeometryBakingContext owner, IModelBuilder<?> modelBuilder, ModelBaker baker, Function<Material, TextureAtlasSprite> spriteGetter, ModelState modelTransform, ResourceLocation modelLocation)
```
源码 :337 —（无 javadoc）

```java
public Set<String> getRootComponentNames()
```
源码 :343 —（无 javadoc）

```java
public Set<String> getConfigurableComponentNames()
```
源码 :349 —（无 javadoc）

```java
public CompositeRenderable bakeRenderable(IGeometryBakingContext configuration)
```
源码 :497 —（无 javadoc）

```java
public class ModelObject
```
源码 :511 —（无 javadoc）

```java
public class ModelGroup extends ModelObject
```
源码 :558 —（无 javadoc）

```java
public record ModelSettings(@NotNull ResourceLocation modelLocation, boolean automaticCulling, boolean shadeQuads, boolean flipV, boolean emissiveAmbient, @Nullable String mtlOverride) { } }
```
源码 :665 —（无 javadoc）

