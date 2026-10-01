# LazyOptional

> `net.minecraftforge.common.util.LazyOptional` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/util/LazyOptional.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This object encapsulates a lazy value, with typical transformation operations (map/ifPresent) available, much like Optional. It also provides the ability to listen for invalidation, via #addListener(NonNullConsumer). This method is invoked when the provider of this object calls #invalidate(). To create an instance of this class, use #of(NonNullSupplier). Note that this accepts a NonNullSupplier, s…

## 公开成员（15 个）

```java
public static <T> LazyOptional<T> of(final @Nullable NonNullSupplier<T> instanceSupplier)
```
源码 :65 — Construct a new LazyOptional that wraps the given NonNullSupplier. @param instanceSupplier The NonNullSupplier to wrap. Cannot return null, but can be null itself. If null, this method returns #empty().

```java
public static <T> LazyOptional<T> empty()
```
源码 :72 — @return The singleton empty instance

```java
public <X> LazyOptional<X> cast()
```
源码 :84 —（无 javadoc）

```java
public boolean isPresent()
```
源码 :122 — Check if this LazyOptional is non-empty. @return `true` if this LazyOptional is non-empty, i.e. holds a non-null supplier

```java
public void ifPresent(NonNullConsumer<? super T> consumer)
```
源码 :133 — If non-empty, invoke the specified NonNullConsumer with the object, otherwise do nothing. @param consumer The NonNullConsumer to run if this optional is non-empty. @throws NullPointerException if `consumer` is null and this LazyOptional is non-empty

```java
public <U> LazyOptional<U> lazyMap(NonNullFunction<? super T, ? extends U> mapper)
```
源码 :159 — If a this LazyOptional is non-empty, return a new LazyOptional encapsulating the mapping function. Otherwise, returns #empty(). The supplier inside this object is NOT resolved. @apiNote This method supports post-processing on optional values, without the need to explicitly check for a return status.…

```java
public <U> Optional<U> map(NonNullFunction<? super T, ? extends U> mapper)
```
源码 :178 — If a this LazyOptional is non-empty, return a new Optional encapsulating the mapped value. Otherwise, returns Optional#empty(). @apiNote This method explicitly resolves the value of the LazyOptional. For a non-resolving mapper that will lazily run the mapping, use #lazyMap(NonNullFunction). @param m…

```java
public Optional<T> filter(NonNullPredicate<? super T> predicate)
```
源码 :199 — Resolve the contained supplier if non-empty, and filter it by the given NonNullPredicate, returning empty if false. It is important to note that this method is not lazy, as it must resolve the value of the supplier to validate it with the predicate. @param predicate A NonNullPredicate to apply to th…

```java
public Optional<T> resolve()
```
源码 :209 — Resolves the value of this LazyOptional, turning it into a standard non-lazy Optional @return The resolved optional.

```java
public T orElse(T other)
```
源码 :220 — Resolve the contained supplier if non-empty and return the result, otherwise return `other`. @param other the value to be returned if this LazyOptional is empty @return the result of the supplier, if non-empty, otherwise `other`

```java
public T orElseGet(NonNullSupplier<? extends T> other)
```
源码 :236 — Resolve the contained supplier if non-empty and return the result, otherwise return the result of `other`. @param other A NonNullSupplier whose result is returned if this LazyOptional is empty @return The result of the supplier, if non-empty, otherwise the result of `other.get()` @throws NullPointer…

```java
public <X extends Throwable> T orElseThrow(NonNullSupplier<? extends X> exceptionSupplier) throws X
```
源码 :257 — Resolve the contained supplier if non-empty and return the result, otherwise throw the exception created by the provided NonNullSupplier. @apiNote A method reference to the exception constructor with an empty argument list can be used as the supplier. For example, `IllegalStateException::new` @param…

```java
public void addListener(NonNullConsumer<LazyOptional<T>> listener)
```
源码 :269 — Register a NonNullConsumer that will be called when this LazyOptional becomes invalid (via #invalidate()). If this LazyOptional is empty, the listener will be called immediately.

```java
public void removeListener(NonNullConsumer<LazyOptional<T>> listener)
```
源码 :280 — Unregisters a NonNullConsumer from the list to be notified when this LazyOptional becomes invalid (via #invalidate()). This allows modder who know they will not need to be notified, to remove the hard reference that this holds to their listener.

```java
public void invalidate()
```
源码 :298 — Invalidate this LazyOptional, making it unavailable for further use, and notifying any #addListener(NonNullConsumer) that this has become invalid and they should update. This would typically be used with capability objects. For example, a TE would call this, if they are covered with a microblock pan…

