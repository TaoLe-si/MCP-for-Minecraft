# NoteBlockEvent

> `net.minecraftforge.event.level.NoteBlockEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/level/NoteBlockEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Base class for Noteblock Events

## 公开成员（9 个）

```java
protected NoteBlockEvent(Level world, BlockPos pos, BlockState state, int note)
```
源码 :24 —（无 javadoc）

```java
public Note getNote()
```
源码 :34 — Get the Note the Noteblock is tuned to @return the Note

```java
public Octave getOctave()
```
源码 :43 — Get the Octave of the note this Noteblock is tuned to @return the Octave

```java
public int getVanillaNoteId()
```
源码 :52 — get the vanilla note-id, which contains information about both Note and Octave. Most modders should not need this. @return an ID for the note

```java
public void setNote(Note note, Octave octave)
```
源码 :63 — Set Note and Octave for this event. If octave is Octave.HIGH, note may only be Note.F_SHARP @param note the Note @param octave the Octave

```java
public static class Play extends NoteBlockEvent
```
源码 :74 —（无 javadoc）

```java
public static class Change extends NoteBlockEvent
```
源码 :100 —（无 javadoc）

```java
public static enum Note
```
源码 :128 — Information about the pitch of a Noteblock note. For altered notes such as G-Sharp / A-Flat the Sharp variant is used here.

```java
public static enum Octave
```
源码 :156 — Describes the Octave of a Note being played by a Noteblock. Together with Note it fully describes the note.

