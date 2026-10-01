# IForgeIntrinsicHolderTagAppender

> `net.minecraftforge.common.extensions.IForgeIntrinsicHolderTagAppender` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeIntrinsicHolderTagAppender.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（13 个）

```java
private IntrinsicHolderTagsProvider.IntrinsicTagAppender<T> self()
```
源码 :14 —（无 javadoc）

```java
ResourceKey<T> getKey(T value)
```
源码 :18 —（无 javadoc）

```java
default IntrinsicHolderTagsProvider.IntrinsicTagAppender<T> remove(final T entry)
```
源码 :26 — Adds a registry entry to the tag json's remove list. Callable during datageneration. @param entry The entry to remove @return The builder for chaining

```java
default IntrinsicHolderTagsProvider.IntrinsicTagAppender<T> remove(final T first, final T...entries)
```
源码 :37 —（无 javadoc）

```java
default IntrinsicHolderTagsProvider.IntrinsicTagAppender<T> addTags(TagKey<T>... values)
```
源码 :46 —（无 javadoc）

```java
default IntrinsicHolderTagsProvider.IntrinsicTagAppender<T> replace()
```
源码 :52 —（无 javadoc）

```java
default IntrinsicHolderTagsProvider.IntrinsicTagAppender<T> replace(boolean value)
```
源码 :58 —（无 javadoc）

```java
default IntrinsicHolderTagsProvider.IntrinsicTagAppender<T> remove(final ResourceLocation location)
```
源码 :64 —（无 javadoc）

```java
default IntrinsicHolderTagsProvider.IntrinsicTagAppender<T> remove(final ResourceLocation first, final ResourceLocation... locations)
```
源码 :70 —（无 javadoc）

```java
default IntrinsicHolderTagsProvider.IntrinsicTagAppender<T> remove(final ResourceKey<T> resourceKey)
```
源码 :76 —（无 javadoc）

```java
default IntrinsicHolderTagsProvider.IntrinsicTagAppender<T> remove(final ResourceKey<T> firstResourceKey, final ResourceKey<T>... resourceKeys)
```
源码 :83 —（无 javadoc）

```java
default IntrinsicHolderTagsProvider.IntrinsicTagAppender<T> remove(TagKey<T> tag)
```
源码 :89 —（无 javadoc）

```java
default IntrinsicHolderTagsProvider.IntrinsicTagAppender<T> remove(TagKey<T> first, TagKey<T>...tags)
```
源码 :96 —（无 javadoc）

