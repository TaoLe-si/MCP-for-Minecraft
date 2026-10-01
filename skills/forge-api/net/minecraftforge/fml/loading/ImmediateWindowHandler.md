# ImmediateWindowHandler

> `net.minecraftforge.fml.loading.ImmediateWindowHandler` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/loading/ImmediateWindowHandler.java` · `fmlloader-1.20.1-47.4.10`（fmlloader-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（9 个）

```java
public static void load(final String launchTarget, final String[] arguments)
```
源码 :25 —（无 javadoc）

```java
public static long setupMinecraftWindow(final IntSupplier width, final IntSupplier height, final Supplier<String> title, final LongSupplier monitor)
```
源码 :53 —（无 javadoc）

```java
public static boolean positionWindow(Optional<Object> monitor,IntConsumer widthSetter, IntConsumer heightSetter, IntConsumer xSetter, IntConsumer ySetter)
```
源码 :57 —（无 javadoc）

```java
public static void updateFBSize(IntConsumer width, IntConsumer height)
```
源码 :61 —（无 javadoc）

```java
public static <T> Supplier<T> loadingOverlay(Supplier<?> mc, Supplier<?> ri, Consumer<Optional<Throwable>> ex, boolean fade)
```
源码 :65 —（无 javadoc）

```java
public static void acceptGameLayer(final ModuleLayer layer)
```
源码 :70 —（无 javadoc）

```java
public static void renderTick()
```
源码 :74 —（无 javadoc）

```java
public static String getGLVersion()
```
源码 :78 —（无 javadoc）

```java
public static void updateProgress(final String message)
```
源码 :81 —（无 javadoc）

