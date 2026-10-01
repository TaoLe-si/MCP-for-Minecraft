# CapabilityToken

> `net.minecraftforge.common.capabilities.CapabilityToken` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/capabilities/CapabilityToken.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Inspired by com.google.common.reflect.TypeToken, use a subclass to capture generic types. Then uses CapabilityTokenSubclass to convert that generic into a string returned by #getType This allows us to know the generic type, without having a hard reference to the class. Example usage: `public static Capability DATA_HOLDER_CAPABILITY = CapabilityManager.get(new CapabilityToken<>(){`); }

## 公开成员（2 个）

```java
protected final String getType()
```
源码 :26 —（无 javadoc）

```java
public String toString()
```
源码 :32 —（无 javadoc）

