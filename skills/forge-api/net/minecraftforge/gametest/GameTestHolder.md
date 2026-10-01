# GameTestHolder

> `net.minecraftforge.gametest.GameTestHolder` · @interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/gametest/GameTestHolder.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**（源码 javadoc）：Marks a class as containing game tests that should be registered automatically. All methods annotated with GameTest or GameTestGenerator will be registered.

## 公开成员（1 个）

```java
String value() default "minecraft"
```
源码 :27 — Used as the default GameTest#templateNamespace() for any game tests in the class that do not specify one.

