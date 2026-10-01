# JsonCodecProvider

> `net.minecraftforge.common.data.JsonCodecProvider` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/data/JsonCodecProvider.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Dataprovider for using a Codec to generate jsons. Path names for jsons are derived from the given registry folder and each entry's namespaced id, in the format: `/entryid/registryfolder/entrypath.json ` @param the type of thing being generated.

## 公开成员（14 个）

```java
protected final PackOutput output
```
源码 :50 —（无 javadoc）

```java
protected final ExistingFileHelper existingFileHelper
```
源码 :51 —（无 javadoc）

```java
protected final String modid
```
源码 :52 —（无 javadoc）

```java
protected final DynamicOps<JsonElement> dynamicOps
```
源码 :53 —（无 javadoc）

```java
protected final PackType packType
```
源码 :54 —（无 javadoc）

```java
protected final String directory
```
源码 :55 —（无 javadoc）

```java
protected final Codec<T> codec
```
源码 :56 —（无 javadoc）

```java
protected final Map<ResourceLocation, T> entries
```
源码 :57 —（无 javadoc）

```java
protected Map<ResourceLocation, ICondition[]> conditions = Collections.emptyMap()
```
源码 :58 —（无 javadoc）

```java
public JsonCodecProvider(PackOutput output, ExistingFileHelper existingFileHelper, String modid, DynamicOps<JsonElement> dynamicOps, PackType packType, String directory, Codec<T> codec, Map<ResourceLocation, T> entries)
```
源码 :68 — @param output PackOutput provided by the DataGenerator. @param dynamicOps DynamicOps to encode values to jsons with using the provided Codec, e.g. JsonOps#INSTANCE. @param packType PackType specifying whether to generate entries in assets or data. @param directory String representing the directory t…

```java
public CompletableFuture<?> run(final CachedOutput cache)
```
源码 :88 —（无 javadoc）

```java
protected void gather(BiConsumer<ResourceLocation, T> consumer)
```
源码 :117 —（无 javadoc）

```java
public String getName()
```
源码 :123 —（无 javadoc）

```java
public JsonCodecProvider<T> setConditions(Map<ResourceLocation, ICondition[]> conditions)
```
源码 :134 — Applies a condition map to this provider. These conditions will be applied to the created JsonElements with the matching names. Null or empty arrays will not be written, and if the top-level json type is not JsonObject, attempting to add conditions will error. @param conditions The name->condition m…

