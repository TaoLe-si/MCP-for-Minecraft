# TopologicalSort

> `net.minecraftforge.fml.loading.toposort.TopologicalSort` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/loading/toposort/TopologicalSort.java` · `fmlloader-1.20.1-47.4.10`（fmlloader-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Provides a topological sort algorithm. While this algorithm is used for mod loading in forge, it can be utilized in other fashions, e.g. topology-based registry loading, prioritization for renderers, and even mod module loading.

## 公开成员（1 个）

```java
public static <T> List<T> topologicalSort(Graph<T> graph, @Nullable Comparator<? super T> comparator) throws IllegalArgumentException
```
源码 :62 — A breath-first-search based topological sort. Compared to the depth-first-search version, it does not reverse the graph and supports custom secondary ordering specified by a comparator. It also utilizes the recently introduced Guava Graph API, which is more straightforward than the old directed grap…

