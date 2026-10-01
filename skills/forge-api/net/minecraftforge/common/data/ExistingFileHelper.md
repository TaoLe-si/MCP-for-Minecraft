# ExistingFileHelper

> `net.minecraftforge.common.data.ExistingFileHelper` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/data/ExistingFileHelper.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Enables data providers to check if other data files currently exist. The instance provided in the GatherDataEvent utilizes the standard resources (via VanillaPackResources), forge's resources, as well as any extra resource packs passed in via the `--existing` argument, or mod resources via the `--existing-mod` argument.

## 公开成员（12 个）

```java
public interface IResourceType
```
源码 :49 —（无 javadoc）

```java
public static class ResourceType implements IResourceType
```
源码 :58 —（无 javadoc）

```java
public ExistingFileHelper(Collection<Path> existingPacks, final Set<String> existingMods, boolean enable, @Nullable final String assetIndex, @Nullable final File assetsDir)
```
源码 :95 — Create a new helper. This should probably NOT be used by mods, as the instance provided by forge is designed to be a central instance that tracks existence of generated data. Only create a new helper if you intentionally want to ignore the existence of other generated files. @param existingPacks a c…

```java
public boolean exists(ResourceLocation loc, PackType packType)
```
源码 :142 — Check if a given resource exists in the known resource packs. @param loc the complete location of the resource, e.g. `"minecraft:textures/block/stone.png"` @param packType the type of resources to check @return `true` if the resource exists in any pack, `false` otherwise

```java
public boolean exists(ResourceLocation loc, IResourceType type)
```
源码 :162 — Check if a given resource exists in the known resource packs. This is a convenience method to avoid repeating type/prefix/suffix and instead use the common definitions in ResourceType, or a custom IResourceType definition. @param loc the base location of the resource, e.g. `"minecraft:block/stone"`…

```java
public boolean exists(ResourceLocation loc, PackType packType, String pathSuffix, String pathPrefix)
```
源码 :178 — Check if a given resource exists in the known resource packs. @param loc the base location of the resource, e.g. `"minecraft:block/stone"` @param packType the type of resources to check @param pathSuffix a string to append after the path, e.g. `".json"` @param pathPrefix a string to append before th…

```java
public void trackGenerated(ResourceLocation loc, IResourceType type)
```
源码 :201 — Track the existence of a generated file. This is a convenience method to avoid repeating type/prefix/suffix and instead use the common definitions in ResourceType, or a custom IResourceType definition. This should be called by data providers immediately when a new data object is created, i.e. not du…

```java
public void trackGenerated(ResourceLocation loc, PackType packType, String pathSuffix, String pathPrefix)
```
源码 :224 — Track the existence of a generated file. This should be called by data providers immediately when a new data object is created, i.e. not during DataProvider#run(net.minecraft.data.CachedOutput) but instead when the "builder" (or whatever intermediate object) is created, such as a ModelBuilder. This…

```java
public Resource getResource(ResourceLocation loc, PackType packType, String pathSuffix, String pathPrefix) throws FileNotFoundException
```
源码 :229 —（无 javadoc）

```java
public Resource getResource(ResourceLocation loc, PackType packType) throws FileNotFoundException
```
源码 :234 —（无 javadoc）

```java
public List<Resource> getResourceStack(ResourceLocation loc, PackType packType)
```
源码 :239 —（无 javadoc）

```java
public boolean isEnabled()
```
源码 :246 — @return `true` if validation is enabled, `false` otherwise

