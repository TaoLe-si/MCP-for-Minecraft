# PlaySoundEvent

> `net.minecraftforge.client.event.sound.PlaySoundEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/sound/PlaySoundEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目用法**：抄声音流水（sounds op 的数据源）

**职责**（源码 javadoc）：Fired when a sound is about to be played by the sound engine. This fires before the sound is played and before any checks on the sound (such as a zeroed volume, an empty net.minecraft.client.resources.sounds.Sound, and others). This can be used to change or prevent (by passing `null)` a sound from being played through #setSound(SoundInstance)). This event is not Cancelable cancellable, and does no…

## 坑

- `event.getSound()` 非 null 不代表能用：`AbstractSoundInstance.getVolume()` 会解引用内部还没解析出来的 `Sound`，直接 NPE（`AbstractSoundInstance:75`）。读之前要能容忍失败。

## 公开成员（5 个）

```java
public PlaySoundEvent(SoundEngine manager, SoundInstance sound)
```
源码 :38 —（无 javadoc）

```java
public String getName()
```
源码 :49 — the name of the original sound This is equivalent to the path of the location of the original sound.

```java
public SoundInstance getOriginalSound()
```
源码 :57 — the original sound that was to be played

```java
public SoundInstance getSound()
```
源码 :66 —（无 javadoc）

```java
public void setSound(@Nullable SoundInstance newSound)
```
源码 :76 — Sets the sound to be played, which may be `null` to prevent any sound from being played. @param newSound the new sound to be played, or `null` for no sound

