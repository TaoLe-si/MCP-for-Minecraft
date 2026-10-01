# DeferredWorkQueue

> `net.minecraftforge.fml.DeferredWorkQueue` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/DeferredWorkQueue.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Utility for running code on the main launch thread at the next available opportunity. There is no guaranteed order that work from various mods will be run, but your own work will be run sequentially. Use of this class after startup is not possible. At that point, `ReentrantBlockableEventLoop` should be used instead. Exceptions from tasks will be handled gracefully, causing a mod loading error. Tas…

## 公开成员（5 个）

```java
public DeferredWorkQueue(ModLoadingStage modLoadingStage)
```
源码 :45 —（无 javadoc）

```java
public static Optional<DeferredWorkQueue> lookup(Optional<ModLoadingStage> parallelClass)
```
源码 :51 —（无 javadoc）

```java
public void runTasks()
```
源码 :55 —（无 javadoc）

```java
public CompletableFuture<Void> enqueueWork(final ModContainer modInfo, final Runnable work)
```
源码 :101 —（无 javadoc）

```java
public <T> CompletableFuture<T> enqueueWork(final ModContainer modInfo, final Supplier<T> work)
```
源码 :105 —（无 javadoc）

