# KeyMappingLookup

> `net.minecraftforge.client.settings.KeyMappingLookup` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/settings/KeyMappingLookup.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（5 个）

```java
public KeyMapping get(InputConstants.Key keyCode)
```
源码 :29 —（无 javadoc）

```java
public List<KeyMapping> getAll(InputConstants.Key keyCode)
```
源码 :59 — Returns all active keys associated with the given key code and the active modifiers and conflict context. @param keyCode the key being pressed @return the list of key mappings

```java
public void put(InputConstants.Key keyCode, KeyMapping keyBinding)
```
源码 :87 —（无 javadoc）

```java
public void remove(KeyMapping keyBinding)
```
源码 :93 —（无 javadoc）

```java
public void clear()
```
源码 :104 —（无 javadoc）

