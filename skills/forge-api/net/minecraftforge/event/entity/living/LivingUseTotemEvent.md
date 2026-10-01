# LivingUseTotemEvent

> `net.minecraftforge.event.entity.living.LivingUseTotemEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/LivingUseTotemEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired when an Entity attempts to use a totem to prevent its death. This event is Cancelable cancellable, and does not HasResult have a result. If this event is cancelled, the totem will not prevent the entity's death. This event is fired on the MinecraftForge#EVENT_BUS Forge event bus, only on the LogicalSide#SERVER logical server.

## 公开成员（4 个）

```java
public LivingUseTotemEvent(LivingEntity entity, DamageSource source, ItemStack totem, InteractionHand hand)
```
源码 :32 —（无 javadoc）

```java
public DamageSource getSource()
```
源码 :43 — the damage source that caused the entity to die

```java
public ItemStack getTotem()
```
源码 :51 — the totem of undying being used from the entity's inventory

```java
public InteractionHand getHandHolding()
```
源码 :59 — the hand holding the totem

