# ModFileInfo

> `net.minecraftforge.fml.loading.moddiscovery.ModFileInfo` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/loading/moddiscovery/ModFileInfo.java` · `fmlloader-1.20.1-47.4.10`（fmlloader-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（18 个）

```java
public static final String CLIENT_SIDE_ONLY_PROP = "__FORGE_clientSideOnly"
```
源码 :54 —（无 javadoc）

```java
public ModFileInfo(final ModFile file, final IConfigurable config, Consumer<IModFileInfo> configFileConsumer, final List<LanguageSpec> languageSpecs)
```
源码 :114 —（无 javadoc）

```java
public List<IModInfo> getMods()
```
源码 :120 —（无 javadoc）

```java
public ModFile getFile()
```
源码 :125 —（无 javadoc）

```java
public List<LanguageSpec> requiredLanguageLoaders()
```
源码 :131 —（无 javadoc）

```java
public Map<String, Object> getFileProperties()
```
源码 :136 —（无 javadoc）

```java
public boolean showAsResourcePack()
```
源码 :142 —（无 javadoc）

```java
public <T> Optional<T> getConfigElement(final String... key)
```
源码 :148 —（无 javadoc）

```java
public List<? extends IConfigurable> getConfigList(final String... key)
```
源码 :154 —（无 javadoc）

```java
public String getLicense()
```
源码 :160 —（无 javadoc）

```java
public IConfigurable getConfig()
```
源码 :166 —（无 javadoc）

```java
public URL getIssueURL()
```
源码 :170 —（无 javadoc）

```java
public boolean missingLicense()
```
源码 :175 —（无 javadoc）

```java
public Optional<String> getCodeSigningFingerprint()
```
源码 :180 —（无 javadoc）

```java
public Optional<String> getTrustData()
```
源码 :191 —（无 javadoc）

```java
public String moduleName()
```
源码 :216 —（无 javadoc）

```java
public String versionString()
```
源码 :221 —（无 javadoc）

```java
public List<String> usesServices()
```
源码 :226 —（无 javadoc）

