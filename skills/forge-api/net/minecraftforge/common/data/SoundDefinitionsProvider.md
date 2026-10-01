# SoundDefinitionsProvider

> `net.minecraftforge.common.data.SoundDefinitionsProvider` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/data/SoundDefinitionsProvider.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Data provider for the `sounds.json` file, which identifies sound definitions for the various sound events in Minecraft.

## 公开成员（13 个）

```java
protected SoundDefinitionsProvider(final PackOutput output, final String modId, final ExistingFileHelper helper)
```
源码 :45 — Creates a new instance of this data provider. @param output The PackOutput instance provided by the data generator. @param modId The mod ID of the current mod. @param helper The existing file helper provided by the event you are initializing this provider in.

```java
public abstract void registerSounds()
```
源码 :55 — Registers the sound definitions that should be generated via one of the `add` methods.

```java
public CompletableFuture<?> run(CachedOutput cache)
```
源码 :58 —（无 javadoc）

```java
public String getName()
```
源码 :72 —（无 javadoc）

```java
protected static SoundDefinition definition()
```
源码 :82 — Creates a new SoundDefinition, which will host a set of SoundDefinition.Sounds and the necessary parameters.

```java
protected static SoundDefinition.Sound sound(final ResourceLocation name, final SoundDefinition.SoundType type)
```
源码 :93 — Creates a new sound with the given name and type. @param name The name of the sound to create. @param type The type of sound to create.

```java
protected static SoundDefinition.Sound sound(final ResourceLocation name)
```
源码 :104 — Creates a new sound with the given name and SoundDefinition.SoundType#SOUND as sound type. @param name The name of the sound to create.

```java
protected static SoundDefinition.Sound sound(final String name, final SoundDefinition.SoundType type)
```
源码 :115 — Creates a new sound with the given name and type. @param name The name of the sound to create. @param type The type of sound to create.

```java
protected static SoundDefinition.Sound sound(final String name)
```
源码 :126 — Creates a new sound with the given name and SoundDefinition.SoundType#SOUND as sound type. @param name The name of the sound to create.

```java
protected void add(final Supplier<SoundEvent> soundEvent, final SoundDefinition definition)
```
源码 :142 — Adds the entry name associated with the supplied SoundEvent with the given SoundDefinition to the list. This method should be preferred when dealing with a `RegistryObject` or `RegistryDelegate`. @param soundEvent A `Supplier` for the given SoundEvent. @param definition A SoundDefinition that define…

```java
protected void add(final SoundEvent soundEvent, final SoundDefinition definition)
```
源码 :158 — Adds the entry name associated with the given SoundEvent with the SoundDefinition to the list. This method should be preferred when a `SoundEvent` is already available in the method context. If you already have a `Supplier` for it, refer to #add(Supplier,. @param soundEvent A SoundEvent. @param defi…

```java
protected void add(final ResourceLocation soundEvent, final SoundDefinition definition)
```
源码 :170 — Adds the SoundEvent referenced by the given ResourceLocation with the SoundDefinition to the list. @param soundEvent The ResourceLocation that identifies the event. @param definition The SoundDefinition that defines the given event.

```java
protected void add(final String soundEvent, final SoundDefinition definition)
```
源码 :187 — Adds the SoundEvent with the specified name along with its SoundDefinition to the list. The given sound event must NOT contain the namespace the name is a part of, since the sound definition specification doesn't allow sounds to be defined outside the namespace they're in. For this reason, any names…

