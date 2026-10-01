# ModFile

> `net.minecraftforge.fml.loading.moddiscovery.ModFile` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/loading/moddiscovery/ModFile.java` · `fmlloader-1.20.1-47.4.10`（fmlloader-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（26 个）

```java
public static final Manifest DEFAULTMANIFEST
```
源码 :41 —（无 javadoc）

```java
public ModFile(final SecureJar jar, final IModProvider provider, final ModFileFactory.ModFileInfoParser parser)
```
源码 :67 —（无 javadoc）

```java
public ModFile(final SecureJar jar, final IModProvider provider, final ModFileFactory.ModFileInfoParser parser, String type)
```
源码 :71 —（无 javadoc）

```java
public Supplier<Map<String,Object>> getSubstitutionMap()
```
源码 :83 —（无 javadoc）

```java
public Type getType()
```
源码 :87 —（无 javadoc）

```java
public Path getFilePath()
```
源码 :92 —（无 javadoc）

```java
public SecureJar getSecureJar()
```
源码 :97 —（无 javadoc）

```java
public List<IModInfo> getModInfos()
```
源码 :102 —（无 javadoc）

```java
public Optional<Path> getAccessTransformer()
```
源码 :106 —（无 javadoc）

```java
public boolean identifyMods()
```
源码 :110 —（无 javadoc）

```java
public List<CoreModFile> getCoreMods()
```
源码 :120 —（无 javadoc）

```java
public ModFileScanData compileContent()
```
源码 :127 — Run in an executor thread to harvest the class and annotation list

```java
public void scanFile(Consumer<Path> pathConsumer)
```
源码 :131 —（无 javadoc）

```java
public void setFutureScanResult(CompletableFuture<ModFileScanData> future)
```
源码 :135 —（无 javadoc）

```java
public ModFileScanData getScanResult()
```
源码 :140 —（无 javadoc）

```java
public void setScanResult(final ModFileScanData modFileScanData, final Throwable throwable)
```
源码 :154 —（无 javadoc）

```java
public void setFileProperties(Map<String, Object> fileProperties)
```
源码 :162 —（无 javadoc）

```java
public List<IModLanguageProvider> getLoaders()
```
源码 :167 —（无 javadoc）

```java
public Path findResource(String... path)
```
源码 :172 —（无 javadoc）

```java
public void identifyLanguage()
```
源码 :179 —（无 javadoc）

```java
public String toString()
```
源码 :186 —（无 javadoc）

```java
public String getFileName()
```
源码 :191 —（无 javadoc）

```java
public IModProvider getProvider()
```
源码 :196 —（无 javadoc）

```java
public IModFileInfo getModFileInfo()
```
源码 :201 —（无 javadoc）

```java
public void setSecurityStatus(final SecureJar.Status status)
```
源码 :206 —（无 javadoc）

```java
public ArtifactVersion getJarVersion()
```
源码 :210 —（无 javadoc）

