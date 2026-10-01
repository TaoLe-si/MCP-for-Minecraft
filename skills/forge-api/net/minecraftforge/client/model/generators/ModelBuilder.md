# ModelBuilder

> `net.minecraftforge.client.model.generators.ModelBuilder` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/generators/ModelBuilder.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：General purpose model builder, contains all the commonalities between item and block models. @see ModelProvider @see BlockModelBuilder @see ItemModelBuilder @param Self type, for simpler chaining of methods.

## 公开成员（32 个）

```java
protected ModelFile parent
```
源码 :57 —（无 javadoc）

```java
protected final Map<String, String> textures = new LinkedHashMap<>()
```
源码 :58 —（无 javadoc）

```java
protected final TransformsBuilder transforms = new TransformsBuilder()
```
源码 :59 —（无 javadoc）

```java
protected final ExistingFileHelper existingFileHelper
```
源码 :60 —（无 javadoc）

```java
protected String renderType = null
```
源码 :62 —（无 javadoc）

```java
protected String renderTypeFast = null
```
源码 :63 —（无 javadoc）

```java
protected boolean ambientOcclusion = true
```
源码 :64 —（无 javadoc）

```java
protected GuiLight guiLight = null
```
源码 :65 —（无 javadoc）

```java
protected final List<ElementBuilder> elements = new ArrayList<>()
```
源码 :67 —（无 javadoc）

```java
protected CustomLoaderBuilder<T> customLoader = null
```
源码 :69 —（无 javadoc）

```java
protected ModelBuilder(ResourceLocation outputLocation, ExistingFileHelper existingFileHelper)
```
源码 :73 —（无 javadoc）

```java
protected boolean exists()
```
源码 :83 —（无 javadoc）

```java
public T parent(ModelFile parent)
```
源码 :95 — Set the parent model for the current model. @param parent the parent model @return this builder @throws NullPointerException if `parent` is `null` @throws IllegalStateException if `parent` does not ModelFile#assertExistence()

```java
public T texture(String key, String texture)
```
源码 :114 — Set the texture for a given dictionary key. @param key the texture key @param texture the texture, can be another key e.g. `"#all"` @return this builder @throws NullPointerException if `key` is `null` @throws NullPointerException if `texture` is `null` @throws IllegalStateException if `texture` is n…

```java
public T texture(String key, ResourceLocation texture)
```
源码 :143 — Set the texture for a given dictionary key. @param key the texture key @param texture the texture @return this builder @throws NullPointerException if `key` is `null` @throws NullPointerException if `texture` is `null` @throws IllegalStateException if `texture` is not a key (does not start with `'#'…

```java
public T renderType(String renderType)
```
源码 :165 — Set the render type for this model. Any render types to be used must be registered via net.minecraftforge.client.event.RegisterNamedRenderTypesEvent. Consider using #renderType(String, String) if you need to set a render type for net.minecraft.client.GraphicsStatus#FAST fast graphics. @param renderT…

```java
public T renderType(String renderType, String renderTypeFast)
```
源码 :180 — Set the render types for this model. Any render types to be used must be registered via net.minecraftforge.client.event.RegisterNamedRenderTypesEvent. @param renderType the render type for net.minecraft.client.GraphicsStatus#FANCY fancy graphics @param renderTypeFast the render type for net.minecraf…

```java
public T renderType(ResourceLocation renderType)
```
源码 :199 — Set the render type for this model. Any render types to be used must be registered via net.minecraftforge.client.event.RegisterNamedRenderTypesEvent. Consider using #renderType(ResourceLocation, ResourceLocation) if you need to set a render type for net.minecraft.client.GraphicsStatus#FAST fast grap…

```java
public T renderType(ResourceLocation renderType, ResourceLocation renderTypeFast)
```
源码 :216 — Set the render types for this model. Any render types to be used must be registered via net.minecraftforge.client.event.RegisterNamedRenderTypesEvent. @param renderType the render type for net.minecraft.client.GraphicsStatus#FANCY fancy graphics @param renderTypeFast the render type for net.minecraf…

```java
public TransformsBuilder transforms()
```
源码 :224 —（无 javadoc）

```java
public T ao(boolean ao)
```
源码 :228 —（无 javadoc）

```java
public T guiLight(GuiLight light)
```
源码 :233 —（无 javadoc）

```java
public ElementBuilder element()
```
源码 :238 —（无 javadoc）

```java
public ElementBuilder element(int index)
```
源码 :252 — Get an existing element builder @param index the index of the existing element builder @return the element builder @throws IndexOutOfBoundsException if {@code} index is out of bounds

```java
public int getElementCount()
```
源码 :261 — the number of elements in this model builder

```java
public <L extends CustomLoaderBuilder<T>> L customLoader(BiFunction<T, ExistingFileHelper, L> customLoaderFactory)
```
源码 :271 — Use a custom loader instead of the vanilla elements. @param customLoaderFactory function that returns the custom loader to set, given this and the #existingFileHelper @return the custom loader builder

```java
public RootTransformsBuilder rootTransforms()
```
源码 :280 —（无 javadoc）

```java
public JsonObject toJson()
```
源码 :286 —（无 javadoc）

```java
public class ElementBuilder
```
源码 :431 —（无 javadoc）

```java
public enum FaceRotation
```
源码 :795 — @param angle the rotation angle @return this builder @throws IllegalArgumentException if `angle` is invalid (not one of 0, +/-22.5, +/-45)

```java
public class TransformsBuilder
```
源码 :809 —（无 javadoc）

```java
public class RootTransformsBuilder
```
源码 :879 — Begin building a new transform for the given perspective. @param type the perspective to create or return the builder for @return the builder for the given perspective @throws NullPointerException if `type` is `null`

