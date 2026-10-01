# ObfuscationReflectionHelper

> `net.minecraftforge.fml.util.ObfuscationReflectionHelper` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/util/ObfuscationReflectionHelper.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Some reflection helper code. This may not work properly in Java 9 with its new, more restrictive, reflection management. As such, if issues are encountered, please report them and we can see what we can do to expand the compatibility. In other cases, AccessTransformers may be used. All field and method names should be passed in as SRG names, and this will automatically resolve if MCP mappings are…

## 公开成员（10 个）

```java
public static String remapName(INameMappingService.Domain domain, String name)
```
源码 :47 —（无 javadoc）

```java
public static <T, E> T getPrivateValue(Class<? super E> classToAccess, E instance, String fieldName)
```
源码 :68 —（无 javadoc）

```java
public static <T, E> void setPrivateValue(@NotNull final Class<? super T> classToAccess, @NotNull final T instance, @Nullable final E value, @NotNull final String fieldName)
```
源码 :101 — Sets the value a field with the specified name in the given class. Note: For performance, use #findField(Class, if you are setting the value more than once. Throws an exception if the field is not found or the value of the field cannot be set. @param classToAccess The class to find the field on. @pa…

```java
public static Method findMethod(@NotNull final Class<?> clazz, @NotNull final String methodName, @NotNull final Class<?>... parameterTypes)
```
源码 :136 —（无 javadoc）

```java
public static <T> Constructor<T> findConstructor(@NotNull final Class<T> clazz, @NotNull final Class<?>... parameterTypes)
```
源码 :170 —（无 javadoc）

```java
public static <T> Field findField(@NotNull final Class<? super T> clazz, @NotNull final String fieldName)
```
源码 :213 —（无 javadoc）

```java
public static class UnableToAccessFieldException extends RuntimeException
```
源码 :231 —（无 javadoc）

```java
public static class UnableToFindFieldException extends RuntimeException
```
源码 :239 —（无 javadoc）

```java
public static class UnableToFindMethodException extends RuntimeException
```
源码 :247 —（无 javadoc）

```java
public static class UnknownConstructorException extends RuntimeException
```
源码 :255 —（无 javadoc）

