# OptionalMod

> `net.minecraftforge.fml.OptionalMod` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/OptionalMod.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（13 个）

```java
public static <M> OptionalMod<M> of(final String modId)
```
源码 :22 —（无 javadoc）

```java
public T get()
```
源码 :61 — If a mod is present in this `OptionalMod`, returns the value, otherwise throws `NoSuchElementException`. @return the modobject held by this `OptionalMod` @throws NoSuchElementException if there is no modobject present @see Optional#isPresent()

```java
public String getModId()
```
源码 :68 —（无 javadoc）

```java
public boolean isPresent()
```
源码 :77 — Return `true` if there is a mod object present, otherwise `false`. @return `true` if there is a mod object present, otherwise `false`

```java
public void ifPresent(Consumer<? super T> consumer)
```
源码 :89 — If a mod object is present, invoke the specified consumer with the object, otherwise do nothing. @param consumer block to be executed if a mod object is present @throws NullPointerException if mod object is present and `consumer` is null

```java
public OptionalMod<T> filter(Predicate<? super T> predicate)
```
源码 :105 — If a mod object is present, and the mod object matches the given predicate, return an `OptionalMod` describing the value, otherwise return an empty `OptionalMod`. @param predicate a predicate to apply to the mod object, if present @return an `OptionalMod` describing the value of this `OptionalMod` i…

```java
public<U> Optional<U> map(Function<? super T, ? extends U> mapper)
```
源码 :128 — If a mod object is present, apply the provided mapping function to it, and if the result is non-null, return an `Optional` describing the result. Otherwise return an empty `Optional`. @apiNote This method supports post-processing on optional values, without the need to explicitly check for a return…

```java
public<U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper)
```
源码 :154 — If a value is present, apply the provided `Optional`-bearing mapping function to it, return that result, otherwise return an empty `Optional`. This method is similar to #map(Function), but the provided mapper is one whose result is already an `Optional`, and if invoked, `flatMap` does not wrap it wi…

```java
public T orElse(T other)
```
源码 :170 — Return the mod object if present, otherwise return `other`. @param other the mod object to be returned if there is no mod object present, may be null @return the mod object, if present, otherwise `other`

```java
public T orElseGet(Supplier<? extends T> other)
```
源码 :184 — Return the mod object if present, otherwise invoke `other` and return the result of that invocation. @param other a `Supplier` whose result is returned if no mod object is present @return the mod object if present otherwise the result of `other.get()` @throws NullPointerException if mod object is no…

```java
public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X
```
源码 :204 — Return the contained mod object, if present, otherwise throw an exception to be created by the provided supplier. @apiNote A method reference to the exception constructor with an empty argument list can be used as the supplier. For example, `IllegalStateException::new` @param Type of the exception t…

```java
public boolean equals(Object obj)
```
源码 :213 —（无 javadoc）

```java
public int hashCode()
```
源码 :223 —（无 javadoc）

