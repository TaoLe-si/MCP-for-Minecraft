# RenderTypeGroup

> `net.minecraftforge.client.RenderTypeGroup` · record · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/RenderTypeGroup.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：A set of functionally equivalent shaders. One using com.mojang.blaze3d.vertex.DefaultVertexFormat#BLOCK, and the other two using com.mojang.blaze3d.vertex.DefaultVertexFormat#NEW_ENTITY. `entityFabulous` may support custom render targets and other aspects of the fabulous pipeline, or can otherwise be the same as `entity`.

## 公开成员（4 个）

```java
public static RenderTypeGroup EMPTY = new RenderTypeGroup(null, null, null)
```
源码 :18 —（无 javadoc）

```java
public RenderTypeGroup
```
源码 :20 —（无 javadoc）

```java
public RenderTypeGroup(RenderType block, RenderType entity)
```
源码 :26 —（无 javadoc）

```java
public boolean isEmpty()
```
源码 :34 — true if this group has render types or not. It either has all, or none

