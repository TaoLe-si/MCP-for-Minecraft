# ForgeConfigSpec

> `net.minecraftforge.common.ForgeConfigSpec` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/ForgeConfigSpec.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（23 个）

```java
public String getLevelComment(List<String> path)
```
源码 :71 —（无 javadoc）

```java
public String getLevelTranslationKey(List<String> path)
```
源码 :75 —（无 javadoc）

```java
public void setConfig(CommentedConfig config)
```
源码 :79 —（无 javadoc）

```java
public void acceptConfig(final CommentedConfig data)
```
源码 :98 —（无 javadoc）

```java
public boolean isCorrecting()
```
源码 :102 —（无 javadoc）

```java
public boolean isLoaded()
```
源码 :106 —（无 javadoc）

```java
public UnmodifiableConfig getSpec()
```
源码 :110 —（无 javadoc）

```java
public UnmodifiableConfig getValues()
```
源码 :114 —（无 javadoc）

```java
public void afterReload()
```
源码 :118 —（无 javadoc）

```java
public void save()
```
源码 :132 —（无 javadoc）

```java
public synchronized boolean isCorrect(CommentedConfig config)
```
源码 :140 —（无 javadoc）

```java
public int correct(CommentedConfig config)
```
源码 :145 —（无 javadoc）

```java
public synchronized int correct(CommentedConfig config, CorrectionListener listener)
```
源码 :149 —（无 javadoc）

```java
public synchronized int correct(CommentedConfig config, CorrectionListener listener, CorrectionListener commentListener)
```
源码 :153 —（无 javadoc）

```java
public static class Builder
```
源码 :278 —（无 javadoc）

```java
public static class Range<V extends Comparable<? super V>> implements Predicate<Object>
```
源码 :698 —（无 javadoc）

```java
public static class ValueSpec
```
源码 :770 —（无 javadoc）

```java
public static class ConfigValue<T> implements Supplier<T>
```
源码 :806 —（无 javadoc）

```java
public static class BooleanValue extends ConfigValue<Boolean>
```
源码 :904 — the default value for the configuration setting

```java
public static class IntValue extends ConfigValue<Integer>
```
源码 :912 —（无 javadoc）

```java
public static class LongValue extends ConfigValue<Long>
```
源码 :926 —（无 javadoc）

```java
public static class DoubleValue extends ConfigValue<Double>
```
源码 :940 —（无 javadoc）

```java
public static class EnumValue<T extends Enum<T>> extends ConfigValue<T>
```
源码 :955 —（无 javadoc）

