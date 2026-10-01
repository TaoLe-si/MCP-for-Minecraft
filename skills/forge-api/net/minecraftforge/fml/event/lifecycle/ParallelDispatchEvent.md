# ParallelDispatchEvent

> `net.minecraftforge.fml.event.lifecycle.ParallelDispatchEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/event/lifecycle/ParallelDispatchEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模组总线生命周期事件（本模组没有需要参与的阶段）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（3 个）

```java
public ParallelDispatchEvent(final ModContainer container, final ModLoadingStage stage)
```
源码 :19 —（无 javadoc）

```java
public CompletableFuture<Void> enqueueWork(Runnable work)
```
源码 :28 —（无 javadoc）

```java
public <T> CompletableFuture<T> enqueueWork(Supplier<T> work)
```
源码 :32 —（无 javadoc）

