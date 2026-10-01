# ObjectHolder

> `net.minecraftforge.registries.ObjectHolder` · @interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/ObjectHolder.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：ObjectHolder can be used to automatically populate public static final fields with entries from the registry. These values can then be referred within mod code directly. @deprecated Use DeferredRegister or RegistryObject instead. Refer to the MDK for more detailed examples. Example usage of alternatives: `// To register something public static final DeferredRegister ITEMS = DeferredRegister.create…

## 公开成员（2 个）

```java
String registryName()
```
源码 :42 — The name of the registry to load registry entries from. This string is parsed as a ResourceLocation and can contain a namespace. @return the registry name

```java
String value()
```
源码 :50 — Represents a name in the form of a ResourceLocation which points to a registry object from the registry given by #registryName(). Must specify the modid if not inside a class annotated with Mod. @return a name in the form of a ResourceLocation

