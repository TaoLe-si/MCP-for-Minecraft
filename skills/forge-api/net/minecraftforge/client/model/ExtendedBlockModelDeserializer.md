# ExtendedBlockModelDeserializer

> `net.minecraftforge.client.model.ExtendedBlockModelDeserializer` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/ExtendedBlockModelDeserializer.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：A version of BlockModel.Deserializer capable of deserializing models with custom loaders, as well as other changes introduced to the spec by Forge.

## 公开成员（3 个）

```java
public static final Gson INSTANCE = (new GsonBuilder()) .registerTypeAdapter(Bloc…
```
源码 :40 —（无 javadoc）

```java
public BlockModel deserialize(JsonElement element, Type targetType, JsonDeserializationContext deserializationContext) throws JsonParseException
```
源码 :51 —（无 javadoc）

```java
public static IUnbakedGeometry<?> deserializeGeometry(JsonDeserializationContext deserializationContext, JsonObject object) throws JsonParseException
```
源码 :95 —（无 javadoc）

