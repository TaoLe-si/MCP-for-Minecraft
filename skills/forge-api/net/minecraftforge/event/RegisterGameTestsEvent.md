# RegisterGameTestsEvent

> `net.minecraftforge.event.RegisterGameTestsEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/RegisterGameTestsEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Game tests are registered on client or server startup. It is only run once for a given instance of the game if ForgeGameTestHooks#isGametestEnabled returns true. This is the preferred way to register your game tests. Fired on the Mod bus, see IModBusEvent.

## 公开成员（3 个）

```java
public RegisterGameTestsEvent(Set<Method> gameTestMethods)
```
源码 :29 —（无 javadoc）

```java
public void register(Class<?> testClass)
```
源码 :42 — Registers an entire class to the game test registry. All methods annotated with GameTest or GameTestGenerator will be registered. If the set of enabled namespaces is non-empty, a method will only be registered if its GameTest#templateNamespace() is in an enabled namespace. @param testClass the test…

```java
public void register(Method testMethod)
```
源码 :55 — Registers a single method to the game test registry. The method will only be registered if it is annotated with GameTest or GameTestGenerator. If the set of enabled namespaces is non-empty, the method will only be registered if its GameTest#templateNamespace() is an enabled namespace. @param testMet…

