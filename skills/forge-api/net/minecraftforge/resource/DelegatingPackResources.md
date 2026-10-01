# DelegatingPackResources

> `net.minecraftforge.resource.DelegatingPackResources` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/resource/DelegatingPackResources.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（8 个）

```java
public DelegatingPackResources(String packId, boolean isBuiltin, PackMetadataSection packMeta, List<? extends PackResources> packs)
```
源码 :37 —（无 javadoc）

```java
public <T> T getMetadataSection(MetadataSectionSerializer<T> deserializer) throws IOException
```
源码 :63 —（无 javadoc）

```java
public void listResources(PackType type, String resourceNamespace, String paths, ResourceOutput resourceOutput)
```
源码 :69 —（无 javadoc）

```java
public Set<String> getNamespaces(PackType type)
```
源码 :78 —（无 javadoc）

```java
public void close()
```
源码 :84 —（无 javadoc）

```java
public IoSupplier<InputStream> getRootResource(String... paths)
```
源码 :94 —（无 javadoc）

```java
public IoSupplier<InputStream> getResource(PackType type, ResourceLocation location)
```
源码 :102 —（无 javadoc）

```java
public Collection<PackResources> getChildren()
```
源码 :115 —（无 javadoc）

