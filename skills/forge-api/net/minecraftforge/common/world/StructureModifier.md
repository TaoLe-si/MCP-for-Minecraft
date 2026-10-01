# StructureModifier

> `net.minecraftforge.common.world.StructureModifier` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/world/StructureModifier.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：JSON-serializable structure modifier. Requires a Codec to deserialize structure modifiers from structure modifier jsons. Structure modifier jsons have the following json format: { "type": "yourmod:yourserializer", // Indicates a registered structure modifier serializer // Additional fields can be specified here according to the codec } Datapacks can also disable a structure modifier by overriding…

## 公开成员（1 个）

```java
void modify(Holder<Structure> structure, Phase phase, StructureInfo.Builder builder)
```
源码 :64 — Modifies the information via the provided structure builder. Allows mob spawns and world-gen features to be added or removed, and climate and client effects to be modified. @param structure the named structure being modified (with original data readable). @param phase structure modification phase. S…

