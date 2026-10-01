# RuntimeEnumExtender

> `net.minecraftforge.fml.common.asm.RuntimeEnumExtender` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/common/asm/RuntimeEnumExtender.java` · `fmlloader-1.20.1-47.4.10`（fmlloader-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Modifies specified enums to allow runtime extension by making the $VALUES field non-final and injecting constructor calls which are not valid in normal java code.

## 公开成员（3 个）

```java
public String name()
```
源码 :45 —（无 javadoc）

```java
public EnumSet<Phase> handlesClass(Type classType, boolean isEmpty)
```
源码 :53 —（无 javadoc）

```java
public int processClassWithFlags(final Phase phase, final ClassNode classNode, final Type classType, final String reason)
```
源码 :65 —（无 javadoc）

