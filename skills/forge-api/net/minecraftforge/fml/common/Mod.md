# Mod

> `net.minecraftforge.fml.common.Mod` · @interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/common/Mod.java` · `javafmllanguage-1.20.1-47.4.10`（javafmllanguage-1.20.1-47.4.10-sources.jar）

**本项目用法**：模组入口注解：`@Mod(McpForMinecraft.MODID)`

**职责**（源码 javadoc）：This defines a Mod to FML. Any class found with this annotation applied will be loaded as a Mod. The instance that is loaded will represent the mod to other Mods in the system. It will be sent various subclasses of `ModLifecycleEvent` at pre-defined times during the loading of the game.

## 公开成员（1 个）

```java
String value()
```
源码 :36 — The unique mod identifier for this mod. Required to be lowercased in the english locale for compatibility. Will be truncated to 64 characters long. This will be used to identify your mod for third parties (other mods), it will be used to identify your mod for registries such as block and item regist…

