# BiomeModifier

> `net.minecraftforge.common.world.BiomeModifier` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/world/BiomeModifier.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：JSON-serializable biome modifier. Requires a Codec to deserialize biome modifiers from biome modifier jsons. Biome modifier jsons have the following json format: { "type": "yourmod:yourserializer", // Indicates a registered biome modifier serializer // Additional fields can be specified here according to the codec } Datapacks can also disable a biome modifier by overriding the json and using `"typ…

## 公开成员（1 个）

```java
void modify(Holder<Biome> biome, Phase phase, BiomeInfo.Builder builder)
```
源码 :64 — Modifies the information via the provided biome builder. Allows mob spawns and world-gen features to be added or removed, and climate and client effects to be modified. @param biome the named biome being modified (with original data readable). @param phase biome modification phase. Biome modifiers a…

