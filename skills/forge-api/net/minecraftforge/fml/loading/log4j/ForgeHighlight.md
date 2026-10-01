# ForgeHighlight

> `net.minecraftforge.fml.loading.log4j.ForgeHighlight` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/loading/log4j/ForgeHighlight.java` · `fmlloader-1.20.1-47.4.10`（fmlloader-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：A wrapper for HighlightConverter that auto-disables ANSI when the terminal doesn't support it. Ansi support is determined by TerminalConsoleAppender

## 公开成员（2 个）

```java
protected static final Logger LOGGER = StatusLogger.getLogger()
```
源码 :33 —（无 javadoc）

```java
public static @Nullable HighlightConverter newInstance(Configuration config, String[] options)
```
源码 :43 — Gets a new instance of the HighlightErrorConverter with the specified options. @param config The current configuration @param options The pattern options @return The new instance

