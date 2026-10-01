# IGeometryLoader

> `net.minecraftforge.client.model.geometry.IGeometryLoader` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/geometry/IGeometryLoader.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：A loader for custom IUnbakedGeometry model geometries. If you do any caching, you should implement ResourceManagerReloadListener and register it with RegisterClientReloadListenersEvent. @see RegisterGeometryLoaders @see RegisterClientReloadListenersEvent

## 公开成员（1 个）

```java
T read(JsonObject jsonObject, JsonDeserializationContext deserializationContext) throws JsonParseException
```
源码 :26 —（无 javadoc）

