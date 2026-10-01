# IModLocator

> `net.minecraftforge.forgespi.locating.IModLocator` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/forgespi/locating/IModLocator.java` · `forgespi-3.0.0`（forgespi-3.0.0-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Loaded as a ServiceLoader. Takes mechanisms for locating candidate "mods" and transforms them into ModFile objects.

## 公开成员（7 个）

```java
List<IModFile> scanMods()
```
源码 :34 —（无 javadoc）

```java
String name()
```
源码 :36 —（无 javadoc）

```java
Path findPath(IModFile modFile, String... path)
```
源码 :38 —（无 javadoc）

```java
void scanFile(final IModFile modFile, Consumer<Path> pathConsumer)
```
源码 :40 —（无 javadoc）

```java
Optional<Manifest> findManifest(Path file)
```
源码 :42 —（无 javadoc）

```java
void initArguments(Map<String, ?> arguments)
```
源码 :44 —（无 javadoc）

```java
boolean isValid(IModFile modFile)
```
源码 :46 —（无 javadoc）

