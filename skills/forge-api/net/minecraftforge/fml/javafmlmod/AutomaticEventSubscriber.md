# AutomaticEventSubscriber

> `net.minecraftforge.fml.javafmlmod.AutomaticEventSubscriber` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/javafmlmod/AutomaticEventSubscriber.java` · `javafmllanguage-1.20.1-47.4.10`（javafmllanguage-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Automatic eventbus subscriber - reads net.minecraftforge.fml.common.Mod.EventBusSubscriber annotations and passes the class instances to the net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus defined by the annotation. Defaults to `MinecraftForge#EVENT_BUS`

## 公开成员（1 个）

```java
public static void inject(final ModContainer mod, final ModFileScanData scanData, final ClassLoader loader)
```
源码 :37 —（无 javadoc）

