# ForgeAdvancementProvider

> `net.minecraftforge.common.data.ForgeAdvancementProvider` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/data/ForgeAdvancementProvider.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：An extension of the AdvancementProvider to provide a feature-complete experience to generate modded advancements.

## 公开成员（2 个）

```java
public ForgeAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper, List<AdvancementGenerator> subProviders)
```
源码 :34 — Constructs an advancement provider using the generators to write the advancements to a file. @param output the target directory of the data generator @param registries a future of a lookup for registries and their objects @param existingFileHelper a helper used to find whether a file exists @param s…

```java
public interface AdvancementGenerator
```
源码 :45 — An interface used to generated modded advancements. This is parallel to vanilla's AdvancementSubProvider with access to the ExistingFileHelper. @see AdvancementSubProvider

