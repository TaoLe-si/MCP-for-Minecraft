# CommandTreeCleaner

> `net.minecraftforge.network.filters.CommandTreeCleaner` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/filters/CommandTreeCleaner.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（1 个）

```java
public static <S> RootCommandNode<S> cleanArgumentTypes(RootCommandNode<S> root, Predicate<ArgumentType<?>> argumentTypeFilter)
```
源码 :26 — Cleans the command tree starting at the given root node from any argument types that do not match the given predicate. Any `ArgumentCommandNode`s that have an unmatched argument type will be stripped from the tree. @return A new command tree, stripped of any unmatched argument types

