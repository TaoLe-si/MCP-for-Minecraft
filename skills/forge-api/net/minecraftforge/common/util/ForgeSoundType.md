# ForgeSoundType

> `net.minecraftforge.common.util.ForgeSoundType` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/util/ForgeSoundType.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：A subclass of SoundType that uses Suppliers. This class allows mod developers to safely create custom `SoundType`s for use in their e.g. Block. The problem with using `SoundType` directly is it requires SoundEvent instances directly, because `SoundType`s are required to be present during Block creation and registration. However, `SoundEvent` must also be registered. A possible solution of initiali…

## 公开成员（6 个）

```java
public ForgeSoundType(float volumeIn, float pitchIn, Supplier<SoundEvent> breakSoundIn, Supplier<SoundEvent> stepSoundIn, Supplier<SoundEvent> placeSoundIn, Supplier<SoundEvent> hitSoundIn, Supplier<SoundEvent> fallSoundIn)
```
源码 :44 —（无 javadoc）

```java
public SoundEvent getBreakSound()
```
源码 :56 —（无 javadoc）

```java
public SoundEvent getStepSound()
```
源码 :63 —（无 javadoc）

```java
public SoundEvent getPlaceSound()
```
源码 :70 —（无 javadoc）

```java
public SoundEvent getHitSound()
```
源码 :77 —（无 javadoc）

```java
public SoundEvent getFallSound()
```
源码 :84 —（无 javadoc）

