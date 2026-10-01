# DeferredRegister

> `net.minecraftforge.registries.DeferredRegister` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/DeferredRegister.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Utility class to help with managing registry entries. Maintains a list of all suppliers for entries and registers them during the proper Register event. Suppliers should return NEW instances every time. Example Usage: `private static final DeferredRegister ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID); private static final DeferredRegister BLOCKS = DeferredRegister.create(ForgeRegi…

## 公开成员（17 个）

```java
public static <B> DeferredRegister<B> create(IForgeRegistry<B> reg, String modid)
```
源码 :66 — DeferredRegister factory for forge registries that exist before this DeferredRegister is created. If you have a supplier, do not use this method. Instead, use one of the other factories that takes in a registry key or registry name. @param reg the forge registry to wrap @param modid the namespace fo…

```java
public static <B> DeferredRegister<B> create(ResourceKey<? extends Registry<B>> key, String modid)
```
源码 :84 — DeferredRegister factory for custom forge registries or BuiltInRegistries to lookup based on the provided registry key. Supports both registries that already exist or do not exist yet. If the registry is never created, any RegistryObjects made from this DeferredRegister will throw an exception. To a…

```java
public static <B> DeferredRegister<B> createOptional(ResourceKey<? extends Registry<B>> key, String modid)
```
源码 :102 — DeferredRegister factory for the optional existence of custom forge registries or BuiltInRegistries to lookup based on the provided registry key. Supports both registries that already exist or do not exist yet. If the registry is never created, any RegistryObjects made from this DeferredRegister wil…

```java
public static <B> DeferredRegister<B> create(ResourceLocation registryName, String modid)
```
源码 :120 — DeferredRegister factory for custom forge registries or BuiltInRegistries to lookup based on the provided registry name. Supports both registries that already exist or do not exist yet. If the registry is never created, any RegistryObjects made from this DeferredRegister will throw an exception. To…

```java
public static <B> DeferredRegister<B> createOptional(ResourceLocation registryName, String modid)
```
源码 :138 — DeferredRegister factory for the optional existence of custom forge registries or BuiltInRegistries to lookup based on the provided registry name. Supports both registries that already exist or do not exist yet. If the registry is never created, any RegistryObjects made from this DeferredRegister wi…

```java
public <I extends T> RegistryObject<I> register(final String name, final Supplier<? extends I> sup)
```
源码 :175 —（无 javadoc）

```java
public Supplier<IForgeRegistry<T>> makeRegistry(final Supplier<RegistryBuilder<T>> sup)
```
源码 :207 — Only used for custom registries to fill the forge registry held in this DeferredRegister. Calls RegistryBuilder#setName automatically. @param sup Supplier of a RegistryBuilder that initializes a IForgeRegistry during the NewRegistryEvent event @return A supplier of the IForgeRegistry created by the…

```java
public TagKey<T> createTagKey(@NotNull String path)
```
源码 :222 —（无 javadoc）

```java
public TagKey<T> createTagKey(@NotNull ResourceLocation location)
```
源码 :238 —（无 javadoc）

```java
public TagKey<T> createOptionalTagKey(@NotNull String path, @NotNull Set<? extends Supplier<T>> defaults)
```
源码 :259 —（无 javadoc）

```java
public TagKey<T> createOptionalTagKey(@NotNull ResourceLocation location, @NotNull Set<? extends Supplier<T>> defaults)
```
源码 :278 —（无 javadoc）

```java
public void addOptionalTagDefaults(@NotNull TagKey<T> name, @NotNull Set<? extends Supplier<T>> defaults)
```
源码 :297 — Adds defaults to an existing tag key. The set of defaults will be bound to the tag if the tag is not loaded from any datapacks. Useful on the client side when a server may not provide a specific tag. @throws IllegalStateException If the registry name was not set. Use the factories that take #create(…

```java
public void register(IEventBus bus)
```
源码 :312 — Adds our event handler to the specified event bus, this MUST be called in order for this class to function. See DeferredRegister. @param bus The Mod Specific event bus.

```java
public static class EventDispatcher
```
源码 :319 —（无 javadoc）

```java
public Collection<RegistryObject<T>> getEntries()
```
源码 :334 — @return The unmodifiable view of registered entries. Useful for bulk operations on all values.

```java
public ResourceKey<? extends Registry<T>> getRegistryKey()
```
源码 :342 — @return The registry key stored in this deferred register. Useful for creating new deferred registers based on an existing one.

```java
public ResourceLocation getRegistryName()
```
源码 :351 —（无 javadoc）

