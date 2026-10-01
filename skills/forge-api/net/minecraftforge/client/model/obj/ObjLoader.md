# ObjLoader

> `net.minecraftforge.client.model.obj.ObjLoader` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/model/obj/ObjLoader.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——模型/数据生成，属于『做模组』的面，不是『驱动游戏』

**职责**（源码 javadoc）：A loader for ObjModel. Allows the user to enable automatic face culling, toggle quad shading, flip UVs, render emissively and specify a ObjMaterialLibrary override.

## 公开成员（5 个）

```java
public static ObjLoader INSTANCE = new ObjLoader()
```
源码 :32 —（无 javadoc）

```java
public void onResourceManagerReload(ResourceManager resourceManager)
```
源码 :40 —（无 javadoc）

```java
public ObjModel read(JsonObject jsonObject, JsonDeserializationContext deserializationContext)
```
源码 :48 —（无 javadoc）

```java
public ObjModel loadModel(ObjModel.ModelSettings settings)
```
源码 :64 —（无 javadoc）

```java
public ObjMaterialLibrary loadMaterialLibrary(ResourceLocation materialLocation)
```
源码 :81 —（无 javadoc）

