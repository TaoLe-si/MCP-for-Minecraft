# IModStateProvider

> `net.minecraftforge.fml.IModStateProvider` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/IModStateProvider.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Provides a list of mod loading states which the mod loader may transition between. There may be multiple mod state providers in a single application, where all states from each provider is combined into a single list and ordered.

## 公开成员（1 个）

```java
List<IModLoadingState> getAllStates()
```
源码 :20 — the list of mod loading states known to this provider

