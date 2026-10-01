# ForgeFlowingFluid

> `net.minecraftforge.fluids.ForgeFlowingFluid` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fluids/ForgeFlowingFluid.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（19 个）

```java
protected ForgeFlowingFluid(Properties properties)
```
源码 :47 —（无 javadoc）

```java
public FluidType getFluidType()
```
源码 :61 —（无 javadoc）

```java
public Fluid getFlowing()
```
源码 :67 —（无 javadoc）

```java
public Fluid getSource()
```
源码 :73 —（无 javadoc）

```java
protected boolean canConvertToSource(Level level)
```
源码 :79 —（无 javadoc）

```java
public boolean canConvertToSource(FluidState state, Level level, BlockPos pos)
```
源码 :85 —（无 javadoc）

```java
protected void beforeDestroyingBlock(LevelAccessor worldIn, BlockPos pos, BlockState state)
```
源码 :91 —（无 javadoc）

```java
protected int getSlopeFindDistance(LevelReader worldIn)
```
源码 :98 —（无 javadoc）

```java
protected int getDropOff(LevelReader worldIn)
```
源码 :104 —（无 javadoc）

```java
public Item getBucket()
```
源码 :110 —（无 javadoc）

```java
protected boolean canBeReplacedWith(FluidState state, BlockGetter level, BlockPos pos, Fluid fluidIn, Direction direction)
```
源码 :116 —（无 javadoc）

```java
public int getTickDelay(LevelReader level)
```
源码 :123 —（无 javadoc）

```java
protected float getExplosionResistance()
```
源码 :129 —（无 javadoc）

```java
protected BlockState createLegacyBlock(FluidState state)
```
源码 :135 —（无 javadoc）

```java
public boolean isSame(Fluid fluidIn)
```
源码 :143 —（无 javadoc）

```java
public Optional<SoundEvent> getPickupSound()
```
源码 :149 —（无 javadoc）

```java
public static class Flowing extends ForgeFlowingFluid
```
源码 :154 —（无 javadoc）

```java
public static class Source extends ForgeFlowingFluid
```
源码 :176 —（无 javadoc）

```java
public static class Properties
```
源码 :192 —（无 javadoc）

