# IForgeAdvancementBuilder

> `net.minecraftforge.common.extensions.IForgeAdvancementBuilder` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeAdvancementBuilder.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（2 个）

```java
private Advancement.Builder self()
```
源码 :20 —（无 javadoc）

```java
default Advancement save(Consumer<Advancement> saver, ResourceLocation id, ExistingFileHelper fileHelper)
```
源码 :34 — Saves this builder with the given id using the ExistingFileHelper to check if the parent is already known. @param saver a Consumer which saves any advancements provided @param id the ResourceLocation id for the new advancement @param fileHelper the ExistingFileHelper where all known advancements are…

