# EarlyLoadingException

> `net.minecraftforge.fml.loading.EarlyLoadingException` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/loading/EarlyLoadingException.java` · `fmlloader-1.20.1-47.4.10`（fmlloader-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Thrown during early loading phase, and collected by the LoadingModList for handoff to the client or server.

## 公开成员（3 个）

```java
public static class ExceptionData
```
源码 :17 —（无 javadoc）

```java
public List<ExceptionData> getAllData()
```
源码 :46 —（无 javadoc）

```java
public EarlyLoadingException(final String message, final Throwable originalException, List<ExceptionData> errorMessages)
```
源码 :50 —（无 javadoc）

