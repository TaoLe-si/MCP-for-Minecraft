# CapabilityProvider

> `net.minecraftforge.common.capabilities.CapabilityProvider` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/capabilities/CapabilityProvider.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（14 个）

```java
protected CapabilityProvider(Class<B> baseClass)
```
源码 :38 —（无 javadoc）

```java
protected CapabilityProvider(final Class<B> baseClass, final boolean isLazy)
```
源码 :43 —（无 javadoc）

```java
protected final void gatherCapabilities()
```
源码 :49 —（无 javadoc）

```java
protected final void gatherCapabilities(@Nullable ICapabilityProvider parent)
```
源码 :54 —（无 javadoc）

```java
protected final void gatherCapabilities(@Nullable Supplier<ICapabilityProvider> parent)
```
源码 :59 —（无 javadoc）

```java
protected final @Nullable CapabilityDispatcher getCapabilities()
```
源码 :83 —（无 javadoc）

```java
public final boolean areCapsCompatible(CapabilityProvider<B> other)
```
源码 :97 —（无 javadoc）

```java
public final boolean areCapsCompatible(@Nullable CapabilityDispatcher other)
```
源码 :102 —（无 javadoc）

```java
protected final @Nullable CompoundTag serializeCaps()
```
源码 :122 —（无 javadoc）

```java
protected final void deserializeCaps(CompoundTag tag)
```
源码 :137 —（无 javadoc）

```java
public void invalidateCaps()
```
源码 :160 —（无 javadoc）

```java
public void reviveCaps()
```
源码 :173 —（无 javadoc）

```java
public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side)
```
源码 :180 —（无 javadoc）

```java
public static class AsField<B extends ICapabilityProviderImpl<B>> extends CapabilityProvider<B>
```
源码 :190 — Special implementation for cases which have a superclass and can't extend CapabilityProvider directly. See LevelChunk

