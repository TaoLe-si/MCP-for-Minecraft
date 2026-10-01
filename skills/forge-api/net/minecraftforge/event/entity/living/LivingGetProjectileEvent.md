# LivingGetProjectileEvent

> `net.minecraftforge.event.entity.living.LivingGetProjectileEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/LivingGetProjectileEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is fired when a living entity attempts to get a projectile with the LivingEntity#getProjectile(ItemStack) method. The item stack given is usually the item stack of a net.minecraft.world.item.ProjectileWeaponItem and the item stack returned is usually the item stack of a net.minecraft.world.entity.projectile.Projectile. This event is not net.minecraftforge.eventbus.api.Cancelable. This e…

## 公开成员（4 个）

```java
public LivingGetProjectileEvent(LivingEntity livingEntity, ItemStack projectileWeaponItemStack, ItemStack ammo)
```
源码 :28 —（无 javadoc）

```java
public ItemStack getProjectileWeaponItemStack()
```
源码 :40 — @return The itemstack of the itrm that is looking for a projectile. With vanilla behavior, this usually returns an itemstack of a net.minecraft.world.item.ProjectileWeaponItem, but it's possible for that to not be the case if modder uses a different implementation of LivingEntity#getProjectile(ItemS…

```java
public ItemStack getProjectileItemStack()
```
源码 :50 — @return The itemstack of the projectile found. Initially this is set to the projectile found by vanilla behaviour, but it's possible for thatnot to be the case if a modder uses a different implementation of LivingEntity#getProjectile(ItemStack).

```java
public void setProjectileItemStack(ItemStack projectileItemStack)
```
源码 :66 — Sets the projectile itemstack to be used. If the entity is a player: whenever the projectile is fired/consumed the stack will be shrunk by one. To disable this behaviour you can copy the stack before giving it to the event. For bows, you can use net.minecraftforge.event.entity.player.ArrowLooseEvent…

