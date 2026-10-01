# EmptyEnergyStorage

> `net.minecraftforge.energy.EmptyEnergyStorage` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/energy/EmptyEnergyStorage.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**（源码 javadoc）：Implementation of IEnergyStorage that cannot store, receive, or provide energy. Use the #INSTANCE, don't instantiate. Example: `ItemStack stack = ...; IEnergyStorage storage = stack.getCapability(ForgeCapabilities.ENERGY).orElse(EmptyEnergyStorage.INSTANCE); // Use storage without checking whether it's present. `

## 公开成员（7 个）

```java
public static final EmptyEnergyStorage INSTANCE = new EmptyEnergyStorage()
```
源码 :19 —（无 javadoc）

```java
protected EmptyEnergyStorage() {} @Override public int receiveEnergy(int maxReceive, boolean simulate)
```
源码 :21 —（无 javadoc）

```java
public int extractEnergy(int maxExtract, boolean simulate)
```
源码 :30 —（无 javadoc）

```java
public int getEnergyStored()
```
源码 :36 —（无 javadoc）

```java
public int getMaxEnergyStored()
```
源码 :42 —（无 javadoc）

```java
public boolean canExtract()
```
源码 :48 —（无 javadoc）

```java
public boolean canReceive()
```
源码 :54 —（无 javadoc）

