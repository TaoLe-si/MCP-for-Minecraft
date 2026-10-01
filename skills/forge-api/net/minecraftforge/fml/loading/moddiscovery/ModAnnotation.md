# ModAnnotation

> `net.minecraftforge.fml.loading.moddiscovery.ModAnnotation` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/loading/moddiscovery/ModAnnotation.java` · `fmlloader-1.20.1-47.4.10`（fmlloader-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（14 个）

```java
public static ModFileScanData.AnnotationData fromModAnnotation(final Type clazz, final ModAnnotation annotation)
```
源码 :21 —（无 javadoc）

```java
public static class EnumHolder
```
源码 :25 —（无 javadoc）

```java
public ModAnnotation(ElementType type, Type asmType, String member)
```
源码 :53 —（无 javadoc）

```java
public ModAnnotation(Type asmType, ModAnnotation parent)
```
源码 :60 —（无 javadoc）

```java
public String toString()
```
源码 :67 —（无 javadoc）

```java
public ElementType getType()
```
源码 :77 —（无 javadoc）

```java
public Type getASMType()
```
源码 :81 —（无 javadoc）

```java
public String getMember()
```
源码 :85 —（无 javadoc）

```java
public Map<String, Object> getValues()
```
源码 :89 —（无 javadoc）

```java
public void addArray(String name)
```
源码 :93 —（无 javadoc）

```java
public void addProperty(String key, Object value)
```
源码 :98 —（无 javadoc）

```java
public void addEnumProperty(String key, String enumName, String value)
```
源码 :110 —（无 javadoc）

```java
public void endArray()
```
源码 :115 —（无 javadoc）

```java
public ModAnnotation addChildAnnotation(String name, String desc)
```
源码 :120 —（无 javadoc）

