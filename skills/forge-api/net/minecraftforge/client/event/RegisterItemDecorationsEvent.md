# RegisterItemDecorationsEvent

> `net.minecraftforge.client.event.RegisterItemDecorationsEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RegisterItemDecorationsEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Allows users to register custom IItemDecorator IItemDecorator to Items. This event is not Cancelable cancelable, and does not HasResult have a result. This event is fired on the FMLJavaModLoadingContext#getModEventBus() mod-specific event bus, only on the LogicalSide#CLIENT logical client.

## 公开成员（2 个）

```java
public RegisterItemDecorationsEvent(Map<Item, List<IItemDecorator>> decorators)
```
源码 :37 —（无 javadoc）

```java
public void register(ItemLike itemLike, IItemDecorator decorator)
```
源码 :45 — Register an ItemDecorator to an Item

