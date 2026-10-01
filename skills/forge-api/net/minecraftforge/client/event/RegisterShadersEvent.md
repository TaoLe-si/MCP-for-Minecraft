# RegisterShadersEvent

> `net.minecraftforge.client.event.RegisterShadersEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RegisterShadersEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired to allow mods to register custom ShaderInstance shaders. This event is fired after the default Minecraft shaders have been registered. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the FMLJavaModLoadingContext#getModEventBus() mod-specific event bus, only on the LogicalSide#CLIENT logical client.

## 公开成员（3 个）

```java
public RegisterShadersEvent(ResourceProvider resourceProvider, List<Pair<ShaderInstance, Consumer<ShaderInstance>>> shaderList)
```
源码 :37 —（无 javadoc）

```java
public ResourceProvider getResourceProvider()
```
源码 :46 — the client-side resource provider

```java
public void registerShader(ShaderInstance shaderInstance, Consumer<ShaderInstance> onLoaded)
```
源码 :63 — Registers a shader, and a callback for when the shader is loaded. When creating a ShaderInstance, pass in the #getResourceProvider() client-side resource provider as the resource provider. Mods should not store the shader instance passed into this method. Instead, mods should store the shader passed…

