# MissingMappingsEvent

> `net.minecraftforge.registries.MissingMappingsEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/MissingMappingsEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired on the net.minecraftforge.common.MinecraftForge#EVENT_BUS.

## 公开成员（7 个）

```java
public MissingMappingsEvent(ResourceKey<? extends Registry<?>> key, IForgeRegistry<?> registry, Collection<Mapping<?>> missed)
```
源码 :27 —（无 javadoc）

```java
public ResourceKey<? extends Registry<?>> getKey()
```
源码 :34 —（无 javadoc）

```java
public IForgeRegistry<?> getRegistry()
```
源码 :39 —（无 javadoc）

```java
public <T> List<Mapping<T>> getMappings(ResourceKey<? extends Registry<T>> registryKey, String namespace)
```
源码 :49 —（无 javadoc）

```java
public <T> List<Mapping<T>> getAllMappings(ResourceKey<? extends Registry<T>> registryKey)
```
源码 :61 —（无 javadoc）

```java
public enum Action
```
源码 :74 — Actions you can take with this missing mapping. #IGNORE means this missing mapping will be ignored. #WARN means this missing mapping will generate a warning. #FAIL means this missing mapping will prevent the world from loading.

```java
public static class Mapping<T> implements Comparable<Mapping<T>>
```
源码 :98 — Remap this name to a new name (add a migration mapping)

