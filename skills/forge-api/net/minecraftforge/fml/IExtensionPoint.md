# IExtensionPoint

> `net.minecraftforge.fml.IExtensionPoint` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/IExtensionPoint.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：An extension point for a mod container. An extension point can be registered for a mod container using ModContainer#registerExtensionPoint(Class, and retrieved (if present) using ModContainer#getCustomExtension(Class). An extension point allows a mod to supply an arbitrary value as a record class to another mod or framework through their mod container class, avoiding the use of InterModComms or ot…

## 公开成员（1 个）

```java
record DisplayTest(Supplier<String> suppliedVersion, BiPredicate<String, Boolean> remoteVersionTest) implements IExtensionPoint<DisplayTest>
```
源码 :96 —（无 javadoc）

