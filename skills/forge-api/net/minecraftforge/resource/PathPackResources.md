# PathPackResources

> `net.minecraftforge.resource.PathPackResources` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/resource/PathPackResources.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Defines a resource pack from an arbitrary Path. This is primarily intended to support including optional resource packs inside a mod, such as to have alternative textures to use along with Programmer Art, or optional alternative recipes for compatibility ot to replace vanilla recipes.

## 公开成员（9 个）

```java
public PathPackResources(String packId, boolean isBuiltin, final Path source)
```
源码 :51 — Constructs a java.nio.Path-based resource pack. @param packId the identifier of the pack. This identifier should be unique within the pack finder, preferably the name of the file or folder containing the resources. @param isBuiltin whether this pack resources should be considered builtin @param sour…

```java
public Path getSource()
```
源码 :63 — Returns the source path containing the resource pack. This is used for error display. @return the root path of the resources.

```java
protected Path resolve(String... paths)
```
源码 :74 — Implement to return a file or folder path for the given set of path components. @param paths One or more path strings to resolve. Can include slash-separated paths. @return the resulting path, which may not exist.

```java
public IoSupplier<InputStream> getRootResource(String... paths)
```
源码 :84 —（无 javadoc）

```java
public void listResources(PackType type, String namespace, String path, ResourceOutput resourceOutput)
```
源码 :94 —（无 javadoc）

```java
public Set<String> getNamespaces(PackType type)
```
源码 :102 —（无 javadoc）

```java
public IoSupplier<InputStream> getResource(PackType type, ResourceLocation location)
```
源码 :138 —（无 javadoc）

```java
public void close()
```
源码 :154 —（无 javadoc）

```java
public String toString()
```
源码 :159 —（无 javadoc）

