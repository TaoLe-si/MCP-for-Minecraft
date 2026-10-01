# ConcatenatedListView

> `net.minecraftforge.common.util.ConcatenatedListView` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/util/ConcatenatedListView.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：A list that concatenates multiple other lists for efficient iteration. You may use this in place of creating a new list and calling List#addAll(Collection) for each of your collections. This list does not support modification operations, but the underlying lists may be mutated safely externally.

## 公开成员（10 个）

```java
public static <T> ConcatenatedListView<T> of(List<T>... lists)
```
源码 :24 —（无 javadoc）

```java
public static <T> List<T> of(List<? extends List<? extends T>> members)
```
源码 :29 —（无 javadoc）

```java
public int size()
```
源码 :46 —（无 javadoc）

```java
public boolean isEmpty()
```
源码 :55 —（无 javadoc）

```java
public boolean contains(Object o)
```
源码 :64 —（无 javadoc）

```java
public T get(int index)
```
源码 :73 —（无 javadoc）

```java
public int indexOf(Object o)
```
源码 :86 —（无 javadoc）

```java
public int lastIndexOf(Object o)
```
源码 :100 —（无 javadoc）

```java
public Iterator<T> iterator()
```
源码 :115 —（无 javadoc）

```java
public Spliterator<T> spliterator()
```
源码 :121 —（无 javadoc）

