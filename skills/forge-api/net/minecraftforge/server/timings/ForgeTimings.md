# ForgeTimings

> `net.minecraftforge.server.timings.ForgeTimings` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/server/timings/ForgeTimings.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：ForgeTimings aggregates timings data collected by TimeTracker for an Object and performs operations for interpretation of the data. @param

## 公开成员（3 个）

```java
public ForgeTimings(T object, int[] rawTimingData)
```
源码 :23 —（无 javadoc）

```java
public WeakReference<T> getObject()
```
源码 :34 — Retrieves the object that the timings are for @return The object

```java
public double getAverageTimings()
```
源码 :45 — Averages the raw timings data collected @return An average of the raw timing data

