# SleepFinishedTimeEvent

> `net.minecraftforge.event.level.SleepFinishedTimeEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/level/SleepFinishedTimeEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is fired when all players are asleep and the time should be set to day. setWakeUpTime(wakeUpTime) sets a new time that will be added to the dayTime.

## 公开成员（3 个）

```java
public SleepFinishedTimeEvent(ServerLevel level, long newTime, long minTime)
```
源码 :20 —（无 javadoc）

```java
public long getNewTime()
```
源码 :30 — @return the new time

```java
public boolean setTimeAddition(long newTimeIn)
```
源码 :40 — Sets the new time which should be set when all players wake up @param newTimeIn The new time at wakeup @return `false` if newTimeIn was lower than current time

