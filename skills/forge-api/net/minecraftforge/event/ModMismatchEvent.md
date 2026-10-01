# ModMismatchEvent

> `net.minecraftforge.event.ModMismatchEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/ModMismatchEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fires when the mod loader is in the process of loading a world that was last saved with mod versions that differ from the currently-loaded versions. This can be used to enqueue work to run at a later point, such as multi-file migration of data. Note that level and world information has not yet been fully loaded; as such, it is unsafe to access server or level information during handling of this ev…

## 公开成员（14 个）

```java
public ModMismatchEvent(LevelStorageSource.LevelDirectory levelDirectory, Map<String, ArtifactVersion> previousVersions, Map<String, ArtifactVersion> missingVersions)
```
源码 :61 —（无 javadoc）

```java
public LevelStorageSource.LevelDirectory getLevelDirectory()
```
源码 :79 — Gets the current level directory for the world being loaded. Can be used for file operations and manual modification of mod files before world load.

```java
public ArtifactVersion getPreviousVersion(String modId)
```
源码 :90 —（无 javadoc）

```java
public ArtifactVersion getCurrentVersion(String modid)
```
源码 :99 —（无 javadoc）

```java
public void markResolved(String modId)
```
源码 :110 — Marks the mod version mismatch as having been resolved safely by the current mod.

```java
public boolean wasResolved(String modId)
```
源码 :119 — Fetches the status of a mod mismatch handling state.

```java
public Optional<MismatchedVersionInfo> getVersionDifference(String modid)
```
源码 :124 —（无 javadoc）

```java
public Optional<ModContainer> getResolver(String modid)
```
源码 :129 —（无 javadoc）

```java
public boolean anyUnresolved()
```
源码 :134 —（无 javadoc）

```java
public Stream<MismatchResolutionResult> getUnresolved()
```
源码 :139 —（无 javadoc）

```java
public boolean anyResolved()
```
源码 :147 —（无 javadoc）

```java
public Stream<MismatchResolutionResult> getResolved()
```
源码 :152 —（无 javadoc）

```java
public record MismatchResolutionResult(String modid, MismatchedVersionInfo versionDifference, @Nullable ModContainer resolver)
```
源码 :159 —（无 javadoc）

```java
public record MismatchedVersionInfo(ArtifactVersion oldVersion, @Nullable ArtifactVersion newVersion)
```
源码 :167 —（无 javadoc）

