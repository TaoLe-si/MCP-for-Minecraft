# ModelProvider

> `net.minecraftforge.client.model.generators.ModelProvider` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/generators/ModelProvider.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（83 个）

```java
public static final String BLOCK_FOLDER = "block"
```
源码 :28 —（无 javadoc）

```java
public static final String ITEM_FOLDER = "item"
```
源码 :29 —（无 javadoc）

```java
protected static final ResourceType TEXTURE = new ResourceType(PackType.CLIENT_RESOURCES, "…
```
源码 :31 —（无 javadoc）

```java
protected static final ResourceType MODEL = new ResourceType(PackType.CLIENT_RESOURCES, "…
```
源码 :32 —（无 javadoc）

```java
protected static final ResourceType MODEL_WITH_EXTENSION = new ResourceType(PackType.CLIENT_RESOURCES, "…
```
源码 :33 —（无 javadoc）

```java
protected final PackOutput output
```
源码 :36 —（无 javadoc）

```java
protected final String modid
```
源码 :37 —（无 javadoc）

```java
protected final String folder
```
源码 :38 —（无 javadoc）

```java
protected final Function<ResourceLocation, T> factory
```
源码 :39 —（无 javadoc）

```java
public final Map<ResourceLocation, T> generatedModels = new HashMap<>()
```
源码 :41 —（无 javadoc）

```java
public final ExistingFileHelper existingFileHelper
```
源码 :43 —（无 javadoc）

```java
protected abstract void registerModels()
```
源码 :45 —（无 javadoc）

```java
public ModelProvider(PackOutput output, String modid, String folder, Function<ResourceLocation, T> factory, ExistingFileHelper existingFileHelper)
```
源码 :47 —（无 javadoc）

```java
public ModelProvider(PackOutput output, String modid, String folder, BiFunction<ResourceLocation, ExistingFileHelper, T> builderFromModId, ExistingFileHelper existingFileHelper)
```
源码 :60 —（无 javadoc）

```java
public T getBuilder(String path)
```
源码 :64 —（无 javadoc）

```java
public ResourceLocation modLoc(String name)
```
源码 :78 —（无 javadoc）

```java
public ResourceLocation mcLoc(String name)
```
源码 :82 —（无 javadoc）

```java
public T withExistingParent(String name, String parent)
```
源码 :86 —（无 javadoc）

```java
public T withExistingParent(String name, ResourceLocation parent)
```
源码 :90 —（无 javadoc）

```java
public T cube(String name, ResourceLocation down, ResourceLocation up, ResourceLocation north, ResourceLocation south, ResourceLocation east, ResourceLocation west)
```
源码 :94 —（无 javadoc）

```java
public T singleTexture(String name, ResourceLocation parent, ResourceLocation texture)
```
源码 :108 —（无 javadoc）

```java
public T singleTexture(String name, ResourceLocation parent, String textureKey, ResourceLocation texture)
```
源码 :116 —（无 javadoc）

```java
public T cubeAll(String name, ResourceLocation texture)
```
源码 :121 —（无 javadoc）

```java
public T cubeTop(String name, ResourceLocation side, ResourceLocation top)
```
源码 :125 —（无 javadoc）

```java
public T cubeBottomTop(String name, ResourceLocation side, ResourceLocation bottom, ResourceLocation top)
```
源码 :138 —（无 javadoc）

```java
public T cubeColumn(String name, ResourceLocation side, ResourceLocation end)
```
源码 :142 —（无 javadoc）

```java
public T cubeColumnHorizontal(String name, ResourceLocation side, ResourceLocation end)
```
源码 :148 —（无 javadoc）

```java
public T orientableVertical(String name, ResourceLocation side, ResourceLocation front)
```
源码 :154 —（无 javadoc）

```java
public T orientableWithBottom(String name, ResourceLocation side, ResourceLocation front, ResourceLocation bottom, ResourceLocation top)
```
源码 :160 —（无 javadoc）

```java
public T orientable(String name, ResourceLocation side, ResourceLocation front, ResourceLocation top)
```
源码 :168 —（无 javadoc）

```java
public T crop(String name, ResourceLocation crop)
```
源码 :175 —（无 javadoc）

```java
public T cross(String name, ResourceLocation cross)
```
源码 :179 —（无 javadoc）

```java
public T stairs(String name, ResourceLocation side, ResourceLocation bottom, ResourceLocation top)
```
源码 :183 —（无 javadoc）

```java
public T stairsOuter(String name, ResourceLocation side, ResourceLocation bottom, ResourceLocation top)
```
源码 :187 —（无 javadoc）

```java
public T stairsInner(String name, ResourceLocation side, ResourceLocation bottom, ResourceLocation top)
```
源码 :191 —（无 javadoc）

```java
public T slab(String name, ResourceLocation side, ResourceLocation bottom, ResourceLocation top)
```
源码 :195 —（无 javadoc）

```java
public T slabTop(String name, ResourceLocation side, ResourceLocation bottom, ResourceLocation top)
```
源码 :199 —（无 javadoc）

```java
public T button(String name, ResourceLocation texture)
```
源码 :203 —（无 javadoc）

```java
public T buttonPressed(String name, ResourceLocation texture)
```
源码 :207 —（无 javadoc）

```java
public T buttonInventory(String name, ResourceLocation texture)
```
源码 :211 —（无 javadoc）

```java
public T pressurePlate(String name, ResourceLocation texture)
```
源码 :215 —（无 javadoc）

```java
public T pressurePlateDown(String name, ResourceLocation texture)
```
源码 :219 —（无 javadoc）

```java
public T sign(String name, ResourceLocation texture)
```
源码 :223 —（无 javadoc）

```java
public T fencePost(String name, ResourceLocation texture)
```
源码 :227 —（无 javadoc）

```java
public T fenceSide(String name, ResourceLocation texture)
```
源码 :231 —（无 javadoc）

```java
public T fenceInventory(String name, ResourceLocation texture)
```
源码 :235 —（无 javadoc）

```java
public T fenceGate(String name, ResourceLocation texture)
```
源码 :239 —（无 javadoc）

```java
public T fenceGateOpen(String name, ResourceLocation texture)
```
源码 :243 —（无 javadoc）

```java
public T fenceGateWall(String name, ResourceLocation texture)
```
源码 :247 —（无 javadoc）

```java
public T fenceGateWallOpen(String name, ResourceLocation texture)
```
源码 :251 —（无 javadoc）

```java
public T wallPost(String name, ResourceLocation wall)
```
源码 :255 —（无 javadoc）

```java
public T wallSide(String name, ResourceLocation wall)
```
源码 :259 —（无 javadoc）

```java
public T wallSideTall(String name, ResourceLocation wall)
```
源码 :263 —（无 javadoc）

```java
public T wallInventory(String name, ResourceLocation wall)
```
源码 :267 —（无 javadoc）

```java
public T panePost(String name, ResourceLocation pane, ResourceLocation edge)
```
源码 :277 —（无 javadoc）

```java
public T paneSide(String name, ResourceLocation pane, ResourceLocation edge)
```
源码 :281 —（无 javadoc）

```java
public T paneSideAlt(String name, ResourceLocation pane, ResourceLocation edge)
```
源码 :285 —（无 javadoc）

```java
public T paneNoSide(String name, ResourceLocation pane)
```
源码 :289 —（无 javadoc）

```java
public T paneNoSideAlt(String name, ResourceLocation pane)
```
源码 :293 —（无 javadoc）

```java
public T doorBottomLeft(String name, ResourceLocation bottom, ResourceLocation top)
```
源码 :303 —（无 javadoc）

```java
public T doorBottomLeftOpen(String name, ResourceLocation bottom, ResourceLocation top)
```
源码 :307 —（无 javadoc）

```java
public T doorBottomRight(String name, ResourceLocation bottom, ResourceLocation top)
```
源码 :311 —（无 javadoc）

```java
public T doorBottomRightOpen(String name, ResourceLocation bottom, ResourceLocation top)
```
源码 :315 —（无 javadoc）

```java
public T doorTopLeft(String name, ResourceLocation bottom, ResourceLocation top)
```
源码 :319 —（无 javadoc）

```java
public T doorTopLeftOpen(String name, ResourceLocation bottom, ResourceLocation top)
```
源码 :323 —（无 javadoc）

```java
public T doorTopRight(String name, ResourceLocation bottom, ResourceLocation top)
```
源码 :327 —（无 javadoc）

```java
public T doorTopRightOpen(String name, ResourceLocation bottom, ResourceLocation top)
```
源码 :331 —（无 javadoc）

```java
public T trapdoorBottom(String name, ResourceLocation texture)
```
源码 :335 —（无 javadoc）

```java
public T trapdoorTop(String name, ResourceLocation texture)
```
源码 :339 —（无 javadoc）

```java
public T trapdoorOpen(String name, ResourceLocation texture)
```
源码 :343 —（无 javadoc）

```java
public T trapdoorOrientableBottom(String name, ResourceLocation texture)
```
源码 :347 —（无 javadoc）

```java
public T trapdoorOrientableTop(String name, ResourceLocation texture)
```
源码 :351 —（无 javadoc）

```java
public T trapdoorOrientableOpen(String name, ResourceLocation texture)
```
源码 :355 —（无 javadoc）

```java
public T torch(String name, ResourceLocation torch)
```
源码 :359 —（无 javadoc）

```java
public T torchWall(String name, ResourceLocation torch)
```
源码 :363 —（无 javadoc）

```java
public T carpet(String name, ResourceLocation wool)
```
源码 :367 —（无 javadoc）

```java
public T leaves(String name, ResourceLocation texture)
```
源码 :371 —（无 javadoc）

```java
public T nested()
```
源码 :379 — a model builder that's not directly saved to disk. Meant for use in custom model loaders.

```java
public ModelFile.ExistingModelFile getExistingFile(ResourceLocation path)
```
源码 :384 —（无 javadoc）

```java
protected void clear()
```
源码 :390 —（无 javadoc）

```java
public CompletableFuture<?> run(CachedOutput cache)
```
源码 :395 —（无 javadoc）

```java
protected CompletableFuture<?> generateAll(CachedOutput cache)
```
源码 :401 —（无 javadoc）

```java
protected Path getPath(T model)
```
源码 :413 —（无 javadoc）

