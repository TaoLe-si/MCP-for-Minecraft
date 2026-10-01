# ModConfig

> `net.minecraftforge.fml.config.ModConfig` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/config/ModConfig.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（12 个）

```java
public ModConfig(final Type type, final IConfigSpec<?> spec, final ModContainer container, final String fileName)
```
源码 :29 —（无 javadoc）

```java
public ModConfig(final Type type, final IConfigSpec<?> spec, final ModContainer activeContainer)
```
源码 :38 —（无 javadoc）

```java
public Type getType()
```
源码 :46 —（无 javadoc）

```java
public String getFileName()
```
源码 :50 —（无 javadoc）

```java
public ConfigFileTypeHandler getHandler()
```
源码 :54 —（无 javadoc）

```java
public <T extends IConfigSpec<T>> IConfigSpec<T> getSpec()
```
源码 :59 —（无 javadoc）

```java
public String getModId()
```
源码 :63 —（无 javadoc）

```java
public CommentedConfig getConfigData()
```
源码 :67 —（无 javadoc）

```java
public void save()
```
源码 :80 —（无 javadoc）

```java
public Path getFullPath()
```
源码 :84 —（无 javadoc）

```java
public void acceptSyncedConfig(byte[] bytes)
```
源码 :88 —（无 javadoc）

```java
public enum Type
```
源码 :93 —（无 javadoc）

