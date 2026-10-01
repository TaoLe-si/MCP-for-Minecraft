# ForgeHooksClient

> `net.minecraftforge.client.ForgeHooksClient` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/ForgeHooksClient.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目用法**：它发的 PlaySoundEvent / BossEventProgress 就是我们抄的源头

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（101 个）

```java
public static void resizeGuiLayers(Minecraft minecraft, int width, int height)
```
源码 :217 —（无 javadoc）

```java
public static void clearGuiLayers(Minecraft minecraft)
```
源码 :221 —（无 javadoc）

```java
public static void pushGuiLayer(Minecraft minecraft, Screen screen)
```
源码 :234 —（无 javadoc）

```java
public static void popGuiLayer(Minecraft minecraft)
```
源码 :243 —（无 javadoc）

```java
public static float getGuiFarPlane()
```
源码 :256 —（无 javadoc）

```java
public static String getArmorTexture(Entity entity, ItemStack armor, String _default, EquipmentSlot slot, String type)
```
源码 :264 —（无 javadoc）

```java
public static boolean onDrawHighlight(LevelRenderer context, Camera camera, HitResult target, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource)
```
源码 :270 —（无 javadoc）

```java
public static void dispatchRenderStage(RenderLevelStageEvent.Stage stage, LevelRenderer levelRenderer, PoseStack poseStack, Matrix4f projectionMatrix, int renderTick, Camera camera, Frustum frustum)
```
源码 :284 —（无 javadoc）

```java
public static void dispatchRenderStage(RenderType renderType, LevelRenderer levelRenderer, PoseStack poseStack, Matrix4f projectionMatrix, int renderTick, Camera camera, Frustum frustum)
```
源码 :293 —（无 javadoc）

```java
public static boolean renderSpecificFirstPersonHand(InteractionHand hand, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, float partialTick, float interpPitch, float swingProgress, float equipProgress, ItemStack stack)
```
源码 :300 —（无 javadoc）

```java
public static boolean renderSpecificFirstPersonArm(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, AbstractClientPlayer player, HumanoidArm arm)
```
源码 :305 —（无 javadoc）

```java
public static void onTextureStitchedPost(TextureAtlas map)
```
源码 :310 —（无 javadoc）

```java
public static void onBlockColorsInit(BlockColors blockColors)
```
源码 :315 —（无 javadoc）

```java
public static void onItemColorsInit(ItemColors itemColors, BlockColors blockColors)
```
源码 :320 —（无 javadoc）

```java
public static Model getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot slot, HumanoidModel<?> _default)
```
源码 :325 —（无 javadoc）

```java
public static <T extends LivingEntity> void copyModelProperties(HumanoidModel<T> original, HumanoidModel<?> replacement)
```
源码 :332 —（无 javadoc）

```java
public static String fixDomain(String base, String complex)
```
源码 :346 —（无 javadoc）

```java
public static float getFieldOfViewModifier(Player entity, float fovModifier)
```
源码 :366 —（无 javadoc）

```java
public static double getFieldOfView(GameRenderer renderer, Camera camera, double partialTick, double fov, boolean usedConfiguredFov)
```
源码 :373 —（无 javadoc）

```java
public static void renderMainMenu(TitleScreen gui, GuiGraphics guiGraphics, Font font, int width, int height, int alpha)
```
源码 :389 —（无 javadoc）

```java
public static String forgeStatusLine
```
源码 :404 —（无 javadoc）

```java
public static SoundInstance playSound(SoundEngine manager, SoundInstance sound)
```
源码 :406 —（无 javadoc）

```java
public static void drawScreen(Screen screen, GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick)
```
源码 :413 —（无 javadoc）

```java
public static Vector3f getFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, float fogRed, float fogGreen, float fogBlue)
```
源码 :432 —（无 javadoc）

```java
public static void onFogRender(FogRenderer.FogMode mode, FogType type, Camera camera, float partialTick, float renderDistance, float nearDistance, float farDistance, FogShape shape)
```
源码 :447 —（无 javadoc）

```java
public static ViewportEvent.ComputeCameraAngles onCameraSetup(GameRenderer renderer, Camera camera, float partial)
```
源码 :463 —（无 javadoc）

```java
public static void onModifyBakingResult(Map<ResourceLocation, BakedModel> models, ModelBakery modelBakery)
```
源码 :470 —（无 javadoc）

```java
public static void onModelBake(ModelManager modelManager, Map<ResourceLocation, BakedModel> models, ModelBakery modelBakery)
```
源码 :475 —（无 javadoc）

```java
public static BakedModel handleCameraTransforms(PoseStack poseStack, BakedModel model, ItemDisplayContext cameraTransformType, boolean applyLeftHandTransform)
```
源码 :480 —（无 javadoc）

```java
public static TextureAtlasSprite[] getFluidSprites(BlockAndTintGetter level, BlockPos pos, FluidState fluidStateIn)
```
源码 :487 —（无 javadoc）

```java
public static Material getBlockMaterial(ResourceLocation loc)
```
源码 :499 —（无 javadoc）

```java
public static void fillNormal(int[] faceData, Direction facing)
```
源码 :504 —（无 javadoc）

```java
public static void fillNormal(int[] faceData, Direction facing, boolean calculateNormals)
```
源码 :513 — internal, relies on fixed format of FaceBakery

```java
public static boolean calculateFaceWithoutAO(BlockAndTintGetter getter, BlockState state, BlockPos pos, BakedQuad quad, boolean isFaceCubic, float[] brightness, int[] lightmap)
```
源码 :551 —（无 javadoc）

```java
public static void loadEntityShader(Entity entity, GameRenderer entityRenderer)
```
源码 :563 —（无 javadoc）

```java
public static boolean shouldCauseReequipAnimation(@NotNull ItemStack from, @NotNull ItemStack to, int slot)
```
源码 :577 —（无 javadoc）

```java
public static CustomizeGuiOverlayEvent.BossEventProgress onCustomizeBossEventProgress(GuiGraphics guiGraphics, Window window, LerpingBossEvent bossInfo, int x, int y, int increment)
```
源码 :594 —（无 javadoc）

```java
public static ScreenshotEvent onScreenshot(NativeImage image, File screenshotFile)
```
源码 :602 —（无 javadoc）

```java
public static void onClientChangeGameType(PlayerInfo info, GameType currentGameMode, GameType newGameMode)
```
源码 :609 —（无 javadoc）

```java
public static void onMovementInputUpdate(Player player, Input movementInput)
```
源码 :618 —（无 javadoc）

```java
public static boolean onScreenMouseClickedPre(Screen guiScreen, double mouseX, double mouseY, int button)
```
源码 :623 —（无 javadoc）

```java
public static boolean onScreenMouseClickedPost(Screen guiScreen, double mouseX, double mouseY, int button, boolean handled)
```
源码 :629 —（无 javadoc）

```java
public static boolean onScreenMouseReleasedPre(Screen guiScreen, double mouseX, double mouseY, int button)
```
源码 :636 —（无 javadoc）

```java
public static boolean onScreenMouseReleasedPost(Screen guiScreen, double mouseX, double mouseY, int button, boolean handled)
```
源码 :642 —（无 javadoc）

```java
public static boolean onScreenMouseDragPre(Screen guiScreen, double mouseX, double mouseY, int mouseButton, double dragX, double dragY)
```
源码 :649 —（无 javadoc）

```java
public static void onScreenMouseDragPost(Screen guiScreen, double mouseX, double mouseY, int mouseButton, double dragX, double dragY)
```
源码 :655 —（无 javadoc）

```java
public static boolean onScreenMouseScrollPre(MouseHandler mouseHelper, Screen guiScreen, double scrollDelta)
```
源码 :661 —（无 javadoc）

```java
public static void onScreenMouseScrollPost(MouseHandler mouseHelper, Screen guiScreen, double scrollDelta)
```
源码 :670 —（无 javadoc）

```java
public static boolean onScreenKeyPressedPre(Screen guiScreen, int keyCode, int scanCode, int modifiers)
```
源码 :679 —（无 javadoc）

```java
public static boolean onScreenKeyPressedPost(Screen guiScreen, int keyCode, int scanCode, int modifiers)
```
源码 :685 —（无 javadoc）

```java
public static boolean onScreenKeyReleasedPre(Screen guiScreen, int keyCode, int scanCode, int modifiers)
```
源码 :691 —（无 javadoc）

```java
public static boolean onScreenKeyReleasedPost(Screen guiScreen, int keyCode, int scanCode, int modifiers)
```
源码 :697 —（无 javadoc）

```java
public static boolean onScreenCharTypedPre(Screen guiScreen, char codePoint, int modifiers)
```
源码 :703 —（无 javadoc）

```java
public static void onScreenCharTypedPost(Screen guiScreen, char codePoint, int modifiers)
```
源码 :709 —（无 javadoc）

```java
public static void onRecipesUpdated(RecipeManager mgr)
```
源码 :715 —（无 javadoc）

```java
public static boolean onMouseButtonPre(int button, int action, int mods)
```
源码 :721 —（无 javadoc）

```java
public static void onMouseButtonPost(int button, int action, int mods)
```
源码 :726 —（无 javadoc）

```java
public static boolean onMouseScroll(MouseHandler mouseHelper, double scrollDelta)
```
源码 :731 —（无 javadoc）

```java
public static void onKeyInput(int key, int scanCode, int action, int modifiers)
```
源码 :737 —（无 javadoc）

```java
public static InputEvent.InteractionKeyMappingTriggered onClickInput(int button, KeyMapping keyBinding, InteractionHand hand)
```
源码 :742 —（无 javadoc）

```java
public static boolean isNameplateInRenderDistance(Entity entity, double squareDistance)
```
源码 :749 —（无 javadoc）

```java
public static void renderPistonMovedBlocks(BlockPos pos, BlockState state, PoseStack stack, MultiBufferSource bufferSource, Level level, boolean checkSides, int packedOverlay, BlockRenderDispatcher blockRenderer)
```
源码 :759 —（无 javadoc）

```java
public static boolean shouldRenderEffect(MobEffectInstance effectInstance)
```
源码 :768 —（无 javadoc）

```java
public static SpriteContents loadSpriteContents( ResourceLocation name, Resource resource, FrameSize frameSize, NativeImage image, AnimationMetadataSection animationMeta )
```
源码 :774 —（无 javadoc）

```java
public static TextureAtlasSprite loadTextureAtlasSprite( ResourceLocation atlasName, SpriteContents contents, int atlasWidth, int atlasHeight, int spriteX, int spriteY, int mipmapLevel )
```
源码 :796 —（无 javadoc）

```java
public static void registerLayerDefinition(ModelLayerLocation layerLocation, Supplier<LayerDefinition> supplier)
```
源码 :812 —（无 javadoc）

```java
public static void loadLayerDefinitions(ImmutableMap.Builder<ModelLayerLocation, LayerDefinition> builder)
```
源码 :817 —（无 javadoc）

```java
public static void processForgeListPingData(ServerStatus packet, ServerData target)
```
源码 :821 —（无 javadoc）

```java
public static void drawForgePingInfo(JoinMultiplayerScreen gui, ServerData target, GuiGraphics guiGraphics, int x, int y, int width, int relativeMouseX, int relativeMouseY)
```
源码 :878 —（无 javadoc）

```java
public static void handleClientLevelClosing(ClientLevel level)
```
源码 :930 —（无 javadoc）

```java
public static void firePlayerLogin(MultiPlayerGameMode pc, LocalPlayer player, Connection networkManager)
```
源码 :940 —（无 javadoc）

```java
public static void firePlayerLogout(@Nullable MultiPlayerGameMode pc, @Nullable LocalPlayer player)
```
源码 :944 —（无 javadoc）

```java
public static void firePlayerRespawn(MultiPlayerGameMode pc, LocalPlayer oldPlayer, LocalPlayer newPlayer, Connection networkManager)
```
源码 :948 —（无 javadoc）

```java
public static void onRegisterParticleProviders(ParticleEngine particleEngine)
```
源码 :952 —（无 javadoc）

```java
public static void onRegisterKeyMappings(Options options)
```
源码 :956 —（无 javadoc）

```java
public static void onRegisterAdditionalModels(Set<ResourceLocation> additionalModels)
```
源码 :960 —（无 javadoc）

```java
public static Component onClientChat(ChatType.Bound boundChatType, Component message, UUID sender)
```
源码 :965 —（无 javadoc）

```java
public static Component onClientPlayerChat(ChatType.Bound boundChatType, Component message, PlayerChatMessage playerChatMessage, UUID sender)
```
源码 :972 —（无 javadoc）

```java
public static Component onClientSystemChat(Component message, boolean overlay)
```
源码 :983 —（无 javadoc）

```java
public static String onClientSendMessage(String message)
```
源码 :990 —（无 javadoc）

```java
public static RenderType getEntityRenderType(RenderType chunkRenderType, boolean cull)
```
源码 :1001 —（无 javadoc）

```java
public static class ClientEvents
```
源码 :1007 —（无 javadoc）

```java
public static Font getTooltipFont(@NotNull ItemStack stack, Font fallbackFont)
```
源码 :1026 —（无 javadoc）

```java
public static RenderTooltipEvent.Pre onRenderTooltipPre(@NotNull ItemStack stack, GuiGraphics graphics, int x, int y, int screenWidth, int screenHeight, @NotNull List<ClientTooltipComponent> components, @NotNull Font fallbackFont, @NotNull ClientTooltipPositioner positioner)
```
源码 :1032 —（无 javadoc）

```java
public static RenderTooltipEvent.Color onRenderTooltipColor(@NotNull ItemStack stack, GuiGraphics graphics, int x, int y, @NotNull Font font, @NotNull List<ClientTooltipComponent> components)
```
源码 :1039 —（无 javadoc）

```java
public static List<ClientTooltipComponent> gatherTooltipComponents(ItemStack stack, List<? extends FormattedText> textElements, int mouseX, int screenWidth, int screenHeight, Font fallbackFont)
```
源码 :1046 —（无 javadoc）

```java
public static List<ClientTooltipComponent> gatherTooltipComponents(ItemStack stack, List<? extends FormattedText> textElements, Optional<TooltipComponent> itemComponent, int mouseX, int screenWidth, int screenHeight, Font fallbackFont)
```
源码 :1051 —（无 javadoc）

```java
public static List<ClientTooltipComponent> gatherTooltipComponentsFromElements(ItemStack stack, List<Either<FormattedText, TooltipComponent>> elements, int mouseX, int screenWidth, int screenHeight, Font fallbackFont)
```
源码 :1060 —（无 javadoc）

```java
public static Comparator<ParticleRenderType> makeParticleRenderTypeComparator(List<ParticleRenderType> renderOrder)
```
源码 :1123 —（无 javadoc）

```java
public static ScreenEvent.RenderInventoryMobEffects onScreenPotionSize(Screen screen, int availableSpace, boolean compact, int horizontalOffset)
```
源码 :1143 —（无 javadoc）

```java
public static boolean onToastAdd(Toast toast)
```
源码 :1150 —（无 javadoc）

```java
public static boolean isBlockInSolidLayer(BlockState state)
```
源码 :1155 —（无 javadoc）

```java
public static void createWorldConfirmationScreen(Runnable doConfirmedWorldLoad)
```
源码 :1161 —（无 javadoc）

```java
public static boolean renderFireOverlay(Player player, PoseStack mat)
```
源码 :1183 —（无 javadoc）

```java
public static boolean renderWaterOverlay(Player player, PoseStack mat)
```
源码 :1188 —（无 javadoc）

```java
public static boolean renderBlockOverlay(Player player, PoseStack mat, RenderBlockScreenEffectEvent.OverlayType type, BlockState block, BlockPos pos)
```
源码 :1193 —（无 javadoc）

```java
public static int getMaxMipmapLevel(int width, int height)
```
源码 :1198 —（无 javadoc）

```java
public static ResourceLocation getShaderImportLocation(String basePath, boolean isRelative, String importPath)
```
源码 :1206 —（无 javadoc）

```java
public static void onCreativeModeTabBuildContents(CreativeModeTab tab, ResourceKey<CreativeModeTab> tabKey, CreativeModeTab.DisplayItemsGenerator originalGenerator, CreativeModeTab.ItemDisplayParameters params, CreativeModeTab.Output output)
```
源码 :1217 —（无 javadoc）

```java
public static Direction getNearestStable(float nX, float nY, float nZ)
```
源码 :1238 — This function is a clone of Direction#getNearest(float, designed to return a consistent direction when the normal is at an inflection point (ie 45 degrees) rounding errors from associated matrix multiplication (such as during SheetedDecalTextureGenerator#endVertex() can cause the direction chosen to…

```java
public static void initClientHooks(Minecraft mc, ReloadableResourceManager resourceManager)
```
源码 :1260 —（无 javadoc）

