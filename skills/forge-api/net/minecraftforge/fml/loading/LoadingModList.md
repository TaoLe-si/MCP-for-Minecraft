# LoadingModList

> `net.minecraftforge.fml.loading.LoadingModList` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/loading/LoadingModList.java` · `fmlloader-1.20.1-47.4.10`（fmlloader-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Master list of all mods in the loading context. This class cannot refer outside the loading package

## 公开成员（13 个）

```java
public static LoadingModList of(List<ModFile> modFiles, List<ModInfo> sortedList, final EarlyLoadingException earlyLoadingException)
```
源码 :57 —（无 javadoc）

```java
public static LoadingModList get()
```
源码 :67 —（无 javadoc）

```java
public void addCoreMods()
```
源码 :70 —（无 javadoc）

```java
public void addAccessTransformers()
```
源码 :79 —（无 javadoc）

```java
public void addForScanning(BackgroundScanHandler backgroundScanHandler)
```
源码 :86 —（无 javadoc）

```java
public List<ModFileInfo> getModFiles()
```
源码 :94 —（无 javadoc）

```java
public Path findResource(final String className)
```
源码 :99 —（无 javadoc）

```java
public Enumeration<URL> findAllURLsForResource(final String resName)
```
源码 :108 —（无 javadoc）

```java
public ModFileInfo getModFileById(String modid)
```
源码 :150 —（无 javadoc）

```java
public List<ModInfo> getMods()
```
源码 :155 —（无 javadoc）

```java
public List<EarlyLoadingException> getErrors()
```
源码 :160 —（无 javadoc）

```java
public void setBrokenFiles(final List<IModFile> brokenFiles)
```
源码 :164 —（无 javadoc）

```java
public List<IModFile> getBrokenFiles()
```
源码 :168 —（无 javadoc）

