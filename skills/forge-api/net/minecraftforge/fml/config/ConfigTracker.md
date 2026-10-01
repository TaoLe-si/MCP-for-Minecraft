# ConfigTracker

> `net.minecraftforge.fml.config.ConfigTracker` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/config/ConfigTracker.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（7 个）

```java
public static final ConfigTracker INSTANCE = new ConfigTracker()
```
源码 :22 —（无 javadoc）

```java
public void loadConfigs(ModConfig.Type type, Path configBasePath)
```
源码 :48 —（无 javadoc）

```java
public void unloadConfigs(ModConfig.Type type, Path configBasePath)
```
源码 :53 —（无 javadoc）

```java
public void loadDefaultServerConfigs()
```
源码 :79 —（无 javadoc）

```java
public String getConfigFileName(String modId, ModConfig.Type type)
```
源码 :88 —（无 javadoc）

```java
public Map<ModConfig.Type, Set<ModConfig>> configSets()
```
源码 :93 —（无 javadoc）

```java
public ConcurrentHashMap<String, ModConfig> fileMap()
```
源码 :97 —（无 javadoc）

