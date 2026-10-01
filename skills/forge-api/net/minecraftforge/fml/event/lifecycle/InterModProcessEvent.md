# InterModProcessEvent

> `net.minecraftforge.fml.event.lifecycle.InterModProcessEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/event/lifecycle/InterModProcessEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模组总线生命周期事件（本模组没有需要参与的阶段）

**职责**（源码 javadoc）：This is the fourth of four commonly called events during mod core startup. Called after InterModEnqueueEvent Retrieve net.minecraftforge.fml.InterModComms net.minecraftforge.fml.InterModComms.IMCMessage suppliers and process them as you wish with this event. This is a parallel dispatch event. @see #getIMCStream() @see #getIMCStream(Predicate)

## 公开成员（1 个）

```java
public InterModProcessEvent(final ModContainer container, final ModLoadingStage stage)
```
源码 :28 —（无 javadoc）

