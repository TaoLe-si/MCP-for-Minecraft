# Forge 官方 API 逐类 SKILL · 总索引

> 由 `python tools/gen_forge_skills.py` 从反编译源码**逐类生成**，不是手写 —— 签名、行号、javadoc 都直接抄自源码。
> 生成后由 `python tools/audit_forge_skills.py` 做外部核对：
> **0 处行号错、0 处漏收**（审计独立实现，不复用生成器的解析）。

## 规模

| 项 | 数 |
|---|---|
| 类 | 855 |
| 公开/受保护成员 | 5517 |
| 包 | 104 |
| 本项目直接用到的类 | 23 |

## 本项目直接用到的类（23 个）

| 类 | 类型 | 成员 | SKILL |
|---|---|---:|---|
| `net.minecraftforge.api.distmarker.Dist` | enum | 3 | [Dist](net/minecraftforge/api/distmarker/Dist.md) |
| `net.minecraftforge.api.distmarker.OnlyIn` | @interface | 2 | [OnlyIn](net/minecraftforge/api/distmarker/OnlyIn.md) |
| `net.minecraftforge.client.ForgeHooksClient` | class | 101 | [ForgeHooksClient](net/minecraftforge/client/ForgeHooksClient.md) |
| `net.minecraftforge.client.event.ClientChatReceivedEvent` | class | 8 | [ClientChatReceivedEvent](net/minecraftforge/client/event/ClientChatReceivedEvent.md) |
| `net.minecraftforge.client.event.CustomizeGuiOverlayEvent` | class | 7 | [CustomizeGuiOverlayEvent](net/minecraftforge/client/event/CustomizeGuiOverlayEvent.md) |
| `net.minecraftforge.client.event.sound.PlaySoundEvent` | class | 5 | [PlaySoundEvent](net/minecraftforge/client/event/sound/PlaySoundEvent.md) |
| `net.minecraftforge.client.gui.LoadingErrorScreen` | class | 4 | [LoadingErrorScreen](net/minecraftforge/client/gui/LoadingErrorScreen.md) |
| `net.minecraftforge.common.ForgeMod` | class | 40 | [ForgeMod](net/minecraftforge/common/ForgeMod.md) |
| `net.minecraftforge.common.MinecraftForge` | class | 4 | [MinecraftForge](net/minecraftforge/common/MinecraftForge.md) |
| `net.minecraftforge.common.extensions.IForgeBlockState` | interface | 53 | [IForgeBlockState](net/minecraftforge/common/extensions/IForgeBlockState.md) |
| `net.minecraftforge.event.TickEvent` | class | 11 | [TickEvent](net/minecraftforge/event/TickEvent.md) |
| `net.minecraftforge.event.entity.living.LivingDeathEvent` | class | 2 | [LivingDeathEvent](net/minecraftforge/event/entity/living/LivingDeathEvent.md) |
| `net.minecraftforge.event.entity.player.PlayerEvent` | class | 19 | [PlayerEvent](net/minecraftforge/event/entity/player/PlayerEvent.md) |
| `net.minecraftforge.eventbus.api.EventPriority` | enum | 2 | [EventPriority](net/minecraftforge/eventbus/api/EventPriority.md) |
| `net.minecraftforge.eventbus.api.IEventBus` | interface | 12 | [IEventBus](net/minecraftforge/eventbus/api/IEventBus.md) |
| `net.minecraftforge.eventbus.api.SubscribeEvent` | @interface | 2 | [SubscribeEvent](net/minecraftforge/eventbus/api/SubscribeEvent.md) |
| `net.minecraftforge.fml.DistExecutor` | class | 10 | [DistExecutor](net/minecraftforge/fml/DistExecutor.md) |
| `net.minecraftforge.fml.common.Mod` | @interface | 1 | [Mod](net/minecraftforge/fml/common/Mod.md) |
| `net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext` | class | 3 | [FMLJavaModLoadingContext](net/minecraftforge/fml/javafmlmod/FMLJavaModLoadingContext.md) |
| `net.minecraftforge.fml.loading.FMLEnvironment` | class | 5 | [FMLEnvironment](net/minecraftforge/fml/loading/FMLEnvironment.md) |
| `net.minecraftforge.fml.loading.FMLPaths` | enum | 6 | [FMLPaths](net/minecraftforge/fml/loading/FMLPaths.md) |
| `net.minecraftforge.registries.ForgeRegistries` | class | 38 | [ForgeRegistries](net/minecraftforge/registries/ForgeRegistries.md) |
| `net.minecraftforge.server.ServerLifecycleHooks` | class | 10 | [ServerLifecycleHooks](net/minecraftforge/server/ServerLifecycleHooks.md) |

## 全部类（按包）

### `ICrashCallable`（1）

- [ICrashCallable](ICrashCallable.md) · class · 0 成员

### `net.minecraftforge.api.distmarker`（3）

- **★** [Dist](net/minecraftforge/api/distmarker/Dist.md) · enum · 3 成员
- **★** [OnlyIn](net/minecraftforge/api/distmarker/OnlyIn.md) · @interface · 2 成员
- [OnlyIns](net/minecraftforge/api/distmarker/OnlyIns.md) · @interface · 1 成员

### `net.minecraftforge.client`（22）

- [ChunkRenderTypeSet](net/minecraftforge/client/ChunkRenderTypeSet.md) · class · 14 成员
- [ClientCommandHandler](net/minecraftforge/client/ClientCommandHandler.md) · class · 5 成员
- [ClientCommandSourceStack](net/minecraftforge/client/ClientCommandSourceStack.md) · class · 13 成员
- [ClientForgeMod](net/minecraftforge/client/ClientForgeMod.md) · class · 3 成员
- [ColorResolverManager](net/minecraftforge/client/ColorResolverManager.md) · class · 2 成员
- [ConfigScreenHandler](net/minecraftforge/client/ConfigScreenHandler.md) · class · 2 成员
- [CreativeModeTabSearchRegistry](net/minecraftforge/client/CreativeModeTabSearchRegistry.md) · class · 5 成员
- [DimensionSpecialEffectsManager](net/minecraftforge/client/DimensionSpecialEffectsManager.md) · class · 2 成员
- [EntitySpectatorShaderManager](net/minecraftforge/client/EntitySpectatorShaderManager.md) · class · 2 成员
- [ExtendedServerListData](net/minecraftforge/client/ExtendedServerListData.md) · record · 1 成员
- [FireworkShapeFactoryRegistry](net/minecraftforge/client/FireworkShapeFactoryRegistry.md) · class · 3 成员
- **★** [ForgeHooksClient](net/minecraftforge/client/ForgeHooksClient.md) · class · 101 成员
- [ForgeRenderTypes](net/minecraftforge/client/ForgeRenderTypes.md) · enum · 17 成员
- [IArmPoseTransformer](net/minecraftforge/client/IArmPoseTransformer.md) · interface · 1 成员
- [IItemDecorator](net/minecraftforge/client/IItemDecorator.md) · interface · 1 成员
- [ItemDecoratorHandler](net/minecraftforge/client/ItemDecoratorHandler.md) · class · 3 成员
- [NamedRenderTypeManager](net/minecraftforge/client/NamedRenderTypeManager.md) · class · 2 成员
- [PresetEditorManager](net/minecraftforge/client/PresetEditorManager.md) · class · 1 成员
- [RecipeBookManager](net/minecraftforge/client/RecipeBookManager.md) · class · 4 成员
- [RenderTypeGroup](net/minecraftforge/client/RenderTypeGroup.md) · record · 4 成员
- [RenderTypeHelper](net/minecraftforge/client/RenderTypeHelper.md) · class · 3 成员
- [StencilManager](net/minecraftforge/client/StencilManager.md) · class · 2 成员

### `net.minecraftforge.client.event`（45）

- [ClientChatEvent](net/minecraftforge/client/event/ClientChatEvent.md) · class · 4 成员
- **★** [ClientChatReceivedEvent](net/minecraftforge/client/event/ClientChatReceivedEvent.md) · class · 8 成员
- [ClientPlayerChangeGameTypeEvent](net/minecraftforge/client/event/ClientPlayerChangeGameTypeEvent.md) · class · 4 成员
- [ClientPlayerNetworkEvent](net/minecraftforge/client/event/ClientPlayerNetworkEvent.md) · class · 7 成员
- [ComputeFovModifierEvent](net/minecraftforge/client/event/ComputeFovModifierEvent.md) · class · 5 成员
- [ContainerScreenEvent](net/minecraftforge/client/event/ContainerScreenEvent.md) · class · 3 成员
- **★** [CustomizeGuiOverlayEvent](net/minecraftforge/client/event/CustomizeGuiOverlayEvent.md) · class · 7 成员
- [EntityRenderersEvent](net/minecraftforge/client/event/EntityRenderersEvent.md) · class · 5 成员
- [InputEvent](net/minecraftforge/client/event/InputEvent.md) · class · 5 成员
- [ModelEvent](net/minecraftforge/client/event/ModelEvent.md) · class · 5 成员
- [MovementInputUpdateEvent](net/minecraftforge/client/event/MovementInputUpdateEvent.md) · class · 2 成员
- [RecipesUpdatedEvent](net/minecraftforge/client/event/RecipesUpdatedEvent.md) · class · 2 成员
- [RegisterClientCommandsEvent](net/minecraftforge/client/event/RegisterClientCommandsEvent.md) · class · 3 成员
- [RegisterClientReloadListenersEvent](net/minecraftforge/client/event/RegisterClientReloadListenersEvent.md) · class · 2 成员
- [RegisterClientTooltipComponentFactoriesEvent](net/minecraftforge/client/event/RegisterClientTooltipComponentFactoriesEvent.md) · class · 2 成员
- [RegisterColorHandlersEvent](net/minecraftforge/client/event/RegisterColorHandlersEvent.md) · class · 4 成员
- [RegisterDimensionSpecialEffectsEvent](net/minecraftforge/client/event/RegisterDimensionSpecialEffectsEvent.md) · class · 2 成员
- [RegisterEntitySpectatorShadersEvent](net/minecraftforge/client/event/RegisterEntitySpectatorShadersEvent.md) · class · 2 成员
- [RegisterGuiOverlaysEvent](net/minecraftforge/client/event/RegisterGuiOverlaysEvent.md) · class · 5 成员
- [RegisterItemDecorationsEvent](net/minecraftforge/client/event/RegisterItemDecorationsEvent.md) · class · 2 成员
- [RegisterKeyMappingsEvent](net/minecraftforge/client/event/RegisterKeyMappingsEvent.md) · class · 2 成员
- [RegisterNamedRenderTypesEvent](net/minecraftforge/client/event/RegisterNamedRenderTypesEvent.md) · class · 3 成员
- [RegisterParticleProvidersEvent](net/minecraftforge/client/event/RegisterParticleProvidersEvent.md) · class · 4 成员
- [RegisterPresetEditorsEvent](net/minecraftforge/client/event/RegisterPresetEditorsEvent.md) · class · 2 成员
- [RegisterRecipeBookCategoriesEvent](net/minecraftforge/client/event/RegisterRecipeBookCategoriesEvent.md) · class · 4 成员
- [RegisterShadersEvent](net/minecraftforge/client/event/RegisterShadersEvent.md) · class · 3 成员
- [RegisterTextureAtlasSpriteLoadersEvent](net/minecraftforge/client/event/RegisterTextureAtlasSpriteLoadersEvent.md) · class · 2 成员
- [RenderArmEvent](net/minecraftforge/client/event/RenderArmEvent.md) · class · 6 成员
- [RenderBlockScreenEffectEvent](net/minecraftforge/client/event/RenderBlockScreenEffectEvent.md) · class · 7 成员
- [RenderGuiEvent](net/minecraftforge/client/event/RenderGuiEvent.md) · class · 6 成员
- [RenderGuiOverlayEvent](net/minecraftforge/client/event/RenderGuiOverlayEvent.md) · class · 7 成员
- [RenderHandEvent](net/minecraftforge/client/event/RenderHandEvent.md) · class · 10 成员
- [RenderHighlightEvent](net/minecraftforge/client/event/RenderHighlightEvent.md) · class · 9 成员
- [RenderItemInFrameEvent](net/minecraftforge/client/event/RenderItemInFrameEvent.md) · class · 7 成员
- [RenderLevelStageEvent](net/minecraftforge/client/event/RenderLevelStageEvent.md) · class · 11 成员
- [RenderLivingEvent](net/minecraftforge/client/event/RenderLivingEvent.md) · class · 9 成员
- [RenderNameTagEvent](net/minecraftforge/client/event/RenderNameTagEvent.md) · class · 9 成员
- [RenderPlayerEvent](net/minecraftforge/client/event/RenderPlayerEvent.md) · class · 8 成员
- [RenderTooltipEvent](net/minecraftforge/client/event/RenderTooltipEvent.md) · class · 16 成员
- [ScreenEvent](net/minecraftforge/client/event/ScreenEvent.md) · class · 15 成员
- [ScreenshotEvent](net/minecraftforge/client/event/ScreenshotEvent.md) · class · 8 成员
- [TextureStitchEvent](net/minecraftforge/client/event/TextureStitchEvent.md) · class · 3 成员
- [ToastAddEvent](net/minecraftforge/client/event/ToastAddEvent.md) · class · 2 成员
- [ViewportEvent](net/minecraftforge/client/event/ViewportEvent.md) · class · 8 成员
- [package-info](net/minecraftforge/client/event/package-info.md) · class · 0 成员

### `net.minecraftforge.client.event.sound`（6）

- **★** [PlaySoundEvent](net/minecraftforge/client/event/sound/PlaySoundEvent.md) · class · 5 成员
- [PlaySoundSourceEvent](net/minecraftforge/client/event/sound/PlaySoundSourceEvent.md) · class · 1 成员
- [PlayStreamingSourceEvent](net/minecraftforge/client/event/sound/PlayStreamingSourceEvent.md) · class · 1 成员
- [SoundEngineLoadEvent](net/minecraftforge/client/event/sound/SoundEngineLoadEvent.md) · class · 1 成员
- [SoundEvent](net/minecraftforge/client/event/sound/SoundEvent.md) · class · 3 成员
- [package-info](net/minecraftforge/client/event/sound/package-info.md) · class · 0 成员

### `net.minecraftforge.client.extensions`（11）

- [IForgeBakedModel](net/minecraftforge/client/extensions/IForgeBakedModel.md) · interface · 9 成员
- [IForgeBlockAndTintGetter](net/minecraftforge/client/extensions/IForgeBlockAndTintGetter.md) · interface · 2 成员
- [IForgeDimensionSpecialEffects](net/minecraftforge/client/extensions/IForgeDimensionSpecialEffects.md) · interface · 6 成员
- [IForgeFont](net/minecraftforge/client/extensions/IForgeFont.md) · interface · 2 成员
- [IForgeGuiGraphics](net/minecraftforge/client/extensions/IForgeGuiGraphics.md) · interface · 9 成员
- [IForgeKeyMapping](net/minecraftforge/client/extensions/IForgeKeyMapping.md) · interface · 10 成员
- [IForgeMinecraft](net/minecraftforge/client/extensions/IForgeMinecraft.md) · interface · 4 成员
- [IForgeModelBaker](net/minecraftforge/client/extensions/IForgeModelBaker.md) · interface · 2 成员
- [IForgePoseStack](net/minecraftforge/client/extensions/IForgePoseStack.md) · interface · 2 成员
- [IForgeVertexConsumer](net/minecraftforge/client/extensions/IForgeVertexConsumer.md) · interface · 5 成员
- [package-info](net/minecraftforge/client/extensions/package-info.md) · class · 0 成员

### `net.minecraftforge.client.extensions.common`（4）

- [IClientBlockExtensions](net/minecraftforge/client/extensions/common/IClientBlockExtensions.md) · interface · 6 成员
- [IClientFluidTypeExtensions](net/minecraftforge/client/extensions/common/IClientFluidTypeExtensions.md) · interface · 19 成员
- [IClientItemExtensions](net/minecraftforge/client/extensions/common/IClientItemExtensions.md) · interface · 8 成员
- [IClientMobEffectExtensions](net/minecraftforge/client/extensions/common/IClientMobEffectExtensions.md) · interface · 7 成员

### `net.minecraftforge.client.gui`（7）

- [ClientTooltipComponentManager](net/minecraftforge/client/gui/ClientTooltipComponentManager.md) · class · 2 成员
- [CreativeTabsScreenPage](net/minecraftforge/client/gui/CreativeTabsScreenPage.md) · class · 5 成员
- **★** [LoadingErrorScreen](net/minecraftforge/client/gui/LoadingErrorScreen.md) · class · 4 成员
- [ModListScreen](net/minecraftforge/client/gui/ModListScreen.md) · class · 10 成员
- [ModMismatchDisconnectedScreen](net/minecraftforge/client/gui/ModMismatchDisconnectedScreen.md) · class · 3 成员
- [ScreenUtils](net/minecraftforge/client/gui/ScreenUtils.md) · class · 17 成员
- [TitleScreenModUpdateIndicator](net/minecraftforge/client/gui/TitleScreenModUpdateIndicator.md) · class · 4 成员

### `net.minecraftforge.client.gui.overlay`（5）

- [ForgeGui](net/minecraftforge/client/gui/overlay/ForgeGui.md) · class · 26 成员
- [GuiOverlayManager](net/minecraftforge/client/gui/overlay/GuiOverlayManager.md) · class · 3 成员
- [IGuiOverlay](net/minecraftforge/client/gui/overlay/IGuiOverlay.md) · interface · 1 成员
- [NamedGuiOverlay](net/minecraftforge/client/gui/overlay/NamedGuiOverlay.md) · record · 1 成员
- [VanillaGuiOverlay](net/minecraftforge/client/gui/overlay/VanillaGuiOverlay.md) · enum · 2 成员

### `net.minecraftforge.client.gui.widget`（5）

- [ExtendedButton](net/minecraftforge/client/gui/widget/ExtendedButton.md) · class · 4 成员
- [ForgeSlider](net/minecraftforge/client/gui/widget/ForgeSlider.md) · class · 18 成员
- [ModListWidget](net/minecraftforge/client/gui/widget/ModListWidget.md) · class · 6 成员
- [ScrollPanel](net/minecraftforge/client/gui/widget/ScrollPanel.md) · class · 28 成员
- [UnicodeGlyphButton](net/minecraftforge/client/gui/widget/UnicodeGlyphButton.md) · class · 4 成员

### `net.minecraftforge.client.loading`（3）

- [ClientModLoader](net/minecraftforge/client/loading/ClientModLoader.md) · class · 4 成员
- [ForgeLoadingOverlay](net/minecraftforge/client/loading/ForgeLoadingOverlay.md) · class · 3 成员
- [NoVizFallback](net/minecraftforge/client/loading/NoVizFallback.md) · class · 4 成员

### `net.minecraftforge.client.model`（16）

- [BakedModelWrapper](net/minecraftforge/client/model/BakedModelWrapper.md) · class · 19 成员
- [CompositeModel](net/minecraftforge/client/model/CompositeModel.md) · class · 7 成员
- [DynamicFluidContainerModel](net/minecraftforge/client/model/DynamicFluidContainerModel.md) · class · 5 成员
- [ElementsModel](net/minecraftforge/client/model/ElementsModel.md) · class · 3 成员
- [EmptyModel](net/minecraftforge/client/model/EmptyModel.md) · class · 5 成员
- [ExtendedBlockModelDeserializer](net/minecraftforge/client/model/ExtendedBlockModelDeserializer.md) · class · 3 成员
- [ForgeFaceData](net/minecraftforge/client/model/ForgeFaceData.md) · record · 5 成员
- [ForgeItemModelShaper](net/minecraftforge/client/model/ForgeItemModelShaper.md) · class · 5 成员
- [IDynamicBakedModel](net/minecraftforge/client/model/IDynamicBakedModel.md) · interface · 1 成员
- [IModelBuilder](net/minecraftforge/client/model/IModelBuilder.md) · interface · 3 成员
- [IQuadTransformer](net/minecraftforge/client/model/IQuadTransformer.md) · interface · 7 成员
- [ItemLayerModel](net/minecraftforge/client/model/ItemLayerModel.md) · class · 2 成员
- [QuadTransformers](net/minecraftforge/client/model/QuadTransformers.md) · class · 10 成员
- [SeparateTransformsModel](net/minecraftforge/client/model/SeparateTransformsModel.md) · class · 5 成员
- [SimpleModelState](net/minecraftforge/client/model/SimpleModelState.md) · class · 4 成员
- [package-info](net/minecraftforge/client/model/package-info.md) · class · 0 成员

### `net.minecraftforge.client.model.data`（4）

- [ModelData](net/minecraftforge/client/model/data/ModelData.md) · class · 7 成员
- [ModelDataManager](net/minecraftforge/client/model/data/ModelDataManager.md) · class · 5 成员
- [ModelProperty](net/minecraftforge/client/model/data/ModelProperty.md) · class · 3 成员
- [MultipartModelData](net/minecraftforge/client/model/data/MultipartModelData.md) · class · 5 成员

### `net.minecraftforge.client.model.generators`（13）

- [BlockModelBuilder](net/minecraftforge/client/model/generators/BlockModelBuilder.md) · class · 2 成员
- [BlockModelProvider](net/minecraftforge/client/model/generators/BlockModelProvider.md) · class · 2 成员
- [BlockStateProvider](net/minecraftforge/client/model/generators/BlockStateProvider.md) · class · 152 成员
- [ConfiguredModel](net/minecraftforge/client/model/generators/ConfiguredModel.md) · class · 15 成员
- [CustomLoaderBuilder](net/minecraftforge/client/model/generators/CustomLoaderBuilder.md) · class · 8 成员
- [IGeneratedBlockState](net/minecraftforge/client/model/generators/IGeneratedBlockState.md) · interface · 1 成员
- [ItemModelBuilder](net/minecraftforge/client/model/generators/ItemModelBuilder.md) · class · 6 成员
- [ItemModelProvider](net/minecraftforge/client/model/generators/ItemModelProvider.md) · class · 4 成员
- [ModelBuilder](net/minecraftforge/client/model/generators/ModelBuilder.md) · class · 32 成员
- [ModelFile](net/minecraftforge/client/model/generators/ModelFile.md) · class · 8 成员
- [ModelProvider](net/minecraftforge/client/model/generators/ModelProvider.md) · class · 83 成员
- [MultiPartBlockStateBuilder](net/minecraftforge/client/model/generators/MultiPartBlockStateBuilder.md) · class · 4 成员
- [VariantBlockStateBuilder](net/minecraftforge/client/model/generators/VariantBlockStateBuilder.md) · class · 9 成员

### `net.minecraftforge.client.model.generators.loaders`（5）

- [CompositeModelBuilder](net/minecraftforge/client/model/generators/loaders/CompositeModelBuilder.md) · class · 5 成员
- [DynamicFluidContainerModelBuilder](net/minecraftforge/client/model/generators/loaders/DynamicFluidContainerModelBuilder.md) · class · 8 成员
- [ItemLayerModelBuilder](net/minecraftforge/client/model/generators/loaders/ItemLayerModelBuilder.md) · class · 9 成员
- [ObjModelBuilder](net/minecraftforge/client/model/generators/loaders/ObjModelBuilder.md) · class · 9 成员
- [SeparateTransformsModelBuilder](net/minecraftforge/client/model/generators/loaders/SeparateTransformsModelBuilder.md) · class · 5 成员

### `net.minecraftforge.client.model.geometry`（8）

- [BlockGeometryBakingContext](net/minecraftforge/client/model/geometry/BlockGeometryBakingContext.md) · class · 24 成员
- [GeometryLoaderManager](net/minecraftforge/client/model/geometry/GeometryLoaderManager.md) · class · 3 成员
- [IGeometryBakingContext](net/minecraftforge/client/model/geometry/IGeometryBakingContext.md) · interface · 11 成员
- [IGeometryLoader](net/minecraftforge/client/model/geometry/IGeometryLoader.md) · interface · 1 成员
- [IUnbakedGeometry](net/minecraftforge/client/model/geometry/IUnbakedGeometry.md) · interface · 3 成员
- [SimpleUnbakedGeometry](net/minecraftforge/client/model/geometry/SimpleUnbakedGeometry.md) · class · 2 成员
- [StandaloneGeometryBakingContext](net/minecraftforge/client/model/geometry/StandaloneGeometryBakingContext.md) · class · 19 成员
- [UnbakedGeometryHelper](net/minecraftforge/client/model/geometry/UnbakedGeometryHelper.md) · class · 11 成员

### `net.minecraftforge.client.model.lighting`（4）

- [FlatQuadLighter](net/minecraftforge/client/model/lighting/FlatQuadLighter.md) · class · 4 成员
- [ForgeModelBlockRenderer](net/minecraftforge/client/model/lighting/ForgeModelBlockRenderer.md) · class · 4 成员
- [QuadLighter](net/minecraftforge/client/model/lighting/QuadLighter.md) · class · 9 成员
- [SmoothQuadLighter](net/minecraftforge/client/model/lighting/SmoothQuadLighter.md) · class · 5 成员

### `net.minecraftforge.client.model.obj`（5）

- [ObjLoader](net/minecraftforge/client/model/obj/ObjLoader.md) · class · 5 成员
- [ObjMaterialLibrary](net/minecraftforge/client/model/obj/ObjMaterialLibrary.md) · class · 4 成员
- [ObjModel](net/minecraftforge/client/model/obj/ObjModel.md) · class · 14 成员
- [ObjTokenizer](net/minecraftforge/client/model/obj/ObjTokenizer.md) · class · 3 成员
- [package-info](net/minecraftforge/client/model/obj/package-info.md) · class · 0 成员

### `net.minecraftforge.client.model.pipeline`（5）

- [QuadBakingVertexConsumer](net/minecraftforge/client/model/pipeline/QuadBakingVertexConsumer.md) · class · 17 成员
- [RemappingVertexPipeline](net/minecraftforge/client/model/pipeline/RemappingVertexPipeline.md) · class · 11 成员
- [TransformingVertexPipeline](net/minecraftforge/client/model/pipeline/TransformingVertexPipeline.md) · class · 3 成员
- [VertexConsumerWrapper](net/minecraftforge/client/model/pipeline/VertexConsumerWrapper.md) · class · 12 成员
- [package-info](net/minecraftforge/client/model/pipeline/package-info.md) · class · 0 成员

### `net.minecraftforge.client.model.renderable`（4）

- [BakedModelRenderable](net/minecraftforge/client/model/renderable/BakedModelRenderable.md) · class · 6 成员
- [CompositeRenderable](net/minecraftforge/client/model/renderable/CompositeRenderable.md) · class · 5 成员
- [IRenderable](net/minecraftforge/client/model/renderable/IRenderable.md) · interface · 2 成员
- [ITextureRenderTypeLookup](net/minecraftforge/client/model/renderable/ITextureRenderTypeLookup.md) · interface · 1 成员

### `net.minecraftforge.client.settings`（4）

- [IKeyConflictContext](net/minecraftforge/client/settings/IKeyConflictContext.md) · interface · 2 成员
- [KeyConflictContext](net/minecraftforge/client/settings/KeyConflictContext.md) · enum · 3 成员
- [KeyMappingLookup](net/minecraftforge/client/settings/KeyMappingLookup.md) · class · 5 成员
- [KeyModifier](net/minecraftforge/client/settings/KeyModifier.md) · enum · 13 成员

### `net.minecraftforge.client.textures`（4）

- [ForgeTextureMetadata](net/minecraftforge/client/textures/ForgeTextureMetadata.md) · class · 5 成员
- [ITextureAtlasSpriteLoader](net/minecraftforge/client/textures/ITextureAtlasSpriteLoader.md) · interface · 2 成员
- [TextureAtlasSpriteLoaderManager](net/minecraftforge/client/textures/TextureAtlasSpriteLoaderManager.md) · class · 2 成员
- [UnitTextureAtlasSprite](net/minecraftforge/client/textures/UnitTextureAtlasSprite.md) · class · 4 成员

### `net.minecraftforge.common`（30）

- [BasicItemListing](net/minecraftforge/common/BasicItemListing.md) · class · 11 成员
- [BiomeManager](net/minecraftforge/common/BiomeManager.md) · class · 8 成员
- [CreativeModeTabRegistry](net/minecraftforge/common/CreativeModeTabRegistry.md) · class · 5 成员
- [DungeonHooks](net/minecraftforge/common/DungeonHooks.md) · class · 4 成员
- [FarmlandWaterManager](net/minecraftforge/common/FarmlandWaterManager.md) · class · 3 成员
- [ForgeConfig](net/minecraftforge/common/ForgeConfig.md) · class · 8 成员
- [ForgeConfigSpec](net/minecraftforge/common/ForgeConfigSpec.md) · class · 23 成员
- [ForgeHooks](net/minecraftforge/common/ForgeHooks.md) · class · 95 成员
- [ForgeI18n](net/minecraftforge/common/ForgeI18n.md) · class · 7 成员
- [ForgeInternalHandler](net/minecraftforge/common/ForgeInternalHandler.md) · class · 12 成员
- **★** [ForgeMod](net/minecraftforge/common/ForgeMod.md) · class · 40 成员
- [ForgeSpawnEggItem](net/minecraftforge/common/ForgeSpawnEggItem.md) · class · 5 成员
- [ForgeStatesProvider](net/minecraftforge/common/ForgeStatesProvider.md) · class · 1 成员
- [ForgeTier](net/minecraftforge/common/ForgeTier.md) · class · 9 成员
- [IExtensibleEnum](net/minecraftforge/common/IExtensibleEnum.md) · interface · 1 成员
- [IForgeShearable](net/minecraftforge/common/IForgeShearable.md) · interface · 2 成员
- [IMinecartCollisionHandler](net/minecraftforge/common/IMinecartCollisionHandler.md) · interface · 4 成员
- [IPlantable](net/minecraftforge/common/IPlantable.md) · interface · 2 成员
- [LenientUnboundedMapCodec](net/minecraftforge/common/LenientUnboundedMapCodec.md) · class · 9 成员
- **★** [MinecraftForge](net/minecraftforge/common/MinecraftForge.md) · class · 4 成员
- [PlantType](net/minecraftforge/common/PlantType.md) · class · 9 成员
- [SoundAction](net/minecraftforge/common/SoundAction.md) · class · 3 成员
- [SoundActions](net/minecraftforge/common/SoundActions.md) · class · 3 成员
- [Tags](net/minecraftforge/common/Tags.md) · class · 6 成员
- [TierSortingRegistry](net/minecraftforge/common/TierSortingRegistry.md) · class · 7 成员
- [ToolAction](net/minecraftforge/common/ToolAction.md) · class · 4 成员
- [ToolActions](net/minecraftforge/common/ToolActions.md) · class · 25 成员
- [UsernameCache](net/minecraftforge/common/UsernameCache.md) · class · 7 成员
- [VillagerTradingManager](net/minecraftforge/common/VillagerTradingManager.md) · class · 0 成员
- [WorldWorkerManager](net/minecraftforge/common/WorldWorkerManager.md) · class · 4 成员

### `net.minecraftforge.common.brewing`（5）

- [BrewingRecipe](net/minecraftforge/common/brewing/BrewingRecipe.md) · class · 7 成员
- [BrewingRecipeRegistry](net/minecraftforge/common/brewing/BrewingRecipeRegistry.md) · class · 9 成员
- [IBrewingRecipe](net/minecraftforge/common/brewing/IBrewingRecipe.md) · interface · 3 成员
- [VanillaBrewingRecipe](net/minecraftforge/common/brewing/VanillaBrewingRecipe.md) · class · 3 成员
- [package-info](net/minecraftforge/common/brewing/package-info.md) · class · 0 成员

### `net.minecraftforge.common.capabilities`（11）

- [AutoRegisterCapability](net/minecraftforge/common/capabilities/AutoRegisterCapability.md) · @interface · 0 成员
- [Capability](net/minecraftforge/common/capabilities/Capability.md) · class · 3 成员
- [CapabilityDispatcher](net/minecraftforge/common/capabilities/CapabilityDispatcher.md) · class · 7 成员
- [CapabilityManager](net/minecraftforge/common/capabilities/CapabilityManager.md) · enum · 3 成员
- [CapabilityProvider](net/minecraftforge/common/capabilities/CapabilityProvider.md) · class · 14 成员
- [CapabilityToken](net/minecraftforge/common/capabilities/CapabilityToken.md) · class · 2 成员
- [ForgeCapabilities](net/minecraftforge/common/capabilities/ForgeCapabilities.md) · class · 4 成员
- [ICapabilityProvider](net/minecraftforge/common/capabilities/ICapabilityProvider.md) · interface · 0 成员
- [ICapabilityProviderImpl](net/minecraftforge/common/capabilities/ICapabilityProviderImpl.md) · interface · 4 成员
- [ICapabilitySerializable](net/minecraftforge/common/capabilities/ICapabilitySerializable.md) · interface · 0 成员
- [RegisterCapabilitiesEvent](net/minecraftforge/common/capabilities/RegisterCapabilitiesEvent.md) · class · 1 成员

### `net.minecraftforge.common.command`（2）

- [EntitySelectorManager](net/minecraftforge/common/command/EntitySelectorManager.md) · class · 3 成员
- [IEntitySelectorType](net/minecraftforge/common/command/IEntitySelectorType.md) · interface · 2 成员

### `net.minecraftforge.common.crafting`（15）

- [AbstractIngredient](net/minecraftforge/common/crafting/AbstractIngredient.md) · class · 13 成员
- [CompoundIngredient](net/minecraftforge/common/crafting/CompoundIngredient.md) · class · 12 成员
- [ConditionalAdvancement](net/minecraftforge/common/crafting/ConditionalAdvancement.md) · class · 3 成员
- [ConditionalRecipe](net/minecraftforge/common/crafting/ConditionalRecipe.md) · class · 4 成员
- [CraftingHelper](net/minecraftforge/common/crafting/CraftingHelper.md) · class · 15 成员
- [DifferenceIngredient](net/minecraftforge/common/crafting/DifferenceIngredient.md) · class · 11 成员
- [IIngredientSerializer](net/minecraftforge/common/crafting/IIngredientSerializer.md) · interface · 3 成员
- [IRecipeContainer](net/minecraftforge/common/crafting/IRecipeContainer.md) · interface · 2 成员
- [IShapedRecipe](net/minecraftforge/common/crafting/IShapedRecipe.md) · interface · 2 成员
- [IntersectionIngredient](net/minecraftforge/common/crafting/IntersectionIngredient.md) · class · 11 成员
- [MultiItemValue](net/minecraftforge/common/crafting/MultiItemValue.md) · class · 3 成员
- [PartialNBTIngredient](net/minecraftforge/common/crafting/PartialNBTIngredient.md) · class · 8 成员
- [StrictNBTIngredient](net/minecraftforge/common/crafting/StrictNBTIngredient.md) · class · 7 成员
- [VanillaIngredientSerializer](net/minecraftforge/common/crafting/VanillaIngredientSerializer.md) · class · 4 成员
- [package-info](net/minecraftforge/common/crafting/package-info.md) · class · 0 成员

### `net.minecraftforge.common.crafting.conditions`（12）

- [AndCondition](net/minecraftforge/common/crafting/conditions/AndCondition.md) · class · 5 成员
- [ConditionContext](net/minecraftforge/common/crafting/conditions/ConditionContext.md) · class · 2 成员
- [FalseCondition](net/minecraftforge/common/crafting/conditions/FalseCondition.md) · class · 5 成员
- [ICondition](net/minecraftforge/common/crafting/conditions/ICondition.md) · interface · 3 成员
- [IConditionBuilder](net/minecraftforge/common/crafting/conditions/IConditionBuilder.md) · interface · 8 成员
- [IConditionSerializer](net/minecraftforge/common/crafting/conditions/IConditionSerializer.md) · interface · 4 成员
- [ItemExistsCondition](net/minecraftforge/common/crafting/conditions/ItemExistsCondition.md) · class · 7 成员
- [ModLoadedCondition](net/minecraftforge/common/crafting/conditions/ModLoadedCondition.md) · class · 5 成员
- [NotCondition](net/minecraftforge/common/crafting/conditions/NotCondition.md) · class · 5 成员
- [OrCondition](net/minecraftforge/common/crafting/conditions/OrCondition.md) · class · 5 成员
- [TagEmptyCondition](net/minecraftforge/common/crafting/conditions/TagEmptyCondition.md) · class · 7 成员
- [TrueCondition](net/minecraftforge/common/crafting/conditions/TrueCondition.md) · class · 5 成员

### `net.minecraftforge.common.data`（21）

- [BlockTagsProvider](net/minecraftforge/common/data/BlockTagsProvider.md) · class · 1 成员
- [DatapackBuiltinEntriesProvider](net/minecraftforge/common/data/DatapackBuiltinEntriesProvider.md) · class · 2 成员
- [ExistingFileHelper](net/minecraftforge/common/data/ExistingFileHelper.md) · class · 12 成员
- [ForgeAdvancementProvider](net/minecraftforge/common/data/ForgeAdvancementProvider.md) · class · 2 成员
- [ForgeBiomeTagsProvider](net/minecraftforge/common/data/ForgeBiomeTagsProvider.md) · class · 3 成员
- [ForgeBlockTagsProvider](net/minecraftforge/common/data/ForgeBlockTagsProvider.md) · class · 3 成员
- [ForgeEntityTypeTagsProvider](net/minecraftforge/common/data/ForgeEntityTypeTagsProvider.md) · class · 3 成员
- [ForgeFluidTagsProvider](net/minecraftforge/common/data/ForgeFluidTagsProvider.md) · class · 3 成员
- [ForgeItemTagsProvider](net/minecraftforge/common/data/ForgeItemTagsProvider.md) · class · 3 成员
- [ForgeLootTableProvider](net/minecraftforge/common/data/ForgeLootTableProvider.md) · class · 3 成员
- [ForgeRecipeProvider](net/minecraftforge/common/data/ForgeRecipeProvider.md) · class · 4 成员
- [ForgeSpriteSourceProvider](net/minecraftforge/common/data/ForgeSpriteSourceProvider.md) · class · 2 成员
- [GlobalLootModifierProvider](net/minecraftforge/common/data/GlobalLootModifierProvider.md) · class · 6 成员
- [JsonCodecProvider](net/minecraftforge/common/data/JsonCodecProvider.md) · class · 14 成员
- [LanguageProvider](net/minecraftforge/common/data/LanguageProvider.md) · class · 19 成员
- [ParticleDescriptionProvider](net/minecraftforge/common/data/ParticleDescriptionProvider.md) · class · 10 成员
- [SoundDefinition](net/minecraftforge/common/data/SoundDefinition.md) · class · 7 成员
- [SoundDefinitionsProvider](net/minecraftforge/common/data/SoundDefinitionsProvider.md) · class · 13 成员
- [SpriteSourceProvider](net/minecraftforge/common/data/SpriteSourceProvider.md) · class · 15 成员
- [VanillaSoundDefinitionsProvider](net/minecraftforge/common/data/VanillaSoundDefinitionsProvider.md) · class · 2 成员
- [package-info](net/minecraftforge/common/data/package-info.md) · class · 0 成员

### `net.minecraftforge.common.extensions`（34）

- [IForgeAbstractMinecart](net/minecraftforge/common/extensions/IForgeAbstractMinecart.md) · interface · 23 成员
- [IForgeAdvancementBuilder](net/minecraftforge/common/extensions/IForgeAdvancementBuilder.md) · interface · 2 成员
- [IForgeBaseRailBlock](net/minecraftforge/common/extensions/IForgeBaseRailBlock.md) · interface · 5 成员
- [IForgeBlock](net/minecraftforge/common/extensions/IForgeBlock.md) · interface · 53 成员
- [IForgeBlockEntity](net/minecraftforge/common/extensions/IForgeBlockEntity.md) · interface · 10 成员
- [IForgeBlockGetter](net/minecraftforge/common/extensions/IForgeBlockGetter.md) · interface · 2 成员
- **★** [IForgeBlockState](net/minecraftforge/common/extensions/IForgeBlockState.md) · interface · 53 成员
- [IForgeBoat](net/minecraftforge/common/extensions/IForgeBoat.md) · interface · 4 成员
- [IForgeBucketPickup](net/minecraftforge/common/extensions/IForgeBucketPickup.md) · interface · 2 成员
- [IForgeCommandSourceStack](net/minecraftforge/common/extensions/IForgeCommandSourceStack.md) · interface · 5 成员
- [IForgeDispensibleContainerItem](net/minecraftforge/common/extensions/IForgeDispensibleContainerItem.md) · interface · 2 成员
- [IForgeEnchantment](net/minecraftforge/common/extensions/IForgeEnchantment.md) · interface · 3 成员
- [IForgeEntity](net/minecraftforge/common/extensions/IForgeEntity.md) · interface · 39 成员
- [IForgeFluid](net/minecraftforge/common/extensions/IForgeFluid.md) · interface · 11 成员
- [IForgeFluidState](net/minecraftforge/common/extensions/IForgeFluidState.md) · interface · 11 成员
- [IForgeFriendlyByteBuf](net/minecraftforge/common/extensions/IForgeFriendlyByteBuf.md) · interface · 9 成员
- [IForgeHolderSet](net/minecraftforge/common/extensions/IForgeHolderSet.md) · interface · 3 成员
- [IForgeIntrinsicHolderTagAppender](net/minecraftforge/common/extensions/IForgeIntrinsicHolderTagAppender.md) · interface · 13 成员
- [IForgeItem](net/minecraftforge/common/extensions/IForgeItem.md) · interface · 59 成员
- [IForgeItemStack](net/minecraftforge/common/extensions/IForgeItemStack.md) · interface · 44 成员
- [IForgeLevel](net/minecraftforge/common/extensions/IForgeLevel.md) · interface · 3 成员
- [IForgeLevelChunk](net/minecraftforge/common/extensions/IForgeLevelChunk.md) · interface · 0 成员
- [IForgeLevelSummary](net/minecraftforge/common/extensions/IForgeLevelSummary.md) · interface · 2 成员
- [IForgeLivingEntity](net/minecraftforge/common/extensions/IForgeLivingEntity.md) · interface · 6 成员
- [IForgeMenuType](net/minecraftforge/common/extensions/IForgeMenuType.md) · interface · 2 成员
- [IForgeMobEffect](net/minecraftforge/common/extensions/IForgeMobEffect.md) · interface · 3 成员
- [IForgeMobEffectInstance](net/minecraftforge/common/extensions/IForgeMobEffectInstance.md) · interface · 5 成员
- [IForgePackResources](net/minecraftforge/common/extensions/IForgePackResources.md) · interface · 1 成员
- [IForgePlayer](net/minecraftforge/common/extensions/IForgePlayer.md) · interface · 9 成员
- [IForgePotion](net/minecraftforge/common/extensions/IForgePotion.md) · interface · 2 成员
- [IForgeRawTagBuilder](net/minecraftforge/common/extensions/IForgeRawTagBuilder.md) · interface · 4 成员
- [IForgeRecipeSerializer](net/minecraftforge/common/extensions/IForgeRecipeSerializer.md) · interface · 2 成员
- [IForgeTagAppender](net/minecraftforge/common/extensions/IForgeTagAppender.md) · interface · 12 成员
- [IForgeTransformation](net/minecraftforge/common/extensions/IForgeTransformation.md) · interface · 8 成员

### `net.minecraftforge.common.loot`（5）

- [CanToolPerformAction](net/minecraftforge/common/loot/CanToolPerformAction.md) · class · 7 成员
- [IGlobalLootModifier](net/minecraftforge/common/loot/IGlobalLootModifier.md) · interface · 2 成员
- [LootModifier](net/minecraftforge/common/loot/LootModifier.md) · class · 5 成员
- [LootModifierManager](net/minecraftforge/common/loot/LootModifierManager.md) · class · 5 成员
- [LootTableIdCondition](net/minecraftforge/common/loot/LootTableIdCondition.md) · class · 7 成员

### `net.minecraftforge.common.property`（1）

- [Properties](net/minecraftforge/common/property/Properties.md) · class · 2 成员

### `net.minecraftforge.common.ticket`（5）

- [AABBTicket](net/minecraftforge/common/ticket/AABBTicket.md) · class · 3 成员
- [ChunkTicketManager](net/minecraftforge/common/ticket/ChunkTicketManager.md) · class · 5 成员
- [ITicketGetter](net/minecraftforge/common/ticket/ITicketGetter.md) · interface · 1 成员
- [ITicketManager](net/minecraftforge/common/ticket/ITicketManager.md) · interface · 2 成员
- [SimpleTicket](net/minecraftforge/common/ticket/SimpleTicket.md) · class · 10 成员

### `net.minecraftforge.common.util`（32）

- [BlockSnapshot](net/minecraftforge/common/util/BlockSnapshot.md) · class · 14 成员
- [BrainBuilder](net/minecraftforge/common/util/BrainBuilder.md) · class · 23 成员
- [CenterChunkPosComparator](net/minecraftforge/common/util/CenterChunkPosComparator.md) · class · 2 成员
- [ConcatenatedListView](net/minecraftforge/common/util/ConcatenatedListView.md) · class · 10 成员
- [DummySavedData](net/minecraftforge/common/util/DummySavedData.md) · class · 2 成员
- [FakePlayer](net/minecraftforge/common/util/FakePlayer.md) · class · 1 成员
- [FakePlayerFactory](net/minecraftforge/common/util/FakePlayerFactory.md) · class · 3 成员
- [ForgeSoundType](net/minecraftforge/common/util/ForgeSoundType.md) · class · 6 成员
- [HexDumper](net/minecraftforge/common/util/HexDumper.md) · class · 3 成员
- [INBTSerializable](net/minecraftforge/common/util/INBTSerializable.md) · interface · 2 成员
- [ITeleporter](net/minecraftforge/common/util/ITeleporter.md) · interface · 4 成员
- [ItemStackMap](net/minecraftforge/common/util/ItemStackMap.md) · class · 2 成员
- [JsonUtils](net/minecraftforge/common/util/JsonUtils.md) · class · 3 成员
- [Lazy](net/minecraftforge/common/util/Lazy.md) · interface · 2 成员
- [LazyOptional](net/minecraftforge/common/util/LazyOptional.md) · class · 15 成员
- [LevelCapabilityData](net/minecraftforge/common/util/LevelCapabilityData.md) · class · 7 成员
- [LogMessageAdapter](net/minecraftforge/common/util/LogMessageAdapter.md) · record · 6 成员
- [LogicalSidedProvider](net/minecraftforge/common/util/LogicalSidedProvider.md) · class · 5 成员
- [MavenVersionStringHelper](net/minecraftforge/common/util/MavenVersionStringHelper.md) · class · 5 成员
- [MutableHashedLinkedMap](net/minecraftforge/common/util/MutableHashedLinkedMap.md) · class · 13 成员
- [NonNullConsumer](net/minecraftforge/common/util/NonNullConsumer.md) · interface · 1 成员
- [NonNullFunction](net/minecraftforge/common/util/NonNullFunction.md) · interface · 1 成员
- [NonNullLazy](net/minecraftforge/common/util/NonNullLazy.md) · interface · 2 成员
- [NonNullPredicate](net/minecraftforge/common/util/NonNullPredicate.md) · interface · 1 成员
- [NonNullSupplier](net/minecraftforge/common/util/NonNullSupplier.md) · interface · 0 成员
- [RecipeMatcher](net/minecraftforge/common/util/RecipeMatcher.md) · class · 1 成员
- [Size2i](net/minecraftforge/common/util/Size2i.md) · class · 6 成员
- [SortedProperties](net/minecraftforge/common/util/SortedProperties.md) · class · 4 成员
- [TablePrinter](net/minecraftforge/common/util/TablePrinter.md) · class · 8 成员
- [TextTable](net/minecraftforge/common/util/TextTable.md) · class · 11 成员
- [TransformationHelper](net/minecraftforge/common/util/TransformationHelper.md) · class · 10 成员
- [TriPredicate](net/minecraftforge/common/util/TriPredicate.md) · interface · 4 成员

### `net.minecraftforge.common.world`（14）

- [BiomeGenerationSettingsBuilder](net/minecraftforge/common/world/BiomeGenerationSettingsBuilder.md) · class · 3 成员
- [BiomeModifier](net/minecraftforge/common/world/BiomeModifier.md) · interface · 1 成员
- [BiomeSpecialEffectsBuilder](net/minecraftforge/common/world/BiomeSpecialEffectsBuilder.md) · class · 15 成员
- [ClimateSettingsBuilder](net/minecraftforge/common/world/ClimateSettingsBuilder.md) · class · 11 成员
- [ForgeBiomeModifiers](net/minecraftforge/common/world/ForgeBiomeModifiers.md) · class · 4 成员
- [ForgeChunkManager](net/minecraftforge/common/world/ForgeChunkManager.md) · class · 12 成员
- [MobSpawnSettingsBuilder](net/minecraftforge/common/world/MobSpawnSettingsBuilder.md) · class · 7 成员
- [ModifiableBiomeInfo](net/minecraftforge/common/world/ModifiableBiomeInfo.md) · class · 6 成员
- [ModifiableStructureInfo](net/minecraftforge/common/world/ModifiableStructureInfo.md) · class · 6 成员
- [NoneBiomeModifier](net/minecraftforge/common/world/NoneBiomeModifier.md) · class · 3 成员
- [NoneStructureModifier](net/minecraftforge/common/world/NoneStructureModifier.md) · class · 3 成员
- [PieceBeardifierModifier](net/minecraftforge/common/world/PieceBeardifierModifier.md) · interface · 3 成员
- [StructureModifier](net/minecraftforge/common/world/StructureModifier.md) · interface · 1 成员
- [StructureSettingsBuilder](net/minecraftforge/common/world/StructureSettingsBuilder.md) · class · 12 成员

### `net.minecraftforge.data.event`（1）

- [GatherDataEvent](net/minecraftforge/data/event/GatherDataEvent.md) · class · 3 成员

### `net.minecraftforge.data.loading`（1）

- [DatagenModLoader](net/minecraftforge/data/loading/DatagenModLoader.md) · class · 2 成员

### `net.minecraftforge.energy`（3）

- [EmptyEnergyStorage](net/minecraftforge/energy/EmptyEnergyStorage.md) · class · 7 成员
- [EnergyStorage](net/minecraftforge/energy/EnergyStorage.md) · class · 16 成员
- [IEnergyStorage](net/minecraftforge/energy/IEnergyStorage.md) · interface · 6 成员

### `net.minecraftforge.entity`（2）

- [IEntityAdditionalSpawnData](net/minecraftforge/entity/IEntityAdditionalSpawnData.md) · interface · 2 成员
- [PartEntity](net/minecraftforge/entity/PartEntity.md) · class · 3 成员

### `net.minecraftforge.event`（23）

- [AddPackFindersEvent](net/minecraftforge/event/AddPackFindersEvent.md) · class · 3 成员
- [AddReloadListenerEvent](net/minecraftforge/event/AddReloadListenerEvent.md) · class · 6 成员
- [AnvilUpdateEvent](net/minecraftforge/event/AnvilUpdateEvent.md) · class · 11 成员
- [AttachCapabilitiesEvent](net/minecraftforge/event/AttachCapabilitiesEvent.md) · class · 6 成员
- [BuildCreativeModeTabContentsEvent](net/minecraftforge/event/BuildCreativeModeTabContentsEvent.md) · class · 10 成员
- [CommandEvent](net/minecraftforge/event/CommandEvent.md) · class · 5 成员
- [DifficultyChangeEvent](net/minecraftforge/event/DifficultyChangeEvent.md) · class · 3 成员
- [ForgeEventFactory](net/minecraftforge/event/ForgeEventFactory.md) · class · 106 成员
- [GameShuttingDownEvent](net/minecraftforge/event/GameShuttingDownEvent.md) · class · 1 成员
- [GrindstoneEvent](net/minecraftforge/event/GrindstoneEvent.md) · class · 7 成员
- [ItemAttributeModifierEvent](net/minecraftforge/event/ItemAttributeModifierEvent.md) · class · 9 成员
- [ItemStackedOnOtherEvent](net/minecraftforge/event/ItemStackedOnOtherEvent.md) · class · 7 成员
- [LootTableLoadEvent](net/minecraftforge/event/LootTableLoadEvent.md) · class · 4 成员
- [ModMismatchEvent](net/minecraftforge/event/ModMismatchEvent.md) · class · 14 成员
- [OnDatapackSyncEvent](net/minecraftforge/event/OnDatapackSyncEvent.md) · class · 4 成员
- [PlayLevelSoundEvent](net/minecraftforge/event/PlayLevelSoundEvent.md) · class · 14 成员
- [RegisterCommandsEvent](net/minecraftforge/event/RegisterCommandsEvent.md) · class · 4 成员
- [RegisterGameTestsEvent](net/minecraftforge/event/RegisterGameTestsEvent.md) · class · 3 成员
- [RegisterStructureConversionsEvent](net/minecraftforge/event/RegisterStructureConversionsEvent.md) · class · 2 成员
- [ServerChatEvent](net/minecraftforge/event/ServerChatEvent.md) · class · 6 成员
- [TagsUpdatedEvent](net/minecraftforge/event/TagsUpdatedEvent.md) · class · 5 成员
- **★** [TickEvent](net/minecraftforge/event/TickEvent.md) · class · 11 成员
- [VanillaGameEvent](net/minecraftforge/event/VanillaGameEvent.md) · class · 6 成员

### `net.minecraftforge.event.brewing`（2）

- [PlayerBrewedPotionEvent](net/minecraftforge/event/brewing/PlayerBrewedPotionEvent.md) · class · 2 成员
- [PotionBrewEvent](net/minecraftforge/event/brewing/PotionBrewEvent.md) · class · 6 成员

### `net.minecraftforge.event.enchanting`（1）

- [EnchantmentLevelSetEvent](net/minecraftforge/event/enchanting/EnchantmentLevelSetEvent.md) · class · 9 成员

### `net.minecraftforge.event.entity`（12）

- [EntityAttributeCreationEvent](net/minecraftforge/event/entity/EntityAttributeCreationEvent.md) · class · 2 成员
- [EntityAttributeModificationEvent](net/minecraftforge/event/entity/EntityAttributeModificationEvent.md) · class · 5 成员
- [EntityEvent](net/minecraftforge/event/entity/EntityEvent.md) · class · 6 成员
- [EntityJoinLevelEvent](net/minecraftforge/event/entity/EntityJoinLevelEvent.md) · class · 4 成员
- [EntityLeaveLevelEvent](net/minecraftforge/event/entity/EntityLeaveLevelEvent.md) · class · 2 成员
- [EntityMobGriefingEvent](net/minecraftforge/event/entity/EntityMobGriefingEvent.md) · class · 1 成员
- [EntityMountEvent](net/minecraftforge/event/entity/EntityMountEvent.md) · class · 6 成员
- [EntityStruckByLightningEvent](net/minecraftforge/event/entity/EntityStruckByLightningEvent.md) · class · 2 成员
- [EntityTeleportEvent](net/minecraftforge/event/entity/EntityTeleportEvent.md) · class · 9 成员
- [EntityTravelToDimensionEvent](net/minecraftforge/event/entity/EntityTravelToDimensionEvent.md) · class · 2 成员
- [ProjectileImpactEvent](net/minecraftforge/event/entity/ProjectileImpactEvent.md) · class · 7 成员
- [SpawnPlacementRegisterEvent](net/minecraftforge/event/entity/SpawnPlacementRegisterEvent.md) · class · 6 成员

### `net.minecraftforge.event.entity.item`（3）

- [ItemEvent](net/minecraftforge/event/entity/item/ItemEvent.md) · class · 2 成员
- [ItemExpireEvent](net/minecraftforge/event/entity/item/ItemExpireEvent.md) · class · 3 成员
- [ItemTossEvent](net/minecraftforge/event/entity/item/ItemTossEvent.md) · class · 2 成员

### `net.minecraftforge.event.entity.living`（31）

- [AnimalTameEvent](net/minecraftforge/event/entity/living/AnimalTameEvent.md) · class · 3 成员
- [BabyEntitySpawnEvent](net/minecraftforge/event/entity/living/BabyEntitySpawnEvent.md) · class · 6 成员
- [EnderManAngerEvent](net/minecraftforge/event/entity/living/EnderManAngerEvent.md) · class · 3 成员
- [LivingAttackEvent](net/minecraftforge/event/entity/living/LivingAttackEvent.md) · class · 2 成员
- [LivingBreatheEvent](net/minecraftforge/event/entity/living/LivingBreatheEvent.md) · class · 10 成员
- [LivingChangeTargetEvent](net/minecraftforge/event/entity/living/LivingChangeTargetEvent.md) · class · 7 成员
- [LivingConversionEvent](net/minecraftforge/event/entity/living/LivingConversionEvent.md) · class · 3 成员
- [LivingDamageEvent](net/minecraftforge/event/entity/living/LivingDamageEvent.md) · class · 2 成员
- **★** [LivingDeathEvent](net/minecraftforge/event/entity/living/LivingDeathEvent.md) · class · 2 成员
- [LivingDestroyBlockEvent](net/minecraftforge/event/entity/living/LivingDestroyBlockEvent.md) · class · 3 成员
- [LivingDropsEvent](net/minecraftforge/event/entity/living/LivingDropsEvent.md) · class · 5 成员
- [LivingDrownEvent](net/minecraftforge/event/entity/living/LivingDrownEvent.md) · class · 9 成员
- [LivingEntityUseItemEvent](net/minecraftforge/event/entity/living/LivingEntityUseItemEvent.md) · class · 7 成员
- [LivingEquipmentChangeEvent](net/minecraftforge/event/entity/living/LivingEquipmentChangeEvent.md) · class · 2 成员
- [LivingEvent](net/minecraftforge/event/entity/living/LivingEvent.md) · class · 5 成员
- [LivingExperienceDropEvent](net/minecraftforge/event/entity/living/LivingExperienceDropEvent.md) · class · 5 成员
- [LivingFallEvent](net/minecraftforge/event/entity/living/LivingFallEvent.md) · class · 2 成员
- [LivingGetProjectileEvent](net/minecraftforge/event/entity/living/LivingGetProjectileEvent.md) · class · 4 成员
- [LivingHealEvent](net/minecraftforge/event/entity/living/LivingHealEvent.md) · class · 3 成员
- [LivingHurtEvent](net/minecraftforge/event/entity/living/LivingHurtEvent.md) · class · 2 成员
- [LivingKnockBackEvent](net/minecraftforge/event/entity/living/LivingKnockBackEvent.md) · class · 6 成员
- [LivingMakeBrainEvent](net/minecraftforge/event/entity/living/LivingMakeBrainEvent.md) · class · 2 成员
- [LivingPackSizeEvent](net/minecraftforge/event/entity/living/LivingPackSizeEvent.md) · class · 3 成员
- [LivingSwapItemsEvent](net/minecraftforge/event/entity/living/LivingSwapItemsEvent.md) · class · 2 成员
- [LivingUseTotemEvent](net/minecraftforge/event/entity/living/LivingUseTotemEvent.md) · class · 4 成员
- [LootingLevelEvent](net/minecraftforge/event/entity/living/LootingLevelEvent.md) · class · 4 成员
- [MobEffectEvent](net/minecraftforge/event/entity/living/MobEffectEvent.md) · class · 7 成员
- [MobSpawnEvent](net/minecraftforge/event/entity/living/MobSpawnEvent.md) · class · 10 成员
- [PotionColorCalculationEvent](net/minecraftforge/event/entity/living/PotionColorCalculationEvent.md) · class · 6 成员
- [ShieldBlockEvent](net/minecraftforge/event/entity/living/ShieldBlockEvent.md) · class · 7 成员
- [ZombieEvent](net/minecraftforge/event/entity/living/ZombieEvent.md) · class · 3 成员

### `net.minecraftforge.event.entity.player`（26）

- [AdvancementEvent](net/minecraftforge/event/entity/player/AdvancementEvent.md) · class · 4 成员
- [AnvilRepairEvent](net/minecraftforge/event/entity/player/AnvilRepairEvent.md) · class · 2 成员
- [ArrowLooseEvent](net/minecraftforge/event/entity/player/ArrowLooseEvent.md) · class · 2 成员
- [ArrowNockEvent](net/minecraftforge/event/entity/player/ArrowNockEvent.md) · class · 3 成员
- [AttackEntityEvent](net/minecraftforge/event/entity/player/AttackEntityEvent.md) · class · 2 成员
- [BonemealEvent](net/minecraftforge/event/entity/player/BonemealEvent.md) · class · 5 成员
- [CriticalHitEvent](net/minecraftforge/event/entity/player/CriticalHitEvent.md) · class · 6 成员
- [EntityItemPickupEvent](net/minecraftforge/event/entity/player/EntityItemPickupEvent.md) · class · 2 成员
- [FillBucketEvent](net/minecraftforge/event/entity/player/FillBucketEvent.md) · class · 2 成员
- [ItemFishedEvent](net/minecraftforge/event/entity/player/ItemFishedEvent.md) · class · 5 成员
- [ItemTooltipEvent](net/minecraftforge/event/entity/player/ItemTooltipEvent.md) · class · 5 成员
- [PermissionsChangedEvent](net/minecraftforge/event/entity/player/PermissionsChangedEvent.md) · class · 3 成员
- [PlayerContainerEvent](net/minecraftforge/event/entity/player/PlayerContainerEvent.md) · class · 4 成员
- [PlayerDestroyItemEvent](net/minecraftforge/event/entity/player/PlayerDestroyItemEvent.md) · class · 2 成员
- **★** [PlayerEvent](net/minecraftforge/event/entity/player/PlayerEvent.md) · class · 19 成员
- [PlayerFlyableFallEvent](net/minecraftforge/event/entity/player/PlayerFlyableFallEvent.md) · class · 2 成员
- [PlayerInteractEvent](net/minecraftforge/event/entity/player/PlayerInteractEvent.md) · class · 15 成员
- [PlayerNegotiationEvent](net/minecraftforge/event/entity/player/PlayerNegotiationEvent.md) · class · 5 成员
- [PlayerSetSpawnEvent](net/minecraftforge/event/entity/player/PlayerSetSpawnEvent.md) · class · 4 成员
- [PlayerSleepInBedEvent](net/minecraftforge/event/entity/player/PlayerSleepInBedEvent.md) · class · 5 成员
- [PlayerSpawnPhantomsEvent](net/minecraftforge/event/entity/player/PlayerSpawnPhantomsEvent.md) · class · 4 成员
- [PlayerWakeUpEvent](net/minecraftforge/event/entity/player/PlayerWakeUpEvent.md) · class · 2 成员
- [PlayerXpEvent](net/minecraftforge/event/entity/player/PlayerXpEvent.md) · class · 4 成员
- [SleepingLocationCheckEvent](net/minecraftforge/event/entity/player/SleepingLocationCheckEvent.md) · class · 2 成员
- [SleepingTimeCheckEvent](net/minecraftforge/event/entity/player/SleepingTimeCheckEvent.md) · class · 2 成员
- [TradeWithVillagerEvent](net/minecraftforge/event/entity/player/TradeWithVillagerEvent.md) · class · 3 成员

### `net.minecraftforge.event.furnace`（1）

- [FurnaceFuelBurnTimeEvent](net/minecraftforge/event/furnace/FurnaceFuelBurnTimeEvent.md) · class · 5 成员

### `net.minecraftforge.event.level`（12）

- [AlterGroundEvent](net/minecraftforge/event/level/AlterGroundEvent.md) · class · 7 成员
- [BlockEvent](net/minecraftforge/event/level/BlockEvent.md) · class · 14 成员
- [ChunkDataEvent](net/minecraftforge/event/level/ChunkDataEvent.md) · class · 5 成员
- [ChunkEvent](net/minecraftforge/event/level/ChunkEvent.md) · class · 5 成员
- [ChunkTicketLevelUpdatedEvent](net/minecraftforge/event/level/ChunkTicketLevelUpdatedEvent.md) · class · 6 成员
- [ChunkWatchEvent](net/minecraftforge/event/level/ChunkWatchEvent.md) · class · 6 成员
- [ExplosionEvent](net/minecraftforge/event/level/ExplosionEvent.md) · class · 5 成员
- [LevelEvent](net/minecraftforge/event/level/LevelEvent.md) · class · 7 成员
- [NoteBlockEvent](net/minecraftforge/event/level/NoteBlockEvent.md) · class · 9 成员
- [PistonEvent](net/minecraftforge/event/level/PistonEvent.md) · class · 8 成员
- [SaplingGrowTreeEvent](net/minecraftforge/event/level/SaplingGrowTreeEvent.md) · class · 6 成员
- [SleepFinishedTimeEvent](net/minecraftforge/event/level/SleepFinishedTimeEvent.md) · class · 3 成员

### `net.minecraftforge.event.server`（6）

- [ServerAboutToStartEvent](net/minecraftforge/event/server/ServerAboutToStartEvent.md) · class · 1 成员
- [ServerLifecycleEvent](net/minecraftforge/event/server/ServerLifecycleEvent.md) · class · 3 成员
- [ServerStartedEvent](net/minecraftforge/event/server/ServerStartedEvent.md) · class · 1 成员
- [ServerStartingEvent](net/minecraftforge/event/server/ServerStartingEvent.md) · class · 1 成员
- [ServerStoppedEvent](net/minecraftforge/event/server/ServerStoppedEvent.md) · class · 1 成员
- [ServerStoppingEvent](net/minecraftforge/event/server/ServerStoppingEvent.md) · class · 1 成员

### `net.minecraftforge.event.village`（3）

- [VillageSiegeEvent](net/minecraftforge/event/village/VillageSiegeEvent.md) · class · 5 成员
- [VillagerTradesEvent](net/minecraftforge/event/village/VillagerTradesEvent.md) · class · 5 成员
- [WandererTradesEvent](net/minecraftforge/event/village/WandererTradesEvent.md) · class · 5 成员

### `net.minecraftforge.eventbus`（16）

- [ASMEventHandler](net/minecraftforge/eventbus/ASMEventHandler.md) · class · 6 成员
- [BusBuilderImpl](net/minecraftforge/eventbus/BusBuilderImpl.md) · class · 9 成员
- [ClassLoaderFactory](net/minecraftforge/eventbus/ClassLoaderFactory.md) · class · 3 成员
- [EventAccessTransformer](net/minecraftforge/eventbus/EventAccessTransformer.md) · class · 1 成员
- [EventBus](net/minecraftforge/eventbus/EventBus.md) · class · 16 成员
- [EventBusEngine](net/minecraftforge/eventbus/EventBusEngine.md) · class · 4 成员
- [EventBusErrorMessage](net/minecraftforge/eventbus/EventBusErrorMessage.md) · class · 6 成员
- [EventSubclassTransformer](net/minecraftforge/eventbus/EventSubclassTransformer.md) · class · 1 成员
- [IEventBusEngine](net/minecraftforge/eventbus/IEventBusEngine.md) · interface · 3 成员
- [IEventListenerFactory](net/minecraftforge/eventbus/IEventListenerFactory.md) · interface · 2 成员
- [ListenerList](net/minecraftforge/eventbus/ListenerList.md) · class · 9 成员
- [LockHelper](net/minecraftforge/eventbus/LockHelper.md) · class · 7 成员
- [LogMarkers](net/minecraftforge/eventbus/LogMarkers.md) · class · 0 成员
- [ModLauncherFactory](net/minecraftforge/eventbus/ModLauncherFactory.md) · class · 3 成员
- [NamedEventListener](net/minecraftforge/eventbus/NamedEventListener.md) · class · 4 成员
- [Names](net/minecraftforge/eventbus/Names.md) · class · 0 成员

### `net.minecraftforge.eventbus.api`（12）

- [BusBuilder](net/minecraftforge/eventbus/api/BusBuilder.md) · interface · 11 成员
- [Cancelable](net/minecraftforge/eventbus/api/Cancelable.md) · @interface · 0 成员
- [Event](net/minecraftforge/eventbus/api/Event.md) · class · 11 成员
- [EventListenerHelper](net/minecraftforge/eventbus/api/EventListenerHelper.md) · class · 2 成员
- **★** [EventPriority](net/minecraftforge/eventbus/api/EventPriority.md) · enum · 2 成员
- [GenericEvent](net/minecraftforge/eventbus/api/GenericEvent.md) · class · 2 成员
- **★** [IEventBus](net/minecraftforge/eventbus/api/IEventBus.md) · interface · 12 成员
- [IEventBusInvokeDispatcher](net/minecraftforge/eventbus/api/IEventBusInvokeDispatcher.md) · interface · 1 成员
- [IEventExceptionHandler](net/minecraftforge/eventbus/api/IEventExceptionHandler.md) · interface · 1 成员
- [IEventListener](net/minecraftforge/eventbus/api/IEventListener.md) · interface · 2 成员
- [IGenericEvent](net/minecraftforge/eventbus/api/IGenericEvent.md) · interface · 1 成员
- **★** [SubscribeEvent](net/minecraftforge/eventbus/api/SubscribeEvent.md) · @interface · 2 成员

### `net.minecraftforge.eventbus.service`（1）

- [ModLauncherService](net/minecraftforge/eventbus/service/ModLauncherService.md) · class · 4 成员

### `net.minecraftforge.fluids`（9）

- [DispenseFluidContainer](net/minecraftforge/fluids/DispenseFluidContainer.md) · class · 2 成员
- [FluidActionResult](net/minecraftforge/fluids/FluidActionResult.md) · class · 6 成员
- [FluidInteractionRegistry](net/minecraftforge/fluids/FluidInteractionRegistry.md) · class · 5 成员
- [FluidStack](net/minecraftforge/fluids/FluidStack.md) · class · 34 成员
- [FluidType](net/minecraftforge/fluids/FluidType.md) · class · 60 成员
- [FluidUtil](net/minecraftforge/fluids/FluidUtil.md) · class · 16 成员
- [ForgeFlowingFluid](net/minecraftforge/fluids/ForgeFlowingFluid.md) · class · 19 成员
- [IFluidBlock](net/minecraftforge/fluids/IFluidBlock.md) · interface · 5 成员
- [IFluidTank](net/minecraftforge/fluids/IFluidTank.md) · interface · 7 成员

### `net.minecraftforge.fluids.capability`（4）

- [FluidHandlerBlockEntity](net/minecraftforge/fluids/capability/FluidHandlerBlockEntity.md) · class · 5 成员
- [IFluidHandler](net/minecraftforge/fluids/capability/IFluidHandler.md) · interface · 7 成员
- [IFluidHandlerItem](net/minecraftforge/fluids/capability/IFluidHandlerItem.md) · interface · 1 成员
- [ItemFluidContainer](net/minecraftforge/fluids/capability/ItemFluidContainer.md) · class · 3 成员

### `net.minecraftforge.fluids.capability.templates`（5）

- [EmptyFluidHandler](net/minecraftforge/fluids/capability/templates/EmptyFluidHandler.md) · class · 4 成员
- [FluidHandlerItemStack](net/minecraftforge/fluids/capability/templates/FluidHandlerItemStack.md) · class · 20 成员
- [FluidHandlerItemStackSimple](net/minecraftforge/fluids/capability/templates/FluidHandlerItemStackSimple.md) · class · 20 成员
- [FluidTank](net/minecraftforge/fluids/capability/templates/FluidTank.md) · class · 24 成员
- [VoidFluidHandler](net/minecraftforge/fluids/capability/templates/VoidFluidHandler.md) · class · 4 成员

### `net.minecraftforge.fluids.capability.wrappers`（4）

- [BlockWrapper](net/minecraftforge/fluids/capability/wrappers/BlockWrapper.md) · class · 6 成员
- [BucketPickupHandlerWrapper](net/minecraftforge/fluids/capability/wrappers/BucketPickupHandlerWrapper.md) · class · 11 成员
- [FluidBlockWrapper](net/minecraftforge/fluids/capability/wrappers/FluidBlockWrapper.md) · class · 11 成员
- [FluidBucketWrapper](net/minecraftforge/fluids/capability/wrappers/FluidBucketWrapper.md) · class · 14 成员

### `net.minecraftforge.fml`（30）

- [Bindings](net/minecraftforge/fml/Bindings.md) · class · 3 成员
- [CrashReportCallables](net/minecraftforge/fml/CrashReportCallables.md) · class · 4 成员
- [DeferredWorkQueue](net/minecraftforge/fml/DeferredWorkQueue.md) · class · 5 成员
- **★** [DistExecutor](net/minecraftforge/fml/DistExecutor.md) · class · 10 成员
- [I18NParser](net/minecraftforge/fml/I18NParser.md) · interface · 2 成员
- [IBindingsProvider](net/minecraftforge/fml/IBindingsProvider.md) · interface · 3 成员
- [IExtensionPoint](net/minecraftforge/fml/IExtensionPoint.md) · interface · 1 成员
- [IModLoadingState](net/minecraftforge/fml/IModLoadingState.md) · interface · 8 成员
- [IModStateProvider](net/minecraftforge/fml/IModStateProvider.md) · interface · 1 成员
- [IModStateTransition](net/minecraftforge/fml/IModStateTransition.md) · interface · 11 成员
- [ISystemReportExtender](net/minecraftforge/fml/ISystemReportExtender.md) · interface · 2 成员
- [InterModComms](net/minecraftforge/fml/InterModComms.md) · class · 5 成员
- [LoadingFailedException](net/minecraftforge/fml/LoadingFailedException.md) · class · 3 成员
- [Logging](net/minecraftforge/fml/Logging.md) · class · 7 成员
- [LogicalSide](net/minecraftforge/fml/LogicalSide.md) · enum · 3 成员
- [ModContainer](net/minecraftforge/fml/ModContainer.md) · class · 26 成员
- [ModList](net/minecraftforge/fml/ModList.md) · class · 16 成员
- [ModLoader](net/minecraftforge/fml/ModLoader.md) · class · 14 成员
- [ModLoadingContext](net/minecraftforge/fml/ModLoadingContext.md) · class · 13 成员
- [ModLoadingException](net/minecraftforge/fml/ModLoadingException.md) · class · 7 成员
- [ModLoadingPhase](net/minecraftforge/fml/ModLoadingPhase.md) · enum · 1 成员
- [ModLoadingStage](net/minecraftforge/fml/ModLoadingStage.md) · enum · 3 成员
- [ModLoadingState](net/minecraftforge/fml/ModLoadingState.md) · record · 5 成员
- [ModLoadingWarning](net/minecraftforge/fml/ModLoadingWarning.md) · class · 2 成员
- [ModStateManager](net/minecraftforge/fml/ModStateManager.md) · class · 3 成员
- [ModWorkManager](net/minecraftforge/fml/ModWorkManager.md) · class · 4 成员
- [OptionalMod](net/minecraftforge/fml/OptionalMod.md) · class · 13 成员
- [StartupMessageManager](net/minecraftforge/fml/StartupMessageManager.md) · class · 5 成员
- [ThreadSelector](net/minecraftforge/fml/ThreadSelector.md) · enum · 1 成员
- [VersionChecker](net/minecraftforge/fml/VersionChecker.md) · class · 3 成员

### `net.minecraftforge.fml.common`（1）

- **★** [Mod](net/minecraftforge/fml/common/Mod.md) · @interface · 1 成员

### `net.minecraftforge.fml.common.asm`（3）

- [CapabilityTokenSubclass](net/minecraftforge/fml/common/asm/CapabilityTokenSubclass.md) · class · 3 成员
- [ObjectHolderDefinalize](net/minecraftforge/fml/common/asm/ObjectHolderDefinalize.md) · class · 3 成员
- [RuntimeEnumExtender](net/minecraftforge/fml/common/asm/RuntimeEnumExtender.md) · class · 3 成员

### `net.minecraftforge.fml.config`（5）

- [ConfigFileTypeHandler](net/minecraftforge/fml/config/ConfigFileTypeHandler.md) · class · 4 成员
- [ConfigTracker](net/minecraftforge/fml/config/ConfigTracker.md) · class · 7 成员
- [IConfigEvent](net/minecraftforge/fml/config/IConfigEvent.md) · interface · 4 成员
- [IConfigSpec](net/minecraftforge/fml/config/IConfigSpec.md) · interface · 6 成员
- [ModConfig](net/minecraftforge/fml/config/ModConfig.md) · class · 12 成员

### `net.minecraftforge.fml.core`（2）

- [ModStateProvider](net/minecraftforge/fml/core/ModStateProvider.md) · class · 1 成员
- [ParallelTransition](net/minecraftforge/fml/core/ParallelTransition.md) · record · 5 成员

### `net.minecraftforge.fml.event`（1）

- [IModBusEvent](net/minecraftforge/fml/event/IModBusEvent.md) · interface · 0 成员

### `net.minecraftforge.fml.event.config`（1）

- [ModConfigEvent](net/minecraftforge/fml/event/config/ModConfigEvent.md) · class · 4 成员

### `net.minecraftforge.fml.event.lifecycle`（9）

- [FMLClientSetupEvent](net/minecraftforge/fml/event/lifecycle/FMLClientSetupEvent.md) · class · 1 成员
- [FMLCommonSetupEvent](net/minecraftforge/fml/event/lifecycle/FMLCommonSetupEvent.md) · class · 1 成员
- [FMLConstructModEvent](net/minecraftforge/fml/event/lifecycle/FMLConstructModEvent.md) · class · 1 成员
- [FMLDedicatedServerSetupEvent](net/minecraftforge/fml/event/lifecycle/FMLDedicatedServerSetupEvent.md) · class · 1 成员
- [FMLLoadCompleteEvent](net/minecraftforge/fml/event/lifecycle/FMLLoadCompleteEvent.md) · class · 1 成员
- [InterModEnqueueEvent](net/minecraftforge/fml/event/lifecycle/InterModEnqueueEvent.md) · class · 1 成员
- [InterModProcessEvent](net/minecraftforge/fml/event/lifecycle/InterModProcessEvent.md) · class · 1 成员
- [ModLifecycleEvent](net/minecraftforge/fml/event/lifecycle/ModLifecycleEvent.md) · class · 5 成员
- [ParallelDispatchEvent](net/minecraftforge/fml/event/lifecycle/ParallelDispatchEvent.md) · class · 3 成员

### `net.minecraftforge.fml.javafmlmod`（4）

- [AutomaticEventSubscriber](net/minecraftforge/fml/javafmlmod/AutomaticEventSubscriber.md) · class · 1 成员
- [FMLJavaModLanguageProvider](net/minecraftforge/fml/javafmlmod/FMLJavaModLanguageProvider.md) · class · 4 成员
- **★** [FMLJavaModLoadingContext](net/minecraftforge/fml/javafmlmod/FMLJavaModLoadingContext.md) · class · 3 成员
- [FMLModContainer](net/minecraftforge/fml/javafmlmod/FMLModContainer.md) · class · 5 成员

### `net.minecraftforge.fml.loading`（30）

- [BackgroundWaiter](net/minecraftforge/fml/loading/BackgroundWaiter.md) · class · 1 成员
- [ClasspathLocatorUtils](net/minecraftforge/fml/loading/ClasspathLocatorUtils.md) · class · 1 成员
- [ClasspathTransformerDiscoverer](net/minecraftforge/fml/loading/ClasspathTransformerDiscoverer.md) · class · 3 成员
- [EarlyLoadingException](net/minecraftforge/fml/loading/EarlyLoadingException.md) · class · 3 成员
- [FMLConfig](net/minecraftforge/fml/loading/FMLConfig.md) · class · 8 成员
- **★** [FMLEnvironment](net/minecraftforge/fml/loading/FMLEnvironment.md) · class · 5 成员
- [FMLLoader](net/minecraftforge/fml/loading/FMLLoader.md) · class · 21 成员
- **★** [FMLPaths](net/minecraftforge/fml/loading/FMLPaths.md) · enum · 6 成员
- [FMLServiceProvider](net/minecraftforge/fml/loading/FMLServiceProvider.md) · class · 9 成员
- [FileUtils](net/minecraftforge/fml/loading/FileUtils.md) · class · 2 成员
- [ImmediateWindowHandler](net/minecraftforge/fml/loading/ImmediateWindowHandler.md) · class · 9 成员
- [ImmediateWindowProvider](net/minecraftforge/fml/loading/ImmediateWindowProvider.md) · interface · 9 成员
- [JarVersionLookupHandler](net/minecraftforge/fml/loading/JarVersionLookupHandler.md) · class · 5 成员
- [LanguageLoadingProvider](net/minecraftforge/fml/loading/LanguageLoadingProvider.md) · class · 4 成员
- [LauncherVersion](net/minecraftforge/fml/loading/LauncherVersion.md) · class · 1 成员
- [LibraryFinder](net/minecraftforge/fml/loading/LibraryFinder.md) · class · 2 成员
- [LoadingModList](net/minecraftforge/fml/loading/LoadingModList.md) · class · 13 成员
- [LogMarkers](net/minecraftforge/fml/loading/LogMarkers.md) · class · 4 成员
- [MCPNamingService](net/minecraftforge/fml/loading/MCPNamingService.md) · class · 4 成员
- [MavenCoordinateResolver](net/minecraftforge/fml/loading/MavenCoordinateResolver.md) · class · 2 成员
- [ModDirTransformerDiscoverer](net/minecraftforge/fml/loading/ModDirTransformerDiscoverer.md) · class · 4 成员
- [ModJarURLHandler](net/minecraftforge/fml/loading/ModJarURLHandler.md) · class · 3 成员
- [ModSorter](net/minecraftforge/fml/loading/ModSorter.md) · class · 1 成员
- [RuntimeDistCleaner](net/minecraftforge/fml/loading/RuntimeDistCleaner.md) · class · 4 成员
- [StringSubstitutor](net/minecraftforge/fml/loading/StringSubstitutor.md) · class · 1 成员
- [StringUtils](net/minecraftforge/fml/loading/StringUtils.md) · class · 6 成员
- [TracingPrintStream](net/minecraftforge/fml/loading/TracingPrintStream.md) · class · 10 成员
- [UniqueModListBuilder](net/minecraftforge/fml/loading/UniqueModListBuilder.md) · class · 2 成员
- [VersionInfo](net/minecraftforge/fml/loading/VersionInfo.md) · record · 2 成员
- [VersionSupportMatrix](net/minecraftforge/fml/loading/VersionSupportMatrix.md) · class · 1 成员

### `net.minecraftforge.fml.loading.log4j`（2）

- [ForgeHighlight](net/minecraftforge/fml/loading/log4j/ForgeHighlight.md) · class · 2 成员
- [SLF4JFixerLaunchPluginService](net/minecraftforge/fml/loading/log4j/SLF4JFixerLaunchPluginService.md) · class · 3 成员

### `net.minecraftforge.fml.loading.moddiscovery`（29）

- [AbstractJarFileDependencyLocator](net/minecraftforge/fml/loading/moddiscovery/AbstractJarFileDependencyLocator.md) · class · 3 成员
- [AbstractJarFileModLocator](net/minecraftforge/fml/loading/moddiscovery/AbstractJarFileModLocator.md) · class · 2 成员
- [AbstractJarFileModProvider](net/minecraftforge/fml/loading/moddiscovery/AbstractJarFileModProvider.md) · class · 1 成员
- [AbstractModProvider](net/minecraftforge/fml/loading/moddiscovery/AbstractModProvider.md) · class · 7 成员
- [BackgroundScanHandler](net/minecraftforge/fml/loading/moddiscovery/BackgroundScanHandler.md) · class · 6 成员
- [ClasspathLocator](net/minecraftforge/fml/loading/moddiscovery/ClasspathLocator.md) · class · 3 成员
- [CoreModFile](net/minecraftforge/fml/loading/moddiscovery/CoreModFile.md) · class · 5 成员
- [ExplodedDirectoryLocator](net/minecraftforge/fml/loading/moddiscovery/ExplodedDirectoryLocator.md) · class · 7 成员
- [InvalidModFileException](net/minecraftforge/fml/loading/moddiscovery/InvalidModFileException.md) · class · 2 成员
- [InvalidModIdentifier](net/minecraftforge/fml/loading/moddiscovery/InvalidModIdentifier.md) · enum · 1 成员
- [JarInJarDependencyLocator](net/minecraftforge/fml/loading/moddiscovery/JarInJarDependencyLocator.md) · class · 7 成员
- [MavenDirectoryLocator](net/minecraftforge/fml/loading/moddiscovery/MavenDirectoryLocator.md) · class · 4 成员
- [MinecraftLocator](net/minecraftforge/fml/loading/moddiscovery/MinecraftLocator.md) · class · 4 成员
- [ModAnnotation](net/minecraftforge/fml/loading/moddiscovery/ModAnnotation.md) · class · 14 成员
- [ModAnnotationVisitor](net/minecraftforge/fml/loading/moddiscovery/ModAnnotationVisitor.md) · class · 8 成员
- [ModClassVisitor](net/minecraftforge/fml/loading/moddiscovery/ModClassVisitor.md) · class · 6 成员
- [ModDiscoverer](net/minecraftforge/fml/loading/moddiscovery/ModDiscoverer.md) · class · 2 成员
- [ModFieldVisitor](net/minecraftforge/fml/loading/moddiscovery/ModFieldVisitor.md) · class · 2 成员
- [ModFile](net/minecraftforge/fml/loading/moddiscovery/ModFile.md) · class · 26 成员
- [ModFileInfo](net/minecraftforge/fml/loading/moddiscovery/ModFileInfo.md) · class · 18 成员
- [ModFileParser](net/minecraftforge/fml/loading/moddiscovery/ModFileParser.md) · class · 3 成员
- [ModInfo](net/minecraftforge/fml/loading/moddiscovery/ModInfo.md) · class · 17 成员
- [ModJarMetadata](net/minecraftforge/fml/loading/moddiscovery/ModJarMetadata.md) · class · 8 成员
- [ModListHandler](net/minecraftforge/fml/loading/moddiscovery/ModListHandler.md) · class · 1 成员
- [ModMethodVisitor](net/minecraftforge/fml/loading/moddiscovery/ModMethodVisitor.md) · class · 2 成员
- [ModValidator](net/minecraftforge/fml/loading/moddiscovery/ModValidator.md) · class · 5 成员
- [ModsFolderLocator](net/minecraftforge/fml/loading/moddiscovery/ModsFolderLocator.md) · class · 5 成员
- [NightConfigWrapper](net/minecraftforge/fml/loading/moddiscovery/NightConfigWrapper.md) · class · 3 成员
- [Scanner](net/minecraftforge/fml/loading/moddiscovery/Scanner.md) · class · 2 成员

### `net.minecraftforge.fml.loading.progress`（3）

- [Message](net/minecraftforge/fml/loading/progress/Message.md) · class · 3 成员
- [ProgressMeter](net/minecraftforge/fml/loading/progress/ProgressMeter.md) · class · 10 成员
- [StartupNotificationManager](net/minecraftforge/fml/loading/progress/StartupNotificationManager.md) · class · 9 成员

### `net.minecraftforge.fml.loading.targets`（25）

- [ArgumentList](net/minecraftforge/fml/loading/targets/ArgumentList.md) · class · 10 成员
- [CommonClientLaunchHandler](net/minecraftforge/fml/loading/targets/CommonClientLaunchHandler.md) · class · 3 成员
- [CommonDevLaunchHandler](net/minecraftforge/fml/loading/targets/CommonDevLaunchHandler.md) · class · 7 成员
- [CommonLaunchHandler](net/minecraftforge/fml/loading/targets/CommonLaunchHandler.md) · class · 15 成员
- [CommonServerLaunchHandler](net/minecraftforge/fml/loading/targets/CommonServerLaunchHandler.md) · class · 3 成员
- [CommonUserdevLaunchHandler](net/minecraftforge/fml/loading/targets/CommonUserdevLaunchHandler.md) · class · 2 成员
- [FMLClientDevLaunchHandler](net/minecraftforge/fml/loading/targets/FMLClientDevLaunchHandler.md) · class · 1 成员
- [FMLClientLaunchHandler](net/minecraftforge/fml/loading/targets/FMLClientLaunchHandler.md) · class · 1 成员
- [FMLClientUserdevLaunchHandler](net/minecraftforge/fml/loading/targets/FMLClientUserdevLaunchHandler.md) · class · 1 成员
- [FMLDataUserdevLaunchHandler](net/minecraftforge/fml/loading/targets/FMLDataUserdevLaunchHandler.md) · class · 1 成员
- [FMLServerDevLaunchHandler](net/minecraftforge/fml/loading/targets/FMLServerDevLaunchHandler.md) · class · 1 成员
- [FMLServerLaunchHandler](net/minecraftforge/fml/loading/targets/FMLServerLaunchHandler.md) · class · 1 成员
- [FMLServerUserdevLaunchHandler](net/minecraftforge/fml/loading/targets/FMLServerUserdevLaunchHandler.md) · class · 1 成员
- [FMLUserdevLaunchHandler](net/minecraftforge/fml/loading/targets/FMLUserdevLaunchHandler.md) · class · 1 成员
- [ForgeClientDevLaunchHandler](net/minecraftforge/fml/loading/targets/ForgeClientDevLaunchHandler.md) · class · 1 成员
- [ForgeClientLaunchHandler](net/minecraftforge/fml/loading/targets/ForgeClientLaunchHandler.md) · class · 1 成员
- [ForgeClientUserdevLaunchHandler](net/minecraftforge/fml/loading/targets/ForgeClientUserdevLaunchHandler.md) · class · 1 成员
- [ForgeDataDevLaunchHandler](net/minecraftforge/fml/loading/targets/ForgeDataDevLaunchHandler.md) · class · 1 成员
- [ForgeDataUserdevLaunchHandler](net/minecraftforge/fml/loading/targets/ForgeDataUserdevLaunchHandler.md) · class · 1 成员
- [ForgeGametestDevLaunchHandler](net/minecraftforge/fml/loading/targets/ForgeGametestDevLaunchHandler.md) · class · 1 成员
- [ForgeGametestUserdevLaunchHandler](net/minecraftforge/fml/loading/targets/ForgeGametestUserdevLaunchHandler.md) · class · 1 成员
- [ForgeServerDevLaunchHandler](net/minecraftforge/fml/loading/targets/ForgeServerDevLaunchHandler.md) · class · 1 成员
- [ForgeServerLaunchHandler](net/minecraftforge/fml/loading/targets/ForgeServerLaunchHandler.md) · class · 1 成员
- [ForgeServerUserdevLaunchHandler](net/minecraftforge/fml/loading/targets/ForgeServerUserdevLaunchHandler.md) · class · 1 成员
- [ForgeUserdevLaunchHandler](net/minecraftforge/fml/loading/targets/ForgeUserdevLaunchHandler.md) · class · 1 成员

### `net.minecraftforge.fml.loading.toposort`（3）

- [CyclePresentException](net/minecraftforge/fml/loading/toposort/CyclePresentException.md) · class · 1 成员
- [StronglyConnectedComponentDetector](net/minecraftforge/fml/loading/toposort/StronglyConnectedComponentDetector.md) · class · 2 成员
- [TopologicalSort](net/minecraftforge/fml/loading/toposort/TopologicalSort.md) · class · 1 成员

### `net.minecraftforge.fml.server`（1）

- [ServerMain](net/minecraftforge/fml/server/ServerMain.md) · class · 1 成员

### `net.minecraftforge.fml.util`（5）

- [CertificateHelper](net/minecraftforge/fml/util/CertificateHelper.md) · class · 3 成员
- [EnhancedRuntimeException](net/minecraftforge/fml/util/EnhancedRuntimeException.md) · class · 5 成员
- [LoaderException](net/minecraftforge/fml/util/LoaderException.md) · class · 4 成员
- [LoaderExceptionModCrash](net/minecraftforge/fml/util/LoaderExceptionModCrash.md) · class · 2 成员
- [ObfuscationReflectionHelper](net/minecraftforge/fml/util/ObfuscationReflectionHelper.md) · class · 10 成员

### `net.minecraftforge.fml.util.thread`（3）

- [EffectiveSide](net/minecraftforge/fml/util/thread/EffectiveSide.md) · class · 1 成员
- [SidedThreadGroup](net/minecraftforge/fml/util/thread/SidedThreadGroup.md) · class · 2 成员
- [SidedThreadGroups](net/minecraftforge/fml/util/thread/SidedThreadGroups.md) · class · 2 成员

### `net.minecraftforge.forge.snapshots`（2）

- [ForgeSnapshotsMod](net/minecraftforge/forge/snapshots/ForgeSnapshotsMod.md) · class · 3 成员
- [ForgeSnapshotsModClient](net/minecraftforge/forge/snapshots/ForgeSnapshotsModClient.md) · class · 1 成员

### `net.minecraftforge.forgespi`（1）

- [Environment](net/minecraftforge/forgespi/Environment.md) · class · 5 成员

### `net.minecraftforge.forgespi.coremod`（2）

- [ICoreModFile](net/minecraftforge/forgespi/coremod/ICoreModFile.md) · interface · 4 成员
- [ICoreModProvider](net/minecraftforge/forgespi/coremod/ICoreModProvider.md) · interface · 1 成员

### `net.minecraftforge.forgespi.language`（7）

- [IConfigurable](net/minecraftforge/forgespi/language/IConfigurable.md) · interface · 2 成员
- [ILifecycleEvent](net/minecraftforge/forgespi/language/ILifecycleEvent.md) · interface · 1 成员
- [IModFileInfo](net/minecraftforge/forgespi/language/IModFileInfo.md) · interface · 5 成员
- [IModInfo](net/minecraftforge/forgespi/language/IModInfo.md) · interface · 8 成员
- [IModLanguageProvider](net/minecraftforge/forgespi/language/IModLanguageProvider.md) · interface · 3 成员
- [MavenVersionAdapter](net/minecraftforge/forgespi/language/MavenVersionAdapter.md) · class · 1 成员
- [ModFileScanData](net/minecraftforge/forgespi/language/ModFileScanData.md) · class · 9 成员

### `net.minecraftforge.forgespi.locating`（4）

- [IModDirectoryLocatorFactory](net/minecraftforge/forgespi/locating/IModDirectoryLocatorFactory.md) · interface · 1 成员
- [IModFile](net/minecraftforge/forgespi/locating/IModFile.md) · interface · 10 成员
- [IModLocator](net/minecraftforge/forgespi/locating/IModLocator.md) · interface · 7 成员
- [ModFileFactory](net/minecraftforge/forgespi/locating/ModFileFactory.md) · interface · 1 成员

### `net.minecraftforge.gametest`（5）

- [BlockPosValueConverter](net/minecraftforge/gametest/BlockPosValueConverter.md) · class · 3 成员
- [ForgeGameTestHooks](net/minecraftforge/gametest/ForgeGameTestHooks.md) · class · 5 成员
- [GameTestHolder](net/minecraftforge/gametest/GameTestHolder.md) · @interface · 1 成员
- [GameTestMain](net/minecraftforge/gametest/GameTestMain.md) · class · 1 成员
- [PrefixGameTestTemplate](net/minecraftforge/gametest/PrefixGameTestTemplate.md) · @interface · 1 成员

### `net.minecraftforge.items`（7）

- [IItemHandler](net/minecraftforge/items/IItemHandler.md) · interface · 6 成员
- [IItemHandlerModifiable](net/minecraftforge/items/IItemHandlerModifiable.md) · interface · 1 成员
- [ItemHandlerHelper](net/minecraftforge/items/ItemHandlerHelper.md) · class · 8 成员
- [ItemStackHandler](net/minecraftforge/items/ItemStackHandler.md) · class · 18 成员
- [SlotItemHandler](net/minecraftforge/items/SlotItemHandler.md) · class · 12 成员
- [VanillaHopperItemHandler](net/minecraftforge/items/VanillaHopperItemHandler.md) · class · 2 成员
- [VanillaInventoryCodeHooks](net/minecraftforge/items/VanillaInventoryCodeHooks.md) · class · 4 成员

### `net.minecraftforge.items.wrapper`（14）

- [CombinedInvWrapper](net/minecraftforge/items/wrapper/CombinedInvWrapper.md) · class · 14 成员
- [EmptyHandler](net/minecraftforge/items/wrapper/EmptyHandler.md) · class · 8 成员
- [EntityArmorInvWrapper](net/minecraftforge/items/wrapper/EntityArmorInvWrapper.md) · class · 1 成员
- [EntityEquipmentInvWrapper](net/minecraftforge/items/wrapper/EntityEquipmentInvWrapper.md) · class · 13 成员
- [EntityHandsInvWrapper](net/minecraftforge/items/wrapper/EntityHandsInvWrapper.md) · class · 1 成员
- [InvWrapper](net/minecraftforge/items/wrapper/InvWrapper.md) · class · 11 成员
- [PlayerArmorInvWrapper](net/minecraftforge/items/wrapper/PlayerArmorInvWrapper.md) · class · 3 成员
- [PlayerInvWrapper](net/minecraftforge/items/wrapper/PlayerInvWrapper.md) · class · 1 成员
- [PlayerMainInvWrapper](net/minecraftforge/items/wrapper/PlayerMainInvWrapper.md) · class · 3 成员
- [PlayerOffhandInvWrapper](net/minecraftforge/items/wrapper/PlayerOffhandInvWrapper.md) · class · 1 成员
- [RangedWrapper](net/minecraftforge/items/wrapper/RangedWrapper.md) · class · 8 成员
- [RecipeWrapper](net/minecraftforge/items/wrapper/RecipeWrapper.md) · class · 11 成员
- [ShulkerItemStackInvWrapper](net/minecraftforge/items/wrapper/ShulkerItemStackInvWrapper.md) · class · 9 成员
- [SidedInvWrapper](net/minecraftforge/items/wrapper/SidedInvWrapper.md) · class · 14 成员

### `net.minecraftforge.logging`（3）

- [CrashReportAnalyser](net/minecraftforge/logging/CrashReportAnalyser.md) · class · 1 成员
- [CrashReportExtender](net/minecraftforge/logging/CrashReportExtender.md) · class · 6 成员
- [PacketDump](net/minecraftforge/logging/PacketDump.md) · class · 1 成员

### `net.minecraftforge.network`（20）

- [ConfigSync](net/minecraftforge/network/ConfigSync.md) · class · 3 成员
- [ConnectionData](net/minecraftforge/network/ConnectionData.md) · class · 4 成员
- [ConnectionType](net/minecraftforge/network/ConnectionType.md) · enum · 3 成员
- [DualStackUtils](net/minecraftforge/network/DualStackUtils.md) · class · 6 成员
- [HandshakeHandler](net/minecraftforge/network/HandshakeHandler.md) · class · 5 成员
- [HandshakeMessages](net/minecraftforge/network/HandshakeMessages.md) · class · 7 成员
- [IContainerFactory](net/minecraftforge/network/IContainerFactory.md) · interface · 2 成员
- [ICustomPacket](net/minecraftforge/network/ICustomPacket.md) · interface · 5 成员
- [LoginWrapper](net/minecraftforge/network/LoginWrapper.md) · class · 1 成员
- [MCRegisterPacketHandler](net/minecraftforge/network/MCRegisterPacketHandler.md) · class · 4 成员
- [NetworkConstants](net/minecraftforge/network/NetworkConstants.md) · class · 6 成员
- [NetworkDirection](net/minecraftforge/network/NetworkDirection.md) · enum · 6 成员
- [NetworkEvent](net/minecraftforge/network/NetworkEvent.md) · class · 14 成员
- [NetworkHooks](net/minecraftforge/network/NetworkHooks.md) · class · 19 成员
- [NetworkInitialization](net/minecraftforge/network/NetworkInitialization.md) · class · 3 成员
- [NetworkInstance](net/minecraftforge/network/NetworkInstance.md) · class · 6 成员
- [NetworkRegistry](net/minecraftforge/network/NetworkRegistry.md) · class · 15 成员
- [PacketDistributor](net/minecraftforge/network/PacketDistributor.md) · class · 14 成员
- [PlayMessages](net/minecraftforge/network/PlayMessages.md) · class · 2 成员
- [ServerStatusPing](net/minecraftforge/network/ServerStatusPing.md) · record · 16 成员

### `net.minecraftforge.network.event`（1）

- [EventNetworkChannel](net/minecraftforge/network/event/EventNetworkChannel.md) · class · 5 成员

### `net.minecraftforge.network.filters`（6）

- [CommandTreeCleaner](net/minecraftforge/network/filters/CommandTreeCleaner.md) · class · 1 成员
- [ForgeConnectionNetworkFilter](net/minecraftforge/network/filters/ForgeConnectionNetworkFilter.md) · class · 2 成员
- [NetworkFilters](net/minecraftforge/network/filters/NetworkFilters.md) · class · 1 成员
- [VanillaConnectionNetworkFilter](net/minecraftforge/network/filters/VanillaConnectionNetworkFilter.md) · class · 2 成员
- [VanillaPacketFilter](net/minecraftforge/network/filters/VanillaPacketFilter.md) · class · 6 成员
- [VanillaPacketSplitter](net/minecraftforge/network/filters/VanillaPacketSplitter.md) · class · 5 成员

### `net.minecraftforge.network.simple`（2）

- [IndexedMessageCodec](net/minecraftforge/network/simple/IndexedMessageCodec.md) · class · 4 成员
- [SimpleChannel](net/minecraftforge/network/simple/SimpleChannel.md) · class · 14 成员

### `net.minecraftforge.registries`（25）

- [DataPackRegistriesHooks](net/minecraftforge/registries/DataPackRegistriesHooks.md) · class · 4 成员
- [DataPackRegistryEvent](net/minecraftforge/registries/DataPackRegistryEvent.md) · class · 1 成员
- [DeferredRegister](net/minecraftforge/registries/DeferredRegister.md) · class · 17 成员
- [ForgeDeferredRegistriesSetup](net/minecraftforge/registries/ForgeDeferredRegistriesSetup.md) · class · 1 成员
- **★** [ForgeRegistries](net/minecraftforge/registries/ForgeRegistries.md) · class · 38 成员
- [ForgeRegistry](net/minecraftforge/registries/ForgeRegistry.md) · class · 46 成员
- [ForgeRegistryTag](net/minecraftforge/registries/ForgeRegistryTag.md) · class · 10 成员
- [ForgeRegistryTagManager](net/minecraftforge/registries/ForgeRegistryTagManager.md) · class · 9 成员
- [GameData](net/minecraftforge/registries/GameData.md) · class · 15 成员
- [IForgeRegistry](net/minecraftforge/registries/IForgeRegistry.md) · interface · 8 成员
- [IForgeRegistryInternal](net/minecraftforge/registries/IForgeRegistryInternal.md) · interface · 3 成员
- [IForgeRegistryModifiable](net/minecraftforge/registries/IForgeRegistryModifiable.md) · interface · 3 成员
- [ILockableRegistry](net/minecraftforge/registries/ILockableRegistry.md) · interface · 1 成员
- [IdMappingEvent](net/minecraftforge/registries/IdMappingEvent.md) · class · 6 成员
- [MissingMappingsEvent](net/minecraftforge/registries/MissingMappingsEvent.md) · class · 7 成员
- [NamespacedDefaultedWrapper](net/minecraftforge/registries/NamespacedDefaultedWrapper.md) · class · 4 成员
- [NamespacedWrapper](net/minecraftforge/registries/NamespacedWrapper.md) · class · 36 成员
- [NewRegistryEvent](net/minecraftforge/registries/NewRegistryEvent.md) · class · 3 成员
- [ObjectHolder](net/minecraftforge/registries/ObjectHolder.md) · @interface · 2 成员
- [ObjectHolderRef](net/minecraftforge/registries/ObjectHolderRef.md) · class · 3 成员
- [ObjectHolderRegistry](net/minecraftforge/registries/ObjectHolderRegistry.md) · class · 5 成员
- [RegisterEvent](net/minecraftforge/registries/RegisterEvent.md) · class · 7 成员
- [RegistryBuilder](net/minecraftforge/registries/RegistryBuilder.md) · class · 41 成员
- [RegistryManager](net/minecraftforge/registries/RegistryManager.md) · class · 16 成员
- [RegistryObject](net/minecraftforge/registries/RegistryObject.md) · class · 21 成员

### `net.minecraftforge.registries.holdersets`（7）

- [AndHolderSet](net/minecraftforge/registries/holdersets/AndHolderSet.md) · class · 5 成员
- [AnyHolderSet](net/minecraftforge/registries/holdersets/AnyHolderSet.md) · record · 12 成员
- [CompositeHolderSet](net/minecraftforge/registries/holdersets/CompositeHolderSet.md) · class · 17 成员
- [HolderSetType](net/minecraftforge/registries/holdersets/HolderSetType.md) · interface · 0 成员
- [ICustomHolderSet](net/minecraftforge/registries/holdersets/ICustomHolderSet.md) · interface · 2 成员
- [NotHolderSet](net/minecraftforge/registries/holdersets/NotHolderSet.md) · class · 14 成员
- [OrHolderSet](net/minecraftforge/registries/holdersets/OrHolderSet.md) · class · 5 成员

### `net.minecraftforge.registries.tags`（3）

- [IReverseTag](net/minecraftforge/registries/tags/IReverseTag.md) · interface · 3 成员
- [ITag](net/minecraftforge/registries/tags/ITag.md) · interface · 7 成员
- [ITagManager](net/minecraftforge/registries/tags/ITagManager.md) · interface · 2 成员

### `net.minecraftforge.resource`（4）

- [DelegatingPackResources](net/minecraftforge/resource/DelegatingPackResources.md) · class · 8 成员
- [PathPackResources](net/minecraftforge/resource/PathPackResources.md) · class · 9 成员
- [ResourcePackLoader](net/minecraftforge/resource/ResourcePackLoader.md) · class · 6 成员
- [package-info](net/minecraftforge/resource/package-info.md) · class · 0 成员

### `net.minecraftforge.server`（2）

- [LanguageHook](net/minecraftforge/server/LanguageHook.md) · class · 2 成员
- **★** [ServerLifecycleHooks](net/minecraftforge/server/ServerLifecycleHooks.md) · class · 10 成员

### `net.minecraftforge.server.command`（15）

- [ChunkGenWorker](net/minecraftforge/server/command/ChunkGenWorker.md) · class · 7 成员
- [CommandHelper](net/minecraftforge/server/command/CommandHelper.md) · class · 1 成员
- [ConfigCommand](net/minecraftforge/server/command/ConfigCommand.md) · class · 2 成员
- [DimensionsCommand](net/minecraftforge/server/command/DimensionsCommand.md) · class · 0 成员
- [EntityCommand](net/minecraftforge/server/command/EntityCommand.md) · class · 0 成员
- [EnumArgument](net/minecraftforge/server/command/EnumArgument.md) · class · 5 成员
- [ForgeCommand](net/minecraftforge/server/command/ForgeCommand.md) · class · 1 成员
- [GenerateCommand](net/minecraftforge/server/command/GenerateCommand.md) · class · 0 成员
- [ModIdArgument](net/minecraftforge/server/command/ModIdArgument.md) · class · 4 成员
- [ModListCommand](net/minecraftforge/server/command/ModListCommand.md) · class · 0 成员
- [TPSCommand](net/minecraftforge/server/command/TPSCommand.md) · class · 0 成员
- [TagsCommand](net/minecraftforge/server/command/TagsCommand.md) · class · 1 成员
- [TextComponentHelper](net/minecraftforge/server/command/TextComponentHelper.md) · class · 1 成员
- [TrackCommand](net/minecraftforge/server/command/TrackCommand.md) · class · 0 成员
- [package-info](net/minecraftforge/server/command/package-info.md) · class · 0 成员

### `net.minecraftforge.server.console`（2）

- [ConsoleCommandCompleter](net/minecraftforge/server/console/ConsoleCommandCompleter.md) · class · 2 成员
- [TerminalHandler](net/minecraftforge/server/console/TerminalHandler.md) · class · 1 成员

### `net.minecraftforge.server.loading`（1）

- [ServerModLoader](net/minecraftforge/server/loading/ServerModLoader.md) · class · 2 成员

### `net.minecraftforge.server.permission`（2）

- [PermissionAPI](net/minecraftforge/server/permission/PermissionAPI.md) · class · 5 成员
- [package-info](net/minecraftforge/server/permission/package-info.md) · class · 0 成员

### `net.minecraftforge.server.permission.events`（1）

- [PermissionGatherEvent](net/minecraftforge/server/permission/events/PermissionGatherEvent.md) · class · 2 成员

### `net.minecraftforge.server.permission.exceptions`（1）

- [UnregisteredPermissionException](net/minecraftforge/server/permission/exceptions/UnregisteredPermissionException.md) · class · 2 成员

### `net.minecraftforge.server.permission.handler`（3）

- [DefaultPermissionHandler](net/minecraftforge/server/permission/handler/DefaultPermissionHandler.md) · class · 6 成员
- [IPermissionHandler](net/minecraftforge/server/permission/handler/IPermissionHandler.md) · interface · 3 成员
- [IPermissionHandlerFactory](net/minecraftforge/server/permission/handler/IPermissionHandlerFactory.md) · interface · 1 成员

### `net.minecraftforge.server.permission.nodes`（5）

- [PermissionDynamicContext](net/minecraftforge/server/permission/nodes/PermissionDynamicContext.md) · class · 5 成员
- [PermissionDynamicContextKey](net/minecraftforge/server/permission/nodes/PermissionDynamicContextKey.md) · record · 1 成员
- [PermissionNode](net/minecraftforge/server/permission/nodes/PermissionNode.md) · class · 12 成员
- [PermissionType](net/minecraftforge/server/permission/nodes/PermissionType.md) · class · 5 成员
- [PermissionTypes](net/minecraftforge/server/permission/nodes/PermissionTypes.md) · class · 5 成员

### `net.minecraftforge.server.timings`（2）

- [ForgeTimings](net/minecraftforge/server/timings/ForgeTimings.md) · class · 3 成员
- [TimeTracker](net/minecraftforge/server/timings/TimeTracker.md) · class · 7 成员

### `net.minecraftforge.versions.forge`（1）

- [ForgeVersion](net/minecraftforge/versions/forge/ForgeVersion.md) · class · 6 成员

### `net.minecraftforge.versions.mcp`（1）

- [MCPVersion](net/minecraftforge/versions/mcp/MCPVersion.md) · class · 3 成员

---

★ = 本项目直接用到的类。其余类也逐类成文（没有任何一个被漏掉），
只是本仓库的 op 不经过它们；每篇开头都写了『本项目未直接使用』及原因。
