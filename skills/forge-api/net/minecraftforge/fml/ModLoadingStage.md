# ModLoadingStage

> `net.minecraftforge.fml.ModLoadingStage` · enum · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/ModLoadingStage.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Mod loading stage of mod containers during the mod loading process. These will have a corresponding ModLoadingState in the basic mod loading process provided by FML. Each mod loading stage has a global DeferredWorkQueue, which is populated during the execution of the state associated with this stage and emptied at the end of the state's execution.

## 公开成员（3 个）

```java
enum 常量 ERROR, /** * Validation of the mod list. * TODO: figure out where this is used and why this exists instead of CONSTRUCT being the first normal stage */ VALIDATE, /** * Default stage of mod containers after construction. */ CONSTRUCT, /** * Common (non-side-specific) setup and initialization. */ COMMON_SETUP, /** * Side-specific setup and initialization. * * @see net.minecraftforge.api.distmarker.Dist */ SIDED_SETUP, /** * Stage for enqueuing {@link net.minecraftforge.fml.InterModComms} messages for later processing. */ ENQUEUE_IMC, /** * Stage for processing received messages though {@link net.minecraftforge.fml.InterModComms}. */ PROCESS_IMC, /** * Marks the completion of mod loading for this container. */ COMPLETE, /** * Marks the completion of the full mod loading process. */ DONE
```
源码 :20 — Special stage for exceptional situations and error handling.

```java
public ModLoadingStage currentState(Throwable exception)
```
源码 :77 — this stage, or #ERROR if the exception is not `null` @param exception the exception that occurred during this stage, may be `null`

```java
public DeferredWorkQueue getDeferredWorkQueue()
```
源码 :84 — the deferred work queue for this stage

