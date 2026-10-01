# BusBuilder

> `net.minecraftforge.eventbus.api.BusBuilder` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/eventbus/api/BusBuilder.java` · `eventbus-6.2.33`（eventbus-6.2.33-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Build a bus

## 公开成员（11 个）

```java
public static BusBuilder builder()
```
源码 :15 —（无 javadoc）

```java
BusBuilder setTrackPhases(boolean trackPhases)
```
源码 :20 —（无 javadoc）

```java
default BusBuilder setPhasesToTrack(EnumSet<EventPriority> phases)
```
源码 :21 —（无 javadoc）

```java
default BusBuilder setPhasesToTrack(EventPriority... phases)
```
源码 :24 —（无 javadoc）

```java
default BusBuilder setPhasesToTrack(EventPriority phase)
```
源码 :27 —（无 javadoc）

```java
BusBuilder setExceptionHandler(IEventExceptionHandler handler)
```
源码 :30 —（无 javadoc）

```java
BusBuilder startShutdown()
```
源码 :31 —（无 javadoc）

```java
BusBuilder checkTypesOnDispatch()
```
源码 :32 —（无 javadoc）

```java
BusBuilder markerType(Class<?> type)
```
源码 :33 —（无 javadoc）

```java
BusBuilder useModLauncher()
```
源码 :36 —（无 javadoc）

```java
IEventBus build()
```
源码 :38 —（无 javadoc）

