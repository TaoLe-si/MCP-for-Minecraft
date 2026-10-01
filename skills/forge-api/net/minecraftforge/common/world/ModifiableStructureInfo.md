# ModifiableStructureInfo

> `net.minecraftforge.common.world.ModifiableStructureInfo` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/world/ModifiableStructureInfo.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Holds lazy-evaluable modified structure info. Memoizers are not used because it's important to return null without evaluating the structure info if it's accessed outside of a server context.

## 公开成员（6 个）

```java
public ModifiableStructureInfo(@NotNull final StructureInfo originalStructureInfo)
```
源码 :32 — @param originalStructureInfo StructureInfo representing the original state of a structure when the structure was constructed.

```java
public StructureInfo get()
```
源码 :41 —（无 javadoc）

```java
public StructureInfo getOriginalStructureInfo()
```
源码 :52 —（无 javadoc）

```java
public StructureInfo getModifiedStructureInfo()
```
源码 :61 —（无 javadoc）

```java
public void applyStructureModifiers(final Holder<Structure> structure, final List<StructureModifier> structureModifiers)
```
源码 :75 —（无 javadoc）

```java
public record StructureInfo(StructureSettings structureSettings)
```
源码 :96 — Record containing raw structure data. @param structureSettings Structure settings.

