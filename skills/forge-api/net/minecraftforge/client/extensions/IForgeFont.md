# IForgeFont

> `net.minecraftforge.client.extensions.IForgeFont` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/extensions/IForgeFont.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Extension interface for Font.

## 公开成员（2 个）

```java
Font self()
```
源码 :18 —（无 javadoc）

```java
default FormattedText ellipsize(FormattedText text, int maxWidth)
```
源码 :27 — If the width of the text exceeds `maxWidth`, an ellipse is added and the text is substringed. @param text the text to ellipsize if needed @param maxWidth the maximum width of the text @return the ellipsized text

