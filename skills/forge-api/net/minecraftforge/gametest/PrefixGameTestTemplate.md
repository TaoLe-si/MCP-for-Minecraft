# PrefixGameTestTemplate

> `net.minecraftforge.gametest.PrefixGameTestTemplate` · @interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/gametest/PrefixGameTestTemplate.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**（源码 javadoc）：When used on a class, this sets the default state for whether to prefix any contained game test templates with the Class#getSimpleName() or not. When used on a method, this defines whether the specific method should be prefixed with the simple class name or not. If this annotation cannot be found on a game test method or its containing class, the default behavior is to prefix the class name. Metho…

## 公开成员（1 个）

```java
boolean value() default true
```
源码 :37 — Whether to prefix the game test template with the containing class' Class#getSimpleName(). For example, true in a class named "MyTest" would result in "mytest.structure" while false would result in "structure". Only applies to methods annotated with GameTest.

