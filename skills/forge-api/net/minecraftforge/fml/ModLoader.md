# ModLoader

> `net.minecraftforge.fml.ModLoader` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/ModLoader.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Loads mods. Dispatch cycle is seen in `#loadMods()` and `#finishMods()` Overall sequence for loadMods is: CONSTRUCT Constructs the mod instance. Mods can typically setup basic environment such as Event listeners and Configuration specifications here. Automated dispatches Dispatches automated elements : `net.minecraftforge.fml.common.Mod.EventBusSubscriber`, `net.minecraftforge.event.RegistryEvent`…

## 公开成员（14 个）

```java
public static ModLoader get()
```
源码 :126 —（无 javadoc）

```java
public void gatherAndInitializeMods(final ModWorkManager.DrivenExecutor syncExecutor, final Executor parallelExecutor, final Runnable periodicTask)
```
源码 :137 — Run on the primary starting thread by ClientModLoader and ServerModLoader @param syncExecutor An executor to run tasks on the main thread @param parallelExecutor An executor to run tasks on a parallel loading thread pool @param periodicTask Optional periodic task to perform on the main thread while…

```java
public void loadMods(final ModWorkManager.DrivenExecutor syncExecutor, final Executor parallelExecutor, final Runnable periodicTask)
```
源码 :187 —（无 javadoc）

```java
public void finishMods(final ModWorkManager.DrivenExecutor syncExecutor, final Executor parallelExecutor, final Runnable periodicTask)
```
源码 :194 —（无 javadoc）

```java
public static boolean isLoadingStateValid()
```
源码 :304 — @return If the current mod loading state is valid. Use if you interact with vanilla systems directly during loading and don't want to cause extraneous crashes due to trying to do things that aren't possible in a "broken load"

```java
public boolean hasCompletedState(final String stateName)
```
源码 :308 —（无 javadoc）

```java
public <T extends Event & IModBusEvent> void runEventGenerator(Function<ModContainer, T> generator)
```
源码 :313 —（无 javadoc）

```java
public <T extends Event & IModBusEvent> void postEvent(T e)
```
源码 :321 —（无 javadoc）

```java
public <T extends Event & IModBusEvent> T postEventWithReturn(T e)
```
源码 :328 —（无 javadoc）

```java
public <T extends Event & IModBusEvent> void postEventWrapContainerInModOrder(T event)
```
源码 :336 —（无 javadoc）

```java
public <T extends Event & IModBusEvent> void postEventWithWrapInModOrder(T e, BiConsumer<ModContainer, T> pre, BiConsumer<ModContainer, T> post)
```
源码 :339 —（无 javadoc）

```java
public List<ModLoadingWarning> getWarnings()
```
源码 :351 —（无 javadoc）

```java
public void addWarning(ModLoadingWarning warning)
```
源码 :356 —（无 javadoc）

```java
public static boolean isDataGenRunning ()
```
源码 :363 —（无 javadoc）

