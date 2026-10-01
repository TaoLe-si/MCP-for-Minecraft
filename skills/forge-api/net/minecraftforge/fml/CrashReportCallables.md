# CrashReportCallables

> `net.minecraftforge.fml.CrashReportCallables` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/CrashReportCallables.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（4 个）

```java
public static void registerCrashCallable(ISystemReportExtender callable)
```
源码 :25 — Register a custom ISystemReportExtender

```java
public static void registerCrashCallable(String headerName, Supplier<String> reportGenerator)
```
源码 :36 — Register a ISystemReportExtender with the given header name and content generator, which will always be appended to the system report @param headerName The name of the system report entry @param reportGenerator The report generator to be called when a crash report is built

```java
public static void registerCrashCallable(String headerName, Supplier<String> reportGenerator, BooleanSupplier active)
```
源码 :61 — Register a ISystemReportExtender with the given header name and content generator, which will only be appended to the system report when the given BooleanSupplier returns true @param headerName The name of the system report entry @param reportGenerator The report generator to be called when a crash…

```java
public static List<ISystemReportExtender> allCrashCallables()
```
源码 :93 —（无 javadoc）

