# Properties

> `net.minecraftforge.common.property.Properties` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/property/Properties.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（2 个）

```java
public static final BooleanProperty StaticProperty = BooleanProperty.create("static")
```
源码 :17 — Property indicating if the model should be rendered in the static renderer or in the TESR. AnimationTESR sets it to false.

```java
public static final ModelProperty<ModelState> AnimationProperty = new ModelProperty<ModelState>()
```
源码 :22 — Property holding the IModelState used for animating the model in the TESR.

