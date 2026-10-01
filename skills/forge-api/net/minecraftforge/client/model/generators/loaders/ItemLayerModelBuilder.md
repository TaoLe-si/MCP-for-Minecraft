# ItemLayerModelBuilder

> `net.minecraftforge.client.model.generators.loaders.ItemLayerModelBuilder` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/generators/loaders/ItemLayerModelBuilder.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（9 个）

```java
public static <T extends ModelBuilder<T>> ItemLayerModelBuilder<T> begin(T parent, ExistingFileHelper existingFileHelper)
```
源码 :29 —（无 javadoc）

```java
protected ItemLayerModelBuilder(T parent, ExistingFileHelper existingFileHelper)
```
源码 :39 —（无 javadoc）

```java
public ItemLayerModelBuilder<T> emissive(int blockLight, int skyLight, int... layers)
```
源码 :55 — Marks a set of layers to be rendered emissively. @param blockLight The block light (0-15) @param skyLight The sky light (0-15) @param layers the layers that will render unlit @return this builder @throws NullPointerException if `layers` is `null` @throws IllegalArgumentException if `layers` is empty…

```java
public ItemLayerModelBuilder<T> color(int color, int... layers)
```
源码 :80 — Marks a set of layers to be rendered with a specific color. @param color The color, in ARGB. @param layers the layers that will render with color @return this builder @throws NullPointerException if `layers` is `null` @throws IllegalArgumentException if `layers` is empty @throws IllegalArgumentExcep…

```java
public ItemLayerModelBuilder<T> renderType(String renderType, int... layers)
```
源码 :108 — Set the render type for a set of layers. @param renderType the render type. Must be registered via net.minecraftforge.client.event.RegisterNamedRenderTypesEvent @param layers the layers that will use this render type @return this builder @throws NullPointerException if `renderType` is `null` @throws…

```java
public ItemLayerModelBuilder<T> renderType(String renderType, String renderTypeFast, int... layers)
```
源码 :119 —（无 javadoc）

```java
public ItemLayerModelBuilder<T> renderType(ResourceLocation renderType, int... layers)
```
源码 :149 — Set the render type for a set of layers. @param renderType the render type. Must be registered via net.minecraftforge.client.event.RegisterNamedRenderTypesEvent @param layers the layers that will use this render type @return this builder @throws NullPointerException if `renderType` is `null` @throws…

```java
public ItemLayerModelBuilder<T> renderType(ResourceLocation renderType, ResourceLocation renderTypeFast, int... layers)
```
源码 :165 —（无 javadoc）

```java
public JsonObject toJson(JsonObject json)
```
源码 :185 —（无 javadoc）

