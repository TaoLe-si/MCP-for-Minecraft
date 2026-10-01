# RecipeMatcher

> `net.minecraftforge.common.util.RecipeMatcher` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/util/RecipeMatcher.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（1 个）

```java
public static <T> int[] findMatches(List<T> inputs, List<? extends Predicate<T>> tests)
```
源码 :26 — Attempts to match inputs to the specified tests. In the best way that all inputs are used by one test. Will return null in any of these cases: input/test lengths don't match. This is only for matching paired outputs. any input doesn't match a test any test doesn't match a input If we are unable to d…

