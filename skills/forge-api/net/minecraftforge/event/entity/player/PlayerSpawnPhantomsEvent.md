# PlayerSpawnPhantomsEvent

> `net.minecraftforge.event.entity.player.PlayerSpawnPhantomsEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/player/PlayerSpawnPhantomsEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is fired from PhantomSpawner#tick, once per player, when phantoms would attempt to be spawned. This event is not fired for spectating players. This event is fired before any per-player checks (but after Player#isSpectator()), but after all global checks. The behavior of PhantomSpawner is determined by the result of this event. See #setResult for documentation. This event is fired on the…

## 公开成员（4 个）

```java
public PlayerSpawnPhantomsEvent(Player player, int phantomsToSpawn)
```
源码 :32 —（无 javadoc）

```java
public int getPhantomsToSpawn()
```
源码 :41 — @return How many phantoms will be spawned, if spawning is successful. The default value is randomly generated.

```java
public void setPhantomsToSpawn(int phantomsToSpawn)
```
源码 :50 — Sets the number of phantoms to be spawned. @param phantomsToSpawn How many phantoms should spawn, given checks are passed.

```java
public void setResult(@NotNull Result result)
```
源码 :64 —（无 javadoc）

