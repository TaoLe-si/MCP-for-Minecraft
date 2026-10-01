# TimeTracker

> `net.minecraftforge.server.timings.TimeTracker` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/server/timings/TimeTracker.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：A class to assist in the collection of data to measure the update times of ticking objects {currently Tile Entities and Entities} @param

## 公开成员（7 个）

```java
public static final TimeTracker<BlockEntity> BLOCK_ENTITY_UPDATE = new TimeTracker<>()
```
源码 :30 — A tracker for timing tile entity update

```java
public static final TimeTracker<Entity> ENTITY_UPDATE = new TimeTracker<>()
```
源码 :34 — A tracker for timing entity updates

```java
public ImmutableList<ForgeTimings<T>> getTimingData()
```
源码 :48 — Returns the timings data recorded by the tracker @return An immutable list of timings data collected by this tracker

```java
public void reset()
```
源码 :62 — Resets the tracker (clears timings and stops any in-progress timings)

```java
public void trackEnd(T tracking)
```
源码 :74 — Ends the timing of the currently tracking object @param tracking The object to stop timing

```java
public void enable(int duration)
```
源码 :86 — Starts recording tracking data for the given duration in seconds @param duration The duration for the time to track

```java
public void trackStart(T toTrack)
```
源码 :97 — Starts timing of the provided object @param toTrack The object to start timing

