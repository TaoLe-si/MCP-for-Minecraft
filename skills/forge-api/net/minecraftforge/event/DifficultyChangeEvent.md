# DifficultyChangeEvent

> `net.minecraftforge.event.DifficultyChangeEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/DifficultyChangeEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：DifficultyChangeEvent is fired when difficulty is changing. This event is fired via the ForgeHooks#onDifficultyChange(Difficulty,. This event does not have a result. HasResult This event is fired on the MinecraftForge#EVENT_BUS.

## 公开成员（3 个）

```java
public DifficultyChangeEvent(Difficulty difficulty, Difficulty oldDifficulty)
```
源码 :27 —（无 javadoc）

```java
public Difficulty getDifficulty()
```
源码 :33 —（无 javadoc）

```java
public Difficulty getOldDifficulty()
```
源码 :38 —（无 javadoc）

