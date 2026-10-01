# TagsCommand

> `net.minecraftforge.server.command.TagsCommand` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/server/command/TagsCommand.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：The `/forge tags` command for listing a registry's tags, getting the elements of tags, and querying the tags of a registry object. Each command is paginated, showing PAGE_SIZE entries at a time. When there are more than 0 entries, the text indicating the amount of entries is highlighted and can be clicked to copy the list of all entries (across all pages) to the clipboard. (This is reflected by th…

## 公开成员（1 个）

```java
public static ArgumentBuilder<CommandSourceStack, ?> register()
```
源码 :71 —（无 javadoc）

