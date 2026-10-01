# RegisterClientTooltipComponentFactoriesEvent

> `net.minecraftforge.client.event.RegisterClientTooltipComponentFactoriesEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RegisterClientTooltipComponentFactoriesEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Allows users to register custom net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent factories for their net.minecraft.world.inventory.tooltip.TooltipComponent types. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the FMLJavaModLoadingContext#getModEventBus() mod-specific event bus, only on the LogicalSide#CLIENT logical…

## 公开成员（2 个）

```java
public RegisterClientTooltipComponentFactoriesEvent(Map<Class<? extends TooltipComponent>, Function<TooltipComponent, ClientTooltipComponent>> factories)
```
源码 :34 —（无 javadoc）

```java
public <T extends TooltipComponent> void register(Class<T> type, Function<? super T, ? extends ClientTooltipComponent> factory)
```
源码 :43 —（无 javadoc）

