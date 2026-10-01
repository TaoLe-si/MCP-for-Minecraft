# RegistryBuilder

> `net.minecraftforge.registries.RegistryBuilder` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/RegistryBuilder.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（41 个）

```java
public static <T> RegistryBuilder<T> of()
```
源码 :24 —（无 javadoc）

```java
public static <T> RegistryBuilder<T> of(String name)
```
源码 :28 —（无 javadoc）

```java
public static <T> RegistryBuilder<T> of(ResourceLocation name)
```
源码 :32 —（无 javadoc）

```java
public RegistryBuilder<T> setName(ResourceLocation name)
```
源码 :57 —（无 javadoc）

```java
public RegistryBuilder<T> setIDRange(int min, int max)
```
源码 :63 —（无 javadoc）

```java
public RegistryBuilder<T> setMaxID(int max)
```
源码 :70 —（无 javadoc）

```java
public RegistryBuilder<T> setDefaultKey(ResourceLocation key)
```
源码 :75 —（无 javadoc）

```java
public RegistryBuilder<T> addCallback(Object inst)
```
源码 :82 —（无 javadoc）

```java
public RegistryBuilder<T> add(AddCallback<T> add)
```
源码 :99 —（无 javadoc）

```java
public RegistryBuilder<T> onAdd(AddCallback<T> add)
```
源码 :105 —（无 javadoc）

```java
public RegistryBuilder<T> add(ClearCallback<T> clear)
```
源码 :110 —（无 javadoc）

```java
public RegistryBuilder<T> onClear(ClearCallback<T> clear)
```
源码 :116 —（无 javadoc）

```java
public RegistryBuilder<T> add(CreateCallback<T> create)
```
源码 :121 —（无 javadoc）

```java
public RegistryBuilder<T> onCreate(CreateCallback<T> create)
```
源码 :127 —（无 javadoc）

```java
public RegistryBuilder<T> add(ValidateCallback<T> validate)
```
源码 :132 —（无 javadoc）

```java
public RegistryBuilder<T> onValidate(ValidateCallback<T> validate)
```
源码 :138 —（无 javadoc）

```java
public RegistryBuilder<T> add(BakeCallback<T> bake)
```
源码 :143 —（无 javadoc）

```java
public RegistryBuilder<T> onBake(BakeCallback<T> bake)
```
源码 :149 —（无 javadoc）

```java
public RegistryBuilder<T> set(MissingFactory<T> missing)
```
源码 :154 —（无 javadoc）

```java
public RegistryBuilder<T> missing(MissingFactory<T> missing)
```
源码 :160 —（无 javadoc）

```java
public RegistryBuilder<T> disableSaving()
```
源码 :165 —（无 javadoc）

```java
public RegistryBuilder<T> disableSync()
```
源码 :176 — Prevents the registry from being synced to clients. @return this

```java
public RegistryBuilder<T> disableOverrides()
```
源码 :182 —（无 javadoc）

```java
public RegistryBuilder<T> allowModification()
```
源码 :188 —（无 javadoc）

```java
public RegistryBuilder<T> legacyName(String name)
```
源码 :200 —（无 javadoc）

```java
public RegistryBuilder<T> legacyName(ResourceLocation name)
```
源码 :205 —（无 javadoc）

```java
public RegistryBuilder<T> hasTags()
```
源码 :224 — Enables tags for this registry if not already. All forge registries with wrappers inherently support tags. @return this builder @see RegistryBuilder#hasWrapper()

```java
public AddCallback<T> getAdd()
```
源码 :247 —（无 javadoc）

```java
public ClearCallback<T> getClear()
```
源码 :262 —（无 javadoc）

```java
public CreateCallback<T> getCreate()
```
源码 :277 —（无 javadoc）

```java
public ValidateCallback<T> getValidate()
```
源码 :292 —（无 javadoc）

```java
public BakeCallback<T> getBake()
```
源码 :307 —（无 javadoc）

```java
public ResourceLocation getDefault()
```
源码 :322 —（无 javadoc）

```java
public int getMinId()
```
源码 :327 —（无 javadoc）

```java
public int getMaxId()
```
源码 :332 —（无 javadoc）

```java
public boolean getAllowOverrides()
```
源码 :337 —（无 javadoc）

```java
public boolean getAllowModifications()
```
源码 :342 —（无 javadoc）

```java
public MissingFactory<T> getMissingFactory()
```
源码 :348 —（无 javadoc）

```java
public boolean getSaveToDisc()
```
源码 :353 —（无 javadoc）

```java
public boolean getSync()
```
源码 :358 —（无 javadoc）

```java
public Set<ResourceLocation> getLegacyNames()
```
源码 :363 —（无 javadoc）

