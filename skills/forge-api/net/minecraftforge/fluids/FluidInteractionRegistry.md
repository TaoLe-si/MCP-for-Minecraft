# FluidInteractionRegistry

> `net.minecraftforge.fluids.FluidInteractionRegistry` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fluids/FluidInteractionRegistry.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**（源码 javadoc）：A registry which defines the interactions a source fluid can have with its surroundings. Each possible flow direction is checked for all interactions with the source. Fluid interactions mimic the behavior of `LiquidBlock#shouldSpreadLiquid`. As such, all directions, besides Direction#DOWN is tested and then replaced. Any fluids which cause a change in the down interaction must be handled in `Flowi…

## 公开成员（5 个）

```java
public static synchronized void addInteraction(FluidType source, InteractionInformation interaction)
```
源码 :45 — Adds an interaction between a source and its surroundings. @param source the source of the interaction, this will be replaced if the interaction occurs @param interaction the interaction data to check and perform

```java
public static boolean canInteract(Level level, BlockPos pos)
```
源码 :59 — Performs all potential fluid interactions at a given position. Note: Only the first interaction check that succeeds will occur. @param level the level the interactions take place in @param pos the position of the source fluid @return `true` if an interaction took place, `false` otherwise

```java
public record InteractionInformation(HasFluidInteraction predicate, FluidInteraction interaction)
```
源码 :101 — Holds the interaction data for a given source type on when to succeed and what to perform. @param predicate a test to see whether an interaction can occur @param interaction the interaction to perform

```java
public interface HasFluidInteraction
```
源码 :159 —（无 javadoc）

```java
public interface FluidInteraction
```
源码 :177 —（无 javadoc）

