# ModLoadingState

> `net.minecraftforge.fml.ModLoadingState` · record · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/ModLoadingState.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Implementation of the IModLoadingState interface. @param name the name of this state @param previous the name of the state immediately previous to this state @param message a function returning a human-friendly message for this state @param phase the mod loading phase this state belongs to @param inlineRunnable an optional runnable, which runs before starting the transition from this state to the…

## 公开成员（5 个）

```java
public <T extends Event & IModBusEvent> Optional<CompletableFuture<Void>> buildTransition(final Executor syncExecutor, final Executor parallelExecutor, final ProgressMeter progressBar, final Function<Executor, CompletableFuture<Void>> preSyncTask, final Function<Executor, CompletableFuture<Void>> postSyncTask)
```
源码 :36 —（无 javadoc）

```java
public static ModLoadingState empty(final String name, final String previous, final ModLoadingPhase phase)
```
源码 :53 — an empty mod loading state The mod loading state has a blank human-readable message, no inline runnable, and no state transition information. @param name the name of the state @param previous the name of the immediately previous state to this state @param phase the mod loading phase the state belong…

```java
public static ModLoadingState withTransition(final String name, final String previous, final ModLoadingPhase phase, final IModStateTransition transition)
```
源码 :67 — Returns a mod loading state with state transition information and a default human-friendly message of `Processing transition [name]`. @param name the name of the state @param previous the name of the immediately previous state to this state @param phase the mod loading phase the state belongs to @pa…

```java
public static ModLoadingState withTransition(final String name, final String previous, final Function<ModList, String> message, final ModLoadingPhase phase, final IModStateTransition transition)
```
源码 :82 — Returns a mod loading state with state transition information and a custom human-friendly message function. @param name the name of the state @param previous the name of the immediately previous state to this state @param message a function returning a human-friendly message for this state @param ph…

```java
public static ModLoadingState withInline(final String name, final String previous, final ModLoadingPhase phase, final Consumer<ModList> inline)
```
源码 :98 — Returns a mod loading state with an inline runnable and a default human-friendly message of `Processing work [name]`. @param name the name of the state @param previous the name of the immediately previous state to this state @param phase the mod loading phase the state belongs to @param inline an op…

