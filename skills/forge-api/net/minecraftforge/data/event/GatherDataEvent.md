# GatherDataEvent

> `net.minecraftforge.data.event.GatherDataEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/data/event/GatherDataEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（3 个）

```java
public GatherDataEvent(final ModContainer mc, final DataGenerator dataGenerator, final DataGeneratorConfig dataGeneratorConfig, ExistingFileHelper existingFileHelper)
```
源码 :35 —（无 javadoc）

```java
public ModContainer getModContainer()
```
源码 :43 —（无 javadoc）

```java
public Collection<Path> getInputs() { return this.config.getInputs(); } public DataGenerator getGenerator() { return this.dataGenerator; } public ExistingFileHelper getExistingFileHelper() { return existingFileHelper; } public CompletableFuture<HolderLookup.Provider> getLookupProvider() { return this.config.lookupProvider; } public boolean includeServer() { return this.config.server; } public boolean includeClient() { return this.config.client; } public boolean includeDev() { return this.config.dev; } public boolean includeReports() { return this.config.reports; } public boolean validate() { return this.config.validate; } public static class DataGeneratorConfig
```
源码 :47 —（无 javadoc）

