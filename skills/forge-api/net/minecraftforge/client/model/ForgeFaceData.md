# ForgeFaceData

> `net.minecraftforge.client.model.ForgeFaceData` · record · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/ForgeFaceData.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：Holds extra data that may be injected into a face. Used by ItemLayerModel, BlockElement and BlockElementFace @param color Color in ARGB format @param blockLight Block Light for this face from 0-15 (inclusive) @param skyLight Sky Light for this face from 0-15 (inclusive) @param ambientOcclusion If this face has AO @param calculateNormals If we should manually calculate the normals for this block or…

## 公开成员（5 个）

```java
public ForgeFaceData(int color, int blockLight, int skyLight, boolean ambientOcclusion)
```
源码 :35 —（无 javadoc）

```java
public static final ForgeFaceData DEFAULT = new ForgeFaceData(0xFFFFFFFF, 0, 0, true, false)
```
源码 :40 —（无 javadoc）

```java
public static final Codec<Integer> COLOR = new ExtraCodecs.EitherCodec<>(Codec.INT, Code…
```
源码 :42 —（无 javadoc）

```java
public static final Codec<ForgeFaceData> CODEC = RecordCodecBuilder.create(builder -> builder.…
```
源码 :46 —（无 javadoc）

```java
public static ForgeFaceData read(@Nullable JsonElement obj, @Nullable ForgeFaceData fallback) throws JsonParseException
```
源码 :62 —（无 javadoc）

