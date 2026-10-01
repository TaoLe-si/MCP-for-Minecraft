# IForgeMinecraft

> `net.minecraftforge.client.extensions.IForgeMinecraft` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/extensions/IForgeMinecraft.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Extension interface for IForgeMinecraft.

## 公开成员（4 个）

```java
private Minecraft self()
```
源码 :19 —（无 javadoc）

```java
default void pushGuiLayer(Screen screen)
```
源码 :29 — Pushes a screen as a new GUI layer. @param screen the new GUI layer

```java
default void popGuiLayer()
```
源码 :37 — Pops a GUI layer from the screen.

```java
default Locale getLocale()
```
源码 :46 — Retrieves the Locale set by the player. Useful for creating string and number formatters.

