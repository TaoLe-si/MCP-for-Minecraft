# KeyModifier

> `net.minecraftforge.client.settings.KeyModifier` · enum · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/settings/KeyModifier.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（13 个）

```java
enum 常量 CONTROL
```
源码 :20 —（无 javadoc）

```java
enum 常量 SHIFT
```
源码 :41 —（无 javadoc）

```java
enum 常量 ALT
```
源码 :57 —（无 javadoc）

```java
enum 常量 NONE
```
源码 :73 —（无 javadoc）

```java
public static final KeyModifier[] MODIFIER_VALUES = {SHIFT, CONTROL, ALT}
```
源码 :97 —（无 javadoc）

```java
public static KeyModifier getActiveModifier()
```
源码 :100 —（无 javadoc）

```java
public static final List<KeyModifier> getValues(boolean includeNone)
```
源码 :111 —（无 javadoc）

```java
public static KeyModifier getModifier(InputConstants.Key key)
```
源码 :116 —（无 javadoc）

```java
public static boolean isKeyCodeModifier(InputConstants.Key key)
```
源码 :124 —（无 javadoc）

```java
public static KeyModifier valueFromString(String stringValue)
```
源码 :132 —（无 javadoc）

```java
public abstract boolean matches(InputConstants.Key key)
```
源码 :140 —（无 javadoc）

```java
public abstract boolean isActive(@Nullable IKeyConflictContext conflictContext)
```
源码 :142 —（无 javadoc）

```java
public abstract Component getCombinedName(InputConstants.Key key, Supplier<Component> defaultLogic)
```
源码 :144 —（无 javadoc）

