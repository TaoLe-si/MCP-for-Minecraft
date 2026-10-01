# VersionChecker

> `net.minecraftforge.fml.VersionChecker` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/VersionChecker.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（3 个）

```java
public enum Status
```
源码 :44 —（无 javadoc）

```java
public record CheckResult(VersionChecker.Status status, ComparableVersion target, Map<ComparableVersion, String> changes, String url) {} public static void startVersionCheck()
```
源码 :99 —（无 javadoc）

```java
public static CheckResult getResult(IModInfo mod)
```
源码 :282 —（无 javadoc）

