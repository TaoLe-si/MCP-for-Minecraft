# InterModEnqueueEvent

> `net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/event/lifecycle/InterModEnqueueEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模组总线生命周期事件（本模组没有需要参与的阶段）

**职责**（源码 javadoc）：This is the third of four commonly called events during mod core startup. Called before InterModProcessEvent Called after FMLClientSetupEvent or FMLDedicatedServerSetupEvent Enqueue net.minecraftforge.fml.InterModComms messages to other mods with this event. This is a parallel dispatch event.

## 公开成员（1 个）

```java
public InterModEnqueueEvent(final ModContainer container, final ModLoadingStage stage)
```
源码 :25 —（无 javadoc）

