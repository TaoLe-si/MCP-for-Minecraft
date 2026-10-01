# MavenCoordinateResolver

> `net.minecraftforge.fml.loading.MavenCoordinateResolver` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/loading/MavenCoordinateResolver.java` · `fmlloader-1.20.1-47.4.10`（fmlloader-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Convert a maven coordinate into a Path. This is gradle standard not maven standard coordinate formatting `:[:]:[@extension]`, must not be `null`.

## 公开成员（2 个）

```java
public static Path get(final String coordinate)
```
源码 :19 —（无 javadoc）

```java
public static Path get(final String groupId, final String artifactId, final String extension, final String classifier, final String version)
```
源码 :30 —（无 javadoc）

