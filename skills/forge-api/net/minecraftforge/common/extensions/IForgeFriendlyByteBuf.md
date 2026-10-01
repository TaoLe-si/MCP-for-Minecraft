# IForgeFriendlyByteBuf

> `net.minecraftforge.common.extensions.IForgeFriendlyByteBuf` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/extensions/IForgeFriendlyByteBuf.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Extension-Interface providing methods for writing registry-id's instead of their registry-names.

## 公开成员（9 个）

```java
private FriendlyByteBuf self()
```
源码 :24 —（无 javadoc）

```java
default <T> void writeRegistryIdUnsafe(@NotNull IForgeRegistry<T> registry, @NotNull T entry)
```
源码 :36 — Writes the given entries integer id to the buffer. Notice however that this will only write the id of the given entry and will not check whether it actually exists in the given registry. Therefore no safety checks can be performed whilst reading it and if the entry is not in the registry a default v…

```java
default void writeRegistryIdUnsafe(@NotNull IForgeRegistry<?> registry, @NotNull ResourceLocation entryKey)
```
源码 :49 — Writes the given entries integer id to the buffer. Notice however that this will only write the id of the given entry and will not check whether it actually exists in the given registry. Therefore no safety checks can be performed whilst reading it and if the entry is not in the registry a default v…

```java
default <T> T readRegistryIdUnsafe(@NotNull IForgeRegistry<T> registry)
```
源码 :61 — Reads an integer value from the buffer, which will be interpreted as an registry-id in the given registry. Notice that if there is no value in the specified registry for the read id, that the registry's default value will be returned. @param registry The registry containing the entry

```java
default <T> void writeRegistryId(@NotNull IForgeRegistry<T> registry, @NotNull T entry)
```
源码 :80 — Writes a given registry-entry's integer id to the specified buffer in combination with writing the containing registry's id. In contrast to #writeRegistryIdUnsafe(IForgeRegistry, this method checks every single step performed as well as writing the registry-id to the buffer, in order to prevent any…

```java
default <T> T readRegistryId()
```
源码 :97 — Reads an registry-entry from the specified buffer. Notice however that the type cannot be checked without providing an additional class parameter - see #readRegistryIdSafe(Class) for an safe version. @param The type of the registry-entry. Notice that this should match the actual type written to the…

```java
default <T> T readRegistryIdSafe(Class<? super T> registrySuperType)
```
源码 :110 — Reads an registry-entry from the specified buffer. This method also verifies, that the value read is of the appropriate type. @param The type of the registry-entry. @throws IllegalArgumentException if the retrieved entries registryType doesn't match the one passed in. @throws NullPointerException if…

```java
default void writeFluidStack(FluidStack stack)
```
源码 :124 — Writes a FluidStack to the packet buffer, easy enough. If EMPTY, writes a FALSE. This behavior provides parity with the ItemStack method in PacketBuffer. @param stack FluidStack to be written to the packet buffer.

```java
default FluidStack readFluidStack()
```
源码 :137 — Reads a FluidStack from this buffer.

