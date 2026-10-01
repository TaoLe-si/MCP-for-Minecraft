# IForgeRawTagBuilder

> `net.minecraftforge.common.extensions.IForgeRawTagBuilder` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeRawTagBuilder.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（4 个）

```java
default TagBuilder getRawBuilder()
```
源码 :15 —（无 javadoc）

```java
default void serializeTagAdditions(final JsonObject tagJson) {} /** * Adds a tag entry to the remove list. * @param tagEntry The tag entry to add to the remove list * @param source The source of the caller for logging purposes (generally a modid) * @return The builder for chaining purposes */ default TagBuilder remove(final TagEntry tagEntry, final String source)
```
源码 :23 —（无 javadoc）

```java
default TagBuilder removeElement(final ResourceLocation elementID, final String source)
```
源码 :41 — Adds a single-element entry to the remove list. @param elementID The ID of the element to add to the remove list @param source The source of the caller for logging purposes (generally a modid) @return The builder for chaining purposes

```java
default TagBuilder removeTag(final ResourceLocation tagID, final String source)
```
源码 :51 — Adds a tag to the remove list. @param tagID The ID of the tag to add to the remove list @param source The source of the caller for logging purposes (generally a modid) @return The builder for chaining purposes

