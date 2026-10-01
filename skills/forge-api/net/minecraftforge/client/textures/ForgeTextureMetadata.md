# ForgeTextureMetadata

> `net.minecraftforge.client.textures.ForgeTextureMetadata` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/textures/ForgeTextureMetadata.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：The "forge" section of texture metadata files (.mcmeta). Currently used only to specify custom TextureAtlasSprite loaders. @see ITextureAtlasSpriteLoader

## 公开成员（5 个）

```java
public static final ForgeTextureMetadata EMPTY = new ForgeTextureMetadata(null)
```
源码 :29 —（无 javadoc）

```java
public static final MetadataSectionSerializer<ForgeTextureMetadata> SERIALIZER = new Serializer()
```
源码 :30 —（无 javadoc）

```java
public static ForgeTextureMetadata forResource(Resource resource) throws IOException
```
源码 :32 —（无 javadoc）

```java
public ForgeTextureMetadata(@Nullable ITextureAtlasSpriteLoader loader)
```
源码 :40 —（无 javadoc）

```java
public ITextureAtlasSpriteLoader getLoader()
```
源码 :46 —（无 javadoc）

