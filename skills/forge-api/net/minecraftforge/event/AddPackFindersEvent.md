# AddPackFindersEvent

> `net.minecraftforge.event.AddPackFindersEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/AddPackFindersEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired on PackRepository creation to allow mods to add new pack finders.

## 公开成员（3 个）

```java
public AddPackFindersEvent(PackType packType, Consumer<RepositorySource> sources)
```
源码 :24 —（无 javadoc）

```java
public void addRepositorySource(RepositorySource source)
```
源码 :34 — Adds a new source to the list of pack finders. @param source the pack finder

```java
public PackType getPackType()
```
源码 :42 — @return the PackType of the pack repository being constructed.

