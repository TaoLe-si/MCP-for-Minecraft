# ITextureAtlasSpriteLoader

> `net.minecraftforge.client.textures.ITextureAtlasSpriteLoader` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/textures/ITextureAtlasSpriteLoader.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：A loader for custom TextureAtlasSprite texture atlas sprites. The loader can be specified in the corresponding .mcmeta file for a texture as follows: { "forge": { "loader": "examplemod:example_tas_loader" } } @see RegisterTextureAtlasSpriteLoadersEvent

## 公开成员（2 个）

```java
SpriteContents loadContents(ResourceLocation name, Resource resource, FrameSize frameSize, NativeImage image, AnimationMetadataSection animationMeta, ForgeTextureMetadata forgeMeta)
```
源码 :34 —（无 javadoc）

```java
TextureAtlasSprite makeSprite(ResourceLocation atlasName, SpriteContents contents, int atlasWidth, int atlasHeight, int spriteX, int spriteY, int mipmapLevel)
```
源码 :41 —（无 javadoc）

