# NewRegistryEvent

> `net.minecraftforge.registries.NewRegistryEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/NewRegistryEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Register new registries when you receive this event through RegistryBuilder and #create(RegistryBuilder).

## 公开成员（3 个）

```java
public NewRegistryEvent() {} /** * Adds a registry builder to be created. * * @param builder The builder to turn into a {@link IForgeRegistry} * @return A supplier of the {@link IForgeRegistry} created by the builder. Resolving too early will return null. */ public <V> Supplier<IForgeRegistry<V>> create(RegistryBuilder<V> builder)
```
源码 :30 —（无 javadoc）

```java
public <V> Supplier<IForgeRegistry<V>> create(RegistryBuilder<V> builder, @Nullable Consumer<IForgeRegistry<V>> onFill)
```
源码 :50 — Adds a registry builder to be created. @param builder The builder to turn into a IForgeRegistry @param onFill Called when the returned supplier is filled with the registry @return a supplier of the IForgeRegistry created by the builder. Resolving too early will return null.

```java
public String toString()
```
源码 :119 —（无 javadoc）

