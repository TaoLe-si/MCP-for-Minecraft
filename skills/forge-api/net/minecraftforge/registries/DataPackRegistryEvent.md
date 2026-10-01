# DataPackRegistryEvent

> `net.minecraftforge.registries.DataPackRegistryEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/DataPackRegistryEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（1 个）

```java
public DataPackRegistryEvent() {} /** * Fired when datapack registries can be registered. * Datapack registries are registries which can only load entries through JSON files from datapacks. * <p> * Data JSONs will be loaded from {@code data/<datapack_namespace>/modid/registryname/}, where {@code modid} is the namespace of the registry key. * <p> * This event is not {@linkplain Cancelable cancellable}, and does not {@linkplain HasResult have a result}. * <p> * This event is fired on the {@linkplain FMLJavaModLoadingContext#getModEventBus() mod-specific event bus}, * on both {@linkplain LogicalSide logical sides}. */ public static final class NewRegistry extends DataPackRegistryEvent
```
源码 :26 —（无 javadoc）

