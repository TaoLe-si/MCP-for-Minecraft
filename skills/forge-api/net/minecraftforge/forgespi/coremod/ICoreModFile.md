# ICoreModFile

> `net.minecraftforge.forgespi.coremod.ICoreModFile` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/forgespi/coremod/ICoreModFile.java` · `forgespi-3.0.0`（forgespi-3.0.0-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Interface for core mods to discover content and properties of their location and context to the coremod implementation.

## 公开成员（4 个）

```java
String getOwnerId()
```
源码 :11 —（无 javadoc）

```java
Reader readCoreMod() throws IOException
```
源码 :12 —（无 javadoc）

```java
Path getPath()
```
源码 :13 —（无 javadoc）

```java
Reader getAdditionalFile(final String fileName) throws IOException
```
源码 :14 —（无 javadoc）

