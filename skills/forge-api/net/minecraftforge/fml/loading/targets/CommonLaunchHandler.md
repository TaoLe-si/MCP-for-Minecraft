# CommonLaunchHandler

> `net.minecraftforge.fml.loading.targets.CommonLaunchHandler` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/loading/targets/CommonLaunchHandler.java` · `fmlloader-1.20.1-47.4.10`（fmlloader-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（15 个）

```java
public record LocatedPaths(List<Path> minecraftPaths, BiPredicate<String, String> minecraftFilter, List<List<Path>> otherModPaths, List<Path> otherArtifacts) {} protected static final Logger LOGGER = LogUtils.getLogger()
```
源码 :35 —（无 javadoc）

```java
public abstract Dist getDist()
```
源码 :39 —（无 javadoc）

```java
public abstract String getNaming()
```
源码 :41 —（无 javadoc）

```java
public boolean isProduction()
```
源码 :43 —（无 javadoc）

```java
public boolean isData()
```
源码 :47 —（无 javadoc）

```java
public abstract LocatedPaths getMinecraftPaths()
```
源码 :51 —（无 javadoc）

```java
public void configureTransformationClassLoader(final ITransformingClassLoaderBuilder builder)
```
源码 :54 —（无 javadoc）

```java
protected String[] preLaunch(String[] arguments, ModuleLayer layer)
```
源码 :58 —（无 javadoc）

```java
protected final Map<String, List<Path>> getModClasses()
```
源码 :72 —（无 javadoc）

```java
public ServiceRunner launchService(final String[] arguments, final ModuleLayer gameLayer)
```
源码 :91 —（无 javadoc）

```java
protected abstract ServiceRunner makeService(final String[] arguments, final ModuleLayer gameLayer)
```
源码 :96 —（无 javadoc）

```java
protected void clientService(final String[] arguments, final ModuleLayer layer) throws Throwable
```
源码 :98 —（无 javadoc）

```java
protected void serverService(final String[] arguments, final ModuleLayer layer) throws Throwable
```
源码 :102 —（无 javadoc）

```java
protected void dataService(final String[] arguments, final ModuleLayer layer) throws Throwable
```
源码 :106 —（无 javadoc）

```java
protected void runTarget(final String target, final String[] arguments, final ModuleLayer layer) throws Throwable
```
源码 :110 —（无 javadoc）

