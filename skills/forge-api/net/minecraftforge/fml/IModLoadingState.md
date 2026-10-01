# IModLoadingState

> `net.minecraftforge.fml.IModLoadingState` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/IModLoadingState.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：A mod loading state. During mod loading, the mod loader transitions between states in a defined sorted list of states, grouped into various ModLoadingPhase. @see IModStateProvider

## 公开成员（8 个）

```java
String name()
```
源码 :29 — the name of this state

```java
String previous()
```
源码 :36 — the name of the state immediately previous to this state This may be a blank name, which indicates this is either the first mod loading state or an exceptional mod loading state (such as a situation where errors prevent the loading process from continuing normally).

```java
ModLoadingPhase phase()
```
源码 :42 — the mod loading phase this state belongs to For exceptional mod loading states, this should be ModLoadingPhase#ERROR.

```java
Function<ModList, String> message()
```
源码 :47 — a function returning a human-friendly message for this state

```java
ToIntFunction<ModList> size()
```
源码 :53 — @return a function that computes the size of this transition based on the size of the modlist. Used to compute progress.

```java
Optional<Consumer<ModList>> inlineRunnable()
```
源码 :59 — an optional runnable, which runs before starting the transition from this state to the next @see #buildTransition(Executor, Executor, ProgressMeter, Function, Function)

```java
Optional<CompletableFuture<Void>> buildTransition(final Executor syncExecutor, final Executor parallelExecutor, final ProgressMeter progressBar)
```
源码 :72 —（无 javadoc）

```java
Optional<CompletableFuture<Void>> buildTransition(final Executor syncExecutor, final Executor parallelExecutor, final ProgressMeter progressBar, final Function<Executor, CompletableFuture<Void>> preSyncTask, final Function<Executor, CompletableFuture<Void>> postSyncTask)
```
源码 :93 —（无 javadoc）

