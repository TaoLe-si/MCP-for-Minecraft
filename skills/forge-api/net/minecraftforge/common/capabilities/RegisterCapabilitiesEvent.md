# RegisterCapabilitiesEvent

> `net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/capabilities/RegisterCapabilitiesEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event fires when it is time to register your capabilities. @see Capability

## 公开成员（1 个）

```java
public <T> void register(Class<T> type)
```
源码 :28 — Registers a capability to be consumed by others. APIs who define the capability should call this. To retrieve the Capability instance, use the @CapabilityInject annotation. @param type The type to be registered

