# FluidStack

> `net.minecraftforge.fluids.FluidStack` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fluids/FluidStack.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——能力/流体/能量/GameTest，本仓库不涉及

**职责**（源码 javadoc）：ItemStack substitute for Fluids. NOTE: Equality is based on the Fluid, not the amount. Use #isFluidStackIdentical(FluidStack) to determine if FluidID, Amount and NBT Tag are all equal.

## 公开成员（34 个）

```java
public static final FluidStack EMPTY = new FluidStack(Fluids.EMPTY, 0)
```
源码 :40 —（无 javadoc）

```java
public static final Codec<FluidStack> CODEC = RecordCodecBuilder.create( instance -> instan…
```
源码 :42 —（无 javadoc）

```java
public FluidStack(Fluid fluid, int amount)
```
源码 :59 —（无 javadoc）

```java
public FluidStack(Fluid fluid, int amount, CompoundTag nbt)
```
源码 :77 —（无 javadoc）

```java
public FluidStack(FluidStack stack, int amount)
```
源码 :87 —（无 javadoc）

```java
public static FluidStack loadFluidStackFromNBT(CompoundTag nbt)
```
源码 :96 — This provides a safe method for retrieving a FluidStack - if the Fluid is invalid, the stack will return as null.

```java
public CompoundTag writeToNBT(CompoundTag nbt)
```
源码 :122 —（无 javadoc）

```java
public void writeToPacket(FriendlyByteBuf buf)
```
源码 :134 —（无 javadoc）

```java
public static FluidStack readFromPacket(FriendlyByteBuf buf)
```
源码 :141 —（无 javadoc）

```java
public final Fluid getFluid()
```
源码 :150 —（无 javadoc）

```java
public final Fluid getRawFluid()
```
源码 :155 —（无 javadoc）

```java
public boolean isEmpty()
```
源码 :160 —（无 javadoc）

```java
protected void updateEmpty()
```
源码 :164 —（无 javadoc）

```java
public int getAmount()
```
源码 :168 —（无 javadoc）

```java
public void setAmount(int amount)
```
源码 :173 —（无 javadoc）

```java
public void grow(int amount)
```
源码 :180 —（无 javadoc）

```java
public void shrink(int amount)
```
源码 :184 —（无 javadoc）

```java
public boolean hasTag()
```
源码 :188 —（无 javadoc）

```java
public CompoundTag getTag()
```
源码 :193 —（无 javadoc）

```java
public void setTag(CompoundTag tag)
```
源码 :198 —（无 javadoc）

```java
public CompoundTag getOrCreateTag()
```
源码 :204 —（无 javadoc）

```java
public CompoundTag getChildTag(String childName)
```
源码 :211 —（无 javadoc）

```java
public CompoundTag getOrCreateChildTag(String childName)
```
源码 :218 —（无 javadoc）

```java
public void removeChildTag(String childName)
```
源码 :229 —（无 javadoc）

```java
public Component getDisplayName()
```
源码 :235 —（无 javadoc）

```java
public String getTranslationKey()
```
源码 :240 —（无 javadoc）

```java
public FluidStack copy()
```
源码 :248 — @return A copy of this FluidStack

```java
public boolean isFluidEqual(@NotNull FluidStack other)
```
源码 :260 — Determines if the FluidIDs and NBT Tags are equal. This does not check amounts. @param other The FluidStack for comparison @return true if the Fluids (IDs and NBT Tags) are the same

```java
public static boolean areFluidStackTagsEqual(@NotNull FluidStack stack1, @NotNull FluidStack stack2)
```
源码 :273 — Determines if the NBT Tags are equal. Useful if the FluidIDs are known to be equal.

```java
public boolean containsFluid(@NotNull FluidStack other)
```
源码 :283 — Determines if the Fluids are equal and this stack is larger. @return true if this FluidStack contains the other FluidStack (same fluid and >= amount)

```java
public boolean isFluidStackIdentical(FluidStack other)
```
源码 :295 — Determines if the FluidIDs, Amounts, and NBT Tags are all equal. @param other - the FluidStack for comparison @return true if the two FluidStacks are exactly the same

```java
public boolean isFluidEqual(@NotNull ItemStack other)
```
源码 :308 — Determines if the FluidIDs and NBT Tags are equal compared to a registered container ItemStack. This does not check amounts. @param other The ItemStack for comparison @return true if the Fluids (IDs and NBT Tags) are the same

```java
public final int hashCode()
```
源码 :314 —（无 javadoc）

```java
public final boolean equals(Object o)
```
源码 :329 —（无 javadoc）

