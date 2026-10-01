# IForgeRegistry

> `net.minecraftforge.registries.IForgeRegistry` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/IForgeRegistry.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Main interface for the registry system. Use this to query the registry system. @param The top level type for the registry

## 公开成员（8 个）

```java
ResourceKey<Registry<V>> getRegistryKey()
```
源码 :29 —（无 javadoc）

```java
ResourceLocation getRegistryName()
```
源码 :30 —（无 javadoc）

```java
void register(String key, V value)
```
源码 :36 — The supplied string key will be prefixed with the currently active mod's mod id. If the supplied name already has a prefix that is different, it will be used and a warning will be logged.

```java
void register(ResourceLocation key, V value)
```
源码 :37 —（无 javadoc）

```java
boolean containsKey(ResourceLocation key)
```
源码 :39 —（无 javadoc）

```java
boolean containsValue(V value)
```
源码 :40 —（无 javadoc）

```java
boolean isEmpty()
```
源码 :41 —（无 javadoc）

```java
<T> T getSlaveMap(ResourceLocation slaveMapName, Class<T> type)
```
源码 :95 — Retrieve the slave map of type T from the registry. Slave maps are maps which are dependent on registry content in some way. @param slaveMapName The name of the slavemap @param type The type @param Type to return @return The slavemap if present

