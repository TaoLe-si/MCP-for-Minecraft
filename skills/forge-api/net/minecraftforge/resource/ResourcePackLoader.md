# ResourcePackLoader

> `net.minecraftforge.resource.ResourcePackLoader` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/resource/ResourcePackLoader.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（6 个）

```java
public static Optional<PathPackResources> getPackFor(String modId)
```
源码 :35 —（无 javadoc）

```java
public static void loadResourcePacks(PackRepository resourcePacks, BiFunction<Map<IModFile, ? extends PathPackResources>, BiConsumer<? super PathPackResources, Pack>, ? extends RepositorySource> packFinder)
```
源码 :41 —（无 javadoc）

```java
public static void loadResourcePacks(PackRepository resourcePacks, Function<Map<IModFile, ? extends PathPackResources>, ? extends RepositorySource> packFinder)
```
源码 :45 —（无 javadoc）

```java
public static PathPackResources createPackForMod(IModFileInfo mf)
```
源码 :54 —（无 javadoc）

```java
public static List<String> getPackNames()
```
源码 :69 —（无 javadoc）

```java
public static <V> Comparator<Map.Entry<String,V>> getSorter()
```
源码 :73 —（无 javadoc）

