# BlockStateProvider

> `net.minecraftforge.client.model.generators.BlockStateProvider` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/generators/BlockStateProvider.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：Data provider for blockstate files. Extends BlockModelProvider so that blockstates and their referenced models can be provided in tandem.

## 公开成员（152 个）

```java
protected final Map<Block, IGeneratedBlockState> registeredBlocks = new LinkedHashMap<>()
```
源码 :73 —（无 javadoc）

```java
public BlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper)
```
源码 :80 —（无 javadoc）

```java
public CompletableFuture<?> run(CachedOutput cache)
```
源码 :96 —（无 javadoc）

```java
protected abstract void registerStatesAndModels()
```
源码 :111 —（无 javadoc）

```java
public VariantBlockStateBuilder getVariantBuilder(Block b)
```
源码 :113 —（无 javadoc）

```java
public MultiPartBlockStateBuilder getMultipartBuilder(Block b)
```
源码 :125 —（无 javadoc）

```java
public BlockModelProvider models()
```
源码 :137 —（无 javadoc）

```java
public ItemModelProvider itemModels()
```
源码 :141 —（无 javadoc）

```java
public ResourceLocation modLoc(String name)
```
源码 :145 —（无 javadoc）

```java
public ResourceLocation mcLoc(String name)
```
源码 :149 —（无 javadoc）

```java
public ResourceLocation blockTexture(Block block)
```
源码 :161 —（无 javadoc）

```java
public ModelFile cubeAll(Block block)
```
源码 :170 —（无 javadoc）

```java
public void simpleBlock(Block block)
```
源码 :174 —（无 javadoc）

```java
public void simpleBlock(Block block, Function<ModelFile, ConfiguredModel[]> expander)
```
源码 :178 —（无 javadoc）

```java
public void simpleBlock(Block block, ModelFile model)
```
源码 :182 —（无 javadoc）

```java
public void simpleBlockItem(Block block, ModelFile model)
```
源码 :186 —（无 javadoc）

```java
public void simpleBlockWithItem(Block block, ModelFile model)
```
源码 :190 —（无 javadoc）

```java
public void simpleBlock(Block block, ConfiguredModel... models)
```
源码 :195 —（无 javadoc）

```java
public void axisBlock(RotatedPillarBlock block)
```
源码 :200 —（无 javadoc）

```java
public void logBlock(RotatedPillarBlock block)
```
源码 :204 —（无 javadoc）

```java
public void axisBlock(RotatedPillarBlock block, ResourceLocation baseName)
```
源码 :208 —（无 javadoc）

```java
public void axisBlock(RotatedPillarBlock block, ResourceLocation side, ResourceLocation end)
```
源码 :212 —（无 javadoc）

```java
public void axisBlockWithRenderType(RotatedPillarBlock block, String renderType)
```
源码 :218 —（无 javadoc）

```java
public void logBlockWithRenderType(RotatedPillarBlock block, String renderType)
```
源码 :222 —（无 javadoc）

```java
public void axisBlockWithRenderType(RotatedPillarBlock block, ResourceLocation baseName, String renderType)
```
源码 :226 —（无 javadoc）

```java
public void axisBlockWithRenderType(RotatedPillarBlock block, ResourceLocation side, ResourceLocation end, String renderType)
```
源码 :230 —（无 javadoc）

```java
public void axisBlockWithRenderType(RotatedPillarBlock block, ResourceLocation renderType)
```
源码 :236 —（无 javadoc）

```java
public void logBlockWithRenderType(RotatedPillarBlock block, ResourceLocation renderType)
```
源码 :240 —（无 javadoc）

```java
public void axisBlockWithRenderType(RotatedPillarBlock block, ResourceLocation baseName, ResourceLocation renderType)
```
源码 :244 —（无 javadoc）

```java
public void axisBlockWithRenderType(RotatedPillarBlock block, ResourceLocation side, ResourceLocation end, ResourceLocation renderType)
```
源码 :248 —（无 javadoc）

```java
public void axisBlockWithRenderTypeAndFast(RotatedPillarBlock block, String renderType, String renderTypeFast)
```
源码 :254 —（无 javadoc）

```java
public void logBlockWithRenderTypeAndFast(RotatedPillarBlock block, String renderType, String renderTypeFast)
```
源码 :258 —（无 javadoc）

```java
public void axisBlockWithRenderTypeAndFast(RotatedPillarBlock block, ResourceLocation baseName, String renderType, String renderTypeFast)
```
源码 :262 —（无 javadoc）

```java
public void axisBlockWithRenderTypeAndFast(RotatedPillarBlock block, ResourceLocation side, ResourceLocation end, String renderType, String renderTypeFast)
```
源码 :266 —（无 javadoc）

```java
public void axisBlockWithRenderTypeAndFast(RotatedPillarBlock block, ResourceLocation renderType, ResourceLocation renderTypeFast)
```
源码 :272 —（无 javadoc）

```java
public void logBlockWithRenderType(RotatedPillarBlock block, ResourceLocation renderType, ResourceLocation renderTypeFast)
```
源码 :276 —（无 javadoc）

```java
public void axisBlockWithRenderTypeAndFast(RotatedPillarBlock block, ResourceLocation baseName, ResourceLocation renderType, ResourceLocation renderTypeFast)
```
源码 :280 —（无 javadoc）

```java
public void axisBlockWithRenderTypeAndFast(RotatedPillarBlock block, ResourceLocation side, ResourceLocation end, ResourceLocation renderType, ResourceLocation renderTypeFast)
```
源码 :284 —（无 javadoc）

```java
public void axisBlock(RotatedPillarBlock block, ModelFile vertical, ModelFile horizontal)
```
源码 :290 —（无 javadoc）

```java
public void horizontalBlock(Block block, ResourceLocation side, ResourceLocation front, ResourceLocation top)
```
源码 :302 —（无 javadoc）

```java
public void horizontalBlock(Block block, ModelFile model)
```
源码 :306 —（无 javadoc）

```java
public void horizontalBlock(Block block, ModelFile model, int angleOffset)
```
源码 :310 —（无 javadoc）

```java
public void horizontalBlock(Block block, Function<BlockState, ModelFile> modelFunc)
```
源码 :314 —（无 javadoc）

```java
public void horizontalBlock(Block block, Function<BlockState, ModelFile> modelFunc, int angleOffset)
```
源码 :318 —（无 javadoc）

```java
public void horizontalFaceBlock(Block block, ModelFile model)
```
源码 :327 —（无 javadoc）

```java
public void horizontalFaceBlock(Block block, ModelFile model, int angleOffset)
```
源码 :331 —（无 javadoc）

```java
public void horizontalFaceBlock(Block block, Function<BlockState, ModelFile> modelFunc)
```
源码 :335 —（无 javadoc）

```java
public void horizontalFaceBlock(Block block, Function<BlockState, ModelFile> modelFunc, int angleOffset)
```
源码 :339 —（无 javadoc）

```java
public void directionalBlock(Block block, ModelFile model)
```
源码 :349 —（无 javadoc）

```java
public void directionalBlock(Block block, ModelFile model, int angleOffset)
```
源码 :353 —（无 javadoc）

```java
public void directionalBlock(Block block, Function<BlockState, ModelFile> modelFunc)
```
源码 :357 —（无 javadoc）

```java
public void directionalBlock(Block block, Function<BlockState, ModelFile> modelFunc, int angleOffset)
```
源码 :361 —（无 javadoc）

```java
public void stairsBlock(StairBlock block, ResourceLocation texture)
```
源码 :373 —（无 javadoc）

```java
public void stairsBlock(StairBlock block, String name, ResourceLocation texture)
```
源码 :377 —（无 javadoc）

```java
public void stairsBlock(StairBlock block, ResourceLocation side, ResourceLocation bottom, ResourceLocation top)
```
源码 :381 —（无 javadoc）

```java
public void stairsBlock(StairBlock block, String name, ResourceLocation side, ResourceLocation bottom, ResourceLocation top)
```
源码 :385 —（无 javadoc）

```java
public void stairsBlockWithRenderType(StairBlock block, ResourceLocation texture, String renderType)
```
源码 :389 —（无 javadoc）

```java
public void stairsBlockWithRenderType(StairBlock block, String name, ResourceLocation texture, String renderType)
```
源码 :393 —（无 javadoc）

```java
public void stairsBlockWithRenderType(StairBlock block, ResourceLocation side, ResourceLocation bottom, ResourceLocation top, String renderType)
```
源码 :397 —（无 javadoc）

```java
public void stairsBlockWithRenderType(StairBlock block, String name, ResourceLocation side, ResourceLocation bottom, ResourceLocation top, String renderType)
```
源码 :401 —（无 javadoc）

```java
public void stairsBlockWithRenderType(StairBlock block, ResourceLocation texture, ResourceLocation renderType)
```
源码 :405 —（无 javadoc）

```java
public void stairsBlockWithRenderType(StairBlock block, String name, ResourceLocation texture, ResourceLocation renderType)
```
源码 :409 —（无 javadoc）

```java
public void stairsBlockWithRenderType(StairBlock block, ResourceLocation side, ResourceLocation bottom, ResourceLocation top, ResourceLocation renderType)
```
源码 :413 —（无 javadoc）

```java
public void stairsBlockWithRenderType(StairBlock block, String name, ResourceLocation side, ResourceLocation bottom, ResourceLocation top, ResourceLocation renderType)
```
源码 :417 —（无 javadoc）

```java
public void stairsBlockWithRenderTypeAndFast(StairBlock block, ResourceLocation texture, String renderType, String renderTypeFast)
```
源码 :421 —（无 javadoc）

```java
public void stairsBlockWithRenderTypeAndFast(StairBlock block, String name, ResourceLocation texture, String renderType, String renderTypeFast)
```
源码 :425 —（无 javadoc）

```java
public void stairsBlockWithRenderTypeAndFast(StairBlock block, ResourceLocation side, ResourceLocation bottom, ResourceLocation top, String renderType, String renderTypeFast)
```
源码 :429 —（无 javadoc）

```java
public void stairsBlockWithRenderTypeAndFast(StairBlock block, String name, ResourceLocation side, ResourceLocation bottom, ResourceLocation top, String renderType, String renderTypeFast)
```
源码 :433 —（无 javadoc）

```java
public void stairsBlockWithRenderTypeAndFast(StairBlock block, ResourceLocation texture, ResourceLocation renderType, ResourceLocation renderTypeFast)
```
源码 :437 —（无 javadoc）

```java
public void stairsBlockWithRenderTypeAndFast(StairBlock block, String name, ResourceLocation texture, ResourceLocation renderType, ResourceLocation renderTypeFast)
```
源码 :441 —（无 javadoc）

```java
public void stairsBlockWithRenderTypeAndFast(StairBlock block, ResourceLocation side, ResourceLocation bottom, ResourceLocation top, ResourceLocation renderType, ResourceLocation renderTypeFast)
```
源码 :445 —（无 javadoc）

```java
public void stairsBlockWithRenderTypeAndFast(StairBlock block, String name, ResourceLocation side, ResourceLocation bottom, ResourceLocation top, ResourceLocation renderType, ResourceLocation renderTypeFast)
```
源码 :449 —（无 javadoc）

```java
public void stairsBlock(StairBlock block, ModelFile stairs, ModelFile stairsInner, ModelFile stairsOuter)
```
源码 :474 —（无 javadoc）

```java
public void slabBlock(SlabBlock block, ResourceLocation doubleslab, ResourceLocation texture)
```
源码 :498 —（无 javadoc）

```java
public void slabBlock(SlabBlock block, ResourceLocation doubleslab, ResourceLocation side, ResourceLocation bottom, ResourceLocation top)
```
源码 :502 —（无 javadoc）

```java
public void slabBlock(SlabBlock block, ModelFile bottom, ModelFile top, ModelFile doubleslab)
```
源码 :506 —（无 javadoc）

```java
public void buttonBlock(ButtonBlock block, ResourceLocation texture)
```
源码 :513 —（无 javadoc）

```java
public void buttonBlock(ButtonBlock block, ModelFile button, ModelFile buttonPressed)
```
源码 :519 —（无 javadoc）

```java
public void pressurePlateBlock(PressurePlateBlock block, ResourceLocation texture)
```
源码 :534 —（无 javadoc）

```java
public void pressurePlateBlock(PressurePlateBlock block, ModelFile pressurePlate, ModelFile pressurePlateDown)
```
源码 :540 —（无 javadoc）

```java
public void signBlock(StandingSignBlock signBlock, WallSignBlock wallSignBlock, ResourceLocation texture)
```
源码 :546 —（无 javadoc）

```java
public void signBlock(StandingSignBlock signBlock, WallSignBlock wallSignBlock, ModelFile sign)
```
源码 :551 —（无 javadoc）

```java
public void fourWayBlock(CrossCollisionBlock block, ModelFile post, ModelFile side)
```
源码 :556 —（无 javadoc）

```java
public void fourWayMultipart(MultiPartBlockStateBuilder builder, ModelFile side)
```
源码 :562 —（无 javadoc）

```java
public void fenceBlock(FenceBlock block, ResourceLocation texture)
```
源码 :572 —（无 javadoc）

```java
public void fenceBlock(FenceBlock block, String name, ResourceLocation texture)
```
源码 :579 —（无 javadoc）

```java
public void fenceBlockWithRenderType(FenceBlock block, ResourceLocation texture, String renderType)
```
源码 :585 —（无 javadoc）

```java
public void fenceBlockWithRenderType(FenceBlock block, String name, ResourceLocation texture, String renderType)
```
源码 :592 —（无 javadoc）

```java
public void fenceBlockWithRenderType(FenceBlock block, ResourceLocation texture, ResourceLocation renderType)
```
源码 :598 —（无 javadoc）

```java
public void fenceBlockWithRenderType(FenceBlock block, String name, ResourceLocation texture, ResourceLocation renderType)
```
源码 :605 —（无 javadoc）

```java
public void fenceBlockWithRenderTypeAndFast(FenceBlock block, ResourceLocation texture, String renderType, String renderTypeFast)
```
源码 :611 —（无 javadoc）

```java
public void fenceBlockWithRenderTypeAndFast(FenceBlock block, String name, ResourceLocation texture, String renderType, String renderTypeFast)
```
源码 :618 —（无 javadoc）

```java
public void fenceBlockWithRenderTypeAndFast(FenceBlock block, ResourceLocation texture, ResourceLocation renderType, ResourceLocation renderTypeFast)
```
源码 :624 —（无 javadoc）

```java
public void fenceBlockWithRenderTypeAndFast(FenceBlock block, String name, ResourceLocation texture, ResourceLocation renderType, ResourceLocation renderTypeFast)
```
源码 :631 —（无 javadoc）

```java
public void fenceGateBlock(FenceGateBlock block, ResourceLocation texture)
```
源码 :637 —（无 javadoc）

```java
public void fenceGateBlock(FenceGateBlock block, String name, ResourceLocation texture)
```
源码 :641 —（无 javadoc）

```java
public void fenceGateBlockWithRenderType(FenceGateBlock block, ResourceLocation texture, String renderType)
```
源码 :645 —（无 javadoc）

```java
public void fenceGateBlockWithRenderType(FenceGateBlock block, String name, ResourceLocation texture, String renderType)
```
源码 :649 —（无 javadoc）

```java
public void fenceGateBlockWithRenderType(FenceGateBlock block, ResourceLocation texture, ResourceLocation renderType)
```
源码 :653 —（无 javadoc）

```java
public void fenceGateBlockWithRenderType(FenceGateBlock block, String name, ResourceLocation texture, ResourceLocation renderType)
```
源码 :657 —（无 javadoc）

```java
public void fenceGateBlockWithRenderTypeAndFast(FenceGateBlock block, ResourceLocation texture, String renderType, String renderTypeFast)
```
源码 :661 —（无 javadoc）

```java
public void fenceGateBlockWithRenderTypeAndFast(FenceGateBlock block, String name, ResourceLocation texture, String renderType, String renderTypeFast)
```
源码 :665 —（无 javadoc）

```java
public void fenceGateBlockWithRenderTypeAndFast(FenceGateBlock block, ResourceLocation texture, ResourceLocation renderType, ResourceLocation renderTypeFast)
```
源码 :669 —（无 javadoc）

```java
public void fenceGateBlockWithRenderTypeAndFast(FenceGateBlock block, String name, ResourceLocation texture, ResourceLocation renderType, ResourceLocation renderTypeFast)
```
源码 :673 —（无 javadoc）

```java
public void fenceGateBlock(FenceGateBlock block, ModelFile gate, ModelFile gateOpen, ModelFile gateWall, ModelFile gateWallOpen)
```
源码 :701 —（无 javadoc）

```java
public void wallBlock(WallBlock block, ResourceLocation texture)
```
源码 :718 —（无 javadoc）

```java
public void wallBlock(WallBlock block, String name, ResourceLocation texture)
```
源码 :722 —（无 javadoc）

```java
public void wallBlockWithRenderType(WallBlock block, ResourceLocation texture, String renderType)
```
源码 :726 —（无 javadoc）

```java
public void wallBlockWithRenderType(WallBlock block, String name, ResourceLocation texture, String renderType)
```
源码 :730 —（无 javadoc）

```java
public void wallBlockWithRenderType(WallBlock block, ResourceLocation texture, ResourceLocation renderType)
```
源码 :734 —（无 javadoc）

```java
public void wallBlockWithRenderType(WallBlock block, String name, ResourceLocation texture, ResourceLocation renderType)
```
源码 :738 —（无 javadoc）

```java
public void wallBlockWithRenderTypeAndFast(WallBlock block, ResourceLocation texture, String renderType, String renderTypeFast)
```
源码 :742 —（无 javadoc）

```java
public void wallBlockWithRenderTypeAndFast(WallBlock block, String name, ResourceLocation texture, String renderType, String renderTypeFast)
```
源码 :746 —（无 javadoc）

```java
public void wallBlockWithRenderTypeAndFast(WallBlock block, ResourceLocation texture, ResourceLocation renderType, ResourceLocation renderTypeFast)
```
源码 :750 —（无 javadoc）

```java
public void wallBlockWithRenderTypeAndFast(WallBlock block, String name, ResourceLocation texture, ResourceLocation renderType, ResourceLocation renderTypeFast)
```
源码 :754 —（无 javadoc）

```java
public static final ImmutableMap<Direction, Property<WallSide>> WALL_PROPS = ImmutableMap.<Direction, Property<WallSide>>b…
```
源码 :776 —（无 javadoc）

```java
public void wallBlock(WallBlock block, ModelFile post, ModelFile side, ModelFile sideTall)
```
源码 :783 —（无 javadoc）

```java
public void paneBlock(IronBarsBlock block, ResourceLocation pane, ResourceLocation edge)
```
源码 :804 —（无 javadoc）

```java
public void paneBlock(IronBarsBlock block, String name, ResourceLocation pane, ResourceLocation edge)
```
源码 :808 —（无 javadoc）

```java
public void paneBlockWithRenderType(IronBarsBlock block, ResourceLocation pane, ResourceLocation edge, String renderType)
```
源码 :812 —（无 javadoc）

```java
public void paneBlockWithRenderType(IronBarsBlock block, String name, ResourceLocation pane, ResourceLocation edge, String renderType)
```
源码 :816 —（无 javadoc）

```java
public void paneBlockWithRenderType(IronBarsBlock block, ResourceLocation pane, ResourceLocation edge, ResourceLocation renderType)
```
源码 :820 —（无 javadoc）

```java
public void paneBlockWithRenderType(IronBarsBlock block, String name, ResourceLocation pane, ResourceLocation edge, ResourceLocation renderType)
```
源码 :824 —（无 javadoc）

```java
public void paneBlockWithRenderTypeAndFast(IronBarsBlock block, ResourceLocation pane, ResourceLocation edge, String renderType, String renderTypeFast)
```
源码 :828 —（无 javadoc）

```java
public void paneBlockWithRenderTypeAndFast(IronBarsBlock block, String name, ResourceLocation pane, ResourceLocation edge, String renderType, String renderTypeFast)
```
源码 :832 —（无 javadoc）

```java
public void paneBlockWithRenderTypeAndFast(IronBarsBlock block, ResourceLocation pane, ResourceLocation edge, ResourceLocation renderType, ResourceLocation renderTypeFast)
```
源码 :836 —（无 javadoc）

```java
public void paneBlockWithRenderTypeAndFast(IronBarsBlock block, String name, ResourceLocation pane, ResourceLocation edge, ResourceLocation renderType, ResourceLocation renderTypeFast)
```
源码 :840 —（无 javadoc）

```java
public void paneBlock(IronBarsBlock block, ModelFile post, ModelFile side, ModelFile sideAlt, ModelFile noSide, ModelFile noSideAlt)
```
源码 :871 —（无 javadoc）

```java
public void doorBlock(DoorBlock block, ResourceLocation bottom, ResourceLocation top)
```
源码 :886 —（无 javadoc）

```java
public void doorBlock(DoorBlock block, String name, ResourceLocation bottom, ResourceLocation top)
```
源码 :890 —（无 javadoc）

```java
public void doorBlockWithRenderType(DoorBlock block, ResourceLocation bottom, ResourceLocation top, String renderType)
```
源码 :894 —（无 javadoc）

```java
public void doorBlockWithRenderType(DoorBlock block, String name, ResourceLocation bottom, ResourceLocation top, String renderType)
```
源码 :898 —（无 javadoc）

```java
public void doorBlockWithRenderType(DoorBlock block, ResourceLocation bottom, ResourceLocation top, ResourceLocation renderType)
```
源码 :902 —（无 javadoc）

```java
public void doorBlockWithRenderType(DoorBlock block, String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation renderType)
```
源码 :906 —（无 javadoc）

```java
public void doorBlockWithRenderTypeAndFast(DoorBlock block, ResourceLocation bottom, ResourceLocation top, String renderType, String renderTypeFast)
```
源码 :910 —（无 javadoc）

```java
public void doorBlockWithRenderTypeAndFast(DoorBlock block, String name, ResourceLocation bottom, ResourceLocation top, String renderType, String renderTypeFast)
```
源码 :914 —（无 javadoc）

```java
public void doorBlockWithRenderTypeAndFast(DoorBlock block, ResourceLocation bottom, ResourceLocation top, ResourceLocation renderType, ResourceLocation renderTypeFast)
```
源码 :918 —（无 javadoc）

```java
public void doorBlockWithRenderTypeAndFast(DoorBlock block, String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation renderType, ResourceLocation renderTypeFast)
```
源码 :922 —（无 javadoc）

```java
public void doorBlock(DoorBlock block, ModelFile bottomLeft, ModelFile bottomLeftOpen, ModelFile bottomRight, ModelFile bottomRightOpen, ModelFile topLeft, ModelFile topLeftOpen, ModelFile topRight, ModelFile topRightOpen)
```
源码 :962 —（无 javadoc）

```java
public void trapdoorBlock(TrapDoorBlock block, ResourceLocation texture, boolean orientable)
```
源码 :1004 —（无 javadoc）

```java
public void trapdoorBlock(TrapDoorBlock block, String name, ResourceLocation texture, boolean orientable)
```
源码 :1008 —（无 javadoc）

```java
public void trapdoorBlockWithRenderType(TrapDoorBlock block, ResourceLocation texture, boolean orientable, String renderType)
```
源码 :1012 —（无 javadoc）

```java
public void trapdoorBlockWithRenderType(TrapDoorBlock block, String name, ResourceLocation texture, boolean orientable, String renderType)
```
源码 :1016 —（无 javadoc）

```java
public void trapdoorBlockWithRenderType(TrapDoorBlock block, ResourceLocation texture, boolean orientable, ResourceLocation renderType)
```
源码 :1020 —（无 javadoc）

```java
public void trapdoorBlockWithRenderType(TrapDoorBlock block, String name, ResourceLocation texture, boolean orientable, ResourceLocation renderType)
```
源码 :1024 —（无 javadoc）

```java
public void trapdoorBlockWithRenderTypeAndFast(TrapDoorBlock block, ResourceLocation texture, boolean orientable, String renderType, String renderTypeFast)
```
源码 :1028 —（无 javadoc）

```java
public void trapdoorBlockWithRenderTypeAndFast(TrapDoorBlock block, String name, ResourceLocation texture, boolean orientable, String renderType, String renderTypeFast)
```
源码 :1032 —（无 javadoc）

```java
public void trapdoorBlockWithRenderTypeAndFast(TrapDoorBlock block, ResourceLocation texture, boolean orientable, ResourceLocation renderType, ResourceLocation renderTypeFast)
```
源码 :1036 —（无 javadoc）

```java
public void trapdoorBlockWithRenderTypeAndFast(TrapDoorBlock block, String name, ResourceLocation texture, boolean orientable, ResourceLocation renderType, ResourceLocation renderTypeFast)
```
源码 :1040 —（无 javadoc）

```java
public void trapdoorBlock(TrapDoorBlock block, ModelFile bottom, ModelFile top, ModelFile open, boolean orientable)
```
源码 :1065 —（无 javadoc）

```java
public String getName()
```
源码 :1094 —（无 javadoc）

```java
public static class ConfiguredModelList
```
源码 :1098 —（无 javadoc）

