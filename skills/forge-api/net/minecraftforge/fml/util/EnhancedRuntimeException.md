# EnhancedRuntimeException

> `net.minecraftforge.fml.util.EnhancedRuntimeException` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/util/EnhancedRuntimeException.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：RuntimeException that gives subclasses the simple opportunity to write extra data when printing the stack trace. Mainly a helper class as printsStackTrace has multiple signatures.

## 公开成员（5 个）

```java
public EnhancedRuntimeException() { super(); } public EnhancedRuntimeException(String message) { super(message); } public EnhancedRuntimeException(String message, Throwable cause) { super(message, cause); } public EnhancedRuntimeException(Throwable cause) { super(cause); } @Override public String getMessage()
```
源码 :20 —（无 javadoc）

```java
public void printStackTrace(final PrintWriter s)
```
源码 :55 —（无 javadoc）

```java
public void printStackTrace(final PrintStream s)
```
源码 :68 —（无 javadoc）

```java
protected abstract void printStackTrace(WrappedPrintStream stream)
```
源码 :81 —（无 javadoc）

```java
public static abstract class WrappedPrintStream
```
源码 :83 —（无 javadoc）

