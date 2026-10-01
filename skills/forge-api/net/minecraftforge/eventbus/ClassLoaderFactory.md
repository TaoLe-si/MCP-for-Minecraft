# ClassLoaderFactory

> `net.minecraftforge.eventbus.ClassLoaderFactory` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/eventbus/ClassLoaderFactory.java` · `eventbus-6.2.33`（eventbus-6.2.33-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（3 个）

```java
public IEventListener create(Method method, Object target) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException
```
源码 :29 —（无 javadoc）

```java
protected Class<?> createWrapper(Method callback) throws ClassNotFoundException
```
源码 :38 —（无 javadoc）

```java
protected static void transformNode(String name, Method callback, ClassNode target)
```
源码 :53 —（无 javadoc）

