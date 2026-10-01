# ModConfigEvent

> `net.minecraftforge.fml.event.config.ModConfigEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/event/config/ModConfigEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模组总线生命周期事件（本模组没有需要参与的阶段）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（4 个）

```java
public ModConfig getConfig()
```
源码 :21 —（无 javadoc）

```java
public static class Loading extends ModConfigEvent
```
源码 :29 — Fired during mod and server loading, depending on ModConfig.Type of config file. Any Config objects associated with this will be valid and can be queried directly.

```java
public static class Reloading extends ModConfigEvent
```
源码 :41 — Fired when the configuration is changed. This can be caused by a change to the config from a UI or from editing the file itself. IMPORTANT: this can fire at any time and may not even be on the server or client threads. Ensure you properly synchronize any resultant changes.

```java
public static class Unloading extends ModConfigEvent
```
源码 :53 — Fired when a config is unloaded. This only happens when the server closes, which is probably only really relevant on the client, to reset internal mod state when the server goes away, though it will fire on the dedicated server as well. The config file will be saved after this event has fired.

