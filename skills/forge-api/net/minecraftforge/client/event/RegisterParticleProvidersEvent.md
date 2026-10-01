# RegisterParticleProvidersEvent

> `net.minecraftforge.client.event.RegisterParticleProvidersEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/RegisterParticleProvidersEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired for registering particle providers at the appropriate time. ParticleTypes must be registered during RegisterEvent as usual; this event is only for the ParticleProviders. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the FMLJavaModLoadingContext#getModEventBus() mod-specific event bus, only on the LogicalSide#CLIENT logical client.

## 公开成员（4 个）

```java
public RegisterParticleProvidersEvent(ParticleEngine particleEngine)
```
源码 :37 —（无 javadoc）

```java
public <T extends ParticleOptions> void registerSpecial(ParticleType<T> type, ParticleProvider<T> provider)
```
源码 :54 —（无 javadoc）

```java
public <T extends ParticleOptions> void registerSprite(ParticleType<T> type, ParticleProvider.Sprite<T> sprite)
```
源码 :70 —（无 javadoc）

```java
public <T extends ParticleOptions> void registerSpriteSet(ParticleType<T> type, ParticleEngine.SpriteParticleRegistration<T> registration)
```
源码 :87 —（无 javadoc）

