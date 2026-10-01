# FMLDedicatedServerSetupEvent

> `net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/event/lifecycle/FMLDedicatedServerSetupEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模组总线生命周期事件（本模组没有需要参与的阶段）

**职责**（源码 javadoc）：This is the second of four commonly called events during mod core startup. Called before InterModEnqueueEvent Called after FMLCommonSetupEvent Called on net.minecraftforge.api.distmarker.Dist#DEDICATED_SERVER - the dedicated game server. Alternative to FMLClientSetupEvent. Do dedicated server specific activities with this event. This event is fired before construction of the dedicated server. Use…

## 公开成员（1 个）

```java
public FMLDedicatedServerSetupEvent(ModContainer container, ModLoadingStage stage)
```
源码 :31 —（无 javadoc）

