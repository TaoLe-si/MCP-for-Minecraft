# CapabilityDispatcher

> `net.minecraftforge.common.capabilities.CapabilityDispatcher` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/capabilities/CapabilityDispatcher.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：A high-speed implementation of a capability delegator. This is used to wrap the results of the AttachCapabilitiesEvent. It is HIGHLY recommended that you DO NOT use this approach unless you MUST delegate to multiple providers instead just implement y our handlers using normal if statements. Internally the handlers are baked into arrays for fast iteration. The ResourceLocations will be used for the…

## 公开成员（7 个）

```java
public CapabilityDispatcher(Map<ResourceLocation, ICapabilityProvider> list, List<Runnable> listeners)
```
源码 :43 —（无 javadoc）

```java
public CapabilityDispatcher(Map<ResourceLocation, ICapabilityProvider> list, List<Runnable> listeners, @Nullable ICapabilityProvider parent)
```
源码 :49 —（无 javadoc）

```java
public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side)
```
源码 :84 —（无 javadoc）

```java
public CompoundTag serializeNBT()
```
源码 :109 —（无 javadoc）

```java
public void deserializeNBT(CompoundTag nbt)
```
源码 :120 —（无 javadoc）

```java
public boolean areCompatible(@Nullable CapabilityDispatcher other)
```
源码 :131 —（无 javadoc）

```java
public void invalidate()
```
源码 :138 —（无 javadoc）

