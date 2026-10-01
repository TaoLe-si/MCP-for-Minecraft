# IEnergyStorage

> `net.minecraftforge.energy.IEnergyStorage` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/energy/IEnergyStorage.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**（源码 javadoc）：An energy storage is the unit of interaction with Energy inventories. A reference implementation can be found at EnergyStorage. Derived from the Redstone Flux power system designed by King Lemming and originally utilized in Thermal Expansion and related mods. Created with consent and permission of King Lemming and Team CoFH. Released with permission under LGPL 2.1 when bundled with Forge.

## 公开成员（6 个）

```java
int receiveEnergy(int maxReceive, boolean simulate)
```
源码 :31 — Adds energy to the storage. Returns quantity of energy that was accepted. @param maxReceive Maximum amount of energy to be inserted. @param simulate If TRUE, the insertion will only be simulated. @return Amount of energy that was (or would have been, if simulated) accepted by the storage.

```java
int extractEnergy(int maxExtract, boolean simulate)
```
源码 :42 — Removes energy from the storage. Returns quantity of energy that was removed. @param maxExtract Maximum amount of energy to be extracted. @param simulate If TRUE, the extraction will only be simulated. @return Amount of energy that was (or would have been, if simulated) extracted from the storage.

```java
int getEnergyStored()
```
源码 :47 — Returns the amount of energy currently stored.

```java
int getMaxEnergyStored()
```
源码 :52 — Returns the maximum amount of energy that can be stored.

```java
boolean canExtract()
```
源码 :58 — Returns if this storage can have energy extracted. If this is false, then any calls to extractEnergy will return 0.

```java
boolean canReceive()
```
源码 :64 — Used to determine if this storage can receive energy. If this is false, then any calls to receiveEnergy will return 0.

