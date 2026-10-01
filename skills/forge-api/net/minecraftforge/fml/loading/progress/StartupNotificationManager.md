# StartupNotificationManager

> `net.minecraftforge.fml.loading.progress.StartupNotificationManager` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/loading/progress/StartupNotificationManager.java` · `fmlloader-1.20.1-47.4.10`（fmlloader-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（9 个）

```java
public static List<ProgressMeter> getCurrentProgress()
```
源码 :21 —（无 javadoc）

```java
public static ProgressMeter prependProgressBar(final String barName, final int count)
```
源码 :27 —（无 javadoc）

```java
public static ProgressMeter addProgressBar(final String barName, final int count)
```
源码 :34 —（无 javadoc）

```java
public static void popBar(final ProgressMeter progressMeter)
```
源码 :42 —（无 javadoc）

```java
public record AgeMessage(int age, Message message) {} public static List<AgeMessage> getMessages()
```
源码 :48 —（无 javadoc）

```java
public static void addModMessage(final String message)
```
源码 :80 —（无 javadoc）

```java
public static Optional<Consumer<String>> modLoaderConsumer()
```
源码 :85 —（无 javadoc）

```java
public static Optional<Consumer<String>> locatorConsumer()
```
源码 :89 —（无 javadoc）

```java
public static Optional<Consumer<String>> mcLoaderConsumer()
```
源码 :93 —（无 javadoc）

