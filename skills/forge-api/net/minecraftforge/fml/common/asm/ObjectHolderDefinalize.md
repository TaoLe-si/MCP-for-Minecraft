# ObjectHolderDefinalize

> `net.minecraftforge.fml.common.asm.ObjectHolderDefinalize` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/common/asm/ObjectHolderDefinalize.java` · `fmlloader-1.20.1-47.4.10`（fmlloader-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Removes the final modifier from fields with the @ObjectHolder annotation, prevents the JITer from in lining them so our runtime replacements can work. Will also de-finalize all fields in on class level annotations.

## 公开成员（3 个）

```java
public String name()
```
源码 :46 —（无 javadoc）

```java
public EnumSet<Phase> handlesClass(Type classType, boolean isEmpty)
```
源码 :54 —（无 javadoc）

```java
public int processClassWithFlags(final Phase phase, final ClassNode classNode, final Type classType, final String reason)
```
源码 :96 —（无 javadoc）

