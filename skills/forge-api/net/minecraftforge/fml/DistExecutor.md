# DistExecutor

> `net.minecraftforge.fml.DistExecutor` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/DistExecutor.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目用法**：分侧执行：客户端才装 ClientHooks，专服上不加载客户端类

**职责**（源码 javadoc）：Use to execute code conditionally based on sidedness. When you want to call something on one side and return a result #safeCallWhenOn(Dist, When you want to call one thing on one side, another thing on the other and return a result #safeRunForDist(Supplier, When you want to run something on one side #safeRunWhenOn(Dist,

## 公开成员（10 个）

```java
public static <T> T callWhenOn(Dist dist, Supplier<Callable<T>> toRun)
```
源码 :50 —（无 javadoc）

```java
public static <T> T unsafeCallWhenOn(Dist dist, Supplier<Callable<T>> toRun)
```
源码 :54 —（无 javadoc）

```java
public static <T> T safeCallWhenOn(Dist dist, Supplier<SafeCallable<T>> toRun)
```
源码 :78 — Call the SafeCallable when on the correct Dist. The lambda supplied here is required to be a method reference to a method defined in another class, otherwise an invalid SafeReferent error will be thrown @param dist the dist which this will run on @param toRun the SafeCallable to run and return the r…

```java
public static void runWhenOn(Dist dist, Supplier<Runnable> toRun)
```
源码 :94 —（无 javadoc）

```java
public static void unsafeRunWhenOn(Dist dist, Supplier<Runnable> toRun)
```
源码 :109 — Runs the supplied Runnable on the speicified side. Same warnings apply as #unsafeCallWhenOn(Dist,. This method can cause unexpected ClassNotFoundException problems in common scenarios. Understand the pitfalls of the way the class verifier works to load classes before using this. Use #safeRunWhenOn(D…

```java
public static void safeRunWhenOn(Dist dist, Supplier<SafeRunnable> toRun)
```
源码 :120 — Call the supplied SafeRunnable when on the correct Dist. @param dist The dist to run on @param toRun The code to run

```java
public static <T> T runForDist(Supplier<Supplier<T>> clientTarget, Supplier<Supplier<T>> serverTarget)
```
源码 :142 —（无 javadoc）

```java
public static <T> T unsafeRunForDist(Supplier<Supplier<T>> clientTarget, Supplier<Supplier<T>> serverTarget)
```
源码 :156 — Unsafe version of #safeRunForDist(Supplier,. Use only when you know what you're doing and understand why the verifier can cause unexpected ClassNotFoundException crashes even when code is apparently not sided. Ensure you test both sides fully to be confident in using this. @param clientTarget The su…

```java
public static <T> T safeRunForDist(Supplier<SafeSupplier<T>> clientTarget, Supplier<SafeSupplier<T>> serverTarget)
```
源码 :181 — Executes one of the two suppliers, based on which side is active. Example (replacement for old SidedProxy): `Proxy p = DistExecutor.safeRunForDist(()->ClientProxy::new, ()->ServerProxy::new);` NOTE: the double supplier is required to avoid classloading the secondary target. @param clientTarget The s…

```java
public interface SafeReferent {} /** * SafeCallable version of {@link SafeReferent}. * @see SafeReferent * @param <T> The return type of the Callable */ public interface SafeCallable<T> extends SafeReferent, Callable<T>, Serializable {} /** * SafeSupplier version of {@link SafeReferent} * @param <T> The return type of the Supplier */ public interface SafeSupplier<T> extends SafeReferent, Supplier<T>, Serializable {} /** * SafeRunnable version of {@link SafeReferent} */ public interface SafeRunnable extends SafeReferent, Runnable, Serializable {} private static final void validateSafeReferent(Supplier<? extends SafeReferent> safeReferentSupplier)
```
源码 :214 — A safe referent. This will assert that it is being called via a separated class method reference. This will avoid the common pitfalls of #callWhenOn(Dist, above. SafeReferents assert that they are defined as a separate method outside the scope of the calling class. Implementations need to be defined…

