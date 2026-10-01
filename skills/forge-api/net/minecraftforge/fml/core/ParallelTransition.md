# ParallelTransition

> `net.minecraftforge.fml.core.ParallelTransition` · record · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/core/ParallelTransition.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（5 个）

```java
public Supplier<Stream<EventGenerator<?>>> eventFunctionStream()
```
源码 :25 —（无 javadoc）

```java
public ThreadSelector threadSelector()
```
源码 :30 —（无 javadoc）

```java
public BiFunction<Executor, CompletableFuture<Void>, CompletableFuture<Void>> finalActivityGenerator()
```
源码 :35 —（无 javadoc）

```java
public BiFunction<Executor, ? extends EventGenerator<?>, CompletableFuture<Void>> preDispatchHook()
```
源码 :43 —（无 javadoc）

```java
public BiFunction<Executor, ? extends EventGenerator<?>, CompletableFuture<Void>> postDispatchHook()
```
源码 :48 —（无 javadoc）

