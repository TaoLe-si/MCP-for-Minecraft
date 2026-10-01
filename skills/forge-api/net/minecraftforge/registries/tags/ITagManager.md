# ITagManager

> `net.minecraftforge.registries.tags.ITagManager` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/tags/ITagManager.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：A tag manager holds information about all tags currently bound to a forge registry. This should be preferred to any Holder-related methods.

## 公开成员（2 个）

```java
boolean isKnownTagName(@NotNull TagKey<V> name)
```
源码 :49 — Checks whether the given tag key exists in this tag manager and is bound. Unlike #getTag(TagKey), this method will not create the tag if it does not exist. @see ITag#isBound()

```java
void addOptionalTagDefaults(@NotNull TagKey<V> name, @NotNull Set<? extends Supplier<V>> defaults)
```
源码 :90 — Adds defaults to an existing tag key. The set of defaults will be bound to the tag if the tag is not loaded from any datapacks. Useful on the client side when a server may not provide a specific tag. Custom registries can use DeferredRegister#addOptionalTagDefaults(TagKey, to add defaults before the…

