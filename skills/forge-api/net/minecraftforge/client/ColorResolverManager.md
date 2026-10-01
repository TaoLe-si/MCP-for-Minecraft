# ColorResolverManager

> `net.minecraftforge.client.ColorResolverManager` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/ColorResolverManager.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Manager for custom ColorResolver instances, collected via RegisterColorHandlersEvent.ColorResolvers.

## 公开成员（2 个）

```java
public static void init()
```
源码 :27 —（无 javadoc）

```java
public static void registerBlockTintCaches(ClientLevel level, Map<ColorResolver, BlockTintCache> target)
```
源码 :40 — Register a BlockTintCache for every registered ColorResolver into the given target map. @param level the level to use @param target the map to populate

