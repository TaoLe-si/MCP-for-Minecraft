# IModDirectoryLocatorFactory

> `net.minecraftforge.forgespi.locating.IModDirectoryLocatorFactory` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/forgespi/locating/IModDirectoryLocatorFactory.java` · `forgespi-3.0.0`（forgespi-3.0.0-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Functional interface for generating a custom IModLocator from a directory, with a specific name. FML provides this factory at net.minecraftforge.forgespi.Environment.Keys#MODDIRECTORYFACTORY during locator construction.

## 公开成员（1 个）

```java
IModLocator build(Path directory, String name)
```
源码 :12 —（无 javadoc）

