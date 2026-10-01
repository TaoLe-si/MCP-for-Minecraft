# NonNullLazy

> `net.minecraftforge.common.util.NonNullLazy` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/util/NonNullLazy.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Proxy object for a value that is calculated on first access. Same as Lazy, but with a nonnull contract. @param The type of the value

## 公开成员（2 个）

```java
static <T> NonNullLazy<T> of(@NotNull NonNullSupplier<T> supplier)
```
源码 :22 — Constructs a lazy-initialized object @param supplier The supplier for the value, to be called the first time the value is needed.

```java
static <T> NonNullLazy<T> concurrentOf(@NotNull NonNullSupplier<T> supplier)
```
源码 :32 — Constructs a thread-safe lazy-initialized object @param supplier The supplier for the value, to be called the first time the value is needed.

