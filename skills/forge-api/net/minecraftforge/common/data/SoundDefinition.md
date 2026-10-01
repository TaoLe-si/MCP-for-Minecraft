# SoundDefinition

> `net.minecraftforge.common.data.SoundDefinition` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/data/SoundDefinition.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Contains all the data to completely define a sound event.

## 公开成员（7 个）

```java
public static final class Sound
```
源码 :41 — Identifies a specific sound that has to be played in a sound event, along with all the necessary parameters. If any of the optional parameters (i.e. the ones that aren't required to obtain an instance of this class) are unset, their default values will be used instead. The list of defaults is availa…

```java
public enum SoundType
```
源码 :294 — Represents the type of sound that the Sound object represents.

```java
public static SoundDefinition definition()
```
源码 :330 — Creates a new SoundDefinition, which will host a set of Sounds and the necessary parameters.

```java
public SoundDefinition replace(final boolean replace)
```
源码 :342 — Sets whether this definition should replace any other definition for the same sound event previously applied, rather than overwriting it. @param replace Whether this definition replaces or not. @return This definition for chaining.

```java
public SoundDefinition subtitle(@Nullable final String subtitle)
```
源码 :358 — Sets the language key for the subtitle that will be displayed whenever this sound is being played. The subtitle is optional and the game will skip displaying it if it isn't present. @param subtitle The subtitle to display, or null to disable. @return This definition for chaining.

```java
public SoundDefinition with(final Sound sound)
```
源码 :370 — Adds the given sound to this sound definition. @param sound The sound to add. @return This definition for chaining.

```java
public SoundDefinition with(final Sound... sounds)
```
源码 :382 — Adds the given sounds to this sound definition. @param sounds The sounds to add. @return This definition for chaining.

