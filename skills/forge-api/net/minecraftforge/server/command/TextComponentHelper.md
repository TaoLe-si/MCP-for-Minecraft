# TextComponentHelper

> `net.minecraftforge.server.command.TextComponentHelper` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/server/command/TextComponentHelper.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（1 个）

```java
public static MutableComponent createComponentTranslation(CommandSource source, final String translation, final Object... args)
```
源码 :28 — Detects when sending to a vanilla client and falls back to sending english, since they don't have the lang data necessary to translate on the client.

