# StronglyConnectedComponentDetector

> `net.minecraftforge.fml.loading.toposort.StronglyConnectedComponentDetector` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/loading/toposort/StronglyConnectedComponentDetector.java` · `fmlloader-1.20.1-47.4.10`（fmlloader-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：An object that splits a graph into strongly connected components lazily with Tarjan's Strongly Connected Components Algorithm. This algorithm allows to detect all cycles in dependencies that prevent topological sorting. This detector evaluates the graph lazily and won't reflect the modifications in the graph after initial evaluation.

## 公开成员（2 个）

```java
public StronglyConnectedComponentDetector(Graph<T> graph)
```
源码 :37 —（无 javadoc）

```java
public Set<Set<T>> getComponents()
```
源码 :41 —（无 javadoc）

