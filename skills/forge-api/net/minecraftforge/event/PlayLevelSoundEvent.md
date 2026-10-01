# PlayLevelSoundEvent

> `net.minecraftforge.event.PlayLevelSoundEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/PlayLevelSoundEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：PlayLevelSoundEvent is fired when a sound is played on a Level. This event is fired from Level#playSound, Level#playSeededSound, and LocalPlayer#playSound. #getLevel() contains the level the sound is being played in. #getSound() contains the sound event to be played. #getOriginalVolume() contains the original volume for the sound to be played at. #getOriginalPitch() contains the original pitch for…

## 公开成员（14 个）

```java
public PlayLevelSoundEvent(@NotNull Level level, @NotNull Holder<SoundEvent> sound, @NotNull SoundSource source, float volume, float pitch)
```
源码 :51 —（无 javadoc）

```java
public Level getLevel()
```
源码 :66 —（无 javadoc）

```java
public Holder<SoundEvent> getSound()
```
源码 :75 —（无 javadoc）

```java
public void setSound(@Nullable Holder<SoundEvent> sound)
```
源码 :83 — Sets the sound event to be played.

```java
public SoundSource getSource()
```
源码 :92 —（无 javadoc）

```java
public void setSource(@NotNull SoundSource source)
```
源码 :100 — Sets the sound source.

```java
public float getOriginalVolume()
```
源码 :109 — the original volume for the sound to be played at

```java
public float getOriginalPitch()
```
源码 :117 — the original pitch for the sound to be played at

```java
public float getNewVolume()
```
源码 :125 — the volume the sound will be played at

```java
public void setNewVolume(float newVolume)
```
源码 :133 — Sets the volume the sound will be played at.

```java
public float getNewPitch()
```
源码 :141 — the pitch the sound will be played at

```java
public void setNewPitch(float newPitch)
```
源码 :149 — Sets the pitch the sound will be played at.

```java
public static class AtEntity extends PlayLevelSoundEvent
```
源码 :165 — PlayLevelSoundEvent.AtEntity is fired when a sound is played on the Level at an Entity's position. This event is fired from Level#playSound, Level#playSeededSound, and LocalPlayer#playSound. This event is Cancelable. If this event is canceled, the sound is not played. This event does not have a resu…

```java
public static class AtPosition extends PlayLevelSoundEvent
```
源码 :195 — PlayLevelSoundEvent.AtPosition is fired when a sound is played on the Level at a specific position. This event is fired from Level#playSound and Level#playSeededSound. This event is Cancelable. If this event is canceled, the sound is not played. This event does not have a result. This event is fired…

