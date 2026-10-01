# BrainBuilder

> `net.minecraftforge.common.util.BrainBuilder` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/util/BrainBuilder.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This object is used to encapsulate state found inside a Brain instance, to make it easily accessible for modders to manipulate during net.minecraftforge.event.entity.living.LivingMakeBrainEvent. Provided are a variety of getter/setter methods to access and manipulate the encapsulated state. Methods marked with "INTENDED FOR INTERNAL USE" are only meant to be used inside: net.minecraftforge.common.…

## 公开成员（23 个）

```java
public BrainBuilder(Brain<E> ignoredBrain) {} public Brain.Provider<E> provider()
```
源码 :54 —（无 javadoc）

```java
public Collection<MemoryModuleType<?>> getMemoryTypes()
```
源码 :60 —（无 javadoc）

```java
public Collection<SensorType<? extends Sensor<? super E>>> getSensorTypes()
```
源码 :64 —（无 javadoc）

```java
public Map<Integer, Map<Activity, Set<BehaviorControl<? super E>>>> getAvailableBehaviorsByPriority()
```
源码 :68 —（无 javadoc）

```java
public Schedule getSchedule()
```
源码 :72 —（无 javadoc）

```java
public void setSchedule(Schedule schedule)
```
源码 :76 —（无 javadoc）

```java
public Map<Activity, Set<Pair<MemoryModuleType<?>, MemoryStatus>>> getActivityRequirements()
```
源码 :80 —（无 javadoc）

```java
public Map<Activity, Set<MemoryModuleType<?>>> getActivityMemoriesToEraseWhenStopped()
```
源码 :84 —（无 javadoc）

```java
public Set<Activity> getCoreActivities()
```
源码 :88 —（无 javadoc）

```java
public Activity getDefaultActivity()
```
源码 :92 —（无 javadoc）

```java
public void setDefaultActivity(Activity defaultActivity)
```
源码 :96 —（无 javadoc）

```java
public Set<Activity> getActiveActivites()
```
源码 :100 —（无 javadoc）

```java
public void setActiveActivites(Set<Activity> value)
```
源码 :104 —（无 javadoc）

```java
public void addBehaviorToActivityByPriority(Integer priority, Activity activity, BehaviorControl<? super E> behaviorControl)
```
源码 :110 — You may use this as a helper method for adding a behavior to an Activity by priority to an entity's brain.

```java
public void addRequirementsToActivity(Activity activity, Collection<Pair<MemoryModuleType<?>, MemoryStatus>> requirements)
```
源码 :115 — You may use this as a helper method for adding memory requirements for an Activity to an entity's brain.

```java
public void addMemoriesToEraseWhenActivityStopped(Activity activity, Collection<MemoryModuleType<?>> memories)
```
源码 :120 — You may use this as a helper method for adding a collection of memories to erase when an Activity is stopped to entity's brain.

```java
public void addAvailableBehaviorsByPriorityFrom(Map<Integer, Map<Activity, Set<BehaviorControl<? super E>>>> addFrom)
```
源码 :129 —（无 javadoc）

```java
public void addAvailableBehaviorsByPriorityTo(Map<Integer, Map<Activity, Set<BehaviorControl<? super E>>>> addTo)
```
源码 :134 —（无 javadoc）

```java
public void addActivityRequirementsFrom(Map<Activity, Set<Pair<MemoryModuleType<?>, MemoryStatus>>> addFrom)
```
源码 :139 —（无 javadoc）

```java
public void addActivityRequirementsTo(Map<Activity, Set<Pair<MemoryModuleType<?>, MemoryStatus>>> addTo)
```
源码 :144 —（无 javadoc）

```java
public void addActivityMemoriesToEraseWhenStoppedFrom(Map<Activity, Set<MemoryModuleType<?>>> addFrom)
```
源码 :149 —（无 javadoc）

```java
public void addActivityMemoriesToEraseWhenStoppedTo(Map<Activity, Set<MemoryModuleType<?>>> addTo)
```
源码 :154 —（无 javadoc）

```java
public Brain<E> makeBrain(Dynamic<?> dynamic)
```
源码 :167 —（无 javadoc）

