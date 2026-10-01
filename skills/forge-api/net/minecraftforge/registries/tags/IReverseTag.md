# IReverseTag

> `net.minecraftforge.registries.tags.IReverseTag` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/tags/IReverseTag.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：A reverse tag is an object aware of what tags it is contained in. Holders implement this interface. A reverse tag makes no guarantees about its persistence relative to a registry value. Modders should look up a reverse tag every time they need it from a ITagManager rather than storing it somewhere.

## 公开成员（3 个）

```java
Stream<TagKey<V>> getTagKeys()
```
源码 :21 —（无 javadoc）

```java
boolean containsTag(TagKey<V> key)
```
源码 :23 —（无 javadoc）

```java
default boolean containsTag(ITag<V> tag)
```
源码 :25 —（无 javadoc）

