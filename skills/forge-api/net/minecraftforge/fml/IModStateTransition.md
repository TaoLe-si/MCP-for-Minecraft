# IModStateTransition

> `net.minecraftforge.fml.IModStateTransition` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/IModStateTransition.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（11 个）

```java
static IModStateTransition buildNoopTransition()
```
源码 :23 —（无 javadoc）

```java
CompletableFuture<Void> build(final String name, final Executor syncExecutor, final Executor parallelExecutor, final ProgressMeter progressBar, final Function<Executor, CompletableFuture<Void>> preSyncTask, final Function<Executor, CompletableFuture<Void>> postSyncTask)
```
源码 :28 —（无 javadoc）

```java
default BiFunction<ModLoadingStage, Throwable, ModLoadingStage> nextModLoadingStage()
```
源码 :56 —（无 javadoc）

```java
EventGenerator<T> addCompletableFutureTaskForModDispatch(final Executor syncExecutor, final Executor parallelExecutor, final List<CompletableFuture<Void>> completableFutures, final ProgressMeter progressBar, final EventGenerator<T> eventGenerator, final BiFunction<ModLoadingStage, Throwable, ModLoadingStage> nextState, final EventGenerator<T> nextGenerator)
```
源码 :61 —（无 javadoc）

```java
ThreadSelector threadSelector()
```
源码 :82 —（无 javadoc）

```java
BiFunction<Executor, CompletableFuture<Void>, CompletableFuture<Void>> finalActivityGenerator()
```
源码 :83 —（无 javadoc）

```java
public Supplier<Stream<EventGenerator<?>>> eventFunctionStream()
```
源码 :97 —（无 javadoc）

```java
public ThreadSelector threadSelector()
```
源码 :102 —（无 javadoc）

```java
public BiFunction<Executor, CompletableFuture<Void>, CompletableFuture<Void>> finalActivityGenerator()
```
源码 :107 —（无 javadoc）

```java
public BiFunction<Executor, ? extends EventGenerator<?>, CompletableFuture<Void>> preDispatchHook()
```
源码 :112 —（无 javadoc）

```java
public BiFunction<Executor, ? extends EventGenerator<?>, CompletableFuture<Void>> postDispatchHook()
```
源码 :117 —（无 javadoc）

