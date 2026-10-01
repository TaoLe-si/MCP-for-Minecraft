# RegisterStructureConversionsEvent

> `net.minecraftforge.event.RegisterStructureConversionsEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/RegisterStructureConversionsEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired for registering structure conversions for pre-1.18.2 worlds. This is used by StructuresBecomeConfiguredFix for converting old structure IDs in pre-1.18.2 worlds to their new equivalents, which can be differentiated per biome. By default, structures whose old ID has a namespace which is not equal to ResourceLocation#DEFAULT_NAMESPACE will be assumed to belong to a modded structure and will be…

## 公开成员（2 个）

```java
public RegisterStructureConversionsEvent(Map<String, StructuresBecomeConfiguredFix.Conversion> map)
```
源码 :45 — @hidden For internal use only.

```java
public void register(String oldStructureID, StructuresBecomeConfiguredFix.Conversion conversion)
```
源码 :92 — Registers a conversion for a structure. A structure conversion can be of two kinds: A trivial conversion, created using StructuresBecomeConfiguredFix.Conversion#trivial(String), contains only the new structure ID and simply converts all mentions of the old structure ID to the new structure ID. A bio…

