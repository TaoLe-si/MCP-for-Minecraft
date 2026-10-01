# TriPredicate

> `net.minecraftforge.common.util.TriPredicate` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/util/TriPredicate.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：A predicate that takes three arguments and returns a boolean.

## 公开成员（4 个）

```java
boolean test(T t, U u, V v)
```
源码 :16 —（无 javadoc）

```java
default TriPredicate<T, U, V> and(TriPredicate<? super T, ? super U, ? super V> other)
```
源码 :18 —（无 javadoc）

```java
default TriPredicate<T, U, V> negate()
```
源码 :23 —（无 javadoc）

```java
default TriPredicate<T, U, V> or(TriPredicate<? super T, ? super U, ? super V> other)
```
源码 :27 —（无 javadoc）

