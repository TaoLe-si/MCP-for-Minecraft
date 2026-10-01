# ObjectHolderRegistry

> `net.minecraftforge.registries.ObjectHolderRegistry` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/registries/ObjectHolderRegistry.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Internal registry for tracking ObjectHolder references

## 公开成员（5 个）

```java
public static synchronized void addHandler(Consumer<Predicate<ResourceLocation>> ref)
```
源码 :44 — Exposed to allow modders to register their own notification handlers. This runnable will be called after a registry snapshot has been injected and finalized. The internal list is backed by a HashSet so it is HIGHLY recommended you implement a proper equals and hashCode function to de-duplicate calle…

```java
public static synchronized boolean removeHandler(Consumer<Predicate<ResourceLocation>> ref)
```
源码 :58 — Removed the specified handler from the notification list. The internal list is backed by a hash set, and so proper hashCode and equals operations are required for success. The default @ObjectHolder implementation uses the hashCode/equals for the field the annotation is on. @return true if handler wa…

```java
public static void findObjectHolders()
```
源码 :83 —（无 javadoc）

```java
public static void applyObjectHolders()
```
源码 :210 —（无 javadoc）

```java
public static void applyObjectHolders(Predicate<ResourceLocation> filter)
```
源码 :224 —（无 javadoc）

