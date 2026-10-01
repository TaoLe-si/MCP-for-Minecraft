# CapabilityTokenSubclass

> `net.minecraftforge.fml.common.asm.CapabilityTokenSubclass` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/common/asm/CapabilityTokenSubclass.java` · `fmlloader-1.20.1-47.4.10`（fmlloader-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Implements getType() in CapabilityToken subclasses. Using the class's signature to determine the generic type of TypeToken, and then implements getType() using that value. Example: new CapabilityToken&lt;String>(){} Has the signature "CapabilityToken&lt;Ljava/lang/String;>" Implements the method: public String getType() { return "java/lang/String"; }

## 公开成员（3 个）

```java
public String name()
```
源码 :44 —（无 javadoc）

```java
public EnumSet<Phase> handlesClass(Type classType, boolean isEmpty)
```
源码 :52 —（无 javadoc）

```java
public int processClassWithFlags(final Phase phase, final ClassNode classNode, final Type classType, final String reason)
```
源码 :65 —（无 javadoc）

