# UniqueModListBuilder

> `net.minecraftforge.fml.loading.UniqueModListBuilder` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/loading/UniqueModListBuilder.java` · `fmlloader-1.20.1-47.4.10`（fmlloader-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（2 个）

```java
public UniqueModListBuilder(final List<ModFile> modFiles) {this.modFiles = modFiles;} public UniqueModListData buildUniq…
```
源码 :32 —（无 javadoc）

```java
public record UniqueModListData(List<ModFile> modFiles, Map<String, List<ModFile>> modFilesByFirstId) {} }
```
源码 :144 —（无 javadoc）

