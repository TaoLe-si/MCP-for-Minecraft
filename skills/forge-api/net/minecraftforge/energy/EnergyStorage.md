# EnergyStorage

> `net.minecraftforge.energy.EnergyStorage` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/energy/EnergyStorage.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**（源码 javadoc）：Reference implementation of IEnergyStorage. Use/extend this or implement your own. Derived from the Redstone Flux power system designed by King Lemming and originally utilized in Thermal Expansion and related mods. Created with consent and permission of King Lemming and Team CoFH. Released with permission under LGPL 2.1 when bundled with Forge.

## 公开成员（16 个）

```java
protected int energy
```
源码 :20 —（无 javadoc）

```java
protected int capacity
```
源码 :21 —（无 javadoc）

```java
protected int maxReceive
```
源码 :22 —（无 javadoc）

```java
protected int maxExtract
```
源码 :23 —（无 javadoc）

```java
public EnergyStorage(int capacity)
```
源码 :25 —（无 javadoc）

```java
public EnergyStorage(int capacity, int maxTransfer)
```
源码 :30 —（无 javadoc）

```java
public EnergyStorage(int capacity, int maxReceive, int maxExtract)
```
源码 :35 —（无 javadoc）

```java
public EnergyStorage(int capacity, int maxReceive, int maxExtract, int energy)
```
源码 :40 —（无 javadoc）

```java
public int receiveEnergy(int maxReceive, boolean simulate)
```
源码 :49 —（无 javadoc）

```java
public int extractEnergy(int maxExtract, boolean simulate)
```
源码 :61 —（无 javadoc）

```java
public int getEnergyStored()
```
源码 :73 —（无 javadoc）

```java
public int getMaxEnergyStored()
```
源码 :79 —（无 javadoc）

```java
public boolean canExtract()
```
源码 :85 —（无 javadoc）

```java
public boolean canReceive()
```
源码 :91 —（无 javadoc）

```java
public Tag serializeNBT()
```
源码 :97 —（无 javadoc）

```java
public void deserializeNBT(Tag nbt)
```
源码 :103 —（无 javadoc）

