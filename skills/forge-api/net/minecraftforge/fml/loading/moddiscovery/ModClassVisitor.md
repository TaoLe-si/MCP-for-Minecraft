# ModClassVisitor

> `net.minecraftforge.fml.loading.moddiscovery.ModClassVisitor` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/loading/moddiscovery/ModClassVisitor.java` · `fmlloader-1.20.1-47.4.10`（fmlloader-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（6 个）

```java
public ModClassVisitor()
```
源码 :29 —（无 javadoc）

```java
public void visit(int version, int access, String name, String signature, String superName, String[] interfaces)
```
源码 :36 —（无 javadoc）

```java
public AnnotationVisitor visitAnnotation(final String annotationName, final boolean runtimeVisible)
```
源码 :44 —（无 javadoc）

```java
public FieldVisitor visitField(int access, String name, String desc, String signature, Object value)
```
源码 :53 —（无 javadoc）

```java
public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions)
```
源码 :59 —（无 javadoc）

```java
public void buildData(final Set<ModFileScanData.ClassData> classes, final Set<ModFileScanData.AnnotationData> annotations)
```
源码 :64 —（无 javadoc）

