# FireworkShapeFactoryRegistry

> `net.minecraftforge.client.FireworkShapeFactoryRegistry` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/FireworkShapeFactoryRegistry.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Keeps track of custom firework shape types, because Particle is client side only this can't be on the Shape itself. So sometime during your client initalization call register.

## 公开成员（3 个）

```java
public static interface Factory
```
源码 :23 —（无 javadoc）

```java
public static void register(FireworkRocketItem.Shape shape, Factory factory)
```
源码 :27 —（无 javadoc）

```java
public static Factory get(FireworkRocketItem.Shape shape)
```
源码 :32 —（无 javadoc）

