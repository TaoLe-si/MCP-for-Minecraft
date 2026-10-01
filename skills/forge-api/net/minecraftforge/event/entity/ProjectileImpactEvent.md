# ProjectileImpactEvent

> `net.minecraftforge.event.entity.ProjectileImpactEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/ProjectileImpactEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is fired on the MinecraftForge#EVENT_BUS. This event is fired when a projectile entity impacts something. This event is fired via ForgeEventFactory#onProjectileImpact(Projectile, This event is fired for all vanilla projectiles by Forge, custom projectiles should fire this event and check the result in a similar fashion. This event is cancelable. When canceled, the impact will not be pro…

## 公开成员（7 个）

```java
public ProjectileImpactEvent(Projectile projectile, HitResult ray)
```
源码 :36 —（无 javadoc）

```java
public void setCanceled(boolean cancel)
```
源码 :48 —（无 javadoc）

```java
public HitResult getRayTraceResult()
```
源码 :53 —（无 javadoc）

```java
public Projectile getProjectile()
```
源码 :58 —（无 javadoc）

```java
public void setImpactResult(@NotNull ImpactResult newResult)
```
源码 :63 —（无 javadoc）

```java
public ImpactResult getImpactResult()
```
源码 :68 —（无 javadoc）

```java
public enum ImpactResult
```
源码 :73 —（无 javadoc）

