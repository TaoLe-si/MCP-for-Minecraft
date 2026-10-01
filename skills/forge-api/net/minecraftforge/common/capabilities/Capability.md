# Capability

> `net.minecraftforge.common.capabilities.Capability` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/capabilities/Capability.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This is the core holder object Capabilities. Each capability will have ONE instance of this class, and it will the the one passed into the ICapabilityProvider functions. The CapabilityManager is in charge of creating this class.

## 公开成员（3 个）

```java
public String getName() { return name; } public @NotNull <R> LazyOptional<R> orEmpty(Capability<R> toCheck, LazyOptional<T> inst)
```
源码 :28 — @return The unique name of this capability, typically this is the fully qualified class name for the target interface.

```java
public boolean isRegistered()
```
源码 :39 — @return true if something has registered this capability to the Manager. This is a marker that the class for this capability exists, and can be used.

```java
public synchronized Capability<T> addListener(Consumer<Capability<T>> listener)
```
源码 :51 — Adds a listener to be called when someone registers this capability. May be called instantly if this is already registered. @param listener Function to fire when capability is registered. @return self, in case people want to use builder pattern.

