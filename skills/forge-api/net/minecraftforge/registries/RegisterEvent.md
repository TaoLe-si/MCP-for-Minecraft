# RegisterEvent

> `net.minecraftforge.registries.RegisterEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/RegisterEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event fires for each forge and vanilla registry when all registries are ready to have modded objects registered. Fired on the IModBusEvent. @see #register(ResourceKey, ResourceLocation, Supplier) @see #register(ResourceKey, Consumer)

## 公开成员（7 个）

```java
public <T> void register(ResourceKey<? extends Registry<T>> registryKey, ResourceLocation name, Supplier<T> valueSupplier)
```
源码 :54 —（无 javadoc）

```java
public <T> void register(ResourceKey<? extends Registry<T>> registryKey, Consumer<RegisterHelper<T>> consumer)
```
源码 :72 — Calls the provided consumer with a register helper if the provided registry key matches this event's registry key. @param registryKey the key of the registry to register objects to @param the type of the registry @see #register(ResourceKey, ResourceLocation, Supplier) a register variant targeted tow…

```java
public ResourceKey<? extends Registry<?>> getRegistryKey()
```
源码 :84 —（无 javadoc）

```java
public <T> IForgeRegistry<T> getForgeRegistry()
```
源码 :94 —（无 javadoc）

```java
public <T> Registry<T> getVanillaRegistry()
```
源码 :104 —（无 javadoc）

```java
public String toString()
```
源码 :110 —（无 javadoc）

```java
public interface RegisterHelper<T>
```
源码 :116 —（无 javadoc）

