# RegistryManager

> `net.minecraftforge.registries.RegistryManager` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/RegistryManager.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（16 个）

```java
public static final RegistryManager ACTIVE = new RegistryManager("ACTIVE")
```
源码 :36 —（无 javadoc）

```java
public static final RegistryManager VANILLA = new RegistryManager("VANILLA")
```
源码 :37 —（无 javadoc）

```java
public static final RegistryManager FROZEN = new RegistryManager("FROZEN")
```
源码 :38 —（无 javadoc）

```java
public RegistryManager(String name)
```
源码 :52 —（无 javadoc）

```java
public String getName()
```
源码 :57 —（无 javadoc）

```java
public <V> ForgeRegistry<V> getRegistry(ResourceLocation key)
```
源码 :68 —（无 javadoc）

```java
public <V> ForgeRegistry<V> getRegistry(ResourceKey<? extends Registry<V>> key)
```
源码 :73 —（无 javadoc）

```java
public <V> ResourceLocation getName(IForgeRegistry<V> reg)
```
源码 :78 —（无 javadoc）

```java
public <V> ResourceLocation updateLegacyName(ResourceLocation legacyName)
```
源码 :83 —（无 javadoc）

```java
public <V> ForgeRegistry<V> getRegistry(ResourceLocation key, RegistryManager other)
```
源码 :97 —（无 javadoc）

```java
public static void postNewRegistryEvent()
```
源码 :145 —（无 javadoc）

```java
public Map<ResourceLocation, Snapshot> takeSnapshot(boolean savingToDisc)
```
源码 :181 —（无 javadoc）

```java
public void clean()
```
源码 :190 —（无 javadoc）

```java
public static List<Pair<String, HandshakeMessages.S2CRegistry>> generateRegistryPackets(boolean isLocal)
```
源码 :197 —（无 javadoc）

```java
public static List<ResourceLocation> getRegistryNamesForSyncToClient()
```
源码 :204 —（无 javadoc）

```java
public static Set<ResourceLocation> getVanillaRegistryKeys()
```
源码 :211 —（无 javadoc）

