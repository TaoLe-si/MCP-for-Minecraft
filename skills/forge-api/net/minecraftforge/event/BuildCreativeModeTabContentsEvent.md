# BuildCreativeModeTabContentsEvent

> `net.minecraftforge.event.BuildCreativeModeTabContentsEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/BuildCreativeModeTabContentsEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired when the contents of a specific creative mode tab are being populated. This event may be fired multiple times if the operator status of the local player or enabled feature flags changes. This event is not Cancelable cancellable, and does not HasResult have a result. This event is fired on the FMLJavaModLoadingContext#getModEventBus() mod-specific event bus, only on the LogicalSide#CLIENT log…

## 公开成员（10 个）

```java
public BuildCreativeModeTabContentsEvent(CreativeModeTab tab, ResourceKey<CreativeModeTab> tabKey, CreativeModeTab.ItemDisplayParameters parameters, MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> entries)
```
源码 :39 —（无 javadoc）

```java
public CreativeModeTab getTab()
```
源码 :49 — the creative mode tab currently populating its contents

```java
public ResourceKey<CreativeModeTab> getTabKey()
```
源码 :56 — the key of the creative mode tab currently populating its contents

```java
public FeatureFlagSet getFlags()
```
源码 :60 —（无 javadoc）

```java
public CreativeModeTab.ItemDisplayParameters getParameters()
```
源码 :64 —（无 javadoc）

```java
public boolean hasPermissions()
```
源码 :68 —（无 javadoc）

```java
public MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> getEntries()
```
源码 :72 —（无 javadoc）

```java
public void accept(ItemStack stack, CreativeModeTab.TabVisibility visibility)
```
源码 :77 —（无 javadoc）

```java
public void accept(Supplier<? extends ItemLike> item, CreativeModeTab.TabVisibility visibility)
```
源码 :81 —（无 javadoc）

```java
public void accept(Supplier<? extends ItemLike> item)
```
源码 :85 —（无 javadoc）

