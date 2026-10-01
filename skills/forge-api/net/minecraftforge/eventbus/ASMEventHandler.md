# ASMEventHandler

> `net.minecraftforge.eventbus.ASMEventHandler` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/eventbus/ASMEventHandler.java` · `eventbus-6.2.33`（eventbus-6.2.33-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（6 个）

```java
protected final IEventListener handler
```
源码 :14 —（无 javadoc）

```java
public ASMEventHandler(IEventListenerFactory factory, Object target, Method method, boolean isGeneric) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException
```
源码 :23 —（无 javadoc）

```java
public void invoke(Event event)
```
源码 :52 —（无 javadoc）

```java
public EventPriority getPriority()
```
源码 :59 —（无 javadoc）

```java
public String toString()
```
源码 :63 —（无 javadoc）

```java
public static ASMEventHandler of(IEventListenerFactory factory, Object target, Method method, boolean isGeneric) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException
```
源码 :77 — Creates a new ASMEventHandler instance, factoring in a time-shifting optimisation. In the case that no post-time checks are needed, an anonymous subclass instance will be returned that calls the listener without additional redundant checks. @implNote The 'all or nothing' nature of the post-time chec…

