# IModLanguageProvider

> `net.minecraftforge.forgespi.language.IModLanguageProvider` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/forgespi/language/IModLanguageProvider.java` · `forgespi-3.0.0`（forgespi-3.0.0-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Loaded as a ServiceLoader, from the classpath. ExtensionPoint are loaded from the mods directory, with the FMLType META-INF of LANGPROVIDER. Version data is read from the manifest's implementation version.

## 公开成员（3 个）

```java
String name()
```
源码 :33 —（无 javadoc）

```java
Consumer<ModFileScanData> getFileVisitor()
```
源码 :35 —（无 javadoc）

```java
<R extends ILifecycleEvent<R>> void consumeLifecycleEvent(Supplier<R> consumeEvent)
```
源码 :37 —（无 javadoc）

