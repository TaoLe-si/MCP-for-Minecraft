# FMLClientSetupEvent

> `net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/event/lifecycle/FMLClientSetupEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模组总线生命周期事件（本模组没有需要参与的阶段）

**职责**（源码 javadoc）：This is the second of four commonly called events during mod lifecycle startup. Called before InterModEnqueueEvent Called after FMLCommonSetupEvent Called on net.minecraftforge.api.distmarker.Dist#CLIENT - the game client. Alternative to FMLDedicatedServerSetupEvent. Do client only setup with this event, such as KeyBindings. This is a parallel dispatch event.

## 公开成员（1 个）

```java
public FMLClientSetupEvent(ModContainer container, ModLoadingStage stage)
```
源码 :28 —（无 javadoc）

