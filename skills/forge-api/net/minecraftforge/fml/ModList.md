# ModList

> `net.minecraftforge.fml.ModList` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/ModList.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Master list of all mods - game-side version. This is classloaded in the game scope and can dispatch game level events as a result.

## 公开成员（16 个）

```java
public static ModList of(List<ModFile> modFiles, List<ModInfo> sortedList)
```
源码 :88 —（无 javadoc）

```java
public static ModList get()
```
源码 :94 —（无 javadoc）

```java
public List<IModFileInfo> getModFiles()
```
源码 :106 —（无 javadoc）

```java
public IModFileInfo getModFileById(String modid)
```
源码 :111 —（无 javadoc）

```java
public <T> Optional<T> getModObjectById(String modId)
```
源码 :167 —（无 javadoc）

```java
public Optional<? extends ModContainer> getModContainerById(String modId)
```
源码 :172 —（无 javadoc）

```java
public Optional<? extends ModContainer> getModContainerByObject(Object obj)
```
源码 :177 —（无 javadoc）

```java
public List<IModInfo> getMods()
```
源码 :182 —（无 javadoc）

```java
public boolean isLoaded(String modTarget)
```
源码 :187 —（无 javadoc）

```java
public int size()
```
源码 :192 —（无 javadoc）

```java
public List<ModFileScanData> getAllScanData()
```
源码 :197 —（无 javadoc）

```java
public void forEachModFile(Consumer<IModFile> fileConsumer)
```
源码 :213 —（无 javadoc）

```java
public <T> Stream<T> applyForEachModFile(Function<IModFile, T> function)
```
源码 :218 —（无 javadoc）

```java
public void forEachModContainer(BiConsumer<String, ModContainer> modContainerConsumer)
```
源码 :222 —（无 javadoc）

```java
public void forEachModInOrder(Consumer<ModContainer> containerConsumer)
```
源码 :226 —（无 javadoc）

```java
public <T> Stream<T> applyForEachModContainer(Function<ModContainer, T> function)
```
源码 :230 —（无 javadoc）

