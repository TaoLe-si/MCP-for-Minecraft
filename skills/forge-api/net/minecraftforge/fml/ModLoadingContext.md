# ModLoadingContext

> `net.minecraftforge.fml.ModLoadingContext` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/ModLoadingContext.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（13 个）

```java
public static ModLoadingContext get()
```
源码 :28 —（无 javadoc）

```java
public void setActiveContainer(final ModContainer container)
```
源码 :36 —（无 javadoc）

```java
public ModContainer getActiveContainer()
```
源码 :46 —（无 javadoc）

```java
public String getActiveNamespace()
```
源码 :51 —（无 javadoc）

```java
public ModContainer getContainer()
```
源码 :55 —（无 javadoc）

```java
public <T extends Record & IExtensionPoint<T>> void registerExtensionPoint(Class<? extends IExtensionPoint<T>> point, Supplier<T> extension)
```
源码 :65 — Register an IExtensionPoint with the mod container. @param point The extension point to register @param extension An extension operator @param The type signature of the extension operator

```java
public void registerDisplayTest(IExtensionPoint.DisplayTest displayTest)
```
源码 :74 — Register a IExtensionPoint.DisplayTest with the mod container. A shorthand for registering a DisplayTest with #registerExtensionPoint(Class,. @param displayTest The IExtensionPoint.DisplayTest to register

```java
public void registerDisplayTest(Supplier<IExtensionPoint.DisplayTest> displayTest)
```
源码 :83 — Register a IExtensionPoint.DisplayTest with the mod container. A shorthand for registering a DisplayTest supplier with #registerExtensionPoint(Class,. @param displayTest The Supplier to register

```java
public void registerDisplayTest(String version, BiPredicate<String, Boolean> remoteVersionTest)
```
源码 :93 — Register a IExtensionPoint.DisplayTest with the mod container. A shorthand for registering a DisplayTest with #registerExtensionPoint(Class, that also creates the DisplayTest instance for you using the provided parameters. @see IExtensionPoint.DisplayTest#DisplayTest(String, BiPredicate)

```java
public void registerDisplayTest(Supplier<String> suppliedVersion, BiPredicate<String, Boolean> remoteVersionTest)
```
源码 :103 — Register a IExtensionPoint.DisplayTest with the mod container. A shorthand for registering a DisplayTest with #registerExtensionPoint(Class, that also creates the DisplayTest instance for you using the provided parameters. @see IExtensionPoint.DisplayTest#DisplayTest(Supplier, BiPredicate)

```java
public void registerConfig(ModConfig.Type type, IConfigSpec<?> spec)
```
源码 :107 —（无 javadoc）

```java
public void registerConfig(ModConfig.Type type, IConfigSpec<?> spec, String fileName)
```
源码 :118 —（无 javadoc）

```java
public <T> T extension()
```
源码 :131 —（无 javadoc）

