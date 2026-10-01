# KeyConflictContext

> `net.minecraftforge.client.settings.KeyConflictContext` · enum · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/settings/KeyConflictContext.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（3 个）

```java
enum 常量 UNIVERSAL
```
源码 :17 — Universal key bindings are used in every context and will conflict with any other context. Key Bindings are universal by default.

```java
enum 常量 GUI
```
源码 :34 — Gui key bindings are only used when a Screen is open.

```java
enum 常量 IN_GAME
```
源码 :51 — In-game key bindings are only used when a Screen is not open.

