# IForgeKeyMapping

> `net.minecraftforge.client.extensions.IForgeKeyMapping` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/extensions/IForgeKeyMapping.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Extension interface for KeyMapping.

## 公开成员（10 个）

```java
private KeyMapping self()
```
源码 :18 —（无 javadoc）

```java
default boolean isActiveAndMatches(InputConstants.Key keyCode)
```
源码 :27 — true if the key conflict context and modifier are active and the keyCode matches this binding, false otherwise

```java
default void setToDefault()
```
源码 :31 —（无 javadoc）

```java
void setKeyConflictContext(IKeyConflictContext keyConflictContext)
```
源码 :35 —（无 javadoc）

```java
IKeyConflictContext getKeyConflictContext()
```
源码 :37 —（无 javadoc）

```java
KeyModifier getDefaultKeyModifier()
```
源码 :39 —（无 javadoc）

```java
KeyModifier getKeyModifier()
```
源码 :41 —（无 javadoc）

```java
void setKeyModifierAndCode(KeyModifier keyModifier, InputConstants.Key keyCode)
```
源码 :43 —（无 javadoc）

```java
default boolean isConflictContextAndModifierActive()
```
源码 :45 —（无 javadoc）

```java
default boolean hasKeyModifierConflict(KeyMapping other)
```
源码 :52 — Returns true when one of the bindings' key codes conflicts with the other's modifier.

