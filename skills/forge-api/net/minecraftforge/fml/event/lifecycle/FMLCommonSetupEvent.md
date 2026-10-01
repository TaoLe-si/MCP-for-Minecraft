# FMLCommonSetupEvent

> `net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/event/lifecycle/FMLCommonSetupEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模组总线生命周期事件（本模组没有需要参与的阶段）

**职责**（源码 javadoc）：This is the first of four commonly called events during mod initialization. Called after net.minecraftforge.registries.RegisterEvent events have been fired and before FMLClientSetupEvent or FMLDedicatedServerSetupEvent during mod startup. Either register your listener using net.minecraftforge.fml.javafmlmod.AutomaticEventSubscriber and net.minecraftforge.eventbus.api.SubscribeEvent or net.minecraf…

## 公开成员（1 个）

```java
public FMLCommonSetupEvent(final ModContainer container, final ModLoadingStage stage)
```
源码 :32 —（无 javadoc）

