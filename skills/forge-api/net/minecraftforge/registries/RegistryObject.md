# RegistryObject

> `net.minecraftforge.registries.RegistryObject` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/RegistryObject.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（21 个）

```java
public static <T, U extends T> RegistryObject<U> create(final ResourceLocation name, IForgeRegistry<T> registry)
```
源码 :43 — Factory for a RegistryObject that stores the value of an object from the provided forge registry once it is ready. @param name the name of the object to look up in the forge registry @param registry the forge registry @return a RegistryObject that stores the value of an object from the provided forg…

```java
public static <T, U extends T> RegistryObject<U> create(final ResourceLocation name, final ResourceKey<? extends Registry<T>> registryKey, String modid)
```
源码 :62 — Factory for a RegistryObject that stores the value of an object from a registry once it is ready based on a lookup of the provided registry key. If a registry with the given key cannot be found, an exception will be thrown when trying to fill this RegistryObject. Use #createOptional(ResourceLocation…

```java
public static <T, U extends T> RegistryObject<U> createOptional(final ResourceLocation name, final ResourceKey<? extends Registry<T>> registryKey, String modid)
```
源码 :82 — Factory for a RegistryObject that optionally stores the value of an object from a registry once it is ready if the registry exists based on a lookup of the provided registry key. If a registry with the given key cannot be found, it will be silently ignored and this RegistryObject will not be filled.…

```java
public static <T, U extends T> RegistryObject<U> create(final ResourceLocation name, final ResourceLocation registryName, String modid)
```
源码 :102 — Factory for a RegistryObject that stores the value of an object from a registry once it is ready based on a lookup of the provided registry name. If a registry with the given name cannot be found, an exception will be thrown when trying to fill this RegistryObject. Use #createOptional(ResourceLocati…

```java
public static <T, U extends T> RegistryObject<U> createOptional(final ResourceLocation name, final ResourceLocation registryName, String modid)
```
源码 :122 — Factory for a RegistryObject that optionally stores the value of an object from a registry once it is ready if the registry exists based on a lookup of the provided registry name. If a registry with the given name cannot be found, it will be silently ignored and this RegistryObject will not be fille…

```java
public T get()
```
源码 :201 —（无 javadoc）

```java
public ResourceLocation getId()
```
源码 :287 —（无 javadoc）

```java
public ResourceKey<T> getKey()
```
源码 :299 —（无 javadoc）

```java
public Stream<T> stream()
```
源码 :304 —（无 javadoc）

```java
public boolean isPresent()
```
源码 :313 — Return `true` if there is a mod object present, otherwise `false`. @return `true` if there is a mod object present, otherwise `false`

```java
public void ifPresent(Consumer<? super T> consumer)
```
源码 :325 — If a mod object is present, invoke the specified consumer with the object, otherwise do nothing. @param consumer block to be executed if a mod object is present @throws NullPointerException if mod object is present and `consumer` is null

```java
public RegistryObject<T> filter(Predicate<? super T> predicate)
```
源码 :341 — If a mod object is present, and the mod object matches the given predicate, return an `RegistryObject` describing the value, otherwise return an empty `RegistryObject`. @param predicate a predicate to apply to the mod object, if present @return an `RegistryObject` describing the value of this `Regis…

```java
public<U> Optional<U> map(Function<? super T, ? extends U> mapper)
```
源码 :364 — If a mod object is present, apply the provided mapping function to it, and if the result is non-null, return an `Optional` describing the result. Otherwise return an empty `Optional`. @apiNote This method supports post-processing on optional values, without the need to explicitly check for a return…

```java
public<U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper)
```
源码 :390 — If a value is present, apply the provided `Optional`-bearing mapping function to it, return that result, otherwise return an empty `Optional`. This method is similar to #map(Function), but the provided mapper is one whose result is already an `Optional`, and if invoked, `flatMap` does not wrap it wi…

```java
public<U> Supplier<U> lazyMap(Function<? super T, ? extends U> mapper)
```
源码 :414 — If a mod object is present, lazily apply the provided mapping function to it, returning a supplier for the transformed result. If this object is empty, or the mapping function returns `null`, the supplier will return `null`. @apiNote This method supports post-processing on optional values, without t…

```java
public T orElse(T other)
```
源码 :426 — Return the mod object if present, otherwise return `other`. @param other the mod object to be returned if there is no mod object present, may be null @return the mod object, if present, otherwise `other`

```java
public T orElseGet(Supplier<? extends T> other)
```
源码 :440 — Return the mod object if present, otherwise invoke `other` and return the result of that invocation. @param other a `Supplier` whose result is returned if no mod object is present @return the mod object if present otherwise the result of `other.get()` @throws NullPointerException if mod object is no…

```java
public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X
```
源码 :460 — Return the contained mod object, if present, otherwise throw an exception to be created by the provided supplier. @apiNote A method reference to the exception constructor with an empty argument list can be used as the supplier. For example, `IllegalStateException::new` @param Type of the exception t…

```java
public Optional<Holder<T>> getHolder()
```
源码 :479 —（无 javadoc）

```java
public boolean equals(Object obj)
```
源码 :485 —（无 javadoc）

```java
public int hashCode()
```
源码 :495 —（无 javadoc）

