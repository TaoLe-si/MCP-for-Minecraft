# IForgeTagAppender

> `net.minecraftforge.common.extensions.IForgeTagAppender` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeTagAppender.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（12 个）

```java
private TagsProvider.TagAppender<T> self()
```
源码 :15 —（无 javadoc）

```java
default TagsProvider.TagAppender<T> addTags(TagKey<T>... values)
```
源码 :20 —（无 javadoc）

```java
default TagsProvider.TagAppender<T> addOptionalTag(TagKey<T> value)
```
源码 :28 —（无 javadoc）

```java
default TagsProvider.TagAppender<T> addOptionalTags(TagKey<T>... values)
```
源码 :33 —（无 javadoc）

```java
default TagsProvider.TagAppender<T> replace()
```
源码 :41 —（无 javadoc）

```java
default TagsProvider.TagAppender<T> replace(boolean value)
```
源码 :45 —（无 javadoc）

```java
default TagsProvider.TagAppender<T> remove(final ResourceLocation location)
```
源码 :55 — Adds a single element's ID to the tag json's remove list. Callable during datageneration. @param location The ID of the element to remove @return The builder for chaining

```java
default TagsProvider.TagAppender<T> remove(final ResourceLocation first, final ResourceLocation... locations)
```
源码 :67 — Adds multiple elements' IDs to the tag json's remove list. Callable during datageneration. @param locations The IDs of the elements to remove @return The builder for chaining

```java
default TagsProvider.TagAppender<T> remove(final ResourceKey<T> resourceKey)
```
源码 :83 — Adds a resource key to the tag json's remove list. Callable during datageneration. @param resourceKey The resource key of the element to remove @return The appender for chaining

```java
default TagsProvider.TagAppender<T> remove(final ResourceKey<T> firstResourceKey, final ResourceKey<T>... resourceKeys)
```
源码 :96 —（无 javadoc）

```java
default TagsProvider.TagAppender<T> remove(TagKey<T> tag)
```
源码 :111 — Adds a tag to the tag json's remove list. Callable during datageneration. @param tag The ID of the tag to remove @return The builder for chaining

```java
default TagsProvider.TagAppender<T> remove(TagKey<T> first, TagKey<T>...tags)
```
源码 :124 —（无 javadoc）

