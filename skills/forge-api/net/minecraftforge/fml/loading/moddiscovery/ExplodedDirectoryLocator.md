# ExplodedDirectoryLocator

> `net.minecraftforge.fml.loading.moddiscovery.ExplodedDirectoryLocator` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/loading/moddiscovery/ExplodedDirectoryLocator.java` · `fmlloader-1.20.1-47.4.10`（fmlloader-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（7 个）

```java
public record ExplodedMod(String modid, List<Path> paths) {} private final List<ExplodedMod> explodedMods = new ArrayList<>()
```
源码 :27 —（无 javadoc）

```java
public List<IModLocator.ModFileOrException> scanMods()
```
源码 :33 —（无 javadoc）

```java
public String name()
```
源码 :44 —（无 javadoc）

```java
public void scanFile(final IModFile file, final Consumer<Path> pathConsumer)
```
源码 :49 —（无 javadoc）

```java
public String toString()
```
源码 :60 —（无 javadoc）

```java
public void initArguments(final Map<String, ?> arguments)
```
源码 :67 —（无 javadoc）

```java
public boolean isValid(final IModFile modFile)
```
源码 :75 —（无 javadoc）

