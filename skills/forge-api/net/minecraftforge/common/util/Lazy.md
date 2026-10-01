# Lazy

> `net.minecraftforge.common.util.Lazy` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/util/Lazy.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Proxy object for a value that is calculated on first access @param The type of the value

## 公开成员（2 个）

```java
static <T> Lazy<T> of(@NotNull Supplier<T> supplier)
```
源码 :22 — Constructs a lazy-initialized object @param supplier The supplier for the value, to be called the first time the value is needed.

```java
static <T> Lazy<T> concurrentOf(@NotNull Supplier<T> supplier)
```
源码 :31 — Constructs a thread-safe lazy-initialized object @param supplier The supplier for the value, to be called the first time the value is needed.

