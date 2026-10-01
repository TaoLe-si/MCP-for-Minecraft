# ContainerScreenEvent

> `net.minecraftforge.client.event.ContainerScreenEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/ContainerScreenEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired for hooking into AbstractContainerScreen events. See the subclasses to listen for specific events. These events are fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client. @see Render.Foreground @see Render.Background

## 公开成员（3 个）

```java
protected ContainerScreenEvent(AbstractContainerScreen<?> containerScreen)
```
源码 :31 —（无 javadoc）

```java
public AbstractContainerScreen<?> getContainerScreen()
```
源码 :39 — the container screen

```java
public static abstract class Render extends ContainerScreenEvent
```
源码 :54 — Fired every time an AbstractContainerScreen renders. See the two subclasses to listen for foreground or background rendering. These events are fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical client. @see Foreground @see Background

