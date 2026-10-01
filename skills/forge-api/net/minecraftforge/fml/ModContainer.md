# ModContainer

> `net.minecraftforge.fml.ModContainer` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/ModContainer.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：The container that wraps around mods in the system. The philosophy is that individual mod implementation technologies should not impact the actual loading and management of mod code. This class provides a mechanism by which we can wrap actual mod code so that the loader and other facilities can treat mods at arms length. @author cpw

## 公开成员（26 个）

```java
protected final String modId
```
源码 :44 —（无 javadoc）

```java
protected final String namespace
```
源码 :45 —（无 javadoc）

```java
protected final IModInfo modInfo
```
源码 :46 —（无 javadoc）

```java
protected ModLoadingStage modLoadingStage
```
源码 :47 —（无 javadoc）

```java
protected Supplier<?> contextExtension
```
源码 :48 —（无 javadoc）

```java
protected final Map<ModLoadingStage, Runnable> activityMap = new HashMap<>()
```
源码 :49 —（无 javadoc）

```java
protected final Map<Class<? extends IExtensionPoint<?>>, Supplier<?>> extensionPoints = new IdentityHashMap<>()
```
源码 :50 —（无 javadoc）

```java
protected final EnumMap<ModConfig.Type, ModConfig> configs = new EnumMap<>(ModConfig.Type.class)
```
源码 :51 —（无 javadoc）

```java
protected Optional<Consumer<IConfigEvent>> configHandler = Optional.empty()
```
源码 :53 —（无 javadoc）

```java
public ModContainer(IModInfo info)
```
源码 :55 —（无 javadoc）

```java
public final String getModId()
```
源码 :96 — @return the modid for this mod

```java
public final String getNamespace()
```
源码 :104 — @return the resource prefix for the mod

```java
public ModLoadingStage getCurrentState()
```
源码 :112 — @return The current loading stage for this mod

```java
public static <T extends Event & IModBusEvent> CompletableFuture<Void> buildTransitionHandler( final ModContainer target, final IModStateTransition.EventGenerator<T> eventGenerator, final ProgressMeter progressBar, final BiFunction<ModLoadingStage, Throwable, ModLoadingStage> stateChangeHandler, final Executor executor)
```
源码 :117 —（无 javadoc）

```java
public IModInfo getModInfo()
```
源码 :136 —（无 javadoc）

```java
public <T extends Record> Optional<T> getCustomExtension(Class<? extends IExtensionPoint<T>> point)
```
源码 :142 —（无 javadoc）

```java
public <T extends Record & IExtensionPoint<T>> void registerExtensionPoint(Class<? extends IExtensionPoint<T>> point, Supplier<T> extension)
```
源码 :146 —（无 javadoc）

```java
public void registerDisplayTest(IExtensionPoint.DisplayTest displayTest)
```
源码 :151 —（无 javadoc）

```java
public void registerDisplayTest(Supplier<IExtensionPoint.DisplayTest> displayTest)
```
源码 :155 —（无 javadoc）

```java
public void registerDisplayTest(String version, BiPredicate<String, Boolean> remoteVersionTest)
```
源码 :159 —（无 javadoc）

```java
public void registerDisplayTest(Supplier<String> suppliedVersion, BiPredicate<String, Boolean> remoteVersionTest)
```
源码 :163 —（无 javadoc）

```java
public void addConfig(final ModConfig modConfig)
```
源码 :167 —（无 javadoc）

```java
public void dispatchConfigEvent(IConfigEvent event)
```
源码 :171 —（无 javadoc）

```java
public abstract boolean matches(Object mod)
```
源码 :181 — Does this mod match the supplied mod? @param mod to compare @return if the mod matches

```java
public abstract Object getMod()
```
源码 :186 — @return the mod object instance

```java
protected <T extends Event & IModBusEvent> void acceptEvent(T e) {} }
```
源码 :192 — Accept an arbitrary event for processing by the mod. Probably posted to an event bus in the lower level container. @param e Event to accept

