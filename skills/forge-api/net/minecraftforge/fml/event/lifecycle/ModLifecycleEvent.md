# ModLifecycleEvent

> `net.minecraftforge.fml.event.lifecycle.ModLifecycleEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/event/lifecycle/ModLifecycleEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模组总线生命周期事件（本模组没有需要参与的阶段）

**职责**（源码 javadoc）：Parent type to all ModLifecycle events. This is based on Forge EventBus. They fire through the ModContainer's eventbus instance.

## 公开成员（5 个）

```java
public ModLifecycleEvent(ModContainer container)
```
源码 :24 —（无 javadoc）

```java
public final String description()
```
源码 :29 —（无 javadoc）

```java
public Stream<InterModComms.IMCMessage> getIMCStream()
```
源码 :35 —（无 javadoc）

```java
public Stream<InterModComms.IMCMessage> getIMCStream(Predicate<String> methodFilter)
```
源码 :39 —（无 javadoc）

```java
public String toString()
```
源码 :48 —（无 javadoc）

