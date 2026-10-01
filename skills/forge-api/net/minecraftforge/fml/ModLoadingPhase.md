# ModLoadingPhase

> `net.minecraftforge.fml.ModLoadingPhase` · enum · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/ModLoadingPhase.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Phases of mod loading, for grouping mod loading states.

## 公开成员（1 个）

```java
enum 常量 ERROR, /** * Phase for discovering and gathering mods for loading. */ GATHER, /** * Phase for the loading of mods found from mod discovery. * * @see #GATHER */ LOAD, /** * Phase after mod loading has completed, for post-loading tasks. * * @see #LOAD */ COMPLETE, /** * Marker phase for the last state in the full mod loading process. */ DONE }
```
源码 :17 — Special phase for exceptional situations and error handling, where mod loading cannot continue normally. There is conventionally only one state with this phase.

